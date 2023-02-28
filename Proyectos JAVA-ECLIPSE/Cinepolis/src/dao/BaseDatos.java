package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	
	
	private static BaseDatos baseDatos;
	private Connection conexion;
	private String nombreBaseDatos;
	private String usuario;
	private String password;
	private String protocolo;
	private String driver;

	private BaseDatos(String nombre, String usuario, String password, String protocolo, String driver) {
		this.nombreBaseDatos = nombre;
		this.usuario = usuario;
		this.password = password;
		this.protocolo = protocolo;
		this.driver = driver;

	}

	public Connection getConexion() {
		return conexion;
	}

	public String hacerConexion() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(protocolo + nombreBaseDatos, usuario, password);
			return "exito";
		} catch (ClassNotFoundException e) {
			return e.toString();
		} catch (SQLException esql) {
			return esql.toString();
		}
	}

	public static BaseDatos newInstance(String nombre, String usuario, String password, String protocolo,
			String driver) {

		return baseDatos == null ? new BaseDatos(nombre, usuario, password, protocolo, driver) : baseDatos;
	}

	public void cerrar() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
