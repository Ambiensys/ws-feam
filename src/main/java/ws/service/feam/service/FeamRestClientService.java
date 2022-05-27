package ws.service.feam.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;

import ws.service.feam.exception.FeamException;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.login.FeamLogin;
import ws.service.feam.modelo.login.FeamLoginRespostaWS;
import ws.service.feam.modelo.manifesto.FeamCancelarMTRResposta;

@Path("")
@RegisterRestClient
public interface FeamRestClientService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/salvarManifestoLote")
    public FeamResposta salvarManifestoLote(@RestHeader("Authorization") String token, 
                                            @RestHeader("chave_feam") String chave, 
                                            FeamGerador gerador) throws FeamException;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ControllerServlet")
    public FeamCancelarMTRResposta cancelarMTR(@RestHeader("Cookie") String cookie, 
                                               @RestForm String codManifesto, 
                                               @RestForm String justificativa, 
                                               @RestForm String acao) throws FeamException;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/gettoken")
    public FeamLoginRespostaWS gettoken(FeamLogin feamLogin) throws FeamException;


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ControllerServlet")
    public Response pesquisaUsuarioUnidades(@RestForm String txtCnpj, 
                                            @RestForm String acao) throws FeamException;
}
