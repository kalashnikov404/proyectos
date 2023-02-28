package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Cafecito;
import modelo.Empleado;
import modelo.Lugar;
import dao.TablaCafecito;


public interface ServiceLugar {
	

	public String guardarLugar(Lugar lugar);
	public String guardarLugarCafecito(Lugar lugar);
	public String guardarLugarEmpleado(Lugar lugar);


	
	 public ArrayList<String> llenar_comboPersona();
	 public ArrayList<String> llenar_comboCafecito();


	//public List<Empleado> getEmpleados();
	public List<Lugar> getLugares();

	 public List<Lugar> consultarPorDatosMesa(String id, String capacidad);
	 public List<Lugar> consultarPorDatosMesaCafecito(String numero, String ubicacion, String claveCafecito);
	 public List<Lugar> consultarPorDatosMesaContrato(String mesaContrato, String fecha, String folio);

	 
	 public Lugar consultarPorClaveMesa(int mesa);
	 public String eliminarMesa(int mesa );
	 public String eliminarMesaContrato(int mesaContrato);
	 public String eliminarMesaCafecito(int mesaCafecito);


	
	public Empleado consultarPorFolio(int folio);


	public String eliminarEmpleado(int folio);
	


}
