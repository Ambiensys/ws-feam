package ws.service.feam.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestPath;

import ws.service.feam.exception.FeamException;
import ws.service.feam.exception.mapper.ResponseException;
import ws.service.feam.modelo.configuracao.FeamIpResposta;
import ws.service.feam.modelo.gerador.FeamGerador;
import ws.service.feam.modelo.gerador.FeamResposta;
import ws.service.feam.modelo.login.FeamLogin;
import ws.service.feam.modelo.login.FeamLoginRespostaWS;
import ws.service.feam.modelo.manifesto.FeamCancelarMTR;
import ws.service.feam.modelo.manifesto.FeamCancelarMTRResposta;

@Path("")
@RegisterRestClient
@RegisterProvider(ResponseException.class)
public interface FeamRestClientService {

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/api/salvarManifestoLote")
        public FeamResposta salvarManifestoLote(@RestHeader("Authorization") String token,
                        @RestHeader("chave_feam") String chave,
                        FeamGerador gerador) throws FeamException;

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/api/cancelarManifesto")
        public FeamCancelarMTRResposta cancelarMTR(@RestHeader("Authorization") String token,
                        @RestHeader("chave_feam") String chave,
                        FeamCancelarMTR feamCancelarMTR) throws FeamException;

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

        @POST
        @Path("/api/buscaPdfManifestoPorCodigoBarras/{codigoBarras}")
        public byte[] buscaPdfManifestoPorCodigoBarras(@RestHeader("Authorization") String token,
                        @RestHeader("chave_feam") String chave,
                        @RestPath String codigoBarras) throws FeamException;

        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/ControllerServlet?acao=gravarIPAcessoWS")
        public FeamIpResposta salvarIP(
                        @RestForm String pessoaCodigo,
                        @RestForm String ip,
                        @RestForm String nome,
                        @RestHeader("Cookie") String cookie) throws FeamException;

        @GET
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Path("/LogoffUsuarioServlet")
        public Integer logoffUsuario(@RestHeader("Cookie") String cookie) throws FeamException;

        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Path("/ControllerServlet")
        public Response getAutenticacao(@RestForm String acao,
                        @RestForm String txtCnpj,
                        @RestForm String txtSenha,
                        @RestForm String txtUnidadeCodigo,
                        @RestForm String txtCpfUsuario,
                        @RestForm String tipoPessoaSociedade) throws FeamException;

        @POST
        @Path("/api/buscaPdfCdf/{nmCdf}")
        public byte[] downloadCdf(@RestHeader("Authorization") String token,
                        @RestHeader("chave_feam") String chave,
                        @RestPath String nmCdf) throws FeamException;

}
