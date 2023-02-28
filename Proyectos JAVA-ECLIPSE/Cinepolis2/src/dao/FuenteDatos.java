package dao;

import excepciones.ConexionException;

public class FuenteDatos {
	

	private static BaseDatos2 baseDatos=null;
	
	public static BaseDatos2 getBaseDatos() throws ConexionException {
		
		if(baseDatos==null) {
			baseDatos = new BaseDatos2("mendt672_cinepolis", "mendt672_alumno", "c(.#1UK44VOP");
	        baseDatos.setProtocolo("jdbc:mysql://92.249.45.104:3306/");
			baseDatos.setDriver("com.mysql.jdbc.Driver");
	        baseDatos.hacerConexion();
		}
		return baseDatos;
	}


}
