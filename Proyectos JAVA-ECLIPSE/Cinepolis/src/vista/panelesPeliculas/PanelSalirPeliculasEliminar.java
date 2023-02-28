package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalirPeliculasEliminar extends JPanel {

	
	
	

	
	private JButton botonSalirEliminacionPeliculas;

//	public JButton getBotonAceptarConsultaPeliculas() {
//		return botonAceptarConsultaPeliculas;
//	}

	public JButton getBotonSalirEliminacionPeliculas() {
		return botonSalirEliminacionPeliculas;
	}

	/**
	 * Create the panel.
	 */
	public PanelSalirPeliculasEliminar() {
		setLayout(new GridLayout(0, 2, 0, 0));

		
		botonSalirEliminacionPeliculas = new JButton("Salir");
		botonSalirEliminacionPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirEliminacionPeliculas.setForeground(new Color(255, 51, 0));
		add(botonSalirEliminacionPeliculas);
		
		

	}

	
	
	
	
	
	
	
}
