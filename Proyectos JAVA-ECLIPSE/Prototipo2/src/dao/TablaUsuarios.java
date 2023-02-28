package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Garantia;
import modelo.Usuario;

public class TablaUsuarios {
	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaUsuarios(Connection conexion) {
		super();
		this.conexion = conexion;
		crearSentencia();
	} 

	private  void crearSentencia() {
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			statement=null;
		}
	}

	public String getUsuario(String usuario, String contrasenia){

		String sql = "select count(*) from (select usuario_us from UsuarioSitema where usuario_us='"+usuario+
				"' && contraseña_us='"+contrasenia+"')as a";

		try {
			ResultSet rs = statement.executeQuery(sql);
			int cant = 0;
			while (rs.next()) {
				cant=Integer.parseInt(rs.getString(1));
			}
			
			String salida = "";
			if(cant==1) {
				salida = "Acceso valido";
			}else if(cant==0) {
				salida = "Usuario o contraseña invalidos";
			}
			
			return salida;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
