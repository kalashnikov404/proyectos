package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import api.ServiceCliente;
import api.ServiceSocio;
import api.ServiceTransporte;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Persona;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceSocioImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegistrarSocios extends JPanel {
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;

	private ServiceSocio serviceSocio;

	public RegistrarSocios(String usuario) {

		if(usuario.equals("dueño")) {

			try {
				serviceSocio = new ServiceSocioImpl();

				setBackground(new Color(255, 128, 128));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Registrar informe");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(64, 128, 128));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(596, 114, 61, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Fecha:");
				lblNewLabel_2.setBounds(596, 178, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Tipo:");
				lblNewLabel_3.setBounds(596, 251, 61, 16);
				add(lblNewLabel_3);

				tfNombre = new JTextField();
				tfNombre.setBounds(769, 109, 401, 26);
				add(tfNombre);
				tfNombre.setColumns(10);

				tfDireccion = new JTextField();
				tfDireccion.setBounds(769, 173, 401, 26);
				add(tfDireccion);
				tfDireccion.setColumns(10);

				tfTelefono = new JTextField();
				tfTelefono.setBounds(769, 246, 130, 26);
				add(tfTelefono);
				tfTelefono.setColumns(10);

				JButton btnNewButton = new JButton("Registrar informe");

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Persona persona = new Persona();



						persona.setNombre(tfNombre.getText());
						persona.setDireccion(tfDireccion.getText());
						persona.setTelefono(tfTelefono.getText());





						String salida= serviceSocio.registrarSocio(persona);




						if(salida.equals("Informe registrado")) {
						tfNombre.setText(null);
							tfDireccion.setText(null);
							tfTelefono.setText(null);
							JOptionPane.showMessageDialog(null, salida);

						}else {					JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
					}
				});





				btnNewButton.setBounds(971, 533, 185, 71);
				add(btnNewButton);

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
				btnSalir.setBounds(44, 533, 85, 81);
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
