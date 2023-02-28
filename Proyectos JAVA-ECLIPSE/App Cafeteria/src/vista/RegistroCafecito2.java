package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import servicios.ServiceCafecitoImpl;

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
import java.awt.event.ActionEvent;
public class RegistroCafecito2 extends JPanel {
	private JTextField textCalle;
	private JTextField textNumero;
	private JTextField textOrientacion;
	private JTextField textCiudad;
	private JTextField textMunicipio;
	private JTextField textCodigoPostal;
	private JTextField textColonia;
	private JTextField textAsentamiento;
	private JTextField textZona;

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
	public RegistroCafecito2() throws IOException {
		
		
		setLayout(null);
		
		

		
    
		JLabel lblNewLabel = new JLabel("Datos del cafecito");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(318, 30, 340, 40);
		add(lblNewLabel);
		
		textCalle = new JTextField();
		textCalle.setBounds(149, 40, 162, 30);
		add(textCalle);
		textCalle.setColumns(10);
		
		JLabel labelCalle = new JLabel("Calle");
		labelCalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelCalle.setForeground(Color.RED);
		labelCalle.setHorizontalAlignment(SwingConstants.CENTER);
		labelCalle.setBounds(30, 35, 93, 37);
		add(labelCalle);
		
		textNumero = new JTextField();
		textNumero.setBounds(149, 88, 162, 30);
		add(textNumero);
		textNumero.setColumns(10);
		
		textOrientacion = new JTextField();
		textOrientacion.setBounds(149, 129, 162, 30);
		add(textOrientacion);
		textOrientacion.setColumns(10);
		
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumero.setForeground(Color.RED);
		labelNumero.setBounds(40, 83, 63, 37);
		add(labelNumero);
		
		JLabel labelOrientacion = new JLabel("Orientaci\u00F3n");
		labelOrientacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelOrientacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrientacion.setForeground(Color.RED);
		labelOrientacion.setBounds(33, 124, 106, 37);
		add(labelOrientacion);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		labelCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		labelCiudad.setForeground(Color.RED);
		labelCiudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelCiudad.setBounds(40, 165, 63, 37);
		add(labelCiudad);
		
		JLabel labelMunicipio = new JLabel("Municipio");
		labelMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
		labelMunicipio.setForeground(Color.RED);
		labelMunicipio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelMunicipio.setBounds(42, 230, 71, 37);
		add(labelMunicipio);
		
		JLabel labelCodigoPostal = new JLabel("Codigo postal");
		labelCodigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodigoPostal.setForeground(Color.RED);
		labelCodigoPostal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelCodigoPostal.setBounds(20, 283, 119, 37);
		add(labelCodigoPostal);
		
		JLabel labelColonia = new JLabel("Colonia");
		labelColonia.setHorizontalAlignment(SwingConstants.CENTER);
		labelColonia.setForeground(Color.RED);
		labelColonia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelColonia.setBounds(10, 331, 116, 37);
		add(labelColonia);
		
		JLabel labelAsentamiento = new JLabel("Asentamiento");
		labelAsentamiento.setHorizontalAlignment(SwingConstants.CENTER);
		labelAsentamiento.setForeground(Color.RED);
		labelAsentamiento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelAsentamiento.setBounds(0, 379, 139, 40);
		add(labelAsentamiento);
		
		textCiudad = new JTextField();
		textCiudad.setBounds(149, 170, 162, 30);
		add(textCiudad);
		textCiudad.setColumns(10);
		
		textMunicipio = new JTextField();
		textMunicipio.setColumns(10);
		textMunicipio.setBounds(149, 235, 162, 30);
		add(textMunicipio);
		
		textCodigoPostal = new JTextField();
		textCodigoPostal.setColumns(10);
		textCodigoPostal.setBounds(149, 286, 162, 30);
		add(textCodigoPostal);
		
		textColonia = new JTextField();
		textColonia.setColumns(10);
		textColonia.setBounds(149, 336, 162, 30);
		add(textColonia);
		
		textAsentamiento = new JTextField();
		textAsentamiento.setColumns(10);
		textAsentamiento.setBounds(149, 386, 162, 30);
		add(textAsentamiento);
		
		textZona = new JTextField();
		textZona.setBounds(149, 430, 162, 30);
		add(textZona);
		textZona.setColumns(10);
		
		JLabel labelZona = new JLabel("Zona");
		labelZona.setHorizontalAlignment(SwingConstants.CENTER);
		labelZona.setForeground(Color.RED);
		labelZona.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelZona.setBounds(10, 430, 116, 40);
		add(labelZona);
		
		JButton btnNewButton = new JButton("Registrar cafecito");
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
				Cafecito cafecito = new Cafecito();
				
//				
				
				cafecito.setCalle(textCalle.getText());
				cafecito.setNumero(Integer.parseInt((textNumero.getText())));
				cafecito.setOrientacion(textOrientacion.getText());
				
				
//				vehiculo.setPlacas(tfPlacas.getText());
//				vehiculo.setModelo(tfModelo.getText());
//				vehiculo.setAño(Integer.parseInt(tfAño.getText()));
//				vehiculo.setMarca(tfMarca.getText());
//				vehiculo.setColor(tfColor.getText());
				
				
				
				
//
//				ServiceVehiculoImpl serviceVehiculoImpl = new ServiceVehiculoImpl();
//				serviceVehiculoImpl.guardar(vehiculo);
				
				ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
				serviceCafecitoImpl.guardar1(cafecito);
				
				
				
				
				
				
				} catch (Exception e2) {
					// TODO: handle exception
				}

				JOptionPane.showInternalMessageDialog(null, "Cafecito registrado con exito");
			}
			
			
			
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(454, 415, 172, 45);
		add(btnNewButton);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);		
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

		fondo.setIcon(img22);

	}
	    
	
}


    	

