package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Contrato;

public interface ServiceContrato {

	
	public String registrarContrato(Contrato contrato);
	public List<Contrato> getContratos(Contrato contrato, String opcion);
	public List<String> getListaContratos();
	public String modificarContrato(Contrato newscontrato, Contrato oldcontrato);

	
	
	 public ArrayList<String> llenar_comboEmpleado();
	 public ArrayList<String> llenar_comboTipo();
	 public ArrayList<String> llenar_comboFechaFin();
	 public ArrayList<String> llenar_comboFechaInicial();
	 public ArrayList<String> llenar_comboSueldo();
	 public ArrayList<String> llenar_comboPuesto();


	
	
}
