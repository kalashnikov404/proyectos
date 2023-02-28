package modelo;

public class Platillo {

	//Tabla platillo
	private int clavePlatillo;
	private String nombre;
	private String tipo;
	private String descripcion;
	private String tiempo;
	private int porcion;
	
	//Tabla ingrediente platillo
	private int numeroIngredientePlatillo;
	private float cantidad;
	private String umedida;
	private int claveProducto;
	private int clavePlatillo2;
	
	//Tabla Costo
	private int numeroCosto;
	private float costo;
	private int numeroIngredientePlatillo2;
	
	//tabla platillo cafecito
	
	private int numeroPlatilloCafecito;
	private String fechaPlatilloCafecito;
	private int claveCafecito;
	private int clavePlatillo3;
	
	
	
	
	
	public int getClavePlatillo() {
		return clavePlatillo;
	}
	public void setClavePlatillo(int clavePlatillo) {
		this.clavePlatillo = clavePlatillo;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public int getPorcion() {
		return porcion;
	}
	public void setPorcion(int porcion) {
		this.porcion = porcion;
	}
	public int getNumeroIngredientePlatillo() {
		return numeroIngredientePlatillo;
	}
	public void setNumeroIngredientePlatillo(int numeroIngredientePlatillo) {
		this.numeroIngredientePlatillo = numeroIngredientePlatillo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public String getUmedida() {
		return umedida;
	}
	public void setUmedida(String umedida) {
		this.umedida = umedida;
	}
	public int getClaveProducto() {
		return claveProducto;
	}
	public void setClaveProducto(int claveProducto) {
		this.claveProducto = claveProducto;
	}
	public int getClavePlatillo2() {
		return clavePlatillo2;
	}
	public void setClavePlatillo2(int clavePlatillo2) {
		this.clavePlatillo2 = clavePlatillo2;
	}
	public int getNumeroCosto() {
		return numeroCosto;
	}
	public void setNumeroCosto(int numeroCosto) {
		this.numeroCosto = numeroCosto;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public int getNumeroIngredientePlatillo2() {
		return numeroIngredientePlatillo2;
	}
	public void setNumeroIngredientePlatillo2(int numeroIngredientePlatillo2) {
		this.numeroIngredientePlatillo2 = numeroIngredientePlatillo2;
	}
	public int getNumeroPlatilloCafecito() {
		return numeroPlatilloCafecito;
	}
	public void setNumeroPlatilloCafecito(int numeroPlatilloCafecito) {
		this.numeroPlatilloCafecito = numeroPlatilloCafecito;
	}
	public String getFechaPlatilloCafecito() {
		return fechaPlatilloCafecito;
	}
	public void setFechaPlatilloCafecito(String fechaPlatilloCafecito) {
		this.fechaPlatilloCafecito = fechaPlatilloCafecito;
	}
	public int getClaveCafecito() {
		return claveCafecito;
	}
	public void setClaveCafecito(int claveCafecito) {
		this.claveCafecito = claveCafecito;
	}
	public int getClavePlatillo3() {
		return clavePlatillo3;
	}
	public void setClavePlatillo3(int clavePlatillo3) {
		this.clavePlatillo3 = clavePlatillo3;
	}

	
	
	
	
	
}
