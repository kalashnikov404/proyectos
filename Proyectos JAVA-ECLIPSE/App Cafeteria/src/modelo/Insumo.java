package modelo;

public class Insumo {

//	tabla producto
	private int claveProducto;
	private String nombre;
	private String tipo;
	private String marca;
	private String presentacion;
	private String contenido;
	private String umedia;
	
//tabla minmax
	private int existencia;
	private int minimo;
	private int maximo;
	private int claveProducto2;
	private int claveCafecito;
	
	
	

	public Insumo() {
		super();
		// TODO Auto-generated constructor stub
	}
//	
//	
//
//	public Cafecito(int cveE, String estado, Ciudad ciudad) {
//		super(cveE, estado, ciudad);
//		// TODO Auto-generated constructor stub
//		
//	}
//	

//	public Insumo(int cveProducto,String nombre, String tipo, String marca, String presentacion, String contenido, String umedida) {
//		super();
//
//		this.cveP=cveP;
//		this.nombre=nombre;
//		this.tipo=tipo;
//		this.marca=marca;
//		this.presentacion=presentacion;
//		this.contenido=contenido;
//		this.umedia=umedida;
//		
//	}

	public int getClaveProducto() {
		return claveProducto;
	}

	public void setCveP(int claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getUmedia() {
		return umedia;
	}

	public void setUmedia(String umedia) {
		this.umedia = umedia;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getClaveProducto2() {
		return claveProducto2;
	}

	public void setClaveProducto2(int claveProducto2) {
		this.claveProducto2 = claveProducto2;
	}

	public int getClaveCafecito() {
		return claveCafecito;
	}

	public void setClaveCafecito(int claveCafecito) {
		this.claveCafecito = claveCafecito;
	}

	public void setClaveProducto(int claveProducto) {
		this.claveProducto = claveProducto;
	}

	
	
	
	
	
	
	
	
	
	
}
