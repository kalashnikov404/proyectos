package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
import modelo.Empleado;
import modelo.Lugar;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceLugarImpl;

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
public class RegistroLugar extends JPanel {
	private JTextField textCapacidad;
	private JTextField textNumero;
	private JTextField textUbicacion;
	private JTextField textClaveMesa;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	ServiceLugarImpl serviceLugarImpl= new ServiceLugarImpl();
	private JFormattedTextField textFecha;
	private JTextField textClaveCafecito;
	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();
	private JTextField textFolio;


	public RegistroLugar() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(176, 143, 304, 37);
		add(textCapacidad);
		textCapacidad.setColumns(10);
		
		JLabel labelCapacidad = new JLabel("Capacidad ");
		labelCapacidad.setBounds(0, 136, 166, 42);
		labelCapacidad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCapacidad.setForeground(Color.BLACK);
		labelCapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelCapacidad);
		
		textNumero = new JTextField();
		textNumero.setBounds(176, 196, 304, 37);
		add(textNumero);
		textNumero.setColumns(10);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(176, 249, 304, 37);
		add(textUbicacion);
		textUbicacion.setColumns(10);
		
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(0, 189, 166, 42);
		labelNumero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumero.setForeground(Color.BLACK);
		add(labelNumero);
		
		JLabel labelUbicacion = new JLabel("Ubicacion");
		labelUbicacion.setBounds(0, 242, 166, 42);
		labelUbicacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelUbicacion.setForeground(Color.BLACK);
		add(labelUbicacion);
		
		JLabel labelEstado = new JLabel("Estado");
		
		JLabel labelMesa = new JLabel("Clave mesa  ");
		labelMesa.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesa.setForeground(Color.BLACK);
		labelMesa.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMesa.setBounds(10, 84, 166, 42);
		add(labelMesa);
		
		textClaveMesa = new JTextField();
		textClaveMesa.setColumns(10);
		textClaveMesa.setBounds(176, 91, 304, 37);
		add(textClaveMesa);
		
		
		
			
		
			
		{	
		};
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos de la estancia ");
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);
		
		JLabel labelFecha = new JLabel("Fecha ");
		labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFecha.setBounds(0, 396, 166, 42);
		add(labelFecha);
		
		textFecha = new JFormattedTextField("YYYY-MM-DD");
		textFecha.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		textFecha.setColumns(10);
		textFecha.setBounds(176, 399, 304, 37);
		add(textFecha);
        
		
		JLabel labelCafecito = new JLabel("Cafecito");
		labelCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito.setForeground(Color.BLACK);
		labelCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito.setBounds(0, 295, 166, 42);
		add(labelCafecito);
		
		JLabel labelClaveCafecito = new JLabel("Clave cafecito");
		labelClaveCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveCafecito.setForeground(Color.BLACK);
		labelClaveCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveCafecito.setBounds(0, 343, 166, 42);
		add(labelClaveCafecito);
		
		JComboBox comboBoxCafecito = new JComboBox();
		
	
		comboBoxCafecito.setBounds(176, 297, 981, 37);
		add(comboBoxCafecito);
        ArrayList<String> lista2 = new ArrayList<String>();
        lista2 = serviceEmpleadoImpl.llenar_comboCafecito();
        for(int i = 0; i<lista2.size();i++){
        	comboBoxCafecito.addItem(lista2.get(i));
        }
		
		textClaveCafecito = new JTextField();
		textClaveCafecito.setColumns(10);
		textClaveCafecito.setBounds(176, 350, 304, 37);
		add(textClaveCafecito);
		
		JLabel labelFolio = new JLabel("Folio ");
		labelFolio.setHorizontalAlignment(SwingConstants.CENTER);
		labelFolio.setForeground(Color.BLACK);
		labelFolio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFolio.setBounds(0, 490, 166, 42);
		add(labelFolio);
		
		textFolio = new JTextField();
		textFolio.setColumns(10);
		textFolio.setBounds(176, 490, 304, 37);
		add(textFolio);
		
		JButton botonRegistrarEstancia = new JButton("Registrar la estancia");
		botonRegistrarEstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Lugar lugar = new Lugar();
				
//					//mesa
//					private int claveMesa;
//					private int capacidad;
//					
//					//mesa cafecito
//					private int numeroMesa;
//					private String Ubicacion;
//					private int claveMesa2;
//					private int claveCafecito;
//					
//					//mesa contrato
//					private int mesaContrato;
//					private String fecha;
//					private int folio;
//					private int claveMesa3;
//					
					
					lugar.setClaveMesa(Integer.parseInt((textClaveMesa.getText())));
					lugar.setCapacidad(Integer.parseInt((textCapacidad.getText())));
					
					lugar.setNumeroMesa(Integer.parseInt((textNumero.getText())));
					lugar.setUbicacion(textUbicacion.getText());
					lugar.setClaveMesa2(Integer.parseInt((textClaveMesa.getText())));
					lugar.setClaveCafecito(Integer.parseInt((textClaveCafecito.getText())));

					lugar.setMesaContrato(Integer.parseInt((textClaveMesa.getText())));
					lugar.setFecha(textFecha.getText());
					lugar.setFolio(Integer.parseInt((textFolio.getText())));
					lugar.setClaveMesa3(Integer.parseInt((textClaveMesa.getText())));

					serviceLugarImpl.guardarLugar(lugar);
					serviceLugarImpl.guardarLugarEmpleado(lugar);
					serviceLugarImpl.guardarLugarCafecito(lugar);
			


					
					
					
					
					
//					
				} catch (Exception e2) {
	//
						JOptionPane.showInternalMessageDialog(null, "No se pudo registrar, verifique e intentelo de nuevo");
//						
	//
//					
					}

					JOptionPane.showInternalMessageDialog(null, "Estancia registrada con exito");
			}
				
				
				
			
		});
		botonRegistrarEstancia.setForeground(Color.BLUE);
		botonRegistrarEstancia.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		botonRegistrarEstancia.setBounds(666, 493, 304, 37);
		add(botonRegistrarEstancia);
		
		JLabel labelCafecito_1 = new JLabel("Cafecito");
		labelCafecito_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito_1.setForeground(Color.BLACK);
		labelCafecito_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito_1.setBounds(0, 437, 166, 42);
		add(labelCafecito_1);
		
		JComboBox comboBoxEmpleado = new JComboBox();
		
		comboBoxEmpleado.setBounds(176, 447, 981, 37);
		add(comboBoxEmpleado);
		ArrayList<String> lista3 = new ArrayList<String>();
        lista3 = serviceLugarImpl.llenar_comboPersona();
        for(int i = 0; i<lista3.size();i++){
        	comboBoxEmpleado.addItem(lista3.get(i));
        }
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
	


    	

