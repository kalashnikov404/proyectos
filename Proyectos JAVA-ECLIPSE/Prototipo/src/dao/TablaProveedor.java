package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Calentador;
import modelo.Persona;
import modelo.Proveedor;

public class TablaProveedor {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaProveedor(Connection conexion) {
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

	public String registrarPersona(Persona persona) {
		String sql = "insert into persona values(null,'"+persona.getNombre()+"','"
				+persona.getDireccion()+"','"+persona.getTelefono()+"', 'Mostrar')";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Persona registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public String registrarProveedor(Proveedor prov) {
		String clabe = "set @cveper=(select max(cve_per) from persona)";
		String sql = "insert into proveedor values(null,'"+prov.getRazonSocial()+"','"+prov.getEmail()+"', @cveper, 'Mostrar')";
		if(statement!=null) {
			try {
				statement.executeUpdate(clabe);
				statement.executeUpdate(sql);
				return "Proveedor registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}


	public List<Proveedor> getProveedor(Proveedor proveedor, String opcion){
		String sql = "";
		if(opcion.equals("Razon Social")) {
			sql = " select nom_per,direc_per,tel_per,razonsocial_prov,email_prov from persona join proveedor on persona.cve_per=proveedor.cve_per where razonsocial_prov='"
					+proveedor.getRazonSocial()+"' && estado_per='Mostrar' && estado_prov='Mostrar' order by razonsocial_prov ASC";
		}
		if(opcion.equals("E-mail")) {
			sql = " select nom_per,direc_per,tel_per,razonsocial_prov,email_prov from persona join proveedor on persona.cve_per=proveedor.cve_per where email_prov='"
					+proveedor.getEmail()+"' && estado_per='Mostrar' && estado_prov='Mostrar' order by email_prov ASC";
		}
		if(opcion.equals("Nombre")) {
			sql = " select nom_per,direc_per,tel_per,razonsocial_prov,email_prov from persona join proveedor on persona.cve_per=proveedor.cve_per where nom_per='"
					+proveedor.getNombre()+"' && estado_per='Mostrar' && estado_prov='Mostrar' order by nom_per ASC";
		}
		if(opcion.equals("Todo")) {
			sql = "select nom_per,direc_per,tel_per,razonsocial_prov,email_prov from persona join proveedor on persona.cve_per=proveedor.cve_per where estado_per='Mostrar' && estado_prov='Mostrar' order by nom_per ASC";
		}

		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Proveedor> prov = new ArrayList<>();
			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setNombre(rs.getString(1));
				p.setDireccion(rs.getString(2));
				p.setTelefono(rs.getString(3));
				p.setRazonSocial(rs.getString(4));
				p.setEmail(rs.getString(5));
				prov.add(p);
			}
			return prov;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaPersona(){
		String sql = "select nombre_per,direc_per,tel_per from persona where estado_per='Mostrar' order by nombre_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> persona = new ArrayList<>();
			while (rs.next()) {
				String per = rs.getString(1)+", "+rs.getString(2)+", "+
						rs.getString(3);
				persona.add(per);
			}
			return persona;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}


	public List<String> getListaProveedor(){
		String sql = " select nom_per,direc_per,tel_per,razonsocial_prov,email_prov from persona join proveedor on persona.cve_per=proveedor.cve_per where estado_per='Mostrar' && estado_prov='Mostrar'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaRazonSocial(){
		String sql = " select razonsocial_prov from  proveedor where estado_prov='Mostrar'order by razonsocial_prov ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	public List<String> getListaEmail(){
		String sql = " select email_prov from  proveedor where estado_prov='Mostrar' order by email_prov ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaNombre(){
		String sql = "select nom_per from persona join proveedor on persona.cve_per=proveedor.cve_per where estado_per='Mostrar' && estado_prov='Mostrar' order by nom_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}





	public String modificarPersona(Persona newpersona, Persona oldpersona) {

		String sql = "update persona set nom_per='"+newpersona.getNombre()+
				"', direc_per='"+newpersona.getDireccion()+
				"', tel_per='"+newpersona.getTelefono()+
				"' where nom_per='"+oldpersona.getNombre()+
				"' && direc_per='"+oldpersona.getDireccion()+
				"' && tel_per='"+oldpersona.getTelefono()+"'";
		System.out.println(sql);
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Persona modificada";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public String modificarProveedor(Proveedor newproveedor, Proveedor oldproveedor) {
		String sql = "update proveedor set razonsocial_prov='"+newproveedor.getRazonSocial()+
				"', email_prov='"+newproveedor.getEmail()+
				"' where razonsocial_prov='"+oldproveedor.getRazonSocial()+
				"' && email_prov='"+oldproveedor.getEmail()+"'";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Proveedor modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}


	public String eliminarProveedor(Persona persona, Proveedor proveedor) {

		String cveper = "set @cveper = (select cve_per from persona where nom_per='"+persona.getNombre()+
				"' && direc_per='"+persona.getDireccion()+"' && tel_per='"+persona.getTelefono()+
				"')";

		String cveprov = "set @cveprov = (select cve_prov from proveedor where razonsocial_prov='"+
				proveedor.getRazonSocial()+"' && email_prov='"+proveedor.getEmail()+"' && cve_per=@cveper)";

		String sql = "update persona set estado_per='No mostrar' where cve_per=@cveper";
		
		String sql2 = "update proveedor set estado_prov='No mostrar' where cve_prov=@cveprov";

		if(statement!=null) {
			try {
				statement.executeUpdate(cveper);
				statement.executeUpdate(cveprov);
				statement.executeUpdate(sql);
				statement.executeUpdate(sql2);
				return "Proveedor borrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

}
