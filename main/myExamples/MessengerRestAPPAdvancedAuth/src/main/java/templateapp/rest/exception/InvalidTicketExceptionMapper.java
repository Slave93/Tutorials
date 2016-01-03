package templateapp.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidTicketExceptionMapper implements
		ExceptionMapper<InvalidTicketException> {

	@Override
	public Response toResponse(InvalidTicketException exception) {
		// ukoliko je ticket istekao ili ne postoji u memoriji
		// vraca se 401 unauthorised
		return Response.status(Status.UNAUTHORIZED)
				.entity(exception.getMessage()).build();
	}

}
