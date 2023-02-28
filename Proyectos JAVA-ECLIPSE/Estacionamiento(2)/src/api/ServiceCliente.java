package api;

import java.util.List;

import modelo.Cliente;

public interface ServiceCliente {
	
	String guardarCCV(Cliente cliente);
	String guardarCeV(Cliente cliente);
	String guardarCoV(Cliente cliente);
	String guardarV(Cliente cliente);
	public List<Cliente> getClientes();
	public Cliente consultarPorId(int id);
	public String modificarCelular(int idCliente, String celular);
	public String modificarCorreo(int idCliente, String correo);
	public String eliminarCliente(int idCliente);
	

}
