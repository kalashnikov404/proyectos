package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Cliente;
import modelo.Csv;
import modelo.Json;

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

	
	public List<Csv> getArchivos(){
		String sql = "select *from csv";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Csv> csvs = new ArrayList<>();
			while (rs.next()) {
				Csv csv = new Csv();
				
				
				csv.setId(rs.getInt(1));
				csv.setPoblacion(rs.getString(2));
				csv.setNombre(rs.getString(3));
				csv.setF1(rs.getString(4));
				csv.setF2(rs.getString(5));
				csv.setF3(rs.getString(6));
				csv.setF4(rs.getString(7));
				csv.setF5(rs.getString(8));
				csv.setF6(rs.getString(9));
				csv.setF7(rs.getString(10));
				csv.setF8(rs.getString(11));
				csv.setF9(rs.getString(12));
				csv.setF10(rs.getString(13));
				csv.setF11(rs.getString(14));
				csv.setF12(rs.getString(15));
				csv.setF13(rs.getString(16));
				csv.setF14(rs.getString(17));
				csv.setF15(rs.getString(18));

				
				
				csvs.add(csv);
			}
			return csvs;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	

	
	public List<Json> getArchivos2(){
		String sql = "select *from json";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Json> jsons = new ArrayList<>();
			while (rs.next()) {
				Json jsonn = new Json();
				
				
				jsonn.setId(rs.getInt(1));
				jsonn.setNombreEs(rs.getString(2));
				jsonn.setSiglas(rs.getString(3));
				jsonn.setPrefijo(rs.getString(4));
				jsonn.setNombreUs(rs.getString(5));
			
				
				
				jsons.add(jsonn);
			}
			return jsons;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	
	
	
	
}
