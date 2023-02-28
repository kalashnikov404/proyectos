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
import servicios.ServicePlatilloImpl;
import servicios.ServiceResurtidoImpl;

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
import javax.swing.JFormattedTextField;

import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.PopupMenuListener;

import dao.JFrameTest;

import javax.swing.event.PopupMenuEvent;
public class RegistroResurtido extends JPanel {
	private JTextField textClaveProveedor;
	private JTextField textClaveResurtido;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	private JTextField textClaveCafecito;
	ServiceLugarImpl serviceLugarImpl= new ServiceLugarImpl();
	ServiceOrdenImpl serviceOrdenImpl= new ServiceOrdenImpl();
	ServiceResurtidoImpl serviceResurtidoImpl= new ServiceResurtidoImpl();

	ServicePlatilloImpl servicePlatilloImpl= new ServicePlatilloImpl();

	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();
	private JTextField textCantidad;
	private JTextField textClavePlatillo;
	private JTextField textFechaCaducidad;
	private JTextField textClaveProducto;
	private JTextField textPrecio;


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
	public RegistroResurtido() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textClaveProveedor = new JTextField();
		textClaveProveedor.setBounds(174, 201, 304, 37);
		add(textClaveProveedor);
		textClaveProveedor.setColumns(10);
		
		JLabel labelClaveProveedor = new JLabel("Clave Proveedor ");
		labelClaveProveedor.setBounds(0, 194, 166, 42);
		labelClaveProveedor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveProveedor.setForeground(Color.BLACK);
		add(labelClaveProveedor);
		
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

			            ca = con.prepareCall("{call sp_hacerResurtido(?,?,?)}");

			            
			            cb = con.prepareCall("{ call sp_hacerResurtidoDos(?,?,?,?,?,?,?)}");
			            cc = con.prepareCall("{ call sp_hacerResurtidoCuatro(?,?,?)}");
			            
		
//			            ca.setInt(1, Integer.parseInt((textClave.getText())));
//			            ca.setInt(2, Integer.parseInt((textMesaContrato.getText())));
//			            ca.setInt(3, Integer.parseInt((textClaveCafecito.getText())));
			            
			            //oden
			            ca.setString(1, textClaveResurtido.getText());
			            ca.setString(2, textClaveProveedor.getText());
			            ca.setString(3, textClaveCafecito.getText());
			            
			            
			            
			            //detalleorden
			            cb.setString(1, textClaveResurtido.getText());
			            cb.setString(2, textCantidad.getText());
			            cb.setString(3, textPrecio.getText());
			            cb.setString(4, textFechaCaducidad.getText());
			            cb.setString(5, textClaveResurtido.getText());
			            cb.setString(6, textClaveProducto.getText());
			            cb.setString(7, textClaveResurtido.getText());


			            //ticket
			            cc.setString(1, textClaveResurtido.getText());
			            cc.setString(2, textClaveProveedor.getText());
			            cc.setString(3, textClaveCafecito.getText());
			        
 
			          
			            
			            ca.execute();
			            cb.execute();
			            cc.execute();


			            
			            con.commit();

//			            claveOrden, now(), numeroMesa, claveCafecito
//			            cb.setInt("claveOrden", Integer.parseInt((textClavePlatillo.getText())));
//			            cb.setInt("numeroMesa", Integer.parseInt((textClavePlatillo.getText())));
//			            cb.setInt("claveCafecito", Integer.parseInt((textClavePlatillo.getText())));
//			            
//			            
//			            numeroDetalle, cantidad, clavePlatillo, precio, claveOrden);
			
//			      
						JOptionPane.showInternalMessageDialog(null, "Resurtido reaizada con exito");

//			            decidi mejor hacerlo con inserts en tablaorden
				
				//parece que ya tengo la sintaxis para calar la llamada del procedimienro em la base
				
				
				
				
				} catch (Exception e1) {

					JOptionPane.showInternalMessageDialog(null, "Hubo un error al realizar el resurtido: " +e1);

				
				}

			}
			
			
		});
		btnNewButton.setForeground(Color.BLUE);
		add(btnNewButton);
		
		JLabel labelClaveOrden = new JLabel("Clave Resurtido ");
		labelClaveOrden.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveOrden.setForeground(Color.BLACK);
		labelClaveOrden.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveOrden.setBounds(0, 88, 166, 42);
		add(labelClaveOrden);
		
		textClaveResurtido = new JTextField();
		textClaveResurtido.setColumns(10);
		textClaveResurtido.setBounds(174, 95, 304, 37);
		add(textClaveResurtido);
		
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
		
		JLabel labelMesaContrato = new JLabel("Proveedor ");
		labelMesaContrato.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesaContrato.setForeground(Color.BLACK);
		labelMesaContrato.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMesaContrato.setBounds(10, 141, 166, 42);
		add(labelMesaContrato);
		
		JComboBox comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setBounds(174, 148, 793, 37);
		add(comboBoxProveedor);
		  ArrayList<String> lista9 = new ArrayList<String>();
	        lista9 = serviceResurtidoImpl.llenar_comboProveedor();
	        for(int i = 0; i<lista9.size();i++){
	        	comboBoxProveedor.addItem(lista9.get(i));
	        }
		

	
		
		JLabel labelPrecio = new JLabel("Producto");
		labelPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecio.setForeground(Color.BLACK);
		labelPrecio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPrecio.setBounds(47, 509, 100, 42);
		add(labelPrecio);
		
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
		
		JLabel labelClavePlatillo = new JLabel("F.Caducidad");
		labelClavePlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelClavePlatillo.setForeground(Color.BLACK);
		labelClavePlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClavePlatillo.setBounds(20, 456, 146, 42);
		add(labelClavePlatillo);
		
		JLabel labelPlatillo = new JLabel("P/U");
		labelPlatillo.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlatillo.setForeground(Color.BLACK);
		labelPlatillo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPlatillo.setBounds(10, 403, 166, 42);
		add(labelPlatillo);
		ArrayList<String> lista7 = new ArrayList<String>();
        lista7 = serviceOrdenImpl.llenar_comboPlatillo();
        for(int i = 0; i<lista7.size();i++){
//        	comboBoxPlatillo.addItem(lista7.get(i));
        }
		
        

	
		textClavePlatillo = new JTextField();
		textClavePlatillo.setColumns(10);
		textFechaCaducidad = new JFormattedTextField("YYYY-MM-DD");
		textFechaCaducidad.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFechaCaducidad.setBounds(174, 463, 304, 37);
		add(textFechaCaducidad);
		
		JLabel lblTotal = new JLabel("Clave Producto ");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblTotal.setBounds(10, 550, 156, 42);
		add(lblTotal);
		
		textClaveProducto = new JTextField();
		textClaveProducto.setColumns(10);
		textClaveProducto.setBounds(174, 563, 304, 37);
		add(textClaveProducto);
		ArrayList<String> lista5 = new ArrayList<String>();
        lista5 = serviceOrdenImpl.llenar_comboEmpleado();
        for(int i = 0; i<lista5.size();i++){
//        	comboBoxContrato.addItem(lista5.get(i));
        }
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(174, 407, 304, 37);
		add(textPrecio);
		
		JComboBox comboBoxProducto = new JComboBox();
		comboBoxProducto.setBounds(174, 516, 793, 37);
		  ArrayList<String> lista3 = new ArrayList<String>();
	        lista3 = servicePlatilloImpl.llenar_comboInsumo();
	        for(int i = 0; i<lista3.size();i++){
	        	comboBoxProducto.addItem(lista3.get(i));
	        }
		add(comboBoxProducto);

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
	