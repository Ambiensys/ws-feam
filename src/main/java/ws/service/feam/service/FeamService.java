package ws.service.feam.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import ws.service.feam.dao.FeamConectaBanco;
import ws.service.feam.exception.FeamException;
import ws.service.feam.exception.geral.ErroServicoRemotoException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.login.FeamLogin;
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

    public FeamLoginRespostaWS gettoken(FeamLogin feamLogin) throws FeamException, IOException, SQLException {
        try {
            Logger log = logArquivo.start();
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

    public byte[] buscaPdfManifestoPorCodigoBarras(String token, String chave, String codigoBarra)  throws FeamException{
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
}
