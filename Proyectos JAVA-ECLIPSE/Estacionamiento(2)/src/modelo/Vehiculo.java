package modelo;

import java.sql.Date;

import java.sql.Time;
import enumeraciones.Tamaños;
import enumeraciones.Tipos;

public class Vehiculo {
	
	private String placas;
	private String modelo;
	private int año;
	private String marca;
	private String color;
	private Tamaños tamaño;
	private Tipos tipo;
	
	public Vehiculo() {
		super();
	}
	
	public Vehiculo(String placas, String modelo, int año, String marca, String color, Tamaños tamaño, Tipos tipo) {
		super();
		this.placas = placas;
		this.modelo = modelo;
		this.año = año;
		this.marca = marca;
		this.color = color;
		this.tamaño = tamaño;
		this.tipo = tipo;
	}
	
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Tamaños getTamaño() {
		return tamaño;
	}
	public void setTamaño(Tamaños tamaño) {
		this.tamaño = tamaño;
	}
	public Tipos getTipo() {
		return tipo;
	}
	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [placas=" + placas + ", modelo=" + modelo + ", año=" + año + ", marca=" + marca + ", color="
				+ color + ", tamaño=" + tamaño + ", tipo=" + tipo + "]";
	}
	
}
