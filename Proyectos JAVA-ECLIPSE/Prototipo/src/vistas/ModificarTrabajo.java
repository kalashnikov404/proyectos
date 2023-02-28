package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
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

import api.ServiceEmpleado;
import api.ServiceTrabajo;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Horario;
import modelo.Trabajo;
import modelo.Transporte;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceTrabajoImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class ModificarTrabajo extends JPanel {

	private JTextField tfNuevoTipo;
	private ButtonGroup opciones;
	private ButtonGroup opcionesSN;
	private ButtonGroup opcionesCBSN;
	private ServiceTrabajo serviceTrabajo;
	private ServiceEmpleado serviceEmpleado;
	private ServiceTransporte serviceTranstporte;

	Trabajo newtrabajo = new Trabajo();				
	Trabajo oldtrabajo = new Trabajo();

	public ModificarTrabajo(String usuario) {

		if(usuario.equals("empleado")) {

			try {
				serviceTrabajo = new ServiceTrabajoImpl();
				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceTranstporte = new ServiceTransporteImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Modificar Trabajo");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(533, 280, 61, 16);
				add(lblTipo);

				JLabel lblHora = new JLabel("Hora:");
				lblHora.setBounds(533, 405, 61, 16);
				add(lblHora);

				JLabel lblEmpleado = new JLabel("Empleado:");
				lblEmpleado.setBounds(533, 478, 83, 16);
				add(lblEmpleado);

				tfNuevoTipo = new JTextField();
				tfNuevoTipo.setBounds(732, 333, 130, 26);
				add(tfNuevoTipo);
				tfNuevoTipo.setColumns(10);

				JSpinner tsHora = new JSpinner( new SpinnerDateModel() );
				tsHora.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 19));
				JSpinner.DateEditor de_tsHora = new JSpinner.DateEditor(tsHora, "HH:mm:ss");
				tsHora.setEditor(de_tsHora);
				tsHora.setValue(new Date());
				tsHora.setBounds(732, 395, 104, 31);
				tsHora.setVisible(true);
				add(tsHora);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(732, 474, 254, 27);
				add(cbEmpleado);

				List<String> tra = new ArrayList<>();
				tra=serviceTranstporte.getListaTransportes();

				String[] transportes = Conversor.getArrayDeList(tra);

				JComboBox cbTransporte = new JComboBox(transportes);
				cbTransporte.setBounds(732, 588, 254, 27);
				add(cbTransporte);

				List<String> tip = new ArrayList<>();
				tip=serviceTrabajo.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);

				JComboBox cbTipo = new JComboBox(tipos);
				cbTipo.setBounds(732, 276, 257, 27);
				add(cbTipo);

				JRadioButton rbNuevoTipo = new JRadioButton("Agregar nuevo tipo");
				rbNuevoTipo.setBounds(533, 334, 188, 23);
				add(rbNuevoTipo);

				opciones = new ButtonGroup();
				opciones.add(rbNuevoTipo);

				JLabel lblPregunta = new JLabel("Hizo uso de un transporte?");
				lblPregunta.setBounds(533, 541, 256, 16);
				add(lblPregunta);

				JRadioButton rbSi = new JRadioButton("Si­A¿Cual?");
				rbSi.setBounds(533, 588, 141, 23);
				add(rbSi);

				JRadioButton rbNo = new JRadioButton("No");
				rbNo.setBounds(533, 648, 141, 23);
				add(rbNo);

				opcionesSN = new ButtonGroup();
				opcionesSN.add(rbSi);
				opcionesSN.add(rbNo);

				JRadioButton rbcbCon = new JRadioButton("Trabajos realizados con transporte:");
				rbcbCon.setBounds(18, 145, 315, 23);
				add(rbcbCon);

				JRadioButton rbcbSin = new JRadioButton("Trabajos realizados sin transporte:");
				rbcbSin.setBounds(18, 200, 308, 23);
				add(rbcbSin);

				opcionesCBSN = new ButtonGroup();
				opcionesCBSN.add(rbcbCon);
				opcionesCBSN.add(rbcbSin);

				List<String> con =new ArrayList();
				con=serviceTrabajo.getListaTrabajosConTransporte();
				String[] tracon= Conversor.getArrayDeList(con);

				JComboBox cbCon = new JComboBox(tracon);
				cbCon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo1 = cbCon.getSelectedItem().toString();

						String[] partes1 = todo1.split(", ");

						cbTipo.setSelectedItem(partes1[0]);
						tsHora.setValue(Time.valueOf(partes1[1]));

						String empleado1 = serviceTrabajo.getEmpleadoCB(partes1[3]);

						cbEmpleado.setSelectedItem(empleado1);

						rbSi.setSelected(true);

						String transporte1 = serviceTrabajo.getTransporteCB(partes1[4]);

						cbTransporte.setSelectedItem(transporte1);



						///old trabajo


						String todo = cbCon.getSelectedItem().toString();

						String[] partes = todo.split(", ");



						oldtrabajo.setTipo(partes[0]);
						oldtrabajo.setHora(Time.valueOf(partes[1]));
						oldtrabajo.setFecha(Conversor.convertirADate((partes[2])));

						Empleado empleado = new Empleado();
						empleado.setRfc(partes[3]);

						Transporte transporte = new Transporte();

						String todoTransporte1 = cbTransporte.getSelectedItem().toString();

						String[] partesTransporte1 = todoTransporte1.split(", ");

						transporte.setPlacas(partesTransporte1[0]);
						transporte.setTipo(partesTransporte1[1]);

						oldtrabajo.setTransporte(transporte);
						oldtrabajo.setEmpleado(empleado);



					}
				});
				cbCon.setBounds(345, 145, 803, 27);
				add(cbCon);

				List<String> sin =new ArrayList();
				sin=serviceTrabajo.getListaTrabajosSinTransporte();
				String[] trasin= Conversor.getArrayDeList(sin);

				JComboBox cbSin = new JComboBox(trasin);
				cbSin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo1 = cbSin.getSelectedItem().toString();

						String[] partes1 = todo1.split(", ");

						cbTipo.setSelectedItem(partes1[0]);
						tsHora.setValue(Time.valueOf(partes1[1]));

						String empleado1 = serviceTrabajo.getEmpleadoCB(partes1[3]);

						cbEmpleado.setSelectedItem(empleado1);
						rbNo.setSelected(true);




						//oldtrabajo

						String todo = cbSin.getSelectedItem().toString();

						String[] partes = todo.split(", ");

						oldtrabajo.setTipo(partes[0]);
						oldtrabajo.setHora(Time.valueOf(partes[1]));
						oldtrabajo.setFecha(Conversor.convertirADate((partes[2])));

						Empleado empleado = new Empleado();
						empleado.setRfc(partes[3]);

						oldtrabajo.setTransporte(null);
						oldtrabajo.setEmpleado(empleado);

					}
				});
				cbSin.setBounds(345, 200, 803, 27);
				add(cbSin);

				JButton btnModificar = new JButton("Modificar trabajo");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {


						if(rbcbCon.isSelected()) {

							String todo = cbCon.getSelectedItem().toString();

							String[] partes = todo.split(", ");

							if(rbNuevoTipo.isSelected()) {
								newtrabajo.setTipo(tfNuevoTipo.getText());
							}else {
								newtrabajo.setTipo(cbTipo.getSelectedItem().toString());
							}

							newtrabajo.setHora(Conversor.convertirHora(tsHora.getValue().toString()));
							newtrabajo.setFecha(Conversor.convertirADate((partes[2])));

							Empleado newempleado = new Empleado();

							String todoEmpleado = cbEmpleado.getSelectedItem().toString();

							String[] partesEmpleado = todoEmpleado.split(", ");

							newempleado.setRfc(partesEmpleado[3]);

							if(rbNo.isSelected()) {
								newtrabajo.setTransporte(null);
							}else {
								Transporte newtransporte = new Transporte();

								String todoTransporte = cbTransporte.getSelectedItem().toString();

								String[] partesTransporte = todoTransporte.split(", ");

								newtransporte.setPlacas(partesTransporte[0]);
								newtransporte.setTipo(partesTransporte[1]);
								newtrabajo.setTransporte(newtransporte);


							}

							newtrabajo.setEmpleado(newempleado);

						}

						if(rbcbSin.isSelected()) {

							String todo = cbSin.getSelectedItem().toString();

							String[] partes = todo.split(", ");

							if(rbNuevoTipo.isSelected()) {
								newtrabajo.setTipo(tfNuevoTipo.getText());
							}else {
								newtrabajo.setTipo(cbTipo.getSelectedItem().toString());
							}


							newtrabajo.setHora(Conversor.convertirHora(tsHora.getValue().toString()));
							newtrabajo.setFecha(Conversor.convertirADate((partes[2])));

							Empleado newempleado = new Empleado();

							String todoEmpleado = cbEmpleado.getSelectedItem().toString();

							String[] partesEmpleado = todoEmpleado.split(", ");

							newempleado.setRfc(partesEmpleado[3]);

							if(rbNo.isSelected()) {
								newtrabajo.setTransporte(null);
							}else {
								Transporte newtransporte = new Transporte();

								String todoTransporte = cbTransporte.getSelectedItem().toString();

								String[] partesTransporte = todoTransporte.split(", ");

								newtransporte.setPlacas(partesTransporte[0]);
								newtransporte.setTipo(partesTransporte[1]);
								newtrabajo.setTransporte(newtransporte);


							}

							newtrabajo.setEmpleado(newempleado);

						}

						String salida = serviceTrabajo.modificarTrabajo(newtrabajo, oldtrabajo);

						if(salida.equals("Trabajo modificado")) {
							tfNuevoTipo.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal. Revisa los datos ingresados");
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
