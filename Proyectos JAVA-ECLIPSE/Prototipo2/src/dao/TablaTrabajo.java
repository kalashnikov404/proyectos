package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Empleado;
import modelo.Trabajo;
import modelo.Transporte;

public class TablaTrabajo {

	private Connection conexion;
	private java.sql.Statement statement;

	String sqlConsulta = "";
	String sqlConsulta2 = "";

	private List<Trabajo> trabajosConsulta = new ArrayList<>();

	public TablaTrabajo(Connection conexion) {
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

	public String registrarTrabajo(Trabajo trabajo) {

		String obtenerTransporte="";

		if(trabajo.getTransporte()==null) {
			obtenerTransporte = "set @cvetran=null";
		}else {
			obtenerTransporte = "set @cvetran=(select cve_tran from transporte where estado_trans='Mostrar' && placas_tran='"+
					trabajo.getTransporte().getPlacas()+"' && tipo_tran='"+trabajo.getTransporte().getTipo()+"')";
		}


		String sql = "insert into trabajo values(null, '"+trabajo.getTipo()+"', '"+trabajo.getHora()+
				"', '"+trabajo.getFecha()+"', '"+trabajo.getEmpleado().getRfc()+
				"', @cvetran)";

		if(statement!=null) {
			try {
				statement.executeUpdate(obtenerTransporte);
				statement.executeUpdate(sql);
				return "Trabajo registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public List<String> getListaTipos(){

		String sql = "select tipo_tra from trabajo group by tipo_tra order by tipo_tra ASC";

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

	public List<String> getListaTrabajosConTransporte(){

		String sql = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
				+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
				+ "placas_tran ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> tipos = new ArrayList<>();

			while (rs.next()) {


				String tipo = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+
						", "+rs.getString(5);

				tipos.add(tipo);
			}
			return tipos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaTrabajosSinTransporte(){

		String sql = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL order "
				+ "by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> tipos = new ArrayList<>();

			while (rs.next()) {


				String tipo = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4);

				tipos.add(tipo);
			}
			return tipos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String modificarTrabajo(Trabajo newtrabajo, Trabajo oldtrabajo) {

		String obtenerOldTransporte = "";
		String obtenerNewTransporte = "";
		String sql = "";

		//No tiene y no quiere
		if(oldtrabajo.getTransporte()==null && newtrabajo.getTransporte()==null) {

			obtenerOldTransporte = "set @cvetranold=null";

			obtenerNewTransporte = "set @cvetrannew=null";

			sql = "update trabajo set tipo_tra='"+newtrabajo.getTipo()+"', hora_tra='"+newtrabajo.getHora()+
					"', rfc_emp='"+newtrabajo.getEmpleado().getRfc()+"', cve_tran=@cvetrannew "
					+ "where tipo_tra='"+oldtrabajo.getTipo()+
					"' && hora_tra='"+oldtrabajo.getHora()+"' && fecha_tra='"+Conversor.convertirDate(oldtrabajo.getFecha())+
					"' && rfc_emp='"+oldtrabajo.getEmpleado().getRfc()+"' && cve_tran is null";

		}

		//No tiene y quiere
		if(oldtrabajo.getTransporte()==null && (!(newtrabajo.getTransporte()==null))){

			obtenerOldTransporte = "set @cvetranold=null";

			obtenerNewTransporte = "set @cvetrannew=(select cve_tran from transporte where estado_trans='Mostrar' && placas_tran='"+
					newtrabajo.getTransporte().getPlacas()+"' && tipo_tran='"+newtrabajo.getTransporte().getTipo()+"')";

			sql = "update trabajo set tipo_tra='"+newtrabajo.getTipo()+"', hora_tra='"+newtrabajo.getHora()+
					"', rfc_emp='"+newtrabajo.getEmpleado().getRfc()+"', cve_tran=@cvetrannew "
					+ "where tipo_tra='"+oldtrabajo.getTipo()+
					"' && hora_tra='"+oldtrabajo.getHora()+"' && fecha_tra='"+Conversor.convertirDate(oldtrabajo.getFecha())+
					"' && rfc_emp='"+oldtrabajo.getEmpleado().getRfc()+"' && cve_tran is null";

		}

		//Tiene y no quiere
		if((!(oldtrabajo.getTransporte()==null)) && (newtrabajo.getTransporte()==null)){

			obtenerOldTransporte = "set @cvetranold=(select cve_tran from transporte where estado_trans='Mostrar' && placas_tran='"+
					oldtrabajo.getTransporte().getPlacas()+"' && tipo_tran='"+oldtrabajo.getTransporte().getTipo()+"')";

			obtenerNewTransporte = "set @cvetrannew=null";

			sql = "update trabajo set tipo_tra='"+newtrabajo.getTipo()+"', hora_tra='"+newtrabajo.getHora()+
					"', rfc_emp='"+newtrabajo.getEmpleado().getRfc()+"', cve_tran=@cvetrannew "
					+ "where tipo_tra='"+oldtrabajo.getTipo()+
					"' && hora_tra='"+oldtrabajo.getHora()+"' && fecha_tra='"+Conversor.convertirDate(oldtrabajo.getFecha())+
					"' && rfc_emp='"+oldtrabajo.getEmpleado().getRfc()+"' && cve_tran=@cvetranold";

		}

		//Tiene y quiere otro
		if((!(oldtrabajo.getTransporte()==null)) && (!(newtrabajo.getTransporte()==null))){

			obtenerOldTransporte = "set @cvetranold=(select cve_tran from transporte where estado_trans='Mostrar' && placas_tran='"+
					oldtrabajo.getTransporte().getPlacas()+"' && tipo_tran='"+oldtrabajo.getTransporte().getTipo()+"')";

			obtenerNewTransporte = "set @cvetrannew=(select cve_tran from transporte where  estado_trans='Mostrar' && placas_tran='"+
					newtrabajo.getTransporte().getPlacas()+"' && tipo_tran='"+newtrabajo.getTransporte().getTipo()+"')";

			sql = "update trabajo set tipo_tra='"+newtrabajo.getTipo()+"', hora_tra='"+newtrabajo.getHora()+
					"', rfc_emp='"+newtrabajo.getEmpleado().getRfc()+"', cve_tran=@cvetrannew "
					+ "where tipo_tra='"+oldtrabajo.getTipo()+
					"' && hora_tra='"+oldtrabajo.getHora()+"' && fecha_tra='"+Conversor.convertirDate(oldtrabajo.getFecha())+
					"' && rfc_emp='"+oldtrabajo.getEmpleado().getRfc()+"' && cve_tran=@cvetranold";

		}

		if(statement!=null) {
			try {
				statement.executeUpdate(obtenerOldTransporte);
				statement.executeUpdate(obtenerNewTransporte);
				statement.executeUpdate(sql);
				return "Trabajo modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public String getEmpleadoCB(String rfc){

		String sql = "select nom_per,direc_per,tel_per,rfc_emp,curp_emp,numseguro_emp from persona join "
				+ "empleado on persona.cve_per=empleado.cve_per where rfc_emp='"+rfc+"' order by nom_per ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);
			String tipo="";
			while (rs.next()) {


				tipo = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)
				+", "+rs.getString(5)+", "+rs.getString(6);

			}
			return tipo;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String getTransporteCB(String placas){

		String sql = "select placas_tran, tipo_tran from transporte where estado_trans='Mostrar' && placas_tran='"+placas+
				"' order by placas_tran, tipo_tran ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			String transporte="";

			while (rs.next()) {


				transporte = rs.getString(1)+", "+rs.getString(2);

			}
			return transporte;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Trabajo> getTrabajo(Trabajo trabajo, String opcion){



		if(opcion.equals("Todo")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";

			sqlConsulta2 = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL order "
					+ "by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";
		}

		if(opcion.equals("Tipo")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where tipo_tra='"+trabajo.getTipo()+
					"' && estado_trans='Mostrar' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";

			sqlConsulta2 = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL && tipo_tra='"
					+trabajo.getTipo()+
					"' order by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";
		}

		if(opcion.equals("Fecha")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' && fecha_tra='"+Conversor.convertirDate(trabajo.getFecha())
					+"' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";

			sqlConsulta2 = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL "
					+ "&& fecha_tra='"+Conversor.convertirDate(trabajo.getFecha())+"' order "
					+ "by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";
		}

		if(opcion.equals("Hora")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' && hora_tra='"+trabajo.getHora()+
					"' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";

			sqlConsulta2 = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL "
					+ "&& hora_tra='"+trabajo.getHora()+"' order "
					+ "by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";
		}

		if(opcion.equals("Empleado")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' && rfc_emp='"+trabajo.getEmpleado().getRfc()+
					"' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";

			sqlConsulta2 = "select tipo_tra, hora_tra, fecha_tra, rfc_emp from trabajo where cve_tran is NULL "
					+ "&& rfc_emp='"+trabajo.getEmpleado().getRfc()+"' order "
					+ "by tipo_tra, hora_tra, fecha_tra, rfc_emp ASC";
		}

		if(opcion.equals("Transporte")) {
			sqlConsulta = "select tipo_tra, hora_tra, fecha_tra, rfc_emp, placas_tran from trabajo join transporte on "
					+ "trabajo.cve_tran=transporte.cve_tran where estado_trans='Mostrar' &&  placas_tran='"+trabajo.getTransporte().getPlacas()+
					"' order by tipo_tra, hora_tra, fecha_tra, rfc_emp, "
					+ "placas_tran ASC";
		}
		

		try {

			ResultSet rs = statement.executeQuery(sqlConsulta);

			while (rs.next()) {

				Trabajo trabajor = new Trabajo();

				trabajor.setTipo(rs.getString(1));
				trabajor.setHora(Time.valueOf(rs.getString(2)));
				trabajor.setFecha(Conversor.convertirADate(rs.getString(3)));

				Empleado empleado = new Empleado();
				empleado.setRfc(rs.getString(4));

				trabajor.setEmpleado(empleado);

				Transporte transporte = new Transporte();
				transporte.setPlacas(rs.getString(5));

				trabajor.setTransporte(transporte);

				trabajosConsulta.add(trabajor);
			}
			
			if(!sqlConsulta2.equals("")) {
				getTrabajoParte2();
			}

			return trabajosConsulta;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public void getTrabajoParte2(){


		try {

			ResultSet rs2 = statement.executeQuery(sqlConsulta2);


			while (rs2.next()) {

				Trabajo trabajor = new Trabajo();

				trabajor.setTipo(rs2.getString(1));
				trabajor.setHora(Time.valueOf(rs2.getString(2)));
				trabajor.setFecha(Conversor.convertirADate(rs2.getString(3)));

				Empleado empleado = new Empleado();
				empleado.setRfc(rs2.getString(4));

				trabajor.setEmpleado(empleado);

				Transporte transporte = new Transporte();
				transporte.setPlacas("No uso transporte");

				trabajor.setTransporte(transporte);

				trabajosConsulta.add(trabajor);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
