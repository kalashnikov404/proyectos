package modelo;

public class Colonia {

	private String nombre;
	private String codigo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "Colonia [nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	
	
	
}
