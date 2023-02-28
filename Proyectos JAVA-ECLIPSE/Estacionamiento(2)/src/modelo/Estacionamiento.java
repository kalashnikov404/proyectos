package modelo;

import java.time.LocalDateTime;

public class Estacionamiento {
	
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Vehiculo vehiculo;
	private Lugar lugar;
	
	public Estacionamiento(LocalDateTime fechaEntrada, Vehiculo vehiculo, Lugar lugar) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.vehiculo = vehiculo;
		this.lugar = lugar;
	}
	
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	
}
