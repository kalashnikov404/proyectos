package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceLugarImpl;
import servicios.ServiceOrdenImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

import dao.JFrameTest;

import javax.swing.event.PopupMenuEvent;
public class RegistroOrden extends JPanel {
	private JTextField textMesaContrato;
	private JTextField textClave;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	private JTextField textClaveCafecito;
	ServiceLugarImpl serviceLugarImpl= new ServiceLugarImpl();
	ServiceOrdenImpl serviceOrdenImpl= new ServiceOrdenImpl();

	
	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();

	private JTextField textPrecio;
	private JTextField textCantidad;
	private JTextField textClavePlatillo;
	private JTextField textTotal;
	private JTextField textFolio;


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
	public RegistroOrden() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textMesaContrato = new JTextField();
		textMesaContrato.setBounds(174, 201, 304, 37);
		add(textMesaContrato);
		textMesaContrato.setColumns(10);
		
		JLabel labelMesaContrato2 = new JLabel("ID Mes-Con");
		labelMesaContrato2.setBounds(0, 194, 166, 42);
		labelMesaContrato2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMesaContrato2.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesaContrato2.setForeground(Color.BLACK);
		add(labelMesaContrato2);
		
		JLabel labelEstado = new JLabel("Estado");

		
		
		JButton btnNewButton = new JButton("Registrar Orden");
		btnNewButton.setBounds(663, 557, 304, 37);
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//			
//				//	
//					//datos de la orden
//					private int claveOrden;
//					private String fechaOrden;
//					private int numeroMesaContrato;
//					private int claveCafecito;
//					
//					
//					//datos de detalle orden
//					private int numeroDetalleOrden;
//					private int cantidadDetalleOrden;
//					private int clavePlatillo;
//					private float precioVentaDetalleOrden;
//					private int claveOrden2;
//					
//
//				//datos del ticket	
//					private int folio;
//					private String fechaticket;
//					private int total;
//					private int claveOrden3;
//					
//				//datos de preparar
//					
//					private int clavePreparacion;
//					private String fechaPreparacion;
//					private int folio2;
//					private int numeroDetalleOrden2;
//		


			        Connection con;
			        CallableStatement ca, cb, cc, cd;
			        try {
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadenaca", "root", "root");
			            
			            con.setAutoCommit(false);

			            ca = con.prepareCall("{call sp_crearOrden(?,?,?)}");

			            
			            cb = con.prepareCall("{ call sp_crearOrdenDos(?,?,?,?,?)}");
			            cc = con.prepareCall("{ call sp_crearOrdenTres(?,?,?)}");
			            
			            cd = con.prepareCall("{ call sp_crearOrdenCuatro(?,?,?)}");

//			            
//			            ca.setInt(1, Integer.parseInt((textClave.getText())));
//			            ca.setInt(2, Integer.parseInt((textMesaContrato.getText())));
//			            ca.setInt(3, Integer.parseInt((textClaveCafecito.getText())));
			            
			            //oden
			            ca.setString(1, textClave.getText());
			            ca.setString(2, textMesaContrato.getText());
			            ca.setString(3, textClaveCafecito.getText());
			            
			            //detalleorden
			            cb.setString(1, textClave.getText());
			            cb.setString(2, textCantidad.getText());
			            cb.setString(3, textClavePlatillo.getText());
			            cb.setString(4, textPrecio.getText());
			            cb.setString(5, textClave.getText());

			            //ticket
			            cc.setString(1, textClave.getText());
			            cc.setString(2, textTotal.getText());
			            cc.setString(3, textClave.getText());
			            
			            cd.setString(1, textClave.getText());
			            cd.setString(2, textFolio.getText());
			            cd.setString(3, textClave.getText());
 
			          
			            
			            ca.execute();
			            cb.execute();
			            cc.execute();
			            cd.execute();


			            
			            con.commit();

//			            claveOrden, now(), numeroMesa, claveCafecito
//			            cb.setInt("claveOrden", Integer.parseInt((textClavePlatillo.getText())));
//			            cb.setInt("numeroMesa", Integer.parseInt((textClavePlatillo.getText())));
//			            cb.setInt("claveCafecito", Integer.parseInt((textClavePlatillo.getText())));
//			            
//			            
//			            numeroDetalle, cantidad, clavePlatillo, precio, claveOrden);
			
//			      
						JOptionPane.showInternalMessageDialog(null, "Orden reaizada con exito");

//			            decidi mejor hacerlo con inserts en tablaorden
				
				//parece que ya tengo la sintaxis para calar la llamada del procedimienro em la base
				
				
				
				
				} catch (Exception e1) {

					JOptionPane.showInternalMessageDialog(null, "Hubo un error al realizar la orden: " +e1);
					

				
				}

			}
			
			
		});
		btnNewButton.setForeground(Color.BLUE);
		add(btnNewButton);
		
		JLabel labelClaveOrden = new JLabel("Clave Orden ");
		labelClaveOrden.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveOrden.setForeground(Color.BLACK);
		labelClaveOrden.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveOrden.setBounds(0, 88, 166, 42);
		add(labelClaveOrden);
		
		textClave = new JTextField();
		textClave.setColumns(10);
		textClave.setBounds(174, 95, 304, 37);
		add(textClave);
		
		JLabel labelClaveCafecito = new JLabel("Clave Cafecito");
		labelClaveCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveCafecito.setForeground(Color.BLACK);
		labelClaveCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveCafecito.setBounds(10, 297, 166, 42);
		add(labelClaveCafecito);
		
		JComboBox<String> comboBoxCafecito = new JComboBox();
	
		{	
		};
comboBoxCafecito.setBounds(174, 249, 793, 37);

	
		add(comboBoxCafecito);
		 ArrayList<String> lista2 = new ArrayList<String>();
	        lista2 = serviceEmpleadoImpl.llenar_comboCafecito();
	        for(int i = 0; i<lista2.size();i++){
	        	comboBoxCafecito.addItem(lista2.get(i));
	        }
		
		textClaveCafecito = new JTextField();
		textClaveCafecito.setColumns(10);
		textClaveCafecito.setBounds(174, 304, 304, 37);
		add(textClaveCafecito);
		
		JLabel labelCafecito = new JLabel("Cafecito");
		labelCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito.setForeground(Color.BLACK);
		labelCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito.setBounds(0, 238, 166, 42);
		add(labelCafecito);
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos de la orden");
		lblIngresaLosDatos.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);
		
		JLabel labelMesaContrato = new JLabel("ID's Mesa-Contr ");
		labelMesaContrato.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesaContrato.setForeground(Color.BLACK);
		labelMesaContrato.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMesaContrato.setBounds(10, 141, 166, 42);
		add(labelMesaContrato);
		
		JComboBox comboBoxMesaContrato = new JComboBox();
		comboBoxMesaContrato.setBounds(174, 148, 793, 37);
		add(comboBoxMesaContrato);
		ArrayList<String> lista8 = new ArrayList<String>();
        lista8 = serviceOrdenImpl.llenar_comboMesaContrato();
        for(int i = 0; i<lista8.size();i++){
        	comboBoxMesaContrato.addItem(lista8.get(i));
        }
		
		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecio.setForeground(Color.BLACK);
		labelPrecio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPrecio.setBounds(47, 509, 100, 42);
		add(labelPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(174, 516, 304, 37);
		add(textPrecio);
		
		JLabel labelCantidad = new JLabel("Cantidad");
		labelCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		labelCantidad.setForeground(Color.BLACK);
		labelCantidad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCantidad.setBounds(0, 352, 166, 42);
		add(labelCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(174, 359, 304, 37);
		add(textCantidad);
		
		JLabel labelClavePlatillo = new JLabel("Clave Platillo");
		labelClavePlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelClavePlatillo.setForeground(Color.BLACK);
		labelClavePlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClavePlatillo.setBounds(20, 456, 146, 42);
		add(labelClavePlatillo);
		
		JLabel labelPlatillo = new JLabel("Platillo");
		labelPlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlatillo.setForeground(Color.BLACK);
		labelPlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPlatillo.setBounds(10, 403, 166, 42);
		add(labelPlatillo);
		
		JComboBox comboBoxPlatillo = new JComboBox();
		comboBoxPlatillo.setBounds(174, 410, 799, 37);
		add(comboBoxPlatillo);
		ArrayList<String> lista7 = new ArrayList<String>();
        lista7 = serviceOrdenImpl.llenar_comboPlatillo();
        for(int i = 0; i<lista7.size();i++){
        	comboBoxPlatillo.addItem(lista7.get(i));
        }
		
		textClavePlatillo = new JTextField();
		textClavePlatillo.setColumns(10);
		textClavePlatillo.setBounds(174, 463, 304, 37);
		add(textClavePlatillo);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblTotal.setBounds(47, 550, 100, 42);
		add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(174, 563, 304, 37);
		add(textTotal);
		
		JLabel labelFolio = new JLabel("Folio ");
		labelFolio.setHorizontalAlignment(SwingConstants.CENTER);
		labelFolio.setForeground(Color.BLACK);
		labelFolio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFolio.setBounds(1087, 88, 80, 42);
		add(labelFolio);
		
		textFolio = new JTextField();
		textFolio.setColumns(10);
		textFolio.setBounds(1177, 93, 113, 37);
		add(textFolio);
		
		JComboBox comboBoxContrato = new JComboBox();
		comboBoxContrato.setBounds(618, 95, 459, 37);
		add(comboBoxContrato);
		ArrayList<String> lista5 = new ArrayList<String>();
        lista5 = serviceOrdenImpl.llenar_comboEmpleado();
        for(int i = 0; i<lista5.size();i++){
        	comboBoxContrato.addItem(lista5.get(i));
        }
		
		
		JLabel labelFolio_1 = new JLabel("Empleado");
		labelFolio_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelFolio_1.setForeground(Color.BLACK);
		labelFolio_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelFolio_1.setBounds(488, 88, 120, 42);
		add(labelFolio_1);

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
	