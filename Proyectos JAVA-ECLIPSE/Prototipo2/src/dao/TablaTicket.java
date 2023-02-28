package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import conversores.Conversor;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Garantia;
import modelo.Venta;

public class TablaTicket {
	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaTicket(Connection conexion) {
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
	
	public Venta getVenta(String fecha, String hora){
		

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"+fecha+"' && hora_vent='"+hora+"')";

		String sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, numcilindros_cal, "
				+ "dimenciones_cal, marca_cal, precio_cal from venta join calentador on venta.cve_cal=calentador.cve_cal "
				+ " where cve_vent=@cvevent";
		
		Venta venta = new Venta();
		try {
			
			statement.executeUpdate(cvevent);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				venta.setFecha(Conversor.convertirADate(rs.getString(1)));
				venta.setHora(Time.valueOf(rs.getString(2)));
				venta.setPrecioTotal(Double.parseDouble(rs.getString(3)));
				venta.setCantidad(Integer.parseInt(rs.getString(4)));
				
				
				Calentador calentador = new Calentador();
				calentador.setTipo(rs.getString(5));
				calentador.setNumCilindros(Integer.parseInt(rs.getString(6)));
				calentador.setDimensiones(rs.getString(7));
				calentador.setMarca(rs.getString(8));
				calentador.setPrecio(Double.parseDouble(rs.getString(9)));
				
				venta.setCalentador(calentador);
				

			}
			return venta;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Cliente getCliente(String fecha, String hora){

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"+fecha+"' && hora_vent='"+hora+"')";
		
		String cvecli = "set @cvecli = (select cve_cli from venta where cve_vent=@cvevent)";
		
		String cveper = "set @cveper = (select cve_per from cliente where cve_cli=@cvecli)";

		String sql = "select nom_per, direc_per, tel_per from persona where cve_per=@cveper";

		Cliente cliente = new Cliente();
		try {
			statement.executeUpdate(cvevent);
			statement.executeUpdate(cvecli);
			statement.executeUpdate(cveper);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				cliente.setNombre(rs.getString(1));
				cliente.setDireccion(rs.getString(2));
				cliente.setTelefono(rs.getString(3));

			}
			return cliente;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Garantia getGarantia(String fecha, String hora){
		
		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"+fecha+"' && hora_vent='"+hora+"')";
		
		String cvegar = "set @cvegar = (select cve_gar from venta where cve_vent=@cvevent)";

		String sql = "select fechini_gar, fechfin_gar, tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal"
				+ " from garantia join calentador on garantia.cve_cal=calentador.cve_cal where cve_gar=@cvegar";

		Garantia garantia = new Garantia();
		try {
			statement.executeUpdate(cvevent);
			statement.executeUpdate(cvegar);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				
				garantia.setFechaInicio(Conversor.convertirADate(rs.getString(1)));
				garantia.setFechaFin(Conversor.convertirADate(rs.getString(2)));
				
				Calentador calentador = new Calentador();
				
				calentador.setTipo(rs.getString(3));
				calentador.setNumCilindros(Integer.parseInt(rs.getString(4)));
				calentador.setDimensiones(rs.getString(5));
				calentador.setMarca(rs.getString(6));
				calentador.setPrecio(Double.parseDouble(rs.getString(7)));
				
				garantia.setCalentador(calentador);

			}
			return garantia;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
