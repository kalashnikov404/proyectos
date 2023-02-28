package api;

import java.util.List;

import modelo.Horario;

public interface ServiceHorario {

	List<Horario> getHorarios(Horario horario, String opcion);
	String registrarHorario(Horario horario);
	public String modificarHorario(Horario newHorario, Horario oldHorario);
	public List<String> getListaHorarios();

}
