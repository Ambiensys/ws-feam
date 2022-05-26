package ws.service.feam.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ws.service.feam.exception.FeamException;
import ws.service.feam.exception.geral.ErroServicoRemotoException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;

@ApplicationScoped
public class FeamService {
    
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
}
