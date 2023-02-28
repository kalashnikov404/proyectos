package modelo;

public class TokenAux {
	private String token;
	private int linea;
	public String getToken() {
		return token;
	}
	public TokenAux(String token,int linea) {
		this.token=token;
		this.linea=linea;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	@Override
	public String toString() {
		return "TokenAux [token=" + token + ", linea=" + linea + "]";
	}
	
}
