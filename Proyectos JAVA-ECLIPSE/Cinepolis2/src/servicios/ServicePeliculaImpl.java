package servicios;

import java.util.List;

import utilidades.ServicePelicula;
import dao.FuenteDatos;
import dao.TablaPelicula;
import excepciones.ConexionException;
import modelo.Pelicula;

public class ServicePeliculaImpl implements ServicePelicula {
	
private TablaPelicula tablaPelicula;

public ServicePeliculaImpl() {
	try {
		tablaPelicula=new TablaPelicula(FuenteDatos.getBaseDatos().getConexion());
	} catch (ConexionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@Override
public List<Pelicula> getPeliculas() {
	// TODO Auto-generated method stub
	return tablaPelicula.getPeliculas();
}


@Override
public List<Pelicula> consultarPorDatosPelicula(String clave, String nombre, String genero, String duracion,
		String clasificacion) {
	// TODO Auto-generated method stub
	return tablaPelicula.consultarPeliculaPorDatos(clave, nombre, genero, duracion, clasificacion);
}


public Pelicula consultarPorId(int id) {
	return tablaPelicula.consultarPorId(id);
}



public String eliminarPelicula(int idPelicula) {
	// TODO Auto-generated method stub
	return tablaPelicula.eliminarPelicula(idPelicula);
}


	
}

