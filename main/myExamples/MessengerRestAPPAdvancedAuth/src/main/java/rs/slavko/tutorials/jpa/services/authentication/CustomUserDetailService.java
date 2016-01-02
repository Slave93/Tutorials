package rs.slavko.tutorials.jpa.services.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAO;
import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAOImpl;
import rs.slavko.tutorials.jpa.messenger.model.Profile;

public class CustomUserDetailService implements UserDetailsService{

	ProfileDAO profileDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		profileDao = new ProfileDAOImpl();
		Profile p = profileDao.getProfile(userName);
		if(p==null){
			throw new UsernameNotFoundException("There is no user with userName: "+userName);
		}
		List authList = new ArrayList();  
	    authList.add(new SimpleGrantedAuthority("ROLE_REST"));  
	    
		UserDetails ud = new User(p.getProfileName(), p.getPassword(), true, true, true, true, authList);
		return ud;
		
	}

}
