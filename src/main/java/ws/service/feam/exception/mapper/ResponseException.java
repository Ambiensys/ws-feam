package ws.service.feam.exception.mapper;

import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import ws.service.feam.erro.ErroBean;
import ws.service.feam.exception.FeamException;


public class ResponseException implements ResponseExceptionMapper<Exception> {
	Logger LOG = Logger.getLogger(ResponseException.class.getName());

	@Override	
	// tag::handles[]
	public boolean handles(int status, MultivaluedMap<String, Object> headers) {
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
		ErroBean erroBean = new ErroBean();
	    switch (response.getStatus()) {
	    case 401:
			System.out.println("401 ");
			
			erroBean.setStatus(response.getStatus());
			erroBean.setMensagem("O token de acesso ao FEAM não é válido!! Não Autorizado!!");
			erroBean.setErro(true);

			if(response.getEntity() != null){
				erroBean = this.getErroBean(response);
			}

            return new FeamException(erroBean);
		case 400:
			System.out.println("400 ");
            return new FeamException(this.getErroBean(response));
	    case 404:
			System.out.println("404 ");
			return new FeamException(this.getErroBean(response));
	    case 503:
			System.out.println("503 ");
	      return null;
		case 500:
				
			erroBean.setStatus(response.getStatus());
			erroBean.setMensagem("Problemas com serviço externo do FEAM");
			erroBean.setErro(true);

			if(response.getEntity() != null){
				erroBean = this.getErroBean(response);
			}

			return new FeamException(erroBean);
	    }
	    return null;
	  }
	// end::toThrowable[]

	private ErroBean getErroBean(Response response){
		System.out.println("response.readEntity(String.class) " + response.getEntity());
		Jsonb jsonb = JsonbBuilder.create();
		ErroBean erroBean = new ErroBean();
		if(response.getEntity() != null){
			erroBean = jsonb.fromJson(response.readEntity(String.class), ErroBean.class);
		}
		erroBean.setStatus(response.getStatus());		
		return erroBean;
	}
}
// end::mapper[]
