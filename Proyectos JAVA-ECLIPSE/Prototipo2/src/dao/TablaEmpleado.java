package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Empleado;

public class TablaEmpleado {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaEmpleado(Connection conexion) {
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
	
	public String registrarEmpleado(Empleado emp) {
		String clabe = "set @cveper=(select max(cve_per) from persona)";
		String sql = "insert into empleado values('"+emp.getRfc()+"','"+emp.getCurp()+"','"+emp.getNumeroSeguro()+"', @cveper)";
			if(statement!=null) {
				try {
					statement.executeUpdate(clabe);
					statement.executeUpdate(sql);
					return "Empleado registrado";
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}else {
				System.out.println("eror, no hay sentencia");
			}
			return sql.toString();
		}
	
	
	
	public List<String> getListaEmpleado(){
		String sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per order by nom_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Empleado> getEmpleado(Empleado empleado, String opcion){
		String sql = "";
		if(opcion.equals("Nombre")) {
			 sql = " select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where nom_per='"
			+empleado.getNombre()+"' order by nom_per ASC";
		}
		if(opcion.equals("Direccion")) {
			 sql = " select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where direc_per='"
				+empleado.getDireccion()+"' order by direc_per ASC";
		}
		if(opcion.equals("Telefono")) {
			 sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where tel_per='"
			+empleado.getTelefono()+"' order by tel_per ASC";
		}
		if(opcion.equals("RFC")) {
			 sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where rfc_emp='"
			+empleado.getRfc()+"' order by rfc_emp ASC";
		}
		if(opcion.equals("CURP")) {
			 sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where curp_emp='"
			+empleado.getCurp()+"' order by curp_emp ASC";
		}
		if(opcion.equals("Num.Seguro")) {
			 sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per where numseguro_emp='"
			+empleado.getNumeroSeguro()+"' order by numseguro_emp ASC";
		}
		if(opcion.equals("Todo")) {
		sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join empleado on persona.cve_per=empleado.cve_per order by nom_per ASC";
				}
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Empleado> emp = new ArrayList<>();
			while (rs.next()) {
				Empleado e = new Empleado();
				e.setNombre(rs.getString(1));
				e.setDireccion(rs.getString(2));
				e.setTelefono(rs.getString(3));
				e.setRfc(rs.getString(4));
				e.setCurp(rs.getString(5));
				e.setNumeroSeguro(rs.getString(6));
				emp.add(e);
			}
			return emp;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaNombre(){
		String sql = "select nom_per from persona join empleado on persona.cve_per=empleado.cve_per order by nom_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<String> getListaDireccion(){
		String sql = "select direc_per from persona join empleado on persona.cve_per=empleado.cve_per order by direc_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<String> getListaTelefono(){
		String sql = "select tel_per from persona join empleado on persona.cve_per=empleado.cve_per order by tel_per ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<String> getListaRfc(){
		String sql = "Select rfc_emp from empleado order by rfc_emp ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<String> getListaCurp(){
		String sql = "Select curp_emp from empleado order by curp_emp ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaNumSeg(){
		String sql = "Select numseguro_emp from empleado order by numseguro_emp ASC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> empleados = new ArrayList<>();
			while (rs.next()) {
				String emp = rs.getString(1);
				empleados.add(emp);
			}
			return empleados;
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

	
	public String modificarEmpleado(Empleado newempleado, Empleado oldempleado) {	
		
		String ajuste1 = "SET FOREIGN_KEY_CHECKS = 0;";
		
		String sql = "update empleado set rfc_emp='"+newempleado.getRfc()+
				"', curp_emp='"+newempleado.getCurp()+
				"', numseguro_emp='"+newempleado.getNumeroSeguro()+
				"' where rfc_emp='"+oldempleado.getRfc()+
				"' && curp_emp='"+oldempleado.getCurp()+
				"' &&  numseguro_emp='"+oldempleado.getNumeroSeguro()+"'";
		
		String ajuste2 = "SET FOREIGN_KEY_CHECKS = 1;";
		
		System.out.println(sql);
		if(statement!=null) {
			try {
				statement.executeUpdate(ajuste1);
				statement.executeUpdate(sql);
				statement.executeUpdate(ajuste2);
				return "Empleado modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	
	

}
