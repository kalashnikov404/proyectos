package api;

import modelo.Ticket;

public interface ServiceTicket {
	

	String guardar(Ticket ticket);
	public int obtenerIdTicket(Ticket ticket);
	public int obtenerIdTicketRecienteCnPlc(String placas);

}
