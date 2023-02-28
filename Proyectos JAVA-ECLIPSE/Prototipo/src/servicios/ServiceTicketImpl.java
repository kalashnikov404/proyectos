package servicios;

import api.ServiceTicket;
import dao.FuenteDatos;
import dao.TablaCalentador;
import dao.TablaTicket;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Garantia;
import modelo.Venta;

public class ServiceTicketImpl implements ServiceTicket{
	
	private TablaTicket tablaTicket;

	public ServiceTicketImpl() throws ConexionException {
		tablaTicket=new TablaTicket(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public Venta getVenta(String fecha, String hora) {
		return tablaTicket.getVenta(fecha, hora);
	}

	@Override
	public Cliente getCliente(String fecha, String hora) {
		return tablaTicket.getCliente(fecha, hora);
	}

	@Override
	public Garantia getGarantia(String fecha, String hora) {
		return tablaTicket.getGarantia(fecha, hora);
	}

}
