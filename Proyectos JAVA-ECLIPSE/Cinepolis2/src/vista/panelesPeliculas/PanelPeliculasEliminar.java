package vista.panelesPeliculas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Pelicula;
import servicios.ServicePeliculaImpl;


	public class PanelPeliculasEliminar extends JPanel {
		private JTextField tfId;

		private int modificacion;
		private Pelicula peliculaPrub;
		
		public PanelPeliculasEliminar() {
			setLayout(null);

			

			JLabel lblInstrucciones = new JLabel("Ingresa el id de la pelicula que deseas eliminar");
			lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
			lblInstrucciones.setBounds(33, 44, 1000, 27);
			add(lblInstrucciones);

			tfId = new JTextField();
			tfId.setBounds(33, 81, 130, 26);
			add(tfId);
			tfId.setColumns(10);

			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int resOp=1;

					while(resOp==1 || resOp==2) {

						ServicePeliculaImpl servicePeliculaImpl = new ServicePeliculaImpl();
						peliculaPrub = new Pelicula();

						peliculaPrub=servicePeliculaImpl.consultarPorId(Integer.parseInt(tfId.getText().toString()));

						resOp=JOptionPane.showConfirmDialog(null, "¿Esta es la pelicula  que deseas eliminar?\n"
								+ "Clave : "+peliculaPrub.getClave()+", Nombre : "+peliculaPrub.getNombre()+", Genero : "+peliculaPrub.getGenero()
								+ "Duracion :" + peliculaPrub.getDuracion() + "Clasificacion :" + peliculaPrub.getClasificacion()) ;
					}

					if(resOp==0) {
					
						ServicePeliculaImpl servicePeliculaImpl = new ServicePeliculaImpl();
						JOptionPane.showMessageDialog(null, (servicePeliculaImpl.eliminarPelicula(Integer.parseInt(tfId.getText()))));	
					}
					
				}
			});
			btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			btnEliminar.setBounds(50, 200, 163, 47);
			add(btnEliminar);



		}
}
