package ws.integracao.feam.exception.mapper;

import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import ws.integracao.feam.erro.ErroBean;
import ws.integracao.feam.exception.FeamException;


public class FeamResponseException implements ResponseExceptionMapper<Exception> {
	Logger LOG = Logger.getLogger(FeamResponseException.class.getName());

	@Override	
	// tag::handles[]
	public boolean handles(int status, MultivaluedMap<String, Object> headers) {
		LOG.info("respondemapper status " + status);
		 return status == Status.UNAUTHORIZED.getStatusCode() // 
					|| status == Status.BAD_REQUEST.getStatusCode() // 
			        || status == Status.SERVICE_UNAVAILABLE.getStatusCode()
					|| status == Status.NOT_FOUND.getStatusCode()
					|| status == Status.INTERNAL_SERVER_ERROR.getStatusCode();
	}
	// end::handles[]

	@Override
	// tag::toThrowable[]
	  public Exception toThrowable(Response response) {
		
	    switch (response.getStatus()) {
	    case 401:
            return new FeamException(this.getErroBean(response));
		case 400:
			LOG.info("responseHandler " + response.getEntity());
            return new WebApplicationException(response);
	    case 404:
			LOG.info("responseHandler " + response.readEntity(String.class));
			return new FeamException(this.getErroBean(response));
	    case 503:
	      return null;
		case 500:
		  LOG.info("responseHandler " + response.readEntity(String.class));
	      return new WebApplicationException(response);
	    }
	    return null;
	  }
	// end::toThrowable[]

	private ErroBean getErroBean(Response response){
		Jsonb jsonb = JsonbBuilder.create();
		ErroBean erroBean = jsonb.fromJson(response.readEntity(String.class), ErroBean.class);
		erroBean.setCodigoErro(response.getStatus());
		return erroBean;
	}
}
// end::mapper[]
