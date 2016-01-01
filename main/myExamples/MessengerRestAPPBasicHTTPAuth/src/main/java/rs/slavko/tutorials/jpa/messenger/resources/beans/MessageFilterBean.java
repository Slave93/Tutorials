package rs.slavko.tutorials.jpa.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	 private @QueryParam("profileName") String profileName;

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	 
	
	 

	 
	 
	 
	
	
}
