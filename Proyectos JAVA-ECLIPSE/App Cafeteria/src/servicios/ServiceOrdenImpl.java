package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceOrden;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import dao.TablaOrden;
import modelo.Orden;
public class ServiceOrdenImpl implements ServiceOrden{

	

	private TablaOrden tablaOrden;
	
	public ServiceOrdenImpl() {
		tablaOrden=new TablaOrden(FuenteDatos.getBaseDatos().getConexion());

	}
	
	@Override
	public List<Orden> getOrdenes() {
		// TODO Auto-generated method stub
		return tablaOrden.getOrdenes();
	}

	@Override
	public ArrayList<String> llenar_comboEmpleado() {
		// TODO Auto-generated method stub
		return tablaOrden.llenar_comboEmpleado();
	}

	@Override
	public ArrayList<String> llenar_comboPlatillo() {
		// TODO Auto-generated method stub
		return tablaOrden.llenar_comboPlatillo();
	}

	@Override
	public ArrayList<String> llenar_comboMesaContrato() {
		// TODO Auto-generated method stub
		return tablaOrden.llenar_comboMesaContrato();
	}

	
	
	
	
}
