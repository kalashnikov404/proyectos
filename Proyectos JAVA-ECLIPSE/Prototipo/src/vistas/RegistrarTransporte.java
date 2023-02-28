package vistas;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Transporte;
import servicios.ServiceTransporteImpl;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class RegistrarTransporte extends JPanel {
	private JTextField tfPlacas;
	private JTextField tfNuevoTipo;
	private ButtonGroup opciones;

	private ServiceTransporte serviceTransporte;

	public RegistrarTransporte(String usuario) {

		if(usuario.equals("dueño")) {

			try {
				serviceTransporte = new ServiceTransporteImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Registrar Transporte");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblPlacas = new JLabel("Placas:");
				lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
				lblPlacas.setBounds(615, 140, 85, 16);
				add(lblPlacas);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(615, 251, 61, 16);
				add(lblTipo);

				tfPlacas = new JTextField();
				tfPlacas.setBounds(712, 135, 130, 26);
				add(tfPlacas);
				tfPlacas.setColumns(10);

				tfNuevoTipo = new JTextField();
				tfNuevoTipo.setBounds(712, 331, 130, 26);
				add(tfNuevoTipo);
				tfNuevoTipo.setColumns(10);

				List<String> tip = new ArrayList<>();
				tip=serviceTransporte.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);

				JComboBox cbTipo = new JComboBox(tipos);
				cbTipo.setBounds(712, 247, 185, 27);
				add(cbTipo);

				JRadioButton rbNuevoTipo = new JRadioButton("Ingresar un nuevo tipo:");
				rbNuevoTipo.setBounds(491, 332, 185, 23);
				add(rbNuevoTipo);

				opciones = new ButtonGroup();
				opciones.add(rbNuevoTipo);

				JButton btnRegistrar = new JButton("Registrar transporte");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Transporte transporte = new Transporte();

						transporte.setPlacas(tfPlacas.getText());

						if(!rbNuevoTipo.isSelected()) {

							String tipo = cbTipo.getSelectedItem().toString();

							transporte.setTipo(tipo);
						}else {
							transporte.setTipo(tfNuevoTipo.getText());
						}

						String salida = serviceTransporte.registrarTransporte(transporte);

						if(salida.equals("Transporte registrado")) {
							tfPlacas.setText(null);
							tfNuevoTipo.setText(null);
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo saliÃ³ mal, revisa los datos ingresados");
						}
					}
				});
				btnRegistrar.setBounds(1212, 609, 185, 71);
				add(btnRegistrar);

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

			} catch (ConexionException e1) {
				e1.printStackTrace();
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
