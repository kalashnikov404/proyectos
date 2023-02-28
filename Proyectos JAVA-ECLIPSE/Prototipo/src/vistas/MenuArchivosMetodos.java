package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.json.JSONException;

import excepciones.ConexionException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import vistas.TratadoMetodos;

public class MenuArchivosMetodos extends JPanel {

	
	TratadoMetodos tratadoMetodos = new TratadoMetodos();
	
	/**
	 * Create the panel.
	 */
	
	public MenuArchivosMetodos(String usuario) throws ConexionException{
		if(usuario.equals("dueño") || usuario.equals("empleado")) {
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setForeground(Color.RED);
			panel.setBounds(10, 11, 691, 438);
			add(panel);
			panel.setLayout(null);
			setBackground(new Color(157, 198, 69));

			JLabel lblNewLabel = new JLabel("Tratar archivo CSV");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
			lblNewLabel.setBounds(92, 190, 261, 27);
			panel.add(lblNewLabel);
			
			JLabel lblTratarArchivoJson = new JLabel("Tratar archivo JSON");
			lblTratarArchivoJson.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));

			lblTratarArchivoJson.setBounds(92, 242, 261, 27);
			panel.add(lblTratarArchivoJson);
			
			JButton btnNewButton = new JButton("Ejecutar");
			btnNewButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tratadoMetodos.ConseguirCsv();
				}
			});
			btnNewButton.setBounds(497, 181, 100, 50);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Ejecutar");
			btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					try {
						tratadoMetodos.ConseguirJson();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btnNewButton_1.setBounds(497, 246, 100, 50);
			panel.add(btnNewButton_1);
			
			JLabel lblTratarDeArchivos = new JLabel("Tratamiento de archivos");
			lblTratarDeArchivos.setBackground(Color.BLACK);
			lblTratarDeArchivos.setForeground(Color.RED);
			lblTratarDeArchivos.setEnabled(false);
			lblTratarDeArchivos.setHorizontalAlignment(SwingConstants.CENTER);
			lblTratarDeArchivos.setFont(new Font("Raleway ExtraBold", Font.BOLD | Font.ITALIC, 36));
			lblTratarDeArchivos.setBounds(92, 42, 540, 78);
			panel.add(lblTratarDeArchivos);


			JButton btnSalir = new JButton("");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Principal frame = new Principal(usuario);
					frame.setVisible(true);

					setVisible(false);
					removeAll();
					repaint();

				}
			});
			btnSalir.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagenes/salir.png")));
			btnSalir.setBounds(45, 550, 85, 81);
			add(btnSalir);
		
		}else {
			JOptionPane.showMessageDialog(null, "No puedes ingresar a esta ventana");

			Principal frame = new Principal(usuario);
			frame.setVisible(true);

			setVisible(false);
			removeAll();
			repaint();

		}

		
		
	}
}
