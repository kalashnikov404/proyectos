package servicios;

import java.util.List;

import api.ServiceVehiculo;
import dao.BaseDatos;
import dao.FuenteDatos;
import dao.TablaVehiculo;
import modelo.Vehiculo;

public class ServiceVehiculoImpl implements ServiceVehiculo{
	
	private TablaVehiculo tablaVehiculo;
	
	public ServiceVehiculoImpl() {
		tablaVehiculo=new TablaVehiculo(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String guardar(Vehiculo vehiculo) {
		return tablaVehiculo.guardar(vehiculo);
	}

	@Override
	public List<Vehiculo> getVehiculos() {
		return tablaVehiculo.getVehiculos();
	}

	@Override
	public String modificarPorPlacas(Vehiculo vehiculo, String placas) {
		return tablaVehiculo.modificarPorPlacas(vehiculo, placas);
	}

}
