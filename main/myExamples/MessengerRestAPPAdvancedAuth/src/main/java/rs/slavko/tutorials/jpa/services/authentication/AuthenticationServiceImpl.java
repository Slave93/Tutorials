package rs.slavko.tutorials.jpa.services.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAO;
import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAOImpl;
import rs.slavko.tutorials.jpa.messenger.exception.CustomAuthenticationException;
import rs.slavko.tutorials.jpa.messenger.exception.InvalidTicketException;
import rs.slavko.tutorials.jpa.messenger.model.Profile;
import rs.slavko.tutorials.jpa.services.authentication.ticket.TicketService;

public class AuthenticationServiceImpl implements AuthenticationService{

	private TicketService ticketService;
	//Instantiating here is not the best soultion but will work for now
	private ProfileDAO profileDao = new ProfileDAOImpl();

	@Override
	public String authenticate(String username, String password)
			throws CustomAuthenticationException {
		if(username==null || password==null){
			throw new CustomAuthenticationException("Must provide username and password");
		}
		Profile profile = profileDao.getProfile(username);
		if(profile==null){
			throw new CustomAuthenticationException("Must provide valid username and password");
		}
		System.out.println("###debug "+this.getClass().toString()+": TicketSerice "+profile.getPassword());
		//TODO: check wheater passwords match and if so generate new ticket and return ticket string
		//if no throw CustomAuthenticationException
		return null;
	}

	@Override
	public void validate(String ticket) throws InvalidTicketException {
		// TODO Auto-generated method stub
		
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

}
