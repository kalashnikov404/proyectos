package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import api.ServiceCliente;
import api.ServiceEmpleado;
import api.ServiceHorario;
import api.ServiceTrabajo;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Horario;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceHorarioImpl;
import servicios.ServiceTrabajoImpl;
import servicios.ServiceTransporteImpl;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class ModificarHorario extends JPanel {

	private Horario newHorario = new Horario();
	private Horario oldHorario = new Horario();

	private ServiceHorario serviceHorario;
	private ServiceEmpleado serviceEmpleado;
	private ServiceTrabajo serviceTrabajo;

	public ModificarHorario(String usuario) {

		if(usuario.equals("due�o")) {

			try {
				serviceTrabajo = new ServiceTrabajoImpl();
				serviceHorario = new ServiceHorarioImpl();
				serviceEmpleado = new ServiceEmpleadoImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Modificar Horario");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(18, 149, 72, 16);
				add(lblHorario);

				JLabel lblFecha= new JLabel("Fecha de asignación:");
				lblFecha.setBounds(352, 248, 152, 16);
				add(lblFecha);

				JLabel lblDia = new JLabel("Día:");
				lblDia.setBounds(355, 293, 61, 16);
				add(lblDia);

				JLabel lblHrEntrada = new JLabel("Hora entrada:");
				lblHrEntrada.setBounds(352, 348, 114, 16);
				add(lblHrEntrada);

				JLabel lblHrSalida = new JLabel("Hora salida:");
				lblHrSalida.setBounds(352, 408, 99, 16);
				add(lblHrSalida);

				JDateChooser dcFechaAsignacion = new JDateChooser();
				dcFechaAsignacion.setBounds(549, 238, 130, 26);
				add(dcFechaAsignacion);

				JSpinner tsHrEntrada = new JSpinner( new SpinnerDateModel() );
				tsHrEntrada.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsHrEntrada = new JSpinner.DateEditor(tsHrEntrada, "HH:mm:ss");
				tsHrEntrada.setEditor(de_tsHrEntrada);
				tsHrEntrada.setValue(new Date());
				tsHrEntrada.setBounds(549, 338, 104, 31);
				tsHrEntrada.setVisible(true);
				add(tsHrEntrada);

				JSpinner tsHrSalida = new JSpinner( new SpinnerDateModel() );
				tsHrSalida.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsHrSalida = new JSpinner.DateEditor(tsHrSalida, "HH:mm:ss");
				tsHrSalida.setEditor(de_tsHrSalida);
				tsHrSalida.setValue(new Date());
				tsHrSalida.setBounds(549, 398, 104, 31);
				tsHrSalida.setVisible(true);
				add(tsHrSalida);

				JLabel lblEmpleado = new JLabel("Empleado:");
				lblEmpleado.setBounds(352, 471, 99, 16);
				add(lblEmpleado);

				List<String> di = new ArrayList<>();
				di = Conversor.getListaDias();

				String[] dias = Conversor.getArrayDeList(di);

				JComboBox cbDia = new JComboBox(dias);
				cbDia.setBounds(549, 289, 202, 27);
				add(cbDia);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(549, 467, 867, 27);
				add(cbEmpleado);

				List<String> hor = new ArrayList<>();
				hor=serviceHorario.getListaHorarios();

				String[] horarios = Conversor.getArrayDeList(hor);

				JComboBox cbHorario = new JComboBox(horarios);
				cbHorario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo = cbHorario.getSelectedItem().toString();

						String[] partes = todo.split(", ");

						Date d = Conversor.convertirADate(partes[0]); 

						dcFechaAsignacion.setDate(d);

						cbDia.setSelectedItem(partes[1]);

						tsHrEntrada.setValue(Time.valueOf(partes[2]));

						tsHrSalida.setValue(Time.valueOf(partes[3]));

						String empleado1 = serviceTrabajo.getEmpleadoCB(partes[4]);

						cbEmpleado.setSelectedItem(empleado1);


						oldHorario.setFechaAsignacion(dcFechaAsignacion.getDate());
						oldHorario.setDia(cbDia.getSelectedItem().toString());
						oldHorario.setHrEntrada(Conversor.convertirHora(tsHrEntrada.getValue().toString()));
						oldHorario.setHrSalida(Conversor.convertirHora(tsHrSalida.getValue().toString()));

						String todoEmpleado = cbEmpleado.getSelectedItem().toString();

						String[] partesEmpleado = todoEmpleado.split(", ");

						oldHorario.setRfc(partesEmpleado[3]);

					}
				});
				cbHorario.setBounds(91, 145, 336, 27);
				add(cbHorario);

				JButton btnModificar = new JButton("Modificar cliente");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newHorario.setFechaAsignacion(dcFechaAsignacion.getDate());
						newHorario.setDia(cbDia.getSelectedItem().toString());
						newHorario.setHrEntrada(Conversor.convertirHora(tsHrEntrada.getValue().toString()));
						newHorario.setHrSalida(Conversor.convertirHora(tsHrSalida.getValue().toString()));

						String todoEmpleado = cbEmpleado.getSelectedItem().toString();

						String[] partesEmpleado = todoEmpleado.split(", ");

						newHorario.setRfc(partesEmpleado[3]);

						String salida = serviceHorario.modificarHorario(newHorario, oldHorario);

						if(salida.equals("Horario modificado")) {
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salió mal. Revisa los datos ingresados");
						}

					}
				});
				btnModificar.setBounds(1212, 609, 185, 71);
				add(btnModificar);

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
