package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	
	private static final String CONTROLADOR ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://92.249.45.104:3306/mendt672_cinepolis";
	private static final String USUARIO ="mendt672_alumno";
	private static final String CLAVE ="c(.#1UK44VOP";
	
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
