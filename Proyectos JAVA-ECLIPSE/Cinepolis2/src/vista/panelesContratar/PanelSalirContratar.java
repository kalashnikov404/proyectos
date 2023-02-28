package vista.panelesContratar;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelSalirContratar extends JPanel {
	private JButton botonAceptarEmpleados;
	private JButton botonSalirEmpleados;

	
	public JButton getBotonAceptarEmpleados() {
		return botonAceptarEmpleados;
	}


	public JButton getBotonSalirEmpleados() {
		return botonSalirEmpleados;
	}


	/**
	 * Create the panel.
	 */
	public PanelSalirContratar() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		botonAceptarEmpleados = new JButton("Aceptar");
		botonAceptarEmpleados.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarEmpleados.setForeground(new Color(102, 204, 0));
		add(botonAceptarEmpleados);
		
		botonSalirEmpleados = new JButton("Salir");
		botonSalirEmpleados.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirEmpleados.setForeground(new Color(255, 51, 0));
		add(botonSalirEmpleados);

	}

}
