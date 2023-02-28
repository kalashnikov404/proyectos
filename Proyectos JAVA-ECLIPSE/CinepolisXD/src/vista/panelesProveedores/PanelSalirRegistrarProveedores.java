package vista.panelesProveedores;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelSalirRegistrarProveedores extends JPanel {
	private JButton botonAceptarProveedores;
	private JButton botonSalirProveedores;
	
	

	public JButton getBotonAceptarProveedores() {
		return botonAceptarProveedores;
	}



	public JButton getBotonSalirProveedores() {
		return botonSalirProveedores;
	}



	/**
	 * Create the panel.
	 */
	public PanelSalirRegistrarProveedores() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		botonAceptarProveedores = new JButton("Aceptar");
		botonAceptarProveedores.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarProveedores.setForeground(new Color(102, 204, 0));
		add(botonAceptarProveedores);
		
		botonSalirProveedores = new JButton("Salir");
		botonSalirProveedores.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirProveedores.setForeground(new Color(255, 51, 0));
		add(botonSalirProveedores);

	}

}
