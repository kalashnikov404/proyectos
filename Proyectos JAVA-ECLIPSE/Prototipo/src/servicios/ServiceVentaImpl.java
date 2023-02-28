package servicios;

import java.util.List;

import api.ServiceVenta;
import dao.FuenteDatos;
import dao.TablaTransporte;
import dao.TablaVenta;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Garantia;
import modelo.Venta;

public class ServiceVentaImpl implements ServiceVenta {
	
	private TablaVenta tablaVenta;

	public ServiceVentaImpl() throws ConexionException {
		tablaVenta=new TablaVenta(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarVentaGarantia(Garantia garantia) {
		return tablaVenta.registrarVentaGarantia(garantia);
	}

	@Override
	public String registrarVenta(Venta venta) {
		return tablaVenta.registrarVenta(venta);
	}

	@Override
	public List<Venta> getVentas(Venta venta, String opcion) {
		return tablaVenta.getVentas(venta, opcion);
	}

	@Override
	public List<String> getListaVentas() {
		return tablaVenta.getListaVentas();
	}

	@Override
	public String getCalentadorDeVenta(Venta venta) {
		return tablaVenta.getCalentadorDeVenta(venta);
	}

	@Override
	public String getClienteDeVenta() {
		return tablaVenta.getClienteDeVenta();
	}

	@Override
	public String getEmpleadoDeVenta() {
		return tablaVenta.getEmpleadoDeVenta();
	}

	@Override
	public String modificarVenta(Venta oldVenta, Venta newVenta) {
		return tablaVenta.modificarVenta(oldVenta, newVenta);
	}

	@Override
	public String getGarantiaFechas(Venta venta) {
		return tablaVenta.getGarantiaFechas(venta);
	}

	@Override
	public int getTotalCant(Calentador calentador) {
		return tablaVenta.getTotalCant(calentador);
	}

	@Override
	public void actualizarCantidad(Garantia garantia, Venta venta, int cantidadfinal) {
		tablaVenta.actualizarCantidad(garantia, venta, cantidadfinal);
		
	}

	@Override
	public void modificarCantidad(Venta oldVenta, Venta newVenta,  int antiguacant) {
		tablaVenta.modificarCantidad(oldVenta, newVenta,  antiguacant);
	}

}
