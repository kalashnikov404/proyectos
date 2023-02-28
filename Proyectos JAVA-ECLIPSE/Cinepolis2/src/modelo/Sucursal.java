package modelo;

public class Sucursal {
	
	private int numero;
	private String calle;
	private int num;
	private String orientacion;
	private int colonia;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
		return "Sucursal [numero=" + numero + ", calle=" + calle + ", num=" + num + ", orientacion=" + orientacion
				+ ", colonia=" + colonia + "]";
	}
	

}
