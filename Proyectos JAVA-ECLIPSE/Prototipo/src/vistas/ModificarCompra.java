package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.CDATASection;

import api.ServiceCalentador;
import api.ServiceCompra;
import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Persona;
import modelo.Proveedor;
import servicios.ServiceCalentadorImpl;
import servicios.ServiceCompraImpl;
import servicios.ServiceProveedorImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ModificarCompra extends JPanel {
	private JTextField txfCantidad;
	private JTextField txfCosto;
	private JComboBox cbProveedor;
	private JComboBox cbCalentador;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txfTotal;
	private JLabel lblNewLabel_5;
	private JButton btnAgrega;
	private JTextField txfSubTotal;
	private JLabel lblNewLabel_6;
	private JTable table;
	private JTextField txfCveCompra;

	private ServiceCompra serviceCompra;
	private ServiceProveedor serviceProveedor;
	private ServiceCalentador serviceCalentador;

	Proveedor p=new Proveedor();
	Calentador c=new Calentador();
	DetalleCompra com=new DetalleCompra();
	Compra cop=new Compra();


	private DetalleCompra newcompra;
	private DetalleCompra oldcompra;
	private Compra newcomp;

	int clavesProveedor;
	int clavesCalentador;
	private JTextField textField_2;

	public ModificarCompra(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			try {
				serviceCompra=new ServiceCompraImpl();
				serviceProveedor=new ServiceProveedorImpl();
				serviceCalentador=new ServiceCalentadorImpl();


				JLabel lblTitulo = new JLabel("Modificar Compras");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Proveedor:");
				lblNewLabel_1.setBounds(704, 157, 85, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Costo:");
				lblNewLabel_2.setBounds(704, 277, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Cantidad:");
				lblNewLabel_3.setBounds(704, 328, 61, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Calentador:");
				lblNewLabel_4.setBounds(704, 210, 97, 16);
				add(lblNewLabel_4);

				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int seleccion= table.getSelectedRow();
						txfCantidad.setText(String.valueOf(table.getValueAt(seleccion, 0)));
						txfCosto.setText(String.valueOf(table.getValueAt(seleccion, 1)));
						txfSubTotal.setText(String.valueOf(table.getValueAt(seleccion, 2)));
						textField_2.setText(String.valueOf(table.getValueAt(seleccion, 3)));

						String proveedor= table.getValueAt(seleccion, 4)+", "+table.getValueAt(seleccion, 5);
						cbProveedor.setSelectedItem(proveedor);

						String calentador= table.getValueAt(seleccion, 6)+", "+table.getValueAt(seleccion, 7)
						+", "+table.getValueAt(seleccion, 8)+", "+table.getValueAt(seleccion, 9)+", "+table.getValueAt(seleccion, 10);
						cbCalentador.setSelectedItem(calentador);

						int parseou=Integer.parseInt(textField_2.getText());

						float parseo5=Float.parseFloat(txfSubTotal.getText());
						oldcompra=new DetalleCompra(parseou);
					}
				});
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setBounds(23, 197, 799, 285);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Cantidad", "Costo", "Subtotal","NumCompra","Razon Social","Email provedor","Tipo calentador","Num. cilindros","Dimenciones","Marca","Precio"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(23, 231, 630, 356);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 


				txfCantidad = new JTextField();
				txfCantidad.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String numero=txfCosto.getText();
						String numero2=txfCantidad.getText();
						Float n=Float.parseFloat(numero);
						Float n2=Float.parseFloat(numero2);
						float res= n*n2;
						txfSubTotal.setText(String.valueOf(res));

					}
				});
				txfCantidad.setBounds(801, 323, 130, 26);
				add(txfCantidad);
				txfCantidad.setColumns(10);

				txfCosto = new JTextField();
				txfCosto.setBounds(801, 272, 130, 26);
				add(txfCosto);
				txfCosto.setColumns(10);



				List<String> prove =new ArrayList();
				prove=serviceCompra.getListaProveedor();
				String[] pro= Conversor.getArrayDeList(prove);
				cbProveedor = new JComboBox(pro);
				cbProveedor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todo = cbProveedor.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						textField.setText(partes[0]);
						clavesProveedor=serviceCompra.getCveProveedor(textField.getText());
						System.out.println("La cve_pro= "+clavesProveedor);
					}
				});
				cbProveedor.setBounds(801, 148, 450, 36);
				add(cbProveedor);

				List<String> cale =new ArrayList();
				cale=serviceCalentador.getListaCalentadores();
				String[] cal= Conversor.getArrayDeList(cale);

				cbCalentador = new JComboBox(cal);
				cbCalentador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todos = cbCalentador.getSelectedItem().toString();
						String[] partes2 = todos.split(", ");
						textField_1.setText(partes2[0]);
						clavesCalentador=serviceCompra.getCveCalentador(textField_1.getText());
						System.out.println("La cve_pro= "+clavesCalentador);
					}
				});
				cbCalentador.setBounds(801, 206, 450, 27);
				add(cbCalentador);

				textField=new JTextField();
				textField.setVisible(false);
				textField.setEnabled(false);
				textField.setEditable(false);
				textField.setBounds(1263, 155, 40, 20);
				add(textField);
				textField.setColumns(10);

				textField_1=new JTextField();
				textField_1.setEnabled(false);
				textField_1.setEditable(false);
				textField_1.setVisible(false);
				textField_1.setBounds(1263, 208, 40, 20);
				add(textField_1);
				textField_1.setColumns(10);

				txfTotal = new JTextField();
				txfTotal.setBounds(1165, 389, 86, 20);
				add(txfTotal);
				txfTotal.setColumns(10);

				lblNewLabel_5 = new JLabel("Total");
				lblNewLabel_5.setBounds(1088, 392, 46, 14);
				add(lblNewLabel_5);

				btnAgrega = new JButton("Modificar compra");
				btnAgrega.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Detalle compra 
						int parseo=Integer.parseInt(txfCantidad.getText());
						float parseo2=Float.parseFloat(txfCosto.getText());
						float parseo5=Float.parseFloat(txfSubTotal.getText());

						newcompra=new DetalleCompra(parseo,parseo2,parseo,clavesProveedor,clavesCalentador, parseo5);
						String salida = serviceCompra.modificarDetalleCompra(newcompra, oldcompra);
						//System.out.println(newcompra+"Esta es la compra");
						//System.out.println(oldcompra+"");
						if(salida.equals("Modificacion completa")) {
							
							txfCantidad.setText(null);
							txfCosto.setText(null);
							txfSubTotal.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
						//Compra

						String cve=txfCveCompra.getText();
						float total= serviceCompra.getTotal(Integer.parseInt(cve));
						//System.out.println(cve+"Clave de la compra");
						String salida2=serviceCompra.modificarCompra(total,cve);
						txfTotal.setText(String.valueOf(total));
						if(salida2.equals("Modificacion lista")) {
							JOptionPane.showMessageDialog(null, salida2);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal con los datos de compra");
						}



					}
				});
				btnAgrega.setBounds(1212, 609, 185, 71);
				add(btnAgrega);

				txfSubTotal = new JTextField();
				txfSubTotal.setBounds(913, 389, 86, 20);
				add(txfSubTotal);
				txfSubTotal.setColumns(10);

				lblNewLabel_6 = new JLabel("SubTotal");
				lblNewLabel_6.setBounds(832, 392, 69, 14);
				add(lblNewLabel_6);

				List<String> compra =new ArrayList();
				compra=serviceCompra.getListaCompra();
				String[] com= Conversor.getArrayDeList(compra);
				JComboBox cbCompra= new JComboBox(com);
				cbCompra.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todo = cbCompra.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						txfCveCompra.setText(partes[0]);
						txfTotal.setText(partes[2]);

						DetalleCompra dc = new DetalleCompra();
						List<String> detallecompra = new ArrayList<>();

						if(!txfCveCompra.getText().isEmpty()) {
							String compra= txfCveCompra.getText().toString();
							dc.setCve(Integer.parseInt(compra));
							detallecompra=serviceCompra.getListaMD(dc,"Detalle");
						}else {
							JOptionPane.showMessageDialog(null,"Seleccione una compra primero");
						}


						String data[][] = new String[detallecompra.size()][11];
						int j=0;
						for(int i=0; i<detallecompra.size(); i++) {
							j=0;
							String[] parte = detallecompra.get(i).split(", ");

							data[i][0]= parte[j]; 
							System.out.println("Fecha"+ parte[j]);
							j++;
							data[i][1]= parte[j];
							System.out.println("Cantidad"+parte[j]);
							j++;
							data[i][2]=parte[j]; //costo
							j++;
							data[i][3]=parte[j];//subtotal
							j++;
							data[i][4]=parte[j]; //razon social prov
							j++;
							data[i][5]=parte[j];
							j++;
							data[i][6]=parte[j];//tipo
							j++;
							data[i][7]=parte[j];//numcilindros
							j++;
							data[i][8]=parte[j];//dimenciones
							j++;
							data[i][9]=parte[j];//marca
							j++;
							data[i][10]=parte[j];

						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setMinWidth(0);//eS EL DATO DE LA CLAVE DE DETALLECOMPRA 
						table.getColumnModel().getColumn(3).setMaxWidth(0);//pOR ESO LO OCULTO ASI NO LO VE EL USUARIO
						table.getColumnModel().getColumn(3).setPreferredWidth(0);//pERO YO PUEDO USARLO :)

						table.getColumnModel().getColumn(4).setPreferredWidth(200);
						table.getColumnModel().getColumn(5).setPreferredWidth(200);
						table.getColumnModel().getColumn(6).setPreferredWidth(200);
						table.getColumnModel().getColumn(7).setPreferredWidth(200);
						table.getColumnModel().getColumn(8).setPreferredWidth(200);
						table.getColumnModel().getColumn(9).setPreferredWidth(200);
						table.getColumnModel().getColumn(10).setPreferredWidth(200);

					}
				});
				cbCompra.setBounds(128, 147, 256, 36);
				add(cbCompra);

				JLabel lblNewLabel_7 = new JLabel("Compra: ");
				lblNewLabel_7.setBounds(24, 158, 94, 15);
				add(lblNewLabel_7);

				JLabel lblNewLabel_8 = new JLabel("Detalle Compra: ");
				lblNewLabel_8.setBounds(24, 188, 198, 26);
				add(lblNewLabel_8);

				txfCveCompra = new JTextField();
				txfCveCompra.setVisible(false);
				txfCveCompra.setEnabled(false);
				txfCveCompra.setEditable(false);
				txfCveCompra.setBounds(388, 155, 40, 20);
				add(txfCveCompra);
				txfCveCompra.setColumns(10);

				textField_2 = new JTextField();
				textField_2.setVisible(false);
				textField_2.setEnabled(false);
				textField_2.setEditable(false);
				textField_2.setBounds(431, 155, 34, 20);
				add(textField_2);
				textField_2.setColumns(10);

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
