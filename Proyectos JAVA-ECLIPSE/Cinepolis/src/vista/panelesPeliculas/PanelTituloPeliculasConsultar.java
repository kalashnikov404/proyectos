package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloPeliculasConsultar extends JPanel{

	

	/**
	 * Create the panel.
	 */
	public PanelTituloPeliculasConsultar() {
		
		JLabel lblNewLabel = new JLabel("Consulta de peliculas");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);

	}
	
	
	
	
	
	
}
