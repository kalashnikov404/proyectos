package dao;

public class FuenteDatos {
	
	private static BaseDatos baseDatos=null;
	
	public static BaseDatos getBaseDatos() {
		
		if(baseDatos==null) {
			baseDatos = new BaseDatos("archivo","root", "root");
	        baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
			baseDatos.setDriver("com.mysql.jdbc.Driver");
	        baseDatos.hacerConexion();
		}
		return baseDatos;
	}

}
