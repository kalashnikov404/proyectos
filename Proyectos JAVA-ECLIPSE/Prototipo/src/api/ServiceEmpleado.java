package api;

import java.util.List;

import modelo.Empleado;
import modelo.Persona;

public interface ServiceEmpleado {
	String registrarPersona(Persona persona);
	String registrarEmpleado(Empleado emp);
	List<String> getListaNombre();
	List<String> getListaDireccion();
	List<String> getListaTelefono();
	List<String> getListaRfc();
	List<String> getListaCurp();
	List<String> getListaNumSeg();
	List<Empleado> getEmpleado(Empleado empleado, String opcion);
	List<String> getListaEmpleado();
	String modificarPersona(Persona newpersona, Persona oldpersona);
	String modificarEmpleado(Empleado newempleado, Empleado oldempleado);
	
}
