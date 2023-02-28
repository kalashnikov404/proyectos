package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;

public interface ServicePelicula {
	
	
	List<Pelicula> getPeliculas();
	public List<Pelicula> consultarPorDatosPelicula(String clave, String nombre, String genero, String duracion, String clasificacion);
	public Pelicula consultarPorId(int id);
	public String eliminarPelicula(int idPelicula);
	
	

	
}