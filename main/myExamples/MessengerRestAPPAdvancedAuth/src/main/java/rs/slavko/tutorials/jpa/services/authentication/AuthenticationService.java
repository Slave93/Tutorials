package rs.slavko.tutorials.jpa.services.authentication;

public interface AuthenticationService {
	public void authenticate(String username,String password) throws Exception;
	public void validate(String ticket);
}
