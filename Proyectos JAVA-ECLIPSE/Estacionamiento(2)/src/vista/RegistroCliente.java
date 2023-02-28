package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import api.ServiceVehiculo;
import conversores.Conversor;
import dao.BaseDatos;
import dao.FuenteDatos;
import dao.TablaCliente;
import dao.TablaEstacionamiento;
import dao.TablaVehiculo;
import enumeraciones.Secciones;
import enumeraciones.Servicios;
import modelo.Cliente;
import modelo.Estacionamiento;
import modelo.Lugar;
import modelo.RenglonTicket;
import modelo.Ticket;
import modelo.Vehiculo;
import servicios.ServiceClienteImpl;
import servicios.ServiceEstacionamientoImpl;
import servicios.ServiceRenglonTicketImpl;
import servicios.ServiceTicketImpl;
import servicios.ServiceVehiculoImpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RegistroCliente extends JPanel {
	private ServiceVehiculo servicioVehiculo;

	private JTextField tfPlacas;
	private JTextField tfModelo;
	private JTextField tfColor;
	private JTextField tfAño;
	private JTextField tfMarca;
	private JTextField tfTamaño;
	private JTextField tfTipo;
	private JTextField tfCelular;
	private JTextField tfCorreo;
	
	private BaseDatos baseDatos;
	
	private Lugar lugar;
	
	private static final int COSTO_LAVADO=20, COSTO_ENCERADO=40, COSTO_ASPIRADO=20, COSTO_UNAHRESTACIONADO=15;



	public RegistroCliente() {

		servicioVehiculo = new ServiceVehiculoImpl();
		setLayout(null);

		//registrar("INSERT INTO cliente(placas, modelo, color, hora_entrada, tamaño, tipo, lugar_estacionado, fecha_entrada) VALUES (111, 'tsuru', 'rojo', '21:47', 'mediano', 'carro', 4, '2020-03-30')");
		//modificar("UPDATE cliente SET color='blanco' WHERE placas=666");
		//eliminar("DELETE FROM cliente WHERE placas=123456");
		//obtenerRegistro("SELECT * FROM cliente");
		//obtenerRegistro("SELECT * FROM cliente WHERE placas="+123456);


		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));

		JLabel lblSobreVehiculo = new JLabel("Sobre el Vehiculo");
		lblSobreVehiculo.setBounds(33, 44, 215, 43);
		lblSobreVehiculo.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		add(lblSobreVehiculo);

		JLabel lblPlacas = new JLabel("Placas:");
		lblPlacas.setBounds(33, 107, 59, 20);
		lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblPlacas);

		tfPlacas = new JTextField();
		tfPlacas.setBounds(102, 107, 130, 26);
		add(tfPlacas);
		tfPlacas.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(33, 147, 68, 20);
		lblModelo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblModelo);

		tfModelo = new JTextField();
		tfModelo.setBounds(111, 147, 130, 26);
		add(tfModelo);
		tfModelo.setColumns(10);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(33, 187, 53, 20);
		lblColor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblColor);

		tfColor = new JTextField();
		tfColor.setBounds(96, 187, 130, 26);
		add(tfColor);
		tfColor.setColumns(10);

		JLabel lblAño = new JLabel("Año:");
		lblAño.setBounds(33, 227, 41, 20);
		lblAño.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblAño);

		tfAño = new JTextField();
		tfAño.setBounds(84, 227, 130, 26);
		add(tfAño);
		tfAño.setColumns(10);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(33, 267, 59, 14);
		lblMarca.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblMarca);

		tfMarca = new JTextField();
		tfMarca.setBounds(102, 267, 130, 26);
		add(tfMarca);
		tfMarca.setColumns(10);

		JLabel lblTamaño = new JLabel("Tamaño:");
		lblTamaño.setBounds(33, 301, 74, 20);
		lblTamaño.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblTamaño);

		JRadioButton rChico, rMediano, rGrande;
		ButtonGroup grupoTamaño;

		rChico=new JRadioButton();
		rChico.setBounds(33, 331, 74, 20);rChico.setText("Chico");add(rChico);
		rMediano=new JRadioButton();
		rMediano.setBounds(33, 361, 120, 20);rMediano.setText("Mediano");add(rMediano);
		rGrande=new JRadioButton();
		rGrande.setBounds(33, 391, 120, 20);rGrande.setText("Grande");add(rGrande);

		grupoTamaño= new ButtonGroup();
		grupoTamaño.add(rChico);
		grupoTamaño.add(rMediano);
		grupoTamaño.add(rGrande);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(33, 431, 46, 20);
		lblTipo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblTipo);

		JRadioButton rMoto, rCarro, rCamioneta;
		ButtonGroup grupoTipo;

		rMoto=new JRadioButton();
		rMoto.setBounds(33, 461, 74, 20);rMoto.setText("Moto");add(rMoto);
		rCarro=new JRadioButton();
		rCarro.setBounds(33, 491, 120, 20);rCarro.setText("Carro");add(rCarro);
		rCamioneta=new JRadioButton();
		rCamioneta.setBounds(33, 521, 120, 20);rCamioneta.setText("Camioneta");add(rCamioneta);

		grupoTipo= new ButtonGroup();
		grupoTipo.add(rMoto);
		grupoTipo.add(rCarro);
		grupoTipo.add(rCamioneta);

		JLabel lblDatosExtra = new JLabel("Datos Extra");
		lblDatosExtra.setBounds(348, 44, 151, 32);
		lblDatosExtra.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		add(lblDatosExtra);

		JLabel lblOpcionales = new JLabel("(Opcionales)");
		lblOpcionales.setBounds(385, 76, 86, 20);
		add(lblOpcionales);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(348, 116, 68, 20);
		lblCelular.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblCelular);

		tfCelular = new JTextField();
		tfCelular.setBounds(426, 116, 130, 26);
		add(tfCelular);
		tfCelular.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(348, 156, 61, 16);
		lblCorreo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblCorreo);

		tfCorreo = new JTextField();
		tfCorreo.setBounds(419, 156, 130, 26);
		add(tfCorreo);
		tfCorreo.setColumns(10);

		JLabel lblHora = new JLabel("Hora Entrada:");
		lblHora.setBounds(690, 44, 186, 26);
		lblHora.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		add(lblHora);

		LocalDateTime dateTime=LocalDateTime.now();
		
		JLabel lblFechaEntrada = new JLabel(dateTime.toString());
		lblFechaEntrada.setBounds(871, 44, 500, 32);
		lblFechaEntrada.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		add(lblFechaEntrada);

		JLabel lblServicios = new JLabel("Otros Servicios");
		lblServicios.setBounds(700, 106, 200, 26);
		lblServicios.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		add(lblServicios);

		JCheckBox cbLavado, cbEncerado, cbAspirado;

		cbLavado = new JCheckBox();
		cbLavado.setBounds(700, 152, 200, 20);cbLavado.setText("Lavado");add(cbLavado);
		cbEncerado = new JCheckBox();
		cbEncerado.setBounds(700, 182, 200, 20);cbEncerado.setText("Encerado");add(cbEncerado);
		cbAspirado = new JCheckBox();
		cbAspirado.setBounds(700, 212, 200, 20);cbAspirado.setText("Aspirado");add(cbAspirado);

		JLabel lblLugar = new JLabel("Selecciona un lugar");
		lblLugar.setBounds(556, 262, 251, 32);
		lblLugar.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		add(lblLugar);


		//btnM1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		
		ServiceEstacionamientoImpl serviceE = new ServiceEstacionamientoImpl();
		
		
		JLabel lblMedianos = new JLabel("Medianos");
		lblMedianos.setBounds(630, 347, 100, 16);
		lblMedianos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblMedianos);
		
		Lugar lugM1=new Lugar(1, Secciones.MEDIANA);
		JButton btnM1 = new JButton();
		btnM1.setBounds(469, 299, 53, 43);
		btnM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.MEDIANA);
			}
		});
		btnM1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM1))));
		add(btnM1);

		Lugar lugM2=new Lugar(2, Secciones.MEDIANA);
		JButton btnM2 = new JButton();
		btnM2.setBounds(527, 299, 53, 43);
		btnM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.MEDIANA);
			}
		});
		btnM2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM2))));
		add(btnM2);

		Lugar lugM3=new Lugar(3, Secciones.MEDIANA);
		JButton btnM3 = new JButton();
		btnM3.setBounds(585, 299, 53, 43);
		btnM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.MEDIANA);
			}
		});
		btnM3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM3))));
		add(btnM3);

		Lugar lugM4=new Lugar(4, Secciones.MEDIANA);
		JButton btnM4 = new JButton();
		btnM4.setBounds(643, 299, 53, 43);
		btnM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.MEDIANA);
			}
		});
		btnM4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM4))));
		add(btnM4);

		Lugar lugM5=new Lugar(5, Secciones.MEDIANA);
		JButton btnM5 = new JButton();
		btnM5.setBounds(701, 299, 53, 43);
		btnM5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.MEDIANA);
			}
		});
		btnM5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM5))));
		add(btnM5);

		Lugar lugM6=new Lugar(6, Secciones.MEDIANA);
		JButton btnM6 = new JButton();
		btnM6.setBounds(759, 299, 53, 43);
		btnM6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.MEDIANA);
			}
		});
		btnM6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM6))));
		add(btnM6);

		Lugar lugM7=new Lugar(7, Secciones.MEDIANA);
		JButton btnM7 = new JButton();
		btnM7.setBounds(817, 299, 53, 43);
		btnM7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.MEDIANA);
			}
		});
		btnM7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM7))));
		add(btnM7);
		
		JLabel lblChicos = new JLabel("<html><center>C\nH\nI\nC\nO\nS</center><html>");
		lblChicos.setBounds(469, 420, 20, 200);
		lblChicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblChicos);

		Lugar lugC1=new Lugar(1, Secciones.CHICA);
		JButton btnC1 = new JButton();
		btnC1.setBounds(411, 347, 53, 43);
		btnC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.CHICA);
			}
		});
		btnC1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC1))));
		add(btnC1);

		Lugar lugC2=new Lugar(2, Secciones.CHICA);
		JButton btnC2 = new JButton();
		btnC2.setBounds(411, 395, 53, 43);
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.CHICA);
			}
		});
		btnC2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC2))));
		add(btnC2);

		Lugar lugC3=new Lugar(3, Secciones.CHICA);
		JButton btnC3 = new JButton();
		btnC3.setBounds(411, 443, 53, 43);
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.CHICA);
			}
		});
		btnC3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC3))));
		add(btnC3);

		Lugar lugC4=new Lugar(4, Secciones.CHICA);
		JButton btnC4 = new JButton();
		btnC4.setBounds(411, 491, 53, 43);
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.CHICA);
			}
		});
		btnC4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC4))));
		add(btnC4);

		Lugar lugC5=new Lugar(5, Secciones.CHICA);
		JButton btnC5 = new JButton();
		btnC5.setBounds(411, 539, 53, 43);
		btnC5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.CHICA);
			}
		});
		btnC5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC5))));
		add(btnC5);

		Lugar lugC6=new Lugar(6, Secciones.CHICA);
		JButton btnC6 = new JButton();
		btnC6.setBounds(411, 587, 53, 43);
		btnC6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.CHICA);
			}
		});
		btnC6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC6))));
		add(btnC6);

		Lugar lugC7=new Lugar(7, Secciones.CHICA);
		JButton btnC7 = new JButton();
		btnC7.setBounds(411, 635, 53, 43);
		btnC7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.CHICA);
			}
		});
		btnC7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC7))));
		add(btnC7);
		
		JLabel lblGrandes = new JLabel("<html><center>G\nR\nA\nN\nD\nE\nS</center><html>");
		lblGrandes.setBounds(850, 420, 20, 200);
		lblGrandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblGrandes);

		Lugar lugG1=new Lugar(1, Secciones.GRANDE);
		JButton btnG1 = new JButton();
		btnG1.setBounds(875, 347, 53, 43);
		btnG1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.GRANDE);
			}
		});
		btnG1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG1))));
		add(btnG1);

		Lugar lugG2=new Lugar(2, Secciones.GRANDE);
		JButton btnG2 = new JButton();
		btnG2.setBounds(875, 395, 53, 43);
		btnG2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.GRANDE);
			}
		});
		btnG2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG2))));
		add(btnG2);

		Lugar lugG3=new Lugar(3, Secciones.GRANDE);
		JButton btnG3 = new JButton();
		btnG3.setBounds(875, 443, 53, 43);
		btnG3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.GRANDE);
			}
		});
		btnG3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG3))));
		add(btnG3);

		Lugar lugG4=new Lugar(4, Secciones.GRANDE);
		JButton btnG4 = new JButton();
		btnG4.setBounds(875, 491, 53, 43);
		btnG4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.GRANDE);
			}
		});
		btnG4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG4))));
		add(btnG4);

		Lugar lugG5=new Lugar(5, Secciones.GRANDE);
		JButton btnG5 = new JButton();
		btnG5.setBounds(875, 539, 53, 43);
		btnG5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.GRANDE);
			}
		});
		btnG5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG5))));
		add(btnG5);

		Lugar lugG6=new Lugar(6, Secciones.GRANDE);
		JButton btnG6 = new JButton();
		btnG6.setBounds(875, 587, 53, 43);
		btnG6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.GRANDE);
			}
		});
		btnG6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG6))));
		add(btnG6);

		Lugar lugG7=new Lugar(7, Secciones.GRANDE);
		JButton btnG7 = new JButton();
		btnG7.setBounds(875, 635, 53, 43);
		btnG7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.GRANDE);
			}
		});
		btnG7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG7))));
		add(btnG7);

		JLabel lblDisponible = new JLabel("Lugar Disponible");
		lblDisponible.setBounds(1028, 299, 500, 43);
		lblDisponible.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/disponible.jpg")));
		lblDisponible.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblDisponible);

		JLabel lblOcupado = new JLabel("Lugar Ocupado");
		lblOcupado.setBounds(1028, 352, 500, 43);
		lblOcupado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/ocupado.jpg")));
		lblOcupado.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblOcupado);

		JLabel lblReservado = new JLabel("Lugar Reservado");
		lblReservado.setBounds(1028, 405, 500, 43);
		lblReservado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/reservado.jpg")));
		lblReservado.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblReservado);

		JButton btnRegistro = new JButton("Registrar entrada");
		btnRegistro.setBounds(1028, 587, 259, 51);

		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vehiculo vehiculo = new Vehiculo();
				
				vehiculo.setPlacas(tfPlacas.getText());
				vehiculo.setModelo(tfModelo.getText());
				vehiculo.setAño(Integer.parseInt(tfAño.getText()));
				vehiculo.setMarca(tfMarca.getText());
				vehiculo.setColor(tfColor.getText());
				
				if(rChico.isSelected()) {
					vehiculo.setTamaño(Conversor.convertirATamaños(rChico.getText()));
				}
				if(rMediano.isSelected()) {
					vehiculo.setTamaño(Conversor.convertirATamaños(rMediano.getText()));
				}
				if(rGrande.isSelected()) {
					vehiculo.setTamaño(Conversor.convertirATamaños(rGrande.getText()));
				}
				
				if(rMoto.isSelected()) {
					vehiculo.setTipo(Conversor.convertirATipos(rMoto.getText()));
				}
				if(rCarro.isSelected()) {
					vehiculo.setTipo(Conversor.convertirATipos(rCarro.getText()));
				}
				if(rCamioneta.isSelected()) {
					vehiculo.setTipo(Conversor.convertirATipos(rCamioneta.getText()));
				}
				
				
				LocalDateTime dateTime=LocalDateTime.now();
				Estacionamiento estacionamiento = new Estacionamiento(dateTime, vehiculo , lugar);
				
				
				
				ServiceVehiculoImpl serviceVehiculoImpl = new ServiceVehiculoImpl();
				serviceVehiculoImpl.guardar(vehiculo);
				
				ServiceEstacionamientoImpl serviceEstacionamientoImpl = new ServiceEstacionamientoImpl();
				serviceEstacionamientoImpl.guardar(estacionamiento);
				
				ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();
				
				
				
				
				Cliente cliente = new Cliente();
				if(!tfCelular.getText().isEmpty() && !tfCorreo.getText().isEmpty()) {
					cliente.setCelular(tfCelular.getText());
					cliente.setCorreo(tfCorreo.getText());
					cliente.setVehiculo(vehiculo);
					serviceClienteImpl.guardarCCV(cliente);
				}
				if(tfCelular.getText().isEmpty()) {
					cliente.setCorreo(tfCorreo.getText());
					cliente.setVehiculo(vehiculo);
					serviceClienteImpl.guardarCoV(cliente);
				}
				if(tfCorreo.getText().isEmpty()) {
					cliente.setCelular(tfCelular.getText());
					cliente.setVehiculo(vehiculo);
					serviceClienteImpl.guardarCeV(cliente);
				}
				if(tfCelular.getText().isEmpty() && tfCorreo.getText().isEmpty()) {
					cliente.setVehiculo(vehiculo);
					serviceClienteImpl.guardarV(cliente);
				}
				
				Ticket ticket = new Ticket();
				
				ticket.setPlacas(vehiculo.getPlacas());
				ticket.setFecha(dateTime);
				
				RenglonTicket renglonTicket;
				List<RenglonTicket> items = new ArrayList<RenglonTicket>(Arrays.asList());
				
				if(cbLavado.isSelected()) {
					renglonTicket = new RenglonTicket(Servicios.LAVADO, COSTO_LAVADO);
					items.add(renglonTicket);
				}
				if(cbEncerado.isSelected()) {
					renglonTicket = new RenglonTicket(Servicios.ENCERADO, COSTO_ENCERADO);
					items.add(renglonTicket);
				}
				if(cbAspirado.isSelected()) {
					renglonTicket = new RenglonTicket(Servicios.ASPIRADO, COSTO_ASPIRADO);
					items.add(renglonTicket);
				}
				
				ticket.setItems(items);
				
				int i=0;
				while(i<ticket.getItems().size()) {
					System.out.println(ticket.getItems().get(i).getServicio());	i++;
				}
				
				ServiceTicketImpl serviceTicketImpl = new ServiceTicketImpl();
				serviceTicketImpl.guardar(ticket);
				
				ServiceRenglonTicketImpl serviceRenglonTicketImpl = new ServiceRenglonTicketImpl();
				serviceRenglonTicketImpl.guardar(ticket);
				
					
				
			}
		});

		btnRegistro.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		add(btnRegistro);


	}
}
