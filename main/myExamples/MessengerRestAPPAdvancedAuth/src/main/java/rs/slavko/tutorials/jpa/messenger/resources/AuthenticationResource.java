package rs.slavko.tutorials.jpa.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.slavko.tutorials.jpa.messenger.model.Profile;

@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {
	
	@GET
	public Profile authenticate() {
		System.out.println("In resource");
		return new Profile("Slave","Slavko","Komarica","123123");	
	}
}
