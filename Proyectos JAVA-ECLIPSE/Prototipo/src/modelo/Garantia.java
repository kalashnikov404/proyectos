package modelo;

import java.util.Date;

public class Garantia {
	
	private Date fechaInicio;
	private Date fechaFin;
	private Calentador calentador;
	private Cliente cliente;
	
	
	public Garantia() {
		super();
		
	}

	public Garantia(Date fechaInicio, Date fechaFin, Calentador calentador, Cliente cliente) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.calentador = calentador;
		this.cliente = cliente;
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


	public Calentador getCalentador() {
		return calentador;
	}


	public void setCalentador(Calentador calentador) {
		this.calentador = calentador;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Garantia [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", calentador=" + calentador
				+ ", cliente=" + cliente + "]";
	}
	
	
	
	
}
