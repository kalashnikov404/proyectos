package vistas;

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

import api.ServiceEmpleado;
import api.ServiceHorario;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Empleado;
import modelo.Horario;
import modelo.Persona;
import modelo.Proveedor;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceHorarioImpl;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JPanel {
	private JTextField txfNombre;
	private JTextField txfTelefono;
	private JTextField txfDireccion;
	private JTextField txfRFC;
	private JTextField txfCURP;
	private JTextField txfNumSeguro;
	private JComboBox cbEmpleado;
	private JCheckBox cbLunes;
	private JCheckBox cbMartes;
	private JCheckBox cbMiercoles;
	private JCheckBox cbJueves;
	private JCheckBox cbViernes;
	private JSpinner tsMartesFin;
	private JSpinner tsMartesIni;
	private JSpinner tsViernesFin;
	private JSpinner tsViernesIni;
	private JSpinner tsJuvesFin;
	private JSpinner tsJuevesIni;
	private JSpinner tsMiercolesFin;
	private JSpinner tsMiercolesIni;
	private JSpinner tsLunesFin;
	private JSpinner tsLunesIni;

	private Persona newPersona;
	private Persona oldPersona;
	private Empleado newEmpleado;
	private Empleado oldEmpleado;
	private Horario oldHorario;
	private Horario newHorario;

	private ServiceEmpleado serviceEmpleado;


	public ModificarEmpleado(String usuario) {

		if(usuario.equals("dueño")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);
			try {
				serviceEmpleado = new ServiceEmpleadoImpl();

				JLabel lblTitulo = new JLabel("Modificar Empleado");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Empleado:");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(80, 143, 75, 16);
				add(lblNewLabel_1);


				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				cbEmpleado = new JComboBox(empleado);
				cbEmpleado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String todo = cbEmpleado.getSelectedItem().toString();
						String[] partes = todo.split(", ");
						txfNombre.setText(partes[0]);
						txfDireccion.setText(partes[1]);
						txfTelefono.setText(partes[2]);
						txfCURP.setText(partes[3]);
						txfRFC.setText(partes[4]);
						txfNumSeguro.setText(partes[5]);

						oldPersona=new Persona(partes[0], partes[1],partes[2]);
						oldEmpleado=new Empleado(partes[3], partes[4],partes[5]);


					}
				});
				cbEmpleado.setBounds(192, 132, 628, 27);
				add(cbEmpleado);

				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(617, 238, 61, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_3.setBounds(617, 277, 61, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Direccion:");
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_4.setBounds(617, 319, 83, 16);
				add(lblNewLabel_4);

				txfNombre = new JTextField();
				txfNombre.setFont(new Font("Arial", Font.PLAIN, 14));
				txfNombre.setBounds(735, 233, 458, 27);
				add(txfNombre);
				txfNombre.setColumns(10);

				txfTelefono = new JTextField();
				txfTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
				txfTelefono.setBounds(735, 272, 203, 27);
				add(txfTelefono);
				txfTelefono.setColumns(10);

				txfDireccion = new JTextField();
				txfDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
				txfDireccion.setBounds(735, 314, 458, 27);
				add(txfDireccion);
				txfDireccion.setColumns(10);

				JButton btMostrarEmpleado = new JButton("Modificar Empleado");
				btMostrarEmpleado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newPersona = new Persona(txfNombre.getText(),txfDireccion.getText(),txfTelefono.getText());
						String salida = serviceEmpleado.modificarPersona(newPersona, oldPersona);

						if(salida.equals("Persona modificada")) {
							txfNombre.setText(null);
							txfDireccion.setText(null);
							txfTelefono.setText(null);
							
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salido mal, revisa los datos ingresados");
						}	

						newEmpleado=new Empleado(txfRFC.getText(),txfCURP.getText(),txfNumSeguro.getText());
						String salida2 = serviceEmpleado.modificarEmpleado(newEmpleado, oldEmpleado);

						if(salida2.equals("Empleado modificado")) {
							txfCURP.setText(null);
							txfRFC.setText(null);
							txfNumSeguro.setText(null);

							JOptionPane.showMessageDialog(null, salida2);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salido mal, revisa los datos ingresados");
						}


					}
				});
				btMostrarEmpleado.setFont(new Font("Arial", Font.PLAIN, 14));
				btMostrarEmpleado.setBounds(1212, 609, 185, 71);
				add(btMostrarEmpleado);

				JLabel lblNewLabel_5 = new JLabel("RFC:");
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_5.setBounds(617, 368, 61, 16);
				add(lblNewLabel_5);

				JLabel lblNewLabel_6 = new JLabel("CURP:");
				lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_6.setBounds(617, 412, 61, 16);
				add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("Numero Seguro:");
				lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_7.setBounds(617, 455, 110, 16);
				add(lblNewLabel_7);

				txfRFC = new JTextField();
				txfRFC.setFont(new Font("Arial", Font.PLAIN, 14));
				txfRFC.setBounds(735, 363, 251, 27);
				add(txfRFC);
				txfRFC.setColumns(10);

				txfCURP = new JTextField();
				txfCURP.setFont(new Font("Arial", Font.PLAIN, 14));
				txfCURP.setBounds(735, 407, 251, 27);
				add(txfCURP);
				txfCURP.setColumns(10);

				txfNumSeguro = new JTextField();
				txfNumSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
				txfNumSeguro.setBounds(735, 450, 251, 26);
				add(txfNumSeguro);
				txfNumSeguro.setColumns(10);

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
