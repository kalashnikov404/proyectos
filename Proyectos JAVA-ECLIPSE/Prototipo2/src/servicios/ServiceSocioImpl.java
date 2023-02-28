package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceCliente;
import api.ServiceSocio;
import dao.FuenteDatos;
import dao.TablaCliente;
import dao.TablaSocio;
import excepciones.ConexionException;
import modelo.Persona;
import modelo.Socio;



public class ServiceSocioImpl implements ServiceSocio{


	private TablaSocio tablaSocio;


	public ServiceSocioImpl() throws ConexionException {
		tablaSocio=new TablaSocio(FuenteDatos.getBaseDatos().getConexion());
	}


	public String registrarSocio(Persona persona) {
		// TODO Auto-generated method stub
		return tablaSocio.registrarSocio(persona);
	}


	public List<Persona> getSocios(Persona persona, String opcion) {
		// TODO Auto-generated method stub
		return tablaSocio.getSocios(persona, opcion);
	}


	@Override
	public List<String> getListaSocios() {
		// TODO Auto-generated method stub
		return tablaSocio.getListaSocios();
	}


	@Override
	public ArrayList<String> llenar_comboNombre() {
		// TODO Auto-generated method stub
		return tablaSocio.llenar_comboNombre();
	}


	@Override
	public ArrayList<String> llenar_comboDireccion() {
		// TODO Auto-generated method stub
		return tablaSocio.llenar_comboDireccion();
	}


	@Override
	public ArrayList<String> llenar_comboTelefono() {
		// TODO Auto-generated method stub
		return tablaSocio.llenar_comboTelefono();
	}


	@Override
	public String modificarSocio(Persona newsocio, Persona oldsocio) {
		// TODO Auto-generated method stub
		return tablaSocio.modificarSocio(newsocio, oldsocio);
	}



	@Override
	public String eliminarSocio(Persona persona, Socio socio) {
		// TODO Auto-generated method stub
		return tablaSocio.eliminarSocio(persona, socio);
	}






}