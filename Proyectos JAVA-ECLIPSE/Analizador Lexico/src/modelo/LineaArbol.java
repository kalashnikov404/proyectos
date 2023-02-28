package modelo;

public class LineaArbol {
	private String nombre;
	private String token;
	private String lexema;
	private String padre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	public String getPadre() {
		return padre;
	}
	public void setPadre(String padre) {
		this.padre = padre;
	}
	public LineaArbol(String nombre, String token, String lexema, String padre) {
		super();
		this.nombre = nombre;
		this.token = token;
		this.lexema = lexema;
		this.padre = padre;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", token=" + token + ", lexema=" + lexema + ", padre=" + padre;
	}
	
	

	

}
