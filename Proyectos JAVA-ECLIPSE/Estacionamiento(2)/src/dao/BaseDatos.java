package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	private Connection conexion;
	private String nombreBaseDatos;
	private String usuario;
	private String password;
	private String protocolo;
	private String driver;
	
	public BaseDatos(String nombreBaseDatos, String usuario, String password) {
		super();
		this.nombreBaseDatos = nombreBaseDatos;
		this.usuario = usuario;
		this.password = password;
	}
	
	public String hacerConexion() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(protocolo + nombreBaseDatos, usuario, password);
			return "exito";
		} catch (ClassNotFoundException e) {
			return e.toString();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.toString();
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