package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conversores.Conversor;
import modelo.Calentador;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Proveedor;

public class TablaCompra {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaCompra(Connection conexion) {
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
	
	public String registrarCompra(Compra compra) {
		String sql = "insert into compra values(null,curdate(),'"+compra.getTotal()+"')";
		
		System.out.println(sql+" /////compra");
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);

				return "Compra registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	public String registrarDetalleCompra(DetalleCompra dcompra) {
		String clabe = "set @cve=(select max(cve_cop) from compra)";
		
		String sql = "insert into detallecompra values(null,'"+
	dcompra.getCantidad()+"', '"+dcompra.getCosto()+"', '"+dcompra.getBaja()+"', '"+
				dcompra.getProveedor()+"', '"+dcompra.getCalentador()
	+"', '"+dcompra.getSubtotal()+"', @cve)";
		
		System.out.println(sql+" /////datellecompra");
		
		if(statement!=null) {
			try {
				statement.executeUpdate(clabe);
				statement.executeUpdate(sql);
				return "Compra registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	
	public List<String> getListaProveedor(){
		String sql = " select razonsocial_prov,email_prov from proveedor where estado_prov='Mostrar'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1)+", "+rs.getString(2);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public int getCveProveedor(String provee){
		String sql = " select cve_prov from proveedor where razonsocial_prov='"+provee+"' && estado_prov='Mostrar'";
		
		System.out.println(sql+" ////cveprov");
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Proveedor> proveedores = new ArrayList<>();
			if (rs.next()) {
				int cve=Integer.parseInt(rs.getString("cve_prov"));
				return cve;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public int getCveCalentador(String calen){
		String sql = " select cve_cal from calentador where tipo_cal='"+calen+"'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Proveedor> proveedores = new ArrayList<>();
			if (rs.next()) {
				int cve=Integer.parseInt(rs.getString("cve_cal"));
				return cve;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public int getCveDetalleCompra(String detalle){
		String sql = " select cve_prov from proveedor where razonsocial_prov='"+detalle+"' && estado_prov='Mostrar";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Proveedor> proveedores = new ArrayList<>();
			if (rs.next()) {
				int cve=Integer.parseInt(rs.getString("cve_prov"));
				return cve;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	
	
	
	
	

	public String modificarTotalCompra() {	
		// update compra set total_cop=1500.00 where cve_cop=1;
		String clabe = "set @cve=(select max(cve_cop) from compra)";
		String sql = "update compra set total_cop=(select sum(subtotal_com) from detallecompra where cve_cop= @cve) where cve_cop= @cve";
		System.out.println(sql);
		if(statement!=null) {
			try {
				statement.executeUpdate(clabe);
				statement.executeUpdate(sql);
				return "Total de compra colocado";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	public String modificarCompra(float total,String cve) {	
		String sql = "update compra set total_cop='"+total+
				"' where cve_cop='"+cve+"'";
		System.out.println(sql);
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Modificacion lista";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	public float getTotal(int cveCompra){
		String sql = "select sum(subtotal_com)as total from detallecompra where cve_cop='"+cveCompra+"'";
		System.out.println(sql);
		try {
			crearSentencia();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				float total=Float.parseFloat(rs.getString("total"));
				return total;
			} else {
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en consulta"+e.getMessage());
			return 0;
		}
	}
	
	public String modificarDetalleCompra(DetalleCompra newcompra,DetalleCompra oldcompra) {	
		String sql = "update detallecompra set cantidad_com='"+newcompra.getCantidad()+
				"', costo_com='"+newcompra.getCosto()+
				"', baja_com='"+newcompra.getBaja()+
				"', cve_prov='"+newcompra.getProveedor()+
				"', cve_cal='"+newcompra.getCalentador()+
				"', subtotal_com='"+newcompra.getSubtotal()+
				"' where cve_cop='"+oldcompra.getCveDetalle()
				+"'";
		System.out.println(sql+" Esto es del metodo");
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Modificacion completa";
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	public List<DetalleCompra> getDetalleCompra(DetalleCompra dcompra, String opcion){
		String sql = "";
		if(opcion.equals("Fecha")) {
			sql = "select fecha_cop, cantidad_com costo_com,subtotal_com, razonsocial_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where c.fecha_cop='"
		+Conversor.convertirDate(dcompra.getFecha())+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		
		if(opcion.equals("Proveedor")) {
			 sql = " select fecha_cop, cantidad_com costo_com,subtotal_com, razonsocial_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where dc.cve_prov='"
				+dcompra.getProveedor()+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		
		if(opcion.equals("Calentador")) {
			sql = "select fecha_cop, cantidad_com costo_com,subtotal_com, razonsocial_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where dc.cve_cal='"+
		dcompra.getCalentador()+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		if(opcion.equals("Todo")) {
			sql = "select fecha_cop, cantidad_com,costo_com,subtotal_com, razonsocial_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal  where estado_prov='Mostrar";
		}
		try {
			
			ResultSet rs = statement.executeQuery(sql);
			
			List<DetalleCompra> h = new ArrayList<>();
			List<Calentador> cal = new ArrayList<>();
			List<Proveedor> prov = new ArrayList<>();
			while (rs.next()) {
				DetalleCompra dc = new DetalleCompra();
				Calentador c=new Calentador();
				Proveedor p=new Proveedor();
				dc.setFecha(Conversor.convertirADate(rs.getString(1)));
				dc.setCantidad(Integer.parseInt(rs.getString(2)));
				dc.setCosto(Float.parseFloat(rs.getString(3)));
				dc.setSubtotal(Float.parseFloat(rs.getString(4)));
				p.setRazonSocial(rs.getString(4));
				c.setTipo(rs.getString(4));
				c.setNumCilindros(Integer.parseInt(rs.getString(2)));
				c.setDimensiones(rs.getString(2));
				c.setMarca(rs.getString(2));
				c.setPrecio(Double.parseDouble(rs.getString(4)));
			
				h.add(dc);
				cal.add(c);
				prov.add(p);
			}
			return h;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//Lo uso en registrarcompras 
	public List<DetalleCompra> getAgregarTabla(DetalleCompra dcompra, String opcion){
		String sql = "";
		String clabe= "";
		if(opcion.equals("Agregar")) {
			clabe = "set @cve=(select max(cve_cop) from compra)";
			sql = "select cantidad_com,costo_com,subtotal_com from detallecompra where cve_cop=@cve";
		}
		try {
			statement.executeUpdate(clabe);
			ResultSet rs = statement.executeQuery(sql);
			List<DetalleCompra> h = new ArrayList<>();
			while (rs.next()) {
				DetalleCompra dc = new DetalleCompra();
				dc.setCantidad(Integer.parseInt(rs.getString(1)));
				dc.setCosto(Float.parseFloat(rs.getString(2)));
				dc.setSubtotal(Float.parseFloat(rs.getString(3)));
				h.add(dc);
			}
			return h;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	

	
	
	//Para modificar en la tabla 
	public List<DetalleCompra> getListaModificarDetalle(DetalleCompra dcompra, String opcion){
		String sql = "";
		if(opcion.equals("Detalle")) {
			 sql = " select cantidad_com,costo_com,subtotal_com,cve_com from detallecompra where cve_cop='"
				+dcompra.getCve()+"' order by cantidad_com ASC";
		}
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<DetalleCompra> h = new ArrayList<>();
			while (rs.next()) {
				DetalleCompra dc = new DetalleCompra();
				dc.setCantidad(Integer.parseInt(rs.getString(1)));
				dc.setCosto(Float.parseFloat(rs.getString(2)));
				dc.setSubtotal(Float.parseFloat(rs.getString(3)));
				dc.setCveDetalle(Integer.parseInt(rs.getString(4)));
				h.add(dc);
			}
			return h;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	public List<String> getInventario(){
			String sql = "select tipo_cal, numcilindros_cal,dimenciones_cal,marca_cal,precio_cal, sum(baja_com) from calentador as c join detallecompra as dc on c.cve_cal=dc.cve_cal group by tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal";
			try {
				ResultSet rs = statement.executeQuery(sql);
				List<String> detalle = new ArrayList<>();
				while (rs.next()) {
					String com = rs.getString(1)+", "+rs.getString(2)
					+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6);
					detalle.add(com);
				}
				return detalle;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		}
		
	
	
	
	public List<Calentador> getTablaCalentadores(int cveDC){
		String sql = " select tipo_cal,numcilindros_cal, dimenciones_cal, marca_cal, precio_cal from calentador where cve_cal='"+cveDC+"'";
	System.out.println(sql);
		try {
			
			ResultSet rs = statement.executeQuery(sql);
			List<Calentador> h = new ArrayList<>();
			while (rs.next()) {
				Calentador c = new Calentador();
				c.setTipo(rs.getString(1));
				c.setNumCilindros(Integer.parseInt(rs.getString(2)));
				c.setDimensiones(rs.getString(3));
				c.setMarca(rs.getString(4));
				c.setPrecio(Double.parseDouble(rs.getString(5)));
				h.add(c);
			}
			return h;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	

	public List<String> getTablaProveedor(DetalleCompra cvDC){
		String sql = " select razonsocial_prov,email_prov from proveedor where cve_prov='"+cvDC.getProveedor()+"'  where estado_prov='Mostrar";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> proveedores = new ArrayList<>();
			while (rs.next()) {
				String proveedor = rs.getString(1)+", "+rs.getString(2);
				proveedores.add(proveedor);
			}
			return proveedores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<String> getListaCompra(){
		String sql = "select *from compra";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> compra = new ArrayList<>();
			while (rs.next()) {
				String com = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3);
				compra.add(com);
			}
			return compra;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	//Para las consultas de compra 
	
	
	public List<String> getDC(DetalleCompra dcompra, String opcion){
		String sql = "";
		if(opcion.equals("Fecha")) {
			sql = "select fecha_cop, cantidad_com, costo_com,subtotal_com,razonsocial_prov,email_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where c.fecha_cop='"
		+Conversor.convertirDate(dcompra.getFecha())+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		
		if(opcion.equals("Proveedor")) {
			 sql = " select fecha_cop, cantidad_com, costo_com,subtotal_com, razonsocial_prov,email_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where dc.cve_prov='"
				+dcompra.getProveedor()+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		
		if(opcion.equals("Calentador")) {
			sql = "select fecha_cop, cantidad_com, costo_com,subtotal_com, razonsocial_prov,email_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where dc.cve_cal='"+
		dcompra.getCalentador()+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		if(opcion.equals("Todo")) {
			sql = "select fecha_cop, cantidad_com, costo_com,subtotal_com, razonsocial_prov,email_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal  where estado_prov='Mostrar'";
		}
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> detalle = new ArrayList<>();
			while (rs.next()) {
				String com = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
				+", "+rs.getString(7)+", "+rs.getString(8)+", "+rs.getString(9)+", "+rs.getString(10)+", "+rs.getString(11);
			
				detalle.add(com);
			}
			return detalle;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public List<String> getListaMD(DetalleCompra dcompra, String opcion){
		String sql = "";
		if(opcion.equals("Detalle")) {
			 sql = " select cantidad_com, costo_com,subtotal_com,dc.cve_cop , razonsocial_prov,email_prov,tipo_cal,numcilindros_cal,dimenciones_cal,marca_cal,precio_cal from compra as c join detallecompra as dc on c.cve_cop=dc.cve_cop join proveedor as pr  on dc.cve_prov=pr.cve_prov join calentador as ca on dc.cve_cal=ca.cve_cal where dc.cve_cop='"
				+dcompra.getCve()+"' && estado_prov='Mostrar' order by fecha_cop ASC";
		}
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<String> detalle = new ArrayList<>();
			while (rs.next()) {
				String com = rs.getString(1)+", "+rs.getString(2)
				+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
				+", "+rs.getString(7)+", "+rs.getString(8)+", "+rs.getString(9)+", "+rs.getString(10)+
				", "+rs.getString(11);
			
				detalle.add(com);
			}
			return detalle;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
