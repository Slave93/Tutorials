package templateapp.core.service.authentication;

import templateapp.rest.exception.CustomAuthenticationException;
import templateapp.rest.exception.InvalidTicketException;

public interface AuthenticationService {
	public String authenticate(String username,String password) throws CustomAuthenticationException;
	public String validate(String ticket) throws InvalidTicketException;
}
