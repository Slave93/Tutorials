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
    private String password;
   
    
    public Profile() {
    	
    }
    
	public Profile(String profileName, String firstName, String lastName,String password) {		
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;		
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	

	@Override
	public String toString() {
		return "Profile [profileName=" + profileName
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
    
    
}
