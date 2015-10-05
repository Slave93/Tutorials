package rs.slavko.projekti.rest.RESTbyJB.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.message.internal.MsgTraceEvent;

import rs.slavko.projekti.rest.RESTbyJB.model.Comment;
import rs.slavko.projekti.rest.RESTbyJB.service.MessageService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private MessageService msgSrv = new MessageService();
	
	
	/*
	@GET	
	public List<Comment> getMessageComments(@PathParam("messageId") long MessageId) {	
		//return msgSrv.getMessageComments(MessageId);
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(1l, "HardcodeCOmment", 1l));
		comments.add(new Comment(2l, "HardcodeCOmment", 1l));
		return comments;
	}
	
	
	@GET
	@Path("/{commentId}")
	public Comment getMessageComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId) {	
		return msgSrv.getComment(commentId, messageId);
	}*/

}
