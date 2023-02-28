package vista.panelesContratar;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloContratar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTituloContratar() {
		JLabel lblNewLabel = new JLabel("Registro de empleados");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);


	}

}
