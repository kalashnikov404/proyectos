package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServicePlatillo;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import dao.TablaPlatillo;
import modelo.Platillo;

public class ServicePlatilloImpl implements ServicePlatillo {

	

	private TablaPlatillo tablaPlatillo;
	
	public ServicePlatilloImpl() {
		tablaPlatillo=new TablaPlatillo(FuenteDatos.getBaseDatos().getConexion());

	}

	@Override
	public String guardarPlatillo(Platillo platillo) {
		// TODO Auto-generated method stub
		return tablaPlatillo.guardarPlatillo(platillo);
	}

	@Override
	public String guardarPlatilloIngrediente(Platillo platillo) {
		// TODO Auto-generated method stub
		return tablaPlatillo.guardarPlatilloIngrediente(platillo);
	}

	@Override
	public String guardarPlatilloCafecito(Platillo platillo) {
		// TODO Auto-generated method stub
		return tablaPlatillo.guardarPlatilloCafecito(platillo);
	}

	@Override
	public String guardarPlatilloCosto(Platillo platillo) {
		// TODO Auto-generated method stub
		return tablaPlatillo.guardarPlatilloCosto(platillo);
	}

	@Override
	public List<Platillo> getPlatillos() {
		// TODO Auto-generated method stub
		return tablaPlatillo.getPlatillos();
	}

	@Override
	public ArrayList<String> llenar_comboInsumo() {
		// TODO Auto-generated method stub
		return tablaPlatillo.llenar_comboInsumo();
	}
	
	
	
}
