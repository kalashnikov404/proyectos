package servicios;

import java.util.List;

import api.ServiceEmpleado;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Persona;

public class ServiceEmpleadoImpl implements ServiceEmpleado {
	private TablaEmpleado tablaEmpleado;
	
	public ServiceEmpleadoImpl() throws ConexionException {
		tablaEmpleado=new TablaEmpleado(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarPersona(Persona persona) {
		return tablaEmpleado.registrarPersona(persona);
	}

	@Override
	public String registrarEmpleado(Empleado emp) {
		return tablaEmpleado.registrarEmpleado(emp);
	}

	@Override
	public List<String> getListaNombre() {
		return tablaEmpleado.getListaNombre();
	}

	@Override
	public List<String> getListaDireccion() {
		return tablaEmpleado.getListaDireccion();
	}

	@Override
	public List<String> getListaTelefono() {
		return tablaEmpleado.getListaTelefono();
	}

	@Override
	public List<String> getListaRfc() {
		return tablaEmpleado.getListaRfc();
	}

	@Override
	public List<String> getListaCurp() {
		return tablaEmpleado.getListaCurp();
	}

	@Override
	public List<String> getListaNumSeg() {
		return tablaEmpleado.getListaNumSeg();
	}

	@Override
	public List<Empleado> getEmpleado(Empleado empleado, String opcion) {
	return tablaEmpleado.getEmpleado(empleado, opcion);
	}

	@Override
	public List<String> getListaEmpleado() {
		return tablaEmpleado.getListaEmpleado();
	}

	@Override
	public String modificarPersona(Persona newpersona, Persona oldpersona) {
		return tablaEmpleado.modificarPersona(newpersona, oldpersona);
	}

	@Override
	public String modificarEmpleado(Empleado newempleado, Empleado oldempleado) {
		return tablaEmpleado.modificarEmpleado(newempleado, oldempleado);
	}

}
