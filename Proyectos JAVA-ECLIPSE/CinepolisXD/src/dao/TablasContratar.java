package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Colonia;
import modelo.Contrato;
import modelo.Persona;
import modelo.Sucursal;

public class TablasContratar {
	
	private Connection conexion;
	private Statement  statement;
	
     
	public TablasContratar(Connection conexion) {
		this.conexion = conexion;
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String guardar(Persona persona, Contrato contrato) {
		
		String sql = "call llenaPersona('"+
	            persona.getCurp()+"','"+
				persona.getNombre()+"','"+
				persona.getPaterno()+"','"+
				persona.getMaterno()+"','"+
				persona.getNacimiento()+"','"+
				persona.getSexo()+"','"+
				persona.getTelefono()+"','"+
				persona.getCalle()+"','"+
				persona.getNumero()+"','"+
				persona.getOrientacion()+"','"+
				persona.getColonia()+"')";

		String sql2 = "call llenaEmpleado('"+
	          
				contrato.getFechaFin()+"','"+
				contrato.getPuesto()+"','"+
				contrato.getSueldo()+"','"+
				contrato.getDescanso()+"','"+
				contrato.getHoraEntrada()+"','"+
				contrato.getHoraSalida()+"','"+
				contrato.getSucursal()+"')";
				
				
		
		try {
			conexion.setAutoCommit(false);
		
			
			statement.executeUpdate(sql);
			statement.executeUpdate(sql2);
			
			return " Empleado registrado con exito";
		} catch (SQLException e) {
			
			return e.toString();
		}

}
	
	public List<Colonia> getColonias(){
		String sql="select  nom_col from colonia order by nom_col asc";
		try {
			ResultSet rs =statement.executeQuery(sql);
			List<Colonia> colonias=new ArrayList<>();
			while (rs.next()) {
				Colonia colonia= new Colonia();
				
				colonia.setNombre(rs.getString("nom_col"));
				colonias.add(colonia);
			}
				return colonias;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}
	public List<Sucursal> getSucursales(){
		String sql="select numero_suc from sucursal order by cve_suc asc";
		try {
			ResultSet rs =statement.executeQuery(sql);
			List<Sucursal> cines=new ArrayList<>();
			while (rs.next()) {
					Sucursal sucursal = new Sucursal();
		sucursal.setNumero(Integer.parseInt(rs.getString("numero_suc")));
		
				
			cines.add(sucursal);
			}
				return cines;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
		
	}
}