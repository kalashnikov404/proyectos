package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaArchivos {

	

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaArchivos(Connection conexion) {
		super();
		this.conexion = conexion;
		crearSentencia();
	}


	private  void crearSentencia() {
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			statement=null;
		}
	}

	

	public List<String> getListaCsv(){

		String sql = "select *from csv";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> numeroCsv = new ArrayList<>();

			while (rs.next()) {


				String numeroCsvs = rs.getString(1);

				numeroCsv.add(numeroCsvs);
			}
			return numeroCsv;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
