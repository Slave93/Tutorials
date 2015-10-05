package rs.slavko.projekti.rest.RESTbyJB.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	private long id;
	private long messageId;
	private String comment;
	
	
	public Comment(){
		
	}


	public Comment(long id, String comment, long messageId) {
		this.id = id;
		this.comment = comment;
		this.messageId = messageId;
	}


	public long getMessageId() {
		return messageId;
	}


	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
