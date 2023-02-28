package api;

import java.util.List;

import modelo.Empleado;
import modelo.Insumo;
import dao.TablaInsumo;


public interface ServiceInsumo {
	
	String guardarInsumo(Insumo insumo);
	public String guardarInsumoMinMax(Insumo insumo);
//	String guardarCeV(Cafecito cafecito);
//	String guardarCoV(Cafecito cafecito);
//	String guardarV(Cafecito cafecito);
	
	public List<Insumo> getInsumos();
	
	public Insumo consultarPorCveP(int cveP);
	public List<Insumo> consultarPorDatosInsumo(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida);
	public List<Insumo> consultarPorDatosMinimoMaximo(String id, String minimo, String maximo, String claveCafecito);
//	public String modificarCalle(int cveP, String calle);
//
//	public int modificarNumero(int cveCafecito, int numero);
//	public String modificarOrientacion(int cveCafecito, String orientacion);
//	

	public String eliminarInsumo(int cveP);
	

}
