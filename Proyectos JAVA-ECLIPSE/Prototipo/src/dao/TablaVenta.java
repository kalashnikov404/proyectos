package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Garantia;
import modelo.Transporte;
import modelo.Venta;

public class TablaVenta {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaVenta(Connection conexion) {
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


	public String registrarVentaGarantia(Garantia garantia) {
		String cvecal ="set @cvecal=(select cve_cal from calentador where tipo_cal='"+garantia.getCalentador().getTipo()+
				"' && numcilindros_cal="+garantia.getCalentador().getNumCilindros()+
				" && dimenciones_cal='"+garantia.getCalentador().getDimensiones()+
				"' && marca_cal='"+garantia.getCalentador().getMarca()+
				"' && precio_cal="+garantia.getCalentador().getPrecio()+
				")";

		String cveper = "set @cveper=(select cve_per from persona where nom_per='"+
				garantia.getCliente().getNombre()+"' && direc_per='"+
				garantia.getCliente().getDireccion()+
				"' && tel_per='"+garantia.getCliente().getTelefono()+"')";

		String cvecli = "set @cvecli=(select cve_cli from cliente where tipo_cli='"+
				garantia.getCliente().getTipo()+"' && cve_per=@cveper)";

		String sql = "insert into garantia values(null, '"+Conversor.convertirDate(garantia.getFechaInicio())+
				"', '"+Conversor.convertirDate(garantia.getFechaFin())+ 
				"', @cvecal, @cvecli)";

		if(statement!=null) {
			try {
				statement.executeUpdate(cvecal);
				statement.executeUpdate(cveper);
				statement.executeUpdate(cvecli);
				statement.executeUpdate(sql);

				return "Garantia registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}

	public String registrarVenta(Venta venta) {

		String c = "set @cvegar=(Select MAX(cve_gar)from garantia)";

		String rfcemp = "set @rfcemp=(select rfc_emp from empleado where curp_emp='"+
				venta.getEmpleado().getCurp()+"' && numseguro_emp='"+venta.getEmpleado().getNumeroSeguro()+
				"')";



		String sql = "insert into venta values(null, '"+venta.getFecha()+
				"', '"+venta.getHora()+"', "+venta.getPrecioTotal()+
				", "+venta.getCantidad()+", @cvecal, @cvecli, @rfcemp, @cvegar)";


		if(statement!=null) {
			try {
				statement.executeUpdate(c);
				statement.executeUpdate(rfcemp);
				statement.executeUpdate(sql);
				return "Venta registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}

	public List<Venta> getVentas(Venta venta, String opcion){

		String sql = "";

		if(opcion.equals("Todo")) {
			sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, "
					+ "numcilindros_cal, marca_cal, nom_per, empleado.rfc_emp, fechfin_gar from "
					+ "venta join calentador on venta.cve_cal=calentador.cve_cal join cliente on "
					+ "venta.cve_cli=cliente.cve_cli join empleado on venta.rfc_emp=empleado.rfc_emp"
					+ " join garantia on venta.cve_gar=garantia.cve_gar join persona on "
					+ "cliente.cve_per=persona.cve_per";
		}

		if(opcion.equals("Cliente al que se atendio")) {
			sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, "
					+ "numcilindros_cal, marca_cal, nom_per, empleado.rfc_emp, fechfin_gar from "
					+ "venta join calentador on venta.cve_cal=calentador.cve_cal join cliente on "
					+ "venta.cve_cli=cliente.cve_cli join empleado on venta.rfc_emp=empleado.rfc_emp"
					+ " join garantia on venta.cve_gar=garantia.cve_gar join persona on "
					+ "cliente.cve_per=persona.cve_per where cliente.tipo_cli='"+venta.getCliente().getTipo()
					+"' && persona.nom_per='"+venta.getCliente().getNombre()
					+"' && persona.direc_per='"+venta.getCliente().getDireccion()
					+"' && persona.tel_per='"+venta.getCliente().getTelefono()+"'";
		}

		if(opcion.equals("Fecha")) {
			sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, "
					+ "numcilindros_cal, marca_cal, nom_per, empleado.rfc_emp, fechfin_gar from "
					+ "venta join calentador on venta.cve_cal=calentador.cve_cal join cliente on "
					+ "venta.cve_cli=cliente.cve_cli join empleado on venta.rfc_emp=empleado.rfc_emp"
					+ " join garantia on venta.cve_gar=garantia.cve_gar join persona on "
					+ "cliente.cve_per=persona.cve_per where venta.fecha_vent='"
					+Conversor.convertirDate(venta.getFecha())+"'";
		}

		if(opcion.equals("Hora")) {
			sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, "
					+ "numcilindros_cal, marca_cal, nom_per, empleado.rfc_emp, fechfin_gar from "
					+ "venta join calentador on venta.cve_cal=calentador.cve_cal join cliente on "
					+ "venta.cve_cli=cliente.cve_cli join empleado on venta.rfc_emp=empleado.rfc_emp"
					+ " join garantia on venta.cve_gar=garantia.cve_gar join persona on "
					+ "cliente.cve_per=persona.cve_per where venta.hora_vent='"
					+venta.getHora()+"'";
		}


		try {
			ResultSet rs = statement.executeQuery(sql);

			List<Venta> ventas = new ArrayList<>();

			while (rs.next()) {

				Venta ventares = new Venta();

				ventares.setFecha(Conversor.convertirADate(rs.getString(1)));
				ventares.setHora(Time.valueOf(rs.getString(2)));
				ventares.setPrecioTotal(Double.parseDouble(rs.getString(3)));
				ventares.setCantidad(Integer.parseInt(rs.getString(4)));

				Calentador calentador = new Calentador();

				calentador.setTipo(rs.getString(5));
				calentador.setNumCilindros(Integer.parseInt(rs.getString(6)));
				calentador.setMarca(rs.getString(7));

				ventares.setCalentador(calentador);

				Cliente cliente = new Cliente();

				cliente.setNombre(rs.getString(8));

				ventares.setCliente(cliente);

				Empleado empleado = new Empleado();

				empleado.setRfc(rs.getString(9));

				ventares.setEmpleado(empleado);

				Garantia garantia = new Garantia();

				garantia.setFechaFin(Conversor.convertirADate(rs.getString(10)));

				ventares.setGarantia(garantia);

				ventas.add(ventares);
			}
			return ventas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<String> getListaVentas(){

		String sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, tipo_cal, "
				+ "numcilindros_cal, marca_cal, nom_per, empleado.rfc_emp, fechfin_gar from "
				+ "venta join calentador on venta.cve_cal=calentador.cve_cal join cliente on "
				+ "venta.cve_cli=cliente.cve_cli join empleado on venta.rfc_emp=empleado.rfc_emp"
				+ " join garantia on venta.cve_gar=garantia.cve_gar join persona on "
				+ "cliente.cve_per=persona.cve_per";

		try {
			ResultSet rs = statement.executeQuery(sql);

			List<String> ventas = new ArrayList<>();

			while (rs.next()) {


				String venta = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+
						", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(7)+", "+rs.getString(8)+
						", "+rs.getString(9)+", "+rs.getString(10);

				ventas.add(venta);
			}
			return ventas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String getCalentadorDeVenta(Venta venta){

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(venta.getFecha())+"' && hora_vent='"+venta.getHora()+"')";

		String cvecal = "set @cvecal = (select cve_cal from venta where venta.cve_vent=@cvevent)";

		String sql = "select tipo_cal, numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from"
				+ " calentador where cve_cal=@cvecal";

		String calentador = "";
		try {
			statement.executeUpdate(cvevent);
			statement.executeUpdate(cvecal);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {


				calentador = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+
						", "+rs.getString(5);

			}
			return calentador;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String getClienteDeVenta(){

		String cvecli = "set @cvecli = (select cve_cli from venta where venta.cve_vent=@cvevent)";

		String sql = "select nom_per, direc_per, tel_per, tipo_cli from cliente join persona on"
				+ " cliente.cve_per=persona.cve_per"
				+ " where cve_cli=@cvecli";

		String cliente = "";
		try {
			statement.executeUpdate(cvecli);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {


				cliente = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4);

			}
			return cliente;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String getEmpleadoDeVenta(){

		String rfcemp = "set @rfcemp = (select rfc_emp from venta where venta.cve_vent=@cvevent)";

		String sql = "select nom_per, direc_per, tel_per, rfc_emp, curp_emp, numseguro_emp"
				+ " from empleado join persona on"
				+ " empleado.cve_per=persona.cve_per"
				+ " where rfc_emp=@rfcemp";

		String empleado = "";
		try {
			statement.executeUpdate(rfcemp);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {


				empleado = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+
						", "+rs.getString(5)+", "+rs.getString(6);

			}
			return empleado;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public Venta getVenta(Venta ventaEntrada){

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(ventaEntrada.getFecha())+"' && hora_vent='"+ventaEntrada.getHora()+"')";

		String sql = "select fecha_vent, hora_vent, preciototal_vent, cantidad_vent, cve_cal, cve_cli, rfc_emp, cve_gar "
				+ "from venta where cve_vent=@cvevent";

		Venta venta = new Venta();
		try {
			statement.executeUpdate(cvevent);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				venta.setFecha(Conversor.convertirADate(rs.getString(1)));
				venta.setHora(Conversor.convertirHora(rs.getString(2)));
				venta.setPrecioTotal(Double.parseDouble(rs.getString(3)));
				venta.setCantidad(Integer.parseInt(rs.getString(4)));


				Calentador calentador = new Calentador();
				calentador.setNumCilindros(Integer.parseInt(rs.getString(5))); 
				venta.setCalentador(calentador);

				Cliente cliente = new Cliente();
				cliente.setTelefono(rs.getString(6));
				venta.setCliente(cliente);

				Empleado empleado = new Empleado();
				empleado.setTelefono(rs.getString(7));
				empleado.setNumeroSeguro(rs.getString(8));
				venta.setEmpleado(empleado);

			}
			return venta;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String modificarVenta(Venta oldVenta, Venta newVenta) {

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(oldVenta.getFecha())+"' && hora_vent='"+oldVenta.getHora()+"')";

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


		String sql = "update venta set preciototal_vent="+newVenta.getPrecioTotal()+
				", cantidad_vent="+newVenta.getCantidad()+", cve_cal=@cvecal, cve_cli=@cvecli, rfc_emp='"+
				newVenta.getEmpleado().getRfc()+"' where cve_vent=@cvevent";

		if(statement!=null) {
			try {
				statement.executeUpdate(cvevent);
				statement.executeUpdate(cvecal);
				statement.executeUpdate(cvecli);
				statement.executeUpdate(sql);
				return "Venta modificada";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}

	public String getGarantiaFechas(Venta venta){

		String cvevent = "set @cvevent = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(venta.getFecha())+"' && hora_vent='"+venta.getHora()+"')";

		String cvegar = "set @cvegar = (select cve_gar from venta where cve_vent=@cvevent)";

		String sql = "select fechini_gar, fechfin_gar from garantia where cve_gar=@cvegar";

		String cliente = "";
		try {
			statement.executeUpdate(cvevent);
			statement.executeUpdate(cvegar);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {


				cliente = rs.getString(1)+", "+rs.getString(2);

			}
			return cliente;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public int getTotalCant(Calentador calentador){

		String cvecal ="set @cvecal=(select cve_cal from calentador where tipo_cal='"+calentador.getTipo()+
				"' && numcilindros_cal="+calentador.getNumCilindros()+
				" && dimenciones_cal='"+calentador.getDimensiones()+
				"' && marca_cal='"+calentador.getMarca()+
				"' && precio_cal="+calentador.getPrecio()+
				")";

		String cant = "set @cantidadtotal = (select sum(baja_com) from detallecompra where cve_cal=@cvecal)";

		String sql1 = "update detallecompra set baja_com=0 where cve_cal=@cvecal";

		String maxcve = "set @maxcve = (select max(cve_com) from detallecompra where cve_cal=@cvecal)";

		String sql2 = "update detallecompra set baja_com=@cantidadtotal where cve_com=@maxcve";

		String fincant = "select @cantidadtotal";

		try {
			statement.executeUpdate(cvecal);
			statement.executeUpdate(cant);
			statement.executeUpdate(sql1);
			//statement.executeUpdate(maxfech);
			statement.executeUpdate(maxcve);
			statement.executeUpdate(sql2);
			ResultSet rs = statement.executeQuery(fincant);

			int cantidad = 0;

			while (rs.next()) {


				cantidad = Integer.parseInt(rs.getString(1));

			}
			return cantidad;
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	public void actualizarCantidad(Garantia garantia, Venta venta, int cantidadfinal){

		String cvecal ="set @cvecal=(select cve_cal from calentador where tipo_cal='"+garantia.getCalentador().getTipo()+
				"' && numcilindros_cal="+garantia.getCalentador().getNumCilindros()+
				" && dimenciones_cal='"+garantia.getCalentador().getDimensiones()+
				"' && marca_cal='"+garantia.getCalentador().getMarca()+
				"' && precio_cal="+garantia.getCalentador().getPrecio()+
				")";

		String maxcve = "set @maxcve = (select max(cve_com) from detallecompra where cve_cal=@cvecal)";

		String sql2 = "update detallecompra set baja_com="+cantidadfinal+" where cve_com=@maxcve";

		if(statement!=null) {
			try {
				statement.executeUpdate(cvecal);
				statement.executeUpdate(maxcve);
				statement.executeUpdate(sql2);
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
	}
	
	public void modificarCantidad(Venta oldVenta, Venta newVenta, int antiguacantidad) {
		
		String cveventOLD = "set @cveventold = (select cve_vent from venta where fecha_vent='"
				+Conversor.convertirDate(oldVenta.getFecha())+"' && hora_vent='"+oldVenta.getHora()+"')";

		String cvecalOLD = "set @cvecalold = (select cve_cal from venta where cve_vent=@cveventold)";

		String cvecalNEW = "set @cvecalnew = (select cve_cal from calentador where tipo_cal='"
				+newVenta.getCalentador().getTipo()+"' && numcilindros_cal="+newVenta.getCalentador().getNumCilindros()
				+" && dimenciones_cal='"+newVenta.getCalentador().getDimensiones()+
				"' && marca_cal='"+newVenta.getCalentador().getMarca()+"' && precio_cal="+newVenta.getCalentador().getPrecio()+
				")";
		
		String maxcveOLD = "set @maxcveold = (select max(cve_com) from detallecompra where cve_cal=@cvecalold)";
		
		String maxcveNEW = "set @maxcvenew = (select max(cve_com) from detallecompra where cve_cal=@cvecalnew)";
		
		String antiguacant = "set @antiguacant = ("+antiguacantidad+")";
 
		String sqlOLD = "update detallecompra set baja_com=baja_com+@antiguacant where cve_com=@maxcveold";
		
		String sqlNEW = "update detallecompra set baja_com=baja_com-"+newVenta.getCantidad()+" where cve_com=@maxcvenew";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(cveventOLD);
				statement.executeUpdate(cvecalOLD);
				statement.executeUpdate(cvecalNEW);
				statement.executeUpdate(maxcveOLD);
				statement.executeUpdate(maxcveNEW);
				statement.executeUpdate(antiguacant);
				statement.executeUpdate(sqlOLD);
				statement.executeUpdate(sqlNEW);
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
	}

}
