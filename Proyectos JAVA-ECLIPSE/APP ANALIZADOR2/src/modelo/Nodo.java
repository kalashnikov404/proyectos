package modelo;

public class Nodo {
	int numero=0;
	String nombre="";
	String lexema="";
	int padre=0;
	String tipo="null";
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
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
	
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	@Override
	public String toString() {
		return "Nodo [numero=" + numero + ", nombre=" + nombre + ", lexema=" + lexema + ", padre=" + padre + " Tipo=" +tipo+"]";
	}
	
	
}
