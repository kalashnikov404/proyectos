package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Vehiculo;

public class TablaVehiculo {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaVehiculo(Connection conexion) {
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

	public String guardar(Vehiculo vehiculo) {
		String sql = "insert into vehiculo values('"+ vehiculo.getPlacas() + "','" + vehiculo.getModelo() + "'," + vehiculo.getAño() + ",'" 
	+ vehiculo.getMarca() + "','" + vehiculo.getColor() + "','" + Conversor.convertirDeTamaños(vehiculo.getTamaño()) + "','" +Conversor.convertirDeTipos(vehiculo.getTipo()) + "')";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Vehiculo registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public String modificarPorPlacas(Vehiculo vehiculo, String placas) {
		String sql = "update vehiculo set placas_veh='"+ vehiculo.getPlacas() +"', modelo_veh='" + vehiculo.getModelo() + "', año=" + vehiculo.getAño() + ", marca='" + vehiculo.getMarca() + "', color='" + vehiculo.getColor() + "', tamaño='" + Conversor.convertirDeTamaños(vehiculo.getTamaño()) + "', tipo='" + Conversor.convertirDeTipos(vehiculo.getTipo()) + "' where placas_veh='" + placas + "'";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Vehiculo modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public List<Vehiculo> getVehiculos(){
		String sql = "select * from vehiculo";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Vehiculo> vehiculos = new ArrayList<>();
			while (rs.next()) {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setPlacas(rs.getString(1));
				vehiculo.setModelo(rs.getString(2));
				vehiculo.setColor(rs.getString(3));
				vehiculo.setTamaño(Conversor.convertirATamaños(rs.getString(4)));
				vehiculo.setTipo(Conversor.convertirATipos(rs.getString(5)));
				vehiculos.add(vehiculo);
			}
			return vehiculos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	/**public String nombreProducto(BigInteger codigo) {
		String sql = "select nom_pro from producto where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getString("nom_pro");
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	**/
	
	
	public boolean existe(String placas) {
		String sql = "select * from vehiculo where placas='"+ placas + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
/**	public void actualizar(String datoNuevo, String placas) {
		String sql = "update producto set disponible_pro ='"+ datoNuevo +"' where codbar_pro ='"+ codigo +"'";
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public Producto getProductByName(String name) {
		String sql = "select * from producto where nom_pro = '"+ name+ "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				return producto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	**/
	
}