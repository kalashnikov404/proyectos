package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuTrabajo extends JPanel {

	private JButton btnRegistrarTrabajo;
	private JButton btnModificarTrabajo;
	private JButton btnConsultarTrabajo;

	public JButton getBtnRegistrarTrabajo() {
		return btnRegistrarTrabajo;
	}

	public JButton getBtnModificarTrabajo() {
		return btnModificarTrabajo;
	}

	public JButton getBtnConsultarTrabajo() {
		return btnConsultarTrabajo;
	}


	public MenuTrabajo() {
		setLayout(new GridLayout(0, 3, 0, 0));

		btnRegistrarTrabajo = new JButton("");
		btnRegistrarTrabajo.setIcon(new ImageIcon(MenuTrabajo.class.getResource("/imagenes/registrar.png")));
		btnRegistrarTrabajo.setBackground(new Color(242, 221, 192));
		btnRegistrarTrabajo.setOpaque(true);
		btnRegistrarTrabajo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarTrabajo.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarTrabajo);

		btnModificarTrabajo = new JButton("");
		btnModificarTrabajo.setIcon(new ImageIcon(MenuTrabajo.class.getResource("/imagenes/modificar.png")));
		btnModificarTrabajo.setBackground(new Color(229, 78, 50));
		btnModificarTrabajo.setOpaque(true);
		btnModificarTrabajo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarTrabajo.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarTrabajo);

		btnConsultarTrabajo = new JButton("");
		btnConsultarTrabajo.setIcon(new ImageIcon(MenuTrabajo.class.getResource("/imagenes/consultar.png")));
		btnConsultarTrabajo.setBackground(new Color(242, 221, 192));
		btnConsultarTrabajo.setOpaque(true);
		btnConsultarTrabajo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarTrabajo.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarTrabajo);

	}

}
