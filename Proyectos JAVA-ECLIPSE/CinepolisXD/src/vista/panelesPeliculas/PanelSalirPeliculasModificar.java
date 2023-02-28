package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalirPeliculasModificar extends JPanel {

	private JButton botonAceptarModificacionPeliculas;
	private JButton botonSalirModificacionPeliculas;

	
	
	public JButton getBotonAceptarModificacionPeliculas() {
		return botonAceptarModificacionPeliculas;
	}



	public JButton getBotonSalirModificacionPeliculas() {
		return botonSalirModificacionPeliculas;
	}



	/**
	 * Create the panel.
	 */
	public PanelSalirPeliculasModificar() {
		
setLayout(new GridLayout(0, 2, 0, 0));
		
		botonAceptarModificacionPeliculas = new JButton("Aceptar");
		botonAceptarModificacionPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonAceptarModificacionPeliculas.setForeground(new Color(102, 204, 0));
		add(botonAceptarModificacionPeliculas);
		
		botonSalirModificacionPeliculas = new JButton("Salir");
		botonSalirModificacionPeliculas.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		botonSalirModificacionPeliculas.setForeground(new Color(255, 51, 0));
		add(botonSalirModificacionPeliculas);
		
		

		
		
		

	}

}
