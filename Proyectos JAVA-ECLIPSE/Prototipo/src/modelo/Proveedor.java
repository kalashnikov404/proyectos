package modelo;

public class Proveedor extends Persona{
	private String razonSocial;
	private String email;
	private Integer cve;

	public Proveedor() {
		super();
	}
	public Proveedor(String razonSocial,String email) {
		super();
		this.razonSocial=razonSocial;
		this.email=email;
	}


	public Integer getCve() {
		return cve;
	}
	public void setCve(Integer cve) {
		this.cve = cve;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Proveedor [razonSocial=" + razonSocial + ", email=" + email + ", cve=" + cve + "]";
	}



}
