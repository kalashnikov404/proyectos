package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import modelo.Cafecito;
import modelo.Ciudad;


public class TablaCafecito {
	private Connection conexion;
	private Statement statement;
	int valor =0;

	public TablaCafecito(Connection conexcion) {
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
	public String guardar1(Cafecito cafecito) {
		String sql = "insert into cafecito values('" + cafecito.getCveCF() + "', '" + cafecito.getCalle() + "', '"+ cafecito.getNumero() + "','" 
				+ cafecito.getOrientacion() + "', '" + cafecito.getCveCol() +"')";
	//	String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
//				cafecito.getOrientacion()+"')";
		
		try {
			statement.executeUpdate(sql);
			return "exito";
		
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("es aqui");
			return sql.toString();
		}
	}
	
	



	public List<Cafecito> getCafecitos(){
//		String sql = "select cve_caf, calle_caf, num_caf, orientacion_caf from cafecito;";
		
		String sql= " select *from  vistacafecitosexistentes;";
		System.out.println(sql);
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Cafecito> cafecitos = new ArrayList<>();
			
			while (rs.next()) {
				Cafecito cafecito=new Cafecito();
				cafecito.setCveCF(rs.getInt("cve_caf"));
				cafecito.setCalle(rs.getString("calle_caf"));
				cafecito.setNumero(rs.getInt("num_caf"));
				cafecito.setOrientacion(rs.getString("orientacion_caf"));
				
			
			
			cafecito.setColonia(rs.getString("nom_col"));
			cafecito.setAsentamiento(rs.getString("tipoasen_col"));
			cafecito.setZona(rs.getString("zona_col"));
			
			cafecito.setCp(rs.getInt("cve_cp"));
//				
			cafecito.setCiudad(rs.getString("nom_ciu"));
			cafecito.setMunicipio(rs.getString("mun_ciu"));
//				
			cafecito.setEstado(rs.getString("nom_edo"));
			
			//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

		
				cafecitos.add(cafecito);
			

			}
			return cafecitos;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
	
	

//	public List<Cafecito> getCafecitos2(){
//		String sql = "select cve_ciu, nom_ciu, mun_ciu from ciudad";
//		System.out.println(sql);
//		try {
//			ResultSet rs = statement.executeQuery(sql);
//			List<Cafecito> cafecitos2 = new ArrayList<>();
//			while (rs.next()) {
//				Cafecito cafecito2=new Cafecito();
//				
//				cafecito2.setCiudad(rs.getString("nom_ciu"));
//				cafecito2.setMunicipio(rs.getString("mun_ciu"));
//				
//				cafecitos2.add(cafecito2);
//			}
//			return cafecitos2;
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			return null;
//		}
//	}

	  public ArrayList<String> llenar_combo(){
	        ArrayList<String> lista = new ArrayList<String>();
	        String sql = "select cve_col, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from colonia, codigopostal,ciudad, estado where colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo;";
	      //  String sql = "select colonia.cve_col, ciudad.nom_ciu , ciudad.mun_ciu from colonia, codigopostal where ";
	        
	        try {
	        	ResultSet rs = statement.executeQuery(sql);	          
//	        	System.out.println("Correcto");
//	        } catch (Exception e) {
//	            System.out.println("No Correcto");
//	        }
//	        try {
	            while(rs.next()){
	                lista.add("Clave colonia:" + rs.getString("cve_col" ) + "    Colonia:" + rs.getString("nom_col") + "    Asentamiento:" + rs.getString("tipoasen_col")+ "    Zona:" + rs.getString("zona_col")+ "    CP:" + rs.getString("cve_cp")+ "    Ciudad:" + rs.getString("nom_ciu")+ "    Municipio:" + rs.getString("mun_ciu")+ "    Estado:" + rs.getString("nom_edo"));
	        		
//	    			lista.add(rs.getString("nom_ciu"));
//	    			lista.add(rs.getString("mun_ciu"));
//	    				
////	    			lista.add(rs.getInt("cve_cp"), sql);
////	    				
//	    			lista.add(rs.getString("nom_col"));
//	    			lista.add(rs.getString("tipoasen_col"));
//	    			lista.add(rs.getString("zona_col"));
////	    				
//	    			lista.add(rs.getString("nom_edo"));
//	    				
//	                
	                
	            }
	        } catch (Exception e) {
	        }
	        return lista;
	    }
	 
	

public String eliminarCliente(int cveCF) {
	String sql = "delete from cafecito where cve_caf="+cveCF;
	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito eliminado";
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
}

public Cafecito consultarPorCve(int cveCF) {
	String sql = "select cve_caf, calle_caf, num_caf, orientacion_caf, cve_col from cafecito where cve_caf="+cveCF;
	Cafecito cafecito = new Cafecito();
	
	
	ResultSet rs = null;
	try {
		rs = statement.executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		while(rs.next()) {
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			cafecito.setCveCol(rs.getInt("cve_col"));
			
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return cafecito;
}

public List<Cafecito> consultarPorDatosCafecito(String clave, String calle, String numero, String orientacion) {

	if(clave!="") {
		clave=" cafecito.cve_caf='"+clave+"'";
	}
	if(calle!="") {
		calle=" cafecito.calle_caf='"+calle+"'";
	}
	if(numero!="") {
		numero=" cafecito.num_caf="+numero;
	}
	if(orientacion!="") {
		orientacion=" cafecito.orientacion_caf='"+orientacion+"'";
	}
	
	
//	String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cve_per is null &&"+clave+calle+numero+orientacion;
 String sql= "select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from cafecito, colonia, codigopostal,ciudad, estado where cafecito.cve_col=colonia.cve_col && colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo &&"+clave+calle+numero+orientacion;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Cafecito> cafecitos = new ArrayList<>();
		while (rs.next()) {
			Cafecito cafecito=new Cafecito();
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			
		
		
		cafecito.setColonia(rs.getString("nom_col"));
		cafecito.setAsentamiento(rs.getString("tipoasen_col"));
		cafecito.setZona(rs.getString("zona_col"));
		
		cafecito.setCp(rs.getInt("cve_cp"));
//			
		cafecito.setCiudad(rs.getString("nom_ciu"));
		cafecito.setMunicipio(rs.getString("mun_ciu"));
//			
		cafecito.setEstado(rs.getString("nom_edo"));
		
		cafecitos.add(cafecito);

		}
		return cafecitos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}


public List<Cafecito> consultarPorDatosColonia(String colonia, String asentamiento, String zona) {

	if(colonia!="") {
		colonia=" colonia.nom_col='"+colonia+"'";
	}
	if(asentamiento!="") {
		asentamiento=" colonia.tipoasen_col='"+asentamiento+"'";
	}
	if(zona!="") {
		zona=" colonia.zona_col="+zona;
	}
	
	
	
//	String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cve_per is null &&"+clave+calle+numero+orientacion;
 String sql= "select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from cafecito, colonia, codigopostal,ciudad, estado where cafecito.cve_col=colonia.cve_col && colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo &&"+colonia+asentamiento+zona;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Cafecito> cafecitos = new ArrayList<>();
		while (rs.next()) {
			Cafecito cafecito=new Cafecito();
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			
		
		
		cafecito.setColonia(rs.getString("nom_col"));
		cafecito.setAsentamiento(rs.getString("tipoasen_col"));
		cafecito.setZona(rs.getString("zona_col"));
		
		cafecito.setCp(rs.getInt("cve_cp"));
//			
		cafecito.setCiudad(rs.getString("nom_ciu"));
		cafecito.setMunicipio(rs.getString("mun_ciu"));
//			
		cafecito.setEstado(rs.getString("nom_edo"));
		
		cafecitos.add(cafecito);

		}
		return cafecitos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}

public List<Cafecito> consultarPorCP(String CP) {

	if(CP!="") {
		CP=" codigopostal.cve_cp='"+CP+"'";

	}
	
//	String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cve_per is null &&"+clave+calle+numero+orientacion;
 String sql= "select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from cafecito, colonia, codigopostal,ciudad, estado where cafecito.cve_col=colonia.cve_col && colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo &&"+CP;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Cafecito> cafecitos = new ArrayList<>();
		while (rs.next()) {
			Cafecito cafecito=new Cafecito();
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			
		
		
		cafecito.setColonia(rs.getString("nom_col"));
		cafecito.setAsentamiento(rs.getString("tipoasen_col"));
		cafecito.setZona(rs.getString("zona_col"));
		
		cafecito.setCp(rs.getInt("cve_cp"));
//			
		cafecito.setCiudad(rs.getString("nom_ciu"));
		cafecito.setMunicipio(rs.getString("mun_ciu"));
//			
		cafecito.setEstado(rs.getString("nom_edo"));
		
		cafecitos.add(cafecito);

		}
		return cafecitos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}



public List<Cafecito> consultarPorDatosCiudad(String ciudad, String municipio) {

	if(ciudad!="") {
		ciudad=" ciudad.nom_ciu='"+ciudad+"'";
	}
	if(municipio!="") {
		municipio=" ciudad.mun_ciu='"+municipio+"'";

	}
	
	
//	String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cve_per is null &&"+clave+calle+numero+orientacion;
 String sql= "select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from cafecito, colonia, codigopostal,ciudad, estado where cafecito.cve_col=colonia.cve_col && colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo &&"+ciudad+municipio;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Cafecito> cafecitos = new ArrayList<>();
		while (rs.next()) {
			Cafecito cafecito=new Cafecito();
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			
		
		
		cafecito.setColonia(rs.getString("nom_col"));
		cafecito.setAsentamiento(rs.getString("tipoasen_col"));
		cafecito.setZona(rs.getString("zona_col"));
		
		cafecito.setCp(rs.getInt("cve_cp"));
//			
		cafecito.setCiudad(rs.getString("nom_ciu"));
		cafecito.setMunicipio(rs.getString("mun_ciu"));
//			
		cafecito.setEstado(rs.getString("nom_edo"));
		
		cafecitos.add(cafecito);

		}
		return cafecitos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}


public List<Cafecito> consultarPorDatosEstado(String estado) {

	if(estado!="") {
		estado=" estado.nom_edo='"+estado+"'";
	}
	
	
//	String sql = "select cliente.cve_cli, cliente.celular_cli, cliente.correo_cli, vehiculo.placas_veh, vehiculo.modelo_veh, vehiculo.año, vehiculo.marca, vehiculo.color, vehiculo.tamaño, vehiculo.tipo from cliente join vehiculo on cliente.placas_veh=vehiculo.placas_veh where cve_per is null &&"+clave+calle+numero+orientacion;
 String sql= "select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo from cafecito, colonia, codigopostal,ciudad, estado where cafecito.cve_col=colonia.cve_col && colonia.cve_cp=codigopostal.cve_cp && codigopostal.cve_ciu=ciudad.cve_ciu && ciudad.cve_edo=estado.cve_edo &&"+estado;
	try {
		ResultSet rs = statement.executeQuery(sql);
		List<Cafecito> cafecitos = new ArrayList<>();
		while (rs.next()) {
			Cafecito cafecito=new Cafecito();
			cafecito.setCveCF(rs.getInt("cve_caf"));
			cafecito.setCalle(rs.getString("calle_caf"));
			cafecito.setNumero(rs.getInt("num_caf"));
			cafecito.setOrientacion(rs.getString("orientacion_caf"));
			
		
		
		cafecito.setColonia(rs.getString("nom_col"));
		cafecito.setAsentamiento(rs.getString("tipoasen_col"));
		cafecito.setZona(rs.getString("zona_col"));
		
		cafecito.setCp(rs.getInt("cve_cp"));
//			
		cafecito.setCiudad(rs.getString("nom_ciu"));
		cafecito.setMunicipio(rs.getString("mun_ciu"));
//			
		cafecito.setEstado(rs.getString("nom_edo"));
		
		cafecitos.add(cafecito);

		}
		return cafecitos;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
}

public String modificarCafecito(Cafecito cafecito, int CveCf) {
	String sql = "update cafecito set calle_caf='" + cafecito.getCalle() + "', num_caf='" + cafecito.getNumero() + "', orientacion_caf='" + cafecito.getOrientacion() + "', cve_col='" + cafecito.getCveCol() + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}


public String modificarClaveCafecito(int clave, int CveCf) {
	String sql = "update cafecito set cve_caf='"+ clave  + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}


public String modificarCalleCafecito(String calle, int CveCf) {
	String sql = "update cafecito set calle_caf='"+ calle + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}


public String modificarNumeroCafecito(int numero, int CveCf) {
	String sql = "update cafecito set num_caf='"+ numero + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}


public String modificarOrientacionCafecito(String orientacion, int CveCf) {
	String sql = "update cafecito set orientacion_caf='"+ orientacion + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}


public String modificarClaveColoniaCafecito(int claveColonia, int CveCf) {
	String sql = "update cafecito set cve_col='"+ claveColonia + "' where cve_caf="+CveCf;

	if(statement!=null) {
		try {
			statement.executeUpdate(sql);
			return "Cafecito modificado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			
		}
	}else {
		System.out.println("error, no hay sentencia");
	}
	return sql.toString();
	
}






//cafecito.setCveCF(Integer.parseInt(textClaveCafecito.getText()));
//cafecito.setCalle(textCalle.getText());
//cafecito.setNumero(Integer.parseInt(textNumero.getText()));
//cafecito.setOrientacion(textOrientacion.getText());
//cafecito.setCveCol(Integer.parseInt(textClaveColonia.getText()));





public int generaI(int valor) {
	int numeroAleatorio = (int) (Math.random()*25+1);
	return numeroAleatorio;
	
}



}
