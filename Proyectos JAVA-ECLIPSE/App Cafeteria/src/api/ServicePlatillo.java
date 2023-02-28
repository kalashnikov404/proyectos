package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Insumo;
import modelo.Platillo;
import dao.TablaPlatillo;


public interface ServicePlatillo {
	
	String guardarPlatillo(Platillo platillo);
	String guardarPlatilloIngrediente(Platillo platillo);
	String guardarPlatilloCafecito(Platillo platillo);
	String guardarPlatilloCosto(Platillo platillo);
	public ArrayList<String> llenar_comboInsumo();

	
	public List<Platillo> getPlatillos();
	
//	public Insumo consultarPorCveP(int cveP);
//	public List<Insumo> consultarPorDatosInsumo(String id, String nombre, String tipo, String marca, String presentacion, String contenido, String umedida);
//	public List<Insumo> consultarPorDatosMinimoMaximo(String id, String minimo, String maximo, String claveCafecito);
////	public String modificarCalle(int cveP, String calle);
////
////	public int modificarNumero(int cveCafecito, int numero);
////	public String modificarOrientacion(int cveCafecito, String orientacion);
////	
//
//	public String eliminarInsumo(int cveP);
//	

}
