package vistas;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import api.ServiceEmpleado;
import api.ServiceHorario;
import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Horario;
import modelo.Persona;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceHorarioImpl;
import servicios.ServiceProveedorImpl;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class RegistrarEmpleado extends JPanel {
	private JTextField txfNombre;
	private JTextField txfDireccion;
	private JTextField txfTelefono;
	private JTextField txfRFC;
	private JTextField txfCURP;
	private JTextField txfNumSeg;
	private JCheckBox cbLunes;
	private JCheckBox cbMartes;
	private JCheckBox cbMiercoles;
	private JCheckBox cbJueves;
	private JCheckBox cbViernes;
	private JSpinner tsMartesFin;
	private JSpinner tsMartesIni;
	private JSpinner tsViernesFin;
	private JSpinner tsViernesIni;
	private JSpinner tsJuevesFin;
	private JSpinner tsJuevesIni;
	private JSpinner tsMiercolesFin;
	private JSpinner tsMiercolesIni;
	private JSpinner tsLunesFin;
	private JSpinner tsLunesIni;

	private ServiceEmpleado serviceEmpleado;
	private ServiceHorario serviceHorario;

	public RegistrarEmpleado(String usuario) {

		//if(usuario.equals("dueño")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1366, 768);
			setLayout(null);

			try {
				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceHorario=new ServiceHorarioImpl();


				JLabel lblTitulo = new JLabel("Registrar Empleado");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(27, 114, 61, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Direccion:");
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(27, 173, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_3.setBounds(27, 251, 61, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("RFC:");
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_4.setBounds(27, 326, 97, 16);
				add(lblNewLabel_4);

				txfNombre = new JTextField();
				txfNombre.setBounds(180, 109, 335, 26);
				add(txfNombre);
				txfNombre.setColumns(10);

				txfDireccion = new JTextField();
				txfDireccion.setBounds(180, 168, 416, 26);
				add(txfDireccion);
				txfDireccion.setColumns(10);

				txfTelefono = new JTextField();
				txfTelefono.setBounds(180, 246, 199, 26);
				add(txfTelefono);
				txfTelefono.setColumns(10);

				txfRFC = new JTextField();
				txfRFC.setBounds(180, 321, 208, 26);
				add(txfRFC);
				txfRFC.setColumns(10);

				JButton btRegistrarEmpleado = new JButton("Registrar empleado");
				btRegistrarEmpleado.setFont(new Font("Arial", Font.PLAIN, 14));
				btRegistrarEmpleado.setBackground(UIManager.getColor("Button.background"));
				btRegistrarEmpleado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona per=new Persona();
						Empleado emp=new Empleado();
						Conversor c=new Conversor();


						per.setNombre(txfNombre.getText());
						per.setDireccion(txfDireccion.getText());
						per.setTelefono(txfTelefono.getText());
						emp.setRfc(txfRFC.getText());
						emp.setCurp(txfCURP.getText());
						emp.setNumeroSeguro(txfNumSeg.getText());

						String salida = serviceEmpleado.registrarPersona(per);
						String salida2=serviceEmpleado.registrarEmpleado(emp);



						Horario horario = new Horario();


						if(cbLunes.isSelected()) {
							horario.setDia("Lunes");
							horario.setHrEntrada(c.convertirHora(tsLunesIni.getValue().toString()));
							horario.setHrSalida(Conversor.convertirHora(tsLunesFin.getValue().toString()));
							horario.setRfc(txfRFC.getText());
							serviceHorario.registrarHorario(horario);
						}
						if(cbMartes.isSelected()) {
							horario.setDia("Martes");
							horario.setHrEntrada(c.convertirHora(tsMartesIni.getValue().toString()));
							horario.setHrSalida(Conversor.convertirHora(tsMartesFin.getValue().toString()));
							horario.setRfc(txfRFC.getText());
							serviceHorario.registrarHorario(horario);
						}

						if(cbMiercoles.isSelected()) {
							horario.setDia("Miercoles");
							horario.setHrEntrada(c.convertirHora(tsMiercolesIni.getValue().toString()));
							horario.setHrSalida(Conversor.convertirHora(tsMiercolesFin.getValue().toString()));
							horario.setRfc(txfRFC.getText());
							serviceHorario.registrarHorario(horario);
						}

						if(cbJueves.isSelected()) {
							horario.setDia("Jueves");
							horario.setHrEntrada(c.convertirHora(tsJuevesIni.getValue().toString()));
							horario.setHrSalida(Conversor.convertirHora(tsJuevesFin.getValue().toString()));
							horario.setRfc(txfRFC.getText());
							serviceHorario.registrarHorario(horario);
						}

						if(cbViernes.isSelected()) {
							horario.setDia("Viernes");
							horario.setHrEntrada(c.convertirHora(tsViernesIni.getValue().toString()));
							horario.setHrSalida(Conversor.convertirHora(tsViernesFin.getValue().toString()));
							horario.setRfc(txfRFC.getText());
							serviceHorario.registrarHorario(horario);	
						}



						if(salida.equals("Persona registrada")&&salida2.equals("Empleado registrado")) {
						txfNombre.setText(null);
							txfDireccion.setText(null);
						txfTelefono.setText(null);
							txfRFC.setText(null);
							txfCURP.setText(null);
							txfNumSeg.setText(null);
							JOptionPane.showMessageDialog(null, salida2);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}

					}
				});
				btRegistrarEmpleado.setBounds(1212, 609, 185, 71);
				add(btRegistrarEmpleado);

				JLabel lblNewLabel_5 = new JLabel("CURP:");
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_5.setBounds(27, 393, 61, 16);
				add(lblNewLabel_5);

				JLabel lblNewLabel_6 = new JLabel("Numero de Seguro:");
				lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 13));
				lblNewLabel_6.setBounds(27, 459, 130, 16);
				add(lblNewLabel_6);

				txfCURP = new JTextField();
				txfCURP.setBounds(180, 388, 208, 26);
				add(txfCURP);
				txfCURP.setColumns(10);

				txfNumSeg = new JTextField();
				txfNumSeg.setBounds(180, 454, 208, 26);
				add(txfNumSeg);
				txfNumSeg.setColumns(10);

				tsMartesFin = new JSpinner( new SpinnerDateModel() );
				tsMartesFin.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsMartesFin = new JSpinner.DateEditor(tsMartesFin, "HH:mm:ss");
				tsMartesFin.setEditor(de_tsMartesFin);
				tsMartesFin.setValue(new Date());
				tsMartesFin.setBounds(1041, 163, 104, 31);
				tsMartesFin.setVisible(true);
				add(tsMartesFin);

				tsMartesIni = new JSpinner( new SpinnerDateModel() );
				tsMartesIni.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsMartesIni = new JSpinner.DateEditor(tsMartesIni, "HH:mm:ss");
				tsMartesIni.setEditor(de_tsMartesIni);
				tsMartesIni.setValue(new Date());
				tsMartesIni.setBounds(792, 163, 104, 31);
				tsMartesIni.setVisible(true);
				add(tsMartesIni);

				tsViernesFin = new JSpinner( new SpinnerDateModel() );
				tsViernesFin.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsViernesFin = new JSpinner.DateEditor(tsViernesFin, "HH:mm:ss");
				tsViernesFin.setEditor(de_tsViernesFin);
				tsViernesFin.setValue(new Date());
				tsViernesFin.setBounds(1041, 383, 104, 31);
				tsViernesFin.setVisible(true);
				add(tsViernesFin);

				tsViernesIni = new JSpinner( new SpinnerDateModel() );
				tsViernesIni.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsViernesIni = new JSpinner.DateEditor(tsViernesIni, "HH:mm:ss");
				tsViernesIni.setEditor(de_tsViernesIni);
				tsViernesIni.setValue(new Date());
				tsViernesIni.setBounds(792, 383, 104, 31);
				tsViernesIni.setVisible(true);
				add(tsViernesIni);

				tsJuevesFin = new JSpinner( new SpinnerDateModel() );
				tsJuevesFin.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsJuevesFin = new JSpinner.DateEditor(tsJuevesFin, "HH:mm:ss");
				tsJuevesFin.setEditor(de_tsJuevesFin);
				tsJuevesFin.setValue(new Date());
				tsJuevesFin.setBounds(1041, 316, 104, 31);
				tsJuevesFin.setVisible(true);
				add(tsJuevesFin);

				tsJuevesIni = new JSpinner( new SpinnerDateModel() );
				tsJuevesIni.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsJuevesIni = new JSpinner.DateEditor(tsJuevesIni, "HH:mm:ss");
				tsJuevesIni.setEditor(de_tsJuevesIni);
				tsJuevesIni.setValue(new Date());
				tsJuevesIni.setBounds(792, 316, 104, 31);
				tsJuevesIni.setVisible(true);
				add(tsJuevesIni);

				tsMiercolesFin = new JSpinner( new SpinnerDateModel() );
				tsMiercolesFin.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsMiercolesFin = new JSpinner.DateEditor(tsMiercolesFin, "HH:mm:ss");
				tsMiercolesFin.setEditor(de_tsMiercolesFin);
				tsMiercolesFin.setValue(new Date());
				tsMiercolesFin.setBounds(1041, 241, 104, 31);
				tsMiercolesFin.setVisible(true);
				add(tsMiercolesFin);

				tsMiercolesIni = new JSpinner( new SpinnerDateModel() );
				tsMiercolesIni.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsMiercolesIni = new JSpinner.DateEditor(tsMiercolesIni, "HH:mm:ss");
				tsMiercolesIni.setEditor(de_tsMiercolesIni);
				tsMiercolesIni.setValue(new Date());
				tsMiercolesIni.setBounds(792, 241, 104, 31);
				tsMiercolesIni.setVisible(true);
				add(tsMiercolesIni);

				tsLunesFin = new JSpinner( new SpinnerDateModel() );
				tsLunesFin.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsLunesFin = new JSpinner.DateEditor(tsLunesFin, "HH:mm:ss");
				tsLunesFin.setEditor(de_tsLunesFin);
				tsLunesFin.setValue(new Date());
				tsLunesFin.setBounds(1041, 91, 104, 31);
				tsLunesFin.setVisible(true);
				add(tsLunesFin);

				tsLunesIni = new JSpinner( new SpinnerDateModel() );
				tsLunesIni.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsLunesIni = new JSpinner.DateEditor(tsLunesIni, "HH:mm:ss");
				tsLunesIni.setEditor(de_tsLunesIni);
				tsLunesIni.setValue(new Date());
				tsLunesIni.setBounds(792, 91, 104, 31);
				tsLunesIni.setVisible(true);
				add(tsLunesIni);

				JLabel lblNewLabel_81 = new JLabel("a:");
				lblNewLabel_81.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_81.setBounds(951, 168, 61, 16);
				add(lblNewLabel_81);

				JLabel lblNewLabel_82 = new JLabel("a:");
				lblNewLabel_82.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_82.setBounds(951, 252, 61, 16);
				add(lblNewLabel_82);

				JLabel lblNewLabel_83 = new JLabel("a:");
				lblNewLabel_83.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_83.setBounds(951, 327, 61, 16);
				add(lblNewLabel_83);

				JLabel lblNewLabel_84 = new JLabel("a:");
				lblNewLabel_84.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_84.setBounds(951, 394, 61, 16);
				add(lblNewLabel_84);

				JLabel lblNewLabel_85 = new JLabel("a:");
				lblNewLabel_85.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_85.setBounds(951, 102, 61, 16);
				add(lblNewLabel_85);

				cbLunes = new JCheckBox("Lunes de:");
				cbLunes.setFont(new Font("Arial", Font.PLAIN, 14));
				cbLunes.setBackground(Color.WHITE);
				cbLunes.setBounds(629, 96, 114, 26);
				add(cbLunes);

				cbMartes = new JCheckBox("Martes de: ");
				cbMartes.setBackground(Color.WHITE);
				cbMartes.setFont(new Font("Arial", Font.PLAIN, 14));
				cbMartes.setBounds(627, 168, 116, 23);
				add(cbMartes);

				cbMiercoles = new JCheckBox("Miercoles de: ");
				cbMiercoles.setFont(new Font("Arial", Font.PLAIN, 14));
				cbMiercoles.setBackground(Color.WHITE);
				cbMiercoles.setBounds(627, 248, 130, 23);
				add(cbMiercoles);

				cbJueves = new JCheckBox("Jueves de:");
				cbJueves.setBackground(Color.WHITE);
				cbJueves.setFont(new Font("Arial", Font.PLAIN, 14));
				cbJueves.setBounds(629, 323, 124, 23);
				add(cbJueves);

				cbViernes = new JCheckBox("Viernes de:");
				cbViernes.setBackground(Color.WHITE);
				cbViernes.setFont(new Font("Arial", Font.PLAIN, 14));
				cbViernes.setBounds(633, 390, 124, 23);
				add(cbViernes);

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

			} catch (ConexionException e1) {
				e1.printStackTrace();
			}

			/*
		}else {
			JOptionPane.showMessageDialog(null, "No puedes ingresar a esta ventana");

			Principal frame = new Principal(usuario);
			frame.setVisible(true);

			setVisible(false);
			removeAll();
			repaint();

		}
		*/

	}
}

