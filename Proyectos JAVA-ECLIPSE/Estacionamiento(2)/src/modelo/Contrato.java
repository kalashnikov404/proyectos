package modelo;

import java.util.Date;

public class Contrato {
	
	private int clave;
	private Date fechaInicio;
	private Date fechaFin;
	private int numCliente;
	
	public Contrato() {
		super();
	}
	
	public Contrato(int clave, Date fechaInicio, Date fechaFin, int numCliente) {
		super();
		this.clave = clave;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.numCliente = numCliente;
	}
	
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}
	
	@Override
	public String toString() {
		return "Contrato [clave=" + clave + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", numCliente="
				+ numCliente + "]";
	}
	
}
