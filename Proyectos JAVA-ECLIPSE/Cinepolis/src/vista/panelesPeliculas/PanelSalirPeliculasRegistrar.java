package vista.panelesPeliculas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelSalirPeliculasRegistrar extends JPanel {
	private JButton botonAceptarRegistroPeliculas;
	private JButton botonSalirRegistroPeliculas;

	public JButton getBotonAceptarRegistroPeliculas() {
		return botonAceptarRegistroPeliculas;
	}

	public JButton getBotonSalirRegistroPeliculas() {
		return botonSalirRegistroPeliculas;
	}

	/**
	 * Create the panel.
	 */
	public PanelSalirPeliculasRegistrar() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		botonAceptarRegistroPeliculas = new JButton("Aceptar");
		botonAceptarRegistroPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarRegistroPeliculas.setForeground(new Color(102, 204, 0));
		add(botonAceptarRegistroPeliculas);
		
		botonSalirRegistroPeliculas = new JButton("Salir");
		botonSalirRegistroPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirRegistroPeliculas.setForeground(new Color(255, 51, 0));
		add(botonSalirRegistroPeliculas);
		
		

	}

}
