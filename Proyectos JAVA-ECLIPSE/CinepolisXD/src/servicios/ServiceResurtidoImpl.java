package servicios;

import java.util.ArrayList;


import utilidades.ServiceResurtido;
import dao.FuenteDatos;

import dao.TablaResurtido;
import excepciones.ConexionException;

public class ServiceResurtidoImpl implements ServiceResurtido{

	
	
	
private TablaResurtido tablaResurtido;

public ServiceResurtidoImpl() {
	try {
		tablaResurtido=new TablaResurtido(FuenteDatos.getBaseDatos().getConexion());
	} catch (ConexionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}



@Override
public ArrayList<String> llenar_comboProveedor() {
	// TODO Auto-generated method stub
	return tablaResurtido.llenar_comboProveedor();
}



@Override
public ArrayList<String> llenar_comboSucursal() {
	// TODO Auto-generated method stub
	return tablaResurtido.llenar_comboSucursal();
}

@Override
public ArrayList<String> llenar_comboResurtido() {
	// TODO Auto-generated method stub
	return tablaResurtido.llenar_comboResurtido();
}



public ArrayList<String> llenar_comboBotana() {
	// TODO Auto-generated method stub
	return tablaResurtido.llenar_comboBotana();
}




}