package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuHorario extends JPanel {

	private JButton btnConsultarHorarios;
	private JButton btnModificarHorarios;
	
	public JButton getBtnConsultarHorarios() {
		return btnConsultarHorarios;
	}
	
	public JButton getBtnModificarHorarios() {
		return btnModificarHorarios;
	}
	
	public MenuHorario() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		btnConsultarHorarios = new JButton("");
		btnConsultarHorarios.setIcon(new ImageIcon(MenuHorario.class.getResource("/imagenes/consultar.png")));
		btnConsultarHorarios.setBackground(new Color(242, 221, 192));
		btnConsultarHorarios.setOpaque(true);
		btnConsultarHorarios.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarHorarios.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarHorarios);
		
		btnModificarHorarios = new JButton("");
		btnModificarHorarios.setIcon(new ImageIcon(MenuHorario.class.getResource("/imagenes/modificar.png")));
		btnModificarHorarios.setBackground(new Color(229, 78, 50));
		btnModificarHorarios.setOpaque(true);
		btnModificarHorarios.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarHorarios.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarHorarios);

	}

}
