package vistas;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import api.ServiceProveedor;
import excepciones.ConexionException;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Transporte;
import servicios.ServiceProveedorImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarProveedores extends JPanel {

	private JTextField txfNombre;
	private JTextField txfDireccion;
	private JTextField txfTelefono;
	private JTextField txfRazonSocial;
	private JTextField txfEmail;
	private JButton btnRegistrar;

	private ServiceProveedor serviceProveedor;

	public RegistrarProveedores(String usuario) {

		if(usuario.equals("due�o")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			try {
				serviceProveedor = new ServiceProveedorImpl();


				JLabel lblTitulo = new JLabel("Registrar Proveedores");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lbNombre = new JLabel("Nombre:");
				lbNombre.setFont(new Font("Arial", Font.PLAIN, 15));
				lbNombre.setBackground(new Color(157, 198, 69));
				lbNombre.setBounds(539, 114, 85, 26);
				add(lbNombre);

				JLabel lbDireccion = new JLabel("Dirección:");
				lbDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
				lbDireccion.setBackground(new Color(157, 198, 69));
				lbDireccion.setBounds(539, 178, 85, 16);
				add(lbDireccion);

				JLabel lbTelefono = new JLabel("Telefono:");
				lbTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
				lbTelefono.setBackground(new Color(157, 198, 69));
				lbTelefono.setBounds(539, 251, 61, 16);
				add(lbTelefono);

				JLabel lbRazonSocial = new JLabel("Razón social:");
				lbRazonSocial.setFont(new Font("Arial", Font.PLAIN, 15));
				lbRazonSocial.setBackground(new Color(157, 198, 69));
				lbRazonSocial.setBounds(539, 326, 97, 16);
				add(lbRazonSocial);

				txfNombre = new JTextField();
				txfNombre.setFont(new Font("Arial", Font.PLAIN, 14));
				txfNombre.setBounds(747, 112, 467, 31);
				add(txfNombre);
				txfNombre.setColumns(10);

				txfDireccion = new JTextField();
				txfDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
				txfDireccion.setBounds(747, 171, 467, 31);
				add(txfDireccion);
				txfDireccion.setColumns(10);

				txfTelefono = new JTextField();
				txfTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
				txfTelefono.setBounds(747, 241, 200, 37);
				add(txfTelefono);
				txfTelefono.setColumns(10);

				txfRazonSocial = new JTextField();
				txfRazonSocial.setFont(new Font("Arial", Font.PLAIN, 14));
				txfRazonSocial.setBounds(747, 316, 467, 37);
				add(txfRazonSocial);
				txfRazonSocial.setColumns(10);

				btnRegistrar = new JButton("Registrar Proveedor");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Persona persona = new Persona();
						Proveedor proveedor=new Proveedor();

						persona.setNombre(txfNombre.getText());
						persona.setDireccion(txfDireccion.getText());
						persona.setTelefono(txfTelefono.getText());
						proveedor.setRazonSocial(txfRazonSocial.getText());
						proveedor.setEmail(txfEmail.getText());

						String salida = serviceProveedor.registrarPersona(persona);
						String salida2=serviceProveedor.registrarProveedor(proveedor);
						if(salida.equals("Persona registrada")&&salida2.equals("Proveedor registrado")) {
							txfNombre.setText(null);
							 txfDireccion.setText(null);
							 txfTelefono.setText(null);
							txfRazonSocial.setText(null);
							txfEmail.setText(null);
							
							JOptionPane.showMessageDialog(null, salida2);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}

					}
				});
				btnRegistrar.setFocusTraversalPolicyProvider(true);
				btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 14));
				btnRegistrar.setBounds(1212, 609, 185, 71);
				add(btnRegistrar);

				JLabel lbEmail = new JLabel("E-mail:");
				lbEmail.setBackground(new Color(157, 198, 69));
				lbEmail.setFont(new Font("Arial", Font.PLAIN, 15));
				lbEmail.setBounds(539, 388, 61, 16);
				add(lbEmail);

				txfEmail = new JTextField();
				txfEmail.setFont(new Font("Arial", Font.PLAIN, 14));
				txfEmail.setBounds(747, 381, 467, 31);
				add(txfEmail);
				txfEmail.setColumns(10);

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

			}  catch (ConexionException e1) {
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
