package rs.slavko.projekti.rest.RESTbyJB.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rs.slavko.projekti.rest.RESTbyJB.model.Comment;
import rs.slavko.projekti.rest.RESTbyJB.model.Message;
import rs.slavko.projekti.rest.RESTbyJB.model.MessageFilterBean;
import rs.slavko.projekti.rest.RESTbyJB.service.MessageService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService msgSrv = new MessageService(); 

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
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilter) {
		if (messageFilter.getYear() > 0) {
			return msgSrv.getAllMessagesForYear(messageFilter.getYear());
		}
		if (messageFilter.getStart() >= 0 && messageFilter.getSize() > 0) {
			return msgSrv.getAllMessagesPaginated(messageFilter.getStart(), messageFilter.getSize());
		}
		return msgSrv.getAllMessages();
	}

    @POST
    public Message addMessage(Message message) {
        return msgSrv.addMessage(message);
    }
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(Message message,@PathParam("messageId") long id) {
    	message.setId(id);
        return msgSrv.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
    	msgSrv.removeMessage(id);
    }	

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {	
		return msgSrv.getMessage(id);
	}
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {	
		return new CommentResource();
	}
	
	
	//moved to SubResource
	/*@GET
	@Path("/{messageId}/comments")
	public List<Comment> getMessageComments(@PathParam("messageId") long MessageId) {	
		return msgSrv.getMessageComments(MessageId);
	}
	
	
	@GET
	@Path("/{messageId}/comments/{commentId}")
	public Comment getMessageComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId) {	
		return msgSrv.getComment(commentId, messageId);
	}*/
	
	
	
	
	
}
