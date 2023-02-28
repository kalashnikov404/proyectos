package vista.PanelesResurtir;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalirResurtidosRegistrar extends JPanel {

	
	
	

	private JButton botonAceptarRegistroResurtidos;

	private JButton botonSalirRegistroResurtidos;

	public JButton getBotonAceptarRegistroResurtidos() {
		return botonAceptarRegistroResurtidos;
	}

	public JButton getBotonSalirRegistroResurtidos() {
		return botonSalirRegistroResurtidos;
	}

	/**
	 * Create the panel.
	 */
	public PanelSalirResurtidosRegistrar() {
		setLayout(new GridLayout(0, 2, 0, 0));

		
		botonSalirRegistroResurtidos = new JButton("Salir");
		botonSalirRegistroResurtidos.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirRegistroResurtidos.setForeground(new Color(255, 51, 0));
		add(botonSalirRegistroResurtidos);
		

		botonAceptarRegistroResurtidos = new JButton("Aceptar");
		botonAceptarRegistroResurtidos.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarRegistroResurtidos.setForeground(new Color(102, 204, 0));
		add(botonAceptarRegistroResurtidos);

	}

	
	
	
	
	
	
	
}