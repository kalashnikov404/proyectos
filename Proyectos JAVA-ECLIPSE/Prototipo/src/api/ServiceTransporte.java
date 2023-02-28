package api;

import java.util.List;

import modelo.Transporte;

public interface ServiceTransporte {

	public String registrarTransporte(Transporte transporte);
	public List<Transporte> getTransportes(Transporte transporte, String opcion);
	public List<String> getListaTransportes();
	public String modificarTransporte(Transporte newtransporte, Transporte oldtransporte);
	public List<String> getListaTipos();
	public List<String> getListaPlacas();
	public String eliminarTransporte( Transporte oldtransporte);

}
