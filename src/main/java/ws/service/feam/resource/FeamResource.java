package ws.service.feam.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;

import ws.service.feam.exception.FeamException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.manifesto.FeamCancelarMTRResposta;
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

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mtr/cancelar")
    public FeamCancelarMTRResposta cancelarMTR(@RestHeader("Cookie") String cookie, @RestForm String codManifesto, @RestForm String justificativa) throws FeamException {
        return service.cancelarMTR(cookie, codManifesto, justificativa);
    }
}