package modelo;

public class Token {
	private String lexema;
	private String token;
	private int linea;
	
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Token(String token, String lexema,int linea) {
		super();
		this.token = token;
		this.lexema = lexema;
		this.linea = linea;
	}
	@Override
	public String toString() {
		return "Token [lexema=" + lexema + ", token=" + token + "]";
	}
	

}
