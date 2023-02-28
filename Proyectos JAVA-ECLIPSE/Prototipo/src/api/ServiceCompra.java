package api;

import java.util.List;

import modelo.Calentador;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Proveedor;

public interface ServiceCompra {

	String registrarCompra(Compra compra);
	List<String> getListaProveedor();
	String registrarDetalleCompra(DetalleCompra dcompra);
	List<DetalleCompra> getDetalleCompra(DetalleCompra dcompra, String opcion);
	List<DetalleCompra> getAgregarTabla(DetalleCompra dcompra, String opcion);
	
	List<DetalleCompra> getListaModificarDetalle(DetalleCompra dcompra, String opcion);
	List<String> getListaCompra();
	
	String modificarTotalCompra();
	String modificarDetalleCompra(DetalleCompra newcompra,DetalleCompra oldcompra);
	String modificarCompra(float total,String cve);
	 float getTotal(int cveCompra);
	
 int getCveProveedor(String provee);
 int getCveCalentador(String calen);
 List<Calentador> getTablaCalentadores(int cveDC);
 
 
 List<String> getDC(DetalleCompra dcompra, String opcion);
 List<String> getListaMD(DetalleCompra dcompra, String opcion);
 List<String> getInventario();
}
