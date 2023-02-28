package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class RegistrarTrabajo extends JPanel {

	private JTextField tfNuevoTipo;
	private ButtonGroup opciones;
	private ButtonGroup opcionesSN;
	private ServiceTransporte serviceTransporte;
	private ServiceEmpleado serviceEmpleado;
	private ServiceTrabajo serviceTrabajo;

	public RegistrarTrabajo(String usuario) {

		if(usuario.equals("empleado")) {

			try {
				serviceTransporte = new ServiceTransporteImpl();
				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceTrabajo = new ServiceTrabajoImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Registrar Trabajo");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(379, 114, 61, 16);
				add(lblTipo);

				JLabel lblEmpleado = new JLabel("Emplado:");
				lblEmpleado.setBounds(379, 263, 85, 16);
				add(lblEmpleado);

				tfNuevoTipo = new JTextField();
				tfNuevoTipo.setBounds(578, 181, 213, 26);
				add(tfNuevoTipo);
				tfNuevoTipo.setColumns(10);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(578, 259, 856, 27);
				add(cbEmpleado);

				List<String> tra = new ArrayList<>();
				tra=serviceTransporte.getListaTransportes();

				String[] transportes = Conversor.getArrayDeList(tra);

				JComboBox cbTransporte = new JComboBox(transportes);
				cbTransporte.setBounds(578, 398, 213, 27);
				add(cbTransporte);

				List<String> tip = new ArrayList<>();
				tip=serviceTrabajo.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);

				JComboBox cbTipo = new JComboBox(tipos);
				cbTipo.setBounds(578, 110, 213, 27);
				add(cbTipo);

				JRadioButton rbNuevoTipo = new JRadioButton("Agregar nuevo tipo");
				rbNuevoTipo.setBounds(379, 182, 161, 23);
				add(rbNuevoTipo);

				opciones = new ButtonGroup();
				opciones.add(rbNuevoTipo);

				JLabel lblPregunta = new JLabel("¿Hizo uso de un trasporte?");
				lblPregunta.setBounds(379, 356, 213, 16);
				add(lblPregunta);

				JRadioButton rbSi = new JRadioButton("Sí ¿Cuál?");
				rbSi.setBounds(379, 398, 141, 23);
				add(rbSi);

				JRadioButton rbNo = new JRadioButton("No");
				rbNo.setBounds(379, 450, 141, 23);
				add(rbNo);

				opcionesSN = new ButtonGroup();
				opcionesSN.add(rbSi);
				opcionesSN.add(rbNo);

				JButton btnRegistrar = new JButton("Registrar Trabajo");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Trabajo trabajo = new Trabajo();

						if(rbNuevoTipo.isSelected()) {
							trabajo.setTipo(tfNuevoTipo.getText());
						}else {
							trabajo.setTipo(cbTipo.getSelectedItem().toString());
						}

						String ahora = Conversor.convertirTiempoSistema();

						String[] partes = ahora.split(" ");

						trabajo.setHora(Time.valueOf(partes[1]));
						trabajo.setFecha(Date.valueOf(partes[0]));

						Empleado empleado = new Empleado();

						String todoEmpleado = cbEmpleado.getSelectedItem().toString();

						String[] partesEmpleado = todoEmpleado.split(", ");

						empleado.setRfc(partesEmpleado[3]);

						if(rbNo.isSelected()) {
							trabajo.setTransporte(null);
						}else {
							Transporte transporte = new Transporte();

							String todoTransporte = cbTransporte.getSelectedItem().toString();

							String[] partesTransporte = todoTransporte.split(", ");

							transporte.setPlacas(partesTransporte[0]);
							transporte.setTipo(partesTransporte[1]);
							trabajo.setTransporte(transporte);


						}

						trabajo.setEmpleado(empleado);

						String salida = serviceTrabajo.registrarTrabajo(trabajo);

						if(salida.equals("Trabajo registrado")) {
						 tfNuevoTipo.setText(null);

							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal. Revisa los datos ingresados");
						}

					}
				});
				btnRegistrar.setBounds(1212, 609, 185, 71);
				add(btnRegistrar);

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
