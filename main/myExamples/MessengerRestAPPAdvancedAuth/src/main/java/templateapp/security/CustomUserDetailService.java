package templateapp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import templateapp.core.dao.ProfileDAO;
import templateapp.core.dao.ProfileDAOImpl;
import templateapp.core.model.Profile;

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
