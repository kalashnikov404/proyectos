package modelo;

public class Empleado extends Persona {
private String rfc;
private String curp;
private String numeroSeguro;

public Empleado() {
	super();
}
public Empleado(String rfc,String curp,String numeroSeguro) {
	super();
	this.rfc=rfc;
	this.curp=curp;
	this.numeroSeguro=numeroSeguro;
}

public String getRfc() {
	return rfc;
}
public void setRfc(String rfc) {
	this.rfc = rfc;
}
public String getCurp() {
	return curp;
}
public void setCurp(String curp) {
	this.curp = curp;
}
public String getNumeroSeguro() {
	return numeroSeguro;
}
public void setNumeroSeguro(String numeroSeguro) {
	this.numeroSeguro = numeroSeguro;
}
@Override
public String toString() {
	return "Empleado [rfc=" + rfc + ", curp=" + curp + ", numeroSeguro=" + numeroSeguro + "]";
}


}
