package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuContrato extends JPanel {

	private JButton btnRegistrarContrato;
	private JButton btnConsultarContrato;
	private JButton btnModificarContrato;

	public JButton getBtnConsultarContrato() {
		return btnConsultarContrato;
	}

	public JButton getBtnModificarContrato() {
		return btnModificarContrato;
	}

	public JButton getBtnRegistrarContrato() {
		return btnRegistrarContrato;
	}


	public MenuContrato() {
		setLayout(new GridLayout(0, 3, 0, 0));

		btnRegistrarContrato = new JButton("");
		btnRegistrarContrato.setIcon(new ImageIcon(MenuContrato.class.getResource("/imagenes/registrar.png")));
		btnRegistrarContrato.setBackground(new Color(242, 221, 192));
		btnRegistrarContrato.setOpaque(true);
		btnRegistrarContrato.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarContrato.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarContrato);
		
		btnConsultarContrato = new JButton("");
		btnConsultarContrato.setIcon(new ImageIcon(MenuContrato.class.getResource("/imagenes/consultar.png")));
		btnConsultarContrato.setBackground(new Color(229, 78, 50));
		btnConsultarContrato.setOpaque(true);
		btnConsultarContrato.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarContrato.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarContrato);
		
		btnModificarContrato = new JButton("");
		btnModificarContrato.setIcon(new ImageIcon(MenuContrato.class.getResource("/imagenes/modificar.png")));
		btnModificarContrato.setBackground(new Color(242, 221, 192));
		btnModificarContrato.setOpaque(true);
		btnModificarContrato.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarContrato.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarContrato);
	}

}
