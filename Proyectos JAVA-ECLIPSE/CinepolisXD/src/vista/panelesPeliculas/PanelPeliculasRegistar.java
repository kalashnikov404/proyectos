package vista.panelesPeliculas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;
import java.awt.GridLayout;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import utilidades.IOFile;

import javax.swing.JComboBox;

public class PanelPeliculasRegistar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField cajaNombre;
	private static JTextField cajaDuracion;
	private static JTextField cajaClasificacion;
	private static JComboBox<String> comboGenero;

	
	
	public static JTextField getCajaNombre() {
		return cajaNombre;
	}



	public static JTextField getCajaDuracion() {
		return cajaDuracion;
	}



	public static JTextField getCajaClasificacion() {
		return cajaClasificacion;
	}



	public static JComboBox<String> getComboGenero() {
		return comboGenero;
	}



	/**
	 * Create the panel.
	 */
	public PanelPeliculasRegistar() {
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_1);
		
		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaNombre);
		cajaNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9nero");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_2);
		
		comboGenero = new JComboBox<>();
	    comboGenero.addItem("Seleccione una opción");
	    comboGenero.addItem("Acción");
	    comboGenero.addItem("Aventuras");
	    comboGenero.addItem("Comedia");
	    comboGenero.addItem("Drama");
	    comboGenero.addItem("Terror");
	    comboGenero.addItem("Musical");
	    comboGenero.addItem("Ciencia ficción");
	    comboGenero.addItem("Belica");
	    comboGenero.addItem("Suspenso");
	    comboGenero.addItem("Adultos+18");
	    comboGenero.addItem("Infantil");
	    comboGenero.addItem("Dibujos Animados");
	    comboGenero.setFont(new Font("Impact", Font.PLAIN, 25));
		add(comboGenero);
		
		JLabel lblNewLabel_3 = new JLabel("Duraci\u00F3n(Min)");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel_3);
		
		cajaDuracion = new JTextField();
		cajaDuracion.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaDuracion);
		cajaDuracion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Clasificaci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		add(lblNewLabel);
		
		cajaClasificacion = new JTextField();
		cajaClasificacion.setFont(new Font("Impact", Font.PLAIN, 25));
		add(cajaClasificacion);
		cajaClasificacion.setColumns(10);

	}
	
	public boolean estanVaciasPeliculas() {
		
		return cajaNombre.getText().isEmpty()||cajaDuracion.getText().isEmpty()||cajaClasificacion.getText().isEmpty()||comboGenero.getSelectedItem().equals("Seleccione una opción");
	}
	public void vaciarCajasPeliculas() {
		cajaNombre.setText("");
		cajaClasificacion.setText("");
		cajaDuracion.setText("");
		comboGenero.setSelectedItem("Seleccione una opción");
		
	}
}
