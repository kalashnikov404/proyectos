package modelo;

import enumeraciones.Secciones;

public class Lugar {
	
	private int espacio;
	private Secciones seccion;
	
	
	public Lugar(int espacio, Secciones seccion) {
		super();
		this.espacio = espacio;
		this.seccion = seccion;
	}
	
	public int getEspacio() {
		return espacio;
	}
	public void setEspacio(int espacio) {
		this.espacio = espacio;
	}
	public Secciones getSeccion() {
		return seccion;
	}
	public void setSeccion(Secciones seccion) {
		this.seccion = seccion;
	}
	
	

}
