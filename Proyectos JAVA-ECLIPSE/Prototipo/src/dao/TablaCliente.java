package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class TablaCliente {

	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaCliente(Connection conexion) {
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

	
	public List<String> getListaTipos(){

		String sql = "select tipo_cli from cliente group by tipo_cli order by tipo_cli ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> tipos = new ArrayList<>();

			while (rs.next()) {


				String tipo = rs.getString(1);

				tipos.add(tipo);
			}
			return tipos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}


	
	public String registrarClientePersona(Cliente cliente) {
	

		String sql = "insert into persona values(null, '"+cliente.getNombre()+ "', '"+cliente.getDireccion()+ "', '"+cliente.getTelefono() +"', 'Mostrar')";

		System.out.println(sql);
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Cliente registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	

	
	public String registrarCliente(Cliente cliente) {
		String c = "set @va=(Select MAX(cve_per)from persona)";

		String sql = "insert into cliente values(null, '"+ cliente.getTipo()+ "',  @va)";
		
		System.out.println(sql);

		if(statement!=null) {
			try {
				statement.executeUpdate(c);
				statement.executeUpdate(sql);
				return "Cliente registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	
	public List<Cliente> getClientes(Cliente cliente, String opcion){

		String sql = "";

		if(opcion.equals("Nombre")) {
			
			sql="select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per && nom_per='"+cliente.getNombre()+"' order by nom_per, direc_per, tel_per, tipo_cli ASC";
		}

		if(opcion.equals("Direccion")) {
			
			sql="select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per && direc_per='"+cliente.getDireccion()+"' order by nom_per, direc_per, tel_per, tipo_cli ASC";
		}
	
		

		if(opcion.equals("Telefono")) {
			
			sql="select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per && tel_per='"+cliente.getTelefono()+"' order by nom_per, direc_per, tel_per, tipo_cli ASC";
		}

		if(opcion.equals("Tipo")) {
			
			sql="select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per && tipo_cli='"+cliente.getTipo()+"' order by nom_per, direc_per, tel_per, tipo_cli ASC";
		}
		
		
		if(opcion.equals("Todo")) {
			sql =  "select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per order by nom_per, direc_per, tel_per, tipo_cli ASC";
		}

		
		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Cliente> clientes = new ArrayList<>();

			while (rs.next()) {

				Cliente clientees = new Cliente();

				clientees.setNombre(rs.getString(1));
				clientees.setDireccion(rs.getString(2));
				clientees.setTelefono(rs.getString(3));
				clientees.setTipo(rs.getString(4));

				clientes.add(clientees);
			}
			return clientes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaClientes(){

		String sql = "select nom_per, direc_per, tel_per, tipo_cli from persona, cliente where persona.cve_per=cliente.cve_per order by nom_per, direc_per, tel_per, tipo_cli ASC;";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> clientes = new ArrayList<>();

			while (rs.next()) {


				String cliente = rs.getString(1)+", "+rs.getString(2) +", "+rs.getString(3) +", "+rs.getString(4);

				clientes.add(cliente);
			}
			return clientes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	

	public String modificarCliente(Cliente newcliente, Cliente oldcliente) {

		String cveper = "set @cveper = (select cve_per from persona where nom_per='"+oldcliente.getNombre()+"' && direc_per='"+oldcliente.getDireccion()+
				"' && tel_per='"+oldcliente.getTelefono()+"')";

		
		String sql= "update persona set nom_per='"+newcliente.getNombre()+	"', direc_per='"+newcliente.getDireccion()+
				"', tel_per='"+newcliente.getTelefono()+ "' where nom_per='"+oldcliente.getNombre() +"' && direc_per='"+
				oldcliente.getDireccion()+ "' && tel_per='"+oldcliente.getTelefono()+"'";
		
		
		
		String sql2 = "update cliente set tipo_cli='"+newcliente.getTipo()+"' where cve_per=@cveper";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(cveper);
				statement.executeUpdate(sql);
				statement.executeUpdate(sql2);
				return "Cliente modificado";
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
	        String sql = "select nom_per from persona join cliente where persona.cve_per=cliente.cve_per group by nom_per;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("nom_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	

	 public ArrayList<String> llenar_comboDireccion(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select direc_per from persona join cliente where persona.cve_per=cliente.cve_per group by direc_per;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("direc_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	
	 
		

	 public ArrayList<String> llenar_comboTelefono(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select tel_per from persona join cliente where persona.cve_per=cliente.cve_per group by tel_per;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("tel_per" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 
	 public ArrayList<String> llenar_comboTipo(){
	        ArrayList<String> lista4 = new ArrayList<String>();
	        String sql = "select tipo_cli from cliente join persona where cliente.cve_per=persona.cve_per group by tipo_cli;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
	        	
	            while(rs.next()){

	                lista4.add(rs.getString("tipo_cli" ));
	        		
	            }
	        } catch (Exception e) {
	        }
	        return lista4;
	    }
	 

	
}


	
	
	
	
	

