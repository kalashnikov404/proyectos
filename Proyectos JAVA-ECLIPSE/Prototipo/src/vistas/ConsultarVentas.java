package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceCliente;
import api.ServiceVenta;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import modelo.Venta;
import servicios.ServiceClienteImpl;
import servicios.ServiceVentaImpl;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class ConsultarVentas extends JPanel {
	private JTable table;
	private ButtonGroup opciones;

	private ServiceVenta serviceVenta;
	private ServiceCliente serviceCliente;

	public ConsultarVentas(String usuario) {
		
		if(usuario.equals("due�o") || usuario.equals("empleado")) {

		try {
			serviceVenta = new ServiceVentaImpl();
			serviceCliente = new ServiceClienteImpl();

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			JLabel lblTitulo = new JLabel("Consultar Ventas");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(58, 131, 29));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			add(lblTitulo);

			table = new JTable();
			table.setForeground(Color.black);
			table.setBackground(new Color(242, 221, 192));
			table.setBounds(23, 197, 799, 364);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"Fecha de venta", "Hora de venta", "Precio Total", "Cantidad vendida", 
					"Tipo de calentador", "Núm de Cilindros", "Marca del calentador", "Nombre del cliente", 
					"RFC del empleado", "Fecha del fin de la garantía"};
			table.getTableHeader().setOpaque(false);
			table.getTableHeader().setBackground(new Color(229, 78, 50));
			table.getTableHeader().setForeground(Color.white);
			table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
			add(table);

			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(18, 187, 1404, 455);
			add(scrollPane);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

			JSpinner tsHora = new JSpinner( new SpinnerDateModel() );
			tsHora.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
			JSpinner.DateEditor de_tsHora = new JSpinner.DateEditor(tsHora, "HH:mm:ss");
			tsHora.setEditor(de_tsHora);
			tsHora.setValue(new Date());
			tsHora.setBounds(90, 123, 104, 31);
			tsHora.setVisible(true);
			add(tsHora);

			JDateChooser dcFecha = new JDateChooser();
			dcFecha.setBounds(440, 128, 130, 26);
			add(dcFecha);

			List<String> cli = new ArrayList<>();
			cli=serviceCliente.getListaClientes();

			String[] clientes = Conversor.getArrayDeList(cli);

			JComboBox cbCliente = new JComboBox(clientes);
			cbCliente.setBounds(222, 69, 1115, 27);
			add(cbCliente);

			JRadioButton rbHora = new JRadioButton("Hora");
			rbHora.setBounds(18, 129, 71, 23);
			add(rbHora);

			JRadioButton rbFecha = new JRadioButton("Fecha");
			rbFecha.setBounds(357, 129, 71, 23);
			add(rbFecha);

			JRadioButton rbCliente = new JRadioButton("Cliente al que se atendio");
			rbCliente.setBounds(18, 69, 192, 23);
			add(rbCliente);

			opciones = new ButtonGroup();
			opciones.add(rbHora);
			opciones.add(rbFecha);
			opciones.add(rbCliente);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Venta venta = new Venta();

					List<Venta> ventas = new ArrayList<>();

					if(rbHora.isSelected()) {
						venta.setHora(Conversor.convertirHora(tsHora.getValue().toString()));
						
						ventas = serviceVenta.getVentas(venta, rbHora.getText());
					}

					if(rbFecha.isSelected()) {
						venta.setFecha(dcFecha.getDate());
						
						ventas = serviceVenta.getVentas(venta, rbFecha.getText());
					}

					if(rbCliente.isSelected()) {
						String todo = cbCliente.getSelectedItem().toString();
						String[] partes = todo.split(", ");

						Cliente cliente = new Cliente(partes[0], partes[1] , partes[2], partes[3]);
						
						venta.setCliente(cliente);
						
						ventas = serviceVenta.getVentas(venta, rbCliente.getText());
					}

					String data[][] = new String[ventas.size()][10];

					for(int i=0; i<ventas.size(); i++) {

						data[i][0]=Conversor.convertirDate(ventas.get(i).getFecha());
						data[i][1]=String.valueOf(ventas.get(i).getHora());
						data[i][2]=String.valueOf(ventas.get(i).getPrecioTotal());
						data[i][3]=String.valueOf(ventas.get(i).getCantidad());
						data[i][4]=ventas.get(i).getCalentador().getTipo();
						data[i][5]=String.valueOf(ventas.get(i).getCalentador().getNumCilindros());
						data[i][6]=ventas.get(i).getCalentador().getMarca();
						data[i][7]=ventas.get(i).getCliente().getNombre();
						data[i][8]=ventas.get(i).getEmpleado().getRfc();
						data[i][9]=Conversor.convertirDate(ventas.get(i).getGarantia().getFechaFin());

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

				}
			});
			btnBuscar.setBounds(1305, 157, 117, 29);
			add(btnBuscar);

			JButton btnTodo = new JButton("Mostrar todo");
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Venta venta = new Venta();

					List<Venta> ventas = new ArrayList<>();

					ventas = serviceVenta.getVentas(venta, "Todo");

					String data[][] = new String[ventas.size()][10];

					for(int i=0; i<ventas.size(); i++) {

						data[i][0]=Conversor.convertirDate(ventas.get(i).getFecha());
						data[i][1]=String.valueOf(ventas.get(i).getHora());
						data[i][2]=String.valueOf(ventas.get(i).getPrecioTotal());
						data[i][3]=String.valueOf(ventas.get(i).getCantidad());
						data[i][4]=ventas.get(i).getCalentador().getTipo();
						data[i][5]=String.valueOf(ventas.get(i).getCalentador().getNumCilindros());
						data[i][6]=ventas.get(i).getCalentador().getMarca();
						data[i][7]=ventas.get(i).getCliente().getNombre();
						data[i][8]=ventas.get(i).getEmpleado().getRfc();
						data[i][9]=Conversor.convertirDate(ventas.get(i).getGarantia().getFechaFin());

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

				}
			});
			btnTodo.setBounds(1226, 654, 185, 71);
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
