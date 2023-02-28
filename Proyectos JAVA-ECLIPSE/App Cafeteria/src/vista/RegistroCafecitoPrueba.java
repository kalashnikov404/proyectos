//package vista;
//
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
//
//import modelo.Cafecito;
//import modelo.Ciudad;
//import servicios.ServiceCafecitoImpl;
//
//import java.awt.Font;
//import java.awt.Image;
//
//import javax.swing.JTextField;
//import java.awt.Color;
//import java.awt.EventQueue;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.awt.event.ActionEvent;
//public class RegistroCafecito extends JPanel {
//	private JTextField textCalle;
//	private JTextField textNumero;
//	private JTextField textOrientacion;
//	private JTextField textCiudad;
//	private JTextField textMunicipio;
//	private JTextField textCodigoPostal;
//	private JTextField textColonia;
//	private JTextField textAsentamiento;
//	private JTextField textZona;
//	private JTextField textEstado;
//	private JTextField textClave;
//
//
//	/**
//	 * Create the panel.
//	 */
//
//	
////	  private BufferedImage imagen;
////
////	  
////
////	    public static void main(String[] args){
//////	    	invocacion de libreria de estilos
////	    	
////	    	
////	    	EventQueue.invokeLater(new Runnable() {
////				public void run() {
////					try {
////						RegistroCafecito frame = new RegistroCafecito();
////						frame.setVisible(true);
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
////				}
////			});}
////      
//	public RegistroCafecito() throws IOException {
//		setBackground(new Color(216, 191, 216));
//		
//		setBounds(100, 100, 1300, 794);
//		setLayout(null);
//		
//
//		
//    
//		JLabel lblNewLabel = new JLabel("Datos del cafecito");
//		lblNewLabel.setBounds(461, 18, 418, 70);
//		lblNewLabel.setForeground(new Color(255, 0, 0));
//		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 34));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		add(lblNewLabel);
//		
//		textCalle = new JTextField();
//		textCalle.setBounds(146, 18, 176, 29);
//		add(textCalle);
//		textCalle.setColumns(10);
//		
//		JLabel labelCalle = new JLabel("Calle ");
//		labelCalle.setBounds(54, 22, 36, 17);
//		labelCalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		labelCalle.setForeground(Color.BLACK);
//		labelCalle.setHorizontalAlignment(SwingConstants.CENTER);
//		add(labelCalle);
//		
//		textNumero = new JTextField();
//		textNumero.setBounds(146, 75, 176, 29);
//		add(textNumero);
//		textNumero.setColumns(10);
//		
//		textOrientacion = new JTextField();
//		textOrientacion.setBounds(146, 128, 176, 29);
//		add(textOrientacion);
//		textOrientacion.setColumns(10);
//		
//		JLabel labelNumero = new JLabel("Numero ");
//		labelNumero.setBounds(54, 75, 60, 17);
//		labelNumero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
//		labelNumero.setForeground(Color.BLACK);
//		add(labelNumero);
//		
//		JLabel labelOrientacion = new JLabel("Orientacion ");
//		labelOrientacion.setBounds(53, 128, 83, 17);
//		labelOrientacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		labelOrientacion.setHorizontalAlignment(SwingConstants.CENTER);
//		labelOrientacion.setForeground(Color.BLACK);
//		add(labelOrientacion);
//		
//		JLabel labelCiudad = new JLabel("Ciudad ");
//		labelCiudad.setBounds(54, 186, 52, 17);
//		labelCiudad.setHorizontalAlignment(SwingConstants.CENTER);
//		labelCiudad.setForeground(Color.BLACK);
//		labelCiudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelCiudad);
//		
//		JLabel labelMunicipio = new JLabel("Municipio ");
//		labelMunicipio.setBounds(57, 249, 68, 17);
//		labelMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
//		labelMunicipio.setForeground(Color.BLACK);
//		labelMunicipio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelMunicipio);
//		
//		JLabel labelCodigoPostal = new JLabel("Codigo postal ");
//		labelCodigoPostal.setBounds(39, 302, 99, 17);
//		labelCodigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
//		labelCodigoPostal.setForeground(Color.BLACK);
//		labelCodigoPostal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelCodigoPostal);
//		
//		JLabel labelColonia = new JLabel("Colonia ");
//		labelColonia.setBounds(59, 354, 55, 17);
//		labelColonia.setHorizontalAlignment(SwingConstants.CENTER);
//		labelColonia.setForeground(Color.BLACK);
//		labelColonia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelColonia);
//		
//		JLabel labelAsentamiento = new JLabel("Asentamiento ");
//		labelAsentamiento.setBounds(24, 408, 100, 17);
//		labelAsentamiento.setHorizontalAlignment(SwingConstants.CENTER);
//		labelAsentamiento.setForeground(Color.BLACK);
//		labelAsentamiento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelAsentamiento);
//		
//		JLabel labelZona = new JLabel("Zona ");
//		labelZona.setBounds(21, 451, 93, 40);
//		labelZona.setHorizontalAlignment(SwingConstants.CENTER);
//		labelZona.setForeground(Color.BLACK);
//		labelZona.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelZona);
//		
//		JLabel labelEstado = new JLabel("Estado");
//		labelZona.setHorizontalAlignment(SwingConstants.CENTER);
//		labelZona.setForeground(Color.BLACK);
//		labelZona.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		add(labelZona);
//		
//		
//		
//		textCiudad = new JTextField();
//		textCiudad.setBounds(146, 186, 176, 29);
//		add(textCiudad);
//		textCiudad.setColumns(10);
//		
//		textMunicipio = new JTextField();
//		textMunicipio.setBounds(146, 245, 176, 29);
//		textMunicipio.setColumns(10);
//		add(textMunicipio);
//		
//		textCodigoPostal = new JTextField();
//		textCodigoPostal.setBounds(146, 298, 176, 29);
//		textCodigoPostal.setColumns(10);
//		add(textCodigoPostal);
//		
//		textColonia = new JTextField();
//		textColonia.setBounds(146, 350, 176, 29);
//		textColonia.setColumns(10);
//		add(textColonia);
//		
//		textAsentamiento = new JTextField();
//		textAsentamiento.setBounds(146, 408, 176, 29);
//		textAsentamiento.setColumns(10);
//		add(textAsentamiento);
//		
//		textZona = new JTextField();
//		textZona.setBounds(146, 463, 176, 29);
//		textZona.setColumns(10);
//		add(textZona);
//	
//		textEstado = new JTextField();
//		textEstado.setBounds(146, 517, 176, 29);
//		textEstado.setColumns(10);
//		add(textEstado);
//
//		
//		
//		JButton btnNewButton = new JButton("Registrar cafecito");
//		btnNewButton.setBounds(643, 515, 155, 31);
//		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				try {
//				
//				Cafecito cafecito = new Cafecito();
//			//	Ciudad ciudad = new Ciudad();
//				
////				
//				cafecito.setCalle(textCalle.getText());
//				cafecito.setNumero(Integer.parseInt((textNumero.getText())));
//				cafecito.setOrientacion(textOrientacion.getText());
//				cafecito.setCiudad(textCiudad.getText());
//				cafecito.setMunicipio(textMunicipio.getText());
//				cafecito.setCp(Integer.parseInt((textCodigoPostal.getText())));
//				cafecito.setColonia(textColonia.getText());
//				cafecito.setAsentamiento(textAsentamiento.getText());
//				cafecito.setZona(textZona.getText());
//				cafecito.setEstado(textEstado.getText());
//				cafecito.setCveCF(Integer.parseInt((textClave.getText())));
//
////				
////				ciudad
////				municipio
////				codigo postal
////				colonia
////				asentamiento
////				zona
////				estado
//
//				
////				vehiculo.setPlacas(tfPlacas.getText());
////				vehiculo.setModelo(tfModelo.getText());
////				vehiculo.setAño(Integer.parseInt(tfAño.getText()));
////				vehiculo.setMarca(tfMarca.getText());
////				vehiculo.setColor(tfColor.getText());
//				
//				
//				
//				
////
////				ServiceVehiculoImpl serviceVehiculoImpl = new ServiceVehiculoImpl();
////				serviceVehiculoImpl.guardar(vehiculo);
//				
//				ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
//				serviceCafecitoImpl.guardar1(cafecito);
//				serviceCafecitoImpl.guardarCafecitoCiudad(cafecito);
//				serviceCafecitoImpl.guardarCafecitoCP(cafecito);
//				serviceCafecitoImpl.guardarCafecitoColonia(cafecito);
//				serviceCafecitoImpl.guardarCafecitoEstado(cafecito);
//
//
//				
//				
//				
//				
//				
//				
//				} catch (Exception e2) {
//
//					JOptionPane.showInternalMessageDialog(null, "Mamaste no se pudo");
//					
//
//				
//				}
//
//				JOptionPane.showInternalMessageDialog(null, "Cafecito registrado con exito");
//			}
//			
//			
//			
//		});
//		btnNewButton.setForeground(Color.BLUE);
//		add(btnNewButton);
//		
//		JLabel lblEstado = new JLabel("Estado");
//		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
//		lblEstado.setForeground(Color.BLACK);
//		lblEstado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		lblEstado.setBounds(24, 521, 100, 17);
//		add(lblEstado);
//		
//		JLabel labelClave = new JLabel("Clave");
//		labelClave.setHorizontalAlignment(SwingConstants.CENTER);
//		labelClave.setForeground(Color.BLACK);
//		labelClave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		labelClave.setBounds(25, 574, 100, 17);
//		add(labelClave);
//		
//		textClave = new JTextField();
//		textClave.setColumns(10);
//		textClave.setBounds(146, 570, 176, 29);
//		add(textClave);
//
////		
////		JLabel fondo = new JLabel("");
////		fondo.setBounds(0, 0, 1300, 795);
////		add(fondo);		
////		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
////		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
////		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));
////
////		fondo.setIcon(img22);
//
//		
//
//	}
//}
//
