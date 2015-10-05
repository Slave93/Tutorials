package rs.slavko.projekti.rest.RESTbyJB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rs.slavko.projekti.rest.RESTbyJB.database.DatabaseClass;
import rs.slavko.projekti.rest.RESTbyJB.model.Profile;



public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Slave", new Profile(1L, "Slave", "Slavko", "Komarica"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		if(profiles.get(profile.getProfileName())==null)
			return null;
		profile.setId(profiles.get(profile.getProfileName()).getId());		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
