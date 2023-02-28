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
import api.ServiceSocio;
import api.ServiceTransporte;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Persona;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceSocioImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ConsultarSocio extends JPanel {

	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;

	private JTable table;
	private ButtonGroup opciones;

	private ServiceSocio serviceSocio;

	public ConsultarSocio(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {

				serviceSocio = new ServiceSocioImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);


				JLabel lblTitulo = new JLabel("Consultar Socios");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				final	JComboBox comboNombre = new JComboBox();
				comboNombre.setBounds(129, 68, 491, 26);
				comboNombre.addItem("Seleccione una opcion");


				ArrayList<String> lista3 = new ArrayList<String>();
				lista3 = serviceSocio.llenar_comboNombre();
				for(int i = 0; i<lista3.size();i++){

					comboNombre.addItem(lista3.get(i));
				}


				add(comboNombre);	


				final	JComboBox comboDireccion = new JComboBox();
				comboDireccion.setBounds(802, 68, 620, 26);
				comboDireccion.addItem("Seleccione una opcion");


				ArrayList<String> lista4 = new ArrayList<String>();
				lista4 = serviceSocio.llenar_comboDireccion();
				for(int i = 0; i<lista4.size();i++){

					comboDireccion.addItem(lista4.get(i));
				}


				add(comboDireccion);	






				final	JComboBox comboTelefono = new JComboBox();
				comboTelefono.setBounds(129, 135, 252, 26);
				comboTelefono.addItem("Seleccione una opcion");


				ArrayList<String> lista5 = new ArrayList<String>();
				lista5 = serviceSocio.llenar_comboTelefono();
				for(int i = 0; i<lista5.size();i++){

					comboTelefono.addItem(lista5.get(i));
				}


				add(comboTelefono);




				table = new JTable();
				table.setBounds(1, 1, 0, 0);
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Nombre", "Direccion", "Telefono"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);


				JRadioButton rbNombre = new JRadioButton("Nombre");
				rbNombre.setBounds(23, 70, 94, 23);
				add(rbNombre);

				JRadioButton rbDireccion = new JRadioButton("Direccion");
				rbDireccion.setBounds(673, 68, 117, 23);
				add(rbDireccion);



				JRadioButton rbTelefono = new JRadioButton("Telefono");
				rbTelefono.setBounds(23, 135, 94, 23);
				add(rbTelefono);


				opciones = new ButtonGroup();

				opciones.add(rbNombre);
				opciones.add(rbDireccion);
				opciones.add(rbTelefono);


				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(1305, 156, 117, 29);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Persona persona = new Persona();
						String variable = (String) comboNombre.getSelectedItem();
						String variable2 = (String) comboDireccion.getSelectedItem();
						String variable3 = (String) comboTelefono.getSelectedItem();



						List<Persona> personas = new ArrayList<>();

						if(rbNombre.isSelected()) {
							persona.setNombre(variable);
							personas=serviceSocio.getSocios(persona, rbNombre.getText());


						}
						if(rbDireccion.isSelected()) {
							persona.setDireccion(variable2);
							personas=serviceSocio.getSocios(persona, rbDireccion.getText());
						}

						if(rbTelefono.isSelected()) {						
							persona.setTelefono(variable3);

							personas=serviceSocio.getSocios(persona, rbTelefono.getText());
						}






						String data[][] = new String[personas.size()][3];

						for(int i=0; i<personas.size(); i++) {

							data[i][0]=personas.get(i).getNombre();
							data[i][1]=personas.get(i).getDireccion();

							data[i][2]=	String.valueOf(personas.get(i).getTelefono());


						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);


					}
				});
				add(btnBuscar);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

				JButton btnTodo = new JButton("Mostrar todo");
				btnTodo.setBounds(1226, 654, 185, 71);
				btnTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Persona persona = new Persona();

						List<Persona> personas = new ArrayList<>();

						personas=serviceSocio.getSocios(persona, "Todo");

						String data[][] = new String[personas.size()][3];

						for(int i=0; i<personas.size(); i++) {
							data[i][0]=personas.get(i).getNombre();
							data[i][1]=personas.get(i).getDireccion();

							data[i][2]=	String.valueOf(personas.get(i).getTelefono());


						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);
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
				btnSalir.setBounds(45, 654, 85, 81);
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
