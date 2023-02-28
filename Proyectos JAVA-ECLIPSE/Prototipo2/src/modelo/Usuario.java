package modelo;

public class Usuario {
	
	private String alias;
	private String contrasenia;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String alias, String contrasenia) {
		super();
		this.alias = alias;
		this.contrasenia = contrasenia;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [alias=" + alias + ", contrasenia=" + contrasenia + "]";
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
