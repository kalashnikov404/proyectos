package servicios;

import java.util.List;

import api.ServiceCompra;
import dao.FuenteDatos;
import dao.TablaCompra;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Proveedor;

public class ServiceCompraImpl implements ServiceCompra {
	
	private TablaCompra tablaCompra;
	
	public ServiceCompraImpl()throws ConexionException  {
		tablaCompra=new TablaCompra(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarCompra(Compra compra) {
		return tablaCompra.registrarCompra(compra);
	}

	@Override
	public List<String> getListaProveedor() {
		return tablaCompra.getListaProveedor();
	}

	@Override
	public String registrarDetalleCompra(DetalleCompra dcompra) {
		return tablaCompra.registrarDetalleCompra(dcompra);
	}

	@Override
	public String modificarTotalCompra() {
		return tablaCompra.modificarTotalCompra();
	}

	@Override
	public List<DetalleCompra> getDetalleCompra(DetalleCompra dcompra, String opcion) {
		return tablaCompra.getDetalleCompra(dcompra, opcion);
	}

	@Override
	public List<DetalleCompra> getAgregarTabla(DetalleCompra dcompra, String opcion) {
		return tablaCompra.getAgregarTabla(dcompra, opcion);
	}

	@Override
	public List<String> getListaCompra() {
		return tablaCompra.getListaCompra();
	}



	@Override
	public List<DetalleCompra> getListaModificarDetalle(DetalleCompra dcompra, String opcion) {
		return tablaCompra.getListaModificarDetalle(dcompra, opcion);
	}

	@Override
	public String modificarDetalleCompra(DetalleCompra newcompra, DetalleCompra oldcompra) {
		return tablaCompra.modificarDetalleCompra(newcompra, oldcompra);
	}


	@Override
	public int getCveProveedor(String provee) {
		return tablaCompra.getCveProveedor(provee);
	}

	@Override
	public int getCveCalentador(String calen) {
		return tablaCompra.getCveCalentador(calen);
	}

	@Override
	public String modificarCompra(float total,String cve) {
		return tablaCompra.modificarCompra(total, cve);
	}

	@Override
	public float getTotal(int cveCompra) {
		return tablaCompra.getTotal(cveCompra);
	}

	@Override
	public List<Calentador> getTablaCalentadores(int cveDC) {
		return tablaCompra.getTablaCalentadores(cveDC);
	}

	@Override
	public List<String> getDC(DetalleCompra dcompra, String opcion) {
		return tablaCompra.getDC(dcompra, opcion);
	}

	@Override
	public List<String> getListaMD(DetalleCompra dcompra, String opcion) {
		return tablaCompra.getListaMD(dcompra, opcion);
	}

	@Override
	public List<String> getInventario() {
		return tablaCompra.getInventario();
	}






}
