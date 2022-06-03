package ws.service.feam.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import ws.service.feam.dao.FeamConectaBanco;
import ws.service.feam.exception.FeamException;
import ws.service.feam.exception.geral.ErroInternoException;
import ws.service.feam.exception.geral.ErroServicoRemotoException;
import ws.service.feam.modelo.configuracao.FeamIpResposta;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.login.FeamAutenticacaoResposta;
import ws.service.feam.modelo.login.FeamLogin;
import ws.service.feam.modelo.login.FeamLoginCdCliente;
import ws.service.feam.modelo.login.FeamLoginRespostaWS;
import ws.service.feam.modelo.manifesto.FeamCancelarMTR;
import ws.service.feam.modelo.manifesto.FeamCancelarMTRResposta;
import ws.service.feam.modelo.unidade.FeamUsuarioUnidade;
import ws.service.feam.util.FeamLogArquivo;

@ApplicationScoped
public class FeamService {

    FeamLogArquivo logArquivo = new FeamLogArquivo(FeamService.class.getName());

    @Inject
    @RestClient
    FeamRestClientService service;

    public FeamResposta salvarManifestoLote(String token, String chave, FeamGerador gerador) throws FeamException {
        try {
            token = "Bearer " + token;
            return service.salvarManifestoLote(token, chave, gerador);
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (ProcessingException | WebApplicationException e) {
            e.printStackTrace();
            throw new ErroServicoRemotoException(e, service);
        }

    }

    void cadastraIpFeam(FeamLogin feamLogin) throws IOException, SQLException, FeamException {
        Logger log = logArquivo.start();
        FeamAutenticacaoResposta feamAutenticacaoResposta = this.autenticacao(feamLogin);
        
        // Cadastra IP Principal Horizons
        FeamIpResposta retornoFeamIP1 = service.salvarIP(feamLogin.getPessoaCodigo().toString(), "187.95.144.250",
                "IP Principal Horizons", feamAutenticacaoResposta.getCookie());

        // Cadastra IP Contingencia Copel
        FeamIpResposta retornoFeamIP2 = service.salvarIP(feamLogin.getPessoaCodigo().toString(), "200.150.87.27",
                "IP Contingencia Copel", feamAutenticacaoResposta.getCookie());

        // Cadastra IP Contingencia Copel
        FeamIpResposta retornoFeamIP3 = service.salvarIP(feamLogin.getPessoaCodigo().toString(), "168.0.134.202",
                "IP Robo Ambiensys", feamAutenticacaoResposta.getCookie());

   
        String sql = "";

        sql += " UPDATE clientes_sistemas " +
                "    SET in_ip_cadastrado = 'S' " +
                "  WHERE id_sistema = 'FEAM' " +
                "    AND cd_cliente = (SELECT cd_cliente " +
                "                        FROM clientes " +
                "                       WHERE nr_cpf_cnpj = '" + feamLogin.getPessoaCnpj().trim() + "')";

        try {
            FeamConectaBanco conectaFeam = new FeamConectaBanco();
            conectaFeam.conexao();
            PreparedStatement pstFeam;
            pstFeam = conectaFeam.conn.prepareStatement(sql);
            pstFeam.executeUpdate();
            conectaFeam.desconecta();
        } catch (SQLException ex) {
            log.info("Erro ao salvar IP! " + ex);
        }

    }

    public FeamAutenticacaoResposta autenticacao(FeamLogin feamLogin) throws FeamException, IOException, SQLException {

        Logger log = logArquivo.start();
        // Recupera Cookie do cliente e efetua logoff
        FeamAutenticacaoResposta feamAutenticacaoResposta = new FeamAutenticacaoResposta();
        FeamConectaBanco conecta = new FeamConectaBanco();
        try {

            conecta.conexao();
            String sql = "SELECT id_token " +
                    "  FROM clientes_sistemas " +
                    " WHERE id_sistema  = 'FEAM' " +
                    "   AND cd_cliente = (SELECT cd_cliente " +
                    "                       FROM clientes " +
                    "                      WHERE nr_cpf_cnpj = '" + feamLogin.getPessoaCnpj().trim() + "')";
            conecta.executaSQL(sql);
            conecta.rs.first();
            String cookie = conecta.rs.getString("id_token");

            if (logoffUsuario(cookie) == 200) {
                log.info("autenticacao - Efetuou logoff do Cookie.");
            } else {
                log.info("autenticacao - Nao conseguiu efetuar logoff do Cookie. Continuando processamento.");
            }
        } catch (SQLException ex) {
            log.info("autenticacao - Nao conseguiu recuperar o Cookie. Continuando processamento.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            // Recupera informacoes da unidade do Gerador
            if (feamLogin.getPessoaCodigo() == null || feamLogin.getPessoaCodigo() <= 0) {
                log.info("Recuperando a unidade...");

                FeamControlePesquisaUsuarioUnidades feamUnidades = new FeamControlePesquisaUsuarioUnidades();
                List<FeamUsuarioUnidade> feamUsuarioUnidade = feamUnidades
                        .pesquisaUsuarioUnidades(feamLogin.getPessoaCnpj());
                for (int i = 0; i < feamUsuarioUnidade.size(); i++) {
                    feamLogin.setPessoaCodigo(Integer.parseInt(feamUsuarioUnidade.get(i).getCodigo()));

                    feamAutenticacaoResposta = this.getAutenticacao("autenticaUsuario",
                            feamLogin.getPessoaCnpj().trim(),
                            feamLogin.getSenha().trim(),
                            feamLogin.getPessoaCodigo().toString().trim(),
                            feamLogin.getUsuarioCpf().trim(),
                            "J");

                    if (feamAutenticacaoResposta.getSucesso().toUpperCase().equals("S")) {
                        // Logou com sucesso! Atualiza unidade na base de dados.
                        String sql = "EXEC dbo.sp_cadastro_cliente_alterar_unidade '" +
                                feamLogin.getPessoaCnpj().trim() + "', NULL , NULL, NULL, NULL, '" +
                                feamLogin.getPessoaCodigo().toString() + "', NULL, NULL, 'admin'";

                        try {
                            PreparedStatement pst;
                            pst = conecta.conn.prepareStatement(sql);
                            pst.executeUpdate();
                        } catch (SQLException ex) {
                            log.info("Erro ao alterar unidade do cliente! " + ex);
                            continue;
                        }

                        break;
                    }
                }
                conecta.desconecta();
            } else {
                feamAutenticacaoResposta = this.getAutenticacao("autenticaUsuario",
                        feamLogin.getPessoaCnpj().trim(),
                        feamLogin.getSenha().trim(),
                        feamLogin.getPessoaCodigo().toString().trim(),
                        feamLogin.getUsuarioCpf().trim(),
                        "J");
            }

            return feamAutenticacaoResposta;
        } catch (IOException | SQLException ex) {
            log.info("Erro ao alterar unidade do cliente! " + ex);
            return null;
        }
    }

    public FeamAutenticacaoResposta getAutenticacao(String acao,
            String txtCnpj,
            String txtSenha,
            String txtUnidadeCodigo,
            String txtCpfUsuario,
            String tipoPessoaSociedade) throws FeamException {

        FeamAutenticacaoResposta resposta = new FeamAutenticacaoResposta();

        Response response = service.getAutenticacao(acao,
                txtCnpj,
                txtSenha,
                txtUnidadeCodigo,
                txtCpfUsuario,
                tipoPessoaSociedade);
        Jsonb jsonb = JsonbBuilder.create();
        resposta = jsonb.fromJson(response.readEntity(String.class), FeamAutenticacaoResposta.class);

        String headersCookie = response.getHeaderString("Set-Cookie");

        
        if (headersCookie != null && !headersCookie.trim().isEmpty()) {
            List<String> Cookielist = Arrays.asList(headersCookie.split(","));

            
            String jsessionid = (Cookielist.get(0));
            String servidor = (Cookielist.get(1));
            String cookie = servidor + jsessionid;

            resposta.setCookie(cookie.replaceAll(" path=/", ""));

            // Grava o Cookie no banco de dados

            if (resposta.getCookie() != null && !resposta.getCookie().trim().isEmpty()) {
                // Cookie na base
                String sqlToken = " UPDATE clientes_sistemas " +
                        "    SET dt_geracao_token     = sysdatetime(), " +
                        "        id_token             = '" + resposta.getCookie().trim() + "'" +
                        "  WHERE id_sistema = 'FEAM' " +
                        "    AND cd_cliente = (SELECT cd_cliente " +
                        "                        FROM clientes " +
                        "                       WHERE nr_cpf_cnpj = '" + txtCnpj + "')";

                try {
                    FeamConectaBanco conecta = new FeamConectaBanco();
                    conecta.conexao();
                    PreparedStatement pstToken;
                    pstToken = conecta.conn.prepareStatement(sqlToken);
                    pstToken.executeUpdate();
                    conecta.desconecta();
                } catch (SQLException | IOException ex) {
                    System.out.println("getAutenticacao - Erro ao gravar cookie : " + ex);
                }
            }
        }
        return resposta;
    }

    public Integer logoffUsuario(String cookie) throws IOException, SQLException {

        Integer retorno;

        try {
            if (cookie.isEmpty()) {
                return 200;
            }
            try {
                retorno = service.logoffUsuario(cookie);
            } catch (Exception e) {
                return 200;
            }

            return retorno;

        } catch (NullPointerException ex) {
            return 200;
        }
    }

    public FeamCancelarMTRResposta cancelarMTR(String token, String chave, FeamCancelarMTR feamCancelarMTR)
            throws FeamException {
        try {
            token = "Bearer " + token;
            return service.cancelarMTR(token, chave, feamCancelarMTR);
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (ProcessingException | WebApplicationException e) {
            e.printStackTrace();
            throw new ErroServicoRemotoException(e, service);
        }
    }

    public FeamLoginRespostaWS gettoken(FeamLoginCdCliente login)
            throws FeamException, IOException, SQLException {
        try {
            Logger log = logArquivo.start();
            FeamLogin feamLogin = login.getFeamLogin();
            try {
                
                // Declare variaveis de login
                FeamConectaBanco conecta = new FeamConectaBanco();

                String consultaMTR = "select in_ip_cadastrado from clientes_sistemas where id_sistema='FEAM' and cd_cliente= " + login.getCdCliente();

                conecta.conexao();
                conecta.executaSQL(consultaMTR);

                // Valida se nao e um RS vazio
                conecta.rs.first();
                if (!conecta.rs.first()) {
                    conecta.desconecta();
                    return null;
                }

                // Posiciona cursor no inicio e retoma loop
                conecta.rs.beforeFirst();
                while (conecta.rs.next()) {
                    
                    if (conecta.rs.getString("in_ip_cadastrado") == null || !conecta.rs.getString("in_ip_cadastrado").equals("S")) {
                        log.info("emitirMTRFeam - Vai cadastrar os IP's");
                        cadastraIpFeam(feamLogin);
                    }
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new ErroInternoException(e, e.getMessage());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new ErroInternoException(e, e.getMessage());
            }

            FeamLoginRespostaWS feamLoginRespostaWS = new FeamLoginRespostaWS();
           
            // Recupera informacoes da unidade do Gerador
            if (feamLogin.getPessoaCodigo() == null || feamLogin.getPessoaCodigo() <= 0) {
                log.info("Recuperando a unidade...");
                FeamConectaBanco conecta = new FeamConectaBanco();
                conecta.conexao();

                FeamControlePesquisaUsuarioUnidades feamUnidades = new FeamControlePesquisaUsuarioUnidades();
                List<FeamUsuarioUnidade> feamUsuarioUnidade = feamUnidades
                        .pesquisaUsuarioUnidades(feamLogin.getPessoaCnpj());
                for (int i = 0; i < feamUsuarioUnidade.size(); i++) {
                    feamLogin.setPessoaCodigo(Integer.parseInt(feamUsuarioUnidade.get(i).getCodigo()));

                    feamLoginRespostaWS = service.gettoken(feamLogin);

                    if (feamLoginRespostaWS.getRetornoCodigo() == 0) {
                        // Logou com sucesso! Atualiza unidade na base de dados.
                        String sql = "EXEC dbo.sp_cadastro_cliente_alterar_unidade '" +
                                feamLogin.getPessoaCnpj().trim() + "', NULL , NULL, NULL, NULL, '" +
                                feamLogin.getPessoaCodigo().toString() + "', NULL, NULL, 'admin'";

                        try {
                            PreparedStatement pst;
                            pst = conecta.conn.prepareStatement(sql);
                            pst.executeUpdate();
                        } catch (SQLException ex) {
                            log.info("Erro ao alterar unidade do cliente! " + ex);
                            continue;
                        }

                        break;
                    }
                }
                conecta.desconecta();
            } else {
                feamLoginRespostaWS = service.gettoken(feamLogin);
            }

            return feamLoginRespostaWS;
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (ProcessingException | WebApplicationException e) {
            e.printStackTrace();
            throw new ErroServicoRemotoException(e, service);
        }
    }

    public byte[] buscaPdfManifestoPorCodigoBarras(String token, String chave, String codigoBarra)
            throws FeamException {
        try {
            token = "Bearer " + token;
            return service.buscaPdfManifestoPorCodigoBarras(token, chave, codigoBarra);
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (ProcessingException | WebApplicationException e) {
            e.printStackTrace();
            throw new ErroServicoRemotoException(e, service);
        }
    }

    public byte[] downloadCdf(String token, String chave, String nmCdf)
            throws FeamException {
        try {
            token = "Bearer " + token;
            return service.downloadCdf(token, chave, nmCdf);
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (ProcessingException | WebApplicationException e) {
            e.printStackTrace();
            throw new ErroServicoRemotoException(e, service);
        }
    }
}
