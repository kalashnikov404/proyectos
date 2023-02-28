package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import api.ServiceCliente;
import api.ServiceContrato;
import api.ServiceSocio;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Persona;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceContratoImpl;
import servicios.ServiceSocioImpl;
import servicios.ServiceTransporteImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarContrato extends JPanel {

	private JTextField tfTipo;
	private JTextField tfFechaInicial;
	private JTextField tfFechaFinal;



	private Contrato newContrato;

	private Contrato oldContrato;




	private ServiceContrato serviceContrato;
	private JTextField tfSueldo;
	private JTextField tfPuesto;


	public ModificarContrato(String usuario) {

		if(usuario.equals("dueño")) {

			try {
				serviceContrato = new ServiceContratoImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Modificar Contrato");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel labelContrato = new JLabel("Contrato:");
				labelContrato.setBounds(18, 149, 61, 16);
				add(labelContrato);

				List<String> con = new ArrayList<>();
				con=serviceContrato.getListaContratos();

				String[] contratos = Conversor.getArrayDeList(con);

				JComboBox cbContratos = new JComboBox(contratos);
				cbContratos.setBounds(84, 144, 900, 27);
				cbContratos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo = cbContratos.getSelectedItem().toString();
						String[] partes = todo.split(", ");

						tfTipo.setText(partes[0]);
						tfFechaInicial.setText(partes[1]);
						tfFechaFinal.setText(partes[2]);
						tfSueldo.setText(partes[3]);
						tfPuesto.setText(partes[4]);




						oldContrato = new Contrato(partes[0] , partes[1], partes[2],partes[3] ,partes[4] );



					}
				});
				add(cbContratos);

				JLabel labelTipo= new JLabel("Tipo:");
				labelTipo.setBounds(599, 233, 88, 16);
				add(labelTipo);




				JLabel labelFechaInicial = new JLabel("Fecha inicial:");
				labelFechaInicial.setBounds(599, 288, 88, 16);
				add(labelFechaInicial);



				JLabel labelFechaFinal = new JLabel("Fecha final:");
				labelFechaFinal.setBounds(599, 343, 88, 16);
				add(labelFechaFinal);




				tfTipo = new JTextField();
				tfTipo.setBounds(747, 228, 160, 26);
				add(tfTipo);
				tfTipo.setColumns(10);



				tfFechaInicial = new JTextField();
				tfFechaInicial.setBounds(747, 283, 160, 26);
				add(tfFechaInicial);
				tfFechaInicial.setColumns(10);


				tfFechaFinal = new JTextField();
				tfFechaFinal.setBounds(747, 338, 160, 26);
				add(tfFechaFinal);
				tfFechaFinal.setColumns(10);

				JLabel labelSueldo = new JLabel("Sueldo:");
				labelSueldo.setBounds(599, 389, 88, 16);
				add(labelSueldo);

				JLabel labelPuesto = new JLabel("Puesto:");
				labelPuesto.setBounds(599, 442, 88, 16);
				add(labelPuesto);

				tfSueldo = new JTextField();
				tfSueldo.setColumns(10);
				tfSueldo.setBounds(747, 384, 160, 26);
				add(tfSueldo);

				tfPuesto = new JTextField();
				tfPuesto.setColumns(10);
				tfPuesto.setBounds(747, 437, 160, 26);
				add(tfPuesto);


				JButton btnModificar = new JButton("Modificar contrato");
				btnModificar.setBounds(1212, 609, 185, 71);

				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newContrato = new Contrato(tfTipo.getText(),tfFechaInicial.getText(), tfFechaFinal.getText() 
								,tfSueldo.getText(), tfPuesto.getText());

						if(oldContrato==null) {
							JOptionPane.showMessageDialog(null, "Error. Selecciona un contrato para modificar");
						}else {


						String salida = serviceContrato.modificarContrato(newContrato, oldContrato);

						if(salida.equals("Contrato modificado")) {

							tfTipo.setText(null);
							tfFechaInicial.setText(null);
							tfFechaFinal.setText(null);
							tfSueldo.setText(null);
							tfPuesto.setText(null);
							JOptionPane.showMessageDialog(null, salida);
						}else {
							JOptionPane.showMessageDialog(null, "Algo salio mal, revisa los datos ingresados");
						}
						}

					}
				});
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