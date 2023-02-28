package servicios;

import java.util.ArrayList;
import java.util.List;

import api.ServiceResurtido;
import dao.FuenteDatos;
import dao.TablaEmpleado;
import dao.TablaResurtido;
import modelo.Resurtido;

public class ServiceResurtidoImpl  implements ServiceResurtido{

	

	private TablaResurtido tablaResurtido;
	
	public ServiceResurtidoImpl() {
		tablaResurtido=new TablaResurtido(FuenteDatos.getBaseDatos().getConexion());

	}

	@Override
	public ArrayList<String> llenar_comboProveedor() {
		// TODO Auto-generated method stub
		return tablaResurtido.llenar_comboProveedor();
	}

	@Override
	public List<Resurtido> getResurtidos() {
		// TODO Auto-generated method stub
		return tablaResurtido.getResurtidos();
	}
	
	
	
}
