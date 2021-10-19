package ws.integracao.feam.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ws.integracao.feam.exception.FeamException;
import ws.integracao.feam.exception.mapper.FeamResponseException;
import ws.integracao.feam.modelo.endereco.FeamEndereco;

@Path("/api")
@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterProvider(FeamResponseException.class)
public interface FeamService {

	@GET
    @Path("/consultaCep/{cep}")
    @ClientHeaderParam(name="Cookie", value="{cookieParam}")
    public FeamEndereco buscarEndereco(@PathParam("cep") String cep) throws ProcessingException, FeamException;
}
