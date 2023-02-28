package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuProveedor extends JPanel{
	
	private JButton btnRegistrarProveedor;
	private JButton btnConsultarProveedores;
	private JButton btnModificarProveedor;
	
	public JButton getBtnRegistrarProveedor() {
		return btnRegistrarProveedor;
	}

	public JButton getBtnConsultarProveedores() {
		return btnConsultarProveedores;
	}

	public JButton getBtnModificarProveedor() {
		return btnModificarProveedor;
	}
	
	public MenuProveedor() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRegistrarProveedor = new JButton("");
		btnRegistrarProveedor.setIcon(new ImageIcon(MenuProveedor.class.getResource("/imagenes/registrar.png")));
		btnRegistrarProveedor.setBackground(new Color(242, 221, 192));
		btnRegistrarProveedor.setOpaque(true);
		btnRegistrarProveedor.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarProveedor.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarProveedor);
		
		btnConsultarProveedores = new JButton("");
		btnConsultarProveedores.setIcon(new ImageIcon(MenuProveedor.class.getResource("/imagenes/consultar.png")));
		btnConsultarProveedores.setBackground(new Color(229, 78, 50));
		btnConsultarProveedores.setOpaque(true);
		btnConsultarProveedores.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarProveedores.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarProveedores);
		
		btnModificarProveedor = new JButton("");
		btnModificarProveedor.setIcon(new ImageIcon(MenuProveedor.class.getResource("/imagenes/modificar.png")));
		btnModificarProveedor.setBackground(new Color(242, 221, 192));
		btnModificarProveedor.setOpaque(true);
		btnModificarProveedor.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarProveedor.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarProveedor);

	}

}
