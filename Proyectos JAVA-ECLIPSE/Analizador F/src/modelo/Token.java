package modelo;

public class Token {
	private String lexema;
	private String token;
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
	public Token(String token, String lexema) {
		super();
		this.token = token;
		this.lexema = lexema;
	}
	@Override
	public String toString() {
		return "Token [lexema=" + lexema + ", token=" + token + "]";
	}
	

}
