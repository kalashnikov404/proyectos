package modelo;

import java.util.Date;

public class Compra {
	private Integer cve;
	private Date fecha;
	private Float total;
	
	public Compra() {
	super();
	}

	public Compra(Integer cve, Date fecha, Float total) {
		super();
		this.cve = cve;
		this.fecha = fecha;
		this.total = total;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [cve=" + cve + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	

}
