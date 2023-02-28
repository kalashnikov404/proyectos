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
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ModificarCliente extends JPanel {

	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfNuevoTipo;
	
	
	
	private Cliente newCliente;
	private Cliente oldCliente;
	

	private ServiceCliente serviceCliente;

	public ModificarCliente(String usuario) {
		
		if(usuario.equals("dueño") || usuario.equals("empleado")) {

		try {
			serviceCliente = new ServiceClienteImpl();

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			JLabel lblTitulo = new JLabel("Modificar Cliente");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(58, 131, 29));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			add(lblTitulo);

			JLabel lblTransporte = new JLabel("Cliente:");
			lblTransporte.setBounds(18, 149, 72, 16);
			add(lblTransporte);

			List<String> cli = new ArrayList<>();
			cli=serviceCliente.getListaClientes();

			String[] clientes = Conversor.getArrayDeList(cli);

			JComboBox cbClientes = new JComboBox(clientes);
			cbClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String todo = cbClientes.getSelectedItem().toString();
					String[] partes = todo.split(", ");
					 
					tfNombre.setText(partes[0]);
					tfDireccion.setText(partes[1]);
					tfTelefono.setText(partes[2]);

					
					
					oldCliente = new Cliente(partes[0], partes[1] , partes[2], partes[3] );
					
					
				}
			});
			cbClientes.setBounds(91, 145, 731, 27);
			add(cbClientes);

			JLabel lblNombre= new JLabel("Nombre:");
			lblNombre.setBounds(606, 238, 61, 16);
			add(lblNombre);

			
			
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(606, 293, 88, 16);
			add(lblDireccion);
			
			
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(606, 348, 61, 16);
			add(lblTelefono);
			
			
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(606, 403, 61, 16);
			add(lblTipo);

			
			
			
			tfNombre = new JTextField();
			tfNombre.setBounds(740, 233, 461, 26);
			add(tfNombre);
			tfNombre.setColumns(10);
			
			

			tfDireccion = new JTextField();
			tfDireccion.setBounds(740, 288, 461, 26);
			add(tfDireccion);
			tfDireccion.setColumns(10);
			

			tfTelefono = new JTextField();
			tfTelefono.setBounds(740, 343, 238, 26);
			add(tfTelefono);
			tfTelefono.setColumns(10);
			
			

			tfNuevoTipo = new JTextField();
			tfNuevoTipo.setBounds(740, 458, 238, 26);
			add(tfNuevoTipo);
			tfNuevoTipo.setColumns(10);
			
			List<String> tip = new ArrayList<>();
			tip=serviceCliente.getListaTipos();

			String[] tipos = Conversor.getArrayDeList(tip);
			
			JComboBox cbTipo = new JComboBox(tipos);
			cbTipo.setBounds(740, 399, 238, 27);
			add(cbTipo);
			
			JRadioButton rbTipo = new JRadioButton("Agregar nuevo tipo:");
			rbTipo.setBounds(523, 459, 171, 23);
			add(rbTipo);
			

			JButton btnModificar = new JButton("Modificar cliente");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(rbTipo.isSelected()) {
						
						newCliente = new Cliente(tfNombre.getText(),tfDireccion.getText(), tfTelefono.getText(), tfNuevoTipo.getText());
						
					}else {
						String tipo = cbTipo.getSelectedItem().toString();
						newCliente = new Cliente(tfNombre.getText(),tfDireccion.getText(), tfTelefono.getText(), tipo);
						
					}
					
					String salida = serviceCliente.modificarCliente(newCliente, oldCliente);
					
					
					
					if(salida.equals("Cliente modificado")) {
						 tfNombre.setText(null);
						tfDireccion.setText(null);
						tfTelefono.setText(null);
						tfNuevoTipo.setText(null);
						JOptionPane.showMessageDialog(null, salida);
					}else {
						JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
					}
					
					
				}
			});
			btnModificar.setBounds(1212, 609, 185, 71);
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
