package servicios;

import java.util.List;

import api.ServiceInsumo;
import dao.FuenteDatos;
import dao.TablaInsumo;
import modelo.Empleado;
import modelo.Insumo;


public class ServiceInsumoImpl implements ServiceInsumo{
	
	
	
	private TablaInsumo tablaInsumo;
	
	public ServiceInsumoImpl() {
		tablaInsumo=new TablaInsumo(FuenteDatos.getBaseDatos().getConexion());
	}
	

	public String guardarInsumo(Insumo insumo) {
		// TODO Auto-generated method stub
		return tablaInsumo.guardarInsumo(insumo);
	
	
	}


	
	public List<Insumo> getInsumos() {
		// TODO Auto-generated method stub

		return tablaInsumo.getInsumos();

	
	}

	public Insumo consultarPorCveP(int cveP) {
		return tablaInsumo.consultarPorCveP(cveP);
	
	}



	public String eliminarInsumo(int cveP) {
		// TODO Auto-generated method stub
		return tablaInsumo.eliminarInsumo(cveP);
	}



	@Override
	public String guardarInsumoMinMax(Insumo insumo) {
		// TODO Auto-generated method stub
		return tablaInsumo.guardarInsumoMinMax(insumo);
	}


	@Override
	public List<Insumo> consultarPorDatosInsumo(String id, String nombre, String tipo, String marca,
			String presentacion, String contenido, String umedida) {
				return tablaInsumo.consultarPorDatosInsumo(id, nombre, tipo, marca, presentacion, contenido, umedida);
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Insumo> consultarPorDatosMinimoMaximo(String id, String minimo, String maximo, String claveCafecito) {
		// TODO Auto-generated method stub
		return tablaInsumo.consultarPorDatosMinimoMaximo(id, minimo, maximo, claveCafecito);
	}

	
	
	
	

	
	

}
