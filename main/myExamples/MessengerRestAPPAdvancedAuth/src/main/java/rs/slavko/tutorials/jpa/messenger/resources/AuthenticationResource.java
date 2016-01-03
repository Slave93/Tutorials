package rs.slavko.tutorials.jpa.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rs.slavko.tutorials.jpa.messenger.exception.CustomAuthenticationException;
import rs.slavko.tutorials.jpa.messenger.model.LoginData;
import rs.slavko.tutorials.jpa.messenger.model.Profile;
import rs.slavko.tutorials.jpa.services.authentication.AuthenticationService;
import rs.slavko.tutorials.jpa.services.authentication.ticket.TicketService;

@Component
@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

	@Autowired
	public AuthenticationService authenticationService;	



	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@GET
	public Profile authenticate() {
		System.out.println("In resource breeee");
		System.out.println("Autowiring authentication service success " + authenticationService);
		return new Profile("Slave", "Slavko", "Komarica", "123123","ROLE_REST");
	}
	
	@POST	
	public Profile getTicket(LoginData loginData) throws CustomAuthenticationException {
		System.out.println("username: "+loginData.getUsername()+" password: "+loginData.getPassword());
		System.out.println("Authenticating user");
		authenticationService.authenticate(loginData.getUsername(),loginData.getPassword());
		return new Profile("Slave", "Slavko", "Komarica", "123123","ROLE_REST");
		
	}
	
}
