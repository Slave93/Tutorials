package rs.slavko.tutorials.jpa.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import rs.slavko.tutorials.jpa.messenger.model.ErrorMessage;
//@Provider
public class NullPointerExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://rs.slavko.tutorials");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
