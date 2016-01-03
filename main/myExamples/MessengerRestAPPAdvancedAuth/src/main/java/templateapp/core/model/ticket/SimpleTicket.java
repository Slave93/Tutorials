package templateapp.core.model.ticket;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SimpleTicket {
	private String ticket;	
	private String userName;
	private SecureRandom random = new SecureRandom();
	
	public SimpleTicket(String username){
		this.ticket = nextTicket();			
		this.userName = username;
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
