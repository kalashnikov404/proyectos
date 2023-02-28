package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Cafecito;
import modelo.Ciudad;

public class TablaCiudad {


	private Connection conexion;
	private Statement statement;
	int valor =0;

	public TablaCiudad(Connection conexcion) {
		this.conexion=conexcion;
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

	

//
	public String guardarCiudad(Ciudad ciudad) {
		String sql = "insert into ciudad values('" + generaI(valor) + "', '" + ciudad.getCiudad() + "', '"+ ciudad.getMunicipio() + "',null)";
	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//				cafecito.getOrientacion()+"')";
		
		try {
			statement.executeUpdate(sql);
			return "exito";
		
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("es aqui ciudad");

			return sql.toString();
		}
	}

	public String guardarCiudadCP(Ciudad ciudad) {
		String sql = "insert into codigopostal values('" + ciudad.getCp()  + "',null)";
	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//				cafecito.getOrientacion()+"')";
		
		try {
			statement.executeUpdate(sql);
			return "exito";
		
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("es aqui cp");

			return sql.toString();
		}
	}

	public String guardarCiudadColonia(Ciudad ciudad) {
		String sql = "insert into colonia values('" + generaI(valor) + "', '" + ciudad.getColonia() + "','"+ ciudad.getAsentamiento()
		+ "', '" + ciudad.getZona() + "',null)";
	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//				cafecito.getOrientacion()+"')";
		
		try {
			statement.executeUpdate(sql);
			return "exito";
		
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("es aqui colonia");

			return sql.toString();
		}
	}

	public String guardarCiudadEstado(Ciudad ciudad) {
		String sql = "insert into estado values('" + generaI(valor) + "','" +  ciudad.getEstado() +"')";
	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//				cafecito.getOrientacion()+"')";
		
		try {
			statement.executeUpdate(sql);
			return "exito";
		
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("es aqui estado");

			return sql.toString();
		}
	}

	
	public List<Ciudad> getCiudades(){
		String sql ="select nom_ciu, mun_ciu, nom_col, tipoasen_col, zona_col, nom_edo from ciudad, colonia, estado;";
		System.out.println(sql);
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Ciudad> ciudades = new ArrayList<>();
			while (rs.next()) {
				Ciudad ciudad=new Ciudad();
				ciudad.setCiudad(rs.getString("nom_ciu"));
				ciudad.setMunicipio(rs.getString("mun_ciu"));
				
			//	ciudad.setCp(rs.getInt("cve_cp"));
				
				ciudad.setColonia(rs.getString("nom_col"));
				ciudad.setAsentamiento(rs.getString("tipoasen_col"));
				ciudad.setZona(rs.getString("zona_col"));
				
				ciudad.setEstado(rs.getString("nom_edo"));
				
				ciudades.add(ciudad);
			}
			return ciudades;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	
public int generaI(int valor) {
	int numeroAleatorio = (int) (Math.random()*25+1);
	return numeroAleatorio;
	
}
}
