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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceEmpleado;
import api.ServiceHorario;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Horario;
import modelo.Transporte;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceHorarioImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class ConsultarHorario extends JPanel {

	private JTextField tfDia;
	private JTable table;
	private ButtonGroup opciones;

	private ServiceHorario serviceHorario;
	private ServiceEmpleado serviceEmpleado;

	public ConsultarHorario(String usuario) {
		
		if(usuario.equals("due�o") || usuario.equals("empleado")) {

		try {
			serviceHorario = new ServiceHorarioImpl();
			serviceEmpleado = new ServiceEmpleadoImpl();

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);

			JLabel lblTitulo = new JLabel("Consultar Horario");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(58, 131, 29));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			add(lblTitulo);

			tfDia = new JTextField();
			tfDia.setBounds(1074, 127, 130, 26);
			add(tfDia);
			tfDia.setColumns(10);

			table = new JTable();
			table.setForeground(Color.BLACK);
			table.setBackground(new Color(242, 221, 192));
			table.setBounds(23, 197, 799, 364);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"Fecha de Asignación", "Día", "Hora de entrada", "Hora de salida", "RFC del Empleado"};
			table.getTableHeader().setOpaque(false);
			table.getTableHeader().setBackground(new Color(229, 78, 50));
			table.getTableHeader().setForeground(Color.white);
			table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
			add(table);

			JSpinner tsHrEntrada = new JSpinner( new SpinnerDateModel() );
			tsHrEntrada.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
			JSpinner.DateEditor de_tsHrEntrada = new JSpinner.DateEditor(tsHrEntrada, "HH:mm:ss");
			tsHrEntrada.setEditor(de_tsHrEntrada);
			tsHrEntrada.setValue(new Date());
			tsHrEntrada.setBounds(516, 122, 104, 31);
			tsHrEntrada.setVisible(true);
			add(tsHrEntrada);

			JSpinner tsHrSalida = new JSpinner( new SpinnerDateModel() );
			tsHrSalida.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
			JSpinner.DateEditor de_tsHrSalida = new JSpinner.DateEditor(tsHrSalida, "HH:mm:ss");
			tsHrSalida.setEditor(de_tsHrSalida);
			tsHrSalida.setValue(new Date());
			tsHrSalida.setBounds(828, 122, 104, 31);
			tsHrSalida.setVisible(true);
			add(tsHrSalida);

			JDateChooser dcFechaAsignacion = new JDateChooser();
			dcFechaAsignacion.setBounds(182, 127, 130, 26);
			add(dcFechaAsignacion);

			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(18, 187, 1404, 455);
			add(scrollPane);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

			JRadioButton rbFechaAsignacion = new JRadioButton("Fecha de asignación");
			rbFechaAsignacion.setBounds(18, 128, 176, 23);
			add(rbFechaAsignacion);

			JRadioButton rbHrEntrada = new JRadioButton("Hora entrada");
			rbHrEntrada.setBounds(393, 128, 141, 23);
			add(rbHrEntrada);

			JRadioButton rbHrSalida = new JRadioButton("Hora salida");
			rbHrSalida.setBounds(712, 128, 141, 23);
			add(rbHrSalida);

			JRadioButton rbDia = new JRadioButton("Día");
			rbDia.setBounds(1013, 128, 141, 23);
			add(rbDia);
			
			JRadioButton rbEmpleado = new JRadioButton("Empleado");
			rbEmpleado.setBounds(18, 73, 98, 23);
			add(rbEmpleado);
			
			List<String> emp =new ArrayList();
			emp=serviceEmpleado.getListaEmpleado();
			String[] empleado= Conversor.getArrayDeList(emp);

			JComboBox cbEmpleado = new JComboBox(empleado);
			cbEmpleado.setBounds(142, 73, 1062, 27);
			add(cbEmpleado);

			opciones = new ButtonGroup();
			opciones.add(rbFechaAsignacion);
			opciones.add(rbHrEntrada);
			opciones.add(rbHrSalida);
			opciones.add(rbDia);
			opciones.add(rbEmpleado);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Horario horario = new Horario();

					List<Horario> horarios = new ArrayList<>();


					if(rbFechaAsignacion.isSelected()) {
						horario.setFechaAsignacion(dcFechaAsignacion.getDate());
						horarios=serviceHorario.getHorarios(horario, rbFechaAsignacion.getText());
					}

					if(rbHrEntrada.isSelected()) {
						horario.setHrEntrada(Conversor.convertirHora(tsHrEntrada.getValue().toString()));
						horarios=serviceHorario.getHorarios(horario, rbHrEntrada.getText());
					}

					if(rbHrSalida.isSelected()) {
						horario.setHrSalida(Conversor.convertirHora(tsHrSalida.getValue().toString()));
						horarios=serviceHorario.getHorarios(horario, rbHrSalida.getText());
					}

					if(rbDia.isSelected()) {
						horario.setDia(tfDia.getText());
						horarios=serviceHorario.getHorarios(horario, rbDia.getText());
					}
					
					if(rbEmpleado.isSelected()) {
						
						String todo = cbEmpleado.getSelectedItem().toString();
						
						String[] partes = todo.split(", ");
						
						horario.setRfc(partes[3]);
						horarios=serviceHorario.getHorarios(horario, rbEmpleado.getText());
					}


					String data[][] = new String[horarios.size()][5];

					for(int i=0; i<horarios.size(); i++) {

						data[i][0]=Conversor.convertirDate(horarios.get(i).getFechaAsignacion());
						data[i][1]=horarios.get(i).getDia();
						data[i][2]=String.valueOf(horarios.get(i).getHrEntrada());
						data[i][3]=String.valueOf(horarios.get(i).getHrSalida());
						data[i][4]=horarios.get(i).getRfc();

					}

					table.setModel(new DefaultTableModel(data, nombreColunas));
					table.getColumnModel().getColumn(0).setPreferredWidth(200);
					table.getColumnModel().getColumn(1).setPreferredWidth(200);
					table.getColumnModel().getColumn(2).setPreferredWidth(200);
					table.getColumnModel().getColumn(3).setPreferredWidth(200);
					table.getColumnModel().getColumn(4).setPreferredWidth(200);

				}
			});
			btnBuscar.setBounds(1277, 144, 118, 31);
			add(btnBuscar);

			JButton btnTodo = new JButton("Mostrar todo");
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Horario horario = new Horario();

					List<Horario> horarios = new ArrayList<>();

					horarios=serviceHorario.getHorarios(horario, "Todo");


					String data[][] = new String[horarios.size()][5];

					for(int i=0; i<horarios.size(); i++) {

						data[i][0]=Conversor.convertirDate(horarios.get(i).getFechaAsignacion());
						data[i][1]=horarios.get(i).getDia();
						data[i][2]=String.valueOf(horarios.get(i).getHrEntrada());
						data[i][3]=String.valueOf(horarios.get(i).getHrSalida());
						data[i][4]=horarios.get(i).getRfc();

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
}
