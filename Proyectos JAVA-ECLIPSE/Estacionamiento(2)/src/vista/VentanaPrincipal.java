package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private MenuPrincipal menuPrincipal;

	private JButton registrarC;
	private JButton registrarSalida;
	private JButton listarClientes;
	private JButton modificarClientes;
	private JButton eliminarClientes;
	private JButton eliminarC;
	private JButton consultarC;
	private JButton listarC;
	private JButton btnSalir;

	private JMenu menuCliente;
	private JMenu menuPensionado;

	JPanel panelCentro;

	private RegistroCliente registroCliente;
	private RegistroSalidaCliente registroSalidaCliente;
	private ListaClientes listaClientes;
	private ModificacionesClientes modificacionesClientes;
	private EliminacionClientes eliminacionClientes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuCliente = new JMenu("Clientes");
		menuCliente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				menuPrincipal = new MenuPrincipal();
				registrarC = menuPrincipal.getRegistrar();
				registrarC.addActionListener(new OyenteRegistrarCliente());

				registrarSalida = menuPrincipal.getRegistrarSalida();
				registrarSalida.addActionListener(new OyenteRegistroSalidaCliente());
				
				listarClientes = menuPrincipal.getListarClientes();
				listarClientes.addActionListener(new OyenteListarClientes());
				
				modificarClientes = menuPrincipal.getModificarClientes();
				modificarClientes.addActionListener(new OyenteModificarClientes());
				
				eliminarClientes = menuPrincipal.getEliminarClientes();
				eliminarClientes.addActionListener(new OyenteEliminarClientes());

				contentPane.add(menuPrincipal, BorderLayout.WEST);
				setVisible(true);
			}
		});
		menuCliente.setFont(new Font("Zapfino", Font.PLAIN, 20));
		menuCliente.setForeground(SystemColor.textHighlight);
		menuBar.add(menuCliente);

		menuPensionado = new JMenu("Socios");
		menuPensionado.setFont(new Font("Zapfino", Font.PLAIN, 20));
		menuPensionado.setForeground(SystemColor.textHighlight);
		menuBar.add(menuPensionado);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);

		JLabel fondo = new JLabel("");
		panelCentro.add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));

	}

	private class OyenteRegistrarCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			registroCliente = new RegistroCliente();
			menuPrincipal.setVisible(false);
			contentPane.removeAll();
			menuPrincipal=null;
			repaint();
			contentPane.add(registroCliente, BorderLayout.CENTER);
			setVisible(true);
			repaint();
		}
	}

	private class OyenteRegistroSalidaCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			registroSalidaCliente = new RegistroSalidaCliente();
			menuPrincipal.setVisible(false);
			contentPane.removeAll();
			menuPrincipal=null;
			repaint();
			contentPane.add(registroSalidaCliente, BorderLayout.CENTER);
			setVisible(true);
			repaint();

		}

	}
	
	private class OyenteListarClientes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			listaClientes = new ListaClientes();
			menuPrincipal.setVisible(false);
			contentPane.removeAll();
			menuPrincipal=null;
			repaint();
			contentPane.add(listaClientes, BorderLayout.CENTER);
			setVisible(true);
			repaint();

		}

	}
	
	private class OyenteModificarClientes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			modificacionesClientes = new ModificacionesClientes();
			menuPrincipal.setVisible(false);
			contentPane.removeAll();
			menuPrincipal=null;
			repaint();
			contentPane.add(modificacionesClientes, BorderLayout.CENTER);
			setVisible(true);
			repaint();

		}

	}
	
	private class OyenteEliminarClientes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			eliminacionClientes = new EliminacionClientes();
			menuPrincipal.setVisible(false);
			contentPane.removeAll();
			menuPrincipal=null;
			repaint();
			contentPane.add(eliminacionClientes, BorderLayout.CENTER);
			setVisible(true);
			repaint();

		}

	}

}
