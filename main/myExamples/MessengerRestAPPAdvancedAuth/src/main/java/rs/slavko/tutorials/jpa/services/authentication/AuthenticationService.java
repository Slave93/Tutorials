package rs.slavko.tutorials.jpa.services.authentication;

import rs.slavko.tutorials.jpa.messenger.exception.CustomAuthenticationException;
import rs.slavko.tutorials.jpa.messenger.exception.InvalidTicketException;

public interface AuthenticationService {
	public String authenticate(String username,String password) throws CustomAuthenticationException;
	public void validate(String ticket) throws InvalidTicketException;
}
