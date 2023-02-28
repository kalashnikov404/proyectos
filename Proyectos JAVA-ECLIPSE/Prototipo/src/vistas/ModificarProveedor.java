package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Transporte;
import servicios.ServiceProveedorImpl;


public class ModificarProveedor extends JPanel {
	private JTextField txfNombre;
	private JTextField txfDireccion;
	private JTextField txfTelefono;
	private JTextField txfRazonSocial;
	private JTextField txfEmail;
	private JButton btnModificar;

	private Persona newPersona;
	private Persona oldPersona;
	private Proveedor newProveedor;
	private Proveedor oldProveedor;

	private ServiceProveedor serviceProveedor;
	private JComboBox comboBox;


	public ModificarProveedor(String usuario) {

		if(usuario.equals("dueño")) {

		setBackground(new Color(157, 198, 69));
		setBounds(100, 100, 1440, 900);
		setLayout(null);

		try {
			serviceProveedor = new ServiceProveedorImpl();

			JLabel lblTitulo = new JLabel("Modificar Proveedor");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(58, 131, 29));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			add(lblTitulo);

			JLabel lbProveedor = new JLabel("Proveedor:");
			lbProveedor.setFont(new Font("Arial", Font.PLAIN, 15));
			lbProveedor.setBounds(153, 149, 73, 16);
			add(lbProveedor);


			List<String> prove =new ArrayList();
			prove=serviceProveedor.getListaProveedor();
			String[] pro= Conversor.getArrayDeList(prove);

			comboBox = new JComboBox(pro);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String todo = comboBox.getSelectedItem().toString();
					String[] partes = todo.split(", ");
					txfNombre.setText(partes[0]);
					txfDireccion.setText(partes[1]);
					txfTelefono.setText(partes[2]);
					txfRazonSocial.setText(partes[3]);
					txfEmail.setText(partes[4]);
					oldPersona=new Persona(partes[0], partes[1],partes[2]);
					oldProveedor=new Proveedor(partes[3], partes[4]);
				}
			});
			comboBox.setBounds(229, 140, 663, 36);
			add(comboBox);

			JLabel lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 15));
			lbNombre.setBackground(new Color(157, 198, 69));
			lbNombre.setBounds(561, 225, 85, 26);
			add(lbNombre);

			JLabel lbDireccion = new JLabel("Direccion:");
			lbDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
			lbDireccion.setBackground(new Color(157, 198, 69));
			lbDireccion.setBounds(561, 303, 85, 16);
			add(lbDireccion);

			JLabel lbTelefono = new JLabel("Telefono:");
			lbTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
			lbTelefono.setBackground(new Color(157, 198, 69));
			lbTelefono.setBounds(561, 377, 61, 16);
			add(lbTelefono);

			JLabel lbRazonSocial = new JLabel("Razon social:");
			lbRazonSocial.setFont(new Font("Arial", Font.PLAIN, 15));
			lbRazonSocial.setBackground(new Color(157, 198, 69));
			lbRazonSocial.setBounds(561, 444, 97, 16);
			add(lbRazonSocial);

			txfNombre = new JTextField();
			txfNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txfNombre.setBounds(747, 223, 467, 31);
			add(txfNombre);
			txfNombre.setColumns(10);

			txfDireccion = new JTextField();
			txfDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
			txfDireccion.setBounds(747, 296, 467, 31);
			add(txfDireccion);
			txfDireccion.setColumns(10);

			txfTelefono = new JTextField();
			txfTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
			txfTelefono.setBounds(747, 367, 200, 37);
			add(txfTelefono);
			txfTelefono.setColumns(10);

			txfRazonSocial = new JTextField();
			txfRazonSocial.setFont(new Font("Arial", Font.PLAIN, 14));
			txfRazonSocial.setBounds(747, 434, 467, 37);
			add(txfRazonSocial);
			txfRazonSocial.setColumns(10);

			btnModificar = new JButton("Modificar Proveedor");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					newPersona = new Persona(txfNombre.getText(),txfDireccion.getText(),txfTelefono.getText());
					String salida = serviceProveedor.modificarPersona(newPersona, oldPersona);

					if(salida.equals("Persona modificada")) {
						txfNombre.setText(null);
						txfDireccion.setText(null);
						txfTelefono.setText(null);
						
						JOptionPane.showMessageDialog(null, salida);
					}else {
						JOptionPane.showMessageDialog(null, "Algo salido mal, revisa los datos ingresados");
					}	


					newProveedor=new Proveedor(txfRazonSocial.getText(),txfEmail.getText());
					String salida2 = serviceProveedor.modificarProveedor(newProveedor, oldProveedor);

					if(salida2.equals("Proveedor modificado")) {
						
						txfRazonSocial.setText(null);
						txfEmail.setText(null);
						
						JOptionPane.showMessageDialog(null, salida2);
					}else {
						JOptionPane.showMessageDialog(null, "Algo salido mal, revisa los datos ingresados");
					}	
				}
			});
			btnModificar.setFocusTraversalPolicyProvider(true);
			btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnModificar.setBackground(new Color(157, 198, 69));
			btnModificar.setBounds(1212, 609, 185, 71);
			add(btnModificar);

			JLabel lbEmail = new JLabel("E-mail:");
			lbEmail.setBackground(new Color(157, 198, 69));
			lbEmail.setFont(new Font("Arial", Font.PLAIN, 15));
			lbEmail.setBounds(561, 519, 61, 16);
			add(lbEmail);

			txfEmail = new JTextField();
			txfEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			txfEmail.setBounds(747, 512, 467, 31);
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

			JButton btnEliminar = new JButton("Borrar Proveedor");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String salida = serviceProveedor.eliminarProveedor(oldPersona, oldProveedor);

					if(salida.equals("Proveedor borrado")) {
						JOptionPane.showMessageDialog(null, salida);
					}else {
						JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
					}

				}
			});
			btnEliminar.setBounds(958, 609, 185, 71);
			add(btnEliminar);

		}catch (ConexionException e) {
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
