package rs.slavko.tutorials.jpa.messenger.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Comment;
import rs.slavko.tutorials.jpa.messenger.model.Message;

public interface MessageDAO {

	
	public List<Message> getAllMessages();
	
	public List<Message> getAllMessagesForYear(int year);
	
	public List<Message> getAllMessagesPaginated(int start, int size);
	
	public List<Message> getAllMessagesForProfile(String profileName);
	
	public Message getMessage(String profileName, int messageNumber);
	
	public Message getMessage(long id);	
	
	public Message addMessage(String profileName, Message message);	
	
	public Message removeMessage(long id);
	

	
	
	
}
