package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Transporte;


public class TablaTransporte {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaTransporte(Connection conexion) {
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

	public String registrarTransporte(Transporte transporte) {

		String sql = "insert into transporte values(null, '"+transporte.getPlacas()+
				"', '"+transporte.getTipo()+"','Mostrar')";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Evento registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public List<Transporte> getTransportes(Transporte transporte, String opcion){

		String sql = "";

		if(opcion.equals("Placas")) {
			sql = "select placas_tran, tipo_tran from transporte where placas_tran='"+transporte.getPlacas()+"'&& estado_trans='Mostrar' order by placas_tran, tipo_tran ASC";
		}

		if(opcion.equals("Tipo")) {
			sql = "select placas_tran, tipo_tran from transporte where tipo_tran='"+transporte.getTipo()+"' && estado_trans='Mostrar' order by placas_tran, tipo_tran ASC";
		}

		if(opcion.equals("Todo")) {
			sql = "select placas_tran, tipo_tran from transporte where estado_trans='Mostrar' order by placas_tran, tipo_tran ASC";
		}

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Transporte> transportes = new ArrayList<>();

			while (rs.next()) {

				Transporte transporteres = new Transporte();

				transporteres.setPlacas(rs.getString(1));
				transporteres.setTipo(rs.getString(2));

				transportes.add(transporteres);
			}
			return transportes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaTransportes(){

		String sql = "select placas_tran, tipo_tran from transporte where estado_trans='Mostrar' order by placas_tran, tipo_tran ASC";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> transportes = new ArrayList<>();

			while (rs.next()) {


				String transporte = rs.getString(1)+", "+rs.getString(2);

				transportes.add(transporte);
			}
			return transportes;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String modificarTransporte(Transporte newtransporte, Transporte oldtransporte) {

		String sql = "update transporte set placas_tran='"+newtransporte.getPlacas()+
				"', tipo_tran='"+newtransporte.getTipo()+
				"' where placas_tran='"+oldtransporte.getPlacas()+
				"' && tipo_tran='"+oldtransporte.getTipo()+"'&& estado_trans='Mostrar'";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Evento modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public List<String> getListaTipos(){
		String sql = "select tipo_tran from transporte where estado_trans='Mostrar' group by tipo_tran order by tipo_tran ASC";
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

	public List<String> getListaPlacas(){
		String sql = "select placas_tran from transporte where estado_trans='Mostrar'group by placas_tran order by placas_tran ASC";
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
	
	
	public String eliminarTransporte(Transporte oldtransporte) {

		String sql = "update transporte set estado_trans='No Mostrar' where placas_tran='"+oldtransporte.getPlacas()+
				"' && tipo_tran='"+oldtransporte.getTipo()+"'";

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Evento eliminado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	

}
