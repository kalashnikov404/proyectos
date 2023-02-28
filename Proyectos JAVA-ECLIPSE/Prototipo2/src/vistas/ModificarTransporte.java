package vistas;

import java.awt.Color;
import java.awt.Font;
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

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Transporte;
import servicios.ServiceTransporteImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarTransporte extends JPanel {

	private JTextField tfPlacas;
	private JTextField tfTipo;

	private Transporte newTransporte;
	private Transporte oldTransporte;


	private ServiceTransporte serviceTransporte;

	public ModificarTransporte(String usuario) {

		if(usuario.equals("dueño")) {

			try {
				serviceTransporte = new ServiceTransporteImpl();

				setBackground(new Color(255, 128, 128));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Modificar Evento");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(64, 128, 128));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblTransporte = new JLabel("Evento:");
				lblTransporte.setBounds(18, 149, 72, 16);
				add(lblTransporte);

				List<String> tra = new ArrayList<>();
				tra=serviceTransporte.getListaTransportes();

				String[] transportes = Conversor.getArrayDeList(tra);

				JComboBox cbTransportes = new JComboBox(transportes);
				cbTransportes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo = cbTransportes.getSelectedItem().toString();
						String[] partes = todo.split(", ");

						tfPlacas.setText(partes[0]);
						tfTipo.setText(partes[1]);

						oldTransporte = new Transporte(partes[0], partes[1]);


					}
				});
				cbTransportes.setBounds(91, 145, 336, 27);
				add(cbTransportes);

				JLabel lblPlacas = new JLabel("Tematica:");
				lblPlacas.setBounds(617, 233, 85, 16);
				add(lblPlacas);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(617, 293, 61, 16);
				add(lblTipo);

				tfPlacas = new JTextField();
				tfPlacas.setBounds(712, 228, 130, 26);
				add(tfPlacas);
				tfPlacas.setColumns(10);

				tfTipo = new JTextField();
				tfTipo.setBounds(712, 288, 130, 26);
				add(tfTipo);
				tfTipo.setColumns(10);

				JButton btnModificar = new JButton("Modificar evento");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newTransporte = new Transporte(tfPlacas.getText(), tfTipo.getText());

						String salida = serviceTransporte.modificarTransporte(newTransporte, oldTransporte);

						if(salida.equals("Evento modificado")) {
							tfPlacas.setText(null);
							 tfTipo.setText(null);
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}


					}
				});
				btnModificar.setBounds(1032, 481, 185, 71);
				add(btnModificar);
				
				
				JButton btnEliminar = new JButton("Eliminar evento");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String salida = serviceTransporte.eliminarTransporte(oldTransporte);
						if(salida.equals("Evento eliminado")) {
							tfPlacas.setText(null);
							 tfTipo.setText(null);
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}


					}
				});
				btnEliminar.setBounds(803, 481, 185, 71);
				add(btnEliminar);

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
				btnSalir.setBounds(42, 481, 85, 81);
				add(btnSalir);

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
