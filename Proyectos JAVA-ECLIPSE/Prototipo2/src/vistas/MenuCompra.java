package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuCompra extends JPanel {

	private JButton btnRegistrarCompra;
	private JButton btnConsultarCompras;
	private JButton btnModificarCompra;
	private JButton btnConsultarInventario;

	public JButton getBtnRegistrarCompra() {
		return btnRegistrarCompra;
	}

	public JButton getBtnConsultarCompras() {
		return btnConsultarCompras;
	}

	public JButton getBtnModificarCompra() {
		return btnModificarCompra;
	}
	public JButton getBtnConsultarInventario() {
		return btnConsultarInventario;
	}

	public MenuCompra() {
		setLayout(new GridLayout(0, 4, 0, 0));

		btnRegistrarCompra = new JButton("");
		btnRegistrarCompra.setIcon(new ImageIcon(MenuCompra.class.getResource("/imagenes/registrar.png")));
		btnRegistrarCompra.setBackground(new Color(242, 221, 192));
		btnRegistrarCompra.setOpaque(true);
		btnRegistrarCompra.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarCompra.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarCompra);

		btnConsultarCompras = new JButton("");
		btnConsultarCompras.setIcon(new ImageIcon(MenuCompra.class.getResource("/imagenes/consultar.png")));
		btnConsultarCompras.setBackground(new Color(229, 78, 50));
		btnConsultarCompras.setOpaque(true);
		btnConsultarCompras.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarCompras.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarCompras);

		btnModificarCompra = new JButton("");
		btnModificarCompra.setIcon(new ImageIcon(MenuCompra.class.getResource("/imagenes/modificar.png")));
		btnModificarCompra.setBackground(new Color(242, 221, 192));
		btnModificarCompra.setOpaque(true);
		btnModificarCompra.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarCompra.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarCompra);

		btnConsultarInventario = new JButton("");
		btnConsultarInventario.setIcon(new ImageIcon(MenuCompra.class.getResource("/imagenes/inventario.png")));
		btnConsultarInventario.setBackground(new Color(229, 78, 50));
		btnConsultarInventario.setOpaque(true);
		btnConsultarInventario.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarInventario.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarInventario);



	}

}
