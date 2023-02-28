package dao;

import excepciones.ConexionException;

public class FuenteDatos {
	
	private static BaseDatos baseDatos=null;
	
	public static BaseDatos getBaseDatos() throws ConexionException {
		
		if(baseDatos==null) {
			baseDatos = new BaseDatos("tenergy","root", "root");
	        baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
			baseDatos.setDriver("com.mysql.jdbc.Driver");
	        baseDatos.hacerConexion();
		}
		return baseDatos;
	}

}
