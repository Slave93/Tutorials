package rs.slavko.tutorials.jpa.messenger.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue
	private long id;
	private int commentSequence;
    private String messageTxt;
    private Date created;
    @ManyToOne(optional = true, targetEntity=Profile.class)
    @JoinColumn(name = "author", referencedColumnName = "profileName")
    private String author;
    @ManyToOne(optional = false, targetEntity=Message.class)
    @JoinColumn(name = "message", referencedColumnName = "id")
    private Message message;
    
    public Comment() {
    	
    }
    

	


	public int getCommentSequence() {
		return commentSequence;
	}





	public void setCommentSequence(int commentSequence) {
		this.commentSequence = commentSequence;
	}	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageTxt() {
		return messageTxt;
	}

	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
    
   
    

}
