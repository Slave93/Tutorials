package kom.slavko.tutorials.spring.springMVC.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kom.slavko.tutorials.spring.springMVC.validation.ValidEmail;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Message;

public class Offer {
	private int id;
	
	@Size(min=5,max=100)	
	private String name;
	
	@ValidEmail
	private String email;	
	
	@NotBlank()
	private String text;

	public int getId() {
		return id;
	}
	public Offer() {
		
	}
	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}
	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}
