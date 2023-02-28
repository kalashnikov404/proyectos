package dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import modelo.Boleto;
import modelo.Colonia;
import modelo.Contrato;
import modelo.Pelicula;
import modelo.Persona;
import modelo.Proveedor;
import modelo.ProveedorSucursal;
import modelo.Resurtido;
import modelo.Sucursal;
import utilidades.Origen;
import vista.PanelesBoletos.PanelBoletosRegistrar;
import vista.PanelesResurtir.PanelResurtidosRegistrar;
import vista.panelesContratar.PanelRegistrarContratar;
import vista.panelesPeliculas.PanelPeliculasConsultar2;
import vista.panelesPeliculas.PanelPeliculasModificar;
import vista.panelesPeliculas.PanelPeliculasRegistar;
import vista.panelesProveedores.PanelRegistrarProveedores;

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
	public void modificarPelicula() {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO, Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablaPelicula tablaPelicula = new TablaPelicula(db.getConexion());
			if (!tablaPelicula.existe(PanelPeliculasModificar.getCajaClave().getText())) {
				
			
			JOptionPane.showMessageDialog(null, "esa pelicula no existe","Error",JOptionPane.ERROR_MESSAGE);
				
			}else {
                Pelicula pelicula = new Pelicula();
				
				pelicula.setClave( Integer.parseInt( PanelPeliculasModificar.getCajaClave().getText()));
				pelicula.setNombre(PanelPeliculasModificar.getCajaNombre().getText());
				pelicula.setGenero((String) PanelPeliculasModificar.getComboGenero().getSelectedItem());
				pelicula.setDuracion(Integer.parseInt(PanelPeliculasModificar.getCajaDuracion().getText()));
				pelicula.setClasificacion(PanelPeliculasModificar.getCajaClasificacion().getText());
				
				
				JOptionPane.showMessageDialog(null,tablaPelicula.modificar(pelicula));

			}

		} else {
			JOptionPane.showMessageDialog(null,"error al hacer conexion con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
	public static DefaultListModel<Pelicula> modelo()  {
		DefaultListModel<Pelicula> model= new DefaultListModel<>();
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablaPelicula tablaPelicula = new TablaPelicula(db.getConexion());
			
			List<Pelicula> peliculas = tablaPelicula.getPeliculas();
			
				
			for (Pelicula pelicula : peliculas) {
				
				model.addElement(pelicula);
				
			}
		
		

		} else {
			System.out.println("error al hacer conexion con la base de datos");
		}
		return model;


	}
	public void guardarBoleto() throws SQLException {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO, Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
		

			
			
			Boleto boleto = new Boleto();
				

		        Connection con;
		        CallableStatement ca, cb, cc, cd;
		    
		            con = DriverManager.getConnection("jdbc:mysql://92.249.45.104:3306/mendt672_cinepolis?noAccessToProcedureBodies=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "mendt672_alumno", "c(.#1UK44VOP");
		            
		            con.setAutoCommit(false);

		            ca = con.prepareCall("{call sp_llenaboletosUno(?,?,?,?)}");
		            cb = con.prepareCall("{call sp_llenaboletosDos(?,?)}");

//		            jdbc:mysql://ipaddress:3306/test?noAccessToProcedureBodies=true
		            
		            ca.setString(1, boleto.setPrecio((String) PanelBoletosRegistrar.getCajaPrecio().getText()));

		            ca.setString(2, boleto.setTipo((String) PanelBoletosRegistrar.getCajaTipo().getText()));
		            
		            
		            
		           
		            ca.setString(3, boleto.setCvePelicula((String) PanelBoletosRegistrar.getCajaPelicula().getText()));
		       
		           
		            ca.setString(4, boleto.setCveSala((String) PanelBoletosRegistrar.getCajaSala().getText()));
		            
		            
		            

		            cb.setLong(1,boleto.setCantidad(Integer.parseInt(PanelBoletosRegistrar.getCajaCantidad().getText())));




		            cb.setString(2, boleto.setCveEmpleado((String) PanelBoletosRegistrar.getCajaEmpleado().getText()));
		            

		            
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
		    
		            con = DriverManager.getConnection("jdbc:mysql://92.249.45.104:3306/mendt672_cinepolis?noAccessToProcedureBodies=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "mendt672_alumno", "c(.#1UK44VOP");
		            
		            con.setAutoCommit(false);

		            ca = con.prepareCall("{call sp_llenaresurtidosUno(?,?)}");
		            
		            
		            
		            cb = con.prepareCall("{call sp_llenaresurtidosDos(?,?,?,?,?)}");

		            
//boleto		             
		            
		            ca.setString(1, resurtido.setClaveProveedor((String) PanelResurtidosRegistrar.getCajaProveedor().getText()));

		            ca.setString(2, resurtido.setClaveSucursal((String) PanelResurtidosRegistrar.getCajaSucursal().getText()));
		            

		            cb.setLong(1, resurtido.setCantidad(Integer.parseInt( PanelResurtidosRegistrar.getCajaC().getText())));

		            cb.setLong(2, resurtido.setBaja(Integer.parseInt( PanelResurtidosRegistrar.getCajaC().getText())));
		            

		            cb.setLong(3, resurtido.setPrecio(Integer.parseInt( PanelResurtidosRegistrar.getCajaCantidad().getText())));


		            cb.setString(4, resurtido.setClaveBotana((String) PanelResurtidosRegistrar.getCajaBotana().getText()));


		            cb.setString(5, resurtido.setCveEmpleado((String) PanelResurtidosRegistrar.getCajaEmpleado().getText()));
		            
//
		            
		            ca.execute();
		            cb.execute();


		            
		            con.commit();

				
				JOptionPane.showMessageDialog(null, "Resurtido guardado con exito");

		

		} else {
			JOptionPane.showMessageDialog(null,"error al hacer conexion con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
		
	
	public void guardarEmpleados() {

		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablasContratar tablasContratar = new TablasContratar(db.getConexion());
 
		      int horaE=Integer.parseInt((String)PanelRegistrarContratar.getComboHorasE().getSelectedItem());
		      int minutoE=Integer.parseInt((String)PanelRegistrarContratar.getComboMinutosE().getSelectedItem());
		      int segundoE=Integer.parseInt((String)PanelRegistrarContratar.getComboSegundosE().getSelectedItem());
		      
		      int horaS=Integer.parseInt((String)PanelRegistrarContratar.getComboHorasS().getSelectedItem());
		      int minutoS=Integer.parseInt((String)PanelRegistrarContratar.getComboMinutosS().getSelectedItem());
		      int segundoS=Integer.parseInt((String)PanelRegistrarContratar.getComboSegundosS().getSelectedItem());
			
			Persona persona = new Persona();
			Contrato contrato = new Contrato();
	 
	      
				persona.setCurp(PanelRegistrarContratar.getCajaCurp().getText());
				persona.setNombre(PanelRegistrarContratar.getCajaNombre().getText());
				persona.setPaterno(PanelRegistrarContratar.getCajaPaterno().getText());
				persona.setMaterno(PanelRegistrarContratar.getCajaMaterno().getText());
				persona.setNacimiento(fecha(PanelRegistrarContratar.getCalendarioNacimiento()));
				persona.setSexo(PanelRegistrarContratar.getRadioFemenino().isSelected() ? "Femenino"
						: "Masculino");
				persona.setTelefono(PanelRegistrarContratar.getCajaTelefono().getText());
				persona.setCalle(PanelRegistrarContratar.getCajaCalle().getText());
				persona.setNumero(Integer.parseInt(PanelRegistrarContratar.getCajaNumero().getText()));
				persona.setOrientacion((String) PanelRegistrarContratar.getComboOrientacion().getSelectedItem());
				persona.setColonia(PanelRegistrarContratar.getComboColonia().getSelectedIndex());

				
				contrato.setFechaFin(fecha(PanelRegistrarContratar.getCalendarioFin()));
				contrato.setPuesto((String) PanelRegistrarContratar.getComboPuesto().getSelectedItem());
				contrato.setSueldo(Float.parseFloat(PanelRegistrarContratar.getCajaSueldo().getText()));
				contrato.setDescanso((String) PanelRegistrarContratar.getComboDiaDescanso().getSelectedItem());
				contrato.setHoraEntrada(LocalTime.of(horaE,minutoE, segundoE));
				contrato.setHoraSalida(LocalTime.of(horaS,minutoS, segundoS));
	            contrato.setSucursal(PanelRegistrarContratar.getComboSucursal().getSelectedIndex());
                 
		         
		        	JOptionPane.showMessageDialog(null, tablasContratar.guardar(persona, contrato));
		           
			
	        
		
		} else {

			JOptionPane.showMessageDialog(null, "error al hacer conexion con la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}


	public static LocalDate fecha(JDateChooser d) {
		int anio = d.getCalendar().get(Calendar.YEAR);
		int dia = d.getCalendar().get(Calendar.DAY_OF_MONTH);
		int mes = d.getCalendar().get(Calendar.MONTH) + 1;
		LocalDate ld = LocalDate.of(anio, mes, dia);
		return ld;
	}

	public void cargarComboContrato() {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			
		TablasContratar tablasContratar= new TablasContratar(db.getConexion());
		
			List<Colonia> colonias = tablasContratar.getColonias();
			List<Sucursal> sucursales= tablasContratar.getSucursales();
				
			for (Sucursal sucursal : sucursales) {
				PanelRegistrarContratar.getComboSucursal().addItem(Integer.toString(sucursal.getNumero()));
				
			}
		
	    for (Colonia colonia : colonias) {
			PanelRegistrarContratar.getComboColonia().addItem(colonia.getNombre());
		}
		} else {
			System.out.println("error al hacer conexion con la base de datos");
		}


	}
	public void guardarProveedores() {

		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablasProveedores tablasProveedores = new TablasProveedores(db.getConexion());
 
		      
			Proveedor proveedor = new Proveedor();
			ProveedorSucursal proveedorSucursal = new ProveedorSucursal();
	 
	      proveedor.setEmpresa(PanelRegistrarProveedores.getCajaEmpresa().getText());
	      proveedor.setTelefono(PanelRegistrarProveedores.getCajaTelefono().getText());
	      proveedor.setCalle(PanelRegistrarProveedores.getCajaCalle().getText());
	      proveedor.setNumero(Integer.parseInt(PanelRegistrarProveedores.getCajaNumero().getText()));
	      proveedor.setOrientacion((String)PanelRegistrarProveedores.getComboOrientacion().getSelectedItem());
	      proveedor.setColonia(PanelRegistrarProveedores.getComboColonia().getSelectedIndex());
	      
          proveedorSucursal.setSucursal(PanelRegistrarProveedores.getComboSucursal().getSelectedIndex());    
		         
		     JOptionPane.showMessageDialog(null, tablasProveedores.guardar(proveedor, proveedorSucursal));
		           
			
	        
		
		} else {

			JOptionPane.showMessageDialog(null, "error al hacer conexion con la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	public void cargarComboProveedores() {
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			
		TablasContratar tablasContratar= new TablasContratar(db.getConexion());
		
			List<Colonia> colonias = tablasContratar.getColonias();
			List<Sucursal> sucursales= tablasContratar.getSucursales();
				
			for (Sucursal sucursal : sucursales) {
				PanelRegistrarProveedores.getComboSucursal().addItem(Integer.toString(sucursal.getNumero()));
				
			}
		
	    for (Colonia colonia : colonias) {
			PanelRegistrarProveedores.getComboColonia().addItem(colonia.getNombre());
		}
		} else {
			System.out.println("error al hacer conexion con la base de datos");
		}


	}
	public String[][] obtenerMatrizPel(){
		BaseDatos db = BaseDatos.newInstance(Origen.BASEDATOS, Origen.USUARIO, Origen.PWD, Origen.PROTOCOLO,
				Origen.DRIVER);
		if (db.hacerConexion().equals("exito")) {
			TablaPelicula tablaPelicula = new TablaPelicula(db.getConexion());
		
			List<Pelicula> peliculas = tablaPelicula.getPeliculasFiltro(PanelPeliculasConsultar2.getCajaBuscar().getText());
	
			
		 
			String matrizinfor[][]= new String[peliculas.size()][100];
			for (int i = 0; i < peliculas.size(); i++) {
				   matrizinfor[i][0]=peliculas.get(i).getClave()+"";
				   matrizinfor[i][1]=peliculas.get(i).getNombre()+"";
				   matrizinfor[i][2]=peliculas.get(i).getGenero()+"";
				   matrizinfor[i][3]=peliculas.get(i).getDuracion()+"";
				   matrizinfor[i][4]=peliculas.get(i).getClasificacion()+"";
				   
				   
				  }
		
	  return matrizinfor;
		
		} else {
			System.out.println("error al hacer conexion con la base de datos");
		}
		return null;
}
}