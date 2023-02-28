package api;

import java.util.List;

import modelo.Garantia;
import modelo.Venta;

public interface ServiceGarantia {
	
	public List<String> getListaGarantias();
	public List<Garantia> getGarantia(Garantia garantia, String opcion);
	public String modificarGarantia(Venta oldVenta, Venta newVenta, Garantia garantia);

}
