package ws.integracao.feam.exception.mapper;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ws.integracao.feam.exception.FeamException;

@Provider
@Priority(200)
public class FeamExceptionHandler implements ExceptionMapper<FeamException> 
{
	Logger LOG = Logger.getLogger(FeamExceptionHandler.class.getName());

	@Override
	public Response toResponse(FeamException exception) {
		return Response.status(exception.getErroBean().getCodigoErro()).entity(exception.getErroBeanJson()).build();
	}
}
