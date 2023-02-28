package vista;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MenuPrincipal extends JPanel {
	
	private JButton registrarC;
	private JButton registrarSalida;
	private JButton listarClientes;
	private JButton modificarClientes;
	private JButton eliminarClientes;
	private JButton gestionarMenu;
	
private JPanel contentPane;
	
	public JButton getEliminarClientes() {
		return eliminarClientes;
	}

	public JButton getModificarClientes() {
		return modificarClientes;
	}

	public JButton getRegistrar() {
		return registrarC;
	}

	public JButton getRegistrarSalida() {
		return registrarSalida;
	}

	public JButton getListarClientes() {
		return listarClientes;
	}


	public JButton getGestionarMenu() {
		return gestionarMenu;
	}
	public MenuPrincipal() {
//		setBackground(Color.CYAN);

		setLayout(new GridLayout(0, 1, 0, 0));

	
		
		
		registrarC = new JButton("Gestionar negocio");
		registrarC.setBounds(0, 1, 527, 104);
		registrarC.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		registrarC.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		registrarC.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		registrarC.setHorizontalTextPosition(SwingConstants.CENTER);
		registrarC.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		registrarC.setFocusPainted(false);
		registrarC.setContentAreaFilled(false);
		registrarC.setBorderPainted(false);
		add(registrarC);
		
		registrarSalida = new JButton("Gestionar personal");
		registrarSalida.setBounds(0, 105, 527, 104);
		registrarSalida.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		registrarSalida.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		registrarSalida.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		registrarSalida.setHorizontalTextPosition(SwingConstants.CENTER);
		registrarSalida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		registrarSalida.setFocusPainted(false);
		registrarSalida.setContentAreaFilled(false);
		registrarSalida.setBorderPainted(false);
		add(registrarSalida);
		
		
		modificarClientes = new JButton("Gestionar inventario");
		modificarClientes.setBounds(0, 209, 527, 104);
		modificarClientes.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		modificarClientes.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		modificarClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		modificarClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		modificarClientes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		modificarClientes.setFocusPainted(false);
		modificarClientes.setContentAreaFilled(false);
		modificarClientes.setBorderPainted(false);
		add(modificarClientes);

		
		listarClientes = new JButton("Gestionar estancia");
		listarClientes.setBounds(0, 209, 527, 104);
		listarClientes.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		listarClientes.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		listarClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		listarClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		listarClientes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		listarClientes.setFocusPainted(false);
		listarClientes.setContentAreaFilled(false);
		listarClientes.setBorderPainted(false);
		add(listarClientes);


		
		gestionarMenu = new JButton("Gestionar menu");
		gestionarMenu.setBounds(0, 209, 527, 104);
		gestionarMenu.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		gestionarMenu.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		gestionarMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		gestionarMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		gestionarMenu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		gestionarMenu.setFocusPainted(false);
		gestionarMenu.setContentAreaFilled(false);
		gestionarMenu.setBorderPainted(false);
		add(gestionarMenu);

	
		eliminarClientes = new JButton("Gestionar servicio");
		eliminarClientes.setBounds(0, 209, 527, 104);
		eliminarClientes.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
		eliminarClientes.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
		eliminarClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		eliminarClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		eliminarClientes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
		eliminarClientes.setFocusPainted(false);
		eliminarClientes.setContentAreaFilled(false);
		eliminarClientes.setBorderPainted(false);
		add(eliminarClientes);

	}

}
