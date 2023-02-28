package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
public class RegistroCafecito extends JPanel {
	private JTextField textCalle;
	private JTextField textNumero;
	private JTextField textOrientacion;
	private JTextField textClave;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	private JTextField textClaveColonia;


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
	public RegistroCafecito() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textCalle = new JTextField();
		textCalle.setBounds(174, 231, 304, 37);
		add(textCalle);
		textCalle.setColumns(10);
		
		JLabel labelCalle = new JLabel("Calle  ");
		labelCalle.setBounds(0, 231, 166, 42);
		labelCalle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		labelCalle.setForeground(Color.BLACK);
		labelCalle.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelCalle);
		
		textNumero = new JTextField();
		textNumero.setBounds(174, 303, 304, 37);
		add(textNumero);
		textNumero.setColumns(10);
		
		textOrientacion = new JTextField();
		textOrientacion.setBounds(174, 374, 304, 37);
		add(textOrientacion);
		textOrientacion.setColumns(10);
		
		JLabel labelNumero = new JLabel("Numero  ");
		labelNumero.setBounds(0, 293, 166, 42);
		labelNumero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumero.setForeground(Color.BLACK);
		add(labelNumero);
		
		JLabel labelOrientacion = new JLabel("Orientaci\u00F3n ");
		labelOrientacion.setBounds(0, 365, 166, 42);
		labelOrientacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		labelOrientacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrientacion.setForeground(Color.BLACK);
		add(labelOrientacion);
		
		JLabel labelEstado = new JLabel("Estado");

		
		
		JButton btnNewButton = new JButton("Registrar cafecito");
		btnNewButton.setBounds(714, 514, 304, 37);
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
				Cafecito cafecito = new Cafecito();
			//	Ciudad ciudad = new Ciudad();
				
//				
				cafecito.setCalle(textCalle.getText());
				cafecito.setNumero(Integer.parseInt((textNumero.getText())));
				cafecito.setOrientacion(textOrientacion.getText());
//				cafecito.setCiudad(textCiudad.getText());
//				cafecito.setMunicipio(textMunicipio.getText());
//				cafecito.setCp(Integer.parseInt((textCodigoPostal.getText())));
//				cafecito.setColonia(textColonia.getText());
//				cafecito.setAsentamiento(textAsentamiento.getText());
//				cafecito.setZona(textZona.getText());
//				cafecito.setEstado(textEstado.getText());
				cafecito.setCveCF(Integer.parseInt((textClave.getText())));
				cafecito.setCveCol(Integer.parseInt((textClaveColonia.getText())));

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
//				ServiceVehiculoImpl serviceVehiculoImpl = new ServiceVehiculoImpl();
//				serviceVehiculoImpl.guardar(vehiculo);
				
				serviceCafecitoImpl.guardar1(cafecito);
		


				
				
				
				
				
				
				} catch (Exception e2) {

					JOptionPane.showInternalMessageDialog(null, "Mamaste no se pudo");
					

				
				}

				JOptionPane.showInternalMessageDialog(null, "Cafecito registrado con exito");
			}
			
			
			
		});
		btnNewButton.setForeground(Color.BLUE);
		add(btnNewButton);
		
		JLabel labelClave = new JLabel("Clave ");
		labelClave.setHorizontalAlignment(SwingConstants.CENTER);
		labelClave.setForeground(Color.BLACK);
		labelClave.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		labelClave.setBounds(0, 158, 166, 42);
		add(labelClave);
		
		textClave = new JTextField();
		textClave.setColumns(10);
		textClave.setBounds(174, 167, 304, 37);
		add(textClave);
		
		JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setForeground(Color.BLACK);
		lblUbicacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblUbicacion.setBounds(0, 443, 166, 42);
		add(lblUbicacion);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {


				String tmp= (String) comboBox.getSelectedItem();
				String sql= "select cve_col from cafecito where cve_col=?";

//				try{
//					pst=conn.prepareStatement(sql);
//					pst.setString(1, tmp);
//					rs=pst.executeQuery();
//		
//					if(rs.next){
//						String add=rs.getString("cve_col");
//						textClaveColonia.setText();
//
//
//					}
//				}
			
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		
		
		
			
		
			
		{	
		};

		
		
	
		
            comboBox.removeAllItems();
            ArrayList<String> lista = new ArrayList<String>();
            lista = serviceCafecitoImpl.llenar_combo();
            for(int i = 0; i<lista.size();i++){
                comboBox.addItem(lista.get(i));
            }
            
           
          
            
    		comboBox.setBounds(174, 455, 1118, 37);

		
		
		add(comboBox);

		
		textClaveColonia = new JTextField();
		textClaveColonia.setColumns(10);
		textClaveColonia.setBounds(174, 520, 304, 37);
		add(textClaveColonia);
		
		JLabel labelClaveColonia = new JLabel("Clave colonia");
		labelClaveColonia.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveColonia.setForeground(Color.BLACK);
		labelClaveColonia.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		labelClaveColonia.setBounds(0, 520, 166, 42);
		add(labelClaveColonia);
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos del cafecito");
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);

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
	


    	

