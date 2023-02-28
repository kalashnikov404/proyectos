package api;

import java.util.List;

import modelo.Persona;
import modelo.Proveedor;

public interface ServiceProveedor {
	String registrarPersona(Persona persona);
	String registrarProveedor(Proveedor prov);
	List<Proveedor> getProveedor(Proveedor provedor, String opcion);
	List<String> getListaPersona();
	List<String> getListaProveedor();
	String modificarPersona(Persona newpersona, Persona oldpersona);
	String modificarProveedor(Proveedor newproveedor, Proveedor oldproveedor);
	List<String> getListaRazonSocial();
	List<String> getListaEmail();
	List<String> getListaNombre();
	public String eliminarProveedor(Persona persona, Proveedor proveedor);

}
