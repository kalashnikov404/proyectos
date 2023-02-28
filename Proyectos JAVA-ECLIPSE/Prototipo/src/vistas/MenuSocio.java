package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuSocio extends JPanel {

	private JButton btnRegistrarSocio;
	private JButton btnConsultarSocio;
	private JButton btnModificarSocio;
	
	public JButton getBtnRegistrarSocio() {
		return btnRegistrarSocio;
	}
	
	public JButton getBtnModificarSocio() {
		return btnModificarSocio;
	}

	public JButton getBtnConsultarSocio() {
		return btnConsultarSocio;
	}
	
	public MenuSocio() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRegistrarSocio = new JButton("");
		btnRegistrarSocio.setIcon(new ImageIcon(MenuSocio.class.getResource("/imagenes/registrar.png")));
		btnRegistrarSocio.setBackground(new Color(242, 221, 192));
		btnRegistrarSocio.setOpaque(true);
		btnRegistrarSocio.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarSocio.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarSocio);
		
		btnConsultarSocio = new JButton("");
		btnConsultarSocio.setIcon(new ImageIcon(MenuSocio.class.getResource("/imagenes/consultar.png")));
		btnConsultarSocio.setBackground(new Color(229, 78, 50));
		btnConsultarSocio.setOpaque(true);
		btnConsultarSocio.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarSocio.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarSocio);
		
		btnModificarSocio = new JButton("");
		btnModificarSocio.setIcon(new ImageIcon(MenuSocio.class.getResource("/imagenes/modificar.png")));
		btnModificarSocio.setBackground(new Color(242, 221, 192));
		btnModificarSocio.setOpaque(true);
		btnModificarSocio.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarSocio.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarSocio);
		
		}

}
