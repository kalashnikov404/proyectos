package api;

import java.util.List;

import modelo.Vehiculo;

public interface ServiceVehiculo {
	
	String guardar(Vehiculo vehiculo);
	
	List<Vehiculo> getVehiculos();
	
	public String modificarPorPlacas(Vehiculo vehiculo, String placas);

}
