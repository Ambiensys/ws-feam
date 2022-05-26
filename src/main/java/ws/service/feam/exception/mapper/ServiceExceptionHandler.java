package ws.service.feam.exception.mapper;

import javax.annotation.Priority;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ws.service.feam.exception.FeamException;

@Provider
@Priority(200)
public class ServiceExceptionHandler implements ExceptionMapper<FeamException> 
{
	@Override
	public Response toResponse(FeamException exception) {
		return Response.status(exception.getErroBean().getStatus()).entity(exception.getErroBean()).build();
	}
}
