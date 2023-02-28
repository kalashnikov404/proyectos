package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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

public class RegistrarCompras extends JPanel {
	private JTextField txfCantidad;
	private JTextField txfCosto;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	private ServiceCompra serviceCompra;
	private ServiceProveedor serviceProveedor;
	private ServiceCalentador serviceCalentador;
	private JTextField textField;
	private JTextField textField_1;
	Proveedor p=new Proveedor();
	Calentador c=new Calentador();
	DetalleCompra com=new DetalleCompra();
	Compra cop=new Compra();
	private JTextField txfTotal;
	private JLabel lblNewLabel_5;
	private JButton btnAgrega;
	private JTextField txfSubTotal;
	private JLabel lblNewLabel_6;
	private JTable table;
	int clavesProveedor;
	int clavesCalentador;

	public RegistrarCompras(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1366, 768);
			setLayout(null);

			try {
				serviceCompra=new ServiceCompraImpl();
				serviceProveedor=new ServiceProveedorImpl();
				serviceCalentador=new ServiceCalentadorImpl();


				JLabel lblTitulo = new JLabel("Registrar Compras");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Proveedor:");
				lblNewLabel_1.setBounds(88, 99, 85, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Costo:");
				lblNewLabel_2.setBounds(88, 218, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Cantidad:");
				lblNewLabel_3.setBounds(88, 277, 61, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Calentador:");
				lblNewLabel_4.setBounds(88, 158, 97, 16);
				add(lblNewLabel_4);


				table = new JTable();
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setBounds(23, 197, 799, 285);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Cantidad", "Costo","Subtotal"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(703, 98, 715, 368);
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
				txfCantidad.setBounds(185, 272, 130, 26);
				add(txfCantidad);
				txfCantidad.setColumns(10);

				txfCosto = new JTextField();
				txfCosto.setBounds(185, 213, 130, 26);
				add(txfCosto);
				txfCosto.setColumns(10);


				JButton btnNewButton = new JButton("Registrar compra");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Compra compra=new Compra();

						String salida=serviceCompra.modificarTotalCompra();
						txfTotal.setText(salida);
						System.out.println("Si pase por aqui");
						
						if(salida.equals("Total de compra colocado")) {
							
							txfSubTotal.setText("");
							txfTotal.setText("");
							JOptionPane.showMessageDialog(null, salida);
							


						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
					}
				});
				btnNewButton.setBounds(1212, 609, 185, 71);
				add(btnNewButton);


				List<String> prove =new ArrayList();
				prove=serviceCompra.getListaProveedor();
				String[] pro= Conversor.getArrayDeList(prove);
				comboBox = new JComboBox(pro);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todo = comboBox.getSelectedItem().toString();
						
						System.out.println(todo);
						
						String[] partes = todo.split(", ");
						textField.setText(partes[0]);
						clavesProveedor=serviceCompra.getCveProveedor(textField.getText());
						//System.out.println("La cve_pro= "+clavesProveedor);
					}
				});
				comboBox.setBounds(185, 90, 394, 36);
				add(comboBox);

				List<String> cale =new ArrayList();
				cale=serviceCalentador.getListaCalentadores();
				String[] cal= Conversor.getArrayDeList(cale);

				comboBox_1 = new JComboBox(cal);
				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todos = comboBox_1.getSelectedItem().toString();
						String[] partes2 = todos.split(", ");
						textField_1.setText(partes2[0]);
						clavesCalentador=serviceCompra.getCveCalentador(textField_1.getText());
						//System.out.println("La cve_pro= "+clavesCalentador);
					}
				});
				comboBox_1.setBounds(185, 154, 394, 27);
				add(comboBox_1);

				textField = new JTextField();
				textField.setEnabled(false);
				textField.setEditable(false);
				textField.setVisible(false);
				textField.setBounds(591, 97, 33, 20);
				add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setEnabled(false);
				textField_1.setEditable(false);
				textField_1.setVisible(false);
				textField_1.setBounds(591, 156, 33, 20);
				add(textField_1);
				textField_1.setColumns(10);

				txfTotal = new JTextField();
				txfTotal.setBounds(477, 342, 86, 20);
				add(txfTotal);
				txfTotal.setColumns(10);

				lblNewLabel_5 = new JLabel("Total");
				lblNewLabel_5.setBounds(419, 345, 46, 14);
				add(lblNewLabel_5);

				btnAgrega = new JButton("Agregar a compra");
				btnAgrega.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txfTotal.getText().isEmpty()) {//	System.out.println("aï¿½ade renglon nuevo a esta compra");
							com.setCantidad(Integer.parseInt(txfCantidad.getText()));
							com.setCosto(Float.parseFloat(txfCosto.getText()));
							com.setBaja(Integer.parseInt(txfCantidad.getText()));
							com.setProveedor(clavesProveedor);
							com.setCalentador(clavesCalentador);
							com.setSubtotal(Float.parseFloat(txfSubTotal.getText()));

							String salida = serviceCompra.registrarDetalleCompra(com);
							txfTotal.setText(txfSubTotal.getText());//fija la segunda o + compras
							if(salida.equals("Compra registrada")) {
								JOptionPane.showMessageDialog(null, salida);
								txfCantidad.setText(null);
								txfCosto.setText(null);
							}else {
								JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
							}
						}else {
							//System.out.println("estaba vac dEVO DE CREAR OTRA COMPRA Y LLENAR LOS DATOS ");
							Compra compra=new Compra();
							compra.setTotal(Float.parseFloat("0"));
							serviceCompra.registrarCompra(compra);
							System.out.println("estaba vacio");
							com.setCantidad(Integer.parseInt(txfCantidad.getText()));
							com.setCosto(Float.parseFloat(txfCosto.getText()));
							com.setBaja(Integer.parseInt(txfCantidad.getText()));
							com.setProveedor(clavesProveedor);
							com.setCalentador(clavesCalentador);
							com.setSubtotal(Float.parseFloat(txfSubTotal.getText()));


							String salida = serviceCompra.registrarDetalleCompra(com);
							txfTotal.setText(txfSubTotal.getText());//fija la primera compra

							if(salida.equals("Compra registrada")) {
								JOptionPane.showMessageDialog(null, salida);
								txfCantidad.setText("");
								txfCosto.setText("");
							}else {
								JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
							}}
						DetalleCompra dc = new DetalleCompra();
						List<DetalleCompra> detallecompra = new ArrayList<>();
						detallecompra=serviceCompra.getAgregarTabla(dc,"Agregar");
						String data[][] = new String[detallecompra.size()][3];
						for(int i=0; i<detallecompra.size(); i++) {
							data[i][0]=String.valueOf(detallecompra.get(i).getCantidad());
							data[i][1]=String.valueOf(detallecompra.get(i).getCosto());
							data[i][2]=String.valueOf(detallecompra.get(i).getSubtotal());
						}
						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);

					}
				});
				btnAgrega.setBounds(462, 440, 162, 26);
				add(btnAgrega);

				txfSubTotal = new JTextField();
				txfSubTotal.setBounds(185, 342, 86, 20);
				add(txfSubTotal);
				txfSubTotal.setColumns(10);

				lblNewLabel_6 = new JLabel("SubTotal");
				lblNewLabel_6.setBounds(88, 345, 74, 14);
				add(lblNewLabel_6);

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
