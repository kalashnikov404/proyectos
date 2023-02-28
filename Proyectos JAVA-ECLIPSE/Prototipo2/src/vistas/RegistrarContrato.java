package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import api.ServiceCliente;
import api.ServiceContrato;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Contrato;
import servicios.ServiceClienteImpl;
import servicios.ServiceContratoImpl;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistrarContrato extends JPanel {
	private JTextField tfTipo;
	private JTextField tfSueldo;
	private JTextField tfPuesto;
	private ServiceContrato serviceContrato;

	public RegistrarContrato(String usuario) {

		if(usuario.equals("dueño")) {

			try {

				serviceContrato = new ServiceContratoImpl();

				setBackground(new Color(255, 128, 128));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Registrar Contrato");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(64, 128, 128));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblNewLabel_1 = new JLabel("Tipo:");
				lblNewLabel_1.setBounds(598, 114, 97, 16);
				add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Fecha inicio:");
				lblNewLabel_2.setBounds(598, 173, 85, 16);
				add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Fecha fin:");
				lblNewLabel_3.setBounds(598, 251, 97, 16);
				add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Sueldo:");
				lblNewLabel_4.setBounds(598, 319, 97, 16);
				add(lblNewLabel_4);



				final	JComboBox comboEmpleado = new JComboBox();
				comboEmpleado.addItem("Seleccione una opcion");


				ArrayList<String> lista3 = new ArrayList<String>();
				lista3 = serviceContrato.llenar_comboEmpleado();
				for(int i = 0; i<lista3.size();i++){

					comboEmpleado.addItem(lista3.get(i));
				}



				comboEmpleado.setBounds(741, 439, 304, 43);


				add(comboEmpleado);	




				tfTipo = new JTextField();
				tfTipo.setBounds(741, 109, 130, 26);
				add(tfTipo);
				tfTipo.setColumns(10);

				tfSueldo = new JTextField();
				tfSueldo.setBounds(741, 314, 130, 26);
				add(tfSueldo);
				tfSueldo.setColumns(10);

				JLabel lblNewLabel_6 = new JLabel("Empleado:");
				lblNewLabel_6.setBounds(598, 451, 97, 16);
				add(lblNewLabel_6);

				tfPuesto = new JTextField();
				tfPuesto.setBounds(741, 381, 130, 26);
				add(tfPuesto);
				tfPuesto.setColumns(10);

				JDateChooser dcFechaInicio = new JDateChooser();
				dcFechaInicio.setBounds(741, 163, 130, 26);
				dcFechaInicio.setDateFormatString("yyyy-MM-dd");




				add(dcFechaInicio);

				JDateChooser dcFechaFin = new JDateChooser();
				dcFechaFin.setBounds(741, 241, 130, 26);
				dcFechaFin.setDateFormatString("yyyy-MM-dd");



				add(dcFechaFin);



				JButton btnRegistroContrato = new JButton("Registrar contrato");
				btnRegistroContrato.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {



						String variable = (String) comboEmpleado.getSelectedItem();



						String dateString = String.format("%1$tY/%1$tm/%1$td", dcFechaInicio.getDate());
						String dateString2 = String.format("%1$tY/%1$tm/%1$td", dcFechaFin.getDate());

						Contrato contrato = new Contrato();



						contrato.setTipo(tfTipo.getText());

						contrato.setFechaI(dateString);
						contrato.setFechaF(dateString2);

						contrato.setSueldo(tfSueldo.getText());
						contrato.setPuesto(tfPuesto.getText());
						contrato.setRfc(variable);



						String salida= serviceContrato.registrarContrato(contrato);







						if(salida.equals("Contrato registrado")) {
							   tfTipo.setText(null);
								tfSueldo.setText(null);
								tfPuesto.setText(null);
							JOptionPane.showMessageDialog(null, salida);


						}else {	JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
					}
				});
				btnRegistroContrato.setBounds(1127, 609, 185, 71);
				add(btnRegistroContrato);

				JLabel lblNewLabel_5 = new JLabel("Puesto:");
				lblNewLabel_5.setBounds(598, 386, 97, 16);
				add(lblNewLabel_5);



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

