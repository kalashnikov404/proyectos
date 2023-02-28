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
import excepciones.ConexionException;
import modelo.Cafecito;
import modelo.Empleado;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEmpleados extends JPanel {

	private JTable table;
	private ServiceEmpleado serviceEmpleado;
	private javax.swing.JComboBox cbConjuntoDatos;
	private javax.swing.JComboBox cbDatos;
	private JTextField textClave, textCalle, textNumero,textOrientacion,textColonia, textAsentamiento,textZona, textCodigoPostal,textCiudad, textMunicipio, textEstado, tfAño, tfMarca, tfCelular, tfCorreo, tfEspacio;
	JDateChooser dateChooser;
	private JSpinner jSpinner1, jSpinner2;
	private SpinnerModel sm, sm2;
	
	public List<Empleado> empleados;
	

	public ConsultaEmpleados() {



		serviceEmpleado= new ServiceEmpleadoImpl();

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

		cbConjuntoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿A partir de que deseas consultar al empleado?", "Datos personales", "Datos del contrato"}));
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
//
				empleados = new ArrayList<>();

				if(cbDatos.getSelectedItem().toString()=="ID") {
					JLabel labelClave = new JLabel("ID: ");
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
							empleados=serviceEmpleado.consultarPorDatosPersona(textClave.getText(), "","","","","","","","" , "", "");
							buscar(empleados);
							
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
							empleados=serviceEmpleado.consultarPorDatosPersona("", textCalle.getText(),"","","","","","","" , "", "");
							buscar(empleados);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="A.Paterno") {
					JLabel labelNumero = new JLabel("A.Paterno: ");
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
							empleados=serviceEmpleado.consultarPorDatosPersona("", "", textNumero.getText(),"","","","","","" , "", "");
							buscar(empleados);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="A.Materno") {
					JLabel labelOrientacion = new JLabel("A.Materno: ");
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
//								
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","",textOrientacion.getText(),"","","","","" , "", "");
							buscar(empleados);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Calle") {
					JLabel labelColonia = new JLabel("Calle: ");
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
						empleados=serviceEmpleado.consultarPorDatosPersona("", "","","",textColonia.getText(),"","","","" , "", "");
							buscar(empleados);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				
				if(cbDatos.getSelectedItem().toString()=="Numero") {
					JLabel labelAsentamiento = new JLabel("Numero:");
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
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "", textAsentamiento.getText(),"","","","" , "");
							buscar(empleados);;

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Orientacion") {
					JLabel labelZona = new JLabel("Orientacion:");
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
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "" , "",textZona.getText(),"","","" , "");
							buscar(empleados);;

						}}); 
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}


				if(cbDatos.getSelectedItem().toString()=="F.Nacimiento") {
					JLabel labelCodigoPostal = new JLabel("F.Nacimiento: ");
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
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "", "", "",textCodigoPostal.getText(),"","" , "");
							buscar(empleados);;

						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Genero") {
					JLabel labelCiudad = new JLabel("Genero: ");
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
//				
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "", "", "", "",textCiudad.getText(),"",""
									);
							buscar(empleados);;
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				
				
				if(cbDatos.getSelectedItem().toString()=="Telefono") {
					JLabel labelMunicipio = new JLabel("Telefono: ");
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
//								
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "", "","","","",textMunicipio.getText(), "");
							buscar(empleados);;
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				if(cbDatos.getSelectedItem().toString()=="Clave colonia") {
					JLabel labelEstado = new JLabel("Clave colonia: ");
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
//								
							empleados=serviceEmpleado.consultarPorDatosPersona("", "","","", "", "","","","","" , textEstado.getText());
							buscar(empleados);;
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}

				
				if(cbDatos.getSelectedItem().toString()=="Folio") {
					JLabel labelEstado = new JLabel("Folio: ");
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
//									
							empleados=serviceEmpleado.consultarPorDatosContrato(textEstado.getText(), "","","", "", "","");
							buscar(empleados);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="RFC") {
					JLabel labelEstado = new JLabel("RFC: ");
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
//							
							empleados=serviceEmpleado.consultarPorDatosContrato("",textEstado.getText(),"","", "", "","");
							buscar(empleados);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="F.Inicio") {
					JLabel labelEstado = new JLabel("F.Inicio: ");
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
//							
							empleados=serviceEmpleado.consultarPorDatosContrato("","",textEstado.getText(),"", "", "","");
							buscar(empleados);
							
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="F.Final") {
					JLabel labelEstado = new JLabel("F.Final: ");
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
//						
							empleados=serviceEmpleado.consultarPorDatosContrato("","","",textEstado.getText(), "", "","");
							buscar(empleados);
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Sueldo") {
					JLabel labelEstado = new JLabel("Sueldo: ");
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
//							
							empleados=serviceEmpleado.consultarPorDatosContrato("","","","",textEstado.getText(), "","");
							buscar(empleados);
							
						}});
					add(btnBuscar);
					revalidate();
					repaint();

					//
				}
				if(cbDatos.getSelectedItem().toString()=="Puesto") {
					JLabel labelEstado = new JLabel("Puesto: ");
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
//							
							empleados=serviceEmpleado.consultarPorDatosContrato("","","","","",textEstado.getText(),"");
							buscar(empleados);
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
//							
							empleados=serviceEmpleado.consultarPorDatosContrato("","","","","","",textEstado.getText());
							buscar(empleados);
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
		if(conjuntoDatos.equalsIgnoreCase("Datos personales")){
			datos = new String[12];

			datos[0] = "Buscar por:";
			datos[1] = "ID";
			datos[2] = "Nombre";
			datos[3] = "A.Paterno";
			datos[4] = "A.Materno";
			datos[5] = "Calle";
			datos[6] = "Numero";
			datos[7] = "Orientacion";
			datos[8] = "F.Nacimiento";
			datos[9] = "Genero";
			datos[10] = "Telefono";
			datos[11] = "Clave colonia";
		
			
	
		}

		if(conjuntoDatos.equalsIgnoreCase("Datos del contrato")){
			datos = new String[8];

			datos[0] = "Buscar por:";
			datos[1] = "Folio";
			datos[2] = "RFC";
			datos[3] = "F.Inicio";
			datos[4] = "F.Final";
			datos[5] = "Sueldo";
			datos[6] = "Puesto";
			datos[7] = "Clave cafecito";
			



			
		}

	
		
		return datos;
	}
	
	public void buscar(List<Empleado> empleados){
		
		if(empleados.size()>0) {
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"ID", "Nombre", "A.Paterno", "A.Materno", "Calle", "Numero", "Orientacion", "F.Nacimiento", "Genero", "Telefono", "Cve Colonia", "Folio", "RFC", "F.Inicio", "F.Fin", "Sueldo", "Puesto","Clave Cafecito"};

		String data[][] = new String[empleados.size()][18];

		for(int i=0; i<empleados.size(); i++) {
		
			
			data[i][0]=String.valueOf(empleados.get(i).getCvePer());
			data[i][1]=empleados.get(i).getNombre();
			data[i][2]=empleados.get(i).getPaterno();
			data[i][3]=empleados.get(i).getMaterno();
			data[i][4]=empleados.get(i).getCalle();
			data[i][5]=String.valueOf(empleados.get(i).getNumero());
			data[i][6]=empleados.get(i).getOrientacion();
			data[i][7]=	String.valueOf(empleados.get(i).getNacimiento());
			data[i][8]=	empleados.get(i).getGenero();
			data[i][9]=	String.valueOf(empleados.get(i).getTelefono());
			data[i][10]=	String.valueOf(empleados.get(i).getCveColonia());
			data[i][11]=	String.valueOf(empleados.get(i).getFolio());
			data[i][12]=	empleados.get(i).getRfc();
			data[i][13]=	String.valueOf(empleados.get(i).getfInicio());
			data[i][14]=	String.valueOf(empleados.get(i).getfFinal());
			data[i][15]=	String.valueOf(empleados.get(i).getSueldo());
			data[i][16]=	empleados.get(i).getPuesto();
			data[i][17]=	String.valueOf(empleados.get(i).getCveCaf());


			



			

			
	
			//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(60);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setPreferredWidth(80);
		table.getColumnModel().getColumn(11).setPreferredWidth(40);
		table.getColumnModel().getColumn(12).setPreferredWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(80);
		table.getColumnModel().getColumn(14).setPreferredWidth(80);
		table.getColumnModel().getColumn(15).setPreferredWidth(80);
		table.getColumnModel().getColumn(16).setPreferredWidth(60);
		table.getColumnModel().getColumn(17).setPreferredWidth(80);

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

