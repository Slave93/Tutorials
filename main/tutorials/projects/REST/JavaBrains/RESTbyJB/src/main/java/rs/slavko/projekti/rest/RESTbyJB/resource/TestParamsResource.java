package rs.slavko.projekti.rest.RESTbyJB.resource;

import java.security.URIParameter;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

@Path("/testParams")
public class TestParamsResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getParamValues(@QueryParam("someQP") String someQP,
								 @CookieParam("someCP") String someCP,
								 @HeaderParam("someHP") String someHP,
								 @MatrixParam("someMP") String someMP,
								 @Context HttpHeaders headerParam,
								 @Context UriInfo uriInfo){		
		return "QueryParam: "+someQP+" CookieParam: "+someCP+" HeaderParam: "+someHP+" MatrixParam: "+someMP
				+"\n"+
				"AbsolutPath: "+uriInfo.getAbsolutePath()
				+"\n"+
				"AllCookies: "+headerParam.getCookies();
		
	}
}
