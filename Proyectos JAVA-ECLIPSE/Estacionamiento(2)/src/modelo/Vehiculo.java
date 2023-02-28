package modelo;

import java.sql.Date;

import java.sql.Time;
import enumeraciones.Tama�os;
import enumeraciones.Tipos;

public class Vehiculo {
	
	private String placas;
	private String modelo;
	private int a�o;
	private String marca;
	private String color;
	private Tama�os tama�o;
	private Tipos tipo;
	
	public Vehiculo() {
		super();
	}
	
	public Vehiculo(String placas, String modelo, int a�o, String marca, String color, Tama�os tama�o, Tipos tipo) {
		super();
		this.placas = placas;
		this.modelo = modelo;
		this.a�o = a�o;
		this.marca = marca;
		this.color = color;
		this.tama�o = tama�o;
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
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
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
	public Tama�os getTama�o() {
		return tama�o;
	}
	public void setTama�o(Tama�os tama�o) {
		this.tama�o = tama�o;
	}
	public Tipos getTipo() {
		return tipo;
	}
	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [placas=" + placas + ", modelo=" + modelo + ", a�o=" + a�o + ", marca=" + marca + ", color="
				+ color + ", tama�o=" + tama�o + ", tipo=" + tipo + "]";
	}
	
}
