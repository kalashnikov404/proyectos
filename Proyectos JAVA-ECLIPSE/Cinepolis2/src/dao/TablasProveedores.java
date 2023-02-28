package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Contrato;
import modelo.Persona;
import modelo.Proveedor;
import modelo.ProveedorSucursal;

public class TablasProveedores {

	private Connection conexion;
	private Statement  statement;
	
     
	public TablasProveedores(Connection conexion) {
		this.conexion = conexion;
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String guardar(Proveedor proveedor, ProveedorSucursal proveedorSucursal) {
		
		String sql = "call llenaproveedor('"+
	            proveedor.getEmpresa()+"','"+
				proveedor.getTelefono()+"','"+
				proveedor.getCalle()+"','"+
				proveedor.getNumero()+"','"+
				proveedor.getOrientacion()+"','"+
			    proveedor.getColonia()+"')";

		String sql2 = "call llenaproveedorcine('"+
	          
				
				proveedorSucursal.getSucursal()+"')";
				
				
		
		try {
			conexion.setAutoCommit(false);
		
			
			statement.executeUpdate(sql);
			statement.executeUpdate(sql2);
			
			return " Proveedor registrado con exito";
		} catch (SQLException e) {
			
			return e.toString();
		}

}
	
	
}
