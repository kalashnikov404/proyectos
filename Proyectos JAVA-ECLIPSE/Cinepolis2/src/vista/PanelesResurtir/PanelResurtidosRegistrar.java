package vista.PanelesResurtir;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import servicios.ServiceBoletoImpl;
import servicios.ServiceResurtidoImpl;
import utilidades.IOFile;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelResurtidosRegistrar extends JPanel {
	private static JTextField cajaNombre;
	private static JTextField cajaDuracion;
	private static JTextField cajaClasificacion;
	private static JTextField cajaC;
	private static JTextField cajaSucursal;

	
//	
//	public static JTextField getCajaPrecio() {
//		return cajaPrecio;
//	}
//
//
//
//	public static void setCajaPrecio(JTextField cajaPrecio) {
//		PanelResurtidosRegistrar.cajaPrecio = cajaPrecio;
//	}
//


	public static JTextField getC() {
		return c;
	}



	public static void setC(JTextField c) {
		PanelResurtidosRegistrar.c = c;
	}



	public int getPerro() {
		return perro;
	}



	public void setPerro(int perro) {
		this.perro = perro;
	}



	public String getPps2() {
		return pps2;
	}



	public void setPps2(String pps2) {
		this.pps2 = pps2;
	}



	public ServiceResurtidoImpl getServiceResurtidoImpl() {
		return serviceResurtidoImpl;
	}



	public void setServiceResurtidoImpl(ServiceResurtidoImpl serviceResurtidoImpl) {
		this.serviceResurtidoImpl = serviceResurtidoImpl;
	}



	public JTextField getText() {
		return text;
	}



	public void setText(JTextField text) {
		this.text = text;
	}



	public static JTextField getTextEmpleado() {
		return textEmpleado;
	}



	public static void setTextEmpleado(JTextField textEmpleado) {
		PanelResurtidosRegistrar.textEmpleado = textEmpleado;
	}



	public static JTextField getTextField() {
		return textField;
	}



	public static void setTextField(JTextField textField) {
		PanelResurtidosRegistrar.textField = textField;
	}



	public static JTextField getCajaSucursal() {
		return cajaSucursal;
	}



	public static void setCajaSucursal(JTextField cajaSucursal) {
		PanelResurtidosRegistrar.cajaSucursal = cajaSucursal;
	}



	public static void setComboNombre(JComboBox<String> comboNombre) {
		PanelResurtidosRegistrar.comboNombre = comboNombre;
	}



	public static void setComboPelicula(JComboBox<String> comboPelicula) {
		PanelResurtidosRegistrar.comboPelicula = comboPelicula;
	}



	public static void setComboSala(JComboBox<String> comboSala) {
		PanelResurtidosRegistrar.comboSala = comboSala;
	}



	public static void setComboCantidad(JComboBox<String> comboCantidad) {
		PanelResurtidosRegistrar.comboCantidad = comboCantidad;
	}



	public static void setComboEmpleado(JComboBox<String> comboEmpleado) {
		PanelResurtidosRegistrar.comboEmpleado = comboEmpleado;
	}



	public static void setCajaSala(JTextField cajaSala) {
		PanelResurtidosRegistrar.cajaSala = cajaSala;
	}



	private static JTextField cajaBaja;
	private static JTextField c;

	private static JComboBox<String> comboNombre;
	private static JComboBox<String> comboPelicula;
	
	private static JComboBox<String> comboSala;
	private static JComboBox<String> comboCantidad;
	private static JComboBox<String> comboEmpleado;
	int perro;
	 String pps2;
	
	
	
	
	ServiceResurtidoImpl serviceResurtidoImpl= new ServiceResurtidoImpl();
	private static JTextField cajaSala;
	
	private static JTextField cajaCantidad;
	private static JTextField cajaEmpleado;
	private static JTextField cajaBotana;

	private JTextField text;
	private static JTextField textEmpleado;
	private static JTextField textField;
	private static JTextField cajaProveedor;
	
	
	public static JTextField getCajaProveedor() {
		return cajaProveedor;
	}



	public static void setCajaProveedor(JTextField cajaProveedor) {
		PanelResurtidosRegistrar.cajaProveedor = cajaProveedor;
	}



	public static JComboBox<String> getComboPelicula() {
		return comboPelicula;
	}



	public static JComboBox<String> getComboSala() {
		return comboSala;
	}



	public static JComboBox<String> getComboCantidad() {
		return comboCantidad;
	}



	public static JComboBox<String> getComboEmpleado() {
		return comboEmpleado;
	}

	


	public static JTextField getCajaSala() {
		return cajaSala;
	}





	public static JTextField getCajaCantidad() {
		return cajaCantidad;
	}




	public static JTextField getCajaEmpleado() {
		return cajaEmpleado;
	}

	

	
	
	public static JTextField getCajaNombre() {
		return cajaNombre;
	}



	public static JTextField getCajaDuracion() {
		return cajaDuracion;
	}



	public static JTextField getCajaClasificacion() {
		return cajaClasificacion;
	}



	

	public static JComboBox<String> getComboNombre() {
		return comboNombre;
	}


	
	
	/**
	 * Create the panel.
	 */
	public PanelResurtidosRegistrar() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor");
		lblNewLabel_1.setBounds(0, 0, 225, 75);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_1);

		
//		
//		JComboBox<String> comboEmpleado_1 = new JComboBox();
//		comboEmpleado_1.setFont(new Font("Impact", Font.PLAIN, 25));
//		comboEmpleado_1.setBounds(225, 0, 350, 75);
//		add(comboEmpleado_1);
		
	
		final JComboBox comboProveedor= new JComboBox();
		comboProveedor.setBounds(225, 0, 350, 75);
		comboProveedor.addItem("Seleccione una opcion");

		

	        ArrayList<String> lista7 = new ArrayList<String>();
	        lista7 = serviceResurtidoImpl.llenar_comboProveedor();
	        for(int i = 0; i<lista7.size();i++){

	        	comboProveedor.addItem(lista7.get(i));
	        }

	        comboProveedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					int monthnumber=comboProveedor.getSelectedIndex();
					

					cajaProveedor.setText(String.valueOf(monthnumber));				
				}
			});
	           
	        
	        comboProveedor.getSelectedIndex()		;
	        comboProveedor.setFont(new Font("Impact", Font.PLAIN, 25));

//		
	        add(comboProveedor);	     
	
	        cajaProveedor = new JTextField();
			cajaProveedor.setBounds(574, 0, 140, 75);
			cajaProveedor.setFont(new Font("Impact", Font.PLAIN, 25));
			add(cajaProveedor);
			cajaProveedor.setColumns(10);
		
//		
//		
//		comboNombre = new JComboBox<>(IOFile.getOpciones("archivos//BoletosPrecios"));
//		comboNombre.setBounds(225, 0, 350, 75);
//		comboNombre.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(comboNombre);
		
		
	
		
		JLabel lblNewLabel_2 = new JLabel("Sucursal");
		lblNewLabel_2.setBounds(0, 75, 225, 75);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_2);
//		
		

		final JComboBox comboSucursal= new JComboBox();
		comboSucursal.setBounds(225, 75, 350, 75);
		comboSucursal.addItem("Seleccione una opcion");

		

	        ArrayList<String> lista8 = new ArrayList<String>();
	        lista8 = serviceResurtidoImpl.llenar_comboSucursal();
	        for(int i = 0; i<lista8.size();i++){

	        	comboSucursal.addItem(lista8.get(i));
	        }

	        comboSucursal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					int monthnumber=comboSucursal.getSelectedIndex();
					

					cajaSucursal.setText(String.valueOf(monthnumber));				
				}
			});
	           
	        
	        comboSucursal.getSelectedIndex()		;
	        comboSucursal.setFont(new Font("Impact", Font.PLAIN, 25));

//		
	        add(comboSucursal);	     
	
	       

        cajaSucursal = new JTextField();
        cajaSucursal.setBounds(574, 75, 140, 75);
        cajaSucursal.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaSucursal);
		cajaSucursal.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(0, 150, 225, 75);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_3);
		
		
		
		

		cajaC = new JTextField();
		cajaC.setBounds(225, 150, 489, 75);
		cajaC.setColumns(10);
		cajaC.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaC);
		
//		final JComboBox comboSala = new JComboBox();
//		comboSala.setBounds(225, 225, 350, 75);
//    	comboSala.addItem("Seleccione una opcion");
//
//		
//
//	        ArrayList<String> lista7 = new ArrayList<String>();
//	        lista7 = serviceBoletoImpl.llenar_comboSala();
//	        for(int i = 0; i<lista7.size();i++){
//
//	        	comboSala.addItem(lista7.get(i));
//	        }
//
//	        comboSala.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
//					
//					int monthnumber=comboSala.getSelectedIndex();
//					
//
//					cajaSala.setText(String.valueOf(monthnumber));				
//				}
//			});
//	        
//	        comboSala.getSelectedIndex()		;
//	        comboSala.setFont(new Font("Impact", Font.PLAIN, 25));
//
//		
//	        add(comboSala);	        
//	
//
//	        cajaSala = new JTextField();
//	        cajaSala.setBounds(574, 225, 140, 75);
//	        cajaSala.setFont(new Font("Impact", Font.PLAIN, 25));
//
//			add(cajaSala);
//	        cajaSala.setColumns(10);
			

		JLabel lblNewLabel6 = new JLabel("Precio");
		lblNewLabel6.setBounds(0, 225, 225, 75);
		lblNewLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel6.setForeground(new Color(30, 144, 255));
		lblNewLabel6.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel6);
		
		cajaCantidad = new JTextField();
		cajaCantidad.setBounds(225, 225, 489, 75);
		cajaCantidad.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaCantidad);
		cajaCantidad.setColumns(10);
		
		


		JLabel lblNewLabel7 = new JLabel("Botana");
		lblNewLabel7.setBounds(0, 298, 225, 75);
		lblNewLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel7.setForeground(new Color(30, 144, 255));
		lblNewLabel7.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel7);
		
		


//
//		
//		comboEmpleado = new JComboBox<>(IOFile.getOpciones("archivos//BoletosEmpleado"));
//		
//
//		comboEmpleado.setBounds(225, 375, 350, 75);
//		comboEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(comboEmpleado);
		
		final JComboBox comboEmpleado = new JComboBox();
		comboEmpleado.setBounds(225, 372, 350, 75);
		comboEmpleado.addItem("Seleccione una opcion");

		

        ArrayList<String> lista4 = new ArrayList<String>();
        lista4 = serviceResurtidoImpl.llenar_comboResurtido();
        for(int i = 0; i<lista4.size();i++){

        	comboEmpleado.addItem(lista4.get(i));

        }
		
//		String[] options = {"Seleccione una opcion", "1-Rodrigo Blancas" , "2-Rigo"};
//		  final JComboBox optionsCombo = new JComboBox(options);
		comboEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int monthnumber=comboEmpleado.getSelectedIndex();
				

cajaEmpleado.setText(String.valueOf(monthnumber));				
			}
		});







		comboEmpleado.getSelectedIndex()		;
comboEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));

		
		
		add(comboEmpleado);
		
		
		cajaEmpleado = new JTextField();
		cajaEmpleado.setBounds(574, 372, 140, 75);
		
		cajaEmpleado.setColumns(10);
		cajaEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));

		add(cajaEmpleado);
		
	
	
	
		

		JLabel lblNewLabel8 = new JLabel("Resurtido");
		lblNewLabel8.setBounds(0, 372, 225, 75);
		lblNewLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel8.setForeground(new Color(30, 144, 255));
		lblNewLabel8.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel8);


		final JComboBox comboBotana = new JComboBox();
		comboBotana.setBounds(225, 298, 350, 75);
		comboBotana.addItem("Seleccione una opcion");

		

        ArrayList<String> lista5 = new ArrayList<String>();
        lista5 = serviceResurtidoImpl.llenar_comboBotana();
        for(int i = 0; i<lista5.size();i++){

        	comboBotana.addItem(lista5.get(i));

        }
		
//		String[] options = {"Seleccione una opcion", "1-Rodrigo Blancas" , "2-Rigo"};
//		  final JComboBox optionsCombo = new JComboBox(options);
        comboBotana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int monthnumber=comboBotana.getSelectedIndex();
				

				cajaBotana.setText(String.valueOf(monthnumber));				
			}
		});


		comboBotana.getSelectedIndex()		;
		comboBotana.setFont(new Font("Impact", Font.PLAIN, 25));

		
		
		add(comboBotana);
		
	
		
		
		
		cajaBotana = new JTextField();
		cajaBotana.setBounds(574, 298, 140, 75);
		
		cajaBotana.setColumns(10);
		cajaBotana.setFont(new Font("Impact", Font.PLAIN, 25));

		add(cajaBotana);
		
		
		
		
		
	
//	{
// combobox.setText(String.valueOf(combobox.getSelectedIndex())));
//
//	}
//}
 
 
		
//		
//		JComboBox comboEmpleado = new JComboBox();
//		
//		
//		comboEmpleado.setBounds(225, 375, 350, 75);
//		comboEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));
//
//        ArrayList<String> lista4 = new ArrayList<String>();
//        lista4 = serviceBoletoImpl.llenar_comboEmpleado();
//        for(int i = 0; i<lista4.size();i++){
//        	comboEmpleado.addItem(lista4.get(i));
//        }
//		add(comboEmpleado);

		

		
		
//		cajaEmpleado = new JTextField();
//		cajaEmpleado.setBounds(225, 375, 350, 75);
//		cajaEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(cajaEmpleado);
//		cajaEmpleado.setColumns(10);
		
		
		
//
//		------------+-------------+------+-----+---------+----------------+
//		| cve_bol    | int         | NO   | PRI | NULL    | auto_increment |
//		| fecha_bol  | date        | NO   |     | NULL    |                |
//		| precio_bol | float(6,2)  | NO   |     | NULL    |                |
//		| tipo_bol   | varchar(30) | NO   |     | NULL    |                |
//		| cve_pel    | int         | NO   | MUL | NULL    |                |
//		| cve_sal    |
//		
//		
//		cve_ventabol      | int  | NO   | PRI | NULL    | auto_increment |
//		| cantidad_ventabol | int  | NO   |     | NULL    |                |
//		| cve_bol           | int  | NO   | MUL | NULL    |                |
//		| num_empta
//		
		
		
	}



	public static JTextField getCajaC() {
		return cajaC;
	}



	public static void setCajaC(JTextField cajaC) {
		PanelResurtidosRegistrar.cajaC = cajaC;
	}



	public static JTextField getCajaBaja() {
		return cajaBaja;
	}



	public static void setCajaBaja(JTextField cajaBaja) {
		PanelResurtidosRegistrar.cajaBaja = cajaBaja;
	}



	public static JTextField getCajaBotana() {
		return cajaBotana;
	}



	public static void setCajaBotana(JTextField cajaBotana) {
		PanelResurtidosRegistrar.cajaBotana = cajaBotana;
	}



	public static void setCajaNombre(JTextField cajaNombre) {
		PanelResurtidosRegistrar.cajaNombre = cajaNombre;
	}



	public static void setCajaDuracion(JTextField cajaDuracion) {
		PanelResurtidosRegistrar.cajaDuracion = cajaDuracion;
	}



	public static void setCajaClasificacion(JTextField cajaClasificacion) {
		PanelResurtidosRegistrar.cajaClasificacion = cajaClasificacion;
	}



	public static void setCajaCantidad(JTextField cajaCantidad) {
		PanelResurtidosRegistrar.cajaCantidad = cajaCantidad;
	}



	public static void setCajaEmpleado(JTextField cajaEmpleado) {
		PanelResurtidosRegistrar.cajaEmpleado = cajaEmpleado;
	}
	
//	public boolean estanVaciosBoletos() {
//
//		
//		
//		return cajaNombre.getText().isEmpty()||cajaDuracion.getText().isEmpty()||cajaClasificacion.getText().isEmpty()||comboGenero.getSelectedItem().equals("Seleccione una opción")
//			||cajaSala.getText().isEmpty()||cajaCantidad.getText().isEmpty()||cajaEmpleado.getText().isEmpty();
//	}
//	public void vaciarCajasBoletos() {
//		comboNombre.setSelectedItem("Seleccione una opción");
//		cajaDuracion.setText("");
//		comboGenero.setSelectedItem("Seleccione una opción");
//		cajaSala.setText("");
//		cajaCantidad.setText("");
//		cajaEmpleado.setText("");
//		
//		
//		
//
//	}	
}
