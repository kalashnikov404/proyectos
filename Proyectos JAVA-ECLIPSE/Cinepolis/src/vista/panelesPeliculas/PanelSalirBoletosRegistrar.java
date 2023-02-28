package vista.panelesPeliculas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelSalirBoletosRegistrar extends JPanel {
	private JButton botonSalirRegistroBoletos;

	private JButton botonAceptarRegistroBoletos;

	
	
//	public JButton getBotonAceptarRegistroPeliculas() {
//		return botonAceptarRegistroPeliculas;
//	}

	public JButton getBotonAceptarRegistroBoletos() {
		return botonAceptarRegistroBoletos;
	}

	public JButton getBotonSalirRegistroBoletos() {
		return botonSalirRegistroBoletos;
	}

	/**
	 * Create the panel.
	 */
	public PanelSalirBoletosRegistrar() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		botonAceptarRegistroBoletos = new JButton("Aceptar");
		botonAceptarRegistroBoletos.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarRegistroBoletos.setForeground(new Color(102, 204, 0));
		add(botonAceptarRegistroBoletos);
		
		botonSalirRegistroBoletos = new JButton("Salir");
		botonSalirRegistroBoletos.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirRegistroBoletos.setForeground(new Color(255, 51, 0));
		add(botonSalirRegistroBoletos);
		
		

	}

}
