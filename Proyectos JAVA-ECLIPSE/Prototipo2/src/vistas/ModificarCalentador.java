package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import api.ServiceCalentador;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Transporte;
import servicios.ServiceCalentadorImpl;

public class ModificarCalentador extends JPanel {
	private JTextField tfTipo;
	private JTextField tfNumCilindros;
	private JTextField tfDimensiones;
	private JTextField tfMarca;
	private JTextField tfPrecio;
	private Calentador newCalentador;
	private Calentador oldCalentador;

	private ServiceCalentador serviceCalentador;

	public ModificarCalentador(String usuario) {

		if(usuario.equals("dueño")) {

			try {
				serviceCalentador=new ServiceCalentadorImpl();


				setLayout(null);
				setBackground(new Color(255, 128, 128));
				setBounds(100, 100, 1366, 768);

				JLabel lblTitulo = new JLabel("Modificar Medicamento");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(64, 128, 128));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblCalentador = new JLabel("Medicamento:");
				lblCalentador.setBounds(18, 149, 83, 16);
				add(lblCalentador);

				List<String> cal = new ArrayList<>();
				cal=serviceCalentador.getListaCalentador();

				String[] calentadores = Conversor.getArrayDeList(cal);

				JComboBox cbCalentador = new JComboBox(calentadores);
				cbCalentador.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String todo= cbCalentador.getSelectedItem().toString();
						String [] partes=todo.split(", ");
						tfTipo.setText(partes[0]);
						tfNumCilindros.setText(partes[1]);
						tfDimensiones.setText(partes[2]);
						tfMarca.setText(partes[3]);
						tfPrecio.setText(partes[4]);

						oldCalentador =new Calentador(partes[0],Integer.parseInt(partes[1]), partes[2],partes[3], Double.parseDouble(partes[4]));
					}
				});
				cbCalentador.setBounds(91, 145, 837, 27);
				add(cbCalentador);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(579, 238, 61, 16);
				add(lblTipo);

				JLabel lblNumCilindros = new JLabel("Cantidad");
				lblNumCilindros.setBounds(579, 293, 111, 16);
				add(lblNumCilindros);

				JLabel lblDimensiones = new JLabel("Gramos:");
				lblDimensiones.setBounds(579, 352, 111, 16);
				add(lblDimensiones);

				tfTipo = new JTextField();
				tfTipo.setBounds(765, 233, 219, 26);
				add(tfTipo);
				tfTipo.setColumns(10);

				tfNumCilindros = new JTextField();
				tfNumCilindros.setBounds(765, 288, 130, 26);
				add(tfNumCilindros);
				tfNumCilindros.setColumns(10);

				tfDimensiones = new JTextField();
				tfDimensiones.setBounds(765, 347, 219, 26);
				add(tfDimensiones);
				tfDimensiones.setColumns(10);


				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(579, 413, 61, 16);
				add(lblMarca);

				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(579, 469, 61, 16);
				add(lblPrecio);

				tfMarca = new JTextField();
				tfMarca.setBounds(765, 408, 219, 26);
				add(tfMarca);
				tfMarca.setColumns(10);

				tfPrecio = new JTextField();
				tfPrecio.setBounds(765, 464, 130, 26);
				add(tfPrecio);
				tfPrecio.setColumns(10);

				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						newCalentador = new Calentador(tfTipo.getText(), Integer.parseInt(tfNumCilindros.getText()),tfDimensiones.getText(),tfMarca.getText(),Double.parseDouble(tfPrecio.getText()));

						String salida = serviceCalentador.modificarCalentador(newCalentador, oldCalentador);

						if(salida.equals("Medicamento modificado")) {
							tfTipo.setText(null);
							tfNumCilindros.setText(null);
							tfDimensiones.setText(null);
							tfMarca.setText(null);
							tfPrecio.setText(null);

							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
					}
				});
				btnModificar.setBounds(1080, 609, 185, 71);
				add(btnModificar);


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
				btnSalir.setBounds(45, 599, 85, 81);
				add(btnSalir);
				
				JButton btnEliminar = new JButton("Borrar Calentador");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String salida = serviceCalentador.eliminarCalentador(oldCalentador);
						
						if(salida.equals("Medicamento borrado")) {
							tfTipo.setText(null);
							tfNumCilindros.setText(null);
							tfDimensiones.setText(null);
							tfMarca.setText(null);
							tfPrecio.setText(null);
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
						
					}
				});
				btnEliminar.setBounds(856, 609, 185, 71);
				add(btnEliminar);

			} catch (ConexionException e) {
				e.printStackTrace();
			}

			
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
