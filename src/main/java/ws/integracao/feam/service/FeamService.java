package ws.integracao.feam.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ws.integracao.feam.modelo.endereco.FeamEndereco;

@Path("/ControllerServlet")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface FeamService {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public FeamEndereco buscarEndereco(@FormParam("acao") String acao, @FormParam("cep") String cep) throws ProcessingException;
}
