package api;

import modelo.RenglonTicket;
import modelo.Ticket;

public interface ServiceRenglonTicket {
	
	String guardar(Ticket ticket);
	public String eliminar(int idTicket, int idServicio);
	public String guardarCnIdTicket(RenglonTicket renglonTicket, int idTicket);

}
