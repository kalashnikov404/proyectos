package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import utilidades.Origen;

public class TablaPelicula {
	
	
	private Connection conexion;
	private Statement  statement;
		
	public TablaPelicula(Connection conexion) {
		this.conexion = conexion;
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public String guardar(Pelicula pelicula) {
		String sql = "insert into pelicula values('"+
				pelicula.getClave()+"','"+
				pelicula.getNombre()+"','"+
				pelicula.getGenero()+"','"+
				pelicula.getDuracion()+"','"+
				pelicula.getClasificacion()+"')";
		try {
			statement.executeUpdate(sql);
			return "pelicula registrada con exito";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	
	
	
	
	
	
	public List<Pelicula> getPeliculas() {

		String sql = "select *from pelicula";

		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Pelicula> peliculas = new ArrayList<>();
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();

				pelicula.setClave(rs.getInt(1));
				pelicula.setNombre(rs.getString(2));
				pelicula.setGenero(rs.getString(3));
				pelicula.setDuracion(rs.getInt(4));

				pelicula.setClasificacion(rs.getString(5));

				
				peliculas.add(pelicula);
			}
			return peliculas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	
	public List<Pelicula> consultarPeliculaPorDatos(String clave, String nombre, String genero, String duracion, String clasificacion) {

		if(clave!="") {
			clave="where pelicula.cve_pel="+clave+"";
		}
		if(nombre!="") {
			nombre="where pelicula.nombre_pel='"+nombre+"'";
		}
		if(genero!="") {
			genero="where pelicula.genero_pel='"+genero+"'";
		}
		if(duracion!="") {
			duracion="where pelicula.duracion_pel='"+duracion+"'";
		}
		if(clasificacion!="") {
			clasificacion="where pelicula.clasificacion_pel='"+clasificacion+"'";
		}
		
		
		String sql = "select *from pelicula "+clave+nombre+genero+duracion+clasificacion;

		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Pelicula> peliculas = new ArrayList<>();
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();

				pelicula.setClave(rs.getInt(1));
				pelicula.setNombre(rs.getString(2));
				pelicula.setGenero(rs.getString(3));
				pelicula.setDuracion(rs.getInt(4));

				pelicula.setClasificacion(rs.getString(5));
				
				peliculas.add(pelicula);

			}
			return peliculas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;

		}
	
	}
	
	
	
	
	
	public Pelicula consultarPorId(int id) {
		String sql = "select *from pelicula where pelicula.cve_pel="+id;
		
		Pelicula pelicula = new Pelicula();
	
		
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				pelicula.setClave(rs.getInt(1));
				pelicula.setNombre(rs.getString(2));
				pelicula.setGenero(rs.getString(3));
				pelicula.setDuracion(rs.getInt(4));

				pelicula.setClasificacion(rs.getString(5));
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pelicula;
	}

	
	
	
	public String eliminarPelicula(int idPelicula) {
		String sql = "delete from pelicula where cve_pel="+idPelicula;
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Pelicula eliminada con exito";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("error, no hay sentencia");
		}
		return sql.toString();
	}
	
	
	}

	
	
	
	
	
	
	
