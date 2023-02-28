package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Boleto;
import modelo.Pelicula;

public class TablaResurtido {

	private Connection conexion;
	private Statement  statement;
		
	public TablaResurtido(Connection conexion) {
		this.conexion = conexion;
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
//
////
//	public String guardar1(Boleto boleto) {
//		String sql = "insert into boleto values(null, now(), '" + boleto.getPrecio() + "', '" + boleto.getTipo() + "', '"+ cafecito.getNumero() + "','" 
//				+ cafecito.getOrientacion() + "', '" + cafecito.getCveCol() +"')";
//	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
////				cafecito.getOrientacion()+"')";
//		
//		try {
//			statement.executeUpdate(sql);
//			return "exito";
//		
//		} catch (SQLException e) {
//			System.out.println(e.toString());
//			System.out.println("es aqui");
//			return sql.toString();
//		}
//	}
	
	
	

	
	 public ArrayList<String> llenar_comboProveedor(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = "select cve_prov, nombre_prov from proveedor;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        String si="Seleccione una opcion";
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	            	
	            	lista3.add(rs.getString("cve_prov" )+ " - " + rs.getString("nombre_prov"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	
	 

		
	 public ArrayList<String> llenar_comboSucursal(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = " select cve_suc, calle_suc from sucursal;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("cve_suc" )+ " - " + rs.getString("calle_suc"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	
	 

		
	 public ArrayList<String> llenar_comboResurtido(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select cve_res, fecha_res from resurtir;;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add( rs.getString("cve_res" )+ " - " + rs.getString("fecha_res"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 

		
	 public ArrayList<String> llenar_comboBotana(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select cve_bot, nombre_bot from botana;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add( rs.getString("cve_bot" )+ " - " + rs.getString("nombre_bot"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
}
