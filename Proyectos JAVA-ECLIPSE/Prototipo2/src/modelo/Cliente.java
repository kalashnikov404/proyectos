package modelo;

public class Cliente extends Persona{

	
	private String tipo;

	
	
	
	
	

	public Cliente() {
		super();
	}
	
	
	
	public Cliente( String nombre,String direccion,String telefono,String tipo) {
	
		
		super(nombre, direccion, telefono);
		this.tipo=tipo;
		
		
		
	}
	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
