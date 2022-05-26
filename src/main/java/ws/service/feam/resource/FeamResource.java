package ws.service.feam.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestHeader;

import ws.service.feam.exception.FeamException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.service.FeamService;

@Path("/feam/api/v1/resource")
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
}