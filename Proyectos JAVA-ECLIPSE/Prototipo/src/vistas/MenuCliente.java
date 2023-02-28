package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuCliente extends JPanel {

	private JButton btnRegistrarCliente;
	private JButton btnConsultarCliente;
	private JButton btnModificarCliente;


	public JButton getBtnModificarCliente() {
		return btnModificarCliente;
	}


	public JButton getBtnConsultarCliente() {
		return btnConsultarCliente;
	}


	public JButton getBtnRegistrarCliente() {
		return btnRegistrarCliente;

	}




	public MenuCliente() {
		setLayout(new GridLayout(0, 3, 0, 0));



		btnRegistrarCliente = new JButton("");
		btnRegistrarCliente.setIcon(new ImageIcon(MenuCliente.class.getResource("/imagenes/registrar.png")));
		btnRegistrarCliente.setBackground(new Color(242, 221, 192));
		btnRegistrarCliente.setOpaque(true);
		btnRegistrarCliente.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarCliente);


		btnConsultarCliente = new JButton("");
		btnConsultarCliente.setIcon(new ImageIcon(MenuCliente.class.getResource("/imagenes/consultar.png")));
		btnConsultarCliente.setBackground(new Color(229, 78, 50));
		btnConsultarCliente.setOpaque(true);
		btnConsultarCliente.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarCliente);

		btnModificarCliente = new JButton("");
		btnModificarCliente.setIcon(new ImageIcon(MenuCliente.class.getResource("/imagenes/modificar.png")));
		btnModificarCliente.setBackground(new Color(242, 221, 192));
		btnModificarCliente.setOpaque(true);
		btnModificarCliente.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarCliente);



	}

}
