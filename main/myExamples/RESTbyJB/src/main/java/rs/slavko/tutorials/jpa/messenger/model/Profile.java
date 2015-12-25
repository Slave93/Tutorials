package rs.slavko.tutorials.jpa.messenger.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "profile")
public class Profile {	
	@Id
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;
    
    public Profile() {
    	this.created = new Date();
    }
    
	public Profile(String profileName, String firstName, String lastName) {		
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Profile [profileName=" + profileName
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", created=" + created + "]";
	}
    
    
}
