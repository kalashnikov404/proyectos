package modelo;



public class Cafecito{
	


	private int cveCF;
	private String calle;
	private int numero;
	private String orientacion;

	private int cp;
	private String colonia;
	private String asentamiento;
	private String zona;
	private String ciudad;
	private String estado;
	

	private String municipio;
	
	private int cveCol;

	
	
	public Cafecito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cafecito(int cveCF,String calle, int numero, String orientacion, int cp, String colonia,
	 String asentamiento, String zona, String estado, String municipio) {
		super();
		this.cveCF=cveCF;
		this.calle = orientacion;
		this.numero = numero;
		this.orientacion = orientacion;
	
		this.cp=cp;
		this.colonia=colonia;
		this.asentamiento=asentamiento;
		this.zona=zona;
		this.estado=estado;
		this.municipio=municipio;
		
	}

	
	
	public int getCveCF() {
		return cveCF;
	}



	public void setCveCF(int string) {
		this.cveCF = string;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getOrientacion() {
		return orientacion;
	}



	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
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

	

	public int getCveCol() {
		return cveCol;
	}

	public void setCveCol(int cveCol) {
		this.cveCol = cveCol;
	}

	
	
}