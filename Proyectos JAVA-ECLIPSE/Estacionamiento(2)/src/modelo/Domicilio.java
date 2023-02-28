package modelo;

public class Domicilio {
	
	private String calle;
	private int numero;
	private String colonia;
	private String ciudad;
	private String estado;
	
	
	public Domicilio() {
		super();
	}
	
	public Domicilio(String calle, int numero, String colonia, String ciudad, String estado) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
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
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad
				+ ", estado=" + estado + "]";
	}
	
}
