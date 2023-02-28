package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import excepciones.ConexionException;
import javax.swing.SwingConstants;


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
	
	
	private ListarBarras listarBarras;


	private TratadoCsv tratadoCsv;
	private TratadoJson tratadoJson;
	
	private MenuArchivosMetodos menuArchivosMetodos;

//	
//	private MostrarGrafica mostrarGrafica;
//	private ReducirDatos reducirDatos;


	
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
	
	

	private JMenu menuArchivos;
	private MenuArchivos menuArchivoPrincipal;
	
	
	

	private JMenu menuBarras;
	private MenuGraficas menuBarrasPrincipal;
	
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
	
	
	private JButton btnTratadoCsv;
	private JButton btnTratadoTxt;
	private JButton btnTratadoJson;
	private JButton btnTratadoXml;
	
	private JButton btnTratado;
	private JButton btnMostrarGraficas;
	
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
         menuBar.setBackground(Color.PINK);	
		setJMenuBar(menuBar);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		
	
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ims.png")));
		lblNewLabel.setBounds(10, 0, 1340, 676);
		panel.add(lblNewLabel);

		menuCliente = new JMenu("Cliente");
		menuCliente.setHorizontalAlignment(SwingConstants.CENTER);
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuCliente.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuCliente.setForeground(SystemColor.textHighlight);
		menuBar.add(menuCliente);
		
		menuProveedor = new JMenu("Proveedor");
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuProveedor.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuProveedor.setForeground(SystemColor.textHighlight);
		menuBar.add(menuProveedor);
		
		menuCalentador = new JMenu("Calentador");
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuCalentador.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuCalentador.setForeground(SystemColor.textHighlight);
		menuBar.add(menuCalentador);
		
		menuHorario = new JMenu("Horario");
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuHorario.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuHorario.setForeground(SystemColor.textHighlight);
		menuBar.add(menuHorario);
		
		menuTransporte = new JMenu("Transporte");
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuTransporte.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuTransporte.setForeground(SystemColor.textHighlight);
		menuBar.add(menuTransporte);
		
		menuSocio = new JMenu("Socio");
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
				fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

				setVisible(true);
				repaint();
			}
		});
		menuSocio.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		menuSocio.setForeground(SystemColor.textHighlight);
		menuBar.add(menuSocio);
	
		
	
	menuArchivos = new JMenu("Archivos");
	menuArchivos.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) { 

			menuArchivoPrincipal = new MenuArchivos();
			

			btnTratado = menuArchivoPrincipal.getBtnTratado();
			btnTratado.addActionListener(new OyenteTratadoMetodos());

			btnTratadoCsv = menuArchivoPrincipal.getBtnTratadoCsv();
			btnTratadoCsv.addActionListener(new OyenteTratadoCsv());
			
			btnTratadoJson = menuArchivoPrincipal.getBtnTratadoJson();
			btnTratadoJson.addActionListener(new OyenteTratadoJson());
			
			
			
			contentPane.add(menuArchivoPrincipal, BorderLayout.WEST);
			setVisible(true);

			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);

			JLabel fondo = new JLabel("");
			panel.add(fondo);
			fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

			setVisible(true);
			repaint();
		}
	});
	
	menuArchivos.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
	menuArchivos.setForeground(SystemColor.textHighlight);
	menuBar.add(menuArchivos);

	
	menuBarras = new JMenu("Barras");
	menuBarras.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) { 

			menuBarrasPrincipal = new MenuGraficas();
			

			btnMostrarGraficas = menuBarrasPrincipal.getBtnMostrarGraficas();
			btnMostrarGraficas.addActionListener(new OyenteMostrarBarras());
			
			
			
			contentPane.add(menuBarrasPrincipal, BorderLayout.WEST);
			setVisible(true);

			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);

			JLabel fondo = new JLabel("");
			panel.add(fondo);
			fondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/ronop.png")));

			setVisible(true);
			repaint();
		}
	});
	
	
	menuBarras.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
	menuBarras.setForeground(SystemColor.textHighlight);
	menuBar.add(menuBarras);
}
		

	
	private class OyenteMostrarBarras implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
 				try {
					listarBarras = new ListarBarras(usuario);
				} catch (ConexionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			
			menuBarrasPrincipal.setVisible(false);
			contentPane.removeAll();
			menuBarrasPrincipal=null;
			repaint();

			contentPane.add(listarBarras, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
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

	
private class OyenteTratadoCsv implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			tratadoCsv = new TratadoCsv(usuario);
		} catch (ConexionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		menuArchivoPrincipal.setVisible(false);
		contentPane.removeAll();
		menuArchivoPrincipal=null;
		repaint();

		contentPane.add(tratadoCsv, BorderLayout.CENTER);
		setVisible(true);
		repaint();
	}
}





private class OyenteTratadoJson implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			tratadoJson = new TratadoJson(usuario);
		} catch (ConexionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		menuArchivoPrincipal.setVisible(false);
		contentPane.removeAll();
		menuArchivoPrincipal=null;
		repaint();

		contentPane.add(tratadoJson, BorderLayout.CENTER);
		setVisible(true);
		repaint();
	}
}


private class OyenteTratadoMetodos implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			menuArchivosMetodos = new MenuArchivosMetodos(usuario);
		} catch (ConexionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		menuArchivoPrincipal.setVisible(false);
		contentPane.removeAll();
		menuArchivoPrincipal=null;
		repaint();

		contentPane.add(menuArchivosMetodos, BorderLayout.CENTER);
		setVisible(true);
		repaint();
	}
}



public class jpColor extends javax.swing.JPanel{
    private Color color1 = new Color(0,0,0);
    private Color color2 = new Color(0,0,0);
    
    public jpColor(){
    }
    
    public jpColor(Color c1, Color c2){
        color1 = c1;
        color2 = c2;        
    }
    
    @Override
    public void paint(Graphics g) {    
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();                        
        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1.darker(),0.0f ,getHeight(), color2.darker()));        
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);        
    }
    
    public void setRandomColor(){
        Random rand = new Random();
        this.color1 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        this.color2 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
    }
    
    public void setVistaColor(){        
        this.color1 = new Color(66,111,166);
        this.color2 = new Color(103,174,118);        
    }
}
}
