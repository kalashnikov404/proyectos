package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexion {
	
	private static final String CONTROLADOR ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/estacionamiento";
	private static final String USUARIO ="root";
	private static final String CLAVE ="teamojano";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		}catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			
			
			conexion=DriverManager.getConnection(URL, USUARIO, CLAVE);
			
			System.out.println("Conexion ok");
		
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		
		return conexion;
	}

}
