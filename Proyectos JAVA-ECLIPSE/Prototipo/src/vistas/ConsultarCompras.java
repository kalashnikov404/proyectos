package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceCalentador;
import api.ServiceCompra;
import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.DetalleCompra;
import modelo.Horario;
import servicios.ServiceCalentadorImpl;
import servicios.ServiceCompraImpl;
import servicios.ServiceProveedorImpl;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ConsultarCompras extends JPanel {
	private JTable table;
	private ButtonGroup opciones;
	private JRadioButton rdProveedor;
	private JRadioButton rdFecha;
	private JRadioButton rdCalentador;
	private ServiceCompra serviceCompra;
	private ServiceProveedor serviceProveedor;
	private ServiceCalentador serviceCalentador;
	private JTextField textField;
	private JTextField textField_1;
	private JDateChooser fecha;
	private JComboBox cbRazonSocial;
	private JComboBox cbCalentador;

	public ConsultarCompras(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			try {
				serviceCompra=new ServiceCompraImpl();
				serviceProveedor=new ServiceProveedorImpl();
				serviceCalentador=new ServiceCalentadorImpl();


				JLabel lblTitulo = new JLabel("Consultar Compras");
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
				String nombreColunas[] = {"Fecha","Cantidad", "Costo", "Subtotal","Razon Social","Email provedor","Tipo calentador","Num. cilindros","Dimenciones","Marca","Precio"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


				List<String> prove =new ArrayList();
				prove=serviceCompra.getListaProveedor();
				String[] pro= Conversor.getArrayDeList(prove);
				cbRazonSocial = new JComboBox(pro);
				cbRazonSocial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todo = cbRazonSocial.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						textField_1.setText(partes[0]);

					}
				});
				cbRazonSocial.setBounds(637, 80, 481, 27);
				add(cbRazonSocial);


				JButton btBuscar = new JButton("Buscar");
				btBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DetalleCompra dc=new DetalleCompra();
						List<String> detallecompra = new ArrayList<>(); 

						if(rdFecha.isSelected()) {
							dc.setFecha(fecha.getDate());
							detallecompra=serviceCompra.getDC(dc,"Fecha");
						}
						if(rdCalentador.isSelected()) {
							int clavesCalentador=serviceCompra.getCveCalentador(textField.getText());
							dc.setCalentador((clavesCalentador));
							detallecompra=serviceCompra.getDC(dc,"Calentador");
						}
						if(rdProveedor.isSelected()) {
							int clavesProveedor=serviceCompra.getCveProveedor(textField_1.getText());
							dc.setProveedor(clavesProveedor);
							detallecompra=serviceCompra.getDC(dc,"Proveedor");	
						}

						String data[][] = new String[detallecompra.size()][11];
						int j=0;
						for(int i=0; i<detallecompra.size(); i++) {
							j=0;
							String[] partes = detallecompra.get(i).split(", ");

							data[i][0]=partes[j]; 
							System.out.println("Fecha"+partes[j]);
							//Fecha
							j++;
							data[i][1]=partes[j];
							System.out.println("Cantidad"+partes[j]);
							//Cantidad
							j++;
							data[i][2]=partes[j]; //costo
							System.out.println("Costo"+partes[j]);

							j++;
							data[i][3]=partes[j];//subtotal
							System.out.println("Valor de j "+j);
							System.out.println("Subtotal"+partes[j]);

							j++;
							data[i][4]=partes[j]; //razon social prov
							System.out.println("Razon "+partes[j]);

							j++;
							data[i][5]=partes[j];
							System.out.println("EMAIL "+partes[j]);

							j++;
							data[i][6]=partes[j];//tipo
							System.out.println("Tipo cal "+partes[j]);

							j++;
							data[i][7]=partes[j];//numcilindros
							System.out.println("Numcilindros "+partes[j]);

							j++;
							data[i][8]=partes[j];//dimenciones
							System.out.println("Dimenciones "+partes[j]);

							j++;
							data[i][9]=partes[j];//marca
							System.out.println("Marca "+partes[j]);

							j++;
							data[i][10]=partes[j];
							System.out.println("PRECIO "+partes[j]);

						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
						table.getColumnModel().getColumn(5).setPreferredWidth(200);
						table.getColumnModel().getColumn(6).setPreferredWidth(200);
						table.getColumnModel().getColumn(7).setPreferredWidth(200);
						table.getColumnModel().getColumn(8).setPreferredWidth(200);
						table.getColumnModel().getColumn(9).setPreferredWidth(200);
						table.getColumnModel().getColumn(10).setPreferredWidth(200);
					}

				});
				btBuscar.setBounds(1305, 159, 117, 29);
				add(btBuscar);



				fecha = new JDateChooser();
				fecha.setBounds(185, 80, 130, 26);
				add(fecha);



				JButton btMostrarTodo = new JButton("Mostrar todo");
				btMostrarTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						DetalleCompra dc = new DetalleCompra();
						List<String> detallecompra = new ArrayList<>();
						detallecompra=serviceCompra.getDC(dc,"Todo");
						String data[][] = new String[detallecompra.size()][11];
						int j=0;
						for(int i=0; i<detallecompra.size(); i++) {
							j=0;
							String[] partes = detallecompra.get(i).split(", ");

							data[i][0]=partes[j]; 
							System.out.println("Fecha"+partes[j]);
							j++;
							data[i][1]=partes[j];
							System.out.println("Cantidad"+partes[j]);
							j++;
							data[i][2]=partes[j]; //costo
							System.out.println("Costo"+partes[j]);
							j++;
							data[i][3]=partes[j];//subtotal
							System.out.println("Subtotal"+partes[j]);
							j++;
							data[i][4]=partes[j]; //razon social prov
							System.out.println("Razon "+partes[j]);
							j++;
							data[i][5]=partes[j];
							System.out.println("EMAIL "+partes[j]);
							j++;
							data[i][6]=partes[j];//tipo
							System.out.println("Tipo cal "+partes[j]);
							j++;
							data[i][7]=partes[j];//numcilindros
							System.out.println("Numcilindros "+partes[j]);
							j++;
							data[i][8]=partes[j];//dimenciones
							System.out.println("Dimenciones "+partes[j]);
							j++;
							data[i][9]=partes[j];//marca
							System.out.println("Marca "+partes[j]);
							j++;
							data[i][10]=partes[j];
							System.out.println("PRECIO "+partes[j]);

						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
						table.getColumnModel().getColumn(5).setPreferredWidth(200);
						table.getColumnModel().getColumn(6).setPreferredWidth(200);
						table.getColumnModel().getColumn(7).setPreferredWidth(200);
						table.getColumnModel().getColumn(8).setPreferredWidth(200);
						table.getColumnModel().getColumn(9).setPreferredWidth(200);
						table.getColumnModel().getColumn(10).setPreferredWidth(200);


					}
				});
				btMostrarTodo.setBounds(1226, 654, 185, 71);
				add(btMostrarTodo);

				rdProveedor = new JRadioButton("Proveedor");
				rdProveedor.setBounds(508, 80, 117, 23);
				add(rdProveedor);

				rdFecha = new JRadioButton("Fecha");
				rdFecha.setBounds(50, 83, 109, 23);
				add(rdFecha);

				rdCalentador = new JRadioButton("Calentador");
				rdCalentador.setBounds(50, 146, 109, 23);
				add(rdCalentador);

				opciones = new ButtonGroup();
				opciones.add(rdProveedor);
				opciones.add(rdCalentador);
				opciones.add(rdFecha);


				List<String> cale =new ArrayList();
				cale=serviceCalentador.getListaCalentadores();
				String[] cal= Conversor.getArrayDeList(cale);

				JComboBox cbCalentador = new JComboBox(cal);
				cbCalentador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todos = cbCalentador.getSelectedItem().toString();
						String[] partes2 = todos.split(", ");
						textField.setText(partes2[0]);
					}
				});
				cbCalentador.setBounds(178, 143, 567, 29);
				add(cbCalentador);

				textField = new JTextField();
				textField.setEnabled(false);
				textField.setEditable(false);
				textField.setVisible(false);
				textField.setBounds(757, 155, 34, 20);
				add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setVisible(false);
				textField_1.setEnabled(false);
				textField_1.setBounds(1119, 80, 28, 20);
				add(textField_1);
				textField_1.setColumns(10);

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
