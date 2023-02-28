package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceContrato;
import dao.FuenteDatos;
import dao.TablaContrato;
import excepciones.ConexionException;
import modelo.Contrato;

public class ServiceContratoImpl implements ServiceContrato{

	private TablaContrato tablaContrato;
	
	
	public ServiceContratoImpl() throws ConexionException {
		tablaContrato=new TablaContrato(FuenteDatos.getBaseDatos().getConexion());
	}


	@Override
	public String registrarContrato(Contrato contrato) {
		// TODO Auto-generated method stub
		return tablaContrato.registrarContrato(contrato);
	}


	@Override
	public ArrayList<String> llenar_comboEmpleado() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboEmpleado();
	}


	@Override
	public ArrayList<String> llenar_comboTipo() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboTipo();
	}


	@Override
	public ArrayList<String> llenar_comboFechaFin() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboFechaFin();
	}


	@Override
	public ArrayList<String> llenar_comboFechaInicial() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboFechaInicial();
	}


	@Override
	public ArrayList<String> llenar_comboSueldo() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboSueldo();
	}


	@Override
	public ArrayList<String> llenar_comboPuesto() {
		// TODO Auto-generated method stub
		return tablaContrato.llenar_comboPuesto();
	}


	@Override
	public List<Contrato> getContratos(Contrato contrato, String opcion) {
		// TODO Auto-generated method stub
		return tablaContrato.getContratos(contrato, opcion);
	}


	@Override
	public List<String> getListaContratos() {
		// TODO Auto-generated method stub
		return tablaContrato.getListaContratos();
	}


	@Override
	public String modificarContrato(Contrato newscontrato, Contrato oldcontrato) {
		// TODO Auto-generated method stub
		return tablaContrato.modificarContrato(newscontrato, oldcontrato);
	}
	
	
	
	
}
