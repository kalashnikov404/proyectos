package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Transporte;



public interface ServiceCliente {
//
	public String registrarClientePersona(Cliente cliente);
	public String registrarCliente(Cliente cliente);
	public List<Cliente> getClientes(Cliente cliente, String opcion);
	public List<String> getListaClientes();
	 public ArrayList<String> llenar_comboNombre();
	 public ArrayList<String> llenar_comboDireccion();
	 public ArrayList<String> llenar_comboTelefono();
	 public ArrayList<String> llenar_comboTipo();
	 
	 public List<String> getListaTipos();



	
	
//	public List<Transporte> getTransportes(Transporte transporte, String opcion);
//	public List<String> getListaTransportes();
 public String modificarCliente(Cliente newcliente, Cliente oldcliente);

}
