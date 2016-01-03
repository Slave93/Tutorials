package templateapp.rest.resources;

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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import templateapp.core.dao.CommentDAO;
import templateapp.core.dao.CommentDAOImpl;
import templateapp.core.model.Comment;
import templateapp.rest.model.ErrorMessage;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	//kod ovih metoda imas i @PathParam messageId od MessageResource klase jer
	//smo odale dosli pa se path samo dopunjuje
	
	private CommentDAO commentDAO = new CommentDAOImpl();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentDAO.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentDAO.addComment(messageId, comment);
	}	

	
	@DELETE
	@Path("/{commentOrder}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentOrder") long commentOrder) {
		commentDAO.removeComment(messageId, (int)commentOrder);
	}
	
	
	@GET
	@Path("/{commentOrder}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentOrder") long commentOrder) {
		Comment comment = commentDAO.getComment(messageId, (int)commentOrder);
		if(comment==null){
			// Ovo su BUILT IN 	exceptioni JAX-RS-a koje mozes da koristis bez mappera
			// mozes da koristis i neke od podklasa WebApplicationException klase
			// kao sto su NotFound,ServerError, gde je status vec podesen pa ne moras da bildujes
			// response samo prosledis errorMessage konstruktoru exceptiona
			ErrorMessage errorMessage = new ErrorMessage("Not found");
			Response res =  Response.status(Status.NOT_FOUND).entity(errorMessage).build();
			throw new  WebApplicationException(res);
		}
		return comment;
	}
	
}
