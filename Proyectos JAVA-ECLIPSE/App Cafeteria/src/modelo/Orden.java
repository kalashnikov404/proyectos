package modelo;

public class Orden {
//	
	//datos de la orden
	private int claveOrden;
	private String fechaOrden;
	private int numeroMesaContrato;
	private int claveCafecito;
	
	
	//datos de detalle orden
	private int numeroDetalleOrden;
	private int cantidadDetalleOrden;
	private int clavePlatillo;
	private float precioVentaDetalleOrden;
	private int claveOrden2;
	

//datos del ticket	
	private int folio;
	private String fechaticket;
	private int total;
	private int claveOrden3;
	
//datos de preparar
	
	private int clavePreparacion;
	private String fechaPreparacion;
	private int folio2;
	private int numeroDetalleOrden2;
	
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getFechaticket() {
		return fechaticket;
	}
	public void setFechaticket(String fechaticket) {
		this.fechaticket = fechaticket;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getClaveOrden3() {
		return claveOrden3;
	}
	public void setClaveOrden3(int claveOrden3) {
		this.claveOrden3 = claveOrden3;
	}
	public int getClavePreparacion() {
		return clavePreparacion;
	}
	public void setClavePreparacion(int clavePreparacion) {
		this.clavePreparacion = clavePreparacion;
	}
	public String getFechaPreparacion() {
		return fechaPreparacion;
	}
	public void setFechaPreparacion(String fechaPreparacion) {
		this.fechaPreparacion = fechaPreparacion;
	}
	public int getFolio2() {
		return folio2;
	}
	public void setFolio2(int folio2) {
		this.folio2 = folio2;
	}
	public int getNumeroDetalleOrden2() {
		return numeroDetalleOrden2;
	}
	public void setNumeroDetalleOrden2(int numeroDetalleOrden2) {
		this.numeroDetalleOrden2 = numeroDetalleOrden2;
	}
	public int getClaveOrden() {
		return claveOrden;
	}
	public void setClaveOrden(int claveOrden) {
		this.claveOrden = claveOrden;
	}
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public int getNumeroMesaContrato() {
		return numeroMesaContrato;
	}
	public void setNumeroMesaContrato(int numeroMesaContrato) {
		this.numeroMesaContrato = numeroMesaContrato;
	}
	public int getClaveCafecito() {
		return claveCafecito;
	}
	public void setClaveCafecito(int claveCafecito) {
		this.claveCafecito = claveCafecito;
	}
	public int getNumeroDetalleOrden() {
		return numeroDetalleOrden;
	}
	public void setNumeroDetalleOrden(int numeroDetalleOrden) {
		this.numeroDetalleOrden = numeroDetalleOrden;
	}
	public int getCantidadDetalleOrden() {
		return cantidadDetalleOrden;
	}
	public void setCantidadDetalleOrden(int cantidadDetalleOrden) {
		this.cantidadDetalleOrden = cantidadDetalleOrden;
	}
	public int getClavePlatillo() {
		return clavePlatillo;
	}
	public void setClavePlatillo(int clavePlatillo) {
		this.clavePlatillo = clavePlatillo;
	}
	public float getPrecioVentaDetalleOrden() {
		return precioVentaDetalleOrden;
	}
	public void setPrecioVentaDetalleOrden(float precioVentaDetalleOrden) {
		this.precioVentaDetalleOrden = precioVentaDetalleOrden;
	}
	public int getClaveOrden2() {
		return claveOrden2;
	}
	public void setClaveOrden2(int claveOrden2) {
		this.claveOrden2 = claveOrden2;
	}

	
	
	
}
