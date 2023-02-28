package api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import dao.TablaCalentador;
import modelo.Calentador;

public interface ServiceCalentador {

	public String registrar(Calentador calentador);
	public List<String> getListaTipos();
	public List<String> getListaDimensiones();
	public List<String> getListaNumeroCilindros();
	public List<String> getListaMarca();
	public List<String> getListaPrecio();
	public List<Calentador> getCalentadores(Calentador calentador, String opcion);
	public List<String> getListaCalentador();
	public String modificarCalentador(Calentador newcalentador, Calentador oldcalentador);
	public List<String> getListaCalentadores();
	
	public String eliminarCalentador(Calentador oldcalentador);
	
}
