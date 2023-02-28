package api;

import java.util.List;

import dao.FuenteDatos;
import dao.TablaCliente;
import modelo.Cliente;
import modelo.Csv;
import modelo.Json;

public interface ServiceArchivos {

	
	public List<Csv> getCsvs();
	
	
	public List<Json> getJsons();

	
	
	
}
