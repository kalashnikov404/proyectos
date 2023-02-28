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
import vista.panelesPeliculas.PanelBoletosRegistrar;
import vista.panelesPeliculas.PanelPeliculasConsultar;
import vista.panelesPeliculas.PanelPeliculasEliminar;
import vista.panelesPeliculas.PanelPeliculasRegistar;
import vista.panelesPeliculas.PanelResurtidosRegistrar;
import vista.panelesPeliculas.PanelSalirBoletosRegistrar;
import vista.panelesPeliculas.PanelSalirPeliculasConsultar;
import vista.panelesPeliculas.PanelSalirPeliculasEliminar;

import vista.panelesPeliculas.PanelSalirPeliculasRegistrar;
import vista.panelesPeliculas.PanelSalirResurtidosRegistrar;
import vista.panelesPeliculas.PanelTituloBoletosRegistar;
import vista.panelesPeliculas.PanelTituloPeliculasConsultar;
import vista.panelesPeliculas.PanelTituloPeliculasEliminar;
import vista.panelesPeliculas.PanelTituloPeliculasRegistrar;
import vista.panelesPeliculas.PanelTituloResurtidosRegistrar;

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

public class Cine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Metodos metodos;
	//////////////////paneles////////////////////////
	private JPanel contentPane;
	private PanelImagenFondo fondo;
	
	private PanelTituloPeliculasRegistrar panelTituloPeliculasRegistrar;
	private PanelPeliculasRegistar panelPeliculasRegistar;
	private PanelSalirPeliculasRegistrar panelSalirPeliculasRegistrar;
	
	
	private PanelTituloPeliculasConsultar panelTituloPeliculasConsultar;
	private PanelPeliculasConsultar panelPeliculasConsultar;
	private PanelSalirPeliculasConsultar panelSalirPeliculasConsultar;
	
	

	private PanelTituloPeliculasEliminar panelTituloPeliculasEliminar;
	private PanelPeliculasEliminar panelPeliculasEliminar;
	private PanelSalirPeliculasEliminar panelSalirPeliculasEliminar;
	
	
	

	private PanelTituloBoletosRegistar panelTituloBoletosRegistrar;
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

	private JButton botonSalirRegistroBoletos;
	private JButton botonAceptarRegistroBoletos;

	

	private JButton botonSalirRegistroResurtidos;
	private JButton botonAceptarRegistroResurtidos;



	private JButton botonSalirEliminacionPeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cine frame = new Cine();
					frame.setVisible(true);
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
		
		JMenu mnNewMenu = new JMenu("Empleados");
		mnNewMenu.setForeground(new Color(153, 0, 255));
		mnNewMenu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Eliminar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
			}
		});
		mntmNewMenuItem_3.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Peliculas");
		mnNewMenu_1.setForeground(new Color(153, 0, 255));
		mnNewMenu_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloPeliculasRegistrar = new PanelTituloPeliculasRegistrar();
				panelPeliculasRegistar= new PanelPeliculasRegistar();
				panelSalirPeliculasRegistrar= new PanelSalirPeliculasRegistrar();
				
				botonAceptarRegistroPeliculas= panelSalirPeliculasRegistrar.getBotonAceptarRegistroPeliculas();
				botonAceptarRegistroPeliculas.addActionListener(new OyenteBotonAceptarConsultaPeliculas());
				
				botonSalirRegistroPeliculas=panelSalirPeliculasRegistrar.getBotonSalirRegistroPeliculas();
				botonSalirRegistroPeliculas.addActionListener(new OyenteSalirConsultaPeliculas());
				
				contentPane.add(panelTituloPeliculasRegistrar, BorderLayout.NORTH);
				contentPane.add(panelPeliculasRegistar, BorderLayout.CENTER);
				contentPane.add(panelSalirPeliculasRegistrar, BorderLayout.SOUTH);
				
				setVisible(true);
				
			}
		});
		
		mntmNewMenuItem_4.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Consultar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			panelTituloPeliculasConsultar = new PanelTituloPeliculasConsultar();
			panelPeliculasConsultar= new PanelPeliculasConsultar();
			panelSalirPeliculasConsultar= new PanelSalirPeliculasConsultar();
			
//			botonAceptarConsultaPeliculas= panelSalirPeliculasConsultar.getBotonAceptarConsultaPeliculas();
//			botonAceptarConsultaPeliculas.addActionListener(new OyenteBotonAceptarConsultaPeliculas());
//			
			botonSalirConsultaPeliculas=panelSalirPeliculasConsultar.getBotonSalirConsultaPeliculas();
			botonSalirConsultaPeliculas.addActionListener(new OyenteSalirConsultaPeliculas());
			
			contentPane.add(panelTituloPeliculasConsultar, BorderLayout.NORTH);
			contentPane.add(panelPeliculasConsultar, BorderLayout.CENTER);
			contentPane.add(panelSalirPeliculasConsultar, BorderLayout.SOUTH);
			
			setVisible(true);

		
		}
		});
		mntmNewMenuItem_5.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Modificar");
		mntmNewMenuItem_6.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Eliminar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
		panelTituloPeliculasEliminar = new PanelTituloPeliculasEliminar();
		panelPeliculasEliminar= new PanelPeliculasEliminar();
		panelSalirPeliculasEliminar= new PanelSalirPeliculasEliminar();
		
//		botonAceptarConsultaPeliculas= panelSalirPeliculasConsultar.getBotonAceptarConsultaPeliculas();
//		botonAceptarConsultaPeliculas.addActionListener(new OyenteBotonAceptarConsultaPeliculas());
//		
		botonSalirEliminacionPeliculas=panelSalirPeliculasEliminar.getBotonSalirEliminacionPeliculas();
		botonSalirEliminacionPeliculas.addActionListener(new OyenteSalirEliminacionPeliculas());
		
		contentPane.add(panelTituloPeliculasEliminar, BorderLayout.NORTH);
		contentPane.add(panelPeliculasEliminar, BorderLayout.CENTER);
		contentPane.add(panelSalirPeliculasEliminar, BorderLayout.SOUTH);
		
	
		
		
				setVisible(true);
				
				
			}
		});
		mntmNewMenuItem_7.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_7.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("Boletos");
		mnNewMenu_2.setForeground(new Color(153, 0, 255));
		mnNewMenu_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Registrar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTituloBoletosRegistrar = new PanelTituloBoletosRegistar();
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
				
			}
		});
		mntmNewMenuItem_8.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_8.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		
		
		
		JMenu mnNewMenu_3 = new JMenu("Ventas");
		mnNewMenu_3.setForeground(new Color(153, 0, 255));
		mnNewMenu_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_3);
		fondo = new PanelImagenFondo();
		
		
		

		JMenu mnNewMenu_4 = new JMenu("Resurtidos");
		mnNewMenu_4.setForeground(new Color(153, 0, 255));
		mnNewMenu_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_4);
		fondo = new PanelImagenFondo();
		
		

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
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
				
			}
		});
		mntmNewMenuItem_9.setForeground(new Color(0, 153, 255));
		mntmNewMenuItem_9.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		
		
		
		
		
		
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
	///////////////////////oyentes aceptar///////////////////
	
	

	private class OyenteBotonAceptarConsultaPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Exito");

			

		}

	}


	private class OyenteSalirConsultaPeliculas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int salir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de salir?", "Advertencia",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (salir == 0) {
				panelTituloPeliculasConsultar.setVisible(false);
				panelPeliculasConsultar.setVisible(false);
				panelSalirPeliculasConsultar.setVisible(false);
				
				
				
				
				
				contentPane.remove(panelTituloPeliculasConsultar);
				contentPane.remove(panelPeliculasConsultar);
				contentPane.remove(panelSalirPeliculasConsultar);
				
				
				panelTituloPeliculasConsultar = null;
				panelPeliculasConsultar = null;
				panelSalirPeliculasConsultar = null;
				
				
				
				System.gc();
				
			}

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
				
				
				
				System.gc();
				
			}
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
				
				
				
				System.gc();
				
			}
		}
		}
	
	
	

	private class OyenteBotonAceptarRegistroBoletos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

//			if (panelBoletosRegistrar.estanVaciosBoletos()) {
//				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
//						JOptionPane.ERROR_MESSAGE);

//			} else {
				try {
					metodos.guardarBoleto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				panelBoletosRegistrar.vaciarCajasBoletos();
//			}
//
		}

	}


	

	

	private class OyenteBotonAceptarRegistroResurtidos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

//			if (panelBoletosRegistrar.estanVaciosBoletos()) {
//				JOptionPane.showMessageDialog(null, "Error aun hay campos sin llenar", "Error",
//						JOptionPane.ERROR_MESSAGE);

//			} else {
				try {
					metodos.guardarResurtido();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				panelBoletosRegistrar.vaciarCajasBoletos();
//			}
//
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
				
				
				
				System.gc();
				
			}
		}
	}

	
	
	
}
	
	
	
	

	