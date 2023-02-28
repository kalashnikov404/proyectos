package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceEmpleado;
import api.ServiceLugar;
import modelo.Empleado;
import modelo.Lugar;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import dao.TablaLugar;

public class ServiceLugarImpl implements ServiceLugar {


	private TablaLugar tablaLugar;
	
	public ServiceLugarImpl() {
		tablaLugar=new TablaLugar(FuenteDatos.getBaseDatos().getConexion());

	}
	
	
	
	@Override
	public String guardarLugar(Lugar lugar) {
		// TODO Auto-generated method stub
		return tablaLugar.guardarLugar(lugar);
	}

	@Override
	public String guardarLugarCafecito(Lugar lugar) {
		// TODO Auto-generated method stub
		return tablaLugar.guardarLugarCafecito(lugar);

	}

	@Override
	public String guardarLugarEmpleado(Lugar lugar) {
		// TODO Auto-generated method stub
		return tablaLugar.guardarLugarEmpleado(lugar);
	}

	@Override
	public ArrayList<String> llenar_comboPersona() {
		// TODO Auto-generated method stub
		return tablaLugar.llenar_comboEmpleado();
	}

	@Override
	public ArrayList<String> llenar_comboCafecito() {
		// TODO Auto-generated method stub
		return tablaLugar.llenar_comboCafecito();
	}

	@Override
	public List<Lugar> getLugares() {
		// TODO Auto-generated method stub
		return tablaLugar.getLugares();
	}

	@Override
	public Empleado consultarPorFolio(int folio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarEmpleado(int folio) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Lugar> consultarPorDatosMesa(String id, String capacidad) {
		// TODO Auto-generated method stub

	return tablaLugar.consultarPorDatosMesa(id, capacidad);
	}



	@Override
	public List<Lugar> consultarPorDatosMesaCafecito(String numero, String ubicacion, String claveCafecito) {
		// TODO Auto-generated method stub
		return tablaLugar.consultarPorDatosMesaCafecito(numero, ubicacion, claveCafecito);
	}



	@Override
	public List<Lugar> consultarPorDatosMesaContrato(String mesaContrato, String fecha, String folio) {
		// TODO Auto-generated method stub
		return tablaLugar.consultarPorDatosMesaContrato(mesaContrato, fecha, folio);
	}



	@Override
	public String eliminarMesa(int mesa) {
		// TODO Auto-generated method stub
		return tablaLugar.eliminarMesa(mesa);
	}



	@Override
	public Lugar consultarPorClaveMesa(int mesa) {

		
		// TODO Auto-generated method stub
	return tablaLugar.consultarPorClaveMesa(mesa);
	}



	

	@Override
	public String eliminarMesaContrato(int mesaContrato) {
		// TODO Auto-generated method stub
		return tablaLugar.eliminarMesaContrato(mesaContrato);
	}



	@Override
	public String eliminarMesaCafecito(int mesaCafecito) {
		// TODO Auto-generated method stub
		return tablaLugar.eliminarMesaCafecito(mesaCafecito);
	}
	

}
