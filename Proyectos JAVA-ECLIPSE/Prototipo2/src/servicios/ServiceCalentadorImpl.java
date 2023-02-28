package servicios;

import java.util.List;

import api.ServiceCalentador;
import api.ServiceTransporte;
import dao.FuenteDatos;
import dao.TablaCalentador;
import dao.TablaTransporte;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Transporte;

public class ServiceCalentadorImpl implements ServiceCalentador{
	
	private TablaCalentador tablaCalentador;

	public ServiceCalentadorImpl() throws ConexionException {
		tablaCalentador=new TablaCalentador(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrar(Calentador calentador) {
		return tablaCalentador.registrar(calentador);
	}

	@Override
	public List<String> getListaTipos() {
		System.out.println("get lista serviceimpl");
		return tablaCalentador.getListaTipos();
	}

	@Override
	public List<String> getListaDimensiones() {
		return tablaCalentador.getListaDimensiones();
	}

	@Override
	public List<String> getListaNumeroCilindros() {
		return tablaCalentador.getListaNumeroCilindros();
	}

	@Override
	public List<String> getListaMarca() {
		return tablaCalentador.getListaMarca();
	}

	@Override
	public List<String> getListaPrecio() {
		return tablaCalentador.getListaPrecio();
	}

	@Override
	public List<Calentador> getCalentadores(Calentador calentador, String opcion) {
		return tablaCalentador.getCalentadores(calentador, opcion);
	}

	@Override
	public List<String> getListaCalentador() {
		return tablaCalentador.getListaCalentador();
	}

	@Override
	public String modificarCalentador(Calentador newcalentador, Calentador oldcalentador) {
		return tablaCalentador.modificarCalentador(newcalentador, oldcalentador);
	}

	@Override
	public List<String> getListaCalentadores() {
		return tablaCalentador.getListaCalentadores();
	}

	@Override
	public String eliminarCalentador(Calentador oldcalentador) {
		return tablaCalentador.eliminarCalentador(oldcalentador);
	}
	 
	
	

}
