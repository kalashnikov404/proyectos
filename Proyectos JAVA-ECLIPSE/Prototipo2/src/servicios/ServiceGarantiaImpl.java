package servicios;

import java.util.List;

import api.ServiceGarantia;
import dao.FuenteDatos;
import dao.TablaGarantia;
import dao.TablaHorario;
import excepciones.ConexionException;
import modelo.Garantia;
import modelo.Venta;

public class ServiceGarantiaImpl implements ServiceGarantia{
	
	private TablaGarantia tablaGarantia;

	public ServiceGarantiaImpl() throws ConexionException {
		tablaGarantia=new TablaGarantia(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public List<String> getListaGarantias() {
		return tablaGarantia.getListaGarantias();
	}

	@Override
	public List<Garantia> getGarantia(Garantia garantia, String opcion) {
		return tablaGarantia.getGarantia(garantia, opcion);
	}

	@Override
	public String modificarGarantia(Venta oldVenta, Venta newVenta, Garantia garantia) {
		return tablaGarantia.modificarGarantia(oldVenta, newVenta, garantia);
	}

}
