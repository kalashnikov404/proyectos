package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceCafecito;
import api.ServiceEmpleado;
import api.ServiceInsumo;
import excepciones.ConexionException;
import modelo.Cafecito;
import modelo.Empleado;
import modelo.Insumo;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaInsumos extends JPanel {

	private JTable table;
	private ServiceInsumo serviceInsumo;
	private javax.swing.JComboBox cbConjuntoDatos;
	private javax.swing.JComboBox cbDatos;
	private JTextField textClave, textCalle, textNumero,textOrientacion,textColonia, textAsentamiento,textZona, textCodigoPostal,textCiudad, textMunicipio, textEstado, tfAño, tfMarca, tfCelular, tfCorreo, tfEspacio;
	JDateChooser dateChooser;
	private JSpinner jSpinner1, jSpinner2;
	private SpinnerModel sm, sm2;
	
	public List<Insumo> insumos;
	

	public ConsultaInsumos() {



		serviceInsumo= new ServiceInsumoImpl();

		dateChooser = new JDateChooser();
		Date date = new Date();
		sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		
		Date date2 = new Date();
		sm2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
		
		cbConjuntoDatos = new javax.swing.JComboBox();
		cbConjuntoDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbConjuntoDatos.setBounds(32, 6, 350, 62);
		cbDatos = new javax.swing.JComboBox();
		cbDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDatos.setBounds(387, 6, 150, 62);

		cbConjuntoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿A partir de que deseas consultar los insumos?", "Datos del insumo", "Datos minimos y maximos"}));
		cbConjuntoDatos.setPreferredSize(new java.awt.Dimension(380, 20));
		cbConjuntoDatos.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbConjuntoDatosItemStateChanged(evt);
		
		
				
			}
		});
		add(cbConjuntoDatos);

		cbDatos.setPreferredSize(new java.awt.Dimension(150, 20));
		add(cbDatos);

		JButton btnConsultar = new JButton("Seleccionar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnConsultar.setBounds(542, 5, 87, 63);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				removeAll();
				repaint();

				insumos = new ArrayList<>();

				if(cbDatos.getSelectedItem().toString()=="Clave producto") {
					JLabel labelClave = new JLabel("Clave producto: ");
					labelClave.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelClave.setBounds(33, 147, 68, 20);
					add(labelClave);

					textClave = new JTextField();
					textClave.setBounds(111, 147, 130, 26);
					add(textClave);
					textClave.setColumns(10);

					labelClave.setVisible(true);
					textClave.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//							
							insumos=serviceInsumo.consultarPorDatosInsumo(textClave.getText(), "","","","","","");
							buscar(insumos);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Nombre") {
					JLabel labelCalle = new JLabel("Nombre: ");
					labelCalle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelCalle.setBounds(33, 147, 68, 20);
					add(labelCalle);

					textCalle = new JTextField();
					textCalle.setBounds(111, 147, 130, 26);
					add(textCalle);
					textCalle.setColumns(10);

					labelCalle.setVisible(true);
					textCalle.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//						
							insumos=serviceInsumo.consultarPorDatosInsumo("", textCalle.getText(), "","","","","");
							buscar(insumos);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

				}
				if(cbDatos.getSelectedItem().toString()=="Tipo") {
					JLabel labelNumero = new JLabel("Tipo: ");
					labelNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelNumero.setBounds(33, 147, 68, 20);
					add(labelNumero);

					textNumero = new JTextField();
					textNumero.setBounds(111, 147, 130, 26);
					add(textNumero);
					textNumero.setColumns(10);

					labelNumero.setVisible(true);
					textNumero.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//								
//							
							insumos=serviceInsumo.consultarPorDatosInsumo("", "",textNumero.getText(), "","","","");
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Marca") {
					JLabel labelOrientacion = new JLabel("Marca: ");
					labelOrientacion.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelOrientacion.setBounds(33, 147, 68, 20);
					add(labelOrientacion);

					textOrientacion = new JTextField();
					textOrientacion.setBounds(111, 147, 130, 26);
					add(textOrientacion);
					textOrientacion.setColumns(10);

					labelOrientacion.setVisible(true);
					textOrientacion.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
////								
//						
							insumos=serviceInsumo.consultarPorDatosInsumo("", "","",textOrientacion.getText(), "","","");
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
			

				if(cbDatos.getSelectedItem().toString()=="Presentacion") {
					JLabel labelColonia = new JLabel("Presentacion: ");
					labelColonia.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelColonia.setBounds(33, 147, 68, 20);
					add(labelColonia);

					textColonia = new JTextField();
					textColonia.setBounds(111, 147, 130, 26);
					add(textColonia);
					textColonia.setColumns(10);

					labelColonia.setVisible(true);
					textColonia.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//						

							insumos=serviceInsumo.consultarPorDatosInsumo("", "","", "",textColonia.getText(), "","");
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
				if(cbDatos.getSelectedItem().toString()=="Contenido") {
					JLabel labelAsentamiento = new JLabel("Contenido:");
					labelAsentamiento.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelAsentamiento.setBounds(33, 147, 74, 20);
					add(labelAsentamiento);

					textAsentamiento = new JTextField();
					textAsentamiento.setBounds(111, 147, 130, 26);
					add(textAsentamiento);
					textAsentamiento.setColumns(10);

					labelAsentamiento.setVisible(true);
					textAsentamiento.setVisible(true);

					
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//						
							insumos=serviceInsumo.consultarPorDatosInsumo("", "","", "","",textAsentamiento.getText(), "");
							buscar(insumos);
						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					
				}
				if(cbDatos.getSelectedItem().toString()=="U.Medida") {
					JLabel labelZona = new JLabel("U.Medida:");
					labelZona.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelZona.setBounds(33, 147, 46, 20);
					add(labelZona);
					
					textZona = new JTextField();
					textZona.setBounds(111, 147, 130, 26);
					add(textZona);
					textZona.setColumns(10);

					labelZona.setVisible(true);
					textZona.setVisible(true);

					

					
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//							
							insumos=serviceInsumo.consultarPorDatosInsumo("", "","", "","", "", textZona.getText());
							buscar(insumos);

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}


				if(cbDatos.getSelectedItem().toString()=="Existencia") {
					JLabel labelCodigoPostal = new JLabel("Existencia: ");
					labelCodigoPostal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelCodigoPostal.setBounds(33, 147, 68, 20);
					add(labelCodigoPostal);

					textCodigoPostal = new JTextField();
					textCodigoPostal.setBounds(111, 147, 130, 26);
					add(textCodigoPostal);
					textCodigoPostal.setColumns(10);

					labelCodigoPostal.setVisible(true);
					textCodigoPostal.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//							
							insumos=serviceInsumo.consultarPorDatosMinimoMaximo(textCodigoPostal.getText(),"", "","");
							buscar(insumos);

						}});
					add(btnBuscar);
					revalidate();
					repaint();

					
					//
				}
				if(cbDatos.getSelectedItem().toString()=="Minimo") {
					JLabel labelCiudad = new JLabel("Minimo: ");
					labelCiudad.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelCiudad.setBounds(33, 147, 68, 20);
					add(labelCiudad);

					textCiudad = new JTextField();
					textCiudad.setBounds(111, 147, 130, 26);
					add(textCiudad);
					textCiudad.setColumns(10);

					labelCiudad.setVisible(true);
					textCiudad.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insumos=serviceInsumo.consultarPorDatosMinimoMaximo("", textCiudad.getText(),"", "");
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				
				
				if(cbDatos.getSelectedItem().toString()=="Maximo") {
					JLabel labelMunicipio = new JLabel("Maximo: ");
					labelMunicipio.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelMunicipio.setBounds(33, 147, 68, 20);
					add(labelMunicipio);

					textMunicipio = new JTextField();
					textMunicipio.setBounds(111, 147, 130, 26);
					add(textMunicipio);
					textMunicipio.setColumns(10);

					labelMunicipio.setVisible(true);
					textMunicipio.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							insumos=serviceInsumo.consultarPorDatosMinimoMaximo("", "", textMunicipio.getText(),"");
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
				

				if(cbDatos.getSelectedItem().toString()=="Clave cafecito") {
					JLabel labelEstado = new JLabel("Clave cafecito: ");
					labelEstado.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelEstado.setBounds(33, 147, 68, 20);
					add(labelEstado);

					textEstado = new JTextField();
					textEstado.setBounds(111, 147, 130, 26);
					add(textEstado);
					textEstado.setColumns(10);

					labelEstado.setVisible(true);
					textEstado.setVisible(true);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insumos=serviceInsumo.consultarPorDatosMinimoMaximo("", "", "", textEstado.getText());
							buscar(insumos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				
				
				
				
			}
		});
		add(btnConsultar);

	}



	private void cbConjuntoDatosItemStateChanged(java.awt.event.ItemEvent evt) {
		if(evt.getStateChange() == ItemEvent.SELECTED){
			if(cbConjuntoDatos.getSelectedIndex()>0){
				cbDatos.setPreferredSize(new java.awt.Dimension(200, 20));
				cbDatos.setModel(new DefaultComboBoxModel(getDatos(cbConjuntoDatos.getSelectedItem().toString())));
			}
		}
	}


	public String[] getDatos(String conjuntoDatos){
		String[] datos = null;
		if(conjuntoDatos.equalsIgnoreCase("Datos del insumo")){
			datos = new String[8];

			datos[0] = "Buscar por:";
			datos[1] = "Clave producto";
			datos[2] = "Nombre";
			datos[3] = "Tipo";
			datos[4] = "Marca";
			datos[5] = "Presentacion";
			datos[6] = "Contenido";
			datos[7] = "U.Medida";
		
	
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos minimos y maximos")){
			datos = new String[5];

			datos[0] = "Buscar por:";
			datos[1] = "Existencia";
			datos[2] = "Minimo";
			datos[3] = "Maximo";
			datos[4] = "Clave cafecito";
			
			


			
		}

	
		
		return datos;
	}
	
	public void buscar(List<Insumo> insumos){
		
		if(insumos.size()>0) {
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"Clave producto", "Nombre", "Tipo", "Marca", "Presentacion", "Contenido", "U.Medida", "Existencia", "Minimo", "Maximo", "Clave cafecito"};


		String data[][] = new String[insumos.size()][11];


		
		for(int i=0; i<insumos.size(); i++) {

//		
//			private int claveProducto;
//			private String nombre;
//			private String tipo;
//			private String marca;
//			private String presentacion;
//			private String contenido;
//			private String umedia;
//			
//		//tabla minmax
//			private int existencia;
//			private int minimo;
//			private int maximo;
//			private int claveProducto2;
//			private int claveCafecito;
//			
			
			data[i][0]=String.valueOf(insumos.get(i).getClaveProducto());
			
			data[i][1]=insumos.get(i).getNombre();
			data[i][2]=insumos.get(i).getTipo();
			data[i][3]=insumos.get(i).getMarca();
			data[i][4]=insumos.get(i).getPresentacion();
			data[i][5]=insumos.get(i).getContenido();
			data[i][6]=insumos.get(i).getUmedia();
			
			data[i][7]=	String.valueOf(insumos.get(i).getExistencia());
			data[i][8]=	String.valueOf(insumos.get(i).getMinimo());
			data[i][9]=	String.valueOf(insumos.get(i).getMaximo());
			data[i][10]=	String.valueOf(insumos.get(i).getClaveCafecito());
	
			
	
			//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setPreferredWidth(80);
		

		add(table);

		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 500, 1430, 200);
		add(scrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setVisible(true);
		repaint();
		revalidate();
		
		
		}else {
			JOptionPane.showMessageDialog(null, "No se encontraron registros, intenta de nuevo");
		}
	} 
		

}

