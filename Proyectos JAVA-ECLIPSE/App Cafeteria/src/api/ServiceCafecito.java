package api;

import java.util.ArrayList;
import java.util.List;

import modelo.Cafecito;
import modelo.Ciudad;


public interface ServiceCafecito {
	
	String guardar1(Cafecito cafecito);
//	String guardar2(Cafecito cafecito2);
//
//	String guardarCiudad(Ciudad ciudad);
//	String guardarCiudadCP(Ciudad ciudad);
//	String guardarCiudadColonia(Ciudad ciudad);
//	String guardarCiudadEstado(Ciudad ciudad);
//
//	String guardarCafecitoCiudad(Cafecito cafecito);
//	String guardarCafecitoCP(Cafecito cafecito);
//	String guardarCafecitoColonia(Cafecito cafecito);
//	String guardarCafecitoEstado(Cafecito cafecito);



	
//	String guardarCeV(Cafecito cafecito);
//	String guardarCoV(Cafecito cafecito);
//	String guardarV(Cafecito cafecito);
	
	public List<Cafecito> getCafecitos();
	public List<Ciudad> getCiudades();
	  public ArrayList<String> llenar_combo();

	  public List<Cafecito> consultarPorDatosCafecito(String clave, String calle, String numero, String orientacion);
	  public List<Cafecito> consultarPorDatosColonia(String colonia, String asentamiento, String zona);
	  public List<Cafecito> consultarPorCP(String CP);
	  public List<Cafecito> consultarPorDatosCiudad(String ciudad, String municipio);
	  public List<Cafecito> consultarPorDatosEstado(String estado);


//	public List<Cafecito> getCafecitos2();


	public Cafecito consultarPorCve(int cve);
	public String modificarCalle(int cveCafecito, String calle);

	public int modificarNumero(int cveCafecito, int numero);
	public String modificarOrientacion(int cveCafecito, String orientacion);
	

	public String eliminarCafecito(int cveCafecito);
	
	  public String modificarCafecito(Cafecito cafecito, int CveCF);

		public String modificarClaveCafecito(int clave, int CveCF);
	public String modificarCalleCafecito(String calle, int CveCF);
	public String modificarNumeroCafecito(int numero, int CveCF);
	public String modificarOrientacionCafecito(String orientacion, int CveCF);
	public String modificarClaveColoniaCafecito(int claveColonia, int CveCF);



	
	
	

}
