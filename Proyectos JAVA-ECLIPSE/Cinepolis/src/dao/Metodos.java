package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Boleto;
import modelo.Pelicula;
import modelo.Resurtido;
import utilidades.Origen;
import vista.panelesPeliculas.PanelBoletosRegistrar;
import vista.panelesPeliculas.PanelPeliculasRegistar;
import vista.panelesPeliculas.PanelResurtidosRegistrar;

public class Metodos {
	
	public void guardarPelicula() {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO, Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablaPelicula tablaPelicula = new TablaPelicula(db.getConexion());
			
			
				Pelicula pelicula = new Pelicula();
				
				pelicula.setNombre(PanelPeliculasRegistar.getCajaNombre().getText());
				pelicula.setGenero((String) PanelPeliculasRegistar.getComboGenero().getSelectedItem());
				pelicula.setDuracion(Integer.parseInt(PanelPeliculasRegistar.getCajaDuracion().getText()));
				pelicula.setClasificacion(PanelPeliculasRegistar.getCajaClasificacion().getText());
				
				JOptionPane.showMessageDialog(null,tablaPelicula.guardar(pelicula));

		

		} else {
			JOptionPane.showMessageDialog(null,"error al hacer conexion con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
	

	
	
	
	

	public void guardarBoleto() throws SQLException {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO, Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
		

			
			
			Boleto boleto = new Boleto();
				

		        Connection con;
		        CallableStatement ca, cb, cc, cd;
		    
		            con = DriverManager.getConnection("jdbc:mysql://92.249.45.104:3306/mendt672_cinepolis", "mendt672_alumno", "c(.#1UK44VOP");
		            
		            con.setAutoCommit(false);

		            ca = con.prepareCall("{call sp_llenaboletos(?,?,?,?)}");
		            cb = con.prepareCall("{call sp_llenaboletos6(?,?)}");

		            

//		            
//		            cb = con.prepareCall("{ call sp_crearOrdenDos(?,?,?,?,?)}");
//		            cc = con.prepareCall("{ call sp_crearOrdenTres(?,?,?)}");
//		            
//		            cd = con.prepareCall("{ call sp_crearOrdenCuatro(?,?,?)}");
//
////		            
//		            ca.setInt(1, Integer.parseInt((textClave.getText())));
//		            ca.setInt(2, Integer.parseInt((textMesaContrato.getText())));
//		            ca.setInt(3, Integer.parseInt((textClaveCafecito.getText())));
		            
//boleto		            
		            
		            ca.setString(1, boleto.setPrecio((String) PanelBoletosRegistrar.getComboNombre().getSelectedItem()));

		            ca.setString(2, boleto.setTipo((String) PanelBoletosRegistrar.getComboGenero().getSelectedItem()));
		            
		            
		            
		           
		            ca.setString(3, boleto.setCvePelicula((String) PanelBoletosRegistrar.getCajaPelicula().getText()));
		       
		           
		            ca.setString(4, boleto.setCveSala((String) PanelBoletosRegistrar.getCajaSala().getText()));
		            
		            
		            

		            cb.setLong(1,boleto.setCantidad(Integer.parseInt(PanelBoletosRegistrar.getCajaCantidad().getText())));




		            cb.setString(2, boleto.setCveEmpleado((String) PanelBoletosRegistrar.getCajaEmpleado().getText()));
		            
//		            
//
//delimiter //
//create procedure sp_llenaboletos2(in  clave int, cantidad int, nEmpleado int)
//begin
//insert into detalleboleto values(null,  cantidad, @x, nEmpleado);
//SET @x:= LAST_INSERT_ID();
//end;//

		            
		            
		        
//		            ca.setString(2, boleto.setCveSala((String) PanelBoletosRegistrar.getComboSala().getSelectedItem()));
//
//					pelicula.setDuracion(Integer.parseInt(PanelPeliculasRegistar.getCajaDuracion().getText()));
//
//		            
//		            ca.setString(2, boleto.setCveSala((String) PanelBoletosRegistrar.getComboSala().getSelectedItem()));
//
//		            
//		            
//		            
//		            
//		        	pelicula.setNombre(PanelPeliculasRegistar.getCajaNombre().getText());
//					pelicula.setGenero((String) PanelPeliculasRegistar.getComboGenero().getSelectedItem());
//					pelicula.setDuracion(Integer.parseInt(PanelPeliculasRegistar.getCajaDuracion().getText()));
//					pelicula.setClasificacion(PanelPeliculasRegistar.getCajaClasificacion().getText());
		            
//		            
//		            
//
//mysql> describe boleto;
//+------------+-------------+------+-----+---------+----------------+
//| Field      | Type        | Null | Key | Default | Extra          |
//+------------+-------------+------+-----+---------+----------------+
//| cve_bol    | int         | NO   | PRI | NULL    | auto_increment |
//| fecha_bol  | date        | NO   |     | NULL    |                |
//| precio_bol | float(6,2)  | NO   |     | NULL    |                |
//| tipo_bol   | varchar(30) | NO   |     | NULL    |                |
//| cve_pel    | int         | NO   | MUL | NULL    |                |
//| cve_sal    | int         | NO   | MUL | NULL    |                |
//+------------+-------------+------+-----+---------+----------------+
//6 rows in set (0.00 sec)
////		            
//		            mysql> delimiter //
//		            mysql> create procedure sp_llenaboleto(in precio int, tipo varchar(30), claveP int, claveS int)
//		                -> begin
//		                -> insert into boleto values(null, now(),  precio, tipo, claveP, claveS);
//		                -> end;//
//		            Query OK, 0 rows affected (0.06 sec)

		            
		            ca.execute();
		            cb.execute();


		            
		            con.commit();


				
				
				JOptionPane.showMessageDialog(null, "Boleto guardado con exito");

		

		} else {
			JOptionPane.showMessageDialog(null,"error al hacer conexion con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
		

	

	

	public void guardarResurtido() throws SQLException {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO, Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
		

			
			
			Resurtido resurtido = new Resurtido();
				

		        Connection con;
		        CallableStatement ca, cb, cc, cd;
		    
		            con = DriverManager.getConnection("jdbc:mysql://92.249.45.104:3306/mendt672_cinepolis", "mendt672_alumno", "c(.#1UK44VOP");
		            
		            con.setAutoCommit(false);

		            ca = con.prepareCall("{call sp_llenaresurtidos(?,?)}");
		            cb = con.prepareCall("{call sp_llenaresurtidos7(?,?,?,?,?)}");

		            

//		            
//		            cb = con.prepareCall("{ call sp_crearOrdenDos(?,?,?,?,?)}");
//		            cc = con.prepareCall("{ call sp_crearOrdenTres(?,?,?)}");
//		            
//		            cd = con.prepareCall("{ call sp_crearOrdenCuatro(?,?,?)}");
//
////		            
//		            ca.setInt(1, Integer.parseInt((textClave.getText())));
//		            ca.setInt(2, Integer.parseInt((textMesaContrato.getText())));
//		            ca.setInt(3, Integer.parseInt((textClaveCafecito.getText())));
		            
//boleto		            
		            
		            ca.setString(1, resurtido.setClaveProveedor((String) PanelResurtidosRegistrar.getCajaProveedor().getText()));

		            ca.setString(2, resurtido.setClaveSucursal((String) PanelResurtidosRegistrar.getCajaSucursal().getText()));
		            
		            
		            
		      
		            
		            //cb.setLong(1,boleto.setCantidad(Integer.parseInt(PanelBoletosRegistrar.getCajaCantidad().getText())));


		            cb.setLong(1, resurtido.setCantidad(Integer.parseInt( PanelResurtidosRegistrar.getCajaC().getText())));

		            cb.setLong(2, resurtido.setBaja(Integer.parseInt( PanelResurtidosRegistrar.getCajaPrecio().getText())));
		            

		            cb.setLong(3, resurtido.setPrecio(Integer.parseInt( PanelResurtidosRegistrar.getCajaCantidad().getText())));


		            cb.setString(4, resurtido.setClaveBotana((String) PanelResurtidosRegistrar.getCajaBotana().getText()));


		            cb.setString(5, resurtido.setCveEmpleado((String) PanelResurtidosRegistrar.getCajaEmpleado().getText()));
		            
//
		            
		            ca.execute();
		            cb.execute();


		            
		            con.commit();

		            
		            
//
//delimiter //
//create procedure sp_llenaresurtidos(in cveProveedor int, claveSucursal int)
//begin
//insert into resurtir values(null, now(),  cveProveedor, claveSucursal);
//end;//


		            
		            
		        
//		            ca.setString(2, boleto.setCveSala((String) PanelBoletosRegistrar.getComboSala().getSelectedItem()));
//
//					pelicula.setDuracion(Integer.parseInt(PanelPeliculasRegistar.getCajaDuracion().getText()));
//
//		            
//		            ca.setString(2, boleto.setCveSala((String) PanelBoletosRegistrar.getComboSala().getSelectedItem()));
//
//		            
//		            
//		            
//		            
//		        	pelicula.setNombre(PanelPeliculasRegistar.getCajaNombre().getText());
//					pelicula.setGenero((String) PanelPeliculasRegistar.getComboGenero().getSelectedItem());
//					pelicula.setDuracion(Integer.parseInt(PanelPeliculasRegistar.getCajaDuracion().getText()));
//					pelicula.setClasificacion(PanelPeliculasRegistar.getCajaClasificacion().getText());
		            
//		            
//		            
//
//mysql> describe boleto;
//+------------+-------------+------+-----+---------+----------------+
//| Field      | Type        | Null | Key | Default | Extra          |
//+------------+-------------+------+-----+---------+----------------+
//| cve_bol    | int         | NO   | PRI | NULL    | auto_increment |
//| fecha_bol  | date        | NO   |     | NULL    |                |
//| precio_bol | float(6,2)  | NO   |     | NULL    |                |
//| tipo_bol   | varchar(30) | NO   |     | NULL    |                |
//| cve_pel    | int         | NO   | MUL | NULL    |                |
//| cve_sal    | int         | NO   | MUL | NULL    |                |
//+------------+-------------+------+-----+---------+----------------+
//6 rows in set (0.00 sec)
////		            
//		            mysql> delimiter //
//		            mysql> create procedure sp_llenaboleto(in precio int, tipo varchar(30), claveP int, claveS int)
//		                -> begin
//		                -> insert into boleto values(null, now(),  precio, tipo, claveP, claveS);
//		                -> end;//
//		            Query OK, 0 rows affected (0.06 sec)

		        

				
				
				JOptionPane.showMessageDialog(null, "Resurtido guardado con exito");

		

		} else {
			JOptionPane.showMessageDialog(null,"error al hacer conexion con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
		
	
	

}
