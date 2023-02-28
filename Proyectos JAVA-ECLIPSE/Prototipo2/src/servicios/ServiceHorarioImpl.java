package servicios;

import java.util.List;

import api.ServiceHorario;
import dao.FuenteDatos;
import dao.TablaHorario;
import dao.TablaTransporte;
import excepciones.ConexionException;
import modelo.Horario;

public class ServiceHorarioImpl implements ServiceHorario{

	private TablaHorario tablaHorario;

	public ServiceHorarioImpl() throws ConexionException {
		tablaHorario=new TablaHorario(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public List<Horario> getHorarios(Horario horario, String opcion) {
		return tablaHorario.getHorarios(horario, opcion);
	}

	@Override
	public String registrarHorario(Horario horario) {
		return tablaHorario.registrarHorario(horario);
	}

	@Override
	public String modificarHorario(Horario newhorario, Horario oldhorario) {
		return tablaHorario.modificarHorario(newhorario, oldhorario);
	}

	@Override
	public List<String> getListaHorarios() {
		return tablaHorario.getListaHorarios();
	}

}
