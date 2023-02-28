package api;

import java.time.LocalDateTime;

import modelo.Estacionamiento;
import modelo.Lugar;

public interface ServiceEstacionamiento {
	
	String guardar(Estacionamiento estacionamiento);
	public String obtenerImagen(Lugar lugar);
	public String registrarSalida(String placas, LocalDateTime fechaTiempo);
	public String modificarHrE(String placas, LocalDateTime fecha);
	public String modificarHrS(String placas, LocalDateTime fecha);
	public String modificarLugar(String placas, Lugar lugar);

}
