package vista.PanelesBoletos;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import modelo.Boleto;
import modelo.Persona;
import servicios.ServiceBoletoImpl;
import utilidades.IOFile;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBoletosRegistrar extends JPanel {
	private static JTextField cajaNombre;
	private static JTextField cajaDuracion;
	private static JTextField cajaClasificacion;
	
	private static JTextField cajaPrecio;
	private static JTextField cajaTipo;



	
	public static JTextField getCajaPrecio() {
		return cajaPrecio;
	}



	public static void setCajaPrecio(JTextField cajaPrecio) {
		PanelBoletosRegistrar.cajaPrecio = cajaPrecio;
	}



	public static JTextField getCajaTipo() {
		return cajaTipo;
	}



	public static void setCajaTipo(JTextField cajaTipo) {
		PanelBoletosRegistrar.cajaTipo = cajaTipo;
	}

	private static JComboBox<String> comboGenero;
	private static JComboBox<String> comboNombre;
	private static JComboBox<String> comboPelicula;
	
	private static JComboBox<String> comboSala;
	private static JComboBox<String> comboCantidad;
	private static JComboBox<String> comboEmpleado;
	int perro;
	 String pps2;
	
	
	
	
	ServiceBoletoImpl serviceBoletoImpl= new ServiceBoletoImpl();

	
	
	private static JTextField cajaPelicula;
	private static JTextField cajaSala;
	
	private static JTextField cajaCantidad;
	private static JTextField cajaEmpleado;
	private JTextField text;
	private JTextField textEmpleado;
	private JTextField textField;

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

	public static JTextField getCajaPelicula() {
		return cajaPelicula;
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



	public static JComboBox<String> getComboGenero() {
		return comboGenero;
	}


	public static JComboBox<String> getComboNombre() {
		return comboNombre;
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



	public ServiceBoletoImpl getServiceBoletoImpl() {
		return serviceBoletoImpl;
	}



	public void setServiceBoletoImpl(ServiceBoletoImpl serviceBoletoImpl) {
		this.serviceBoletoImpl = serviceBoletoImpl;
	}



	public JTextField getText() {
		return text;
	}



	public void setText(JTextField text) {
		this.text = text;
	}



	public JTextField getTextEmpleado() {
		return textEmpleado;
	}



	public void setTextEmpleado(JTextField textEmpleado) {
		this.textEmpleado = textEmpleado;
	}



	public JTextField getTextField() {
		return textField;
	}



	public void setTextField(JTextField textField) {
		this.textField = textField;
	}



	public static JComboBox<String> getComboPrecio() {
		return comboPrecio;
	}



	public static void setComboPrecio(JComboBox<String> comboPrecio) {
		PanelBoletosRegistrar.comboPrecio = comboPrecio;
	}



	public static JComboBox<String> getComboTipo() {
		return comboTipo;
	}



	public static void setComboTipo(JComboBox<String> comboTipo) {
		PanelBoletosRegistrar.comboTipo = comboTipo;
	}



	public static void setCajaNombre(JTextField cajaNombre) {
		PanelBoletosRegistrar.cajaNombre = cajaNombre;
	}



	public static void setCajaDuracion(JTextField cajaDuracion) {
		PanelBoletosRegistrar.cajaDuracion = cajaDuracion;
	}



	public static void setCajaClasificacion(JTextField cajaClasificacion) {
		PanelBoletosRegistrar.cajaClasificacion = cajaClasificacion;
	}



	public static void setComboGenero(JComboBox<String> comboGenero) {
		PanelBoletosRegistrar.comboGenero = comboGenero;
	}



	public static void setComboNombre(JComboBox<String> comboNombre) {
		PanelBoletosRegistrar.comboNombre = comboNombre;
	}



	public static void setComboPelicula(JComboBox<String> comboPelicula) {
		PanelBoletosRegistrar.comboPelicula = comboPelicula;
	}



	public static void setComboSala(JComboBox<String> comboSala) {
		PanelBoletosRegistrar.comboSala = comboSala;
	}



	public static void setComboCantidad(JComboBox<String> comboCantidad) {
		PanelBoletosRegistrar.comboCantidad = comboCantidad;
	}



	public static void setComboEmpleado(JComboBox<String> comboEmpleado) {
		PanelBoletosRegistrar.comboEmpleado = comboEmpleado;
	}



	public static void setCajaPelicula(JTextField cajaPelicula) {
		PanelBoletosRegistrar.cajaPelicula = cajaPelicula;
	}



	public static void setCajaSala(JTextField cajaSala) {
		PanelBoletosRegistrar.cajaSala = cajaSala;
	}



	public static void setCajaCantidad(JTextField cajaCantidad) {
		PanelBoletosRegistrar.cajaCantidad = cajaCantidad;
	}



	public static void setCajaEmpleado(JTextField cajaEmpleado) {
		PanelBoletosRegistrar.cajaEmpleado = cajaEmpleado;
	}

	private static JComboBox<String> comboPrecio;
	private static JComboBox<String> comboTipo;
	private JTextField textField_1;
	private JTextField textField_2;


	
	
	/**
	 * Create the panel.
	 */
	public PanelBoletosRegistrar() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(0, 0, 225, 75);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_1);


		

		
		final	JComboBox comboPrecio = new JComboBox();
		comboPrecio.setBounds(225, 0, 350, 75);
		comboPrecio.addItem("Seleccione una opcion");
		comboPrecio.addItem("30");
		comboPrecio.addItem("50");
		comboPrecio.addItem("40");


		
        ArrayList<String> lista33 = new ArrayList<String>();
        lista33 = serviceBoletoImpl.llenar_comboPrecio();
        for(int i = 0; i<lista33.size();i++){

        }
        comboPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String variable3 = (String) comboPrecio.getSelectedItem();
				
				cajaPrecio.setText(String.valueOf(variable3));			


			}
		});
        
        comboPrecio.getSelectedIndex()		;
        comboPrecio.setFont(new Font("Impact", Font.PLAIN, 25));

	
        add(comboPrecio);
		
		
    	
        cajaPrecio = new JTextField();
        cajaPrecio.setFont(new Font("Impact", Font.PLAIN, 25));
        cajaPrecio.setColumns(10);
        cajaPrecio.setBounds(574, 0, 140, 75);
		add(cajaPrecio);
		
		
		
		
	
		
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(0, 75, 225, 75);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_2);
//		
		
		
		
		
		
		
		final	JComboBox comboTipo = new JComboBox();
		comboTipo.setBounds(225, 75, 350, 75);
		comboTipo.addItem("Seleccione una opcion");
		comboTipo.addItem("Infantil");
		comboTipo.addItem("Adulto");
		comboTipo.addItem("3 Edad - Discapacitado");
		
		
		
		
        ArrayList<String> lista333 = new ArrayList<String>();
        for(int i = 0; i<lista333.size();i++){

        }
        comboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String variable2 = (String) comboTipo.getSelectedItem();
				

		



				cajaTipo.setText(String.valueOf(variable2));			
				
				
			}
		});
        
        comboTipo.getSelectedIndex()		;
        comboTipo.setFont(new Font("Impact", Font.PLAIN, 25));

	
        add(comboTipo);
		
		
        cajaTipo = new JTextField();
        cajaTipo.setFont(new Font("Impact", Font.PLAIN, 25));
        cajaTipo.setColumns(10);
        cajaTipo.setBounds(574, 75, 140, 75);
		add(cajaTipo);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Pelicula");
		lblNewLabel_3.setBounds(0, 150, 225, 75);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_3);
		
		
		
		
		
		
		
		final	JComboBox comboDuracion = new JComboBox();
		comboDuracion.setBounds(225, 150, 350, 75);
    	comboDuracion.addItem("Seleccione una opcion");

		
        ArrayList<String> lista3 = new ArrayList<String>();
        lista3 = serviceBoletoImpl.llenar_comboPelicula();
        for(int i = 0; i<lista3.size();i++){

        	comboDuracion.addItem(lista3.get(i));
        }
        comboDuracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int monthnumber=comboDuracion.getSelectedIndex();
				

				cajaPelicula.setText(String.valueOf(monthnumber));				
			}
		});
        
        comboDuracion.getSelectedIndex()		;
        comboDuracion.setFont(new Font("Impact", Font.PLAIN, 25));

	
        add(comboDuracion);	        
//		
//		
//		
//		comboPelicula = new JComboBox<>(IOFile.getOpciones("archivos//BoletosPeliculas"));
//		comboPelicula.setBounds(225, 150, 350, 75);
//		comboPelicula.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(comboPelicula);
		
		
		cajaPelicula = new JTextField();
		cajaPelicula.setBounds(574, 150, 140, 75);
		cajaPelicula.setColumns(10);
		cajaPelicula.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaPelicula);
		
		
		
		
//		
//		
//	JComboBox comboDuracion = new JComboBox();
//		
//		
//	comboDuracion.setBounds(225, 150, 350, 75);
//	comboDuracion.setFont(new Font("Impact", Font.PLAIN, 25));
//
//        ArrayList<String> lista3 = new ArrayList<String>();
//        lista3 = serviceBoletoImpl.llenar_comboPelicula();
//        for(int i = 0; i<lista3.size();i++){
//        	comboDuracion.addItem(lista3.get(i));
//        }
//		add(comboDuracion);

		
		
		
		
//		
//		
//		cajaDuracion = new JTextField();
//		cajaDuracion.setBounds(225, 150, 350, 75);
//		cajaDuracion.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(cajaDuracion);
//		cajaDuracion.setColumns(10);
		
		
		JLabel lblNewLabel5 = new JLabel("Sala");
		lblNewLabel5.setBounds(0, 225, 225, 75);
		lblNewLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel5.setForeground(new Color(30, 144, 255));
		lblNewLabel5.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel5);
		
		
		
		


//		
//		comboSala = new JComboBox<>(IOFile.getOpciones("archivos//BoletoSala"));
//		comboSala.setBounds(225, 225, 350, 75);
//		comboSala.setFont(new Font("Impact", Font.PLAIN, 25));
//		add(comboSala);
//		
		
		final JComboBox comboSala = new JComboBox();
		comboSala.setBounds(225, 225, 350, 75);
    	comboSala.addItem("Seleccione una opcion");

		

	        ArrayList<String> lista7 = new ArrayList<String>();
	        lista7 = serviceBoletoImpl.llenar_comboSala();
	        for(int i = 0; i<lista7.size();i++){

	        	comboSala.addItem(lista7.get(i));
	        }

	        comboSala.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					int monthnumber=comboSala.getSelectedIndex();
					

					cajaSala.setText(String.valueOf(monthnumber));				
				}
			});
	        
	        comboSala.getSelectedIndex()		;
	        comboSala.setFont(new Font("Impact", Font.PLAIN, 25));

		
	        add(comboSala);	        
	

	        cajaSala = new JTextField();
	        cajaSala.setBounds(574, 225, 140, 75);
	        cajaSala.setFont(new Font("Impact", Font.PLAIN, 25));

			add(cajaSala);
	        cajaSala.setColumns(10);
			

		JLabel lblNewLabel6 = new JLabel("Cantidad");
		lblNewLabel6.setBounds(0, 300, 225, 75);
		lblNewLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel6.setForeground(new Color(30, 144, 255));
		lblNewLabel6.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel6);
		
		cajaCantidad = new JTextField();
		cajaCantidad.setBounds(225, 300, 489, 75);
		cajaCantidad.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaCantidad);
		cajaCantidad.setColumns(10);
		
		


		JLabel lblNewLabel7 = new JLabel("Empleado");
		lblNewLabel7.setBounds(0, 375, 225, 75);
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
		comboEmpleado.setBounds(225, 375, 350, 75);
		comboEmpleado.addItem("Seleccione una opcion");

		

        ArrayList<String> lista4 = new ArrayList<String>();
        lista4 = serviceBoletoImpl.llenar_comboEmpleado();
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
		cajaEmpleado.setBounds(574, 375, 140, 75);
		
		cajaEmpleado.setColumns(10);
		cajaEmpleado.setFont(new Font("Impact", Font.PLAIN, 25));

		add(cajaEmpleado);
	
	
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
	
	public boolean estanVaciosBoletos() {

		
		
		return cajaNombre.getText().isEmpty()||cajaDuracion.getText().isEmpty()||cajaClasificacion.getText().isEmpty()||comboGenero.getSelectedItem().equals("Seleccione una opción")
			||cajaSala.getText().isEmpty()||cajaCantidad.getText().isEmpty()||cajaEmpleado.getText().isEmpty();
	}
	public void vaciarCajasBoletos() {
		comboNombre.setSelectedItem("Seleccione una opción");
		cajaDuracion.setText("");
		comboGenero.setSelectedItem("Seleccione una opción");
		cajaSala.setText("");
		cajaCantidad.setText("");
		cajaEmpleado.setText("");
		
		
		
	}
}