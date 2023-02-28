package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Cliente;
import modelo.Vehiculo;

public class TablaCliente {

	private Connection conexion;
	private java.sql.Statement statement;
	private java.sql.Statement statementD;
	
	

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

	public String guardarCCV(Cliente cliente) {
		String sql = "insert into cliente values(null, '" + cliente.getCelular() + "', '"+ cliente.getCorreo() + "','" 
				+ cliente.getVehiculo().getPlacas() + "',null)";
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
	
	public String guardarV(Cliente cliente) {
		String sql = "insert into cliente values(null, null, null,'" 
				+ cliente.getVehiculo().getPlacas() + "',null)";
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
	
	public String guardarCoV(Cliente cliente) {
		String sql = "insert into cliente values(null, null, '"+ cliente.getCorreo() + "','" 
				+ cliente.getVehiculo().getPlacas() + "',null)";
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
	
	public String guardarCeV(Cliente cliente) {
		String sql = "insert into cliente values(null, '" + cliente.getCelular() + "', null,'" 
				+ cliente.getVehiculo().getPlacas() + "',null)";
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
	
	public String modificarCelular(int idCliente, String celular) {
		String sql = "update cliente set celular_cli='" + celular + "' where cve_cli="+idCliente;
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Cliente modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	public String modificarCorreo(int idCliente, String correo) {
		String sql = "update cliente set correo_cli='" + correo + "' where cve_cli="+idCliente;
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Cliente modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	public String eliminarCliente(int idCliente) {
		String sql = "delete from cliente where cve_cli="+idCliente;
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Cliente eliminado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	public List<Cliente> getClientes(){
		String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				Vehiculo vehiculo = new Vehiculo();
				
				cliente.setId(rs.getInt(1));
				cliente.setCelular(rs.getString(2));
				cliente.setCorreo(rs.getString(3));
				
				vehiculo.setPlacas(rs.getString(4));
				vehiculo.setModelo(rs.getString(5));
				vehiculo.setAño(rs.getInt(6));
				vehiculo.setMarca(rs.getString(7));
				vehiculo.setColor(rs.getString(8));
				vehiculo.setTamaño(Conversor.convertirATamaños(rs.getString(9)));
				vehiculo.setTipo(Conversor.convertirATipos(rs.getString(10)));
				
				cliente.setVehiculo(vehiculo);
				clientes.add(cliente);
			}
			return clientes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Cliente consultarPorId(int id) {
		String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cliente.cve_cli="+id;
		
		Cliente cliente = new Cliente();
		Vehiculo vehiculo = new Vehiculo();
		
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				cliente.setId(rs.getInt(1));
				cliente.setCelular(rs.getString(2));
				cliente.setCorreo(rs.getString(3));
				
				vehiculo.setPlacas(rs.getString(4));
				vehiculo.setModelo(rs.getString(5));
				vehiculo.setAño(rs.getInt(6));
				vehiculo.setMarca(rs.getString(7));
				vehiculo.setColor(rs.getString(8));
				vehiculo.setTamaño(Conversor.convertirATamaños(rs.getString(9)));
				vehiculo.setTipo(Conversor.convertirATipos(rs.getString(10)));
				
				cliente.setVehiculo(vehiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

}