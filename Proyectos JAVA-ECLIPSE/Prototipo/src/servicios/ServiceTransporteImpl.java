package servicios;

import java.util.List;

import api.ServiceTransporte;
import dao.FuenteDatos;
import dao.TablaTransporte;
import excepciones.ConexionException;
import modelo.Transporte;

public class ServiceTransporteImpl implements ServiceTransporte{
	
	private TablaTransporte tablaTransporte;

	public ServiceTransporteImpl() throws ConexionException {
		tablaTransporte=new TablaTransporte(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarTransporte(Transporte transporte) {
		return tablaTransporte.registrarTransporte(transporte);
	}

	@Override
	public List<Transporte> getTransportes(Transporte transporte, String opcion) {
		return tablaTransporte.getTransportes(transporte, opcion);
	}

	@Override
	public String modificarTransporte(Transporte newtransporte, Transporte oldtransporte) {
		return tablaTransporte.modificarTransporte(newtransporte, oldtransporte);
	}

	@Override
	public List<String> getListaTransportes() {
		return tablaTransporte.getListaTransportes();
	}

	@Override
	public List<String> getListaTipos() {
		return tablaTransporte.getListaTipos();
	}

	@Override
	public List<String> getListaPlacas() {
		return tablaTransporte.getListaPlacas();
	}

	@Override
	public String eliminarTransporte(Transporte oldtransporte) {
		return tablaTransporte.eliminarTransporte( oldtransporte);
	}

}
