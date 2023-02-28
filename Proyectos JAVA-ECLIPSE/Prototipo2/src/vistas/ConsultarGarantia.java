package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceCalentador;
import api.ServiceCliente;
import api.ServiceGarantia;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Garantia;
import modelo.Transporte;
import servicios.ServiceCalentadorImpl;
import servicios.ServiceClienteImpl;
import servicios.ServiceGarantiaImpl;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ConsultarGarantia extends JPanel {

	private JTable table;
	private ButtonGroup opciones;

	private ServiceGarantia serviceGarantia;
	private ServiceCliente serviceCliente;
	private ServiceCalentador serviceCalentador;

	public ConsultarGarantia(String usuario) {
		
		if(usuario.equals("dueño") || usuario.equals("empleado")) {

		try {
			serviceGarantia = new ServiceGarantiaImpl();
			serviceCliente = new ServiceClienteImpl();
			serviceCalentador = new ServiceCalentadorImpl();

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1366, 768);
			setLayout(null);

			JLabel lblTitulo = new JLabel("Consultar GarantÃ­a");
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
			String nombreColunas[] = {"Fecha de inicio", "Fecha de fin", "Tipo de calentador", "Num de cilindros", "Marca"
					, "Nombre del cliente"};
			table.getTableHeader().setOpaque(false);
			table.getTableHeader().setBackground(new Color(229, 78, 50));
			table.getTableHeader().setForeground(Color.white);
			table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
			add(table);

			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(18, 187, 1404, 455);
			add(scrollPane);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

			List<String> cal = new ArrayList<>();
			cal=serviceCalentador.getListaCalentador();

			String[] calentadores = Conversor.getArrayDeList(cal);
			
			JComboBox cbCalentador = new JComboBox(calentadores);
			cbCalentador.setBounds(800, 130, 465, 27);
			add(cbCalentador);
			
			List<String> cli = new ArrayList<>();
			cli=serviceCliente.getListaClientes();

			String[] clientes = Conversor.getArrayDeList(cli);

			JComboBox cbCliente = new JComboBox(clientes);
			cbCliente.setBounds(110, 78, 1155, 27);
			add(cbCliente);

			JDateChooser dcFcIni = new JDateChooser();
			dcFcIni.setBounds(132, 131, 130, 26);
			add(dcFcIni);

			JDateChooser dcFcFin = new JDateChooser();
			dcFcFin.setBounds(464, 131, 130, 26);
			add(dcFcFin);

			JRadioButton rbCliente = new JRadioButton("Cliente");
			rbCliente.setBounds(24, 82, 76, 23);
			add(rbCliente);

			JRadioButton rbFcIni = new JRadioButton("Fecha inicio");
			rbFcIni.setBounds(23, 133, 107, 23);
			add(rbFcIni);

			JRadioButton rbFcFin = new JRadioButton("Fecha fin");
			rbFcFin.setBounds(363, 134, 89, 23);
			add(rbFcFin);

			JRadioButton rbCalentador = new JRadioButton("Calentador");
			rbCalentador.setBounds(697, 134, 107, 23);
			add(rbCalentador);
			
			opciones = new ButtonGroup();

			opciones.add(rbCliente);
			opciones.add(rbFcIni);
			opciones.add(rbFcFin);
			opciones.add(rbCalentador);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Garantia garantia = new Garantia();

					List<Garantia> garantias = new ArrayList<>();
					
					if(rbCliente.isSelected()) {
						Cliente cliente = new Cliente();
						
						String todo = cbCliente.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						
						cliente.setNombre(partes[0]);
						garantia.setCliente(cliente);
						
						garantias = serviceGarantia.getGarantia(garantia, rbCliente.getText());
					} 
					
					if(rbFcIni.isSelected()) {
						garantia.setFechaInicio(dcFcIni.getDate());
						
						garantias = serviceGarantia.getGarantia(garantia, rbFcIni.getText());
					}
					
					if(rbFcFin.isSelected()) {
						garantia.setFechaFin(dcFcFin.getDate());
						
						garantias = serviceGarantia.getGarantia(garantia, rbFcFin.getText());
					}
					
					if(rbCalentador.isSelected()) {
						
						Calentador calentador = new Calentador();
						
						String todo = cbCalentador.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						
						calentador.setTipo(partes[0]);
						calentador.setNumCilindros(Integer.parseInt(partes[1]));
						calentador.setMarca(partes[3]);
						garantia.setCalentador(calentador);
						
						garantias = serviceGarantia.getGarantia(garantia, rbCalentador.getText());
					}
					
					String data[][] = new String[garantias.size()][6];

					for(int i=0; i<garantias.size(); i++) {

						data[i][0]=Conversor.convertirDate(garantias.get(i).getFechaInicio());
						data[i][1]=Conversor.convertirDate(garantias.get(i).getFechaFin());
						data[i][2]=garantias.get(i).getCalentador().getTipo();
						data[i][3]=String.valueOf(garantias.get(i).getCalentador().getNumCilindros());
						data[i][4]=garantias.get(i).getCalentador().getMarca();
						data[i][5]=garantias.get(i).getCliente().getNombre();

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
			btnBuscar.setBounds(1277, 144, 118, 31);
			add(btnBuscar);

			JButton btnTodo = new JButton("Mostrar todo");
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Garantia garantia = new Garantia();

					List<Garantia> garantias = new ArrayList<>();
					
					garantias = serviceGarantia.getGarantia(garantia, "Todo");

					String data[][] = new String[garantias.size()][6];

					for(int i=0; i<garantias.size(); i++) {

						data[i][0]=Conversor.convertirDate(garantias.get(i).getFechaInicio());
						data[i][1]=Conversor.convertirDate(garantias.get(i).getFechaFin());
						data[i][2]=garantias.get(i).getCalentador().getTipo();
						data[i][3]=String.valueOf(garantias.get(i).getCalentador().getNumCilindros());
						data[i][4]=garantias.get(i).getCalentador().getMarca();
						data[i][5]=garantias.get(i).getCliente().getNombre();

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
