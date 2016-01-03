package templateapp.core.service.authentication;

import templateapp.core.model.ticket.InMemoryTicketCash;
import templateapp.core.model.ticket.SimpleTicket;

public class TicketService {
	
	private InMemoryTicketCash ticketCash;
	
	public InMemoryTicketCash getTicketCash() {
		return ticketCash;
	}

	public void setTicketCash(InMemoryTicketCash ticketCash) {
		this.ticketCash = ticketCash;
	}

	public TicketService(){
		
	}
	
	public String validateTicket(String ticket){
		SimpleTicket inMemoryTicket = ticketCash.getTicket(ticket);
		if(inMemoryTicket!=null){
			return inMemoryTicket.getUserName();
		}
		return null;
	}
	
	public SimpleTicket generateTicket(String username){
		SimpleTicket ticket = new SimpleTicket(username);
		ticketCash.addTicket(ticket);
		return ticket;
		
	}
}
