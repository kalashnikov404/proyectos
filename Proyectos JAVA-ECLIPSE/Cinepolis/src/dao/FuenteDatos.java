package dao;

import excepciones.ConexionException;

public class FuenteDatos {
	
	private static BaseDatos2 baseDatos=null;
	
	public static BaseDatos2 getBaseDatos() throws ConexionException {
		
		if(baseDatos==null) {
			baseDatos = new BaseDatos2("cinepolis","root", "root");
	        baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
			baseDatos.setDriver("com.mysql.jdbc.Driver");
	        baseDatos.hacerConexion();
		}
		return baseDatos;
	}

}
