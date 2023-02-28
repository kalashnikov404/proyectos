package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Empleado;
public interface ServiceEmpleado {

	


	public String guardarEmpleado(Empleado empleado);
	public String guardarEmpleadoPersona(Empleado empleado);

	public List<Empleado> consultarPorDatosContrato(String folio, String rfc, String finicio, String ffinal, String sueldo, String puesto, String claveCafecito);
	public List<Empleado> consultarPorDatosPersona(String id, String nombre, String paterno, String materno, String calle, String numero, String orientacion, String nacimiento, String genero, String telefono, String idColonia);

	 public ArrayList<String> llenar_comboPersona();
	 public ArrayList<String> llenar_comboCafecito();


	//public List<Empleado> getEmpleados();
	public List<String> getEmpleados();
	public List<Empleado> getEmpleados2();


	
	public Empleado consultarPorFolio(int folio);


	public String eliminarEmpleado(int folio);
	

}
