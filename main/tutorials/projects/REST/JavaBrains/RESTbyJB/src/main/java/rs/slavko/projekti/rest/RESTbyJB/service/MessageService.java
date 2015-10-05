package rs.slavko.projekti.rest.RESTbyJB.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import rs.slavko.projekti.rest.RESTbyJB.database.DatabaseClass;
import rs.slavko.projekti.rest.RESTbyJB.model.Comment;
import rs.slavko.projekti.rest.RESTbyJB.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	private Map<Long, Comment> comments = DatabaseClass.getComments();
	
	public MessageService() {
		messages.put(1l, new Message(1, "Hello World", "Slavko"));
		messages.put(2l, new Message(2, "Hello Jersey", "Slavko"));
		
		comments.put(1l, new Comment(1l,"FirstMessageFirstComment",1l));
		comments.put(2l, new Comment(2l,"FirstMessageSecondComment",1l));
		comments.put(3l, new Comment(3l,"FirstMessageThirdComment",1l));
		comments.put(4l, new Comment(4l,"FirstMessageFourthComment",1l));
		comments.put(5l, new Comment(1l,"SecondMessageFirstComment",2l));
		comments.put(6l, new Comment(2l,"SecondMessageSecondComment",2l));		
	}
	
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1l);
		messages.put(message.getId(), message);
		return messages.get(message.getId());
	}
		
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return messages.get(message.getId());
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	public Comment addComment(Comment comment){		
		if(messages.get(comment.getMessageId())==null){
			return null;
		}
		long count = 0;
		ArrayList<Comment> allComments = new ArrayList<Comment>(comments.values());		
		for (int i = 0; i < allComments.size(); i++) {
			if(allComments.get(i).getMessageId()==comment.getMessageId()){
				count++;
			}
		}
		comment.setId(count + 1l);
		comments.put(comments.size()+1l, comment);
		return comment;
	}	
	
	public Comment getComment(long id,long messageId){
		ArrayList<Comment> allComments = new ArrayList<Comment>(comments.values());
		for (int i = 0; i < allComments.size(); i++) {
			if(allComments.get(i).getId()==id & allComments.get(i).getMessageId()==messageId){
				return allComments.get(i);				
			}
		}
		return null;
	}
	
	public List<Comment> getAllComments(){
		return new ArrayList<Comment>(comments.values());
	}
	
	public List<Comment> getMessageComments(long messageId){
		ArrayList<Comment> allComments = new ArrayList<Comment>(comments.values());
		ArrayList<Comment> messageComments = new ArrayList<Comment>();
		for (int i = 0; i < allComments.size(); i++) {
			if(allComments.get(i).getMessageId()==messageId){
				messageComments.add(allComments.get(i));
			}
		}
		return messageComments;		
	}
	
	public Comment removeComment(long id, long messageId){
		ArrayList<Comment> allComments = new ArrayList<Comment>(comments.values());
		for (int i = 0; i < allComments.size(); i++) {
			if(allComments.get(i).getId()==id && allComments.get(i).getMessageId()==messageId){
				return allComments.remove(i);
			}
		}
		return null;
	}
	
	
	

	
	
	
}
