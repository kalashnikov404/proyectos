package modelo;

public class Pelicula {
	
	private int clave;
	private String nombre;
	private String genero;
	private int duracion;
	private String clasificacion;
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	@Override
	public String toString() {
		return "Pelicula [clave=" + clave + ", nombre=" + nombre + ", genero=" + genero + ", duracion=" + duracion
				+ ", clasificacion=" + clasificacion + "]";
	}
	
	
	
	

}
