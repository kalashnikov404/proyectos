package vista.panelesPeliculas;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

import dao.Metodos;
import modelo.Pelicula;
import utilidades.IOFile;

import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelPeliculasModificar extends JPanel {
	private static JList<Pelicula> listaPeliculas;
	private static JTextField cajaClave;
	private static JTextField cajaNombre;
	private static JTextField cajaDuracion;
	private static JTextField cajaClasificacion;
	private static JComboBox<String> comboGenero;

	public static JList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	
	

	public static JTextField getCajaClave() {
		return cajaClave;
	}



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
	public PanelPeliculasModificar() {
		setLayout(new GridLayout(2, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		listaPeliculas = new JList<>(Metodos.modelo());
		listaPeliculas.setForeground(new Color(244, 164, 96));
		listaPeliculas.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		scrollPane.setViewportView(listaPeliculas);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Clave de la pelicula");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);

		cajaClave = new JTextField();
		cajaClave.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(cajaClave);
		cajaClave.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("G\u00E9nero");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		panel.add(lblNewLabel_2);

		comboGenero = new JComboBox<>(IOFile.getOpciones("archivos//generos"));
		comboGenero.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(comboGenero);

		JLabel lblNewLabel_4 = new JLabel("Clasificac\u00F3n");
		lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(30, 144, 255));
		panel.add(lblNewLabel);

		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(cajaNombre);
		cajaNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Duraci\u00F3n(Min)");
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		panel.add(lblNewLabel_3);

		cajaDuracion = new JTextField();
		cajaDuracion.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(cajaDuracion);
		cajaDuracion.setColumns(10);

		cajaClasificacion = new JTextField();
		cajaClasificacion.setFont(new Font("Impact", Font.PLAIN, 20));
		panel.add(cajaClasificacion);
		cajaClasificacion.setColumns(10);

	}
public boolean estanVaciasPeliculasM() {
		
		return cajaNombre.getText().isEmpty()||cajaDuracion.getText().isEmpty()||cajaClasificacion.getText().isEmpty()||comboGenero.getSelectedItem().equals("Seleccione una opción");
	}
	public void vaciarCajasPeliculasM() {
		cajaNombre.setText("");
		cajaClasificacion.setText("");
		cajaDuracion.setText("");
		comboGenero.setSelectedItem("Seleccione una opción");
		
	}
}
