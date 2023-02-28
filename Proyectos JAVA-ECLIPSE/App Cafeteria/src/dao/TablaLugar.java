package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Lugar;
import modelo.Empleado;
import modelo.Insumo;

	public class TablaLugar {
		private Connection conexion;
		private Statement statement;
		int valor =0;

		public TablaLugar(Connection conexcion) {
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
		
		
//		//mesa
//		private int claveMesa;
//		private int capacidad;
//		
//		

		
		public String guardarLugar(Lugar lugar) {
			String sql = "insert into mesa values('" + lugar.getClaveMesa()+ "', '" + lugar.getCapacidad() + "')";
		//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//					cafecito.getOrientacion()+"')";
			
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		

//		//mesa cafecito
//		private int numeroMesa;
//		private int numero;
//		private String Ubicacion;
//		private int claveMesa2;
//		private int claveCafecito;
		
		public String guardarLugarCafecito(Lugar lugar) {
			String sql = "insert into mesacafecito values('" + lugar.getNumeroMesa() + "', '" + lugar.getUbicacion() +
					"', '" + lugar.getClaveMesa2() + "', '" + lugar.getClaveCafecito() +"')";
		//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//					cafecito.getOrientacion()+"')";
			
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		
//		//mesa contrato
//		private int mesaContrato;
//		private String fecha;
//		private int folio;
//		private int claveMesa3;
		public String guardarLugarEmpleado(Lugar lugar) {
			String sql = "insert into mesacontrato values('" + lugar.getMesaContrato()+ "', '" + lugar.getFecha() + "', '" + lugar.getFolio() +
					"', '" + lugar.getClaveMesa3() +"')";
		//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//					cafecito.getOrientacion()+"')";
			
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		
		
		public List<Lugar> getLugares(){
			String sql = "select mesa.cve_mes, mesa.capacidad_mes, mesacafecito.num_mescaf, mesacafecito.ubicacion_mescaf, mesacafecito.cve_mes, mesacafecito.cve_caf, mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes  from mesa, mesacafecito, mesacontrato where mesa.cve_mes=mesacafecito.cve_mes && mesa.cve_mes=mesacontrato.cve_mes;";
			System.out.println(sql);
			try {
				ResultSet rs = statement.executeQuery(sql);
				List<Lugar> lugares = new ArrayList<>();
				while (rs.next()) {
					Lugar lugar =new Lugar();
//					
//					//mesa
//					private int claveMesa;
//					private int capacidad;
//					
//					//mesa cafecito
//					private int numeroMesa;
//					private int numero;
//					private String Ubicacion;
//					private int claveMesa2;
//					private int claveCafecito;
//					
//					//mesa contrato
//					private int mesaContrato;
//					private String fecha;
//					private int folio;
//					private int claveMesa3;
					
					lugar.setClaveMesa(rs.getInt("cve_mes"));
					lugar.setCapacidad(rs.getInt("capacidad_mes"));
					
				
					lugar.setNumeroMesa(rs.getInt("num_mescaf"));
					lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
					lugar.setClaveCafecito(rs.getInt("cve_caf"));
					
					lugar.setMesaContrato(rs.getInt("num_mescon"));
					lugar.setFecha(rs.getString("fecha_mescon"));
					lugar.setFolio(rs.getInt("folio_con"));


				
					
					lugares.add(lugar);
				}
				return lugares;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		}

		 public ArrayList<String> llenar_comboCafecito(){
		        ArrayList<String> lista = new ArrayList<String>();
		        String sql = "select *from cafecito;";
		      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
		        
		        try {
		        	ResultSet rs = statement.executeQuery(sql);	          
//		        	System.out.println("Correcto");
//		        } catch (Exception e) {
//		            System.out.println("No Correcto");
//		        }
//		        try {
		        	
		            while(rs.next()){
		                lista.add("Clave cafecito:" + rs.getString("cve_caf" )+ "    Calle:" + rs.getString("calle_caf") + "    Numero:" + rs.getString("num_caf") + "    Orientacion:" + rs.getString("orientacion_caf")+ "    Clave colonia:" + rs.getString("cve_col"));
		        		
		            }
		        } catch (Exception e) {
		        }
		        return lista;
		    }
		
		 
//		 select folio_con, rfc_con, fechaini_con, fechafin_con, sueldo_con, puesto_con, cve_caf, cve_per from contrato;
		 public ArrayList<String> llenar_comboEmpleado(){
		        ArrayList<String> lista3 = new ArrayList<String>();
		        String sql = "select persona.nom_per, persona.ap_per, persona.am_per ,contrato.folio_con, contrato.rfc_con, contrato.puesto_con, contrato.cve_caf from contrato, persona where persona.cve_per=contrato.cve_per;";
		      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
		        
		        try {
		        	ResultSet rs = statement.executeQuery(sql);	          
//		        	System.out.println("Correcto");
//		        } catch (Exception e) {
//		            System.out.println("No Correcto");
//		        }
//		        try {
		        	
		            while(rs.next()){
		                lista3.add("Folio:" + rs.getString("folio_con" )+ "    Nombre:" + rs.getString("nom_per") + "    A.Paterno:" + rs.getString("ap_per") + "    A.Materno:" + rs.getString("am_per")+ "    RFC:" + rs.getString("rfc_con")+ "    Puesto:" + rs.getString("puesto_con")+ "    Clave Cafecito:" + rs.getString("cve_caf"));
		        		
		            }
		        } catch (Exception e) {
		        }
		        return lista3;
		    }
		 
		 
		 public List<Lugar> consultarPorDatosMesa(String id, String capacidad) {

				if(id!="") {
					id=" mesa.cve_mes='"+id+"'";
				}
				if(capacidad!="") {
					capacidad=" mesa.capacidad_mes='"+capacidad+"'";
				}
			
				

				String sql = "select mesa.cve_mes, mesa.capacidad_mes, mesacafecito.num_mescaf, mesacafecito.ubicacion_mescaf, mesacafecito.cve_mes, mesacafecito.cve_caf, mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes  from mesa, mesacafecito, mesacontrato where mesa.cve_mes=mesacafecito.cve_mes && mesa.cve_mes=mesacontrato.cve_mes && "+id+capacidad;
				try {
					ResultSet rs = statement.executeQuery(sql);
					List<Lugar> lugares = new ArrayList<>();
					while (rs.next()) {
						Lugar lugar =new Lugar();
//						
//					
						
						lugar.setClaveMesa(rs.getInt("cve_mes"));
						lugar.setCapacidad(rs.getInt("capacidad_mes"));
						
					
						lugar.setNumeroMesa(rs.getInt("num_mescaf"));
						lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
						lugar.setClaveCafecito(rs.getInt("cve_caf"));
						
						lugar.setMesaContrato(rs.getInt("num_mescon"));
						lugar.setFecha(rs.getString("fecha_mescon"));
						lugar.setFolio(rs.getInt("folio_con"));


					
						
						lugares.add(lugar);
					}
					return lugares;
				} catch (Exception e) {
					System.out.println(e.toString());
					return null;
				}
			}
		 
		 
		 public List<Lugar> consultarPorDatosMesaCafecito(String numero, String ubicacion, String claveCafecito) {

				if(numero!="") {
					numero=" mesacafecito.num_mescaf='"+numero+"'";
				}
				if(ubicacion!="") {
					ubicacion=" mesacafecito.ubicacion_mescaf='"+ubicacion+"'";
				}
				if(claveCafecito!="") {
					claveCafecito=" mesacafecito.cve_caf='"+claveCafecito+"'";
				}
				
//				 num_mescaf       | int(11)     | NO   | PRI | NULL    | auto_increment |
//				 | ubicacion_mescaf | varchar(50) | YES  |     | NULL    |                |
//				 | cve_mes          | int(11)     | NO   | MUL | NULL    |                |
//				 | cve_caf
				
				String sql = "select mesa.cve_mes, mesa.capacidad_mes, mesacafecito.num_mescaf, mesacafecito.ubicacion_mescaf, mesacafecito.cve_mes, mesacafecito.cve_caf, mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes  from mesa, mesacafecito, mesacontrato where mesa.cve_mes=mesacafecito.cve_mes && mesa.cve_mes=mesacontrato.cve_mes && "+numero+ubicacion+claveCafecito;
				try {
					ResultSet rs = statement.executeQuery(sql);
					List<Lugar> lugares = new ArrayList<>();
					while (rs.next()) {
						Lugar lugar =new Lugar();
//						
//					
						
						lugar.setClaveMesa(rs.getInt("cve_mes"));
						lugar.setCapacidad(rs.getInt("capacidad_mes"));
						
					
						lugar.setNumeroMesa(rs.getInt("num_mescaf"));
						lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
						lugar.setClaveCafecito(rs.getInt("cve_caf"));
						
						lugar.setMesaContrato(rs.getInt("num_mescon"));
						lugar.setFecha(rs.getString("fecha_mescon"));
						lugar.setFolio(rs.getInt("folio_con"));


					
						
						lugares.add(lugar);
					}
					return lugares;
				} catch (Exception e) {
					System.out.println(e.toString());
					return null;
				}
			}
		 
		 
		 public List<Lugar> consultarPorDatosMesaContrato(String mesaContrato, String fecha, String folio) {

				if(mesaContrato!="") {
					mesaContrato=" mesacontrato.num_mescon='"+mesaContrato+"'";
				}
				if(fecha!="") {
					fecha=" mesacontrato.fecha_mescon='"+fecha+"'";
				}
				if(folio!="") {
					folio=" mesacontrato.folio_con='"+folio+"'";
				}
				
//				 num_mescon   | int(11) | NO   | PRI | NULL    | auto_increment |
//				 | fecha_mescon | date    | NO   |     | NULL    |                |
//				 | folio_con    | int(11) | NO   | MUL | NULL    |                |
//				 | cve_mes      | int(11) | NO   | MUL | NULL    |                |
//				 +--------------+---------+------+-----+---------+----------------+
//				 4 rows in set (0.04 sec)

				String sql = "select mesa.cve_mes, mesa.capacidad_mes, mesacafecito.num_mescaf, mesacafecito.ubicacion_mescaf, mesacafecito.cve_mes, mesacafecito.cve_caf, mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes  from mesa, mesacafecito, mesacontrato where mesa.cve_mes=mesacafecito.cve_mes && mesa.cve_mes=mesacontrato.cve_mes && "+mesaContrato+fecha+folio;
				try {
					ResultSet rs = statement.executeQuery(sql);
					List<Lugar> lugares = new ArrayList<>();
					while (rs.next()) {
						Lugar lugar =new Lugar();
//						
//					
						
						lugar.setClaveMesa(rs.getInt("cve_mes"));
						lugar.setCapacidad(rs.getInt("capacidad_mes"));
						
					
						lugar.setNumeroMesa(rs.getInt("num_mescaf"));
						lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
						lugar.setClaveCafecito(rs.getInt("cve_caf"));
						
						lugar.setMesaContrato(rs.getInt("num_mescon"));
						lugar.setFecha(rs.getString("fecha_mescon"));
						lugar.setFolio(rs.getInt("folio_con"));


					
						
						lugares.add(lugar);
					}
					return lugares;
				} catch (Exception e) {
					System.out.println(e.toString());
					return null;
				}
			}

		 
		 
//		 delete mesacontrato from mesacontrato join mesacafecito on mesacontrato.cve_mes=mesacafecito.cve_mes where mesacontrato.cve_mes=77;
		
		 
		 
		 public Lugar consultarPorClaveMesa(int mesaC) {


				String sql = "select mesa.cve_mes, mesa.capacidad_mes, mesacafecito.num_mescaf, mesacafecito.ubicacion_mescaf, mesacafecito.cve_mes, mesacafecito.cve_caf, mesacontrato.num_mescon, mesacontrato.fecha_mescon, mesacontrato.folio_con, mesacontrato.cve_mes  from mesa, mesacafecito, mesacontrato where mesa.cve_mes=mesacafecito.cve_mes && mesa.cve_mes=mesacontrato.cve_mes && mesa.cve_mes= "+mesaC;
			
				Lugar lugar =new Lugar();

				ResultSet rs = null;
				try {
					rs = statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					while(rs.next()) {
//						
//					
						
						lugar.setClaveMesa(rs.getInt("cve_mes"));
						lugar.setCapacidad(rs.getInt("capacidad_mes"));
						
					
						lugar.setNumeroMesa(rs.getInt("num_mescaf"));
						lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
						lugar.setClaveCafecito(rs.getInt("cve_caf"));
						
						lugar.setMesaContrato(rs.getInt("num_mescon"));
						lugar.setFecha(rs.getString("fecha_mescon"));
						lugar.setFolio(rs.getInt("folio_con"));


					
						
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return lugar;
}
	
		 
		 public String eliminarMesa(int mesa ) {
				String sql = " delete mesa.* from mesa where cve_mes="+mesa;
				if(statement!=null) {
					try {
						statement.executeUpdate(sql);
						return "Mesa eliminada con exito";
					} catch (SQLException e) {
						System.out.println(e.toString());

					}
				}else {
					System.out.println("error, no hay sentencia");
				}
				return sql.toString();
			}
		 
		 public String eliminarMesaContrato(int mesaContrato ) {
				String sql = " delete mesacontrato.* from mesacontrato where mesacontrato.cve_mes="+mesaContrato;
				if(statement!=null) {
					try {
						statement.executeUpdate(sql);
//						return "Mesa eliminada con exito";
					} catch (SQLException e) {
						System.out.println(e.toString());

					}
				}else {
					System.out.println("error, no hay sentencia");
				}
				return sql.toString();
			}
	
		 
		 public String eliminarMesaCafecito(int mesaCafecito ) {
				String sql = " delete mesacafecito.* from mesacafecito where mesacafecito.cve_mes="+mesaCafecito;
				if(statement!=null) {
					try {
						statement.executeUpdate(sql);
//						return "Mesa eliminada con exito";
					} catch (SQLException e) {
						System.out.println(e.toString());

					}
				}else {
					System.out.println("error, no hay sentencia");
				}
				return sql.toString();
			}
	}
