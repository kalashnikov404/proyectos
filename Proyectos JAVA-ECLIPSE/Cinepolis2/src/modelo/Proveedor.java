package modelo;

public class Proveedor {
	
	private String empresa;
	private String telefono;
	private String calle;
	private int numero;
	private String orientacion;
	private int colonia;
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	public int getColonia() {
		return colonia;
	}
	public void setColonia(int colonia) {
		this.colonia = colonia;
	}
	@Override
	public String toString() {
		return "Proveedor [empresa=" + empresa + ", telefono=" + telefono + ", calle=" + calle + ", numero=" + numero
				+ ", orientacion=" + orientacion + ", colonia=" + colonia + "]";
	}
	
	

}