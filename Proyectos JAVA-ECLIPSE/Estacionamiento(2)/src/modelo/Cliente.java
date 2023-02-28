package modelo;

import enumeraciones.Genero;

public class Cliente extends Persona{
	
	private int id;
	private String celular;
	private String correo;
	private Vehiculo vehiculo;
	
	

	public Cliente() {
		super();
	}

	

	public Cliente(int id, String nombre, String paterno, String materno, Genero genero, Domicilio domicilio) {
		super(id, nombre, paterno, materno, genero, domicilio);
	}



	public Cliente(String celular, String correo, Vehiculo vehiculo) {
		super();
		this.celular = celular;
		this.correo = correo;
		this.vehiculo = vehiculo;
	}

	public Cliente(int idper, String nombre, String paterno, String materno, Genero genero, Domicilio domicilio, String celular, String correo, Vehiculo vehiculo) {
		super(idper, nombre, paterno, materno, genero, domicilio);
		this.celular = celular;
		this.correo = correo;
		this.vehiculo = vehiculo;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}
