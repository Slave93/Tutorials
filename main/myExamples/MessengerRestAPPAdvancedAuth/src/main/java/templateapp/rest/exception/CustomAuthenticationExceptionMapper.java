package templateapp.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import templateapp.rest.model.ErrorMessage;

@Provider
public class CustomAuthenticationExceptionMapper implements ExceptionMapper<CustomAuthenticationException> {

	@Override
	public Response toResponse(CustomAuthenticationException exception) {
		//ukoilko korisnik prosledi loše kredencijale desice se CustomAuthenticationException
		//i treba samo da mu prosledimo poruku. U suprotom authentication resource ce mu vratiti
		//ticket koji je sačuvam u radnoj memoriji
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
		return Response.status(Status.OK).entity(errorMessage).build();
	}

}
