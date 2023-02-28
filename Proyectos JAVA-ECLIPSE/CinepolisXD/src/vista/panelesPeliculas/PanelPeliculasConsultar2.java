package vista.panelesPeliculas;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;

import javax.swing.JTextField;

import dao.Metodos;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class PanelPeliculasConsultar2 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPeliculas;
	private static JTextField cajaBuscar;
	private JLabel lblNewLabel;
    private Metodos  metodos;
    private JScrollPane scrollPane;
   
    
	public static JTextField getCajaBuscar() {
		return cajaBuscar;
	}


	/**
	 * Create the panel.
	 */
	public PanelPeliculasConsultar2() {
		metodos = new Metodos();
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{72, 0, 0};
		gbl_panel.rowHeights = new int[]{95, 45, 115, 46, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		cajaBuscar = new JTextField();
		cajaBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			  String  titulos[] = {"Clave","Nombre","Genero","Duración","Clasificaión"};
			   String informacion[][]=metodos.obtenerMatrizPel();
					

				tablaPeliculas = new JTable(informacion,titulos);
				scrollPane.setViewportView(tablaPeliculas);
				
			}
		});
		
		lblNewLabel = new JLabel("Buscar:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_cajaBuscar = new GridBagConstraints();
		gbc_cajaBuscar.fill = GridBagConstraints.BOTH;
		gbc_cajaBuscar.gridx = 1;
		gbc_cajaBuscar.gridy = 3;
		panel.add(cajaBuscar, gbc_cajaBuscar);
		cajaBuscar.setColumns(10);
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		
	
		

	}
}
