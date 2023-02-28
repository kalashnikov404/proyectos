package servicios;

import java.util.List;

import api.ServiceArchivos;
import api.ServiceCliente;
import dao.FuenteDatos;
import dao.TablaArchivos;
import dao.TablaCliente;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Csv;
import modelo.Json;





public class ServiceArchivosImpl   implements ServiceArchivos{
	
	private TablaArchivos tablaArchivos;

	public ServiceArchivosImpl() throws ConexionException {
		tablaArchivos=new TablaArchivos(FuenteDatos.getBaseDatos().getConexion());
	}


	

	@Override
	public List<Csv> getCsvs() {
		return tablaArchivos.getArchivos();
	}



	@Override
	public List<Json> getJsons() {
		return tablaArchivos.getArchivos2();
	}
	
	
	
	
}
