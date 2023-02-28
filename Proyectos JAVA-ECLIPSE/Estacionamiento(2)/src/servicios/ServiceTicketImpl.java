package servicios;

import api.ServiceTicket;
import dao.FuenteDatos;
import dao.TablaCliente;
import dao.TablaTicket;
import modelo.Ticket;

public class ServiceTicketImpl implements ServiceTicket{
	
	private TablaTicket tablaTicket;
	
	public ServiceTicketImpl() {
		tablaTicket=new TablaTicket(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String guardar(Ticket ticket) {
		return tablaTicket.guardar(ticket);
	}

	@Override
	public int obtenerIdTicket(Ticket ticket) {
		return tablaTicket.obtenerIdTicket(ticket);
	}

	@Override
	public int obtenerIdTicketRecienteCnPlc(String placas) {
		return tablaTicket.obtenerIdTicketRecienteCnPlc(placas);
	}

}
