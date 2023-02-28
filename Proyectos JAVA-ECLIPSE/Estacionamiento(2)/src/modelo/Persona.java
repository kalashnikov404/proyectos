package modelo;

import enumeraciones.Genero;

public class Persona {
	
	private int id;
	private String nombre;
	private String paterno;
	private String materno;
	private Genero genero;
	private Domicilio domicilio;
	
	public Persona() {
		super();
	}
	
	public Persona(int id, String nombre, String paterno, String materno, Genero genero, Domicilio domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.genero = genero;
		this.domicilio = domicilio;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [curp=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", genero=" + genero + ", domicilio=" + domicilio.toString() + "]";
	}

}
