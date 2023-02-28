package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Empleado;
import modelo.Insumo;
import modelo.Platillo;

	
	public class TablaPlatillo {
		private Connection conexion;
		private Statement statement;
		int valor =0;

		public TablaPlatillo(Connection conexcion) {
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

		
//		//Tabla platillo
//		private int clavePlatillo;
//		private String nombre;
//		private String tipo;
//		private String descripcion;
//		private String tiempo;
//		private int porcion;
//	
//		
//	

		

		public String guardarPlatillo(Platillo platillo) {
			String sql = "insert into platillo values('" + platillo.getClavePlatillo()+ "', '" + platillo.getNombre() + "', '"+ platillo.getTipo() + "','" 
					+ platillo.getDescripcion() + "','" + platillo.getTiempo() + "','" + platillo.getPorcion()+ "')";
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
		
		
//		//Tabla ingrediente platillo
//		private int numeroIngredientePlatillo;
//		private float cantidad;
//		private String umedida;
//		private int claveProducto;
//		private int clavePlatillo2;
		
		public String guardarPlatilloIngrediente(Platillo platillo) {
			String sql = "insert into ingredienteplatillo values('" + platillo.getNumeroIngredientePlatillo()+ "', '" + platillo.getCantidad() + "', '"+ platillo.getUmedida() + "','" 
					+ platillo.getClaveProducto() + "','" + platillo.getClavePlatillo2() + "')";
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
		
		
		//Tabla Costo
//		private int numeroCosto;
//		private float costo;
//		private int numeroIngredientePlatillo2;
//		
		
		public String guardarPlatilloCosto(Platillo platillo) {
			String sql = "insert into costos values('" + platillo.getNumeroCosto()+ "', '" + platillo.getCosto() + "', '"+ platillo.getNumeroIngredientePlatillo2() + "')";
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
		
				//tabla platillo cafecito
//		
//		private int numeroPlatilloCafecito;
//		private String fechaPlatilloCafecito;
//		private int claveCafecito;
//		private int clavePlatillo3;
//		
		
		public String guardarPlatilloCafecito(Platillo platillo) {
			String sql = "insert into platillocafecito values('" + platillo.getNumeroPlatilloCafecito()+ "', '" + platillo.getFechaPlatilloCafecito() + "', '"+ platillo.getClaveCafecito()
			+ "', '" + platillo.getClavePlatillo3() +"')";
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

	
//		platillo, ingredienteplatillo, platillocafecito, 
		
//		me quede en pensar que hacer con aquellos ingredientes que se asignan a un platillo;
		
		public List<Platillo> getPlatillos(){
			String sql = " ";
			System.out.println(sql);
			try {
				ResultSet rs = statement.executeQuery(sql);
				List<Platillo> platillos = new ArrayList<>();
				while (rs.next()) {
					
					Platillo platillo =new Platillo();
					
					//platillo
					platillo.setClavePlatillo(rs.getInt("cve_pla"));
					platillo.setNombre(rs.getString("nom_pla"));
					platillo.setTipo(rs.getString("tipo_pla"));
					platillo.setDescripcion(rs.getString("descripcion_pla"));
					platillo.setTiempo(rs.getString("tiempopre_pla"));
					platillo.setPorcion(rs.getInt("porcion_pla"));
					
					//ingredienteplatillo
					platillo.setNumeroIngredientePlatillo(rs.getInt("num_ingpla"));
					platillo.setCantidad(rs.getInt("cant_ingpla"));
					platillo.setUmedida(rs.getString("umedida_ingpla"));
					
					platillo.setClaveProducto(rs.getInt("cve_pro"));

					
					
//					tabla costos
					platillo.setCosto(rs.getInt("costoprep_cos"));
				
					//
					//tabla platillo cafecito
					platillo.setNumeroPlatilloCafecito(rs.getInt("num_placaf"));
					platillo.setFechaPlatilloCafecito(rs.getString("fecha_placaf"));

//				select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla.ingredienteplattilo.cve_pla, costos.costospre_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf where platillo.cve_caf=ingredienteplatillo.cve_caf && ingredienteplatillo.num_placaf=costos.num_placaf && platillo
//					
					platillos.add(platillo);
				}
				return platillos;
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


//public List<Platillo> consultarPorDatosPlatillo(String id, String nombre, String tipo, String descripcion, String tiempo, String porcion) {
//
////
////	datos[0] = "Buscar por:";
////	datos[1] = "Clave Platillo";
////	datos[2] = "Nombre";
////
////	datos[3] = "Tipo";
////	datos[4] = "Descripcion";
////	datos[5] = "Tiempo";
////	datos[6] = "Porcion";
////	
//	if(id!="") {
//		id=" producto.cve_pro='"+id+"'";
//	}
//	if(nombre!="") {
//		nombre=" producto.nom_pro='"+nombre+"'";
//	}
//	if(tipo!="") {
//		tipo=" producto.tipo_pro='"+tipo+"'";
//	}
//	if(descripcion!="") {
//		descripcion=" producto.marca_pro='"+descripcion+"'";
//	}
//	if(tiempo!="") {
//		tiempo=" producto.presentacion_pro='"+tiempo+"'";
//	}
//	if(porcion!="") {
//		porcion=" producto.contenido_pro='"+porcion+"'";
//
//	}
//	
//
//	String sql = "select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla, ingredienteplatillo.cve_pro, ingredienteplatillo.cve_pla, costos.costoprep_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf from platillo, ingredienteplatillo, costos, platillocafecito where platillo.cve_pla=ingredienteplatillo.cve_pla && ingredienteplatillo.cve_pla=platillocafecito.cve_pla && platillocafecito.num_placaf=costos.num_placaf &&"+id+nombre+tipo+descripcion+tiempo+porcion;
//	try {
//		ResultSet rs = statement.executeQuery(sql);
//		List<Platillo> platillos = new ArrayList<>();
//		while (rs.next()) {
//			
//			Platillo platillo =new Platillo();
//			
//			//platillo
//			platillo.setClavePlatillo(rs.getInt("cve_pla"));
//			platillo.setNombre(rs.getString("nom_pla"));
//			platillo.setTipo(rs.getString("tipo_pla"));
//			platillo.setDescripcion(rs.getString("descripcion_pla"));
//			platillo.setTiempo(rs.getString("tiempopre_pla"));
//			platillo.setPorcion(rs.getInt("porcion_pla"));
//			
//			//ingredienteplatillo
//			platillo.setNumeroIngredientePlatillo(rs.getInt("num_ingpla"));
//			platillo.setCantidad(rs.getInt("cant_ingpla"));
//			platillo.setUmedida(rs.getString("umedida_ingpla"));
//			
//			platillo.setClaveProducto(rs.getInt("cve_pro"));
//
//			
//			
////			tabla costos
//			platillo.setCosto(rs.getInt("costoprep_cos"));
//		
//			//
//			//tabla platillo cafecito
//			platillo.setNumeroPlatilloCafecito(rs.getInt("num_placaf"));
//			platillo.setFechaPlatilloCafecito(rs.getString("fecha_placaf"));
//
////		select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla.ingredienteplattilo.cve_pla, costos.costospre_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf where platillo.cve_caf=ingredienteplatillo.cve_caf && ingredienteplatillo.num_placaf=costos.num_placaf && platillo
////			
//			platillos.add(platillo);
//		}
//		return platillos;
//	} catch (Exception e) {
//		System.out.println(e.toString());
//		return null;
//	}
//}
//
//
//
//public List<Platillo> consultarPorDatosPlatilloIngrediente(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida) {
//
//	if(id!="") {
//		id=" producto.cve_pro='"+id+"'";
//	}
//	if(nombre!="") {
//		nombre=" producto.nom_pro='"+nombre+"'";
//	}
//	if(tipo!="") {
//		tipo=" producto.tipo_pro='"+tipo+"'";
//	}
//	if(marca!="") {
//		marca=" producto.marca_pro='"+marca+"'";
//	}
//	if(presentacion!="") {
//		presentacion=" producto.presentacion_pro='"+presentacion+"'";
//	}
//	if(contenido!="") {
//		contenido=" producto.contenido_pro='"+contenido+"'";
//	}
//	if(umedida!="") {
//		umedida=" producto.umedida_pro='"+umedida+"'";
//		
//	
//	}
//	
//
////	String sql = "select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla, ingredienteplatillo.cve_pro, ingredienteplatillo.cve_pla, costos.costoprep_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf from platillo, ingredienteplatillo, costos, platillocafecito where platillo.cve_pla=ingredienteplatillo.cve_pla && ingredienteplatillo.cve_pla=platillocafecito.cve_pla && platillocafecito.num_placaf=costos.num_placaf &&"+id+nombre+tipo+descripcion+tiempo+porcion;
//	try {
//		ResultSet rs = statement.executeQuery(sql);
//		List<Platillo> platillos = new ArrayList<>();
//		while (rs.next()) {
//			
//			Platillo platillo =new Platillo();
//			
//			//platillo
//			platillo.setClavePlatillo(rs.getInt("cve_pla"));
//			platillo.setNombre(rs.getString("nom_pla"));
//			platillo.setTipo(rs.getString("tipo_pla"));
//			platillo.setDescripcion(rs.getString("descripcion_pla"));
//			platillo.setTiempo(rs.getString("tiempopre_pla"));
//			platillo.setPorcion(rs.getInt("porcion_pla"));
//			
//			//ingredienteplatillo
//			platillo.setNumeroIngredientePlatillo(rs.getInt("num_ingpla"));
//			platillo.setCantidad(rs.getInt("cant_ingpla"));
//			platillo.setUmedida(rs.getString("umedida_ingpla"));
//			
//			platillo.setClaveProducto(rs.getInt("cve_pro"));
//
//			
//			
////			tabla costos
//			platillo.setCosto(rs.getInt("costoprep_cos"));
//		
//			//
//			//tabla platillo cafecito
//			platillo.setNumeroPlatilloCafecito(rs.getInt("num_placaf"));
//			platillo.setFechaPlatilloCafecito(rs.getString("fecha_placaf"));
//
////		select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla.ingredienteplattilo.cve_pla, costos.costospre_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf where platillo.cve_caf=ingredienteplatillo.cve_caf && ingredienteplatillo.num_placaf=costos.num_placaf && platillo
////			
//			platillos.add(platillo);
//		}
//		return platillos;
//	} catch (Exception e) {
//		System.out.println(e.toString());
//		return null;
//	}
//}
//
//public List<Platillo> consultarPorDatosPlatilloCosto(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida) {
//
//	if(id!="") {
//		id=" producto.cve_pro='"+id+"'";
//	}
//	if(nombre!="") {
//		nombre=" producto.nom_pro='"+nombre+"'";
//	}
//	if(tipo!="") {
//		tipo=" producto.tipo_pro='"+tipo+"'";
//	}
//	if(marca!="") {
//		marca=" producto.marca_pro='"+marca+"'";
//	}
//	if(presentacion!="") {
//		presentacion=" producto.presentacion_pro='"+presentacion+"'";
//	}
//	if(contenido!="") {
//		contenido=" producto.contenido_pro='"+contenido+"'";
//	}
//	if(umedida!="") {
//		umedida=" producto.umedida_pro='"+umedida+"'";
//		
//	
//	}
//	
//
////	String sql = "select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla, ingredienteplatillo.cve_pro, ingredienteplatillo.cve_pla, costos.costoprep_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf from platillo, ingredienteplatillo, costos, platillocafecito where platillo.cve_pla=ingredienteplatillo.cve_pla && ingredienteplatillo.cve_pla=platillocafecito.cve_pla && platillocafecito.num_placaf=costos.num_placaf &&"+id+nombre+tipo+descripcion+tiempo+porcion;
//	try {
//		ResultSet rs = statement.executeQuery(sql);
//		List<Platillo> platillos = new ArrayList<>();
//		while (rs.next()) {
//			
//			Platillo platillo =new Platillo();
//			
//			//platillo
//			platillo.setClavePlatillo(rs.getInt("cve_pla"));
//			platillo.setNombre(rs.getString("nom_pla"));
//			platillo.setTipo(rs.getString("tipo_pla"));
//			platillo.setDescripcion(rs.getString("descripcion_pla"));
//			platillo.setTiempo(rs.getString("tiempopre_pla"));
//			platillo.setPorcion(rs.getInt("porcion_pla"));
//			
//			//ingredienteplatillo
//			platillo.setNumeroIngredientePlatillo(rs.getInt("num_ingpla"));
//			platillo.setCantidad(rs.getInt("cant_ingpla"));
//			platillo.setUmedida(rs.getString("umedida_ingpla"));
//			
//			platillo.setClaveProducto(rs.getInt("cve_pro"));
//
//			
//			
////			tabla costos
//			platillo.setCosto(rs.getInt("costoprep_cos"));
//		
//			//
//			//tabla platillo cafecito
//			platillo.setNumeroPlatilloCafecito(rs.getInt("num_placaf"));
//			platillo.setFechaPlatilloCafecito(rs.getString("fecha_placaf"));
//
////		select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla.ingredienteplattilo.cve_pla, costos.costospre_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf where platillo.cve_caf=ingredienteplatillo.cve_caf && ingredienteplatillo.num_placaf=costos.num_placaf && platillo
////			
//			platillos.add(platillo);
//		}
//		return platillos;
//	} catch (Exception e) {
//		System.out.println(e.toString());
//		return null;
//	}
//}
//
//public List<Platillo> consultarPorDatosCafecito(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida) {
//
//	if(id!="") {
//		id=" producto.cve_pro='"+id+"'";
//	}
//	if(nombre!="") {
//		nombre=" producto.nom_pro='"+nombre+"'";
//	}
//	if(tipo!="") {
//		tipo=" producto.tipo_pro='"+tipo+"'";
//	}
//	if(marca!="") {
//		marca=" producto.marca_pro='"+marca+"'";
//	}
//	if(presentacion!="") {
//		presentacion=" producto.presentacion_pro='"+presentacion+"'";
//	}
//	if(contenido!="") {
//		contenido=" producto.contenido_pro='"+contenido+"'";
//	}
//	if(umedida!="") {
//		umedida=" producto.umedida_pro='"+umedida+"'";
//		
//	
//	}
//	
//
////	String sql = "select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla, ingredienteplatillo.cve_pro, ingredienteplatillo.cve_pla, costos.costoprep_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf from platillo, ingredienteplatillo, costos, platillocafecito where platillo.cve_pla=ingredienteplatillo.cve_pla && ingredienteplatillo.cve_pla=platillocafecito.cve_pla && platillocafecito.num_placaf=costos.num_placaf &&"+id+nombre+tipo+descripcion+tiempo+porcion;
//	try {
//		ResultSet rs = statement.executeQuery(sql);
//		List<Platillo> platillos = new ArrayList<>();
//		while (rs.next()) {
//			
//			Platillo platillo =new Platillo();
//			
//			//platillo
//			platillo.setClavePlatillo(rs.getInt("cve_pla"));
//			platillo.setNombre(rs.getString("nom_pla"));
//			platillo.setTipo(rs.getString("tipo_pla"));
//			platillo.setDescripcion(rs.getString("descripcion_pla"));
//			platillo.setTiempo(rs.getString("tiempopre_pla"));
//			platillo.setPorcion(rs.getInt("porcion_pla"));
//			
//			//ingredienteplatillo
//			platillo.setNumeroIngredientePlatillo(rs.getInt("num_ingpla"));
//			platillo.setCantidad(rs.getInt("cant_ingpla"));
//			platillo.setUmedida(rs.getString("umedida_ingpla"));
//			
//			platillo.setClaveProducto(rs.getInt("cve_pro"));
//
//			
//			
////			tabla costos
//			platillo.setCosto(rs.getInt("costoprep_cos"));
//		
//			//
//			//tabla platillo cafecito
//			platillo.setNumeroPlatilloCafecito(rs.getInt("num_placaf"));
//			platillo.setFechaPlatilloCafecito(rs.getString("fecha_placaf"));
//
////		select platillo.cve_pla, platillo.nom_pla, platillo.tipo_pla, platillo.descripcion_pla, platillo.tiempopre_pla, platillo.porcion_pla, ingredienteplatillo.num_ingpla, ingredienteplatillo.cant_ingpla, ingredienteplatillo.umedida_ingpla.ingredienteplattilo.cve_pla, costos.costospre_cos, platillocafecito.num_placaf, platillocafecito.fecha_placaf where platillo.cve_caf=ingredienteplatillo.cve_caf && ingredienteplatillo.num_placaf=costos.num_placaf && platillo
////			
//			platillos.add(platillo);
//		}
//		return platillos;
//	} catch (Exception e) {
//		System.out.println(e.toString());
//		return null;
//	}
//}




public ArrayList<String> llenar_comboInsumo(){
    ArrayList<String> lista = new ArrayList<String>();
    String sql = " select *from producto;";
  //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
//    cve_pro          | int(11)     | NO   | PRI | NULL    | auto_increment |
//    | nom_pro          | varchar(40) | NO   |     | NULL    |                |
//    | tipo_pro         | varchar(40) | NO   |     | NULL    |                |
//    | marca_pro        | varchar(40) | NO   |     | NULL    |                |
//    | presentacion_pro | varchar(40) | NO   |     | NULL    |                |
//    | contenido_pro    | float(6,2)  | NO   |     | NULL    |                |
//    | umedida_pro
    try {
    	ResultSet rs = statement.executeQuery(sql);	          
//    	System.out.println("Correcto");
//    } catch (Exception e) {
//        System.out.println("No Correcto");
//    }
//    try {
        while(rs.next()){
        	lista.add("ID:" + rs.getString("cve_pro" )+ "    Nombre:" + rs.getString("nom_pro")  + "    Tipo:" + rs.getString("tipo_pro") + "    Marca:" + rs.getString("marca_pro")+ "    Presentacion:" + rs.getString("presentacion_pro")+ "    Contenido:" + rs.getString("contenido_pro")
            + "    Umedida:" + rs.getString("umedida_pro"));
    		
        }
    } catch (Exception e) {
    }
    return lista;
}



	
		public int generaI(int valor) {
			int numeroAleatorio = (int) (Math.random()*25+1);
			return numeroAleatorio;
			
		}

	
	
	
	
	
	
	
	
}
