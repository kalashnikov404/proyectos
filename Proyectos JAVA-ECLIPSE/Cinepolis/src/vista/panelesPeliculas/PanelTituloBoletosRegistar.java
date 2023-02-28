package vista.panelesPeliculas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloBoletosRegistar extends JPanel{

	

	/**
	 * Create the panel.
	 */
	public PanelTituloBoletosRegistar() {
		
		JLabel lblNewLabel = new JLabel("Registro de boletos");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);

	}
	
	
	
	
	
	
}
