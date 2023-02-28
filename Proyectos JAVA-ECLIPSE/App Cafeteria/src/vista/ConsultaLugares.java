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
import api.ServiceLugar;
import excepciones.ConexionException;
import modelo.Cafecito;
import modelo.Empleado;
import modelo.Insumo;
import modelo.Lugar;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;
import servicios.ServiceLugarImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaLugares extends JPanel {

	private JTable table;
	private ServiceLugar serviceLugar;
	private javax.swing.JComboBox cbConjuntoDatos;
	private javax.swing.JComboBox cbDatos;
	private JTextField textClave, textCalle, textNumero,textOrientacion,textColonia, textAsentamiento,textZona, textCodigoPostal,textCiudad, textMunicipio, textEstado, tfAño, tfMarca, tfCelular, tfCorreo, tfEspacio;
	JDateChooser dateChooser;
	private JSpinner jSpinner1, jSpinner2;
	private SpinnerModel sm, sm2;
	
	public List<Lugar> lugares;
	

	public ConsultaLugares() {



		serviceLugar= new ServiceLugarImpl();

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

		cbConjuntoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿A partir de que deseas consultar las estancias?", "Datos de la mesa", "Datos del cafecito", "Datos del contrato"}));
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

				lugares = new ArrayList<>();

				if(cbDatos.getSelectedItem().toString()=="Clave Mesa") {
					JLabel labelClave = new JLabel("Clave Mesa: ");
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
							lugares=serviceLugar.consultarPorDatosMesa(textClave.getText(), "");
							buscar(lugares);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Capacidad") {
					JLabel labelCalle = new JLabel("Capacidad: ");
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
							lugares=serviceLugar.consultarPorDatosMesa("", textCalle.getText());
							buscar(lugares);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

				}
				if(cbDatos.getSelectedItem().toString()=="Numero Mesa-Cafecito") {
					JLabel labelNumero = new JLabel("Numero Mesa-Cafecito: ");
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
							lugares=serviceLugar.consultarPorDatosMesaCafecito(textNumero.getText(), "", "");
							buscar(lugares);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Ubicacion") {
					JLabel labelOrientacion = new JLabel("Ubicacion: ");
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
							lugares=serviceLugar.consultarPorDatosMesaCafecito("", textOrientacion.getText(), "");
							buscar(lugares);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
			

				if(cbDatos.getSelectedItem().toString()=="Clave Cafecito") {
					JLabel labelColonia = new JLabel("Clave Cafecito: ");
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
							lugares=serviceLugar.consultarPorDatosMesaCafecito("", "", textColonia.getText());
							buscar(lugares);
							
						}}); 
	
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
				if(cbDatos.getSelectedItem().toString()=="Numero Mesa-Contrato") {
					JLabel labelAsentamiento = new JLabel("Numero Mesa-Contrato:");
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
							
							lugares=serviceLugar.consultarPorDatosMesaContrato(textAsentamiento.getText(), "", "");
							buscar(lugares);
						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					
				}
				if(cbDatos.getSelectedItem().toString()=="Fecha") {
					JLabel labelZona = new JLabel("Fecha:");
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
							lugares=serviceLugar.consultarPorDatosMesaContrato("", textZona.getText(), "");
							buscar(lugares);

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				if(cbDatos.getSelectedItem().toString()=="Folio") {
					JLabel labelZona = new JLabel("Folio:");
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
							lugares=serviceLugar.consultarPorDatosMesaContrato("", "", textZona.getText());
							buscar(lugares);

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
		if(conjuntoDatos.equalsIgnoreCase("Datos de la mesa")){
			datos = new String[3];

			datos[0] = "Buscar por:";
			datos[1] = "Clave Mesa";
			datos[2] = "Capacidad";
		
	
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos del cafecito")){
			datos = new String[4];

			datos[0] = "Buscar por:";
			datos[1] = "Numero Mesa-Cafecito";
			datos[2] = "Ubicacion";
			datos[3] = "Clave Cafecito";

			
		
			
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos del contrato")){
			datos = new String[4];

			datos[0] = "Buscar por:";
			datos[1] = "Numero Mesa-Contrato";
			datos[2] = "Fecha";
			datos[3] = "Folio";
			
	

			
		}
	
		
		return datos;
	}
	
	public void buscar(List<Lugar> lugares){
		
		if(lugares.size()>0) {
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"ID", "Capacidad", "Numero", "Ubicacion", "Clave cafecito", "ID.MesCon", "Fecha", "Folio"};


		String data[][] = new String[lugares.size()][8];


		
		for(int i=0; i<lugares.size(); i++) {

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
			
			data[i][0]=String.valueOf(lugares.get(i).getClaveMesa());
			data[i][1]=String.valueOf(lugares.get(i).getCapacidad());

			data[i][2]=String.valueOf(lugares.get(i).getNumeroMesa());

			
			data[i][3]=lugares.get(i).getUbicacion();
			data[i][4]=String.valueOf(lugares.get(i).getClaveCafecito());
			data[i][5]=String.valueOf(lugares.get(i).getMesaContrato());
			data[i][6]=lugares.get(i).getFecha();
			data[i][7]=String.valueOf(lugares.get(i).getFolio());

			
	
//			lugar.setClaveMesa(rs.getInt("cve_mes"));
//			lugar.setCapacidad(rs.getInt("capacidad_mes"));
//			
//		
//			lugar.setNumeroMesa(rs.getInt("num_mescaf"));
//			lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
//			lugar.setClaveCafecito(rs.getInt("cve_caf"));
//			
//			lugar.setMesaContrato(rs.getInt("num_mescon"));
//			lugar.setFecha(rs.getString("fecha_mescon"));
//			lugar.setFolio(rs.getInt("folio_con"));


	
			//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
	

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

