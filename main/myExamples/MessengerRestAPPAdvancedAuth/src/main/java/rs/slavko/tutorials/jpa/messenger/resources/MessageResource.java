package rs.slavko.tutorials.jpa.messenger.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import rs.slavko.tutorials.jpa.messenger.dao.MessageDAO;
import rs.slavko.tutorials.jpa.messenger.dao.MessageDAOImpl;
import rs.slavko.tutorials.jpa.messenger.exception.DataNotFoundException;
import rs.slavko.tutorials.jpa.messenger.model.ErrorMessage;
import rs.slavko.tutorials.jpa.messenger.model.Message;
import rs.slavko.tutorials.jpa.messenger.resources.beans.MessageFilterBean;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)// if you want to provide more consuming and providing formats
// you can supply media type as @Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML}) or @Consumes...
// or you can have different methods binded to same path but different media types at Produces annotation
//lets say getJSONMessages and getXMLMessages, so client can provide Accept header value and based on that
//right method will be called(same as for consumes - ContentType header value in client request)
public class MessageResource {

	MessageDAO messageDAO = new MessageDAOImpl();	
	/*
	 Naming of this method does not count. XML will be returned in format
	 <messages>
	 	<message>
	 	  <id> 1 </id>
	 	  ...
	 	</message>
	 	...
	 </messages>
	 */
	@GET	
	public List<Message> getMessages(@QueryParam("profName") String profName) {
		if(profName!=null){
			return messageDAO.getAllMessagesForProfile(profName);
		}		
		return messageDAO.getAllMessages();
	}

	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo,@QueryParam("profileName") String profileName) {
		if(profileName==null){
			// Ovo su BUILT IN 	exceptioni JAX-RS-a koje mozes da koristis bez mappera
			// mozes da koristis i neke od podklasa WebApplicationException klase
			// kao sto su NotFound,ServerError, gde je status vec podesen pa ne moras da bildujes
			// response samo prosledis errorMessage konstruktoru exceptiona
			ErrorMessage errorMessage = new ErrorMessage("Must provide profile name in query param", 404, "http://slavko.komarica.rs");
			Response res =  Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
			throw new  WebApplicationException(res);
		}
		
		message = messageDAO.addMessage(profileName, message);
		//mozes da koristis i Response.status(...).entity().build(); ali imas i ovako metode koje automatski
		//postavljaju status plus ova created prima sta je to kreirano
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build())
					   .entity(message).build();
	}	
	
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageDAO.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageDAO.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		
		return message;
		
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		/*URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
	       		.path(MessageResource.class, "getCommentResource")
	       		.path(CommentResource.class)
	       		.resolveTemplate("messageId", message.getId())// cause now link contain's variable portion of messageId we need to resolve that to a value
	            .build();
	    return uri.toString();*/
		return "";
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
       		 .path(ProfileResource.class)
       		 .path(message.getAuthor().getProfileName())
             .build();
        return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
		 .path(MessageResource.class)
		 .path(Long.toString(message.getId()))
		 .build()
		 .toString();
		return uri;
	}
	
	
	
}
