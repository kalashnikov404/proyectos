package servicios;

import java.util.ArrayList;

import utilidades.ServiceBoleto;
import utilidades.ServicePelicula;
import dao.FuenteDatos;
import dao.TablaBoleto;
import dao.TablaPelicula;
import excepciones.ConexionException;

public class ServiceBoletoImpl implements ServiceBoleto{

	
	
	
private TablaBoleto tablaBoleto;

public ServiceBoletoImpl() {
	try {
		tablaBoleto=new TablaBoleto(FuenteDatos.getBaseDatos().getConexion());
	} catch (ConexionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

@Override
public ArrayList<String> llenar_comboEmpleado() {
	// TODO Auto-generated method stub
	return tablaBoleto.llenar_comboEmpleado();
}

public ArrayList<String> llenar_comboPelicula() {
	// TODO Auto-generated method stub
	return tablaBoleto.llenar_comboPelicula();
}

@Override
public ArrayList<String> llenar_comboSala() {
	// TODO Auto-generated method stub
	return tablaBoleto.llenar_comboSala();
}

@Override
public ArrayList<String> llenar_comboPrecio() {
	// TODO Auto-generated method stub
	return tablaBoleto.llenar_comboPrecio();
}

@Override
public ArrayList<String> llenar_comboTipo() {
	// TODO Auto-generated method stub
	return tablaBoleto.llenar_comboTipo();
}
}