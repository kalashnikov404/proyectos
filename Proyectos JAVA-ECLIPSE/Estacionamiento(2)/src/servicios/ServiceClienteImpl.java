
package servicios;

import java.util.List;

import api.ServiceCliente;
import dao.FuenteDatos;
import dao.TablaCliente;
import modelo.Cliente;

public class ServiceClienteImpl implements ServiceCliente {
	
private TablaCliente tablaCliente;
	
	public ServiceClienteImpl() {
		tablaCliente=new TablaCliente(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String guardarCCV(Cliente cliente) {
		return tablaCliente.guardarCCV(cliente);
	}

	@Override
	public String guardarCeV(Cliente cliente) {
		return tablaCliente.guardarCeV(cliente);
	}

	@Override
	public String guardarCoV(Cliente cliente) {
		return tablaCliente.guardarCoV(cliente);
	}

	@Override
	public String guardarV(Cliente cliente) {
		return tablaCliente.guardarV(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		return tablaCliente.getClientes();
	}

	@Override
	public Cliente consultarPorId(int id) {
		return tablaCliente.consultarPorId(id);
	}

	@Override
	public String modificarCelular(int idCliente, String celular) {
		return tablaCliente.modificarCelular(idCliente, celular);
	}

	@Override
	public String modificarCorreo(int idCliente, String correo) {
		return tablaCliente.modificarCorreo(idCliente, correo);
	}

	@Override
	public String eliminarCliente(int idCliente) {
		return tablaCliente.eliminarCliente(idCliente);
	}

}
