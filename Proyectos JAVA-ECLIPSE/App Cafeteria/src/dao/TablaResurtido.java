package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Orden;
import modelo.Resurtido;


public class TablaResurtido {
	private Connection conexion;
	private Statement statement;
	int valor =0;

	public TablaResurtido(Connection conexcion) {
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
	
	
	
	
	
	public List<Resurtido> getResurtidos(){
		String sql = "select resurtir.cve_res, resurtir.fecha_res, resurtir.cve_prov, resurtir.cve_caf, renglonresurtir.cant_renres, renglonresurtir.ppu_renres, renglonresurtir.cve_pro from resurtir, renglonresurtir, provcaf where resurtir.cve_res=renglonresurtir.cve_res;";
		System.out.println(sql);
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Resurtido> resurtidos = new ArrayList<>();
			while (rs.next()) {
				
				Resurtido resurtido =new Resurtido();
			
				
				resurtido.setClaveResurtido(rs.getInt("cve_res"));
				resurtido.setFechaResurtido(rs.getString("fecha_res"));
				resurtido.setClaveProveedor(rs.getInt("cve_prov"));
				resurtido.setClaveCafecito(rs.getInt("cve_caf"));
				resurtido.setCantidad(rs.getInt("cant_renres"));
				resurtido.setPpu(rs.getInt("ppu_renres"));
				resurtido.setClaveProducto(rs.getInt("cve_pro"));
				
			
			
				resurtidos.add(resurtido);
			}
			return resurtidos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	

	 public ArrayList<String> llenar_comboProveedor(){
	        ArrayList<String> lista3 = new ArrayList<String>();
	        String sql = " select cve_prov, empresa_pro, calle_prov, num_prov, tel_prov, correo_prov, cve_col from proveedor;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){
	                lista3.add("Clave Proveedor:" + rs.getString("cve_prov" )+ "  Empresa:" + rs.getString("empresa_pro") + "  Calle:" + rs.getString("calle_prov") + "  Numero:" + rs.getString("num_prov") + "   Telefono :" + rs.getString("tel_prov") + "   Correo :" + rs.getString("correo_prov") + "   Colonia :" + rs.getString("cve_col"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista3;
	    }
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
