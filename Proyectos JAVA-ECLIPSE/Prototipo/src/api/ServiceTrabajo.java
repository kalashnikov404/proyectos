package api;

import java.util.List;

import modelo.Trabajo;

public interface ServiceTrabajo {
	
	public String registrarTrabajo(Trabajo trabajo);
	public List<String> getListaTipos();
	public List<String> getListaTrabajosConTransporte();
	public List<String> getListaTrabajosSinTransporte();
	public String modificarTrabajo(Trabajo newtrabajo, Trabajo oldtrabajo);
	public String getEmpleadoCB(String rfc);
	public String getTransporteCB(String placas);
	public List<Trabajo> getTrabajo(Trabajo trabajo, String opcion);

}
