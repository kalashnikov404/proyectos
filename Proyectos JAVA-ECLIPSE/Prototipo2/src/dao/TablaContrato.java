package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Persona;

public class TablaContrato {

	
	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaContrato(Connection conexion) {
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

	



	
	public String registrarContrato(Contrato contrato) {
	

		String sql = "insert into contrato values(null, '"+contrato.getTipo()+ "', '"+contrato.getFechaI()+ "', '"+contrato.getFechaF()+ "', '"+contrato.getSueldo()+ "', '"+contrato.getPuesto()+ "', '"+contrato.getRfc() +"')";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Contrato registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	

	
	
	
	public List<Contrato> getContratos(Contrato contrato, String opcion){

		String sql = "";

		if(opcion.equals("Tipo")) {
			
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.tipo_cont='"+contrato.getTipo()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}

		if(opcion.equals("Fecha inicial")) {
			
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.fechini_cont='"+contrato.getFechaI()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}
	
		

		if(opcion.equals("Fecha final")) {
			
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.fechfin_cont='"+contrato.getFechaF()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}



		if(opcion.equals("Sueldo")) {
			
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.sueldo_cont='"+contrato.getSueldo()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}



		if(opcion.equals("Puesto")) {
		
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.puesto_cont='"+contrato.getPuesto()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}


		if(opcion.equals("RFC")) {
			
			sql="select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato where contrato.rfc_emp='"+contrato.getRfc()+"' order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		}
		
		if(opcion.equals("Todo")) {
			sql =  "select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
			
			
		}

		
		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Contrato> contratos = new ArrayList<>();

			while (rs.next()) {

				Contrato contratoo = new Contrato();

			    contratoo.setTipo(rs.getString(1));
			    contratoo.setFechaI(rs.getString(2));
			    contratoo.setFechaF(rs.getString(3));
			    contratoo.setSueldo(rs.getString(4));
			    contratoo.setPuesto(rs.getString(5));
			    contratoo.setRfc(rs.getString(6));

			    
				
				contratos.add(contratoo);
			}
			return contratos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaContratos(){

		String sql = "select tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp from contrato order by tipo_cont, fechini_cont, fechfin_cont, sueldo_cont, puesto_cont, rfc_emp ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> contratos = new ArrayList<>();

			while (rs.next()) {


				String contrato = rs.getString(1)+", "+rs.getString(2) +", "+rs.getString(3) +", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6);

				contratos.add(contrato);
			}
			return contratos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	

	

	public String modificarContrato(Contrato newscontrato, Contrato oldcontrato) {

		

		
		String sql= "update contrato set tipo_cont='"+newscontrato.getTipo()+"', fechini_cont='"+newscontrato.getFechaI() +"', fechfin_cont='"+newscontrato.getFechaF() +"', sueldo_cont='"+newscontrato.getSueldo()+ "', sueldo_cont='"+newscontrato.getSueldo()+"', puesto_cont='"+newscontrato.getPuesto()+"'  where tipo_cont='"+oldcontrato.getTipo() +"'  && fechini_cont='"+oldcontrato.getFechaI()
		+ "' && fechfin_cont='"+oldcontrato.getFechaF() + "' && sueldo_cont='"+oldcontrato.getSueldo() + "' && puesto_cont='"+oldcontrato.getPuesto()  +"'";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Contrato modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	
	

	 public ArrayList<String> llenar_comboEmpleado(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select rfc_emp from empleado ;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("rfc_emp" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	


	 public ArrayList<String> llenar_comboTipo(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select tipo_cont from contrato group by tipo_cont;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("tipo_cont" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	


	 public ArrayList<String> llenar_comboFechaInicial(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select fechini_cont from contrato group by fechini_cont;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("fechini_cont" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	 



	 public ArrayList<String> llenar_comboFechaFin(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select fechfin_cont from contrato group by fechfin_cont;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("fechfin_cont" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 
	 


	 public ArrayList<String> llenar_comboSueldo(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select sueldo_cont from contrato group by sueldo_cont;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("sueldo_cont" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 


	 public ArrayList<String> llenar_comboPuesto(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select puesto_cont from contrato group by puesto_cont;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("puesto_cont" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 
}
