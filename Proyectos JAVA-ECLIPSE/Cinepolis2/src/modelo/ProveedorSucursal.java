package modelo;

import java.time.LocalDate;

public class ProveedorSucursal {
	
	private LocalDate fechaprov;
	private int proveedor;
	private int sucursal;
	public LocalDate getFechaprov() {
		return fechaprov;
	}
	public void setFechaprov(LocalDate fechaprov) {
		this.fechaprov = fechaprov;
	}
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	@Override
	public String toString() {
		return "ProveedorSucursal [fechaprov=" + fechaprov + ", proveedor=" + proveedor + ", sucursal=" + sucursal
				+ "]";
	}
	
	
	
	

}
