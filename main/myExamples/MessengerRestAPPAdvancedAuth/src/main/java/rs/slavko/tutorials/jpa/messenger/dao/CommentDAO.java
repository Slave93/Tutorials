package rs.slavko.tutorials.jpa.messenger.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Comment;
import rs.slavko.tutorials.jpa.messenger.model.Message;

public interface CommentDAO {
	
	
	public List<Comment> getAllComments(long messageId);
	
	public Comment getComment(long messageId, int commentNumber);
	
	public Comment addComment(long messageId, Comment comment);
	
	public Comment removeComment(long messageId, int commentNumber);
		
}
