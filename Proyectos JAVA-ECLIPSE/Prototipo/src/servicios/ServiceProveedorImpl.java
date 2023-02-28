package servicios;

import java.util.List;

import api.ServiceProveedor;
import dao.FuenteDatos;
import dao.TablaProveedor;
import excepciones.ConexionException;
import modelo.Persona;
import modelo.Proveedor;

public class ServiceProveedorImpl implements ServiceProveedor {

	private TablaProveedor tablaProveedor;

	public ServiceProveedorImpl() throws ConexionException {
		tablaProveedor=new TablaProveedor(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarPersona(Persona persona) {
		return tablaProveedor.registrarPersona(persona);
	}

	@Override
	public String registrarProveedor(Proveedor prov) {
		return tablaProveedor.registrarProveedor(prov);
	}

	@Override
	public List<String> getListaPersona() {
		return tablaProveedor.getListaPersona();
	}

	@Override
	public List<String> getListaProveedor() {
		return tablaProveedor.getListaProveedor();
	}

	@Override
	public String modificarPersona(Persona newpersona, Persona oldpersona) {
		return tablaProveedor.modificarPersona(newpersona, oldpersona);
	}

	@Override
	public String modificarProveedor(Proveedor newproveedor, Proveedor oldproveedor) {
		return tablaProveedor.modificarProveedor(newproveedor, oldproveedor);
	}

	@Override
	public List<Proveedor> getProveedor(Proveedor provedor, String opcion) {
		return tablaProveedor.getProveedor(provedor, opcion);
	}

	@Override
	public List<String> getListaRazonSocial() {
		return tablaProveedor.getListaRazonSocial();
	}

	@Override
	public List<String> getListaEmail() {
		return tablaProveedor.getListaEmail();
	}

	@Override
	public List<String> getListaNombre() {
		return tablaProveedor.getListaNombre();
	}

	@Override
	public String eliminarProveedor(Persona persona, Proveedor proveedor) {
		return tablaProveedor.eliminarProveedor(persona, proveedor);
	}

	
}
