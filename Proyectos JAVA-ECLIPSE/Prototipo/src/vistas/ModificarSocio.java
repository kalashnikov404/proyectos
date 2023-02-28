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

import api.ServiceCliente;
import api.ServiceSocio;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Persona;
import modelo.Socio;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceSocioImpl;
import servicios.ServiceTransporteImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSocio extends JPanel {

	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;


	private Persona newPersona;
	private Persona oldPersona;

	private Socio newSocio;

	private Socio oldSocio;




	private ServiceSocio serviceSocio;

	public ModificarSocio(String usuario) {

		setBackground(new Color(157, 198, 69));
		setBounds(100, 100, 1391, 749);

		if(usuario.equals("dueño")) {

			try {
				serviceSocio = new ServiceSocioImpl();
				setLayout(null);


				JLabel lblTitulo = new JLabel("Modificar Socio");
				lblTitulo.setBounds(6, 6, 1428, 31);
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				add(lblTitulo);

				JLabel lblSocio = new JLabel("Socio:");
				lblSocio.setBounds(18, 149, 72, 16);
				add(lblSocio);

				List<String> per = new ArrayList<>();
				per=serviceSocio.getListaSocios();

				String[] personas = Conversor.getArrayDeList(per);

				JComboBox cbSocios = new JComboBox(personas);
				cbSocios.setBounds(62, 144, 782, 27);
				cbSocios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo = cbSocios.getSelectedItem().toString();
						String[] partes = todo.split(", ");

						tfNombre.setText(partes[0]);
						tfDireccion.setText(partes[1]);
						tfTelefono.setText(partes[2]);




						oldSocio = new Socio(partes[0] , partes[1], partes[2]);



					}
				});
				add(cbSocios);

				JLabel lblNombre= new JLabel("Nombre:");
				lblNombre.setBounds(595, 238, 61, 16);
				add(lblNombre);




				JLabel lblDireccion = new JLabel("Direccion:");
				lblDireccion.setBounds(595, 288, 85, 16);
				add(lblDireccion);



				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(595, 348, 61, 16);
				add(lblTelefono);




				tfNombre = new JTextField();
				tfNombre.setBounds(763, 233, 487, 26);
				add(tfNombre);
				tfNombre.setColumns(10);



				tfDireccion = new JTextField();
				tfDireccion.setBounds(763, 283, 487, 26);
				add(tfDireccion);
				tfDireccion.setColumns(10);


				tfTelefono = new JTextField();
				tfTelefono.setBounds(763, 343, 263, 26);
				add(tfTelefono);
				tfTelefono.setColumns(10);




				JButton btnModificar = new JButton("Modificar socio");
				btnModificar.setBounds(1212, 609, 185, 71);

				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newSocio = new Socio(tfNombre.getText(),tfDireccion.getText(), tfTelefono.getText());



						String salida = serviceSocio.modificarSocio(newSocio, oldSocio);

						if(salida.equals("Socio modificado")) {
							
							tfNombre.setText(null);
							tfDireccion.setText(null);
							tfTelefono.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}


					}
				});
				add(btnModificar);

				JButton btnSalir = new JButton("");
				btnSalir.setBounds(45, 599, 85, 81);
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
				add(btnSalir);
				
				JButton btnBorrarSocio = new JButton("Borrar Socio");
				btnBorrarSocio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						

						String salida = serviceSocio.eliminarSocio(oldPersona, oldSocio);

						if(salida.equals("Socio borrado")) {
							
							
							tfNombre.setText(null);
							tfDireccion.setText(null);
							tfTelefono.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
						
						
					}
				});
				btnBorrarSocio.setBounds(969, 609, 185, 71);
				add(btnBorrarSocio);

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
