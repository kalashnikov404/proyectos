package servicios;

import java.util.List;

import api.ServiceTrabajo;
import dao.FuenteDatos;
import dao.TablaTrabajo;
import dao.TablaTransporte;
import excepciones.ConexionException;
import modelo.Trabajo;

public class ServiceTrabajoImpl implements ServiceTrabajo{
	
	private TablaTrabajo tablaTrabajo;

	public ServiceTrabajoImpl() throws ConexionException {
		tablaTrabajo=new TablaTrabajo(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarTrabajo(Trabajo trabajo) {
		return tablaTrabajo.registrarTrabajo(trabajo);
	}

	@Override
	public List<String> getListaTipos() {
		return tablaTrabajo.getListaTipos();
	}

	@Override
	public List<String> getListaTrabajosConTransporte() {
		return tablaTrabajo.getListaTrabajosConTransporte();
	}

	@Override
	public List<String> getListaTrabajosSinTransporte() {
		return tablaTrabajo.getListaTrabajosSinTransporte();
	}

	@Override
	public String modificarTrabajo(Trabajo newtrabajo, Trabajo oldtrabajo) {
		return tablaTrabajo.modificarTrabajo(newtrabajo, oldtrabajo);
	}

	@Override
	public String getEmpleadoCB(String rfc) {
		return tablaTrabajo.getEmpleadoCB(rfc);
	}

	@Override
	public String getTransporteCB(String placas) {
		return tablaTrabajo.getTransporteCB(placas);
	}

	@Override
	public List<Trabajo> getTrabajo(Trabajo trabajo, String opcion) {
		return tablaTrabajo.getTrabajo(trabajo, opcion);
	}

}
