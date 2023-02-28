package modelo;

public class Json {

	private int id;
	private String nombreEs;
	private String siglas;
	private String prefijo;
	private String nombreUs;
	
	
	
	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Json(int id, String nombreEs, String siglas, String prefijo, String nombreUs) {
		super();
		this.id = id;
		this.nombreEs = nombreEs;
		this.siglas = siglas;
		this.prefijo = prefijo;
		this.nombreUs = nombreUs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreEs() {
		return nombreEs;
	}
	public void setNombreEs(String nombreEs) {
		this.nombreEs = nombreEs;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNombreUs() {
		return nombreUs;
	}
	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	
	
	
}
