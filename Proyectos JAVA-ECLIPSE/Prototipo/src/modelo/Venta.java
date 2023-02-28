package modelo;

import java.sql.Time;
import java.util.Date;

public class Venta {
	
	private Date fecha;
	private Time hora;
	private Double precioTotal;
	private int cantidad;
	private Calentador calentador;
	private Cliente cliente;
	private Empleado empleado;
	private Garantia garantia;
	
	
	public Venta() {
		super();
	}

	public Venta(Date fecha, Time hora, Double precioTotal, int cantidad, Calentador calentador, Cliente cliente,
			Empleado empleado, Garantia garantia) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precioTotal = precioTotal;
		this.cantidad = cantidad;
		this.calentador = calentador;
		this.cliente = cliente;
		this.empleado = empleado;
		this.garantia = garantia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}

	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", hora=" + hora + ", precioTotal=" + precioTotal + ", cantidad=" + cantidad
				+ ", calentador=" + calentador + ", cliente=" + cliente + ", empleado=" + empleado + ", garantia="
				+ garantia + "]";
	}
	
	

}
