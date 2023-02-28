package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
import modelo.Empleado;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;

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
public class RegistroEmpleado extends JPanel {
	private JTextField textNombre;
	private JTextField textPaterno;
	private JTextField textMaterno;
	private JTextField textClavePersona;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	private JTextField textNumero;
	private JTextField textCalle;
	private JFormattedTextField textNacimiento;
	private JTextField textGenero;
	private JTextField textTelefono;
	private JTextField textClaveColonia;
	private JTextField textFolio;
	private JTextField textRFC;
	private JTextField textInicio;
	private JTextField textFinal;
	private JTextField textSueldo;
	private JTextField textPuesto;
	private JTextField textClaveCafecito;
	private JTextField textOrientacion;
	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();


	/**
	 * Create the panel.
	 */

	
//	  private BufferedImage imagen;
//
//	  
//
//	    public static void main(String[] args){
////	    	invocacion de libreria de estilos
//	    	
//	    	
//	    	EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						RegistroCafecito frame = new RegistroCafecito();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});}
//      
	public RegistroEmpleado() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(176, 143, 304, 37);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre ");
		labelNombre.setBounds(0, 136, 166, 42);
		labelNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelNombre);
		
		textPaterno = new JTextField();
		textPaterno.setBounds(176, 196, 304, 37);
		add(textPaterno);
		textPaterno.setColumns(10);
		
		textMaterno = new JTextField();
		textMaterno.setBounds(176, 249, 304, 37);
		add(textMaterno);
		textMaterno.setColumns(10);
		
		JLabel labelPaterno = new JLabel("A.Paterno ");
		labelPaterno.setBounds(0, 189, 166, 42);
		labelPaterno.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaterno.setForeground(Color.BLACK);
		add(labelPaterno);
		
		JLabel labelMaterno = new JLabel("A.Materno ");
		labelMaterno.setBounds(0, 242, 166, 42);
		labelMaterno.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaterno.setForeground(Color.BLACK);
		add(labelMaterno);
		
		JLabel labelEstado = new JLabel("Estado");

		
		
		JButton botonRegistrarEmpleado = new JButton("Registrar Empleado");
		botonRegistrarEmpleado.setBounds(1009, 87, 304, 37);
		botonRegistrarEmpleado.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		botonRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
				Empleado empleado = new Empleado();
			//	Ciudad ciudad = new Ciudad();
				
  			empleado.setCvePer(Integer.parseInt((textClavePersona.getText())));
			empleado.setNombre(textNombre.getText());
			empleado.setPaterno(textPaterno.getText());
			empleado.setMaterno(textMaterno.getText());
			empleado.setCalle(textCalle.getText());
			empleado.setNumero(Integer.parseInt((textNumero.getText())));
			empleado.setOrientacion(textOrientacion.getText());
			empleado.setNacimiento(textNacimiento.getText());
			empleado.setGenero(textGenero.getText());
			empleado.setTelefono(Integer.parseInt(textTelefono.getText()));
			empleado.setCveColonia(Integer.parseInt((textClaveColonia.getText())));
	
			
			
  			empleado.setFolio(Integer.parseInt((textFolio.getText())));
			empleado.setRfc(textRFC.getText());
			empleado.setfInicio(textInicio.getText());
			empleado.setfFinal(textFinal.getText());
  			empleado.setSueldo(Integer.parseInt((textSueldo.getText())));
  			empleado.setCveCaf(Integer.parseInt((textClaveCafecito.getText())));
  			
  			empleado.setCvePersona(Integer.parseInt((textClavePersona.getText())));

			
//			te int folio;
//			private String rfc;
//			private String fInicio;
//			private String fFinal;
//			private double sueldo;
//			private String puesto;
//			private int cveCaf;
//			
//			
//			private int cvePersona;
//			
//				private String genero;
//				private int telefono;
//				private int cveColonia;
//				
//				
//				
//				cafecito.setCalle(textCalle.getText());
//				cafecito.setNumero(Integer.parseInt((textNumero.getText())));
//				cafecito.setOrientacion(textOrientacion.getText());
////				cafecito.setCiudad(textCiudad.getText());
////				cafecito.setMunicipio(textMunicipio.getText());
////				cafecito.setCp(Integer.parseInt((textCodigoPostal.getText())));
////				cafecito.setColonia(textColonia.getText());
////				cafecito.setAsentamiento(textAsentamiento.getText());
////				cafecito.setZona(textZona.getText());
////				cafecito.setEstado(textEstado.getText());
//				cafecito.setCveCF(Integer.parseInt((textClave.getText())));
//				cafecito.setCveCol(Integer.parseInt((textClaveColonia.getText())));

//
////				
//				ciudad
//				municipio
//				codigo postal
//				colonia
//				asentamiento
//				zona
//				estado

				
//				vehiculo.setPlacas(tfPlacas.getText());
//				vehiculo.setModelo(tfModelo.getText());
//				vehiculo.setAño(Integer.parseInt(tfAño.getText()));
//				vehiculo.setMarca(tfMarca.getText());
//				vehiculo.setColor(tfColor.getText());
				
				
				
				
//
//				serviceVehiculoImpl.guardar(vehiculo);
		serviceEmpleadoImpl.guardarEmpleadoPersona(empleado);

		serviceEmpleadoImpl.guardarEmpleado(empleado);
		


				
				
				
				
				
//				
			} catch (Exception e2) {
//
					JOptionPane.showInternalMessageDialog(null, "No se pudo registrar, verifique e intentelo de nuevo");
//					
//
//				
				}

				JOptionPane.showInternalMessageDialog(null, "Empleado registrado con exito");
		}
			
			
			
		});
		botonRegistrarEmpleado.setForeground(Color.BLUE);
		add(botonRegistrarEmpleado);
		
		JLabel labelClavePersona = new JLabel("Clave persona ");
		labelClavePersona.setHorizontalAlignment(SwingConstants.CENTER);
		labelClavePersona.setForeground(Color.BLACK);
		labelClavePersona.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClavePersona.setBounds(10, 84, 166, 42);
		add(labelClavePersona);
		
		textClavePersona = new JTextField();
		textClavePersona.setColumns(10);
		textClavePersona.setBounds(176, 91, 304, 37);
		add(textClavePersona);
		
		JLabel labelCalle = new JLabel("Calle ");
		labelCalle.setHorizontalAlignment(SwingConstants.CENTER);
		labelCalle.setForeground(Color.BLACK);
		labelCalle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCalle.setBounds(0, 287, 166, 42);
		add(labelCalle);
		
		
		
			
		
			
		{	
		};
            
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(107, 340, 59, 37);
		add(textNumero);
		
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumero.setForeground(Color.BLACK);
		labelNumero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setBounds(10, 339, 94, 42);
		add(labelNumero);
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos del empleado ");
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(176, 297, 304, 37);
		add(textCalle);
		
		JLabel labelNacimiento = new JLabel("F.Nacimiento ");
		labelNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		labelNacimiento.setForeground(Color.BLACK);
		labelNacimiento.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNacimiento.setBounds(0, 393, 166, 42);
		add(labelNacimiento);
		
		textNacimiento = new JFormattedTextField("YYYY-MM-DD");
		textNacimiento.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		textNacimiento.setColumns(10);
		textNacimiento.setBounds(176, 400, 304, 37);
		add(textNacimiento);
		
		JLabel labelGenero = new JLabel("Genero");
		labelGenero.setHorizontalAlignment(SwingConstants.CENTER);
		labelGenero.setForeground(Color.BLACK);
		labelGenero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelGenero.setBounds(0, 446, 166, 42);
		add(labelGenero);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(176, 453, 304, 37);
		add(textGenero);
		
		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		labelTelefono.setForeground(Color.BLACK);
		labelTelefono.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelTelefono.setBounds(0, 494, 166, 42);
		add(labelTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(176, 501, 304, 37);
		add(textTelefono);
		
		JLabel labelUbicacion = new JLabel("Ubicaci\u00F3n ");
		labelUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelUbicacion.setForeground(Color.BLACK);
		labelUbicacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelUbicacion.setBounds(0, 587, 166, 42);
		add(labelUbicacion);
		
		JComboBox comboBoxUbicacion= new JComboBox();
	
		
        comboBoxUbicacion.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = serviceCafecitoImpl.llenar_combo();
        for(int i = 0; i<lista.size();i++){
            comboBoxUbicacion.addItem(lista.get(i));
        }
        
       
      
		
    	comboBoxUbicacion.setBounds(176, 594, 1118, 37);
		add(comboBoxUbicacion);
		
		JLabel labelClaveColonia = new JLabel("Clave colonia");
		labelClaveColonia.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveColonia.setForeground(Color.BLACK);
		labelClaveColonia.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveColonia.setBounds(0, 534, 166, 42);
		add(labelClaveColonia);
		
		textClaveColonia = new JTextField();
		textClaveColonia.setColumns(10);
		textClaveColonia.setBounds(176, 549, 304, 37);
		add(textClaveColonia);
		
		JLabel labelFolio = new JLabel("Folio ");
		labelFolio.setHorizontalAlignment(SwingConstants.CENTER);
		labelFolio.setForeground(Color.BLACK);
		labelFolio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFolio.setBounds(490, 84, 166, 42);
		add(labelFolio);
		
		textFolio = new JTextField();
		textFolio.setColumns(10);
		textFolio.setBounds(661, 89, 304, 37);
		add(textFolio);
		
		JLabel labelRFC = new JLabel("RFC ");
		labelRFC.setHorizontalAlignment(SwingConstants.CENTER);
		labelRFC.setForeground(Color.BLACK);
		labelRFC.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelRFC.setBounds(490, 136, 166, 42);
		add(labelRFC);
		
		JLabel labelInicio = new JLabel("F.Inicio ");
		labelInicio.setHorizontalAlignment(SwingConstants.CENTER);
		labelInicio.setForeground(Color.BLACK);
		labelInicio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelInicio.setBounds(490, 196, 166, 42);
		
		add(labelInicio);
		
		JLabel labelFinal = new JLabel("F.Final ");
		labelFinal.setHorizontalAlignment(SwingConstants.CENTER);
		labelFinal.setForeground(Color.BLACK);
		labelFinal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFinal.setBounds(490, 242, 166, 42);
		add(labelFinal);
		
		JLabel labelSueldo = new JLabel("Sueldo ");
		labelSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldo.setForeground(Color.BLACK);
		labelSueldo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelSueldo.setBounds(490, 287, 166, 42);
		add(labelSueldo);
		
		JLabel labelPuesto = new JLabel("Puesto ");
		labelPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuesto.setForeground(Color.BLACK);
		labelPuesto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPuesto.setBounds(490, 341, 166, 42);
		add(labelPuesto);
		
		textRFC = new JTextField();
		textRFC.setColumns(10);
		textRFC.setBounds(661, 136, 304, 37);
		add(textRFC);
		
		
		textInicio = new JFormattedTextField("YYYY-MM-DD");
		textInicio.setFont(new Font("Dialog", Font.PLAIN, 20));
		textInicio.setColumns(10);
		textInicio.setBounds(661, 196, 304, 37);
		add(textInicio);
		
		textFinal = new JFormattedTextField("YYYY-MM-DD");
		textFinal.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFinal.setColumns(10);
		textFinal.setBounds(661, 249, 304, 37);
		add(textFinal);
		
		textSueldo = new JTextField();
		textSueldo.setColumns(10);
		textSueldo.setBounds(661, 292, 304, 37);
		add(textSueldo);
		
		textPuesto = new JTextField();
		textPuesto.setColumns(10);
		textPuesto.setBounds(661, 339, 304, 37);
		add(textPuesto);
		
		JLabel labelCafecito = new JLabel("Cafecito");
		labelCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito.setForeground(Color.BLACK);
		labelCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito.setBounds(490, 393, 166, 42);
		add(labelCafecito);
		
		JLabel labelClaveCafecito = new JLabel("Clave cafecito");
		labelClaveCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveCafecito.setForeground(Color.BLACK);
		labelClaveCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveCafecito.setBounds(500, 446, 166, 42);
		add(labelClaveCafecito);
		
		JComboBox comboBoxCafecito = new JComboBox();
		
	
		comboBoxCafecito.setBounds(661, 393, 629, 37);
		add(comboBoxCafecito);
        ArrayList<String> lista2 = new ArrayList<String>();
        lista2 = serviceEmpleadoImpl.llenar_comboCafecito();
        for(int i = 0; i<lista2.size();i++){
        	comboBoxCafecito.addItem(lista2.get(i));
        }
		
		textClaveCafecito = new JTextField();
		textClaveCafecito.setColumns(10);
		textClaveCafecito.setBounds(661, 453, 304, 37);
		add(textClaveCafecito);
		
		JLabel labelOrientacion = new JLabel("Orientaci\u00F3n ");
		labelOrientacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrientacion.setForeground(Color.BLACK);
		labelOrientacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelOrientacion.setBounds(176, 340, 117, 42);
		add(labelOrientacion);
		
		textOrientacion = new JTextField();
		textOrientacion.setColumns(10);
		textOrientacion.setBounds(294, 340, 186, 37);
		add(textOrientacion);

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
	


    	

