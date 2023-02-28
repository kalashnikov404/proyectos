package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import dao.Metodos;
import utilidades.HilosReloj;
import vista.PanelesBoletos.PanelBoletosRegistrar;
import vista.PanelesBoletos.PanelSalirBoletosRegistrar;
import vista.PanelesBoletos.PanelTituloBoletosRegistrar;
import vista.PanelesResurtir.PanelResurtidosRegistrar;
import vista.PanelesResurtir.PanelSalirResurtidosRegistrar;
import vista.PanelesResurtir.PanelTituloResurtidosRegistrar;
import vista.panelesContratar.PanelRegistrarContratar;
import vista.panelesContratar.PanelSalirContratar;
import vista.panelesContratar.PanelTituloContratar;
import vista.panelesPeliculas.PanelPeliculasConsultar;
import vista.panelesPeliculas.PanelPeliculasConsultar2;
import vista.panelesPeliculas.PanelPeliculasEliminar;
import vista.panelesPeliculas.PanelPeliculasModificar;
import vista.panelesPeliculas.PanelPeliculasRegistar;
import vista.panelesPeliculas.PanelSalirPeliculasConsultar;
import vista.panelesPeliculas.PanelSalirPeliculasEliminar;
import vista.panelesPeliculas.PanelSalirPeliculasModificar;
import vista.panelesPeliculas.PanelSalirPeliculasRegistrar;
import vista.panelesPeliculas.PanelTituloPeliculasConsultar;
import vista.panelesPeliculas.PanelTituloPeliculasEliminar;
import vista.panelesPeliculas.PanelTituloPeliculasModificar;
import vista.panelesPeliculas.PanelTituloPeliculasRegistrar;
import vista.panelesProveedores.PanelRegistrarProveedores;
import vista.panelesProveedores.PanelSalirRegistrarProveedores;
import vista.panelesProveedores.PanelTituloRegistarProveedores;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Cine extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Metodos metodos;
	private JMenu menuEmpleados;
	private JMenu menuPeliculas;
	private JMenu menuCartelera;
	private JMenu menuBoletos;
	private JMenu menuProveedores;
	private JMenu menuResurtidos;
	private JMenu menuVentas;
	
	private static JLabel lbReloj;
	
	
	
	public static JLabel getLbReloj() {
		return lbReloj;
	}


	//////////////////paneles////////////////////////
	private JPanel contentPane;
	private PanelImagenFondo fondo;
	
	private PanelTituloPeliculasRegistrar panelTituloPeliculasRegistrar;
	private PanelPeliculasRegistar panelPeliculasRegistar;
	private PanelSalirPeliculasRegistrar panelSalirPeliculasRegistrar;
	
	private PanelTituloPeliculasModificar panelTituloPeliculasModificar;
	private PanelPeliculasModificar panelPeliculasModificar;
	private PanelSalirPeliculasModificar panelSalirPeliculasModificar;
	
	private PanelTituloPeliculasConsultar panelTituloPeliculasConsultar;
	private PanelPeliculasConsultar panelPeliculasConsultar;
	private PanelPeliculasConsultar2 panelPeliculasConsultar2;
	private PanelSalirPeliculasConsultar panelSalirPeliculasConsultar;

	private PanelTituloPeliculasEliminar panelTituloPeliculasEliminar;
	private PanelPeliculasEliminar panelPeliculasEliminar;
	private PanelSalirPeliculasEliminar panelSalirPeliculasEliminar;
	
	private PanelTituloContratar panelTituloContratar;
	private PanelRegistrarContratar panelRegistrarContratar;
	private PanelSalirContratar panelSalirContratar;
	
	private PanelTituloRegistarProveedores panelTituloRegistarProveedores;
	private PanelRegistrarProveedores panelRegistrarProveedores;
	private PanelSalirRegistrarProveedores panelSalirRegistrarProveedores;
	
	private PanelTituloBoletosRegistrar panelTituloBoletosRegistrar;
	private PanelBoletosRegistrar panelBoletosRegistrar;
	private PanelSalirBoletosRegistrar panelSalirBoletosRegistrar;
	
	private PanelTituloResurtidosRegistrar panelTituloResurtidosRegistar;
	private PanelResurtidosRegistrar panelResurtidosRegistrar;
	private PanelSalirResurtidosRegistrar panelSalirResurtidosRegistrar;
	
	
	
	/////////////////botones/////////////////////
	private JButton botonAceptarRegistroPeliculas;
	private JButton botonSalirRegistroPeliculas;
	
	private JButton botonAceptarConsultaPeliculas;
	private JButton botonSalirConsultaPeliculas;

	private JButton botonAceptarModificacionPeliculas;
	private JButton botonSalirModificacionPeliculas;
	
	private JButton botonSalirEliminacionPeliculas;
	
	private JButton botonAceptarEmpleados;
	private JButton botonSalirEmpleados;
	
	private JButton botonAceptarProveedores;
	private JButton botonSalirProveedores;
	
	private JButton botonSalirRegistroBoletos;
	private JButton botonAceptarRegistroBoletos;

	private JButton botonSalirRegistroResurtidos;
	private JButton botonAceptarRegistroResurtidos;

	private JMenu menuSucursal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Cine frame = new Cine();
					frame.setVisible(true);
				HilosReloj hilosReloj = new HilosReloj();
				hilosReloj.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cine() {
		
		metodos = new Metodos();
			try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cine.class.getResource("/imagenes/logo.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Cinepolis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuSucursal = new JMenu("Sucursal");
		menuSucursal.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-videoc\u00E1mara-pro-50.png")));
		menuSucursal.setForeground(new Color(153, 0, 255));
		menuSucursal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuSucursal);
		
		menuEmpleados = new JMenu("Empleados");
		menuEmpleados.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-contactos-50.png")));
		menuEmpleados.setForeground(new Color(153, 0, 255));
		menuEmpleados.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuEmpleados);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-m\u00E1s-50.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloContratar = new PanelTituloContratar();
				panelRegistrarContratar =new PanelRegistrarContratar();
				panelSalirContratar= new PanelSalirContratar();
				botonAceptarEmpleados= panelSalirContratar.getBotonAceptarEmpleados();
				botonAceptarEmpleados.addActionListener(new OyenteBotonAceptarRegistroEmpleados());
				botonSalirEmpleados= panelSalirContratar.getBotonSalirEmpleados();
				botonSalirEmpleados.addActionListener(new OyenteSalirRegistroEmpleados());
				
				
				contentPane.add(panelTituloContratar, BorderLayout.NORTH);
				contentPane.add(panelRegistrarContratar, BorderLayout.CENTER);
				contentPane.add(panelSalirContratar, BorderLayout.SOUTH);
				activarMenu(false);
			metodos.cargarComboContrato();
				setVisible(true);
			}
		});
		mntmNewMenuItem.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuEmpleados.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-b\u00FAsqueda-50.png")));
		mntmNewMenuItem_1.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuEmpleados.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-actualizar-50.png")));
		mntmNewMenuItem_2.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuEmpleados.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Eliminar");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-remove-50.png")));
		mntmNewMenuItem_3.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuEmpleados.add(mntmNewMenuItem_3);
		
		menuPeliculas = new JMenu("Peliculas");
		menuPeliculas.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-proyector-de-pel\u00EDculas-50.png")));
		menuPeliculas.setForeground(new Color(153, 0, 255));
		menuPeliculas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuPeliculas);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar");
		mntmNewMenuItem_4.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-m\u00E1s-50.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloPeliculasRegistrar = new PanelTituloPeliculasRegistrar();
				panelPeliculasRegistar= new PanelPeliculasRegistar();
				panelSalirPeliculasRegistrar= new PanelSalirPeliculasRegistrar();
				
				botonAceptarRegistroPeliculas= panelSalirPeliculasRegistrar.getBotonAceptarRegistroPeliculas();
				botonAceptarRegistroPeliculas.addActionListener(new OyenteBotonAceptarRegistroPeliculas());
				botonSalirRegistroPeliculas=panelSalirPeliculasRegistrar.getBotonSalirRegistroPeliculas();
				botonSalirRegistroPeliculas.addActionListener(new OyenteSalirRegistroPeliculas());
				
				contentPane.add(panelTituloPeliculasRegistrar, BorderLayout.NORTH);
				contentPane.add(panelPeliculasRegistar, BorderLayout.CENTER);
				contentPane.add(panelSalirPeliculasRegistrar, BorderLayout.SOUTH);
				activarMenu(false);
				setVisible(true);
				
			}
		});
		
		mntmNewMenuItem_4.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuPeliculas.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Consultar");
		mntmNewMenuItem_5.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-b\u00FAsqueda-50.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			panelTituloPeliculasConsultar = new PanelTituloPeliculasConsultar();
		//	panelPeliculasConsultar= new PanelPeliculasConsultar();
			panelPeliculasConsultar2= new PanelPeliculasConsultar2();
			panelSalirPeliculasConsultar= new PanelSalirPeliculasConsultar();
			
//			botonAceptarConsultaPeliculas= panelSalirPeliculasConsultar.getBotonAceptarConsultaPeliculas();
//			botonAceptarConsultaPeliculas.addActionListener(new OyenteBotonAceptarConsultaPeliculas());
//			
			botonSalirConsultaPeliculas=panelSalirPeliculasConsultar.getBotonSalirConsultaPeliculas();
			botonSalirConsultaPeliculas.addActionListener(new OyenteSalirConsultaPeliculas());
			
			contentPane.add(panelTituloPeliculasConsultar, BorderLayout.NORTH);
			contentPane.add(panelPeliculasConsultar2, BorderLayout.CENTER);
			contentPane.add(panelSalirPeliculasConsultar, BorderLayout.SOUTH);
			activarMenu(false);
			setVisible(true);

		
		}
		});
		mntmNewMenuItem_5.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuPeliculas.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Modificar");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-actualizar-50.png")));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloPeliculasModificar= new PanelTituloPeliculasModificar();
				panelPeliculasModificar= new PanelPeliculasModificar();
				panelSalirPeliculasModificar= new PanelSalirPeliculasModificar();
				botonAceptarModificacionPeliculas=panelSalirPeliculasModificar.getBotonAceptarModificacionPeliculas();
				botonAceptarModificacionPeliculas.addActionListener(new OyenteBotonAceptarModificacionPeliculas());
				botonSalirModificacionPeliculas=panelSalirPeliculasModificar.getBotonSalirModificacionPeliculas();
				botonSalirModificacionPeliculas.addActionListener(new OyenteSalirModificacionPeliculas());
				
				contentPane.add(panelTituloPeliculasModificar, BorderLayout.NORTH);
				contentPane.add(panelPeliculasModificar, BorderLayout.CENTER);
				contentPane.add(panelSalirPeliculasModificar, BorderLayout.SOUTH);
				activarMenu(false);
				setVisible(true);
				
			}
		});
		mntmNewMenuItem_6.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuPeliculas.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Eliminar");
		mntmNewMenuItem_7.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-remove-50.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloPeliculasEliminar= new PanelTituloPeliculasEliminar();
				panelPeliculasEliminar = new PanelPeliculasEliminar();
				panelSalirPeliculasEliminar= new PanelSalirPeliculasEliminar();
				botonSalirEliminacionPeliculas= panelSalirPeliculasEliminar.getBotonSalirEliminacionPeliculas();
				botonSalirEliminacionPeliculas.addActionListener(new OyenteSalirEliminacionPeliculas());
				contentPane.add(panelTituloPeliculasEliminar, BorderLayout.NORTH);
				contentPane.add(panelPeliculasEliminar, BorderLayout.CENTER);
				contentPane.add(panelSalirPeliculasEliminar, BorderLayout.SOUTH);
				activarMenu(false);
				setVisible(true);
				
			}
		});
		mntmNewMenuItem_7.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_7.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuPeliculas.add(mntmNewMenuItem_7);
		
		menuCartelera = new JMenu("Cartelera");
		menuCartelera.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-corto-50.png")));
		menuCartelera.setForeground(new Color(153, 0, 255));
		menuCartelera.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuCartelera);
		
		menuBoletos = new JMenu("Boletos");
		menuBoletos.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-boleto-50.png")));
		menuBoletos.setForeground(new Color(153, 0, 255));
		menuBoletos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuBoletos);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Registrar");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelTituloBoletosRegistrar = new PanelTituloBoletosRegistrar();
				panelBoletosRegistrar= new PanelBoletosRegistrar();
				panelSalirBoletosRegistrar= new PanelSalirBoletosRegistrar();
				
				botonAceptarRegistroBoletos= panelSalirBoletosRegistrar.getBotonAceptarRegistroBoletos();
				botonAceptarRegistroBoletos.addActionListener(new OyenteBotonAceptarRegistroBoletos());
//				
				botonSalirRegistroBoletos=panelSalirBoletosRegistrar.getBotonSalirRegistroBoletos();
				botonSalirRegistroBoletos.addActionListener(new OyenteSalirRegistroBoletos());
		
				contentPane.add(panelTituloBoletosRegistrar, BorderLayout.NORTH);
				contentPane.add(panelBoletosRegistrar, BorderLayout.CENTER);
				contentPane.add(panelSalirBoletosRegistrar, BorderLayout.SOUTH);
				
				setVisible(true);
				activarMenu(false);
			}
		});
		mntmNewMenuItem_12.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_12.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuBoletos.add(mntmNewMenuItem_12);
		
		menuProveedores = new JMenu("Proveedores");
		menuProveedores.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-presupuesto-50.png")));
		menuProveedores.setForeground(new Color(153, 0, 255));
		menuProveedores.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuProveedores);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Registrar");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-m\u00E1s-50.png")));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloRegistarProveedores= new PanelTituloRegistarProveedores();
				panelRegistrarProveedores= new PanelRegistrarProveedores();
				panelSalirRegistrarProveedores= new PanelSalirRegistrarProveedores();
				botonAceptarProveedores= panelSalirRegistrarProveedores.getBotonAceptarProveedores();
				botonAceptarProveedores.addActionListener(new OyenteBotonAceptarRegistroProveedores());
				botonSalirProveedores= panelSalirRegistrarProveedores.getBotonSalirProveedores();
				botonSalirProveedores.addActionListener(new OyenteSalirRegistroProveedores());
				
				contentPane.add(panelTituloRegistarProveedores, BorderLayout.NORTH);
				contentPane.add(panelRegistrarProveedores, BorderLayout.CENTER);
				contentPane.add(panelSalirRegistrarProveedores, BorderLayout.SOUTH);
				activarMenu(false);
				metodos.cargarComboProveedores();
				setVisible(true);
				
				
			}
		});
		mntmNewMenuItem_8.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_8.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuProveedores.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Consultar");
		mntmNewMenuItem_9.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-b\u00FAsqueda-50.png")));
		mntmNewMenuItem_9.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_9.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuProveedores.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Modificar");
		mntmNewMenuItem_10.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-actualizar-50.png")));
		mntmNewMenuItem_10.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_10.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuProveedores.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Eliminar");
		mntmNewMenuItem_11.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-remove-50.png")));
		mntmNewMenuItem_11.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_11.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuProveedores.add(mntmNewMenuItem_11);
		
		menuResurtidos = new JMenu("Resurtidos");
		menuResurtidos.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-noticias-50.png")));
		menuResurtidos.setForeground(new Color(153, 0, 255));
		menuResurtidos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuResurtidos);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Registrar");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelTituloResurtidosRegistar = new PanelTituloResurtidosRegistrar();
				panelResurtidosRegistrar= new PanelResurtidosRegistrar();
				panelSalirResurtidosRegistrar= new PanelSalirResurtidosRegistrar();
			
				botonAceptarRegistroResurtidos= panelSalirResurtidosRegistrar.getBotonAceptarRegistroResurtidos();
				botonAceptarRegistroResurtidos.addActionListener(new OyenteBotonAceptarRegistroResurtidos());
				
				botonSalirRegistroResurtidos=panelSalirResurtidosRegistrar.getBotonSalirRegistroResurtidos();
				botonSalirRegistroResurtidos.addActionListener(new OyenteSalirRegistroResurtidos());
			
				contentPane.add(panelTituloResurtidosRegistar, BorderLayout.NORTH);
				contentPane.add(panelResurtidosRegistrar, BorderLayout.CENTER);
				contentPane.add(panelSalirResurtidosRegistrar, BorderLayout.SOUTH);
				
				setVisible(true);
				activarMenu(false);
			}
		});
		mntmNewMenuItem_13.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_13.setFont(new Font("Arial Black", Font.PLAIN, 16));
		menuResurtidos.add(mntmNewMenuItem_13);
		
		menuVentas = new JMenu("Ventas");
		menuVentas.setIcon(new ImageIcon(Cine.class.getResource("/imagenes/icons8-monedas-50.png")));
		menuVentas.setForeground(new Color(153, 0, 255));
		menuVentas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		menuBar.add(menuVentas);
		
		lbReloj = new JLabel("New label");
		lbReloj.setForeground(new Color(204, 51, 0));
		lbReloj.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuBar.add(lbReloj);
		fondo = new PanelImagenFondo();
		
		contentPane = fondo;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	
	private class PanelImagenFondo extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image img;
		private URL ruta;

		@Override
		public void paint(Graphics g) {
			ruta = this.getClass().getResource("/imagenes/fondo.jpg");
			img = new ImageIcon(ruta).getImage();
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
	
	
	 public void activarMenu(boolean estado) {
		 menuBoletos.setEnabled(estado);
		 menuCartelera.setEnabled(estado);
		 menuEmpleados.setEnabled(estado);
		 menuPeliculas.setEnabled(estado);
		 menuProveedores.setEnabled(estado);
		 menuResurtidos.setEnabled(estado);
		 menuVentas.setEnabled(estado);
		 menuSucursal.setEnabled(estado);
	 }
	///////////////////////oyentes aceptar///////////////////
	
	

	private class OyenteBotonAceptarConsultaPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Exito");

			

		}

	}


	
	
	
	
	private class OyenteBotonAceptarRegistroPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (panelPeliculasRegistar.estanVaciasPeliculas()) {
				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				metodos.guardarPelicula();
				panelPeliculasRegistar.vaciarCajasPeliculas();
			}

		}

	}

	
	private class OyenteBotonAceptarModificacionPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (panelPeliculasModificar.estanVaciasPeliculasM()) {
				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				metodos.modificarPelicula();
				panelPeliculasModificar.vaciarCajasPeliculasM();
			}

		}

	}

	
	private class OyenteBotonAceptarRegistroBoletos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (panelBoletosRegistrar.estanVaciosBoletos()) {
				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				try {
					metodos.guardarBoleto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panelBoletosRegistrar.vaciarCajasBoletos();
			}
//
		}

	}


	

	

	private class OyenteBotonAceptarRegistroResurtidos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (panelResurtidosRegistrar.estanVaciosResurtidos()) {
				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				try {
					metodos.guardarResurtido();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panelResurtidosRegistrar.vaciarCajasResurtidos();
			}
//
		}

	}
	
	
	private class OyenteBotonAceptarRegistroEmpleados implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			//if (panelPeliculasRegistar.estanVaciasPeliculas()) {
			//	JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
					//	JOptionPane.ERROR_MESSAGE);

			//} else {
				metodos.guardarEmpleados();
			//	panelPeliculasRegistar.vaciarCajasPeliculas();
			//}

		}

	}
	
	private class OyenteBotonAceptarRegistroProveedores implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			//if (panelPeliculasRegistar.estanVaciasPeliculas()) {
			//	JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
					//	JOptionPane.ERROR_MESSAGE);

			//} else {
				metodos.guardarProveedores();
			//	panelPeliculasRegistar.vaciarCajasPeliculas();
			//}

		}

	}
	
	///////////////////////////oyentes salir///////////////////
	private class OyenteSalirRegistroPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (salir == 0) {
				panelTituloPeliculasRegistrar.setVisible(false);
				panelPeliculasRegistar.setVisible(false);
				panelSalirPeliculasRegistrar.setVisible(false);
				
				
				contentPane.remove(panelTituloPeliculasRegistrar);
				contentPane.remove(panelPeliculasRegistar);
				contentPane.remove(panelSalirPeliculasRegistrar);
				
				
				panelTituloPeliculasRegistrar = null;
				panelPeliculasRegistar = null;
				panelSalirPeliculasRegistrar = null;
				
				activarMenu(true);
				
				System.gc();
				
			}
		}
	}
	
	
	
private class OyenteSalirConsultaPeliculas implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloPeliculasConsultar.setVisible(false);
			panelPeliculasConsultar2.setVisible(false);
			panelSalirPeliculasConsultar.setVisible(false);
			
			
			contentPane.remove(panelTituloPeliculasConsultar);
			contentPane.remove(panelPeliculasConsultar2);
			contentPane.remove(panelSalirPeliculasConsultar);
			
			
			panelTituloPeliculasConsultar = null;
			panelPeliculasConsultar2 = null;
			panelSalirPeliculasConsultar = null;
			
			
			activarMenu(true);
			System.gc();
			
		}

	}

}
private class OyenteSalirModificacionPeliculas implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloPeliculasModificar.setVisible(false);
			panelPeliculasModificar.setVisible(false);
			panelSalirPeliculasModificar.setVisible(false);
			
			
			contentPane.remove(panelTituloPeliculasModificar);
			contentPane.remove(panelPeliculasModificar);
			contentPane.remove(panelSalirPeliculasModificar);
			
			
			panelTituloPeliculasModificar = null;
			panelPeliculasModificar = null;
			panelSalirPeliculasModificar = null;
			
			activarMenu(true);
			System.gc();
			
		}
	}
}

private class OyenteSalirEliminacionPeliculas implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloPeliculasEliminar.setVisible(false);
			panelPeliculasEliminar.setVisible(false);
			panelSalirPeliculasEliminar.setVisible(false);
			
			
			contentPane.remove(panelTituloPeliculasEliminar);
			contentPane.remove(panelPeliculasEliminar);
			contentPane.remove(panelSalirPeliculasEliminar);
			
			
			panelTituloPeliculasEliminar = null;
			panelPeliculasEliminar = null;
			panelSalirPeliculasEliminar = null;
			
			activarMenu(true);
			System.gc();
			
		}
	}
}


private class OyenteSalirRegistroEmpleados implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloContratar.setVisible(false);
			panelRegistrarContratar.setVisible(false);
			panelSalirContratar.setVisible(false);
			
			
			contentPane.remove(panelTituloContratar);
			contentPane.remove(panelRegistrarContratar);
			contentPane.remove(panelSalirContratar);
			
			
			panelTituloContratar = null;
			panelRegistrarContratar = null;
			panelSalirContratar = null;
			
			activarMenu(true);
			System.gc();
			
		}
	}
}

private class OyenteSalirRegistroProveedores implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloRegistarProveedores.setVisible(false);
			panelRegistrarProveedores.setVisible(false);
			panelSalirRegistrarProveedores.setVisible(false);
			
			
			contentPane.remove(panelTituloRegistarProveedores);
			contentPane.remove(panelRegistrarProveedores);
			contentPane.remove(panelSalirRegistrarProveedores);
			
			
			panelTituloRegistarProveedores = null;
			panelRegistrarProveedores = null;
			panelSalirRegistrarProveedores = null;
			
			activarMenu(true);
			System.gc();
			
		}
	}
}

private class OyenteSalirRegistroResurtidos implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloResurtidosRegistar.setVisible(false);
			panelResurtidosRegistrar.setVisible(false);
			panelSalirResurtidosRegistrar.setVisible(false);
			
			
			
			
			
			contentPane.remove(panelTituloResurtidosRegistar);
			contentPane.remove(panelResurtidosRegistrar);
			contentPane.remove(panelSalirResurtidosRegistrar);
			
			
			panelTituloResurtidosRegistar = null;
			panelResurtidosRegistrar = null;
			panelSalirResurtidosRegistrar = null;
			
			activarMenu(true);
			
			System.gc();
			
		}
	}
}

private class OyenteSalirRegistroBoletos implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salir == 0) {
			panelTituloBoletosRegistrar.setVisible(false);
			panelBoletosRegistrar.setVisible(false);
			panelSalirBoletosRegistrar.setVisible(false);
			
			
			
			
			
			contentPane.remove(panelTituloBoletosRegistrar);
			contentPane.remove(panelBoletosRegistrar);
			contentPane.remove(panelSalirBoletosRegistrar);
			
			
			panelTituloBoletosRegistrar = null;
			panelBoletosRegistrar = null;
			panelSalirBoletosRegistrar = null;
			
			
			activarMenu(true);
			System.gc();
			
		}
	}
}


	

}
	