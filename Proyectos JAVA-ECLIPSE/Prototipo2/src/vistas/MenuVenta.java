package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuVenta extends JPanel{
	
	private JButton btnRegistrarVenta;
	private JButton btnConsultarVentas;
	private JButton btnModificarVenta;

	public JButton getBtnRegistrarVenta() {
		return btnRegistrarVenta;
	}

	public JButton getBtnConsultarVentas() {
		return btnConsultarVentas;
	}

	public JButton getBtnModificarVenta() {
		return btnModificarVenta;
	}
	
	public MenuVenta() {
		setLayout(new GridLayout(0, 3, 0, 0));

		btnRegistrarVenta = new JButton("");
		btnRegistrarVenta.setIcon(new ImageIcon(MenuVenta.class.getResource("/imagenes/registrar.png")));
		btnRegistrarVenta.setBackground(new Color(242, 221, 192));
		btnRegistrarVenta.setOpaque(true);
		btnRegistrarVenta.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarVenta.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarVenta);

		btnConsultarVentas = new JButton("");
		btnConsultarVentas.setIcon(new ImageIcon(MenuVenta.class.getResource("/imagenes/consultar.png")));
		btnConsultarVentas.setBackground(new Color(229, 78, 50));
		btnConsultarVentas.setOpaque(true);
		btnConsultarVentas.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarVentas);

		btnModificarVenta = new JButton("");
		btnModificarVenta.setIcon(new ImageIcon(MenuVenta.class.getResource("/imagenes/modificar.png")));
		btnModificarVenta.setBackground(new Color(242, 221, 192));
		btnModificarVenta.setOpaque(true);
		btnModificarVenta.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarVenta.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarVenta);
		
	}

}
