package servicios;

import api.ServiceUsuarios;
import dao.FuenteDatos;
import dao.TablaCalentador;
import dao.TablaUsuarios;
import excepciones.ConexionException;

public class ServiceUsuariosImpl implements ServiceUsuarios{
	
	private TablaUsuarios tablaUsuarios;

	public ServiceUsuariosImpl() throws ConexionException {
		tablaUsuarios=new TablaUsuarios(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String getUsuario(String usuario, String contrasenia) {
		return tablaUsuarios.getUsuario(usuario, contrasenia);
	}

}
