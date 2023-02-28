package modelo;

public class Resurtido {
	
	
	
	private String claveProveedor;
	private String claveSucursal;
	private int cantidad;
	private int baja;
	private float precio;
	private String cveEmpleado;
	private String claveBotana;
	

	public String getClaveProveedor() {
		return claveProveedor;
	}
	public String setClaveProveedor(String claveProveedor) {
		return this.claveProveedor = claveProveedor;
	}
	public String getClaveSucursal() {
		return claveSucursal;
	}
	public String setClaveSucursal(String claveSucursal) {
		return this.claveSucursal = claveSucursal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public long setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}
	public int getBaja() {
		return baja;
	}
	public long setBaja(int baja) {
		return this.baja = baja;
	}
	public float getPrecio() {
		return precio;
	}
	public long setPrecio(int precio) {
		this.precio = precio;
		return precio;
	}
	public String getCveEmpleado() {
		return cveEmpleado;
	}
	public String setCveEmpleado(String cveEmpleado) {
		return this.cveEmpleado = cveEmpleado;
	}
	public String getClaveBotana() {
		return claveBotana;
	}
	public String setClaveBotana(String claveBotana) {
		return this.claveBotana = claveBotana;
	}
	@Override
	public String toString() {
		return "Resurtido [claveProveedor=" + claveProveedor + ", claveSucursal=" + claveSucursal + ", cantidad="
				+ cantidad + ", baja=" + baja + ", precio=" + precio + ", cveEmpleado=" + cveEmpleado + ", claveBotana="
				+ claveBotana + "]";
	}


	
	
//
//	----------+----------+------+-----+---------+----------------+
//	| cve_res   | int      | NO   | PRI | NULL    | auto_increment |
//	| fecha_res | datetime | NO   |     | NULL    |                |
//	| cve_prov  | int      | NO   | MUL | NULL    |                |
//	| cve_suc   | int      | NO   | MUL | NULL    |                |
//	+-----------+----------+------+-----+---------+----------------+
//	4 rows in set (0.01 sec)
//
//	mysql> describe renglonresurtir;//
//	+-----------------+------------+------+-----+---------+----------------+
//	| Field           | Type       | Null | Key | Default | Extra          |
//	+-----------------+------------+------+-----+---------+----------------+
//	| num_renres      | int        | NO   | PRI | NULL    | auto_increment |
//	| cantidad_renres | int        | NO   |     | NULL    |                |
//	| baja_renres     | int        | NO   |     | NULL    |                |
//	| precio_renres   | float(6,2) | NO   |     | NULL    |                |
//	| cve_bot         | int        | NO   | MUL | NULL    |                |
//	| cve_res         | int        | NO   | MUL | NULL    |
	
	
	
	
	
	
	
	
	
	
	
}
