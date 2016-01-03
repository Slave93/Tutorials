package templateapp.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import templateapp.core.database.DatabaseClass;
import templateapp.core.model.Profile;

public interface ProfileDAO {

		
	public List<Profile> getAllProfiles();
	
	public Profile getProfile(String profileName);
	
	public Profile addProfile(Profile profile);
	
	public Profile updateProfile(Profile profile);
	
	public Profile removeProfile(String profileName);
	
	
}
