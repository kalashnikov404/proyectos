package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Horario;
import modelo.Persona;
import modelo.Transporte;

public class TablaHorario {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaHorario(Connection conexion) {
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

	public List<Horario> getHorarios(Horario horario, String opcion){

		String sql = "";

		if(opcion.equals("Fecha de asignación")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario where fechaasg_hor='"
		+Conversor.convertirDate(horario.getFechaAsignacion())+"' order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor ASC";
		}
		
		if(opcion.equals("Día")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario where dia_hor='"+
		horario.getDia()+"' order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor ASC";
		}
		
		if(opcion.equals("Hora entrada")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario where hrentrada_hor='"+
		horario.getHrEntrada()+"' order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor ASC";
		}
		
		if(opcion.equals("Hora salida")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario where hrsalida_hor='"+
		horario.getHrSalida()+"' order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor ASC";
		}
		
		if(opcion.equals("Empleado")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario where rfc_emp='"+
		horario.getRfc()+"' order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor ASC";
		}

		if(opcion.equals("Todo")) {
			sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario order by fechaasg_hor, dia_hor, "
					+ "hrentrada_hor, hrsalida_hor ASC";
		}
		
		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Horario> horarios = new ArrayList<>();

			while (rs.next()) {

				Horario horariosres = new Horario();

				horariosres.setFechaAsignacion(Conversor.convertirADate(rs.getString(1)));
				horariosres.setDia(rs.getString(2));
				horariosres.setHrEntrada(Time.valueOf(rs.getString(3)));
				horariosres.setHrSalida(Time.valueOf(rs.getString(4)));
				horariosres.setRfc(rs.getString(5));

				horarios.add(horariosres);
			}
			return horarios;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String registrarHorario(Horario horario) {
		String sql = "insert into horario values(null,curdate(),'"+
	horario.getDia()+"', '"+horario.getHrEntrada()+"', '"+horario.getHrSalida()+"', '"+horario.getRfc()
	+"')";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);

				return "Horario registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	public String modificarHorario(Horario newHorario, Horario oldHorario) {	
		String sql = "update horario set fechaasg_hor='"+Conversor.convertirDate(newHorario.getFechaAsignacion())+
				"', dia_hor='"+newHorario.getDia()+
				"', hrentrada_hor='"+newHorario.getHrEntrada()+
				"', hrsalida_hor='"+newHorario.getHrSalida()+
				"', rfc_emp='"+newHorario.getRfc()+
				
				"' where fechaasg_hor='"+Conversor.convertirDate(oldHorario.getFechaAsignacion())+
				"' && dia_hor='"+oldHorario.getDia()+
				"' && hrentrada_hor='"+oldHorario.getHrEntrada()+
				"' && hrsalida_hor='"+oldHorario.getHrSalida()+
				"' && rfc_emp='"+oldHorario.getRfc()
				+"'";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Horario modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	public List<String> getListaHorarios(){

		String sql = "select fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp from horario "
				+ "order by fechaasg_hor, dia_hor, hrentrada_hor, hrsalida_hor, rfc_emp ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> horarios = new ArrayList<>();

			while (rs.next()) {


				String horario = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+
						", "+rs.getString(5);

				horarios.add(horario);
			}
			return horarios;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
