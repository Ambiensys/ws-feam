package ws.integracao.feam.resource;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import io.smallrye.common.constraint.NotNull;
import ws.integracao.feam.exception.FeamException;
import ws.integracao.feam.exception.FeamServiceUnavailableException;
import ws.integracao.feam.exception.geral.ErroInternoException;
import ws.integracao.feam.exception.geral.ErroServicoRemotoException;
import ws.integracao.feam.modelo.endereco.FeamEndereco;
import ws.integracao.feam.service.FeamService;

@Path("/feam/api/v1")
public class FeamResource {
	
	@Inject
    @RestClient
    FeamService service;
	
	@Inject
    Logger logger;
	
	@GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarEndereco")
    public FeamEndereco buscarEndereco( @NotBlank(message = "Cep não pode ser vazio") 
                                         @NotNull()
                                         @QueryParam("cep") final String cep) throws FeamException {
        logger.info("buscarEndereco");
        try {
            FeamEndereco sinirEndereco = null;
            sinirEndereco = service.buscarEndereco(cep);
            return sinirEndereco;
        } catch (ProcessingException e) {
            e.printStackTrace();
            throw new FeamServiceUnavailableException(e);
        } catch (WebApplicationException e) {
            e.printStackTrace();
            String entity = e.getResponse() != null && e.getResponse().getEntity() != null ? e.getResponse().getEntity().toString() : "";
			throw new ErroServicoRemotoException(e, service, e.getResponse().getStatus(), entity);          
        } catch (FeamException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErroInternoException(e);
        }
    }

}
