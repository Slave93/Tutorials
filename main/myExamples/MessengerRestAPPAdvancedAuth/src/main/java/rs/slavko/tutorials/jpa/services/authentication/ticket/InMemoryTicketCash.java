package rs.slavko.tutorials.jpa.services.authentication.ticket;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTicketCash {
	private static Map<String,SimpleTicket> ticketCash = new HashMap<String, SimpleTicket>();
	
	
	public void addTicket(SimpleTicket ticket){
		ticketCash.put(ticket.getTicketId(), ticket);
	}
	public SimpleTicket getTicket(String ticketId){
		return ticketCash.get(ticketId);
	}
}
