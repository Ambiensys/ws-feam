package ws.integracao.feam.resource;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import io.smallrye.common.constraint.NotNull;
import ws.integracao.feam.modelo.endereco.FeamEndereco;
import ws.integracao.feam.service.FeamService;

@Path("/feam/api/v1")
public class FeamResource {
	
	@Inject
    @RestClient
    FeamService service;
	
	@Inject
    Logger logger;
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarEndereco")
    public FeamEndereco buscarEndereco( @NotBlank(message = "Cep não pode ser vazio") 
                                         @NotNull()
                                         @QueryParam("cep") final String cep) {
        logger.info("buscarEndereco");
        try {
            FeamEndereco feamEndereco = null;
            feamEndereco = service.buscarEndereco("buscaCep", cep);
            return feamEndereco;
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
