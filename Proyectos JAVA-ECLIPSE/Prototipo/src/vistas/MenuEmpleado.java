package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuEmpleado extends JPanel {

	private JButton btnRegistrarEmpleado;
	private JButton btnConsultarEmpleados;
	private JButton btnModificarEmpleado;
	
public JButton getBtnRegistrarEmpleado() {
		return btnRegistrarEmpleado;
	}

	public JButton getBtnConsultarEmpleados() {
		return btnConsultarEmpleados;
	}

	public JButton getBtnModificarEmpleado() {
		return btnModificarEmpleado;
	}

	public MenuEmpleado() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRegistrarEmpleado = new JButton("");
		btnRegistrarEmpleado.setIcon(new ImageIcon(MenuEmpleado.class.getResource("/imagenes/registrar.png")));
		btnRegistrarEmpleado.setBackground(new Color(242, 221, 192));
		btnRegistrarEmpleado.setOpaque(true);
		btnRegistrarEmpleado.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnRegistrarEmpleado.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnRegistrarEmpleado);
		
		btnConsultarEmpleados = new JButton("");
		btnConsultarEmpleados.setIcon(new ImageIcon(MenuEmpleado.class.getResource("/imagenes/consultar.png")));
		btnConsultarEmpleados.setBackground(new Color(229, 78, 50));
		btnConsultarEmpleados.setOpaque(true);
		btnConsultarEmpleados.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnConsultarEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnConsultarEmpleados);
		
		btnModificarEmpleado = new JButton("");
		btnModificarEmpleado.setIcon(new ImageIcon(MenuEmpleado.class.getResource("/imagenes/modificar.png")));
		btnModificarEmpleado.setBackground(new Color(242, 221, 192));
		btnModificarEmpleado.setOpaque(true);
		btnModificarEmpleado.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		btnModificarEmpleado.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnModificarEmpleado);

	}

}
