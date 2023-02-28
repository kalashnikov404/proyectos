package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import excepciones.ConexionException;

public class BaseDatos2 {

	private Connection conexion;
	private String nombreBaseDatos;
	private String usuario;
	private String password;
	private String protocolo;
	private String driver;
	
	public BaseDatos2(String nombreBaseDatos, String usuario, String password) {
		super();
		this.nombreBaseDatos = nombreBaseDatos;
		this.usuario = usuario;
		this.password = password;
	}
	
	public String hacerConexion() throws ConexionException {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(protocolo + nombreBaseDatos, usuario, password);
			return "exito";
		} catch (ClassNotFoundException | SQLException e ) {
			throw new ConexionException("Error "+e.getMessage());
		}
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Connection getConexion() {
		return conexion;
	}
	
	
}
