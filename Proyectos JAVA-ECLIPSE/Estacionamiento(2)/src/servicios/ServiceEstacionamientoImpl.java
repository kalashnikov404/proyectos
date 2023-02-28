package servicios;

import java.time.LocalDateTime;

import api.ServiceEstacionamiento;
import dao.FuenteDatos;
import dao.TablaEstacionamiento;
import modelo.Estacionamiento;
import modelo.Lugar;

public class ServiceEstacionamientoImpl implements ServiceEstacionamiento{

	private TablaEstacionamiento tablaEstacionamiento;

	public ServiceEstacionamientoImpl() {
		tablaEstacionamiento=new TablaEstacionamiento(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String guardar(Estacionamiento estacionamiento) {
		return tablaEstacionamiento.guardar(estacionamiento);
	}

	@Override
	public String obtenerImagen(Lugar lugar) {
		return tablaEstacionamiento.obtenerImagen(lugar);
	}

	@Override
	public String registrarSalida(String placas, LocalDateTime fechaTiempo) {
		return tablaEstacionamiento.registrarSalida(placas, fechaTiempo);
	}

	@Override
	public String modificarHrE(String placas, LocalDateTime fecha) {
		return tablaEstacionamiento.modificarHrE(placas, fecha);
	}

	@Override
	public String modificarHrS(String placas, LocalDateTime fecha) {
		return tablaEstacionamiento.modificarHrS(placas, fecha);
	}

	@Override
	public String modificarLugar(String placas, Lugar lugar) {
		return tablaEstacionamiento.modificarLugar(placas, lugar);
	}

}
