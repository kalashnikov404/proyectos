//package modelo;
//
//import dao.BaseDatos;
//
//public class PrincipalBaseDatos {
//	
//	public static void main(String[] args) {
//		BaseDatos baseDatos = new BaseDatos("cadenaca", "root", "root");
//		baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
//		baseDatos.setDriver("com.mysql.jdbc.Driver");
//		String respuesta = baseDatos.hacerConexion();
//		if (respuesta.equals("exito")) {
//			
//			TablaCafecito tablaCafecito = new TablaCafecito(baseDatos.getConexion());
//			Cafecito cafecito = new Cafecito();
//			cafecito.setCve(18);
//			cafecito.setCalle("Francisco J mujica");
//			cafecito.setNumero(45);
//			cafecito.setOrientacion("Sur");
//			
//			System.out.println(tablaCafecito.guardar(cafecito));
//		}
//		else {
//			System.out.println("Error al cargar la base de datos "+respuesta);
//		}
//	}
//}
//
////String sql = "insert into cafecito values("+ cafecito.getCve() + ",'" + cafecito.getCalle() + "','" + cafecito.getNumero() + "','" + 
////		cafecito.getOrientacion()+"')";