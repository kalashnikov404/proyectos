package vista.panelesProveedores;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloRegistarProveedores extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTituloRegistarProveedores() {
		JLabel lblNewLabel = new JLabel("Registro de proveedores");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 40));
		add(lblNewLabel);



	}

}
