package vista.panelesPeliculas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utilidades.ServicePelicula;

import modelo.Pelicula;
import servicios.ServicePeliculaImpl;

import javax.swing.JButton;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
public class PanelPeliculasConsultar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField tfClave, tfNombre, tfGenero, tfDuracion, tfClasificacion, tfCelular, tfCorreo, tfEspacio;

	private JTable table;
	private ServicePelicula servicePelicula;
	private List<Pelicula> peliculas;
	
	private javax.swing.JComboBox cbConjuntoDatos;
	private javax.swing.JComboBox cbDatos;
	public PanelPeliculasConsultar() {
servicePelicula = new ServicePeliculaImpl();


cbConjuntoDatos = new javax.swing.JComboBox();
cbDatos = new javax.swing.JComboBox();

cbConjuntoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿A partir de que deseas consultar la pelicula?", "Datos de la pelicula"}));
cbConjuntoDatos.setPreferredSize(new java.awt.Dimension(350, 20));
cbConjuntoDatos.addItemListener(new java.awt.event.ItemListener() {
	public void itemStateChanged(java.awt.event.ItemEvent evt) {
		cbConjuntoDatosItemStateChanged(evt);
	}
});
add(cbConjuntoDatos);

cbDatos.setPreferredSize(new java.awt.Dimension(150, 20));
add(cbDatos);

JButton btnConsultar = new JButton("Seleccionar");
btnConsultar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {

		removeAll();
		repaint();
//
		peliculas = new ArrayList<>();

		if(cbDatos.getSelectedItem().toString()=="Clave") {
			JLabel lblPlacas = new JLabel("Clave: ");
			lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblPlacas.setBounds(33, 147, 68, 60);
			add(lblPlacas);

			tfClave = new JTextField();
			tfClave.setBounds(111, 147, 130, 26);
			add(tfClave);
			tfClave.setColumns(10);

			lblPlacas.setVisible(true);
			tfClave.setVisible(true);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					peliculas=servicePelicula.consultarPorDatosPelicula(tfClave.getText(), "", "", "","");
					buscar(peliculas);
				}});
			add(btnBuscar);
			revalidate();
			repaint();

			//
		}
		if(cbDatos.getSelectedItem().toString()=="Nombre") {
			JLabel lblPlacas = new JLabel("Nombre: ");
			lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblPlacas.setBounds(33, 147, 68, 60);
			add(lblPlacas);

			tfNombre = new JTextField();
			tfNombre.setBounds(111, 147, 130, 26);
			add(tfNombre);
			tfNombre.setColumns(10);

			lblPlacas.setVisible(true);
			tfNombre.setVisible(true);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					peliculas=servicePelicula.consultarPorDatosPelicula("", tfNombre.getText(), "", "", "");
					buscar(peliculas);
				}});
			add(btnBuscar);
			revalidate();
			repaint();

			//
		}if(cbDatos.getSelectedItem().toString()=="Genero") {
			JLabel lblPlacas = new JLabel("Genero: ");
			lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblPlacas.setBounds(33, 147, 68, 60);
			add(lblPlacas);

			tfGenero = new JTextField();
			tfGenero.setBounds(111, 147, 130, 26);
			add(tfGenero);
			tfGenero.setColumns(10);

			lblPlacas.setVisible(true);
			tfGenero.setVisible(true);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					peliculas=servicePelicula.consultarPorDatosPelicula("", "", tfGenero.getText(), "", "");
					buscar(peliculas);
				}});
			add(btnBuscar);
			revalidate();
			repaint();

			//
		}	if(cbDatos.getSelectedItem().toString()=="Duracion") {
			JLabel lblPlacas = new JLabel("Duracion: ");
			lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblPlacas.setBounds(33, 147, 68, 60);
			add(lblPlacas);

			tfDuracion = new JTextField();
			tfDuracion.setBounds(111, 147, 130, 26);
			add(tfDuracion);
			tfDuracion.setColumns(10);

			lblPlacas.setVisible(true);
			tfDuracion.setVisible(true);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					peliculas=servicePelicula.consultarPorDatosPelicula("", "", "", tfDuracion.getText(), "");
					buscar(peliculas);
				}});
			add(btnBuscar);
			revalidate();
			repaint();

			//
		}
		if(cbDatos.getSelectedItem().toString()=="Clasificacion") {
			JLabel lblPlacas = new JLabel("Clasificacion: ");
			lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblPlacas.setBounds(33, 147, 68, 60);
			add(lblPlacas);

			tfClasificacion = new JTextField();
			tfClasificacion.setBounds(111, 147, 130, 26);
			add(tfClasificacion);
			tfClasificacion.setColumns(10);

			lblPlacas.setVisible(true);
			tfClasificacion.setVisible(true);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					peliculas=servicePelicula.consultarPorDatosPelicula("", "", "", "", tfClasificacion.getText());
					buscar(peliculas);
				}});
			add(btnBuscar);
			revalidate();
			repaint();

			//
		}
		
		
		
		
		
		
		
		
		
}
	
});
add(btnConsultar);

}


private void cbConjuntoDatosItemStateChanged(java.awt.event.ItemEvent evt) {
if(evt.getStateChange() == ItemEvent.SELECTED){
if(cbConjuntoDatos.getSelectedIndex()>0){
	cbDatos.setPreferredSize(new java.awt.Dimension(200, 20));
	cbDatos.setModel(new DefaultComboBoxModel(getDatos(cbConjuntoDatos.getSelectedItem().toString())));
}
}
}


			public String[] getDatos(String conjuntoDatos){
				String[] datos = null;
				if(conjuntoDatos.equalsIgnoreCase("Datos de la pelicula")){
					datos = new String[6];

					datos[0] = "Buscar por:";
					datos[1] = "Clave";
					datos[2] = "Nombre";
					datos[3] = "Genero";
					datos[4] = "Duracion";
					datos[5] = "Clasificacion";
				
				}

				
				return datos;
			}
			
			public void buscar(List<Pelicula> peliculas){
				
				if(peliculas.size()>0) {
				
				table = new JTable();
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"CLAVE", "NOMBRE", "GENERO", "DURACION", "CLASIFICACION"};

				String data[][] = new String[peliculas.size()][5];

				for(int i=0; i<peliculas.size(); i++) {
					
					data[i][0]=String.valueOf(peliculas.get(i).getClave());
					data[i][1]=peliculas.get(i).getNombre();
					data[i][2]=peliculas.get(i).getGenero();
					data[i][3]=String.valueOf(peliculas.get(i).getDuracion());
					data[i][4]=peliculas.get(i).getClasificacion();

				}
				setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


				table.setModel(new DefaultTableModel(data, nombreColunas));

				table.getColumnModel().getColumn(0).setPreferredWidth(350);
				table.getColumnModel().getColumn(1).setPreferredWidth(350);
				table.getColumnModel().getColumn(2).setPreferredWidth(350);
				table.getColumnModel().getColumn(3).setPreferredWidth(350);
				table.getColumnModel().getColumn(4).setPreferredWidth(350);


				add(table);

				
				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(0, 500, 1800, 200);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				setVisible(true);
				repaint();
				revalidate();
				
				
				}else {
					JOptionPane.showMessageDialog(null, "No se encontraron registros, intenta de nuevo");
				}
			} 
				

		}


