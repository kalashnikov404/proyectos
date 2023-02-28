package modelo;

public class Transporte {
	
	private String placas;
	private String tipo;
	
	public Transporte() {
		super();
	}
	
	public Transporte(String placas, String tipo) {
		super();
		this.placas = placas;
		this.tipo = tipo;
	}
	
	public String getPlacas() {
		return placas;
	}
	
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Transporte [placas=" + placas + ", tipo=" + tipo + "]";
	}
	
}
