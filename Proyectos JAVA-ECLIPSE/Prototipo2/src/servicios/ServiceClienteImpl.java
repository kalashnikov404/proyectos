package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceCliente;
import dao.FuenteDatos;
import dao.TablaCliente;

import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;


public class ServiceClienteImpl implements ServiceCliente{

	
	private TablaCliente tablaCliente;
	
	
	public ServiceClienteImpl() throws ConexionException {
		tablaCliente=new TablaCliente(FuenteDatos.getBaseDatos().getConexion());
	}


	public String registrarClientePersona(Cliente cliente) {
		// TODO Auto-generated method stub
		return tablaCliente.registrarClientePersona(cliente);
	}


	public String registrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return tablaCliente.registrarCliente(cliente);
	}


	@Override
	public List<String> getListaClientes() {
		// TODO Auto-generated method stub
		return tablaCliente.getListaClientes();
	}


	@Override
	public List<Cliente> getClientes(Cliente cliente, String opcion) {
		// TODO Auto-generated method stub
		return tablaCliente.getClientes(cliente, opcion);
	}


	@Override
	public String modificarCliente(Cliente newcliente, Cliente oldcliente) {
		// TODO Auto-generated method stub
		return tablaCliente.modificarCliente(newcliente, oldcliente);
	}


	@Override
	public ArrayList<String> llenar_comboNombre() {
		// TODO Auto-generated method stub
		return tablaCliente.llenar_comboNombre();
	}


	@Override
	public ArrayList<String> llenar_comboDireccion() {
		// TODO Auto-generated method stub
		return tablaCliente.llenar_comboDireccion();
	}


	@Override
	public ArrayList<String> llenar_comboTelefono() {
		// TODO Auto-generated method stub
		return tablaCliente.llenar_comboTelefono();
	}


	@Override
	public ArrayList<String> llenar_comboTipo() {
		// TODO Auto-generated method stub
		return tablaCliente.llenar_comboTipo();
	}


	@Override
	public List<String> getListaTipos() {
		return tablaCliente.getListaTipos();
	}

	
	
	
}
	
	
