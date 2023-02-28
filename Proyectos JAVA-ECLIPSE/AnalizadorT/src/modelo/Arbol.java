package modelo;

import java.util.ArrayList;

public class Arbol {
	private ArrayList<LineaArbol> lineas;
	private String nombreDelArbol;
	public ArrayList<LineaArbol> getLineas() {
		return lineas;
	}
	public void setLineas(ArrayList<LineaArbol> lineas) {
		this.lineas = lineas;
	}
	public String getNombreDelArbol() {
		return nombreDelArbol;
	}
	public void setNombreDelArbol(String nombreDelArbol) {
		this.nombreDelArbol = nombreDelArbol;
	}
	public Arbol(ArrayList<LineaArbol> lineas, String nombreDelArbol) {
		super();
		this.lineas = lineas;
		this.nombreDelArbol = nombreDelArbol;
	}
	

}
