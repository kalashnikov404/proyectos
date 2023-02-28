package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuGarantia extends JPanel {

	private JButton btnCosultarGarantias;
	private JButton btnModificarGarantia;
	
	public JButton getBtnCosultarGarantias() {
		return btnCosultarGarantias;
	}

	public JButton getBtnModificarGarantia() {
		return btnModificarGarantia;
	}
	
	public MenuGarantia() {
			setLayout(new GridLayout(0, 1, 0, 0));

			btnCosultarGarantias = new JButton("");
			btnCosultarGarantias.setIcon(new ImageIcon(MenuGarantia.class.getResource("/imagenes/consultar.png")));
			btnCosultarGarantias.setBackground(new Color(242, 221, 192));
			btnCosultarGarantias.setOpaque(true);
			btnCosultarGarantias.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			btnCosultarGarantias.setHorizontalTextPosition(SwingConstants.CENTER);
			add(btnCosultarGarantias);
		}

	}


