package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuGraficas extends JPanel {



	private JButton btnMostrarGraficas;

	public JButton getBtnMostrarGraficas() {
		return btnMostrarGraficas;
	}


	public MenuGraficas() {
		setLayout(new GridLayout(0, 3, 0, 0));


		btnMostrarGraficas = new JButton("");
		btnMostrarGraficas.setIcon(new ImageIcon(MenuGraficas.class.getResource("/imagenes/barras.png")));
		btnMostrarGraficas.setBackground(new Color(242, 221, 192));
		btnMostrarGraficas.setOpaque(true);
		btnMostrarGraficas.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnMostrarGraficas.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnMostrarGraficas);



	}

}
