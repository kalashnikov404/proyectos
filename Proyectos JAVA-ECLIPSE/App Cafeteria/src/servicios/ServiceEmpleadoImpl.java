package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceEmpleado;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import modelo.Empleado;



public class ServiceEmpleadoImpl implements ServiceEmpleado {


	private TablaEmpleado tablaEmpleado;
	
	public ServiceEmpleadoImpl() {
		tablaEmpleado=new TablaEmpleado(FuenteDatos.getBaseDatos().getConexion());

	}
	
	
	@Override
	public String guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return tablaEmpleado.guardarEmpleado(empleado);
	}

	@Override
	public List<String> getEmpleados() {
		// TODO Auto-generated method stub
		return tablaEmpleado.getEmpleados();
	}

	@Override
	public Empleado consultarPorFolio(int folio) {
		// TODO Auto-generated method stub
		return tablaEmpleado.consultarPorFolio(folio);
	}

	@Override
	public String eliminarEmpleado(int folio) {
		// TODO Auto-generated method stub
		return tablaEmpleado.eliminarEmpleado(folio);
	}


	@Override
	public List<Empleado> getEmpleados2() {
		// TODO Auto-generated method stub
		return tablaEmpleado.getEmpleados2();
	}


	@Override
	public String guardarEmpleadoPersona(Empleado empleado) {
		// TODO Auto-generated method stub
		return tablaEmpleado.guardarEmpleadoPersona(empleado);
	}


	@Override
	public ArrayList<String> llenar_comboPersona() {
		// TODO Auto-generated method stub
		return tablaEmpleado.llenar_comboPersona();
	}
	
	
	@Override
	public ArrayList<String> llenar_comboCafecito() {
		// TODO Auto-generated method stub
		return tablaEmpleado.llenar_comboCafecito();
	}


	@Override
	public List<Empleado> consultarPorDatosPersona(String id, String nombre, String paterno, String materno,
			String calle, String numero, String orientacion, String nacimiento, String genero, String telefono,
			String idColonia) {
		// TODO Auto-generated method stub
		return tablaEmpleado.consultarPorDatosPersona(id, nombre, paterno, materno, calle, numero, orientacion, nacimiento, genero, telefono, idColonia);
	}


	@Override
	public List<Empleado> consultarPorDatosContrato(String folio, String rfc, String finicio, String ffinal,
			String sueldo, String puesto, String claveCafecito) {
		// TODO Auto-generated method stub
		return tablaEmpleado.consultarPorDatosContrato(folio, rfc, finicio, ffinal, sueldo, puesto, claveCafecito);
	}
	
	
	
	

	
	

}
