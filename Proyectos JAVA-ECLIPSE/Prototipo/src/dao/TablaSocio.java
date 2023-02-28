package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Persona;
import modelo.Proveedor;
import modelo.Socio;

public class TablaSocio {

	
	
	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaSocio(Connection conexion) {
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




	
	public String registrarSocio(Persona persona) {
	

		String sql = "insert into persona values(null, '"+persona.getNombre()+ "', '"+persona.getDireccion()+ "', '"+persona.getTelefono() +"', 'Mostrar')";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Socio registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	
	
	
	public List<Persona> getSocios(Persona persona, String opcion){

		String sql = "";

		if(opcion.equals("Nombre")) {
			
			sql="select nom_per, direc_per, tel_per from persona where  persona.estado_per='Mostrar' && not exists(select cve_per"
					+ " from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from "
					+ "proveedor where proveedor.cve_per=persona.cve_per) && not exists(select cve_per from"
					+ " empleado where empleado.cve_per=persona.cve_per) && persona.nom_per='"+persona.getNombre()+"' "
							+ "group by nom_per, direc_per, tel_per order by nom_per, direc_per, tel_per ASC";
		}

		if(opcion.equals("Direccion")) {
			
			sql="select nom_per, direc_per, tel_per from persona where  persona.estado_per='Mostrar' && not exists(select cve_per "
					+ "from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from "
					+ "proveedor where proveedor.cve_per=persona.cve_per) && not exists(select cve_per from "
					+ "empleado where empleado.cve_per=persona.cve_per) && persona.direc_per='"+persona.getDireccion()+"' "
							+ "group by nom_per, direc_per, tel_per order by nom_per, direc_per, tel_per ASC";
		}
	
		

		if(opcion.equals("Telefono")) {
			
			sql="select nom_per, direc_per, tel_per from persona  where persona.estado_per='Mostrar' && not exists(select cve_per "
					+ "from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from "
					+ "proveedor where proveedor.cve_per=persona.cve_per) && not exists(select cve_per from "
					+ "empleado where empleado.cve_per=persona.cve_per) && persona.tel_per='"+persona.getTelefono()+"'"
							+ " group by nom_per, direc_per, tel_per order by nom_per, direc_per, tel_per ASC";
		}

		
		
		if(opcion.equals("Todo")) {
			sql =  "select nom_per, direc_per, tel_per from persona where persona.estado_per='Mostrar' && not exists(select cve_per from cliente where "
					+ "cliente.cve_per=persona.cve_per) && not exists(select cve_per from empleado where empleado.cve_per=persona.cve_per)"
					+ " && not exists(select cve_per from proveedor where proveedor.cve_per=persona.cve_per)";
			
			
		}

		System.out.println(sql);
		
		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Persona> personas = new ArrayList<>();

			while (rs.next()) {

				Persona personaa = new Persona();

				personaa.setNombre(rs.getString(1));
				personaa.setDireccion(rs.getString(2));
				personaa.setTelefono(rs.getString(3));
				
				personas.add(personaa);
			}
			return personas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaSocios(){

		String sql = "select nom_per, direc_per, tel_per from persona where  persona.estado_per='Mostrar' && not exists(select cve_per from cliente where cliente.cve_per=persona.cve_per)&& not exists(select cve_per from empleado where empleado.cve_per=persona.cve_per) && not exists(select cve_per from proveedor where proveedor.cve_per=persona.cve_per)  group by nom_per, direc_per, tel_per order by nom_per, direc_per, tel_per ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> personas = new ArrayList<>();

			while (rs.next()) {


				String persona = rs.getString(1)+", "+rs.getString(2) +", "+rs.getString(3);

				personas.add(persona);
			}
			return personas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	

	public String modificarSocio(Persona newsocio, Persona oldsocio) {

		

		
		String sql= "update persona set nom_per='"+newsocio.getNombre()+"', direc_per='"+newsocio.getDireccion()+ "', tel_per='"+newsocio.getTelefono() +"'  where nom_per='"+oldsocio.getNombre() +"'  && direc_per='"+oldsocio.getDireccion()+ "' && tel_per='"+oldsocio.getTelefono()+"'";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Socio modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	

	 public ArrayList<String> llenar_comboNombre(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select nom_per from persona where persona.estado_per='Mostrar' && not exists(select cve_per from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from empleado where empleado.cve_per=persona.cve_per) && not exists(select cve_per from proveedor where proveedor.cve_per=persona.cve_per);";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("nom_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	

	 public ArrayList<String> llenar_comboDireccion(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select direc_per from persona where persona.estado_per='Mostrar'&& not exists(select cve_per from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from empleado where empleado.cve_per=persona.cve_per) && not exists(select cve_per from proveedor where proveedor.cve_per=persona.cve_per);";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("direc_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	 
		

	 public ArrayList<String> llenar_comboTelefono(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select tel_per from persona where  persona.estado_per='Mostrar' && not exists(select cve_per from cliente where cliente.cve_per=persona.cve_per) && not exists(select cve_per from empleado where empleado.cve_per=persona.cve_per) && not exists(select cve_per from proveedor where proveedor.cve_per=persona.cve_per)";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("tel_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 

		public String eliminarSocio(Persona persona, Socio socio) {

			String cveper = "set @cveper = (select cve_per from persona where nom_per='"+socio.getNombre()+
					"' && direc_per='"+socio.getDireccion()+"' && tel_per='"+socio.getTelefono()+
					"')";

		
			String sql = "update persona set estado_per='No mostrar' where cve_per=@cveper";
			
		
			if(statement!=null) {
				try {
					statement.executeUpdate(cveper);
					statement.executeUpdate(sql);
					return "Socio borrado";
				} catch (SQLException e) {
					System.out.println(e.toString());

				}
			}else {
				System.out.println("eror, no hay sentencia");
			}
			return sql.toString();
		}


	
}