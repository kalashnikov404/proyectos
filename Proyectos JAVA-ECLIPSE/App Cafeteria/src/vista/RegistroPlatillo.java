package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Platillo;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceLugarImpl;
import servicios.ServicePlatilloImpl;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JFormattedTextField;
public class RegistroPlatillo extends JPanel {
	private JTextField textNombre;
	private JTextField textTipo;
	private JTextField textDescripcion;
	private JTextField textClavePlatillo;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	ServiceLugarImpl serviceLugarImpl= new ServiceLugarImpl();
	private JTextField textPorcion;
	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();
	ServicePlatilloImpl servicePlatilloImpl= new ServicePlatilloImpl();
	private JTextField textFecha;
	private JTextField textTiempo;
	private JTextField textUmedida;
	private JTextField textCosto;
	private JTextField textClaveProducto;
	private JTextField textIngredientePlatillo;
	private JTextField textCantidad;
	private JTextField textClaveCafecito;




	public RegistroPlatillo() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(176, 143, 304, 37);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(0, 136, 166, 42);
		labelNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelNombre);
		
		textTipo = new JTextField();
		textTipo.setBounds(176, 196, 304, 37);
		add(textTipo);
		textTipo.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(176, 249, 304, 37);
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel labelTipo = new JLabel("Tipo");
		labelTipo.setBounds(0, 189, 166, 42);
		labelTipo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelTipo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipo.setForeground(Color.BLACK);
		add(labelTipo);
		
		JLabel labelDescripcion = new JLabel("Descripcion");
		labelDescripcion.setBounds(0, 242, 166, 42);
		labelDescripcion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		labelDescripcion.setForeground(Color.BLACK);
		add(labelDescripcion);
		
		
		JLabel labelClavePlatillo = new JLabel("Clave Platillo ");
		labelClavePlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelClavePlatillo.setForeground(Color.BLACK);
		labelClavePlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClavePlatillo.setBounds(10, 84, 166, 42);
		add(labelClavePlatillo);
		
		textClavePlatillo = new JTextField();
		textClavePlatillo.setColumns(10);
		textClavePlatillo.setBounds(176, 91, 304, 37);
		add(textClavePlatillo);
		
		
		
			
		
			
		{	
		};
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos del platillo e insumos requeridos ");
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);
        
		
		JLabel labelTiempo = new JLabel("Tiempo");
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setForeground(Color.BLACK);
		labelTiempo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelTiempo.setBounds(0, 295, 166, 42);
		add(labelTiempo);
		
		JLabel labelPorcion = new JLabel("Porcion ");
		labelPorcion.setHorizontalAlignment(SwingConstants.CENTER);
		labelPorcion.setForeground(Color.BLACK);
		labelPorcion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPorcion.setBounds(0, 343, 166, 42);
		add(labelPorcion);
     
		
		textPorcion = new JTextField();
		textPorcion.setColumns(10);
		textPorcion.setBounds(176, 350, 304, 37);
		add(textPorcion);
		
		JButton botonRegistrarEstancia = new JButton("Registrar el platillo");
		botonRegistrarEstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Platillo platillo = new Platillo();
				
////						private int clavePlatillo;
//					private String nombre;
//					private String tipo;
//					private String descripcion;
//					private String tiempo;
//					private int porcion;
//					
//					//Tabla ingrediente platillo
//					private int numeroIngredientePlatillo;
//					private float cantidad;
//					private String umedida;
//					private int claveProducto;
//					private int clavePlatillo2;
//					
//					//Tabla Costo
//					private int numeroCosto;
//					private float costo;
//					private int numeroIngredientePlatillo2;
//					
//					//tabla platillo cafecito
//					
//					private int numeroPlatilloCafecito;
//					private String fechaPlatilloCafecito;
//					private int claveCafecito;
//					private int clavePlatillo3;
					//platillo
					platillo.setClavePlatillo(Integer.parseInt((textClavePlatillo.getText())));//	
					platillo.setNombre(textNombre.getText());
					platillo.setTipo(textTipo.getText());
					platillo.setDescripcion(textDescripcion.getText());
					platillo.setTiempo(textTiempo.getText());
					platillo.setPorcion(Integer.parseInt((textPorcion.getText())));//	
					
					
					//platillo cafecito
					platillo.setNumeroPlatilloCafecito(Integer.parseInt((textClaveCafecito.getText())));//	
					platillo.setFechaPlatilloCafecito(textFecha.getText());//	
					platillo.setClaveCafecito(Integer.parseInt((textClaveCafecito.getText())));//	
					platillo.setClavePlatillo3(Integer.parseInt((textClavePlatillo.getText())));//	
					
					//
//					//ingrediente platillo
//					platillo.setNumeroIngredientePlatillo(Integer.parseInt((textIngredientePlatillo.getText())));//	
//					platillo.setCantidad(Integer.parseInt((textCantidad.getText())));//	
//					platillo.setUmedida(textUmedida.getText());//	
//					platillo.setClaveProducto(Integer.parseInt((textClaveProducto.getText())));//	
//					platillo.setClavePlatillo2(Integer.parseInt((textClavePlatillo.getText())));//	

					//costo
					platillo.setNumeroCosto(Integer.parseInt((textClavePlatillo.getText())));//	
					platillo.setCosto(Integer.parseInt((textCosto.getText())));//	
					platillo.setNumeroIngredientePlatillo2(Integer.parseInt((textClavePlatillo.getText())));//	
					
				


					servicePlatilloImpl.guardarPlatillo(platillo);
					servicePlatilloImpl.guardarPlatilloCafecito(platillo);
					servicePlatilloImpl.guardarPlatilloCosto(platillo);

					
//					lugar.setCapacidad(Integer.parseInt((textNombre.getText())));
//					
//					lugar.setNumeroMesa(Integer.parseInt((textTipo.getText())));
//					lugar.setUbicacion(textDescripcion.getText());
//					lugar.setClaveMesa2(Integer.parseInt((textClavePlatillo.getText())));
//					lugar.setClaveCafecito(Integer.parseInt((textPorcion.getText())));
//
//					lugar.setMesaContrato(Integer.parseInt((textClavePlatillo.getText())));
//					lugar.setFecha(textFecha.getText());
//					lugar.setFolio(Integer.parseInt((textFolio.getText())));
//					lugar.setClaveMesa3(Integer.parseInt((textClavePlatillo.getText())));
//
//					serviceLugarImpl.guardarLugar(lugar);
//					serviceLugarImpl.guardarLugarEmpleado(lugar);
//					serviceLugarImpl.guardarLugarCafecito(lugar);
//			


					
					
					
					
					
////					
				} catch (Exception e2) {
//	//
						JOptionPane.showInternalMessageDialog(null, "No se pudo registrar, verifique e intentelo de nuevo");
////						
//	//
						
////					
					}
//
					JOptionPane.showInternalMessageDialog(null, "Platillo registrada con exito");
			}
//				
//				
				
			
		});
		botonRegistrarEstancia.setForeground(Color.BLUE);
		botonRegistrarEstancia.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		botonRegistrarEstancia.setBounds(534, 558, 304, 37);
		add(botonRegistrarEstancia);
		
		JLabel labelFecha = new JLabel("Fecha");
		labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFecha.setBounds(0, 449, 166, 42);
		add(labelFecha);
		
		JLabel labelCosto = new JLabel("Costo");
		labelCosto.setHorizontalAlignment(SwingConstants.CENTER);
		labelCosto.setForeground(Color.BLACK);
		labelCosto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCosto.setBounds(0, 396, 166, 42);
		add(labelCosto);
		
		
		textUmedida = new JTextField();

		textUmedida.setColumns(10);
		textUmedida.setBounds(690, 196, 304, 37);
		add(textUmedida);
		
		textClaveProducto = new JTextField();
		textClaveProducto.setColumns(10);
		textClaveProducto.setBounds(690, 300, 304, 37);
		add(textClaveProducto);
		
		textCosto = new JTextField();

		textCosto.setColumns(10);
		textCosto.setBounds(176, 403, 304, 37);
		add(textCosto);
		
		textTiempo = new JFormattedTextField("HH:MM:SS");

//		HH:MM:SS
		textTiempo.setFont(new Font("Dialog", Font.PLAIN, 20));
		textTiempo.setColumns(10);
		textTiempo.setBounds(176, 300, 304, 37);
		add(textTiempo);
		
		
		textFecha = new JFormattedTextField("YYYY-MM-DD");
		textFecha.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		textFecha.setColumns(10);
		textFecha.setBounds(176, 452, 304, 37);
		add(textFecha);
		
		JLabel labelIngredientePlatillo = new JLabel("N. IngPla");
		labelIngredientePlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelIngredientePlatillo.setForeground(Color.BLACK);
		labelIngredientePlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelIngredientePlatillo.setBounds(508, 84, 166, 42);
		add(labelIngredientePlatillo);
		
		textIngredientePlatillo = new JTextField();
		textIngredientePlatillo.setColumns(10);
		textIngredientePlatillo.setBounds(690, 91, 304, 37);
		add(textIngredientePlatillo);
		
		JLabel labelCantidad = new JLabel("Cantidad");
		labelCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		labelCantidad.setForeground(Color.BLACK);
		labelCantidad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCantidad.setBounds(518, 136, 166, 42);
		add(labelCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(690, 143, 304, 37);
		add(textCantidad);
		
		JLabel labelUmedida = new JLabel("U.Medida");
		labelUmedida.setHorizontalAlignment(SwingConstants.CENTER);
		labelUmedida.setForeground(Color.BLACK);
		labelUmedida.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelUmedida.setBounds(508, 189, 166, 42);
		add(labelUmedida);
		
		JLabel labelProducto = new JLabel("Producto");
		labelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProducto.setForeground(Color.BLACK);
		labelProducto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelProducto.setBounds(490, 242, 117, 42);
		add(labelProducto);
		
		JComboBox comboBoxProducto = new JComboBox();
		comboBoxProducto.setBounds(604, 249, 686, 37);
		  ArrayList<String> lista3 = new ArrayList<String>();
	        lista3 = servicePlatilloImpl.llenar_comboInsumo();
	        for(int i = 0; i<lista3.size();i++){
	        	comboBoxProducto.addItem(lista3.get(i));
	        }
		
		add(comboBoxProducto);
		
		JLabel labelClaveProducto = new JLabel("Clave Producto");
		labelClaveProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveProducto.setForeground(Color.BLACK);
		labelClaveProducto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveProducto.setBounds(508, 295, 166, 42);
		add(labelClaveProducto);
		
		JLabel labelCafecito = new JLabel("Cafecito ");
		labelCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito.setForeground(Color.BLACK);
		labelCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito.setBounds(10, 502, 166, 42);
		add(labelCafecito);
		
		JComboBox comboBoxCafecito = new JComboBox();
		comboBoxCafecito.setBounds(176, 509, 818, 37);
		   ArrayList<String> lista2 = new ArrayList<String>();
	        lista2 = serviceEmpleadoImpl.llenar_comboCafecito();
	        for(int i = 0; i<lista2.size();i++){
	        	comboBoxCafecito.addItem(lista2.get(i));
	        }
		add(comboBoxCafecito);
		
		
		
		
		JLabel labelClaveCafecito = new JLabel("Clave Cafecito");
		labelClaveCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveCafecito.setForeground(Color.BLACK);
		labelClaveCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveCafecito.setBounds(10, 555, 166, 42);
		add(labelClaveCafecito);
		
		textClaveCafecito = new JTextField();
		textClaveCafecito.setColumns(10);
		textClaveCafecito.setBounds(176, 557, 304, 37);
		add(textClaveCafecito);
		
		JButton botonAgregarInsumos = new JButton("Agregar insumos");
		botonAgregarInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
	try {
					
					Platillo platillo = new Platillo();
				
////						private int clavePlatillo;
//					private String nombre;
//					private String tipo;
//					private String descripcion;
//					private String tiempo;
//					private int porcion;
//					
//					//Tabla ingrediente platillo
//					private int numeroIngredientePlatillo;
//					private float cantidad;
//					private String umedida;
//					private int claveProducto;
//					private int clavePlatillo2;
//					
//					//Tabla Costo
//					private int numeroCosto;
//					private float costo;
//					private int numeroIngredientePlatillo2;
//					
//					//tabla platillo cafecito
//					
//					private int numeroPlatilloCafecito;
//					private String fechaPlatilloCafecito;
//					private int claveCafecito;
//					private int clavePlatillo3;
					
					//
					//ingrediente platillo
					platillo.setNumeroIngredientePlatillo(Integer.parseInt((textIngredientePlatillo.getText())));//	
					platillo.setCantidad(Integer.parseInt((textCantidad.getText())));//	
					platillo.setUmedida(textUmedida.getText());//	
					platillo.setClaveProducto(Integer.parseInt((textClaveProducto.getText())));//	
					platillo.setClavePlatillo2(Integer.parseInt((textClavePlatillo.getText())));//	

			


					servicePlatilloImpl.guardarPlatilloIngrediente(platillo);
					
					
//					lugar.setCapacidad(Integer.parseInt((textNombre.getText())));
//					
//					lugar.setNumeroMesa(Integer.parseInt((textTipo.getText())));
//					lugar.setUbicacion(textDescripcion.getText());
//					lugar.setClaveMesa2(Integer.parseInt((textClavePlatillo.getText())));
//					lugar.setClaveCafecito(Integer.parseInt((textPorcion.getText())));
//
//					lugar.setMesaContrato(Integer.parseInt((textClavePlatillo.getText())));
//					lugar.setFecha(textFecha.getText());
//					lugar.setFolio(Integer.parseInt((textFolio.getText())));
//					lugar.setClaveMesa3(Integer.parseInt((textClavePlatillo.getText())));
//
//					serviceLugarImpl.guardarLugar(lugar);
//					serviceLugarImpl.guardarLugarEmpleado(lugar);
//					serviceLugarImpl.guardarLugarCafecito(lugar);
//			


					
					
					
					
					
//					
				} catch (Exception e2) {
	//
						JOptionPane.showInternalMessageDialog(null, "No se pudo agregar, verifique e intentelo de nuevo");
//						
	//
//					
					}

					JOptionPane.showInternalMessageDialog(null, "Insumos agregados con exito");
			
				
				
			
			
			
			}
		});
		botonAgregarInsumos.setForeground(Color.BLUE);
		botonAgregarInsumos.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		botonAgregarInsumos.setBounds(690, 372, 304, 37);
		add(botonAgregarInsumos);
		
//		
        
       
        
        
//		JLabel fondo = new JLabel("");
//		fondo.setBounds(0, 0, 1300, 795);
//		add(fondo);		
//		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
//		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
//		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));
//
//		fondo.setIcon(img22);

		

	}
}
	
