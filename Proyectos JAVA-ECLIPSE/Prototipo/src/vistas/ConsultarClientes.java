package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import api.ServiceCliente;
import api.ServiceTransporte;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ConsultarClientes extends JPanel {


	private JTable table;
	private ButtonGroup opciones;

	private ServiceCliente serviceCliente;

	public ConsultarClientes(String usuario) {



			try {

				serviceCliente = new ServiceClienteImpl();
				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 700);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Consultar Clientes");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				final	JComboBox comboNombre = new JComboBox();
				comboNombre.addItem("Seleccione una opcion");


				ArrayList<String> lista3 = new ArrayList<String>();
				lista3 = serviceCliente.llenar_comboNombre();
				for(int i = 0; i<lista3.size();i++){

					comboNombre.addItem(lista3.get(i));
				}
				comboNombre.setBounds(122, 66, 419, 26);

				add(comboNombre);	

				final	JComboBox comboDireccion = new JComboBox();
				comboDireccion.addItem("Seleccione una opcion");


				ArrayList<String> lista4 = new ArrayList<String>();
				lista4 = serviceCliente.llenar_comboDireccion();
				for(int i = 0; i<lista4.size();i++){

					comboDireccion.addItem(lista4.get(i));
				}
				comboDireccion.setBounds(702, 66, 566, 26);

				add(comboDireccion);	

				final	JComboBox comboTelefono = new JComboBox();
				comboTelefono.addItem("Seleccione una opcion");


				ArrayList<String> lista5 = new ArrayList<String>();
				lista5 = serviceCliente.llenar_comboTelefono();
				for(int i = 0; i<lista5.size();i++){

					comboTelefono.addItem(lista5.get(i));
				}
				comboTelefono.setBounds(548, 130, 170, 26);

				add(comboTelefono);	

				final	JComboBox comboTipo = new JComboBox();
				comboTipo.addItem("Seleccione una opcion");


				ArrayList<String> lista6 = new ArrayList<String>();
				lista6 = serviceCliente.llenar_comboTipo();
				for(int i = 0; i<lista6.size();i++){

					comboTipo.addItem(lista6.get(i));
				}
				comboTipo.setBounds(122, 130, 201, 26);

				add(comboTipo);	

				table = new JTable();
				table.setBounds(1, 1, 0, 0);
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Nombre", "Direccion", "Telefono", "Tipo"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);


				JRadioButton rbNombre = new JRadioButton("Nombre");
				rbNombre.setBounds(18, 66, 92, 23);
				add(rbNombre);

				JRadioButton rbDireccion = new JRadioButton("Direccion");
				rbDireccion.setBounds(598, 66, 92, 23);
				add(rbDireccion);



				JRadioButton rbTelefono = new JRadioButton("Telefono");
				rbTelefono.setBounds(449, 130, 92, 23);
				add(rbTelefono);


				JRadioButton rbTipo = new JRadioButton("Tipo");
				rbTipo.setBounds(18, 130, 80, 23);
				add(rbTipo);


				opciones = new ButtonGroup();

				opciones.add(rbNombre);
				opciones.add(rbDireccion);
				opciones.add(rbTelefono);

				opciones.add(rbTipo);


				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(1123, 147, 117, 29);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Cliente cliente = new Cliente();
						String variable = (String) comboNombre.getSelectedItem();
						String variable2 = (String) comboDireccion.getSelectedItem();
						String variable3 = (String) comboTelefono.getSelectedItem();
						String variable4 = (String) comboTipo.getSelectedItem();



						List<Cliente> clientes = new ArrayList<>();

						if(rbNombre.isSelected()) {
							cliente.setNombre(variable);
							clientes=serviceCliente.getClientes(cliente, rbNombre.getText());



						}
						if(rbDireccion.isSelected()) {
							cliente.setDireccion(variable2);
							clientes=serviceCliente.getClientes(cliente, rbDireccion.getText());
						}

						if(rbTelefono.isSelected()) {						
							cliente.setTelefono(variable3);

							clientes=serviceCliente.getClientes(cliente, rbTelefono.getText());
						}

						if(rbTipo.isSelected()) {
							cliente.setTipo(variable4);
							clientes=serviceCliente.getClientes(cliente, rbTipo.getText());
						}




						String data[][] = new String[clientes.size()][4];

						for(int i=0; i<clientes.size(); i++) {

							data[i][0]=clientes.get(i).getNombre();
							data[i][1]=clientes.get(i).getDireccion();

							data[i][2]=	String.valueOf(clientes.get(i).getTelefono());


							data[i][3]=clientes.get(i).getTipo();

						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(500);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);


					}
				});
				add(btnBuscar);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1372, 350);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

				JButton btnTodo = new JButton("Mostrar todo");
				btnTodo.setBounds(1123, 548, 185, 71);
				btnTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Cliente cliente = new Cliente();

						List<Cliente> clientes = new ArrayList<>();

						clientes=serviceCliente.getClientes(cliente, "Todo");

						String data[][] = new String[clientes.size()][4];

						for(int i=0; i<clientes.size(); i++) {
							data[i][0]=clientes.get(i).getNombre();
							data[i][1]=clientes.get(i).getDireccion();

							data[i][2]=	String.valueOf(clientes.get(i).getTelefono());


							data[i][3]=clientes.get(i).getTipo();
						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(500);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
					}
				});
				add(btnTodo);

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
				btnSalir.setBounds(18, 548, 85, 81);
				add(btnSalir);

			} catch (ConexionException e1) {
				e1.printStackTrace();
			}

	}
}