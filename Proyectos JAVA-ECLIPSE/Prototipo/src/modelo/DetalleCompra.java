package modelo;


public class DetalleCompra extends Compra {
	
	private Integer cantidad;
	private Float costo;
	private Integer baja;
	private Integer proveedor;
	private Integer calentador;
	private Float subtotal;
	private Integer cveDetalle;
	
	public DetalleCompra() {
		super();
	}

	public Integer getCveDetalle() {
		return cveDetalle;
	}

	public void setCveDetalle(Integer cveDetalle) {
		this.cveDetalle = cveDetalle;
	}

	
	
	public DetalleCompra( Integer cveDetalle) {
		super();
		this.cveDetalle = cveDetalle;
	}

	public DetalleCompra(Integer cantidad, Float costo, Integer baja, Integer proveedor, Integer calentador,
			Float subtotal) {
		super();
		this.cantidad = cantidad;
		this.costo = costo;
		this.baja = baja;
		this.proveedor = proveedor;
		this.calentador = calentador;
		this.subtotal = subtotal;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Integer getBaja() {
		return baja;
	}

	public void setBaja(Integer baja) {
		this.baja = baja;
	}

	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getCalentador() {
		return calentador;
	}

	public void setCalentador(Integer calentador) {
		this.calentador = calentador;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "DetalleCompra [cantidad=" + cantidad + ", costo=" + costo + ", baja=" + baja + ", proveedor="
				+ proveedor + ", calentador=" + calentador + ", subtotal=" + subtotal + "]";
	}

	
}