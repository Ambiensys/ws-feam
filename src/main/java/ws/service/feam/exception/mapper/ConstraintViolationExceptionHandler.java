package ws.service.feam.exception.mapper;

import java.util.Set;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import ws.service.feam.erro.ErroBean;

@Provider()
@Priority(100)
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> 
{

	@Inject
	Logger logger;

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		ErroBean bean = new ErroBean();
		bean.setStatus(Status.BAD_REQUEST.getStatusCode());
		Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : violations) {
			bean.setMensagem(constraintViolation.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(bean).build();
		}
		return null;
	}

}
