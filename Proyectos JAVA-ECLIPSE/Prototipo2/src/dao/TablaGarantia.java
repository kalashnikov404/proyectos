package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Garantia;
import modelo.Transporte;
import modelo.Venta;

public class TablaGarantia {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaGarantia(Connection conexion) {
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

	public List<Garantia> getGarantia(Garantia garantia, String opcion){

		String sql = "";

		if(opcion.equals("Todo")) {
			sql  = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
					+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
					+ "persona on cliente.cve_per=persona.cve_per order by fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal,"
					+ " marca_cal, nom_per";
		}

		if(opcion.equals("Cliente")) {
			sql  = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
					+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
					+ "persona on cliente.cve_per=persona.cve_per where nom_per='"+garantia.getCliente().getNombre()+"' "+
					"order by fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per";;
		}

		if(opcion.equals("Fecha inicio")) {
			sql  = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
					+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
					+ "persona on cliente.cve_per=persona.cve_per where fechini_gar='"+
					Conversor.convertirDate(garantia.getFechaInicio())+"' "
					+ "order by fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per";
		}

		if(opcion.equals("Fecha fin")) {
			sql  = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
					+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
					+ "persona on cliente.cve_per=persona.cve_per where fechfin_gar='"+Conversor.convertirDate(garantia.getFechaFin())+"' "
					+ "order by fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per";
		}

		if(opcion.equals("Calentador")) {
			sql  = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
					+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
					+ "persona on cliente.cve_per=persona.cve_per where tipo_cal='"+garantia.getCalentador().getTipo()+"' && numcilindros_cal="
					+garantia.getCalentador().getNumCilindros()+" && marca_cal='"+garantia.getCalentador().getMarca()+"' "
					+ "order by fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per";;
		}

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Garantia> garantias = new ArrayList<>();

			while (rs.next()) {

				Garantia garantiares = new Garantia();

				garantiares.setFechaInicio(Conversor.convertirADate(rs.getString(1)));
				garantiares.setFechaFin(Conversor.convertirADate(rs.getString(2)));

				Calentador calentador = new Calentador();
				calentador.setTipo(rs.getString(3));
				calentador.setNumCilindros(Integer.parseInt(rs.getString(4)));
				calentador.setMarca(rs.getString(5));
				garantiares.setCalentador(calentador);

				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString(6));
				garantiares.setCliente(cliente);

				garantias.add(garantiares);
			}
			return garantias;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaGarantias(){

		String sql = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, marca_cal, nom_per from garantia join "
				+ "calentador on garantia.cve_cal=calentador.cve_cal join cliente on garantia.cve_cli=cliente.cve_cli join "
				+ "persona on cliente.cve_per=persona.cve_per order by fechini_gar, fechfin_gar, tipo_cal, "
				+ "numcilindros_cal, marca_cal, nom_per";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> garantias = new ArrayList<>();

			while (rs.next()) {

				String garantia = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+
						rs.getString(5)+", "+rs.getString(6);

				garantias.add(garantia);
			}
			return garantias;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String modificarGarantia(Venta oldVenta, Venta newVenta, Garantia garantia) {

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(oldVenta.getFecha())+"' && hora_vent='"+oldVenta.getHora()+"')";

		String cvegar = "set @cvegar = (select cve_gar from venta where cve_vent=@cvevent)";

		String cvecal = "set @cvecal = (select cve_cal from calentador where tipo_cal='"
				+newVenta.getCalentador().getTipo()+"' && numcilindros_cal="+newVenta.getCalentador().getNumCilindros()
				+" && dimenciones_cal='"+newVenta.getCalentador().getDimensiones()+
				"' && marca_cal='"+newVenta.getCalentador().getMarca()+"' && precio_cal="+newVenta.getCalentador().getPrecio()+
				")";

		String cvecli = "set @cvecli = (select cve_cli from cliente join persona on cliente.cve_per=persona.cve_per "
				+ "where nom_per='"+newVenta.getCliente().getNombre()+
				"' && direc_per='"+newVenta.getCliente().getDireccion()+
				"' && tel_per='"+newVenta.getCliente().getTelefono()+
				"' && tipo_cli='"+newVenta.getCliente().getTipo()+"')";


		String sql = "update garantia set fechini_gar='"+Conversor.convertirDate(garantia.getFechaInicio())+
				"', fechfin_gar='"+Conversor.convertirDate(garantia.getFechaFin())+
				"', cve_cal=@cvecal, cve_cli=@cvecli where cve_gar=@cvegar";

		if(statement!=null) {
			try {
				statement.executeUpdate(cvevent);
				statement.executeUpdate(cvegar);
				statement.executeUpdate(cvecal);
				statement.executeUpdate(cvecli);
				statement.executeUpdate(sql);
				return "Garantia modificada";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

}
