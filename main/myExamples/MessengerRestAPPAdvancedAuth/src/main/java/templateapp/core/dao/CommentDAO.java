package templateapp.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import templateapp.core.database.DatabaseClass;
import templateapp.core.model.Comment;
import templateapp.core.model.Message;

public interface CommentDAO {
	
	
	public List<Comment> getAllComments(long messageId);
	
	public Comment getComment(long messageId, int commentNumber);
	
	public Comment addComment(long messageId, Comment comment);
	
	public Comment removeComment(long messageId, int commentNumber);
		
}
