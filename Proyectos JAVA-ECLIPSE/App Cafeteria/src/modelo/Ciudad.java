package modelo;

public class Ciudad {

	private String ciudad;
	private String municipio;
	private int cp;
	private String colonia;
	private String asentamiento;
	private String zona;
	private String estado;
	
	
	
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Ciudad(String ciudad, String municipio, int cp) {
		
		this.ciudad=ciudad;
		this.municipio=municipio;
		this.cp=cp;
	}




	public String getCiudad() {
		return ciudad;
	}




	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}




	public String getMunicipio() {
		return municipio;
	}




	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getAsentamiento() {
		return asentamiento;
	}


	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
	
}
