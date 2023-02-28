package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuCalentador extends JPanel {

	private JButton btnRegistrarCalentador;
	private JButton btnConsultarCalentador;
	private JButton btnModificarCalentador;
	
	public JButton getBtnRegistrarCalentador() {
		return btnRegistrarCalentador;
	}
	
	public JButton getBtnConsultarCalentador() {
		return btnConsultarCalentador;
	}
	
	public JButton getBtnModificarCalentador() {
		return btnModificarCalentador;
	}
	
	public MenuCalentador() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRegistrarCalentador = new JButton("");
		btnRegistrarCalentador.setIcon(new ImageIcon(MenuCalentador.class.getResource("/imagenes/registrar.png")));
		btnRegistrarCalentador.setBackground(new Color(242, 221, 192));
		btnRegistrarCalentador.setOpaque(true);
		btnRegistrarCalentador.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarCalentador.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarCalentador);
		
		btnConsultarCalentador = new JButton("");
		btnConsultarCalentador.setIcon(new ImageIcon(MenuCalentador.class.getResource("/imagenes/consultar.png")));
		btnConsultarCalentador.setBackground(new Color(229, 78, 50));
		btnConsultarCalentador.setOpaque(true);
		btnConsultarCalentador.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarCalentador.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarCalentador);
		
		btnModificarCalentador = new JButton("");
		btnModificarCalentador.setIcon(new ImageIcon(MenuCalentador.class.getResource("/imagenes/modificar.png")));
		btnModificarCalentador.setBackground(new Color(242, 221, 192));
		btnModificarCalentador.setOpaque(true);
		btnModificarCalentador.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarCalentador.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarCalentador);
		
		}

}
