package servicios;

import java.util.ArrayList;

import api.ServiceBoleto;
import api.ServicePelicula;
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
}