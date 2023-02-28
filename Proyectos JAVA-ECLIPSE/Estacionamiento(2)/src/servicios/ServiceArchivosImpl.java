package servicios;

import java.util.List;

import api.ServiceArchivos;
import api.ServiceCliente;
import dao.TablaArchivos;
import dao.TablaCliente;
import modelo.Csv;





public class ServiceArchivosImpl   implements ServiceArchivos{
	
	private TablaArchivos tablaArchivos;


	@Override
	public List<String> getListaCsv() {
		// TODO Auto-generated method stub
		return tablaArchivos.getListaCsv();
	}

	
	
}
