package servicios;

import api.ServiceRenglonTicket;
import dao.FuenteDatos;
import dao.TablaRenglonTicket;
import dao.TablaTicket;
import modelo.RenglonTicket;
import modelo.Ticket;

public class ServiceRenglonTicketImpl implements ServiceRenglonTicket {
	
	private TablaRenglonTicket tablaRenglonTicket;
	
	public ServiceRenglonTicketImpl() {
		tablaRenglonTicket=new TablaRenglonTicket(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String guardar(Ticket ticket) {
		return tablaRenglonTicket.guardar(ticket);
	}

	@Override
	public String eliminar(int idTicket, int idServicio) {
		return tablaRenglonTicket.eliminar(idTicket, idServicio);
	}

	@Override
	public String guardarCnIdTicket(RenglonTicket renglonTicket, int idTicket) {
		return tablaRenglonTicket.guardarCnIdTicket(renglonTicket, idTicket);
	}

}
