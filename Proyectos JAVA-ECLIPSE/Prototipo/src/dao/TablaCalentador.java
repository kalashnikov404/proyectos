package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Calentador;
import modelo.Transporte;


public class TablaCalentador {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaCalentador(Connection conexion) {
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

	public String registrar(Calentador calentador) {

		String sql = "insert into calentador values(null, '"
				+calentador.getTipo()+"',"+calentador.getNumCilindros()+",'"+calentador.getDimensiones()+
				"','"+calentador.getMarca()+"',"+calentador.getPrecio()+", 'Mostrar')";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Calentador registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("Error, no hay sentencia");
		}
		return sql.toString();
	}


	public List<Calentador> getCalentador(Calentador calentador, String opcion){

		String sql = "";

		if(opcion.equals("Tipo")) {
			sql = "select tipo_cal from calentador where tipo_cal='"+calentador.getTipo()+"' && estado_cal='Mostrar' order by tipo_cal ASC";
		}

		if(opcion.equals("Todo")) {
			sql = "select tipo_cal from calentador where estado_cal='Mostrar' order by tipo_cal, tipo_cal ASC";
		}

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Calentador> calentadores = new ArrayList<>();

			while (rs.next()) {

				Calentador cal = new Calentador();

				cal.setTipo(rs.getString(1));

				calentadores.add(cal);
			}
			return calentadores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}


	public List<String> getListaTipos(){

		String sql = "select tipo_cal from calentador where estado_cal='Mostrar' group by tipo_cal order by tipo_cal ASC";

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


	public List<String> getListaNumeroCilindros(){

		String sql = "select numcilindros_cal from calentador where estado_cal='Mostrar' group by numcilindros_cal order by numcilindros_cal ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> numeroCilindros = new ArrayList<>();

			while (rs.next()) {


				String numeroCilindro = rs.getString(1);

				numeroCilindros.add(numeroCilindro);
			}
			return numeroCilindros;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaDimensiones(){

		String sql = "select dimenciones_cal from calentador where estado_cal='Mostrar' group by dimenciones_cal order by dimenciones_cal ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> dimensiones = new ArrayList<>();

			while (rs.next()) {


				String dimension = rs.getString(1);

				dimensiones.add(dimension);
			}
			return dimensiones;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaMarca(){

		String sql = "select marca_cal from calentador where estado_cal='Mostrar' group by marca_cal order by marca_cal ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> marcas = new ArrayList<>();

			while (rs.next()) {

				String marca = rs.getString(1);

				marcas.add(marca);
			}
			return marcas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaPrecio(){

		String sql = "select precio_cal from calentador where estado_cal='Mostrar' group by precio_cal order by precio_cal ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> precios = new ArrayList<>();

			while (rs.next()) {

				String precio = rs.getString(1);

				precios.add(precio);
			}
			return precios;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}


	}

	public List<Calentador> getCalentadores(Calentador calentador, String opcion){

		String sql = "";

		if(opcion.equals("Tipo")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where tipo_cal='"+calentador.getTipo()+"' && estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}

		if(opcion.equals("Numero Cilindros")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where numcilindros_cal='"+calentador.getNumCilindros()+"' && estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}

		if(opcion.equals("Dimensiones")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where dimenciones_cal='"+calentador.getDimensiones()+"' && estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}
		if(opcion.equals("Marca")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where marca_cal='"+calentador.getMarca()+"' && estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}
		if(opcion.equals("Precio")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where precio_cal='"+calentador.getPrecio()+"' && estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}
		if(opcion.equals("Todo")) {
			sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where  estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";
		}

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Calentador> calentadores = new ArrayList<>();

			while (rs.next()) {

				Calentador calentadorres = new Calentador();

				calentadorres.setTipo(rs.getString(1));
				calentadorres.setNumCilindros(Integer.parseInt(rs.getString(2)));
				calentadorres.setDimensiones(rs.getString(3));
				calentadorres.setMarca(rs.getString(4));
				calentadorres.setPrecio(Double.parseDouble(rs.getString(5)));

				calentadores.add(calentadorres);
			}
			return calentadores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaCalentador(){

		String sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where estado_cal='Mostrar' order by tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> calentadores = new ArrayList<>();

			while (rs.next()) {


				String calentador = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5);

				calentadores.add(calentador);
			}
			return calentadores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String modificarCalentador(Calentador newcalentador, Calentador oldcalentador) {

		String sql = "update calentador set tipo_cal='"+newcalentador.getTipo()+
				"' ,numcilindros_cal="+newcalentador.getNumCilindros()+",dimenciones_cal='"
				+newcalentador.getDimensiones()+"',marca_cal='"+newcalentador.getMarca()+
				"',precio_cal="+newcalentador.getPrecio()
				+ " where tipo_cal='"+oldcalentador.getTipo()+"' "
				+ "&& numcilindros_cal="+oldcalentador.getNumCilindros()+" && dimenciones_cal='"
				+oldcalentador.getDimensiones()+"' && marca_cal='"+oldcalentador.getMarca()+
				"' && precio_cal="+oldcalentador.getPrecio()+" && estado_cal='Mostrar'";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Calentador modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public List<String> getListaCalentadores(){
		String sql = " select tipo_cal,numcilindros_cal, dimenciones_cal, marca_cal,precio_cal from calentador where estado_cal='Mostrar'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> calentadores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5);
				calentadores.add(proveedor);
			}
			return calentadores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String eliminarCalentador(Calentador oldcalentador) {

		String cvecal = "set @cvecal = (select cve_cal from calentador where tipo_cal='"+oldcalentador.getTipo()+
				"' && numcilindros_cal="+oldcalentador.getNumCilindros()+" && dimenciones_cal='"+oldcalentador.getDimensiones()+
				"' && marca_cal='"+oldcalentador.getMarca()+"' && precio_cal="+oldcalentador.getPrecio()+")";
		
		String sql = "update calentador set estado_cal='No mostrar' where cve_cal=@cvecal";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(cvecal);
				statement.executeUpdate(sql);
				return "Calentador borrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}


}
