package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Orden;

public interface ServiceOrden {

	
	public List<Orden> getOrdenes();
	 public ArrayList<String> llenar_comboEmpleado();
	 public ArrayList<String> llenar_comboPlatillo();
	 public ArrayList<String> llenar_comboMesaContrato();

}
