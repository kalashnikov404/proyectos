package modelo;

public class Padre {
	private int numero;
	private String nombre;
	private int padre;
	private String tipo;

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPadre() {
		return padre;
	}
	public void setPadre(int padre) {
		this.padre = padre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return numero + "	" + nombre + "	" + padre+"	"+tipo;
	}
	public Padre(int numero, String nombre, int padre) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.padre = padre;
		tipo="";
	}
	public Padre() {
		// TODO Auto-generated constructor stub
		tipo="";
	}

}
