package modelo;

import java.sql.Time;
import java.util.Date;

public class Trabajo {

	private String tipo;
	private Time hora;
	private Date fecha;
	private Empleado empleado;
	private Transporte transporte;
	
	public Trabajo() {
		super();
	}
	
	public Trabajo(String tipo, Time hora, Date fecha, Empleado empleado, Transporte transporte) {
		super();
		this.tipo = tipo;
		this.hora = hora;
		this.fecha = fecha;
		this.empleado = empleado;
		this.transporte = transporte;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Transporte getTransporte() {
		return transporte;
	}
	
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
}
