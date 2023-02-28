package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class VentanaPrueba extends JFrame {

	public JPanel contentPane;

	public JPanel getContentPanel() {
		return contentPane;
	}

	public void setJPanel(JPanel contentPane) {
		this.contentPane = contentPane;
	}
   
	private MenuPrincipal menuPrincipal;

	private JButton registrarC;
	private JButton registrarSalida;
	private JButton listarClientes;
	private JButton modificarClientes;
	private JButton eliminarClientes;
	private JButton gestionarMenu;
	private JButton eliminarC;
	private JButton consultarC;
	private JButton listarC;
	private JButton btnSalir;
	private JMenuItem menuItem = null;
	

	private JMenu menuCliente;
	private GestionOpcionN gestionOpcionN;
	private JToolBar toolBar;

	JPanel panelCentro;

	private RegistroCafecito registroCafecito;
	private ModificacionCafecitos modificacionCafecitos;
	private EliminacionCafecitos eliminacionCafecitos;
	private ListaCafecitos listaCafecitos;
	private ConsultaCafecitos consultaCafecitos;
	
	
	private RegistroEmpleado registroEmpleado;
	private ModificacionEmpleados modificacionEmpleados;
	private EliminacionEmpleados eliminacionEmpleados;
	private ConsultaEmpleados consultaEmpleados;
	private ListaEmpleados listaEmpleados;
	
	
	private RegistroInsumo registroInsumo;
	private ListaInsumos listaInsumos;
	private ModificacionInsumos modificacionInsumos;
	private EliminacionInsumos eliminacionInsumos;
	private ConsultaInsumos consultaInsumos;
	
	private RegistroLugar registroLugar;
	private ListaLugares listaLugares;

	private ModificacionLugares modificacionLugares;
	private EliminacionLugares eliminacionLugares;
	private ConsultaLugares consultaLugares;
	
	private RegistroPlatillo registroPlatillo;
	private ModificacionPlatillos modificacionPlatillos;
	private ListaPlatillos listaPlatillos;
	private EliminacionPlatillos eliminacionPlatillos;
	private ConsultaPlatillos consultaPlatillos;
	
	
	private RegistroOrden registroOrden;
	private ListaTickets listaTickets;
	
	private RegistroResurtido registroResurtido;
	private ListaResurtidos listaResurtidos;
	
//	private RegistroSalidaCliente registroSalidaCliente;
//	private ListaClientes listaClientes;
//	private ModificacionesClientes modificacionesClientes;
//	private EliminacionClientes eliminacionClientes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							UIDefaults ui = UIManager.getLookAndFeelDefaults();
							ui.put("PopupMenu.background", Color.RED);
							ui.put("Menu.background", Color.RED);
							ui.put("Menu.opaque", true);
							ui.put("MenuItem.background", Color.CYAN);
							ui.put("MenuItem.opaque", true);
							// this looks not so good, but without the margins above/below are still grey
							ui.put("PopupMenu.contentMargins", null);

							Font f = new Font("sans-serif", Font.PLAIN, 20);
							UIManager.put("Menu.font", f);

							UIManager.put("MenuItem.font", f);
							
							break;
						}
					}

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaPrueba() {

		Image imgina = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/casita2.png")).getImage();

		Image empleado = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/empleado2.png")).getImage();

		Image despensa = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/despensa2.png")).getImage();

		Image lugar = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/lugar2.png")).getImage();
		
		Image menuPlatillo = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/menu.png")).getImage();

		Image servicio = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/servicio.png")).getImage();
		Image pagar = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/pagar.png")).getImage();
		

		Image recibo = new ImageIcon(VentanaPrueba.class .getResource("/imagenes/recibo2.png")).getImage();
		Image resurtir = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/resurtir.png")).getImage();


		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 794);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuCliente = new JMenu("Le cafecito");
		menuCliente.setBackground(Color.WHITE);
		menuCliente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				menuPrincipal = new MenuPrincipal();

				// boton gestion cafecito
				registrarC = menuPrincipal.getRegistrar();
				// Create the popup menu.

				JPopupMenu popup = new JPopupMenu();

				JMenuItem imagen1 = new JMenuItem("Registrar Cafecito",
						new ImageIcon(imgina.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen1.getAccessibleContext().setAccessibleDescription("Registrar Cafecito");

				imagen1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							registroCafecito = new RegistroCafecito();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(registroCafecito, BorderLayout.CENTER);
						setVisible(true);
						repaint();

					}
				});

				popup.add(imagen1);

				JMenuItem imagen2 = new JMenuItem("Listar Cafecito",
						new ImageIcon(imgina.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen2.getAccessibleContext().setAccessibleDescription("Listar Cafecito");

				imagen2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						

						listaCafecitos = new ListaCafecitos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(listaCafecitos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
						
				


					}
				});

			

				popup.add(imagen2);

				JMenuItem imagen3 = new JMenuItem("Modificar Cafecito",
						new ImageIcon(imgina.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen3.getAccessibleContext().setAccessibleDescription("Modificar Cafecito");

				imagen3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {



						modificacionCafecitos = new ModificacionCafecitos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(modificacionCafecitos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
					}
				});

				popup.add(imagen3);

				JMenuItem imagen4 = new JMenuItem("Consultar Cafecito",
						new ImageIcon(imgina.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen4.getAccessibleContext().setAccessibleDescription("Consultar Cafecito");

				imagen4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						consultaCafecitos= new ConsultaCafecitos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(consultaCafecitos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});
			
				popup.add(imagen4);
				
				

				JMenuItem imagen5 = new JMenuItem("Eliminar Cafecito",
						new ImageIcon(imgina.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen5.getAccessibleContext().setAccessibleDescription("Eliminar Cafecito");

				imagen5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						
					 eliminacionCafecitos = new 	EliminacionCafecitos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(eliminacionCafecitos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
					
						
						
					}
				});
			
				popup.add(imagen5);
				

				registrarC.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup.show(e.getComponent(), e.getX(), e.getY());

					}
				});

				// boton 2 jmenuitem gestionar personal

				registrarSalida = menuPrincipal.getRegistrarSalida();

				JPopupMenu popup2 = new JPopupMenu();

				JMenuItem imagen11 = new JMenuItem("Registrar Empleado",
						new ImageIcon(empleado.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen11.getAccessibleContext().setAccessibleDescription("Registrar Empleado");

				imagen11.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

							try {
								registroEmpleado = new RegistroEmpleado();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(registroEmpleado, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
					
					}
				});

				
				
				
				
				popup2.add(imagen11);

				JMenuItem imagen22 = new JMenuItem("Listar Empleado",
						new ImageIcon(empleado.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen22.getAccessibleContext().setAccessibleDescription("Listar Empleado");

				imagen22.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						listaEmpleados = new ListaEmpleados();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(listaEmpleados, BorderLayout.CENTER);
						setVisible(true);
						repaint();

					}
				});

				popup2.add(imagen22);

				JMenuItem imagen33 = new JMenuItem("Modificar Empleado",
						new ImageIcon(empleado.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen33.getAccessibleContext().setAccessibleDescription("Modificar Empleado");

				imagen33.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {



						modificacionEmpleados= new ModificacionEmpleados();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(modificacionEmpleados, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup2.add(imagen33);

				JMenuItem imagen44 = new JMenuItem("Consultar Empleado",
						new ImageIcon(empleado.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen44.getAccessibleContext().setAccessibleDescription("Consultar Empleado");

				imagen44.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						consultaEmpleados = new ConsultaEmpleados();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(consultaEmpleados, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
						
				

					}
				});

				popup2.add(imagen44);
				
				

				JMenuItem imagen55 = new JMenuItem("Eliminar Empleado",
						new ImageIcon(empleado.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen55.getAccessibleContext().setAccessibleDescription("Eliminar Empleado");

				imagen55.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						

						 eliminacionEmpleados = new 	EliminacionEmpleados();
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(eliminacionEmpleados, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							
					}
				});

				popup2.add(imagen55);

				registrarSalida.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup2.show(e.getComponent(), e.getX(), e.getY());

					}
				});

				modificarClientes = menuPrincipal.getModificarClientes();

				JPopupMenu popup3 = new JPopupMenu();

				JMenuItem imagen111 = new JMenuItem("Registrar Insumo",
						new ImageIcon(despensa.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen111.getAccessibleContext().setAccessibleDescription("Registrar Insumo");

				imagen111.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						
						 try {
							registroInsumo = new 	RegistroInsumo();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(registroInsumo, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							
						
						
					}
				});

				popup3.add(imagen111);

				JMenuItem imagen222 = new JMenuItem("Listar Insumo",
						new ImageIcon(despensa.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen222.getAccessibleContext().setAccessibleDescription("Listar Insumo");

				imagen222.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						listaInsumos = new ListaInsumos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(listaInsumos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup3.add(imagen222);

				JMenuItem imagen333 = new JMenuItem("Modificar Insumo",
						new ImageIcon(despensa.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen333.getAccessibleContext().setAccessibleDescription("Modificar Insumo");

				imagen333.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						modificacionInsumos = new ModificacionInsumos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(modificacionInsumos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup3.add(imagen333);

				JMenuItem imagen444 = new JMenuItem("Consultar Insumo",
						new ImageIcon(despensa.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen444.getAccessibleContext().setAccessibleDescription("Consultar Insumo");

				imagen444.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						consultaInsumos= new ConsultaInsumos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(consultaInsumos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup3.add(imagen444);

				JMenuItem imagen555 = new JMenuItem("Eliminar Insumo",
						new ImageIcon(despensa.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen555.getAccessibleContext().setAccessibleDescription("Eliminar Insumo");

				imagen555.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						 
						eliminacionInsumos = new EliminacionInsumos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(eliminacionInsumos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
					}
				});

				popup3.add(imagen555);

				modificarClientes.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup3.show(e.getComponent(), e.getX(), e.getY());

					}
				});

				listarClientes = menuPrincipal.getListarClientes();

				JPopupMenu popup4 = new JPopupMenu();

				JMenuItem imagen1111 = new JMenuItem("Registrar Lugar",
						new ImageIcon(lugar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen1111.getAccessibleContext().setAccessibleDescription("Registrar Lugar");

				imagen1111.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {



						 try {
							registroLugar = new RegistroLugar();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(registroLugar, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							
					}
				});

				popup4.add(imagen1111);

				JMenuItem imagen2222 = new JMenuItem("Listar Lugar",
						new ImageIcon(lugar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen2222.getAccessibleContext().setAccessibleDescription("Listar Lugar");

				imagen2222.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						 listaLugares = new ListaLugares();
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(listaLugares, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							
					}
				});

				popup4.add(imagen2222);

				JMenuItem imagen3333 = new JMenuItem("Modificar Lugar",
						new ImageIcon(lugar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen3333.getAccessibleContext().setAccessibleDescription("Modificar Lugar");

				imagen3333.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						modificacionLugares = new ModificacionLugares();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(modificacionLugares, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup4.add(imagen3333);

				JMenuItem imagen4444 = new JMenuItem("Consultar Lugar",
						new ImageIcon(lugar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen4444.getAccessibleContext().setAccessibleDescription("Consulcar Lugar");

				imagen4444.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						consultaLugares= new ConsultaLugares();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(consultaLugares, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup4.add(imagen4444);
				

				JMenuItem imagen5555 = new JMenuItem("Eliminar Lugar",
						new ImageIcon(lugar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen5555.getAccessibleContext().setAccessibleDescription("Eliminar Lugar");

				imagen5555.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						eliminacionLugares = new EliminacionLugares();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(eliminacionLugares, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup4.add(imagen5555);

				listarClientes.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup4.show(e.getComponent(), e.getX(), e.getY());

					}
				});
				
				
				

				gestionarMenu = menuPrincipal.getGestionarMenu();

				JPopupMenu popup5 = new JPopupMenu();

				JMenuItem imagen11111 = new JMenuItem("Registrar Platillo",
						new ImageIcon(menuPlatillo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen11111.getAccessibleContext().setAccessibleDescription("Registrar Platillo");

				imagen11111.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						 try {
							registroPlatillo = new RegistroPlatillo();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(registroPlatillo, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							
						
					}
				});

				popup5.add(imagen11111);

				JMenuItem imagen22222 = new JMenuItem("Listar Platillo",
						new ImageIcon(menuPlatillo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen22222.getAccessibleContext().setAccessibleDescription("Listar Platillo");

				imagen22222.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						 listaPlatillos = new ListaPlatillos();
							menuPrincipal.setVisible(false);
							contentPane.removeAll();
							menuPrincipal = null;
							repaint();
							contentPane.add(listaPlatillos, BorderLayout.CENTER);
							setVisible(true);
							repaint();
							

					}
				});

				popup5.add(imagen22222);

				JMenuItem imagen33333 = new JMenuItem("Modificar Platillo",
						new ImageIcon(menuPlatillo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen33333.getAccessibleContext().setAccessibleDescription("Modificar Platillo");

				imagen33333.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						modificacionPlatillos = new ModificacionPlatillos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(modificacionPlatillos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup5.add(imagen33333);

				JMenuItem imagen44444 = new JMenuItem("Consultar Platillo",
						new ImageIcon(menuPlatillo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen44444.getAccessibleContext().setAccessibleDescription("Consulcar Platillo");

				imagen44444.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						consultaPlatillos = new ConsultaPlatillos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(consultaPlatillos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup5.add(imagen44444);
				

				JMenuItem imagen55555 = new JMenuItem("Eliminar Platillo",
						new ImageIcon(menuPlatillo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen55555.getAccessibleContext().setAccessibleDescription("Eliminar Platillo");

				imagen55555.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {


						eliminacionPlatillos = new EliminacionPlatillos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(eliminacionPlatillos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
					}
				});

				popup5.add(imagen55555);

				gestionarMenu.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup5.show(e.getComponent(), e.getX(), e.getY());

					}
				});


				eliminarClientes = menuPrincipal.getEliminarClientes();

				JPopupMenu popup6 = new JPopupMenu();

				JMenuItem imagen111111 = new JMenuItem("Ordenar Platillo",
						new ImageIcon(servicio.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen111111.getAccessibleContext().setAccessibleDescription("Ordenar Platillo");

				imagen111111.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							registroOrden = new RegistroOrden();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(registroOrden, BorderLayout.CENTER);
						setVisible(true);
						repaint();

					}
				});

				popup6.add(imagen111111);
//
//				JMenuItem imagen222222 = new JMenuItem("Pagar Platillo",
//						new ImageIcon(servicio.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
//
//				imagen222222.getAccessibleContext().setAccessibleDescription("Pagar Platillo");
//
//				imagen222222.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//
//						JOptionPane.showMessageDialog(null, "Soy pagar platillo");
//
//					}
//				});

//				popup6.add(imagen222222);

				JMenuItem imagen333333 = new JMenuItem("Listar Tickets",
						new ImageIcon(recibo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen333333.getAccessibleContext().setAccessibleDescription("Listar Tickets");

				imagen333333.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						listaTickets = new 	ListaTickets();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(listaTickets, BorderLayout.CENTER);
						setVisible(true);
						repaint();

					}
				});
				
			

				popup6.add(imagen333333);

				JMenuItem imagen444444 = new JMenuItem("Resurtir Almacen",
						new ImageIcon(resurtir.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen444444.getAccessibleContext().setAccessibleDescription("Resurtir Almacen");

				imagen444444.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							registroResurtido = new RegistroResurtido();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(registroResurtido, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
//						private RegistroResurtido registroResurtido;
//						private ListaResurtidos listaResurtidos;
						
					}
				});

				popup6.add(imagen444444);
				

				JMenuItem imagen555555 = new JMenuItem("Listar Resurtidos",
						new ImageIcon(recibo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

				imagen555555.getAccessibleContext().setAccessibleDescription("Listar Resurtidos");

				imagen555555.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						
						listaResurtidos = new ListaResurtidos();
						menuPrincipal.setVisible(false);
						contentPane.removeAll();
						menuPrincipal = null;
						repaint();
						contentPane.add(listaResurtidos, BorderLayout.CENTER);
						setVisible(true);
						repaint();
						
//						private RegistroResurtido registroResurtido;
//						private ListaResurtidos listaResurtidos;
						
						

					}
				});

				popup6.add(imagen555555);

				eliminarClientes.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						JLabel fondo = new JLabel("");
						panelCentro.add(fondo);
						Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg"))
								.getImage();
						ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

						fondo.setIcon(img2);

						popup6.show(e.getComponent(), e.getX(), e.getY());

					}
				});

				contentPane.add(menuPrincipal, BorderLayout.WEST);

				setVisible(true);

				contentPane.add(panelCentro, BorderLayout.CENTER);

				JLabel fondo = new JLabel("");

				panelCentro.add(fondo);

				Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
				ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));
				fondo.setIcon(img2);

			}
		});
		menuCliente.setFont(new Font("Curlz MT", Font.BOLD | Font.ITALIC, 40));
		menuCliente.setForeground(Color.RED);
		menuBar.add(menuCliente);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);

		JLabel fondo = new JLabel("");

		panelCentro.add(fondo);
		Image img = new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

		fondo.setIcon(img2);
	
	
		}
	

	
	}


