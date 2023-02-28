package modelo;

public class Pilaa {
	private String token;
	private int numero=0;
	private int padre=0;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPadre() {
		return padre;
	}
	public void setPadre(int padre) {
		this.padre = padre;
	}
	@Override
	public String toString() {
		return "Pilaa [token=" + token + ", numero=" + numero + ", padre=" + padre + "]";
	}
	
	
}
