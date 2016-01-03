package rs.slavko.tutorials.jpa.services.authentication.ticket;

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
	
	public String validateTicket(SimpleTicket ticket){
		String ticketId = ticket.getTicketId();
		SimpleTicket inMemoryTicket = ticketCash.getTicket(ticketId);
		if(inMemoryTicket!=null){
			return inMemoryTicket.getUserName();
		}
		return null;
	}
}
