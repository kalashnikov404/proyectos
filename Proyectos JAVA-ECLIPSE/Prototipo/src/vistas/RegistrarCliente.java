package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import api.ServiceCliente;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class RegistrarCliente extends JPanel {
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfTipo;

	private Principal principal;

	private ServiceCliente serviceCliente;

	public RegistrarCliente(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
				serviceCliente = new ServiceClienteImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Registrar Cliente");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(609, 114, 61, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Direccion:");
				lblNewLabel_2.setBounds(609, 178, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setBounds(609, 251, 61, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Tipo de cliente:");
				lblNewLabel_4.setBounds(609, 326, 97, 16);
				add(lblNewLabel_4);

				tfNombre = new JTextField();
				tfNombre.setBounds(757, 109, 472, 26);
				add(tfNombre);
				tfNombre.setColumns(10);

				tfDireccion = new JTextField();
				tfDireccion.setBounds(757, 173, 472, 26);
				add(tfDireccion);
				tfDireccion.setColumns(10);

				tfTelefono = new JTextField();
				tfTelefono.setBounds(757, 246, 130, 26);
				add(tfTelefono);
				tfTelefono.setColumns(10);

				tfTipo = new JTextField();
				tfTipo.setBounds(757, 400, 275, 26);
				add(tfTipo);
				tfTipo.setColumns(10);
				
				List<String> tip = new ArrayList<>();
				tip=serviceCliente.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);
				JComboBox cbTipos = new JComboBox(tipos);
				cbTipos.setBounds(757, 322, 275, 27);
				add(cbTipos);
				
				JRadioButton rbTipo = new JRadioButton("Agregar un nuevo tipo:");
				rbTipo.setBounds(539, 401, 185, 23);
				add(rbTipo);

				JButton btnNewButton = new JButton("Registrar cliente");

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Cliente cliente = new Cliente();



						cliente.setNombre(tfNombre.getText());
						cliente.setDireccion(tfDireccion.getText());
						cliente.setTelefono(tfTelefono.getText());
						
						
						
						if(!rbTipo.isSelected()) {

							String tipo = cbTipos.getSelectedItem().toString();

							cliente.setTipo(tipo);
						}else {
							cliente.setTipo(tfTipo.getText());
						}





						String salida= serviceCliente.registrarClientePersona(cliente);
						String salida2= serviceCliente.registrarCliente(cliente);



						if(salida.equals("Cliente registrado") && salida2.equals("Cliente registrado")) {
							 tfNombre.setText(null);
							tfDireccion.setText(null);
							 tfTelefono.setText(null);
							tfTipo.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
							
							
							//limpiar lso campos
							//JOptionPane.showMessageDialog(null, salida2);

						}else {					JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
					}
				});





				btnNewButton.setBounds(1212, 609, 185, 71);
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
