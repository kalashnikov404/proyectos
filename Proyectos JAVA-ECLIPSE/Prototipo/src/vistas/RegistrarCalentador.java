package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import api.ServiceCalentador;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Transporte;
import servicios.ServiceCalentadorImpl;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegistrarCalentador extends JPanel {
	private JTextField tfTipo;
	private JTextField tfNumCilindros;
	private JTextField tfDimensiones;
	private JTextField tfMarca;
	private JTextField tfPrecio;
	private ServiceCalentador serviceCalentador;

	public RegistrarCalentador(String usuario) {

		if(usuario.equals("dueño")) {

			setLayout(null);
			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);

			try {
				serviceCalentador = new ServiceCalentadorImpl();


				JLabel lblTitulo = new JLabel("Registrar Calentador");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(573, 116, 61, 16);
				add(lblTipo);

				JLabel lblNumCilindros = new JLabel("NÃºmero de cilindros:");
				lblNumCilindros.setBounds(573, 177, 132, 16);
				add(lblNumCilindros);

				JLabel lblDimensiones = new JLabel("Dimensiones:");
				lblDimensiones.setBounds(573, 246, 114, 16);
				add(lblDimensiones);

				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(573, 311, 61, 16);
				add(lblMarca);

				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(573, 384, 61, 16);
				add(lblPrecio);

				tfTipo = new JTextField();
				tfTipo.setBounds(734, 111, 207, 26);
				add(tfTipo);
				tfTipo.setColumns(10);

				tfNumCilindros = new JTextField();
				tfNumCilindros.setBounds(734, 172, 130, 26);
				add(tfNumCilindros);
				tfNumCilindros.setColumns(10);

				tfDimensiones = new JTextField();
				tfDimensiones.setBounds(734, 241, 207, 26);
				add(tfDimensiones);
				tfDimensiones.setColumns(10);

				tfMarca = new JTextField();
				tfMarca.setBounds(734, 306, 207, 26);
				add(tfMarca);
				tfMarca.setColumns(10);

				tfPrecio = new JTextField();
				tfPrecio.setBounds(734, 379, 130, 26);
				add(tfPrecio);
				tfPrecio.setColumns(10);

				JButton btnRegistrar = new JButton("Registrar Calentador");

				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Calentador calentador = new Calentador();
						calentador.setTipo(tfTipo.getText());
						calentador.setNumCilindros(Integer.parseInt(tfNumCilindros.getText()));
						calentador.setDimensiones(tfDimensiones.getText());
						calentador.setMarca(tfMarca.getText());
						calentador.setPrecio(Double.parseDouble(tfPrecio.getText())); 

						String salida = serviceCalentador.registrar(calentador);

						if(salida.equals("Calentador registrado")) {
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
