package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuTransporte extends JPanel {

	private JButton btnRegistrarTransporte;
	private JButton btnConsultarTransportes;
	private JButton btnModificarTransporte;
	
	public JButton getBtnRegistrarTransporte() {
		return btnRegistrarTransporte;
	}
	
	public JButton getBtnConsultarTransportes() {
		return btnConsultarTransportes;
	}
	
	public JButton getBtnModificarTransporte() {
		return btnModificarTransporte;
	}
	
	public MenuTransporte() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRegistrarTransporte = new JButton("");
		btnRegistrarTransporte.setIcon(new ImageIcon(MenuTransporte.class.getResource("/imagenes/registrar.png")));
		btnRegistrarTransporte.setBackground(new Color(242, 221, 192));
		btnRegistrarTransporte.setOpaque(true);
		btnRegistrarTransporte.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarTransporte.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarTransporte);
		
		btnConsultarTransportes = new JButton("");
		btnConsultarTransportes.setIcon(new ImageIcon(MenuTransporte.class.getResource("/imagenes/consultar.png")));
		btnConsultarTransportes.setBackground(new Color(229, 78, 50));
		btnConsultarTransportes.setOpaque(true);
		btnConsultarTransportes.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarTransportes.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarTransportes);
		
		btnModificarTransporte = new JButton("");
		btnModificarTransporte.setIcon(new ImageIcon(MenuTransporte.class.getResource("/imagenes/modificar.png")));
		btnModificarTransporte.setBackground(new Color(242, 221, 192));
		btnModificarTransporte.setOpaque(true);
		btnModificarTransporte.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarTransporte.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarTransporte);
		
		}

}
