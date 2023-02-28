package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalirPeliculasConsultar extends JPanel{

	
	
	private JButton botonAceptarConsultaPeliculas;
	private JButton botonSalirConsultaPeliculas;

//	public JButton getBotonAceptarConsultaPeliculas() {
//		return botonAceptarConsultaPeliculas;
//	}

	public JButton getBotonSalirConsultaPeliculas() {
		return botonSalirConsultaPeliculas;
	}

	/**
	 * Create the panel.
	 */
	public PanelSalirPeliculasConsultar() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
//		botonAceptarConsultaPeliculas = new JButton("Aceptar");
//		botonAceptarConsultaPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
//		botonAceptarConsultaPeliculas.setForeground(new Color(102, 204, 0));
//		add(botonAceptarConsultaPeliculas);
		
		botonSalirConsultaPeliculas = new JButton("Salir");
		botonSalirConsultaPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirConsultaPeliculas.setForeground(new Color(255, 51, 0));
		add(botonSalirConsultaPeliculas);
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
}
