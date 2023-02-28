package api;

import java.util.List;

import modelo.Calentador;
import modelo.Garantia;
import modelo.Venta;

public interface ServiceVenta {
	
	public String registrarVentaGarantia(Garantia garantia);
	public String registrarVenta(Venta venta);
	public List<Venta> getVentas(Venta venta, String opcion);
	public List<String> getListaVentas();
	public String getCalentadorDeVenta(Venta venta);
	public String getClienteDeVenta();
	public String getEmpleadoDeVenta();
	public String modificarVenta(Venta oldVenta, Venta newVenta);
	public String getGarantiaFechas(Venta venta);
	
	public int getTotalCant(Calentador calentador);
	public void actualizarCantidad(Garantia garantia, Venta venta, int cantidadfinal);
	
	public void modificarCantidad(Venta oldVenta, Venta newVenta, int antiguacant);

}
