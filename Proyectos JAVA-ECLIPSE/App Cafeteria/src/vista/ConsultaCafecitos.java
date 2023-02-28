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
import excepciones.ConexionException;
import modelo.Cafecito;
import servicios.ServiceCafecitoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCafecitos extends JPanel {

	private JTable table;
	private ServiceCafecito serviceCafecito;
	private javax.swing.JComboBox cbConjuntoDatos;
	private javax.swing.JComboBox cbDatos;
	private JTextField textClave, textCalle, textNumero,textOrientacion,textColonia, textAsentamiento,textZona, textCodigoPostal,textCiudad, textMunicipio, textEstado, tfAño, tfMarca, tfCelular, tfCorreo, tfEspacio;
	JDateChooser dateChooser;
	private JSpinner jSpinner1, jSpinner2;
	private SpinnerModel sm, sm2;
	
	public List<Cafecito> cafecitos;
	

	public ConsultaCafecitos() {



		serviceCafecito = new ServiceCafecitoImpl();

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

		cbConjuntoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿A partir de que deseas consultar al cafecito?", "Datos cafecito", "Datos colonia", "Codigo Postal", "Datos ciudad", "Estado" }));
		cbConjuntoDatos.setPreferredSize(new java.awt.Dimension(350, 20));
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
//
				cafecitos = new ArrayList<>();

				if(cbDatos.getSelectedItem().toString()=="Clave") {
					JLabel labelClave = new JLabel("Clave: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCafecito(textClave.getText(), "", "", "");
								buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Calle") {
					JLabel labelCalle = new JLabel("Calle: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCafecito("",textCalle.getText() , "", "");
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Numero") {
					JLabel labelNumero = new JLabel("Numero: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCafecito("", "", textNumero.getText(),  "");
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Orientacion") {
					JLabel labelOrientacion = new JLabel("Orientacion: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCafecito("", "", "", textOrientacion.getText());
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Colonia") {
					JLabel labelColonia = new JLabel("Colonia: ");
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
							cafecitos=serviceCafecito.consultarPorDatosColonia(textColonia.getText(),"", "");
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
				if(cbDatos.getSelectedItem().toString()=="Asentamiento") {
					JLabel labelAsentamiento = new JLabel("Asentamiento:");
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
							cafecitos=serviceCafecito.consultarPorDatosColonia("", textAsentamiento.getText(),"");

							buscar(cafecitos);

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Zona") {
					JLabel labelZona = new JLabel("Zona:");
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
							cafecitos=serviceCafecito.consultarPorDatosColonia("", "",textZona.getText());

							buscar(cafecitos);

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}


				if(cbDatos.getSelectedItem().toString()=="CP") {
					JLabel labelCodigoPostal = new JLabel("CP: ");
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
							cafecitos=serviceCafecito.consultarPorCP(textCodigoPostal.getText());
							buscar(cafecitos);

						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Ciudad") {
					JLabel labelCiudad = new JLabel("Ciudad: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCiudad(textCiudad.getText(), "");
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				
				
				if(cbDatos.getSelectedItem().toString()=="Municipio") {
					JLabel labelMunicipio = new JLabel("Municipio: ");
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
							cafecitos=serviceCafecito.consultarPorDatosCiudad("",textMunicipio.getText());
							buscar(cafecitos);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				if(cbDatos.getSelectedItem().toString()=="Estado") {
					JLabel labelEstado = new JLabel("Estado: ");
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
							cafecitos=serviceCafecito.consultarPorDatosEstado(textEstado.getText());
							buscar(cafecitos);
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
		if(conjuntoDatos.equalsIgnoreCase("Datos cafecito")){
			datos = new String[5];

			datos[0] = "Buscar por:";
			datos[1] = "Clave";
			datos[2] = "Calle";
			datos[3] = "Numero";
			datos[4] = "Orientacion";
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos colonia")){
			datos = new String[4];

			datos[0] = "Buscar por:";
			datos[1] = "Colonia";
			datos[2] = "Asentamiento";
			datos[3] = "Zona";

		}

		if(conjuntoDatos.equalsIgnoreCase("Codigo Postal")){
			datos = new String[2];

			datos[0] = "Buscar por:";
			datos[1] = "CP";
	
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos ciudad")){
			datos = new String[3];

			datos[0] = "Buscar por:";
			datos[1] = "Ciudad";
			datos[2] = "Municipio";
		}
		
		
		if(conjuntoDatos.equalsIgnoreCase("Estado")){
			datos = new String[2];

			datos[0] = "Buscar por:";
			datos[1] = "Estado";
		}
		
		
		return datos;
	}
	
	public void buscar(List<Cafecito> cafecitos){
		
		if(cafecitos.size()>0) {
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

		String data[][] = new String[cafecitos.size()][11];

		for(int i=0; i<cafecitos.size(); i++) {

			data[i][0]=String.valueOf(cafecitos.get(i).getCveCF());
			data[i][1]=cafecitos.get(i).getCalle();
			data[i][2]=String.valueOf(cafecitos.get(i).getNumero());
			data[i][3]=cafecitos.get(i).getOrientacion();
		
		   
			data[i][4]=cafecitos.get(i).getColonia();
			data[i][5]=cafecitos.get(i).getAsentamiento();
			data[i][6]=cafecitos.get(i).getZona();
			
			data[i][7]=String.valueOf(cafecitos.get(i).getCp());

		    data[i][8]=cafecitos.get(i).getCiudad();
			data[i][9]=cafecitos.get(i).getMunicipio();
				
			data[i][10]=cafecitos.get(i).getEstado();
		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		table.setModel(new DefaultTableModel(data, nombreColunas));

		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(120);
		table.getColumnModel().getColumn(9).setPreferredWidth(120);
		table.getColumnModel().getColumn(10).setPreferredWidth(120);

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
