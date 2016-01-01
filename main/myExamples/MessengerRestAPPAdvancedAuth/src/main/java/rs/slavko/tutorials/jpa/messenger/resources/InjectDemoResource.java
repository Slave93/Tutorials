package rs.slavko.tutorials.jpa.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/jbinjectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	
	@GET
	public String tellWhatIsThisAllAbout(){
		return "go to currentUrl/annotations for testing MatrixParam,HeaderParam and CookieParam\n "
				+ "to /context for testing @Context annotations";
	}
	
	
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("authSessionID") String header,
											@CookieParam("someCP") String cookie) {
		return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path : " + path + " Cookies: " + cookies;
	}
	
	
	

}
