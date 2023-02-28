package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceCafecito;
import dao.FuenteDatos;
import dao.TablaCafecito;
import dao.TablaCiudad;
import modelo.Cafecito;
import modelo.Ciudad;


public class ServiceCafecitoImpl implements ServiceCafecito {
	
	
	private TablaCiudad tablaCiudad;
	private TablaCafecito tablaCafecito;
	
	public ServiceCafecitoImpl() {
		tablaCafecito=new TablaCafecito(FuenteDatos.getBaseDatos().getConexion());
		tablaCiudad=new TablaCiudad(FuenteDatos.getBaseDatos().getConexion());

	}
	
//Guarda cafecito
	public String guardar1(Cafecito cafecito) {
		// TODO Auto-generated method stub
		return tablaCafecito.guardar1(cafecito);
	
	
	}
	
//	//guarda ciudad
//
//	public String guardarCafecitoCiudad(Ciudad ciudad) {
//		// TODO Auto-generated method stub
//		return tablaCafecito.guardarCafecitoCiudad(cafecito);
//	
//	
//	}

	
	//guarda cp




	@Override
	public List<Cafecito> getCafecitos() {
		// TODO Auto-generated method stub

		return tablaCafecito.getCafecitos();

	
	}

	@Override
	public List<Ciudad> getCiudades() {
		// TODO Auto-generated method stub

		return tablaCiudad.getCiudades();

	
	}
	
	
	
//	@Override
//
//	public List<Cafecito> getCafecitos2() {
//		// TODO Auto-generated method stub
//
//		return tablaCafecito.getCafecitos2();
//
//	
//	}


	@Override
	public Cafecito consultarPorCve(int cveCF) {
		return tablaCafecito.consultarPorCve(cveCF);
	
	}

	
	@Override
	public String modificarCalle(int cveCafecito, String calle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarNumero(int cveCafecito, int numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String modificarOrientacion(int cveCafecito, String orientacion) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String eliminarCafecito(int cveCafecito) {
		return tablaCafecito.eliminarCliente(cveCafecito);

	}

	
	@Override
	public ArrayList<String> llenar_combo() {
		// TODO Auto-generated method stub

		return tablaCafecito.llenar_combo();

	
	}

	@Override
	public List<Cafecito> consultarPorDatosCafecito(String clave, String calle, String numero, String orientacion) {
		// TODO Auto-generated method stub

	return tablaCafecito.consultarPorDatosCafecito(clave, calle, numero, orientacion);
	
	}

	@Override
	public List<Cafecito> consultarPorDatosColonia(String colonia, String asentamiento, String zona) {
		// TODO Auto-generated method stub
		return tablaCafecito.consultarPorDatosColonia(colonia, asentamiento, zona);
	}

	@Override
	public List<Cafecito> consultarPorCP(String CP) {
		// TODO Auto-generated method stub
		return tablaCafecito.consultarPorCP(CP);
	}

	@Override
	public List<Cafecito> consultarPorDatosCiudad(String ciudad, String municipio) {
		// TODO Auto-generated method stub
		return tablaCafecito.consultarPorDatosCiudad(ciudad, municipio);
	}

	@Override
	public List<Cafecito> consultarPorDatosEstado(String estado) {
		return tablaCafecito.consultarPorDatosEstado(estado);

	}

	@Override
	public String modificarCafecito(Cafecito cafecito, int CveCF) {
		// TODO Auto-generated method stub
return tablaCafecito.modificarCafecito(cafecito, CveCF);

	}

	@Override
	public String modificarClaveCafecito(int clave, int CveCF) {
		// TODO Auto-generated method stub
		return tablaCafecito.modificarClaveCafecito(clave, CveCF);
	}

	@Override
	public String modificarCalleCafecito(String calle, int CveCF) {
		// TODO Auto-generated method stub
		return tablaCafecito.modificarCalleCafecito(calle, CveCF);
	}

	@Override
	public String modificarNumeroCafecito(int numero, int CveCF) {
		// TODO Auto-generated method stub
		return tablaCafecito.modificarNumeroCafecito(numero, CveCF);
	}

	@Override
	public String modificarOrientacionCafecito(String orientacion, int CveCF) {
		// TODO Auto-generated method stub
		return tablaCafecito.modificarOrientacionCafecito(orientacion, CveCF);
	}

	@Override
	public String modificarClaveColoniaCafecito(int claveColonia, int CveCF) {
		// TODO Auto-generated method stub
		return tablaCafecito.modificarClaveColoniaCafecito(claveColonia, CveCF);
	}


	
	
	

}
