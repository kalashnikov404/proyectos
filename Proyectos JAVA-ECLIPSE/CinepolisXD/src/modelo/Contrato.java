package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Contrato {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puesto;
	private float sueldo;
	private String descanso;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private String curp;
	private int sucursal;
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public String getDescanso() {
		return descanso;
	}
	public void setDescanso(String descanso) {
		this.descanso = descanso;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	@Override
	public String toString() {
		return "Contrato [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", puesto=" + puesto + ", sueldo="
				+ sueldo + ", descanso=" + descanso + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida
				+ ", curp=" + curp + ", sucursal=" + sucursal + "]";
	}
	
	

}
