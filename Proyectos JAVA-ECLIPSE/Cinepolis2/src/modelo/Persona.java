package modelo;

import java.time.LocalDate;

public class Persona {
	
	private String curp;
	private String nombre;
	private String paterno;
	private String materno;
	private LocalDate nacimiento;
	private String sexo;
	private String telefono;
	private String calle;
	private int numero;
	private String orientacion;
	private int colonia;
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public int getColonia() {
		return colonia;
	}
	public void setColonia(int colonia) {
		this.colonia = colonia;
	}
	@Override
	public String toString() {
		return "Persona [curp=" + curp + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", nacimiento=" + nacimiento + ", sexo=" + sexo + ", telefono=" + telefono + ", calle=" + calle
				+ ", numero=" + numero + ", orientacion=" + orientacion + ", colonia=" + colonia + "]";
	}
	
	
	
	

}
