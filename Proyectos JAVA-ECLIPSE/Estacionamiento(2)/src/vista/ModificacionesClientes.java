package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import conversores.Conversor;
import enumeraciones.Secciones;
import enumeraciones.Servicios;
import modelo.Cliente;
import modelo.Lugar;
import modelo.RenglonTicket;
import modelo.Vehiculo;
import servicios.ServiceClienteImpl;
import servicios.ServiceEstacionamientoImpl;
import servicios.ServiceRenglonTicketImpl;
import servicios.ServiceTicketImpl;
import servicios.ServiceVehiculoImpl;

public class ModificacionesClientes extends JPanel {

	private JTextField tfPlacas;
	private JTextField tfModelo;
	private JTextField tfColor;
	private JTextField tfAño;
	private JTextField tfMarca;
	private JTextField tfCelular;
	private JTextField tfCorreo;
	private JTextField tfHrE;
	private JTextField tfHrS;

	private Lugar lugar;
	
	private int modificacion;
	private int id;
	private Cliente clientePrub;
	
	private static final int COSTO_LAVADO=20, COSTO_ENCERADO=40, COSTO_ASPIRADO=20, COSTO_UNAHRESTACIONADO=15;

	public ModificacionesClientes() {
		setLayout(null);

		int resOp=1;

		while(resOp==1 || resOp==2) {
			id=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Id del cliente que deseas modificar"));

			ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();
			clientePrub = new Cliente();

			clientePrub=serviceClienteImpl.consultarPorId(id);

			resOp=JOptionPane.showConfirmDialog(null, "¿Este es el usuario que deseas modificar?\n"
					+ "id: "+clientePrub.getId()+", celular: "+clientePrub.getCelular()+", correo: "+clientePrub.getCorreo()+"\n"
					+ "placas: "+clientePrub.getVehiculo().getPlacas());
		}

		modificacion=Integer.parseInt(JOptionPane.showInputDialog("¿Qué deseas modificar?\n"
				+ "1. Datos sobre el vehiculo\n"
				+ "2. Datos extras\n"
				+ "3. Datos de los servicios pedidos\n"
				+ "4. Datos del estacionado"));

		JOptionPane.showMessageDialog(null, "Ingresa todos los campos de la categoria elegida para pode rmodificar el cliente");

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));

		JLabel lblSobreVehiculo = new JLabel("Sobre el Vehiculo");
		lblSobreVehiculo.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		lblSobreVehiculo.setBounds(33, 44, 215, 43);
		add(lblSobreVehiculo);

		JLabel lblPlacas = new JLabel("Placas:");
		lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPlacas.setBounds(33, 107, 48, 16);
		add(lblPlacas);

		tfPlacas = new JTextField();
		tfPlacas.setBounds(80, 107, 130, 26);
		add(tfPlacas);
		tfPlacas.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(220, 107, 61, 16);
		add(lblModelo);

		tfModelo = new JTextField();
		tfModelo.setBounds(291, 107, 130, 26);
		add(tfModelo);
		tfModelo.setColumns(10);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(431, 107, 48, 16);
		add(lblColor);

		tfColor = new JTextField();
		tfColor.setBounds(489, 107, 130, 26);
		add(tfColor);
		tfColor.setColumns(10);

		JLabel lblAño = new JLabel("Año:");
		lblAño.setBounds(629, 107, 34, 16);
		add(lblAño);

		tfAño = new JTextField();
		tfAño.setBounds(673, 107, 130, 26);
		add(tfAño);
		tfAño.setColumns(10);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(813, 107, 48, 16);
		add(lblMarca);

		tfMarca = new JTextField();
		tfMarca.setBounds(871, 107, 130, 26);
		add(tfMarca);
		tfMarca.setColumns(10);

		JLabel lblTamaño = new JLabel("Tamaño:");
		lblTamaño.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblTamaño.setBounds(33, 143, 74, 20);
		add(lblTamaño);

		JRadioButton rChico, rMediano, rGrande;
		ButtonGroup grupoTamaño;

		rChico=new JRadioButton(); rChico.setText("Chico"); rChico.setBounds(112, 143, 74, 20); add(rChico);
		rMediano=new JRadioButton(); rMediano.setText("Mediano"); rMediano.setBounds(191, 143, 120, 20); add(rMediano);
		rGrande=new JRadioButton(); rGrande.setText("Grande"); rGrande.setBounds(316, 143, 120, 20); add(rGrande);

		grupoTamaño= new ButtonGroup();
		grupoTamaño.add(rChico);
		grupoTamaño.add(rMediano);
		grupoTamaño.add(rGrande);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(441, 143, 46, 20);
		add(lblTipo);

		JRadioButton rMoto, rCarro, rCamioneta;
		ButtonGroup grupoTipo;

		rMoto=new JRadioButton(); rMoto.setText("Moto"); rMoto.setBounds(492, 143, 74, 20); add(rMoto);
		rCarro=new JRadioButton(); rCarro.setText("Carro"); rCarro.setBounds(571, 143, 120, 20); add(rCarro);
		rCamioneta=new JRadioButton(); rCamioneta.setText("Camioneta"); rCamioneta.setBounds(696, 143, 120, 20); add(rCamioneta);

		grupoTipo= new ButtonGroup();
		grupoTipo.add(rMoto);
		grupoTipo.add(rCarro);
		grupoTipo.add(rCamioneta);

		JLabel lblDatosExtra = new JLabel("Datos Extra");
		lblDatosExtra.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblDatosExtra.setBounds(33, 173, 151, 32);
		add(lblDatosExtra);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(33, 210, 68, 20);
		add(lblCelular);

		tfCelular = new JTextField();
		tfCelular.setBounds(106, 210, 130, 26);
		add(tfCelular);
		tfCelular.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(241, 210, 61, 16);
		add(lblCorreo);

		tfCorreo = new JTextField();
		tfCorreo.setBounds(307, 210, 130, 26);
		add(tfCorreo);
		tfCorreo.setColumns(10);

		JLabel lblServicios = new JLabel("Otros Servicios");
		lblServicios.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		lblServicios.setBounds(33, 240, 200, 26);
		add(lblServicios);

		JCheckBox cbLavado, cbEncerado, cbAspirado;

		cbLavado = new JCheckBox(); cbLavado.setText("Lavado"); cbLavado.setBounds(33, 271, 200, 20); add(cbLavado);
		cbEncerado = new JCheckBox(); cbEncerado.setText("Encerado"); cbEncerado.setBounds(238, 271, 200, 20); add(cbEncerado);
		cbAspirado = new JCheckBox(); cbAspirado.setText("Aspirado"); cbAspirado.setBounds(443, 271, 200, 20); add(cbAspirado);

		JLabel lblDtsEst = new JLabel("Datos del estacionado");
		lblDtsEst.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		lblDtsEst.setBounds(33, 301, 500, 26);
		add(lblDtsEst);

		JLabel lblFormat = new JLabel("(aaaa-mm-ddThh:mm:ss)");
		lblFormat.setBounds(350, 301, 200, 26);
		add(lblFormat);

		JLabel lblHrE = new JLabel("Hora Entrada:");
		lblHrE.setBounds(33, 332, 186, 26);
		add(lblHrE);

		tfHrE = new JTextField();
		tfHrE.setBounds(224, 332, 130, 26);
		add(tfHrE);
		tfHrE.setColumns(10);

		JLabel lblHrS = new JLabel("Hora Salida:");
		lblHrS.setBounds(359, 332, 186, 26);
		add(lblHrS);

		tfHrS = new JTextField();
		tfHrS.setBounds(550, 332, 130, 26);
		add(tfHrS);
		tfHrS.setColumns(10);

		ServiceEstacionamientoImpl serviceE = new ServiceEstacionamientoImpl();


		JLabel lblMedianos = new JLabel("Medianos");
		lblMedianos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMedianos.setBounds(930, 347, 100, 16);
		add(lblMedianos);
		
		lugar=null;

		Lugar lugM1=new Lugar(1, Secciones.MEDIANA);
		JButton btnM1 = new JButton();
		btnM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.MEDIANA);
			}
		});
		btnM1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM1))));
		btnM1.setBounds(769, 299, 53, 43);
		add(btnM1);

		Lugar lugM2=new Lugar(2, Secciones.MEDIANA);
		JButton btnM2 = new JButton();
		btnM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.MEDIANA);
			}
		});
		btnM2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM2))));
		btnM2.setBounds(827, 299, 53, 43);
		add(btnM2);

		Lugar lugM3=new Lugar(3, Secciones.MEDIANA);
		JButton btnM3 = new JButton();
		btnM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.MEDIANA);
			}
		});
		btnM3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM3))));
		btnM3.setBounds(885, 299, 53, 43);
		add(btnM3);

		Lugar lugM4=new Lugar(4, Secciones.MEDIANA);
		JButton btnM4 = new JButton();
		btnM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.MEDIANA);
			}
		});
		btnM4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM4))));
		btnM4.setBounds(943, 299, 53, 43);
		add(btnM4);

		Lugar lugM5=new Lugar(5, Secciones.MEDIANA);
		JButton btnM5 = new JButton();
		btnM5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.MEDIANA);
			}
		});
		btnM5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM5))));
		btnM5.setBounds(1001, 299, 53, 43);
		add(btnM5);

		Lugar lugM6=new Lugar(6, Secciones.MEDIANA);
		JButton btnM6 = new JButton();
		btnM6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.MEDIANA);
			}
		});
		btnM6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM6))));
		btnM6.setBounds(1059, 299, 53, 43);
		add(btnM6);

		Lugar lugM7=new Lugar(7, Secciones.MEDIANA);
		JButton btnM7 = new JButton();
		btnM7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.MEDIANA);
			}
		});
		btnM7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugM7))));
		btnM7.setBounds(1117, 299, 53, 43);
		add(btnM7);

		JLabel lblChicos = new JLabel("<html><center>C\nH\nI\nC\nO\nS</center><html>");
		lblChicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChicos.setBounds(769, 420, 20, 200);
		add(lblChicos);

		Lugar lugC1=new Lugar(1, Secciones.CHICA);
		JButton btnC1 = new JButton();
		btnC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.CHICA);
			}
		});
		btnC1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC1))));
		btnC1.setBounds(711, 347, 53, 43);
		add(btnC1);

		Lugar lugC2=new Lugar(2, Secciones.CHICA);
		JButton btnC2 = new JButton();
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.CHICA);
			}
		});
		btnC2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC2))));
		btnC2.setBounds(711, 395, 53, 43);
		add(btnC2);

		Lugar lugC3=new Lugar(3, Secciones.CHICA);
		JButton btnC3 = new JButton();
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.CHICA);
			}
		});
		btnC3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC3))));
		btnC3.setBounds(711, 443, 53, 43);
		add(btnC3);

		Lugar lugC4=new Lugar(4, Secciones.CHICA);
		JButton btnC4 = new JButton();
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.CHICA);
			}
		});
		btnC4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC4))));
		btnC4.setBounds(711, 491, 53, 43);
		add(btnC4);

		Lugar lugC5=new Lugar(5, Secciones.CHICA);
		JButton btnC5 = new JButton();
		btnC5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.CHICA);
			}
		});
		btnC5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC5))));
		btnC5.setBounds(711, 539, 53, 43);
		add(btnC5);

		Lugar lugC6=new Lugar(6, Secciones.CHICA);
		JButton btnC6 = new JButton();
		btnC6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.CHICA);
			}
		});
		btnC6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC6))));
		btnC6.setBounds(711, 587, 53, 43);
		add(btnC6);

		Lugar lugC7=new Lugar(7, Secciones.CHICA);
		JButton btnC7 = new JButton();
		btnC7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.CHICA);
			}
		});
		btnC7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugC7))));
		btnC7.setBounds(711, 635, 53, 43);
		add(btnC7);

		JLabel lblGrandes = new JLabel("<html><center>G\nR\nA\nN\nD\nE\nS</center><html>");
		lblGrandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGrandes.setBounds(1150, 420, 20, 200);
		add(lblGrandes);

		Lugar lugG1=new Lugar(1, Secciones.GRANDE);
		JButton btnG1 = new JButton();
		btnG1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(1, Secciones.GRANDE);
			}
		});
		btnG1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG1))));
		btnG1.setBounds(1175, 347, 53, 43);
		add(btnG1);

		Lugar lugG2=new Lugar(2, Secciones.GRANDE);
		JButton btnG2 = new JButton();
		btnG2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(2, Secciones.GRANDE);
			}
		});
		btnG2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG2))));
		btnG2.setBounds(1175, 395, 53, 43);
		add(btnG2);

		Lugar lugG3=new Lugar(3, Secciones.GRANDE);
		JButton btnG3 = new JButton();
		btnG3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(3, Secciones.GRANDE);
			}
		});
		btnG3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG3))));
		btnG3.setBounds(1175, 443, 53, 43);
		add(btnG3);

		Lugar lugG4=new Lugar(4, Secciones.GRANDE);
		JButton btnG4 = new JButton();
		btnG4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(4, Secciones.GRANDE);
			}
		});
		btnG4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG4))));
		btnG4.setBounds(1175, 491, 53, 43);
		add(btnG4);

		Lugar lugG5=new Lugar(5, Secciones.GRANDE);
		JButton btnG5 = new JButton();
		btnG5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(5, Secciones.GRANDE);
			}
		});
		btnG5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG5))));
		btnG5.setBounds(1175, 539, 53, 43);
		add(btnG5);

		Lugar lugG6=new Lugar(6, Secciones.GRANDE);
		JButton btnG6 = new JButton();
		btnG6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(6, Secciones.GRANDE);
			}
		});
		btnG6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG6))));
		btnG6.setBounds(1175, 587, 53, 43);
		add(btnG6);

		Lugar lugG7=new Lugar(7, Secciones.GRANDE);
		JButton btnG7 = new JButton();
		btnG7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugar = new Lugar(7, Secciones.GRANDE);
			}
		});
		btnG7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(serviceE.obtenerImagen(lugG7))));
		btnG7.setBounds(1175, 635, 53, 43);
		add(btnG7);

		JLabel lblDisponible = new JLabel("Lugar Disponible");
		lblDisponible.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/disponible.jpg")));
		lblDisponible.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDisponible.setBounds(33, 368, 500, 43);
		add(lblDisponible);

		JLabel lblOcupado = new JLabel("Lugar Ocupado");
		lblOcupado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/ocupado.jpg")));
		lblOcupado.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblOcupado.setBounds(33, 421, 500, 43);
		add(lblOcupado);

		JLabel lblReservado = new JLabel("Lugar Reservado");
		lblReservado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/reservado.jpg")));
		lblReservado.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblReservado.setBounds(33, 474, 500, 43);
		add(lblReservado);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(modificacion) {
				
				case 1: 
					
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
					
					ServiceVehiculoImpl serviceVehiculoImpl = new ServiceVehiculoImpl();
					serviceVehiculoImpl.modificarPorPlacas(vehiculo, clientePrub.getVehiculo().getPlacas());
					
					break;
					
				case 2:
					
					ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();
					
					if(!tfCelular.getText().isEmpty() && !tfCorreo.getText().isEmpty()) {
						serviceClienteImpl.modificarCelular(clientePrub.getId(), tfCelular.getText());
						serviceClienteImpl.modificarCorreo(clientePrub.getId(), tfCorreo.getText());
					}
					if(tfCelular.getText().isEmpty()) {
						serviceClienteImpl.modificarCorreo(clientePrub.getId(), tfCorreo.getText());
					}
					if(tfCorreo.getText().isEmpty()) {
						serviceClienteImpl.modificarCelular(clientePrub.getId(), tfCelular.getText());
					}
					
					break;
					
				case 3:
					
					ServiceTicketImpl serviceTicketImpl = new ServiceTicketImpl();
					int idTicket=serviceTicketImpl.obtenerIdTicketRecienteCnPlc(clientePrub.getVehiculo().getPlacas());
					
					ServiceRenglonTicketImpl serviceRenglonTicketImpl = new ServiceRenglonTicketImpl();
					
					RenglonTicket renglonTicket;
					if(cbLavado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 1);
						renglonTicket = new RenglonTicket(Servicios.LAVADO, COSTO_LAVADO);
						serviceRenglonTicketImpl.guardarCnIdTicket(renglonTicket, idTicket);
					}
					if(cbEncerado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 2);
						renglonTicket = new RenglonTicket(Servicios.ENCERADO, COSTO_ENCERADO);
						serviceRenglonTicketImpl.guardarCnIdTicket(renglonTicket, idTicket);
					}
					if(cbAspirado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 3);
						renglonTicket = new RenglonTicket(Servicios.ASPIRADO, COSTO_ASPIRADO);
						serviceRenglonTicketImpl.guardarCnIdTicket(renglonTicket, idTicket);
					}
					
					if(!cbLavado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 1);
					}
					if(!cbEncerado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 2);
					}
					if(!cbAspirado.isSelected()) {
						serviceRenglonTicketImpl.eliminar(idTicket, 3);
					}
					
					break;
					
				case 4:
					
					ServiceEstacionamientoImpl serviceEstacionamientoImpl = new ServiceEstacionamientoImpl();
					
					if(!tfHrE.getText().isEmpty() && !tfHrS.getText().isEmpty()) {
						serviceEstacionamientoImpl.modificarHrE(clientePrub.getVehiculo().getPlacas(), LocalDateTime.parse(tfHrE.getText()));
						serviceEstacionamientoImpl.modificarHrS(clientePrub.getVehiculo().getPlacas(), LocalDateTime.parse(tfHrS.getText()));
					}
					if(tfHrE.getText().isEmpty() && !tfHrS.getText().isEmpty()) {
						serviceEstacionamientoImpl.modificarHrS(clientePrub.getVehiculo().getPlacas(), LocalDateTime.parse(tfHrS.getText()));
					}
					if(tfHrS.getText().isEmpty() && !tfHrE.getText().isEmpty()) {
						serviceEstacionamientoImpl.modificarHrE(clientePrub.getVehiculo().getPlacas(), LocalDateTime.parse(tfHrE.getText()));
					}
					
					if(!(lugar==null)) {
						ServiceEstacionamientoImpl sL = new ServiceEstacionamientoImpl();
						sL.modificarLugar(clientePrub.getVehiculo().getPlacas(), lugar);
					}
						
					break;
				
				}
				
			}
		});
		btnModificar .setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		btnModificar .setBounds(33, 587, 259, 51);
		add(btnModificar);


	}

}
