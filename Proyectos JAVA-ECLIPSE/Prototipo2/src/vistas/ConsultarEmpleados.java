package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import api.ServiceEmpleado;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Proveedor;
import servicios.ServiceEmpleadoImpl;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarEmpleados extends JPanel {
	private JTable table;
	private JComboBox cbNombre;
	private JComboBox cbDireccion;
	private JComboBox cbTelefono;
	private JComboBox cbRfc;
	private JComboBox cbCurp;
	private JComboBox cbNumSeg;
	private JButton btBuscar;
	private ButtonGroup opciones;

	private ServiceEmpleado serviceEmpleado;
	private JRadioButton rbCurp;
	private JRadioButton rbNumSeguro;
	private JRadioButton rbTelefono;
	private JRadioButton rbRfc;
	private JRadioButton rbNombre;
	private JRadioButton rbDireccion;
	private JButton btMostrarTodo;


	public ConsultarEmpleados(String usuario) {

		if(usuario.equals("dueño")) {

			setLayout(null);
			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1366, 768);

			try {
				serviceEmpleado = new ServiceEmpleadoImpl();


				JLabel lblTitulo = new JLabel("Consultar Empleados");
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
				String nombreColunas[] = {"Nombre","Direccion","Telefono","RFC", "CURP","Num.Seguro"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 


				btBuscar = new JButton("Buscar");
				btBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Empleado empleado = new Empleado();
						List<Empleado> emp = new ArrayList<>();
						if(rbNombre.isSelected()) {
							String nombre= cbNombre.getSelectedItem().toString();
							empleado.setNombre(nombre);
							emp=serviceEmpleado.getEmpleado(empleado, rbNombre.getText());
						}
						if(rbDireccion.isSelected()) {
							String direccion= cbDireccion.getSelectedItem().toString();
							empleado.setDireccion(direccion);
							emp=serviceEmpleado.getEmpleado(empleado, rbDireccion.getText());
						}
						if(rbTelefono.isSelected()) {
							String telefono= cbTelefono.getSelectedItem().toString();
							empleado.setTelefono(telefono);
							emp=serviceEmpleado.getEmpleado(empleado, rbTelefono.getText());
						}
						if(rbRfc.isSelected()) {
							String rfc= cbRfc.getSelectedItem().toString();
							empleado.setRfc(rfc);
							emp=serviceEmpleado.getEmpleado(empleado, rbRfc.getText());
						}
						if(rbCurp.isSelected()) {
							String curp= cbCurp.getSelectedItem().toString();
							empleado.setCurp(curp);
							emp=serviceEmpleado.getEmpleado(empleado, rbCurp.getText());
						}
						if(rbNumSeguro.isSelected()) {
							String numSeg= cbNumSeg.getSelectedItem().toString();
							empleado.setNumeroSeguro(numSeg);
							emp=serviceEmpleado.getEmpleado(empleado, rbNumSeguro.getText());
						}

						String data[][] = new String[emp.size()][6];
						for(int i=0; i<emp.size(); i++) {
							data[i][0]=emp.get(i).getNombre();
							data[i][1]=emp.get(i).getDireccion();
							data[i][2]=emp.get(i).getTelefono();
							data[i][3]=emp.get(i).getRfc();
							data[i][4]=emp.get(i).getCurp();
							data[i][5]=emp.get(i).getNumeroSeguro();
						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);	
						table.getColumnModel().getColumn(2).setPreferredWidth(200);	
						table.getColumnModel().getColumn(3).setPreferredWidth(200);	
						table.getColumnModel().getColumn(4).setPreferredWidth(200);	
						table.getColumnModel().getColumn(4).setPreferredWidth(200);	

					}
				});
				btBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
				btBuscar.setBounds(1305, 146, 117, 29);
				add(btBuscar);



				List<String> em =new ArrayList();
				em=serviceEmpleado.getListaNombre();
				String[] nombre= Conversor.getArrayDeList(em);

				cbNombre = new JComboBox(nombre);
				cbNombre.setBounds(111, 81, 408, 29);
				add(cbNombre);

				List<String> dire =new ArrayList();
				dire=serviceEmpleado.getListaDireccion();
				String[] direccion= Conversor.getArrayDeList(dire);

				cbDireccion = new JComboBox(direccion);
				cbDireccion.setBounds(658, 81, 447, 29);
				add(cbDireccion);

				List<String> tel =new ArrayList();
				tel=serviceEmpleado.getListaTelefono();
				String[] telefono= Conversor.getArrayDeList(tel);

				cbTelefono = new JComboBox(telefono);
				cbTelefono.setBounds(1226, 81, 167, 29);
				add(cbTelefono);

				List<String> rf =new ArrayList();
				rf=serviceEmpleado.getListaRfc();
				String[] rfc= Conversor.getArrayDeList(rf);

				cbRfc = new JComboBox(rfc);
				cbRfc.setBounds(99, 133, 234, 29);
				add(cbRfc);

				List<String> cu =new ArrayList();
				cu=serviceEmpleado.getListaCurp();
				String[] curp= Conversor.getArrayDeList(cu);

				cbCurp = new JComboBox(curp);
				cbCurp.setBounds(451, 133, 241, 29);
				add(cbCurp);

				List<String> num =new ArrayList();
				num=serviceEmpleado.getListaNumSeg();
				String[] numSeguro= Conversor.getArrayDeList(num);

				cbNumSeg = new JComboBox(numSeguro);
				cbNumSeg.setBounds(879, 133, 226, 29);
				add(cbNumSeg);

				rbCurp = new JRadioButton("CURP");
				rbCurp.setFont(new Font("Arial", Font.PLAIN, 14));
				rbCurp.setBounds(374, 134, 109, 23);
				add(rbCurp);

				rbNumSeguro = new JRadioButton("Num.Seguro");
				rbNumSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
				rbNumSeguro.setBounds(747, 134, 117, 23);
				add(rbNumSeguro);

				rbTelefono = new JRadioButton("Telefono");
				rbTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
				rbTelefono.setBounds(1127, 82, 97, 23);
				add(rbTelefono);

				rbRfc = new JRadioButton("RFC");
				rbRfc.setFont(new Font("Arial", Font.PLAIN, 14));
				rbRfc.setBounds(18, 133, 81, 23);
				add(rbRfc);

				rbNombre = new JRadioButton("Nombre");
				rbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
				rbNombre.setBounds(21, 84, 109, 23);
				add(rbNombre);

				rbDireccion = new JRadioButton("Direccion");
				rbDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
				rbDireccion.setBounds(555, 82, 109, 23);
				add(rbDireccion);

				opciones = new ButtonGroup();
				opciones.add(rbNombre);
				opciones.add(rbDireccion);
				opciones.add(rbCurp);
				opciones.add(rbNumSeguro);
				opciones.add(rbRfc);
				opciones.add(rbTelefono);


				btMostrarTodo = new JButton("Mostrar todo");
				btMostrarTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Empleado empleado = new Empleado();
						List<Empleado> emp = new ArrayList<>();
						emp=serviceEmpleado.getEmpleado(empleado, "Todo");

						String data[][] = new String[emp.size()][6];
						for(int i=0; i<emp.size(); i++) {
							data[i][0]=emp.get(i).getNombre();
							data[i][1]=emp.get(i).getDireccion();
							data[i][2]=emp.get(i).getTelefono();
							data[i][3]=emp.get(i).getRfc();
							data[i][4]=emp.get(i).getCurp();
							data[i][5]=emp.get(i).getNumeroSeguro();
						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);	
						table.getColumnModel().getColumn(2).setPreferredWidth(200);	
						table.getColumnModel().getColumn(3).setPreferredWidth(200);	
						table.getColumnModel().getColumn(4).setPreferredWidth(200);	
						table.getColumnModel().getColumn(5).setPreferredWidth(200);	


					}
				});
				btMostrarTodo.setFont(new Font("Arial", Font.PLAIN, 14));
				btMostrarTodo.setBounds(1226, 654, 185, 71);
				add(btMostrarTodo);

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
