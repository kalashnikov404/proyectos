package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Orden;
import modelo.Platillo;

public class TablaOrden {
	private Connection conexion;
	private Statement statement;
	int valor =0;

	public TablaOrden(Connection conexcion) {
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
	
	
	
	
	public List<Orden> getOrdenes(){
		String sql = "select orden.cve_ord, orden.num_mescon, orden.cve_caf, detalleorden.cant_detord, detalleorden.cve_pla, detalleorden.pventa_detord, ticket.fecha_tic, ticket.total_tic, preparar.folio_con from orden, detalleorden, ticket, preparar where orden.cve_ord=detalleorden.cve_ord && detalleorden.cve_ord=ticket.cve_ord && detalleorden.num_detord=preparar.num_detord;";
		System.out.println(sql);
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Orden> ordenes = new ArrayList<>();
			while (rs.next()) {
				
				Orden orden =new Orden();
			
				
				orden.setClaveOrden(rs.getInt("cve_ord"));
				orden.setNumeroMesaContrato(rs.getInt("num_mescon"));
				orden.setClaveCafecito(rs.getInt("cve_caf"));

				
				orden.setCantidadDetalleOrden(rs.getInt("cant_detord"));
				orden.setClavePlatillo(rs.getInt("cve_pla"));
				orden.setPrecioVentaDetalleOrden(rs.getInt("pventa_detord"));
				orden.setFechaticket(rs.getString("fecha_tic"));
				orden.setTotal(rs.getInt("total_tic"));
				orden.setFolio(rs.getInt("folio_con"));
			
				ordenes.add(orden);
			}
			return ordenes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}


	
	 public ArrayList<String> llenar_comboEmpleado(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = "select persona.nom_per, persona.ap_per ,contrato.folio_con, contrato.puesto_con, contrato.cve_caf from contrato, persona where persona.cve_per=contrato.cve_per;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){
	                lista3.add("Folio:" + rs.getString("folio_con" )+ "  Nombre:" + rs.getString("nom_per") + "  A.Paterno:" + rs.getString("ap_per") + "  Puesto:" + rs.getString("puesto_con") + "  Clave Cafecito :" + rs.getString("cve_caf"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	
	 public ArrayList<String> llenar_comboPlatillo(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = "select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.tiempopre_pla, platillo.porcion_pla, platillocafecito.cve_caf from platillo, platillocafecito where platillo.cve_pla=platillocafecito.cve_pla;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){
	                lista3.add("Clave Platillo:" + rs.getString("cve_pla" )+ "  nombre:" + rs.getString("nom_pla") + "  Tipo:" + rs.getString("tipo_pla") + "  Tiempo:" + rs.getString("tiempopre_pla") + "  Porcion :" + rs.getString("porcion_pla") + "  Clave Cafecito :" + rs.getString("cve_caf")   );
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	
	
	
	 public ArrayList<String> llenar_comboMesaContrato(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = " select mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes, mesacafecito.ubicacion_mescaf, mesacafecito.cve_caf from mesacontrato, mesacafecito where mesacontrato.cve_mes=mesacafecito.cve_mes;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){
	                lista3.add("ID Mesa-Contrato:" + rs.getString("num_mescon" )+ "  fecha:" + rs.getString("fecha_mescon") + "  Folio:" + rs.getString("folio_con") + "  Clave Mesa:" + rs.getString("cve_mes")+ "  Ubicacion:" + rs.getString("ubicacion_mescaf")+ "  Clave Cafecito:" + rs.getString("cve_caf"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	
	

	
	
	
	
	
}
