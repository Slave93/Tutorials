package templateapp.core.service.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import templateapp.core.dao.ProfileDAO;
import templateapp.core.dao.ProfileDAOImpl;
import templateapp.core.model.Profile;
import templateapp.rest.exception.CustomAuthenticationException;
import templateapp.rest.exception.InvalidTicketException;

public class AuthenticationServiceImpl implements AuthenticationService {

	private TicketService ticketService;
	// Instantiating here is not the best soultion but will work for now
	private ProfileDAO profileDao = new ProfileDAOImpl();
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String authenticate(String username, String password)
			throws CustomAuthenticationException {
		if (username == null || password == null) {
			throw new CustomAuthenticationException(
					"Bad credentials");
		}
		Profile profile = profileDao.getProfile(username);
		if (profile == null) {
			throw new CustomAuthenticationException(
					"Bad credentials");
		}
		
		String encodedPassword = profile.getPassword();		
		System.out.println("DB password: " + encodedPassword); //DELETE LINE!!!
		System.out.println("Provided password: "+ password); //DELETE LINE!!!
		boolean matches = passwordEncoder.matches(password, encodedPassword);
		if (!matches) {
			throw new CustomAuthenticationException("Bad credentials");
		}
		return ticketService.generateTicket(username).getTicket();

	}

	@Override
	public String validate(String ticket) throws InvalidTicketException {
		if(ticket==null){
			throw new InvalidTicketException("Must provide a valid ticket!");
		}
		String userName = ticketService.validateTicket(ticket);
		if(ticket==null){
			throw new InvalidTicketException("Provided ticket is no longer valid!");
		}
		return userName;

	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

}
