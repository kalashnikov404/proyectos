package vistas;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Transporte;
import servicios.ServiceProveedorImpl;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ConsultarProveedor extends JPanel {
	private JTable table;
	private JButton btnMostrarTodo;
	private ButtonGroup opciones;
	private ServiceProveedor serviceProveedor;
	private JRadioButton rdRazonSocial;
	private JRadioButton rdEmail;
	private JRadioButton rdNombre;
	private JComboBox cbRazonSocial;
	private JComboBox cbEmail;
	private JComboBox cbNombre;

	public ConsultarProveedor(String usuario) {

		if(usuario.equals("dueño")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			try {
				serviceProveedor = new ServiceProveedorImpl();

				JLabel lblTitulo = new JLabel("Consultar Proveedor");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);


				table = new JTable();
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setBounds(23, 197, 799, 364);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Nombre","Direccion","Telefono","RazonSocial", "Email"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);



				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Proveedor proveedor = new Proveedor();
						List<Proveedor> prov = new ArrayList<>();
						if(rdRazonSocial.isSelected()) {
							String razonSocial= cbRazonSocial.getSelectedItem().toString();
							proveedor.setRazonSocial(razonSocial);
							prov=serviceProveedor.getProveedor(proveedor, rdRazonSocial.getText());
						}
						if(rdEmail.isSelected()) {
							String email= cbEmail.getSelectedItem().toString();
							proveedor.setEmail(email);
							prov=serviceProveedor.getProveedor(proveedor, rdEmail.getText());
						}
						if(rdNombre.isSelected()) {
							String nombre= cbNombre.getSelectedItem().toString();
							proveedor.setNombre(nombre);
							prov=serviceProveedor.getProveedor(proveedor, rdNombre.getText());
						}

						String data[][] = new String[prov.size()][5];
						for(int i=0; i<prov.size(); i++) {
							data[i][0]=prov.get(i).getNombre();
							data[i][1]=prov.get(i).getDireccion();
							data[i][2]=prov.get(i).getTelefono();
							data[i][3]=prov.get(i).getRazonSocial();
							data[i][4]=prov.get(i).getEmail();
						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);	
						table.getColumnModel().getColumn(2).setPreferredWidth(200);	
						table.getColumnModel().getColumn(3).setPreferredWidth(200);	
						table.getColumnModel().getColumn(4).setPreferredWidth(200);	
					}
				});
				btnNewButton.setBackground(new Color(157, 198, 69));
				btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
				btnNewButton.setBounds(1305, 154, 117, 29);
				add(btnNewButton);


				rdRazonSocial = new JRadioButton("Razon Social");
				rdRazonSocial.setFont(new Font("Arial", Font.PLAIN, 15));
				rdRazonSocial.setBackground(Color.WHITE);
				rdRazonSocial.setBounds(18, 75, 141, 23);
				add(rdRazonSocial);

				rdEmail = new JRadioButton("E-mail");
				rdEmail.setBackground(Color.WHITE);
				rdEmail.setFont(new Font("Arial", Font.PLAIN, 15));
				rdEmail.setBounds(18, 131, 80, 23);
				add(rdEmail);

				rdNombre = new JRadioButton("Nombre");
				rdNombre.setBackground(Color.WHITE);
				rdNombre.setFont(new Font("Arial", Font.PLAIN, 15));
				rdNombre.setBounds(686, 75, 109, 23);
				add(rdNombre);

				opciones = new ButtonGroup();
				opciones.add(rdRazonSocial);
				opciones.add(rdEmail);
				opciones.add(rdNombre);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

				btnMostrarTodo = new JButton("Mostrar todo");
				btnMostrarTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Proveedor proveedor = new Proveedor();
						List<Proveedor> prove = new ArrayList<>();
						prove=serviceProveedor.getProveedor(proveedor, "Todo");
						String data[][] = new String[prove.size()][5];
						for(int i=0; i<prove.size(); i++) {
							data[i][0]=prove.get(i).getNombre();
							data[i][1]=prove.get(i).getDireccion();
							data[i][2]=prove.get(i).getTelefono();
							data[i][3]=prove.get(i).getRazonSocial();
							data[i][4]=prove.get(i).getEmail();
						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);	
						table.getColumnModel().getColumn(2).setPreferredWidth(200);	
						table.getColumnModel().getColumn(3).setPreferredWidth(200);	
						table.getColumnModel().getColumn(4).setPreferredWidth(200);	

					}
				});
				btnMostrarTodo.setBackground(new Color(58, 131, 29));
				btnMostrarTodo.setFont(new Font("Arial", Font.PLAIN, 14));
				btnMostrarTodo.setBounds(1226, 654, 185, 71);
				add(btnMostrarTodo);

				List<String> rs =new ArrayList();
				rs=serviceProveedor.getListaRazonSocial();
				String[] razonSocial= Conversor.getArrayDeList(rs);

				cbRazonSocial = new JComboBox(razonSocial);
				cbRazonSocial.setBounds(147, 74, 439, 29);
				add(cbRazonSocial);


				List<String> em =new ArrayList();
				em=serviceProveedor.getListaEmail();
				String[] email= Conversor.getArrayDeList(em);

				cbEmail = new JComboBox(email);
				cbEmail.setBounds(103, 131, 360, 26);
				add(cbEmail);

				List<String> nom =new ArrayList();
				nom=serviceProveedor.getListaNombre();
				String[] nombre= Conversor.getArrayDeList(nom);

				cbNombre = new JComboBox(nombre);
				cbNombre.setBounds(785, 75, 527, 26);
				add(cbNombre);

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
				btnSalir.setBounds(45, 654, 85, 81);
				add(btnSalir);

			} catch (ConexionException e) {
				// TODO Auto-generated catch block
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
