package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloPeliculasModificar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTituloPeliculasModificar() {
		
		JLabel lblNewLabel = new JLabel("Modificación de peliculas");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);


	}

}
