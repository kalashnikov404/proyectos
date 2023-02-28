package modelo;

public class Boleto {

	private String clave;

	private String precio;
	private String tipo;
	private String cvePelicula;
	private String cveSala;
	private int cantidad;
	private String cveEmpleado;
	
	
	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getPrecio() {
		return precio;
	}


	public String setPrecio(String precio) {
		return this.precio = precio;
	}


	public String getTipo() {
		return tipo;
	}


	public String setTipo(String tipo) {
		return this.tipo = tipo;
	}


	public String getCvePelicula() {
		return cvePelicula;
	}


	public String setCvePelicula(String cvePelicula) {
		return this.cvePelicula = cvePelicula;
	}


	public String getCveSala() {
		return cveSala;
	}


	public String setCveSala(String cveSala) {
		return this.cveSala = cveSala;
	}


	public int getCantidad() {
		return cantidad;
	}


	public int setCantidad(int i) {
		return this.cantidad = i;
	}


	public String getCveEmpleado() {
		return cveEmpleado;
	}


	public String setCveEmpleado(String cveEmpleado) {
		return this.cveEmpleado = cveEmpleado;
	}


	@Override
	public String toString() {
		return "Boleto [precio=" + precio + ", tipo=" + tipo + ", cvePelicula=" + cvePelicula + ", cveSala=" + cveSala
				+ ", cantidad=" + cantidad + ", cveEmpleado=" + cveEmpleado + "]";
	}

	
	
	
	
	
	
	
	
	
}
