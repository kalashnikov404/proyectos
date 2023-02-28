package api;

import modelo.Cliente;
import modelo.Garantia;
import modelo.Venta;

public interface ServiceTicket {
	
	public Venta getVenta(String fecha, String hora);
	public Cliente getCliente(String fecha, String hora);
	public Garantia getGarantia(String fecha, String hora);

}
