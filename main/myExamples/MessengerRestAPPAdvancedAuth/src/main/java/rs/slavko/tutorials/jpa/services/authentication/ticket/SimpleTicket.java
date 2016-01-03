package rs.slavko.tutorials.jpa.services.authentication.ticket;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SimpleTicket {
	private String ticketId;
	private String ticket;
	private String userName;
	private SecureRandom random = new SecureRandom();
	
	public SimpleTicket(String username){
		this.ticketId = nextTicket();
		this.ticket = "ticket_"+ticketId;		
		this.userName = userName;
	}
	
	
	
	public String getTicketId() {
		return ticketId;
	}



	public String getTicket() {
		return ticket;
	}



	public String getUserName() {
		return userName;
	}



	private String nextTicket() {
	    return new BigInteger(130, random).toString(32);
	}
}
