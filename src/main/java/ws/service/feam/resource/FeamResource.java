package ws.service.feam.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;

import ws.service.feam.exception.FeamException;
import ws.service.feam.exception.geral.ErroInternoException;
import ws.service.feam.exception.geral.NotFoundException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.login.FeamLoginCdCliente;
import ws.service.feam.modelo.login.FeamLoginRespostaWS;
import ws.service.feam.modelo.manifesto.FeamCancelarMTR;
import ws.service.feam.modelo.manifesto.FeamCancelarMTRResposta;
import ws.service.feam.service.FeamService;
import ws.service.feam.util.Util;

@Path("/feam/api/v1/resource")
@RolesAllowed("FEAMSERVICEROLE")
public class FeamResource {

    @Inject
    FeamService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mtr/emitir")
    public FeamResposta salvarManifestoLote(@RestHeader("token") String token, @RestHeader("chave") String chave, FeamGerador gerador) throws FeamException {
        return service.salvarManifestoLote(token, chave, gerador);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mtr/cancelar")
    public FeamCancelarMTRResposta cancelarMTR(@RestHeader("token") String token, 
                                               @RestHeader("chave") String chave, 
                                               FeamCancelarMTR feamCancelarMTR) throws FeamException {
        return service.cancelarMTR(token, chave, feamCancelarMTR);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gettoken")
    public FeamLoginRespostaWS gettoken(FeamLoginCdCliente feamLogin) throws FeamException, IOException, SQLException {
        return service.gettoken(feamLogin);
    }
    

    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/mtr/download")
    public byte[] buscaPdfManifestoPorCodigoBarras(@RestHeader("token") String token, 
                                    @RestHeader("chave") String chave,
                                    @RestForm String nmMtr,
                                    @RestForm String cnpjGerador, 
                                    @RestForm String codSolicitacao,
                                    @RestForm String codigoBarra) throws FeamException {
    	byte[] resposta = service.buscaPdfManifestoPorCodigoBarras(token, chave, codigoBarra);

        if(resposta == null ) throw new NotFoundException("Sem dados!");

        String dataAtual    = Util.getDataAtual("yyyy-MM-dd HH:mm:ss.SSS");

        String diretorioArquivo = Util.getDiretorioPasta("../Z/SIGRA/MTR/FEAM/", dataAtual);

        String diretorioTemp = "../S/Temp/";

        String nomeArquivo = "FEAM - " + cnpjGerador + " - " + nmMtr + " - " + codSolicitacao + ".pdf"; 
        String caminhoArquivo = diretorioArquivo + nomeArquivo;

        String caminhoArquivoTemp = diretorioTemp + nomeArquivo;
        try{
                     
            try (OutputStream temp = new FileOutputStream(caminhoArquivo)) {
                temp.write(resposta);
                temp.close();
            }

            try (OutputStream temp = new FileOutputStream(caminhoArquivoTemp)) {
                temp.write(resposta);
                temp.close();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
            throw new ErroInternoException(ex);
        }
            
        return resposta;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/cdf/download")
    public byte[] downloadCdf(@RestHeader("token") String token, 
                                    @RestHeader("chave") String chave,
                                    @RestForm String nmCdf,
                                    @RestForm String cnpjGerador, 
                                    @RestForm String codSolicitacao) throws FeamException {
                                        
        byte[] resposta = service.downloadCdf(token, chave, nmCdf);

        if(resposta == null ) throw new NotFoundException("Sem dados!");

        String dataAtual    = Util.getDataAtual("yyyy-MM-dd HH:mm:ss.SSS");

        String diretorioArquivo = Util.getDiretorioPasta("../Z/SIGRA/CDF/FEAM/", dataAtual);

        String diretorioTemp = "../S/Temp/";

        String nomeArquivo = "FEAM - " + cnpjGerador + " - " + nmCdf + " - " + codSolicitacao + ".pdf"; 
        String caminhoArquivo = diretorioArquivo + nomeArquivo;

        String caminhoArquivoTemp = diretorioTemp + nomeArquivo;
        try{
                     
            try (OutputStream temp = new FileOutputStream(caminhoArquivo)) {
                temp.write(resposta);
                temp.close();
            }

            try (OutputStream temp = new FileOutputStream(caminhoArquivoTemp)) {
                temp.write(resposta);
                temp.close();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
            throw new ErroInternoException(ex);
        }
            
        return resposta;
    }

}