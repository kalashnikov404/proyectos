package modelo;

public class Contrato extends Empleado {


	
	private String tipo;
	private String fechaI;
	private String fechaF;
	private String sueldo;
	private String puesto;
	
	
	
	public Contrato() {
		super();
	}
	

	
	public Contrato( String tipo,String fechaI,String fechaF,String sueldo, String puesto) {

		

		
	
		this.tipo=tipo;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.sueldo=sueldo;
		this.puesto=puesto;
		
		
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getFechaI() {
		return fechaI;
	}



	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}



	public String getFechaF() {
		return fechaF;
	}



	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}



	public String getSueldo() {
		return sueldo;
	}



	public void setSueldo(String string) {
		this.sueldo = string;
	}



	public String getPuesto() {
		return puesto;
	}



	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
	
	
	
	
}
