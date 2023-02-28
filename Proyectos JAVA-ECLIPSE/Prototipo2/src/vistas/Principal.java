package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.MenuElement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Principal extends JFrame {

	private RegistrarTransporte registrarTransporte;
	private ConsultarTransporte consultarTransporte;
	private ModificarTransporte modificarTransporte;
	
	private ConsultarHorario consultarHorario;
	private ModificarHorario modificarHorarios;
	
	private RegistrarProveedores registrarProveedor;
	private ConsultarProveedor consultarProveedor;
	private ModificarProveedor modificarProveedor;
	
	private RegistrarCliente registrarCliente;
	private ConsultarClientes consultarClientes;
	private ModificarCliente modificarCliente;
	
	private RegistrarCalentador registrarCalentador;
	private ConsultarCalentador consultarCalentador;
	private ModificarCalentador modificarCalentador;
	
	private RegistrarSocios registrarSocios;
	private ConsultarSocio consultarSocio;
	private ModificarSocio modificarSocio;
	
	private RegistrarEmpleado registrarEmpleado;
	private ConsultarEmpleados consultarEmpleado;
	private ModificarEmpleado modificarEmpleado;
	
	private RegistrarTrabajo registrarTrabajo;
	private ModificarTrabajo modificarTrabajo;
	private ConsultarTrabajo consultarTrabajo;
	
	private RegistrarVenta registrarVenta;
	private ConsultarVentas consultarVentas;
	private ModificarVenta modificarVenta;
	
	private RegistrarContrato registrarContrato;
	private ConsultarContrato consultarContrato;
	private ModificarContrato modificarContrato;
	
	private ConsultarGarantia consultarGarantia;
	
	private RegistrarCompras registrarCompra;
	private ConsultarCompras consultarCompra;
	private ModificarCompra modificarCompra;
	private ConsultarInventario consultarInventario;

	private JPanel contentPane;
	
	private JMenu menuCliente;
	private MenuCliente menuClientePrincipal;
	
	private JMenu menuProveedor;
	private MenuProveedor menuProveedorPrincipal;
	
	private JMenu menuCalentador;
	private MenuCalentador menuCalentadorPrincipal;
	
	private JMenu menuHorario;
	private MenuHorario menuHorarioPrincipal;
	
	private JMenu menuTransporte;
	private MenuTransporte menuTransportePrincipal;
	
	private JMenu menuSocio;
	private MenuSocio menuSocioPrincipal;
	
	private JMenu menuEpleado;
	private MenuEmpleado menuEmpleadoPrincipal;
	
	private JMenu menuTrabajo;
	private MenuTrabajo menuTrabajoPrincipal;
	
	private JMenu menuVenta;
	private MenuVenta menuVentaPrincipal;
	
	private JMenu menuContrato;
	private MenuContrato menuContratoPrincipal;
	
	private JMenu menuGarantia;
	private MenuGarantia menuGarantiaPrincipal;
	
	private JMenu menuCompra;
	private MenuCompra menuCompraPrincipal;
	
	
	JPanel panel;

	private JButton btnRegistrarTransporte;
	private JButton btnConsultarTransportes;
	private JButton btnModificarTransporte;
	
	private JButton btnConsultarHorarios;
	private JButton btnModificarHorarios;
	
	private JButton btnRegistrarProveedor;
	private JButton btnConsultarProveedores;
	private JButton btnModificarProveedor;
	
	private JButton btnRegistrarCliente;
	private JButton btnConsultarCliente;
	private JButton btnModificarCliente;
	
	private JButton btnRegistrarCalentador;
	private JButton btnConsultarCalentador;
	private JButton btnModificarCalentador;
	
	private JButton btnRegistrarSocio;
	private JButton btnConsultarSocio;
	private JButton btnModificarSocio;
	
	private JButton btnRegistrarEmpleado;
	private JButton btnConsultarEmpleados;
	private JButton btnModificarEmpleado;
	
	private JButton btnRegistrarTrabajo;
	private JButton btnModificarTrabajo;
	private JButton btnConsultarTrabajo;
	
	private JButton btnRegistrarVenta;
	private JButton btnConsultarVentas;
	private JButton btnModificarVenta;
	
	private JButton btnRegistrarContrato;
	private JButton btnConsultarContrato;
	private JButton btnModificarContrato;
	
	private JButton btnCosultarGarantias;
	
	private JButton btnRegistrarCompra;
	private JButton btnConsultarCompras;
	private JButton btnModificarCompra;
	private JButton btnConsultarInventario;
	
	private String usuario;
	

	public Principal(String usuario) {
		
		this.usuario=usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1366, 768);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		  menuBar.setOpaque(true);
          menuBar.setBackground(Color.BLUE);	
		setJMenuBar(menuBar);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		contentPane.add(panel, BorderLayout.CENTER);

		menuCliente = new JMenu("Personal");
		
	

		menuCliente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuClientePrincipal = new MenuCliente();

				
				
				btnRegistrarCliente = menuClientePrincipal.getBtnRegistrarCliente();
				btnRegistrarCliente.addActionListener(new OyenteRegistrarCliente());
				
				btnConsultarCliente = menuClientePrincipal.getBtnConsultarCliente();
				btnConsultarCliente.addActionListener(new OyenteConsultarClientes());
				
				btnModificarCliente = menuClientePrincipal.getBtnModificarCliente();
				btnModificarCliente.addActionListener(new OyenteModificarCliente());
				
				contentPane.add(menuClientePrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuCliente.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuCliente.setForeground(Color.RED);


		menuBar.add(menuCliente);
		
		menuProveedor = new JMenu("Pacientes");
	
		
		menuProveedor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuProveedorPrincipal = new MenuProveedor();

				btnRegistrarProveedor = menuProveedorPrincipal.getBtnRegistrarProveedor();
				btnRegistrarProveedor.addActionListener(new OyenteRegistrarProveedor());
				
				btnConsultarProveedores = menuProveedorPrincipal.getBtnConsultarProveedores();
				btnConsultarProveedores.addActionListener(new OyenteConsultarProveedores());
				
				btnModificarProveedor = menuProveedorPrincipal.getBtnModificarProveedor();
				btnModificarProveedor.addActionListener(new OyenteModificarProveedor());
				
				contentPane.add(menuProveedorPrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuProveedor.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuProveedor.setForeground(Color.RED);
		menuBar.add(menuProveedor);
		
		menuCalentador = new JMenu("Medicamentos");
		menuCalentador.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuCalentadorPrincipal = new MenuCalentador();

				btnRegistrarCalentador = menuCalentadorPrincipal.getBtnRegistrarCalentador();
				btnRegistrarCalentador.addActionListener(new OyenteRegistrarCalentador());
				
				btnConsultarCalentador = menuCalentadorPrincipal.getBtnConsultarCalentador();
				btnConsultarCalentador.addActionListener(new OyenteConsultarCalentador());
				
				btnModificarCalentador = menuCalentadorPrincipal.getBtnModificarCalentador();
				btnModificarCalentador.addActionListener(new OyenteModificarCalentador());

				
				contentPane.add(menuCalentadorPrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuCalentador.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuCalentador.setForeground(Color.RED);
		menuBar.add(menuCalentador);
		
		menuHorario = new JMenu("Horarios");
		menuHorario.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuHorarioPrincipal = new MenuHorario();

				btnConsultarHorarios = menuHorarioPrincipal.getBtnConsultarHorarios();
				btnConsultarHorarios.addActionListener(new OyenteConsultarHorarios());

				btnModificarHorarios = menuHorarioPrincipal.getBtnModificarHorarios();
				btnModificarHorarios.addActionListener(new OyenteModificarHorarios());
				
				contentPane.add(menuHorarioPrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuHorario.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuHorario.setForeground(Color.RED);
		menuBar.add(menuHorario);
		
		menuTransporte = new JMenu("Eventos");
		menuTransporte.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuTransportePrincipal = new MenuTransporte();

				btnRegistrarTransporte = menuTransportePrincipal.getBtnRegistrarTransporte();
				btnRegistrarTransporte.addActionListener(new OyenteRegistrarTransporte());
				
				btnConsultarTransportes = menuTransportePrincipal.getBtnConsultarTransportes();
				btnConsultarTransportes.addActionListener(new OyenteConsultarTransportes());
				
				btnModificarTransporte = menuTransportePrincipal.getBtnModificarTransporte();
				btnModificarTransporte.addActionListener(new OyenteModificarTransporte());

				
				contentPane.add(menuTransportePrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuTransporte.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuTransporte.setForeground(Color.RED);
		menuBar.add(menuTransporte);
		
		menuSocio = new JMenu("Informes");
		menuSocio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 

				menuSocioPrincipal = new MenuSocio();

				btnRegistrarSocio = menuSocioPrincipal.getBtnRegistrarSocio();
				btnRegistrarSocio.addActionListener(new OyenteRegistrarSocio());
				
				btnConsultarSocio = menuSocioPrincipal.getBtnConsultarSocio();
				btnConsultarSocio.addActionListener(new OyenteConsultarSocio());
				
				btnModificarSocio = menuSocioPrincipal.getBtnModificarSocio();
				btnModificarSocio.addActionListener(new OyenteModificarSocio());

				contentPane.add(menuSocioPrincipal, BorderLayout.WEST);
				setVisible(true);

				panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");
				panel.add(fondo);
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));

				setVisible(true);
				repaint();
			}
		});
		menuSocio.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuSocio.setForeground(Color.RED);
		menuBar.add(menuSocio);
		
		
		JLabel fondo = new JLabel("");
		panel.add(fondo);
		fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/salud.png")));
	}

	private class OyenteRegistrarTransporte implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarTransporte = new RegistrarTransporte(usuario);
			menuTransportePrincipal.setVisible(false);
			contentPane.removeAll();
			menuTransportePrincipal=null;
			repaint();

			contentPane.add(registrarTransporte, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarTransportes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarTransporte = new ConsultarTransporte(usuario);
			menuTransportePrincipal.setVisible(false);
			contentPane.removeAll();
			menuTransportePrincipal=null;
			repaint();

			contentPane.add(consultarTransporte, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarTransporte implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarTransporte = new ModificarTransporte(usuario);
			menuTransportePrincipal.setVisible(false);
			contentPane.removeAll();
			menuTransportePrincipal=null;
			repaint();

			contentPane.add(modificarTransporte, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarHorarios implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarHorario = new ConsultarHorario(usuario);
			menuHorarioPrincipal.setVisible(false);
			contentPane.removeAll();
			menuHorarioPrincipal=null;
			repaint();

			contentPane.add(consultarHorario, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarHorarios implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarHorarios = new ModificarHorario(usuario);
			menuHorarioPrincipal.setVisible(false);
			contentPane.removeAll();
			menuHorarioPrincipal=null;
			repaint();

			contentPane.add(modificarHorarios, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarProveedor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarProveedor = new RegistrarProveedores(usuario);
			menuProveedorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuProveedorPrincipal=null;
			repaint();

			contentPane.add(registrarProveedor, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarProveedores implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarProveedor = new ConsultarProveedor(usuario);
			menuProveedorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuProveedorPrincipal=null;
			repaint();

			contentPane.add(consultarProveedor, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarProveedor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarProveedor = new ModificarProveedor(usuario);
			menuProveedorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuProveedorPrincipal=null;
			repaint();

			contentPane.add(modificarProveedor, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarCliente = new RegistrarCliente(usuario);
			menuClientePrincipal.setVisible(false);
			contentPane.removeAll();
			menuClientePrincipal=null;
			repaint();

			contentPane.add(registrarCliente, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	
	
	private class OyenteConsultarClientes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarClientes = new ConsultarClientes(usuario);
			menuClientePrincipal.setVisible(false);
			contentPane.removeAll();
			menuClientePrincipal=null;
			repaint();

			contentPane.add(consultarClientes, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarCliente = new ModificarCliente(usuario);
			menuClientePrincipal.setVisible(false);
			contentPane.removeAll();
			menuClientePrincipal=null;
			repaint();

			contentPane.add(modificarCliente, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarCalentador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarCalentador = new RegistrarCalentador(usuario);
			menuCalentadorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCalentadorPrincipal=null;
			repaint();

			contentPane.add(registrarCalentador, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarCalentador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarCalentador = new ConsultarCalentador(usuario);
			menuCalentadorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCalentadorPrincipal=null;
			repaint();

			contentPane.add(consultarCalentador, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarCalentador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarCalentador = new ModificarCalentador(usuario);
			menuCalentadorPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCalentadorPrincipal=null;
			repaint();

			contentPane.add(modificarCalentador, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarSocio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarSocios = new RegistrarSocios(usuario);
			menuSocioPrincipal.setVisible(false);
			contentPane.removeAll();
			menuSocioPrincipal=null;
			repaint();

			contentPane.add(registrarSocios, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	

	private class OyenteConsultarSocio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarSocio = new ConsultarSocio(usuario);
			menuSocioPrincipal.setVisible(false);
			contentPane.removeAll();
			menuSocioPrincipal=null;
			repaint();

			contentPane.add(consultarSocio, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarSocio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarSocio = new ModificarSocio(usuario);
			menuSocioPrincipal.setVisible(false);
			contentPane.removeAll();
			menuSocioPrincipal=null;
			repaint();

			contentPane.add(modificarSocio, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarEmpleado implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarEmpleado = new RegistrarEmpleado(usuario);
			menuEmpleadoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuEmpleadoPrincipal=null;
			repaint();

			contentPane.add(registrarEmpleado, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarEmpleados implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarEmpleado = new ConsultarEmpleados(usuario);
			menuEmpleadoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuEmpleadoPrincipal=null;
			repaint();

			contentPane.add(consultarEmpleado, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarEmpleados implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarEmpleado = new ModificarEmpleado(usuario);
			menuEmpleadoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuEmpleadoPrincipal=null;
			repaint();

			contentPane.add(modificarEmpleado, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarTrabajo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarTrabajo = new RegistrarTrabajo(usuario);
			menuTrabajoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuTrabajoPrincipal=null;
			repaint();

			contentPane.add(registrarTrabajo, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarTrabajo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarTrabajo = new ModificarTrabajo(usuario);
			menuTrabajoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuTrabajoPrincipal=null;
			repaint();

			contentPane.add(modificarTrabajo, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarTrabajo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarTrabajo = new ConsultarTrabajo(usuario);
			menuTrabajoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuTrabajoPrincipal=null;
			repaint();

			contentPane.add(consultarTrabajo, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarVenta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarVenta = new RegistrarVenta(usuario);
			menuVentaPrincipal.setVisible(false);
			contentPane.removeAll();
			menuVentaPrincipal=null;
			repaint();

			contentPane.add(registrarVenta, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarVentas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarVentas = new ConsultarVentas(usuario);
			menuVentaPrincipal.setVisible(false);
			contentPane.removeAll();
			menuVentaPrincipal=null;
			repaint();

			contentPane.add(consultarVentas, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarVenta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarVenta = new ModificarVenta(usuario);
			menuVentaPrincipal.setVisible(false);
			contentPane.removeAll();
			menuVentaPrincipal=null;
			repaint();

			contentPane.add(modificarVenta, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarContrato implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarContrato = new RegistrarContrato(usuario);
			menuContratoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuContratoPrincipal=null;
			repaint();

			contentPane.add(registrarContrato, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	
	private class OyenteConsultarContrato implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarContrato = new ConsultarContrato(usuario);
			menuContratoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuContratoPrincipal=null;
			repaint();

			contentPane.add(consultarContrato, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	
	
	
	private class OyenteModificarContrato implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarContrato = new ModificarContrato(usuario);
			menuContratoPrincipal.setVisible(false);
			contentPane.removeAll();
			menuContratoPrincipal=null;
			repaint();

			contentPane.add(modificarContrato, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarGarantia implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarGarantia = new ConsultarGarantia(usuario);
			menuGarantiaPrincipal.setVisible(false);
			contentPane.removeAll();
			menuGarantiaPrincipal=null;
			repaint();

			contentPane.add(consultarGarantia, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteRegistrarCompra implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrarCompra = new RegistrarCompras(usuario);
			menuCompraPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCompraPrincipal=null;
			repaint();

			contentPane.add(registrarCompra, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarCompras implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarCompra = new ConsultarCompras(usuario);
			menuCompraPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCompraPrincipal=null;
			repaint();

			contentPane.add(consultarCompra, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteModificarCompra implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			modificarCompra = new ModificarCompra(usuario);
			menuCompraPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCompraPrincipal=null;
			repaint();

			contentPane.add(modificarCompra, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	private class OyenteConsultarInventario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			consultarInventario = new ConsultarInventario(usuario);
			menuCompraPrincipal.setVisible(false);
			contentPane.removeAll();
			menuCompraPrincipal=null;
			repaint();

			contentPane.add(consultarInventario, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}
	
	

}
