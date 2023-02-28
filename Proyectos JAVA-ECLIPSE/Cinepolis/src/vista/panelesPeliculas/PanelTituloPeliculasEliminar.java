package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloPeliculasEliminar extends JPanel {

	
	

	/**
	 * Create the panel.
	 */
	public PanelTituloPeliculasEliminar() {
		
		JLabel lblNewLabel = new JLabel("Eliminacion de peliculas");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);

	}
	
	
	
	
	
}
