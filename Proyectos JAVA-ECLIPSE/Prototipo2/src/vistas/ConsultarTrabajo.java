package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceEmpleado;
import api.ServiceTrabajo;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Trabajo;
import modelo.Transporte;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceTrabajoImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class ConsultarTrabajo extends JPanel {

	private JTable table;
	private ServiceTrabajo serviceTrabajo;
	private ServiceEmpleado serviceEmpleado;
	private ServiceTransporte serviceTransporte;
	private ButtonGroup opciones;
	private JButton btnBuscar;
	private JButton btnTodo;

	public ConsultarTrabajo(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
				serviceTrabajo = new ServiceTrabajoImpl();
				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceTransporte = new ServiceTransporteImpl();


				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Consultar Trabajo");
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
				String nombreColunas[] = {"Tipo", "Hora", "Fecha", "RFC", "Placas"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(133, 66, 862, 27);
				add(cbEmpleado);

				JDateChooser dcFecha = new JDateChooser();
				dcFecha.setBounds(106, 130, 130, 26);
				add(dcFecha);

				JSpinner tsHora = new JSpinner( new SpinnerDateModel() );
				tsHora.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsHora = new JSpinner.DateEditor(tsHora, "HH:mm:ss");
				tsHora.setEditor(de_tsHora);
				tsHora.setValue(new Date());
				tsHora.setBounds(382, 123, 104, 31);
				tsHora.setVisible(true);
				add(tsHora);

				List<String> tip = new ArrayList<>();
				tip=serviceTrabajo.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);

				JComboBox cbTipo = new JComboBox(tipos);
				cbTipo.setBounds(1039, 129, 254, 27);
				add(cbTipo);

				JRadioButton rbTipo = new JRadioButton("Tipo");
				rbTipo.setBounds(975, 129, 62, 23);
				add(rbTipo);

				JRadioButton rbFecha = new JRadioButton("Fecha");
				rbFecha.setBounds(23, 133, 141, 23);
				add(rbFecha);

				JRadioButton rbEmpleado = new JRadioButton("Empleado");
				rbEmpleado.setBounds(23, 66, 141, 23);
				add(rbEmpleado);

				JRadioButton rbTransporte = new JRadioButton("Transporte");
				rbTransporte.setBounds(546, 130, 141, 23);
				add(rbTransporte);

				JRadioButton rbHora = new JRadioButton("Hora");
				rbHora.setBounds(308, 129, 62, 23);
				add(rbHora);

				List<String> tra = new ArrayList<>();
				tra=serviceTransporte.getListaTransportes();

				String[] transportes = Conversor.getArrayDeList(tra);

				JComboBox cbTransporte = new JComboBox(transportes);
				cbTransporte.setBounds(657, 129, 239, 27);
				add(cbTransporte);

				opciones = new ButtonGroup();
				opciones.add(rbTipo);
				opciones.add(rbFecha);
				opciones.add(rbHora);
				opciones.add(rbEmpleado);
				opciones.add(rbTransporte);

				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Trabajo trabajo = new Trabajo();

						List<Trabajo> trabajos = new ArrayList<>();

						if(rbTipo.isSelected()) {

							String tipo = cbTipo.getSelectedItem().toString();
							trabajo.setTipo(tipo);
							trabajos = serviceTrabajo.getTrabajo(trabajo, rbTipo.getText());

						}
						if(rbFecha.isSelected()) {

							trabajo.setFecha(dcFecha.getDate());;
							trabajos = serviceTrabajo.getTrabajo(trabajo, rbFecha.getText());

						}
						if(rbHora.isSelected()) {

							trabajo.setHora(Conversor.convertirHora(tsHora.getValue().toString()));
							trabajos = serviceTrabajo.getTrabajo(trabajo, rbHora.getText());

						}
						if(rbTransporte.isSelected()) {

							String todo = cbTransporte.getSelectedItem().toString();

							String[] partes = todo.split(", ");

							Transporte transporte = new Transporte();

							transporte.setPlacas(partes[0]);

							trabajo.setTransporte(transporte);
							trabajos = serviceTrabajo.getTrabajo(trabajo, rbTransporte.getText());

						}
						if(rbEmpleado.isSelected()) {

							String todo = cbEmpleado.getSelectedItem().toString();

							String[] partes = todo.split(", ");

							Empleado empleado = new Empleado();
							empleado.setRfc(partes[3]);

							trabajo.setEmpleado(empleado);;
							trabajos = serviceTrabajo.getTrabajo(trabajo, rbEmpleado.getText());

						}

						eliminar(table);

						String data[][] = new String[trabajos.size()][5];

						for(int i=0; i<trabajos.size(); i++) {

							data[i][0]=trabajos.get(i).getTipo();
							data[i][1]=trabajos.get(i).getHora().toString();
							data[i][2]=Conversor.convertirDate(trabajos.get(i).getFecha());
							data[i][3]=trabajos.get(i).getEmpleado().getRfc();
							data[i][4]=trabajos.get(i).getTransporte().getPlacas();


						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
					}
				});
				btnBuscar.setBounds(1304, 157, 117, 29);
				add(btnBuscar);

				btnTodo = new JButton("Mostrar todo");
				btnTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						eliminar(table);
						repaint();

						Trabajo trabajo = new Trabajo();

						List<Trabajo> trabajos = new ArrayList<>();

						trabajos = serviceTrabajo.getTrabajo(trabajo, "Todo");


						System.out.println("mostrar de nuevo");
						String data[][] = new String[trabajos.size()][5];

						for(int i=0; i<trabajos.size(); i++) {

							data[i][0]=trabajos.get(i).getTipo();
							data[i][1]=trabajos.get(i).getHora().toString();
							data[i][2]=Conversor.convertirDate(trabajos.get(i).getFecha());
							data[i][3]=trabajos.get(i).getEmpleado().getRfc();
							data[i][4]=trabajos.get(i).getTransporte().getPlacas();


						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
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

	public void eliminar(javax.swing.JTable Tabla){
		System.out.println("eliminar");
		DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
		while(modelo.getRowCount()>0)modelo.removeRow(0);

		TableColumnModel modCol = Tabla.getColumnModel();
		while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
	}


}
