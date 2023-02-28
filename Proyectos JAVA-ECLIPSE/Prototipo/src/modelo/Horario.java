package modelo;

import java.sql.Time;
import java.util.Date;

public class Horario {
	
	private Date fechaAsignacion;
	private String dia;
	private Time hrEntrada;
	private Time hrSalida;
	private String rfc;
	
	public Horario() {
		super();
	}

	public Horario(Date fechaAsignacion, String dia, Time hrEntrada, Time hrSalida, String rfc) {
		super();
		this.fechaAsignacion = fechaAsignacion;
		this.dia = dia;
		this.hrEntrada = hrEntrada;
		this.hrSalida = hrSalida;
		this.rfc=rfc;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Time getHrEntrada() {
		return hrEntrada;
	}

	public void setHrEntrada(Time hrEntrada) {
		this.hrEntrada = hrEntrada;
	}

	public Time getHrSalida() {
		return hrSalida;
	}

	public void setHrSalida(Time hrSalida) {
		this.hrSalida = hrSalida;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "Horario [fechaAsignacion=" + fechaAsignacion + ", dia=" + dia + ", hrEntrada=" + hrEntrada
				+ ", hrSalida=" + hrSalida + ", rfc=" + rfc + "]";
	}

}
