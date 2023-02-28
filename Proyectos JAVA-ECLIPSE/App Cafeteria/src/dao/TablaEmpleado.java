package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Empleado;



	public class TablaEmpleado {
		private Connection conexion;
		private Statement statement;
		int valor =0;

		public TablaEmpleado(Connection conexcion) {
			this.conexion=conexcion;
			crearSentencia();
		}

		private  void crearSentencia() {
			try {
				statement=conexion.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
				statement=null;
			
			
			}}
		
//		private String nombre;
//		private String paterno;
//		private String materno;
//		private String calle;
//		private int numero;
//		private String orientacion;
//		private Date nacimiento;
//		private String genero;
//		private int telefono;
//		private int cveColonia;
		
		public String guardarEmpleadoPersona(Empleado empleado) {
			String sql = "insert into persona values('" + empleado.getCvePer() + "', '"+ empleado.getNombre() + "','" 
					+ empleado.getPaterno() + "','"+ empleado.getMaterno() + "','"
					+ empleado.getCalle() + "','"+ empleado.getNumero()+ "','" + empleado.getOrientacion()+ "','"+ empleado.getNacimiento()+ "','" + empleado.getGenero()
					+ "','" + empleado.getTelefono() + "','" + empleado.getCveColonia()+"')";
	
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		
		public String guardarEmpleado(Empleado empleado) {
			String sql = "insert into contrato values('" + empleado.getFolio() + "', '"+ empleado.getRfc() + "','" 
					+ empleado.getfInicio() + "','"+ empleado.getfFinal() + "','"
					+ empleado.getSueldo() + "','"+ empleado.getPuesto()+ "','" + empleado.getCveCaf()+ "','" + empleado.getCvePer() +"')";
	
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		
		

		public List<Empleado> getEmpleados2(){
			String sql = "select *from  vistaempleadosexistentes;";
			System.out.println(sql);
			try {
				ResultSet rs = statement.executeQuery(sql);
				List<Empleado> empleados = new ArrayList<>();
				while (rs.next()) {
					Empleado empleado =new Empleado();
					
					//datos de la persona
					
					empleado.setCvePer(rs.getInt("cve_per"));
					empleado.setNombre(rs.getString("nom_per"));
					empleado.setPaterno(rs.getNString("ap_per"));
					empleado.setMaterno(rs.getNString("am_per"));
					empleado.setCalle(rs.getNString("calle_per"));
					empleado.setNumero(rs.getInt("num_per"));
					empleado.setOrientacion(rs.getNString("orientacion_per"));
					
					empleado.setNacimiento(rs.getString("fechanac_per"));
					empleado.setGenero(rs.getNString("genero_per"));
					empleado.setTelefono(rs.getInt("telefono_per"));
					empleado.setCveColonia(rs.getInt("cve_col"));

			
					//datos del contrato
					empleado.setFolio(rs.getInt("folio_con"));
					empleado.setRfc(rs.getString("rfc_con"));
					empleado.setfInicio(rs.getString("fechaini_con"));
					empleado.setfFinal(rs.getString("fechafin_con"));
					empleado.setSueldo(rs.getDouble("sueldo_con"));
					empleado.setPuesto(rs.getString("puesto_con"));
					empleado.setCveCaf(rs.getInt("cve_caf"));	
					

					
					empleados.add(empleado);
				}
				return empleados;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		}

		
		
		public List<String> getEmpleados(){
			String sql = "select contrato.cve_con, persona.nombre_per, persona.ap_per, persona.am_per, persona.sexo_per, persona.calle_per, persona.numcs_per, colonia.nom_col, ciudad.nom_ciu, estado.nom_est, cliente.celular_cli, cliente.correo_cli, cliente.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo, contrato.fini_con, contrato.fcfin_con, estacionamiento.num_lug from persona join cliente on persona.cve_per=cliente.cve_per join contrato on cliente.cve_cli=contrato.cve_cli join vehiculo on cliente.placas_veh=vehiculo.placas_veh join estacionamiento on vehiculo.placas_veh=estacionamiento.placas_veh join colonia on persona.cp_col=colonia.cp_col join ciudad on colonia.cve_ciu=ciudad.cve_ciu join estado on ciudad.cve_est=estado.cve_est group by estacionamiento.placas_veh, contrato.cve_con, estacionamiento.num_lug";

			try {
				ResultSet rs = statement.executeQuery(sql);
				List<String> empleados = new ArrayList<>();
				while (rs.next()) {

					empleados.add(rs.getString(1));
					empleados.add(rs.getString(2));
					empleados.add(rs.getString(3));
					empleados.add(rs.getString(4));
					empleados.add(rs.getString(5));
					empleados.add(rs.getString(6));
					empleados.add(rs.getString(7));
					empleados.add(rs.getString(8));
					empleados.add(rs.getString(9));
					empleados.add(rs.getString(10));
					empleados.add(rs.getString(11));
					empleados.add(rs.getString(12));
					empleados.add(rs.getString(13));
					empleados.add(rs.getString(14));
					empleados.add(rs.getString(15));
					empleados.add(rs.getString(16));
					empleados.add(rs.getString(17));

					empleados.add(rs.getString(18));

				
					
				}
				return empleados;

			} catch (Exception e) {
				return null;
			}
		}

	public String eliminarEmpleado(int folio) {
		String sql = "delete contrato.* from contrato join persona on contrato.cve_per=persona.cve_per where contrato.cve_per="+folio;
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Empleado eliminado con exito";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	

	public Empleado consultarPorFolio(int folio) {
		String sql = "select persona.cve_per, persona.nom_per, persona.ap_per, persona.am_per, contrato.folio_con, contrato.rfc_con from persona, contrato where persona.cve_per=contrato.cve_per;";
				
		Empleado empleado =new Empleado();
		
		
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				
				empleado.setCvePer(rs.getInt("cve_per"));
				empleado.setNombre(rs.getString("nom_per"));
				empleado.setPaterno(rs.getNString("ap_per"));
				empleado.setMaterno(rs.getNString("am_per"));
				empleado.setFolio(rs.getInt("folio_con"));
				empleado.setRfc(rs.getString("rfc_con"));
				

				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empleado;
	}




	 public ArrayList<String> llenar_comboPersona(){
	        ArrayList<String> lista = new ArrayList<String>();
	        String sql = " select cve_per, nom_per, ap_per, am_per, calle_per from persona;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	            while(rs.next()){
	                lista.add("Clave persona:" + rs.getString("cve_per" ) + "    Nombre:" + rs.getString("nom_per") + "    A.paterno:" + rs.getString("ap_per")+ "    A.materno:" + rs.getString("am_per")+ "    Calle:" + rs.getString("calle_per"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista;
	    }



	 public ArrayList<String> llenar_comboCafecito(){
	        ArrayList<String> lista = new ArrayList<String>();
	        String sql = "select *from cafecito;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	        	
	            while(rs.next()){
	                lista.add("Clave cafecito:" + rs.getString("cve_caf" )+ "    Calle:" + rs.getString("calle_caf") + "    Numero:" + rs.getString("num_caf") + "    Orientacion:" + rs.getString("orientacion_caf")+ "    Clave colonia:" + rs.getString("cve_col"));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista;
	    }
	 
	 
//	 select folio_con, rfc_con, fechaini_con, fechafin_con, sueldo_con, puesto_con, cve_caf, cve_per from contrato;


	public int generaI(int valor) {
		int numeroAleatorio = (int) (Math.random()*25+1);
		return numeroAleatorio;
		
	}

	
	public List<Empleado> consultarPorDatosPersona(String id, String nombre, String paterno, String materno, String calle, String numero, String orientacion, String nacimiento, String genero, String telefono, String idColonia) {

		if(id!="") {
			id=" persona.cve_per='"+id+"'";
		}
		if(nombre!="") {
			nombre=" persona.nom_per='"+nombre+"'";
		}
		if(paterno!="") {
			paterno=" persona.ap_per='"+paterno+"'";
		}
		if(materno!="") {
			materno=" persona.am_per='"+materno+"'";
		}
		if(calle!="") {
			calle=" persona.calle_per='"+calle+"'";
		}
		if(numero!="") {
			numero=" persona.num_per='"+numero+"'";
		}
		if(orientacion!="") {
			orientacion=" persona.orientacion_per='"+orientacion+"'";
			
		}if(nacimiento!="") {
			nacimiento=" persona.fechanac_per  ='"+nacimiento+"'";
			
		}if(genero!="") {
			genero=" persona.genero_per='"+genero+"'";
			
		}if(telefono!="") {
			telefono=" persona.telefono_per='"+telefono+"'";
			
		}if(idColonia!="") {
			idColonia=" persona.cve_col='"+idColonia+"'";
		}
		

		String sql = "select persona.cve_per, persona.nom_per, persona.ap_per, persona.am_per, persona.calle_per, persona.num_per, persona.orientacion_per, persona.fechanac_per, persona.genero_per, persona.telefono_per, persona.cve_col, contrato.folio_con, contrato.rfc_con, contrato.fechaini_con, contrato.fechafin_con, contrato.sueldo_con, contrato.puesto_con, contrato.cve_caf from persona, contrato where persona.cve_per=contrato.cve_per &&"+id+nombre+paterno+materno+calle+numero+orientacion+nacimiento+genero+telefono+idColonia;
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Empleado> empleados = new ArrayList<>();
			while (rs.next()) {
				Empleado empleado =new Empleado();
				empleado.setCvePer(rs.getInt("cve_per"));
				empleado.setNombre(rs.getString("nom_per"));
				empleado.setPaterno(rs.getNString("ap_per"));
				empleado.setMaterno(rs.getNString("am_per"));
				empleado.setCalle(rs.getNString("calle_per"));
				empleado.setNumero(rs.getInt("num_per"));
				empleado.setOrientacion(rs.getNString("orientacion_per"));
				
				empleado.setNacimiento(rs.getString("fechanac_per"));
				empleado.setGenero(rs.getNString("genero_per"));
				empleado.setTelefono(rs.getInt("telefono_per"));
				empleado.setCveColonia(rs.getInt("cve_col"));

		
				//datos del contrato
				empleado.setFolio(rs.getInt("folio_con"));
				empleado.setRfc(rs.getString("rfc_con"));
				empleado.setfInicio(rs.getString("fechaini_con"));
				empleado.setfFinal(rs.getString("fechafin_con"));
				empleado.setSueldo(rs.getDouble("sueldo_con"));
				empleado.setPuesto(rs.getString("puesto_con"));
				empleado.setCveCaf(rs.getInt("cve_caf"));	
				
				empleados.add(empleado);

			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
//	
//	 folio_con    | int(11)     | NO   | PRI | NULL    | auto_increment |
//	 | rfc_con      | varchar(40) | NO   |     | NULL    |                |
//	 | fechaini_con | date        | NO   |     | NULL    |                |
//	 | fechafin_con | date        | NO   |     | NULL    |                |
//	 | sueldo_con   | float(8,2)  | NO   |     | NULL    |                |
//	 | puesto_con   | varchar(40) | YES  |     | NULL    |                |
//	 | cve_caf      | int(11)     | NO   | MUL | NULL    |                |
//	 | cve_per
	
	public List<Empleado> consultarPorDatosContrato(String folio, String rfc, String finicio, String ffinal, String sueldo, String puesto, String claveCafecito) {
 

		 
		if(folio!="") {
			folio=" contrato.folio_con='"+folio+"'";
		}
		if(rfc!="") {
			rfc=" contrato.rfc_con='"+rfc+"'";
		}
		if(finicio!="") {
			finicio=" contrato.fechaini_con='"+finicio+"'";
		}
		if(ffinal!="") {
			ffinal=" contrato.fechafin_con='"+ffinal+"'";
		}
		if(sueldo!="") {
			sueldo=" contrato.sueldo_con='"+sueldo+"'";
		}
		if(puesto!="") {
			puesto=" contrato.puesto_con='"+puesto+"'";
			
			
		}if(claveCafecito!="") {
			claveCafecito=" contrato.cve_caf='"+claveCafecito+"'";
		
		}
		

		String sql = "select persona.cve_per, persona.nom_per, persona.ap_per, persona.am_per, persona.calle_per, persona.num_per, persona.orientacion_per, persona.fechanac_per, persona.genero_per, persona.telefono_per, persona.cve_col, contrato.folio_con, contrato.rfc_con, contrato.fechaini_con, contrato.fechafin_con, contrato.sueldo_con, contrato.puesto_con, contrato.cve_caf from persona, contrato where persona.cve_per=contrato.cve_per &&"+folio+rfc+finicio+ffinal+sueldo+puesto+claveCafecito;
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Empleado> empleados = new ArrayList<>();
			while (rs.next()) {
				Empleado empleado =new Empleado();
				empleado.setCvePer(rs.getInt("cve_per"));
				empleado.setNombre(rs.getString("nom_per"));
				empleado.setPaterno(rs.getNString("ap_per"));
				empleado.setMaterno(rs.getNString("am_per"));
				empleado.setCalle(rs.getNString("calle_per"));
				empleado.setNumero(rs.getInt("num_per"));
				empleado.setOrientacion(rs.getNString("orientacion_per"));
				
				empleado.setNacimiento(rs.getString("fechanac_per"));
				empleado.setGenero(rs.getNString("genero_per"));
				empleado.setTelefono(rs.getInt("telefono_per"));
				empleado.setCveColonia(rs.getInt("cve_col"));

		
				//datos del contrato
				empleado.setFolio(rs.getInt("folio_con"));
				empleado.setRfc(rs.getString("rfc_con"));
				empleado.setfInicio(rs.getString("fechaini_con"));
				empleado.setfFinal(rs.getString("fechafin_con"));
				empleado.setSueldo(rs.getDouble("sueldo_con"));
				empleado.setPuesto(rs.getString("puesto_con"));
				empleado.setCveCaf(rs.getInt("cve_caf"));	
				
				empleados.add(empleado);

			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
}
