package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Empleado;
import modelo.Insumo;

	
	public class TablaInsumo {
		private Connection conexion;
		private Statement statement;
		int valor =0;

		public TablaInsumo(Connection conexcion) {
			this.conexion=conexcion;
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
//
//		mysql> describe producto;
//		+------------------+-------------+------+-----+---------+----------------+
//		| Field            | Type        | Null | Key | Default | Extra          |
//		+------------------+-------------+------+-----+---------+----------------+
//		| cve_pro          | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| nom_pro          | varchar(40) | NO   |     | NULL    |                |
//		| tipo_pro         | varchar(40) | NO   |     | NULL    |                |
//		| marca_pro        | varchar(40) | NO   |     | NULL    |                |
//		| presentacion_pro | varchar(40) | NO   |     | NULL    |                |
//		| contenido_pro    | float(6,2)  | NO   |     | NULL    |                |
//		| umedida_pro      | varchar(40) | NO   |     | NULL    |                |
//		+------------------+-------------+------+-----+---------+----------------+
//		7 rows in set (0.08 sec)

		public String guardarInsumo(Insumo insumo) {
			String sql = "insert into producto values('" + insumo.getClaveProducto()+ "', '" + insumo.getNombre() + "', '"+ insumo.getTipo() + "','" 
					+ insumo.getMarca() + "','" + insumo.getPresentacion() + "','" + insumo.getContenido() +
					"','" + insumo.getUmedia() + "')";
		//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//					cafecito.getOrientacion()+"')";
			
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
		
//		private int existencia;
//		private int minimo;
//		private int maximo;
//		private int claveProducto2;
//		private int claveCafecio;
		
		public String guardarInsumoMinMax(Insumo insumo) {
			String sql = "insert into minmax values('" + insumo.getExistencia()+ "', '" + insumo.getMinimo() + "', '"+ insumo.getMaximo() + "','" 
					+ insumo.getClaveProducto2() + "','" + insumo.getClaveCafecito() + "')";
		//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//					cafecito.getOrientacion()+"')";
			
			try {
				statement.executeUpdate(sql);
				return "exito";
			} catch (SQLException e) {
				System.out.println(e.toString());
				return sql.toString();
			}
		}
	
		public List<Insumo> getInsumos(){
			String sql = "select *from vistainsumosexistentes;";
			System.out.println(sql);
			try {
				ResultSet rs = statement.executeQuery(sql);
				List<Insumo> insumos = new ArrayList<>();
				while (rs.next()) {
					Insumo insumo =new Insumo();
					insumo.setClaveProducto(rs.getInt("cve_pro"));
					insumo.setNombre(rs.getString("nom_pro"));
					insumo.setTipo(rs.getString("tipo_pro"));
					insumo.setMarca(rs.getString("marca_pro"));
					insumo.setPresentacion(rs.getString("presentacion_pro"));
					insumo.setContenido(rs.getString("contenido_pro"));
					insumo.setUmedia(rs.getString("umedida_pro"));
					
					
//					tabla minmax
					insumo.setExistencia(rs.getInt("num_minmax"));
					insumo.setMinimo(rs.getInt("min_minmax"));
					insumo.setMaximo(rs.getInt("max_minmax"));
					insumo.setClaveCafecito(rs.getInt("cve_caf"));
				
					
					insumos.add(insumo);
				}
				return insumos;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		}

	

public String eliminarInsumo(int cveP) {
	String sql = "delete minmax.* from minmax join producto on minmax.cve_pro=producto.cve_pro where minmax.cve_pro="+cveP;
	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Insumo eliminado con exito";
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
}
	
	
	
	


public Insumo consultarPorCveP(int cveP) {
	String sql =  "select cve_pro, nom_pro, tipo_pro, marca_pro, presentacion_pro, contenido_pro, umedida_pro from producto where cve_pro="+cveP;
	Insumo insumo = new Insumo();
	
	
	ResultSet rs = null;
	try {
		rs = statement.executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		while(rs.next()) {
			insumo.setCveP(rs.getInt("cve_pro"));
			insumo.setNombre(rs.getString("nom_pro"));
			insumo.setTipo(rs.getString("tipo_pro"));
			insumo.setMarca(rs.getString("marca_pro"));
			insumo.setPresentacion(rs.getString("presentacion_pro"));
			insumo.setContenido(rs.getString("contenido_pro"));
			insumo.setUmedia(rs.getString("umedida_pro"));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return insumo;
}

//private int claveProducto;
//private String nombre;
//private String tipo;
//private String marca;
//private String presentacion;
//private String contenido;
//private String umedia;
//cve_pro          | int(11)     | NO   | PRI | NULL    | auto_increment |
//| nom_pro          | varchar(40) | NO   |     | NULL    |                |
//| tipo_pro         | varchar(40) | NO   |     | NULL    |                |
//| marca_pro        | varchar(40) | NO   |     | NULL    |                |
//| presentacion_pro | varchar(40) | NO   |     | NULL    |                |
//| contenido_pro    | float(6,2)  | NO   |     | NULL    |                |
//| umedida_pro


public List<Insumo> consultarPorDatosInsumo(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida) {

	if(id!="") {
		id=" producto.cve_pro='"+id+"'";
	}
	if(nombre!="") {
		nombre=" producto.nom_pro='"+nombre+"'";
	}
	if(tipo!="") {
		tipo=" producto.tipo_pro='"+tipo+"'";
	}
	if(marca!="") {
		marca=" producto.marca_pro='"+marca+"'";
	}
	if(presentacion!="") {
		presentacion=" producto.presentacion_pro='"+presentacion+"'";
	}
	if(contenido!="") {
		contenido=" producto.contenido_pro='"+contenido+"'";
	}
	if(umedida!="") {
		umedida=" producto.umedida_pro='"+umedida+"'";
		
	
	}
	

	String sql = "select producto.cve_pro, producto.nom_pro, producto.tipo_pro, producto.marca_pro, producto.presentacion_pro, producto.contenido_pro, producto.umedida_pro, minmax.num_minmax, minmax.min_minmax, minmax.max_minmax, minmax.cve_caf from producto, minmax where producto.cve_pro=minmax.cve_pro &&"+id+nombre+tipo+marca+presentacion+contenido+umedida;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Insumo> insumos = new ArrayList<>();
		while (rs.next()) {
		
				Insumo insumo =new Insumo();
				insumo.setClaveProducto(rs.getInt("cve_pro"));
				insumo.setNombre(rs.getString("nom_pro"));
				insumo.setTipo(rs.getString("tipo_pro"));
				insumo.setMarca(rs.getString("marca_pro"));
				insumo.setPresentacion(rs.getString("presentacion_pro"));
				insumo.setContenido(rs.getString("contenido_pro"));
				insumo.setUmedia(rs.getString("umedida_pro"));
				
				
//				tabla minmax
				insumo.setExistencia(rs.getInt("num_minmax"));
				insumo.setMinimo(rs.getInt("min_minmax"));
				insumo.setMaximo(rs.getInt("max_minmax"));
				insumo.setClaveCafecito(rs.getInt("cve_caf"));
			
				
				insumos.add(insumo);

		}
		return insumos;
		 
	}catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}


//
//private int existencia;
//private int minimo;
//private int maximo;
//private int claveProducto2;
//private int claveCafecito;

//num_minmax | min_minmax | max_minmax | cve_pro | cve_caf |
//+------------+------------+------------+---------+---------+
public List<Insumo> consultarPorDatosMinimoMaximo(String id, String minimo, String maximo, String claveCafecito) {

	if(id!="") {
		id=" minmax.num_minmax='"+id+"'";
	}
	if(minimo!="") {
		minimo=" minmax.min_minmax='"+minimo+"'";
	}
	if(maximo!="") {
		maximo=" minmax.max_minmax='"+maximo+"'";
	}
	if(claveCafecito!="") {
		claveCafecito=" minmax.cve_caf='"+claveCafecito+"'";
	
	}
	

	String sql = "select producto.cve_pro, producto.nom_pro, producto.tipo_pro, producto.marca_pro, producto.presentacion_pro, producto.contenido_pro, producto.umedida_pro, minmax.num_minmax, minmax.min_minmax, minmax.max_minmax, minmax.cve_caf from producto, minmax where producto.cve_pro=minmax.cve_pro &&"+id+minimo+maximo+claveCafecito;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Insumo> insumos = new ArrayList<>();
		while (rs.next()) {
		
				Insumo insumo =new Insumo();
				insumo.setClaveProducto(rs.getInt("cve_pro"));
				insumo.setNombre(rs.getString("nom_pro"));
				insumo.setTipo(rs.getString("tipo_pro"));
				insumo.setMarca(rs.getString("marca_pro"));
				insumo.setPresentacion(rs.getString("presentacion_pro"));
				insumo.setContenido(rs.getString("contenido_pro"));
				insumo.setUmedia(rs.getString("umedida_pro"));
				
				
//				tabla minmax
				insumo.setExistencia(rs.getInt("num_minmax"));
				insumo.setMinimo(rs.getInt("min_minmax"));
				insumo.setMaximo(rs.getInt("max_minmax"));
				insumo.setClaveCafecito(rs.getInt("cve_caf"));
			
				
				insumos.add(insumo);

		}
		return insumos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}






	
		public int generaI(int valor) {
			int numeroAleatorio = (int) (Math.random()*25+1);
			return numeroAleatorio;
			
		}

	
	
	
	
	
	
	
	
}
