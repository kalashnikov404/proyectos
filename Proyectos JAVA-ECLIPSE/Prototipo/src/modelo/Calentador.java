package modelo;

public class Calentador {

	private String tipo;
	private int numCilindros;
	private String dimensiones;
	private String marca;
	private Double precio;
	private Integer cvecal;

	public Calentador() {
		super();

	}
	public Calentador(String tipo, int num_cilindros,String dimensiones,String marca,Double precio) {
		super();
		this.tipo = tipo;
		this.numCilindros = num_cilindros;
		this.dimensiones = dimensiones;
		this.marca = marca;
		this.precio = precio;
	}

	public Integer getCvecal() {
		return cvecal;
	}
	public void setCvecal(Integer cvecal) {
		this.cvecal = cvecal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumCilindros() {
		return numCilindros;
	}
	public void setNumCilindros(int num_cilindros) {
		this.numCilindros = num_cilindros;
	}
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Calentador [tipo=" + tipo + ", num_cilindros=" + numCilindros + ", dimensiones=" + dimensiones
				+ ", marca=" + marca + ", precio=" + precio + "]";
	}



}
