package vista.panelesProveedores;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import utilidades.IOFile;

import javax.swing.JComboBox;

public class PanelRegistrarProveedores extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField cajaEmpresa;
	private static JTextField cajaTelefono;
	private static JTextField cajaCalle;
	private static JTextField cajaNumero;
	private static JComboBox<String> comboColonia;
	private static  JComboBox<String> comboSucursal;
	private static JComboBox<String> comboOrientacion;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static JTextField getCajaEmpresa() {
		return cajaEmpresa;
	}

	public static JTextField getCajaTelefono() {
		return cajaTelefono;
	}

	public static JTextField getCajaCalle() {
		return cajaCalle;
	}

	public static JTextField getCajaNumero() {
		return cajaNumero;
	}

	public static JComboBox<String> getComboColonia() {
		return comboColonia;
	}

	public static JComboBox<String> getComboSucursal() {
		return comboSucursal;
	}

	public static JComboBox<String> getComboOrientacion() {
		return comboOrientacion;
	}

	/**
	 * Create the panel.
	 */
	public PanelRegistrarProveedores() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 32, 35, 35, 35, 45, 35, 44, 35, 43, 35, 26, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Empresa");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		cajaEmpresa = new JTextField();
		cajaEmpresa.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaEmpresa = new GridBagConstraints();
		gbc_cajaEmpresa.insets = new Insets(0, 0, 5, 0);
		gbc_cajaEmpresa.fill = GridBagConstraints.BOTH;
		gbc_cajaEmpresa.gridx = 1;
		gbc_cajaEmpresa.gridy = 0;
		add(cajaEmpresa, gbc_cajaEmpresa);
		cajaEmpresa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaTelefono = new GridBagConstraints();
		gbc_cajaTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_cajaTelefono.fill = GridBagConstraints.BOTH;
		gbc_cajaTelefono.gridx = 1;
		gbc_cajaTelefono.gridy = 2;
		add(cajaTelefono, gbc_cajaTelefono);
		cajaTelefono.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Datos de domicilio");
		lblNewLabel_2.setForeground(new Color(204, 51, 255));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Calle");
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cajaCalle = new JTextField();
		cajaCalle.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaCalle = new GridBagConstraints();
		gbc_cajaCalle.insets = new Insets(0, 0, 5, 0);
		gbc_cajaCalle.fill = GridBagConstraints.BOTH;
		gbc_cajaCalle.gridx = 1;
		gbc_cajaCalle.gridy = 4;
		add(cajaCalle, gbc_cajaCalle);
		cajaCalle.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero");
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		cajaNumero = new JTextField();
		cajaNumero.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaNumero = new GridBagConstraints();
		gbc_cajaNumero.insets = new Insets(0, 0, 5, 0);
		gbc_cajaNumero.fill = GridBagConstraints.BOTH;
		gbc_cajaNumero.gridx = 1;
		gbc_cajaNumero.gridy = 6;
		add(cajaNumero, gbc_cajaNumero);
		cajaNumero.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Orientaci\u00F3n");
		lblNewLabel_5.setForeground(new Color(30, 144, 255));
		lblNewLabel_5.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		comboOrientacion = new JComboBox<>(IOFile.getOpciones("archivos//Orientacion"));
		comboOrientacion.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboOrientacion = new GridBagConstraints();
		gbc_comboOrientacion.insets = new Insets(0, 0, 5, 0);
		gbc_comboOrientacion.fill = GridBagConstraints.BOTH;
		gbc_comboOrientacion.gridx = 1;
		gbc_comboOrientacion.gridy = 8;
		add(comboOrientacion, gbc_comboOrientacion);
		
		JLabel lblNewLabel_6 = new JLabel("Colonia");
		lblNewLabel_6.setForeground(new Color(30, 144, 255));
		lblNewLabel_6.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 10;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		comboColonia = new JComboBox<>();
		comboColonia.addItem("Seleccione una opción");
		comboColonia.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboColonia = new GridBagConstraints();
		gbc_comboColonia.insets = new Insets(0, 0, 5, 0);
		gbc_comboColonia.fill = GridBagConstraints.BOTH;
		gbc_comboColonia.gridx = 1;
		gbc_comboColonia.gridy = 10;
		add(comboColonia, gbc_comboColonia);
		
		JLabel lblNewLabel_7 = new JLabel("Sucursal");
		lblNewLabel_7.setForeground(new Color(30, 144, 255));
		lblNewLabel_7.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 12;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		comboSucursal = new JComboBox<>();
		comboSucursal.addItem("Seleccione una opción");
		comboSucursal.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboSucursal = new GridBagConstraints();
		gbc_comboSucursal.fill = GridBagConstraints.BOTH;
		gbc_comboSucursal.gridx = 1;
		gbc_comboSucursal.gridy = 12;
		add(comboSucursal, gbc_comboSucursal);
		
		
		

	}

}
