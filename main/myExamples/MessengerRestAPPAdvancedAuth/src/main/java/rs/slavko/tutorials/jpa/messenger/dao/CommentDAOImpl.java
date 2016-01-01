package rs.slavko.tutorials.jpa.messenger.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Comment;
import rs.slavko.tutorials.jpa.messenger.model.Message;

public class CommentDAOImpl implements CommentDAO{
	
	MessageDAO messageDAO = new MessageDAOImpl();
	
	public List<Comment> getAllComments(long messageId) {
		List<Comment> comments = messageDAO.getMessage(messageId).getComments();
		return comments;
	}
	
	public Comment getComment(long messageId, int commentNumber) {		
		return messageDAO.getMessage(messageId).getComments().get(commentNumber-1);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Message message = messageDAO.getMessage(messageId);
		List<Comment> comments = message.getComments();		
		comment.setMessage(message);
		comment.setCreated(new Date());
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
		return comment;
	}
	
	public Comment removeComment(long messageId, int commentOrder) {		
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();		
		Comment c = getComment(messageId, commentOrder);
		c = em.merge(c);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}
		
}
