package modelo;

import enumeraciones.Servicios;

public class RenglonTicket {

	
	public RenglonTicket(Servicios servicio, double costo) {
		super();
		this.servicio = servicio;
		this.costo = costo;
	}
	private Servicios servicio;
	private double costo;
	
	
	public Servicios getServicio() {
		return servicio;
	}
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
}
