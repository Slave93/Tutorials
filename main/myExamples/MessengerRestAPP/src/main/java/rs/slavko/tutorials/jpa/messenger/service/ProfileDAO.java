package rs.slavko.tutorials.jpa.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Profile;

public interface ProfileDAO {

		
	public List<Profile> getAllProfiles();
	
	public Profile getProfile(String profileName);
	
	public Profile addProfile(Profile profile);
	
	public Profile updateProfile(Profile profile);
	
	public Profile removeProfile(String profileName);
	
	
}
