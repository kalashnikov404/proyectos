package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Persona;
import modelo.Socio;

public interface ServiceSocio {



	public String registrarSocio(Persona persona);
	public List<Persona> getSocios(Persona persona, String opcion);
	public List<String> getListaSocios();
	public ArrayList<String> llenar_comboNombre();
	public ArrayList<String> llenar_comboDireccion();
	public ArrayList<String> llenar_comboTelefono();


	public String modificarSocio(Persona newsocio, Persona oldsocio);
	public String eliminarSocio(Persona persona, Socio socio);



}