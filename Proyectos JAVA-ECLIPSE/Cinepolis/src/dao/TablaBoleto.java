package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Boleto;
import modelo.Pelicula;

public class TablaBoleto {

	private Connection conexion;
	private Statement  statement;
		
	public TablaBoleto(Connection conexion) {
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
	
	
	

	
	 public ArrayList<String> llenar_comboEmpleado(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = "select num_empta, nom_per, ap_per from empleadotaquilla, persona, contrato where persona.curp_per=contrato.curp_per && contrato.folio_con=empleadotaquilla.folio_con;";
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

	            	
	            	lista3.add(rs.getString("num_empta" )+ " - " + rs.getString("nom_per")+ " - " + rs.getString("ap_per"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	
	 

		
	 public ArrayList<String> llenar_comboPelicula(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select cve_pel, nombre_pel from pelicula;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("cve_pel" )+ " - " + rs.getString("nombre_pel"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	
	 

		
	 public ArrayList<String> llenar_comboSala(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select cve_sal, tipo_sal, cve_suc from sala;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add( rs.getString("cve_sal" )+ " - " + rs.getString("tipo_sal")+  " - " + "Suc: " + rs.getString("cve_suc"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 
	 
	
}
