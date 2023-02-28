package vistas;

import java.awt.Color;
import java.awt.Font;

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

import api.ServiceCliente;
import api.ServiceContrato;
import api.ServiceTransporte;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Transporte;
import servicios.ServiceClienteImpl;
import servicios.ServiceContratoImpl;
import servicios.ServiceTransporteImpl;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ConsultarContrato extends JPanel {




	private JTable table;
	private ButtonGroup opciones;

	private ServiceContrato serviceContrato;


	public ConsultarContrato(String usuario) {

		if(usuario.equals("dueño")) {

			try {

				serviceContrato = new ServiceContratoImpl();

				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);
				setLayout(null);


				JLabel lblTitulo = new JLabel("Consultar Contratos");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);




				final	JComboBox comboTipo = new JComboBox();
				comboTipo.setBounds(110, 68, 170, 26);
				comboTipo.addItem("Seleccione una opcion");


				ArrayList<String> lista3 = new ArrayList<String>();
				lista3 = serviceContrato.llenar_comboTipo();
				for(int i = 0; i<lista3.size();i++){

					comboTipo.addItem(lista3.get(i));
				}


				add(comboTipo);	

				//
				//		String variable = (String) comboNombre.getSelectedItem();
				////			int variable = (int) jComboBox1.getSelectedItem();
				//			


				final	JComboBox comboSueldo = new JComboBox();
				comboSueldo.setBounds(110, 128, 234, 26);
				comboSueldo.addItem("Seleccione una opcion");


				ArrayList<String> lista4 = new ArrayList<String>();
				lista4 = serviceContrato.llenar_comboSueldo();
				for(int i = 0; i<lista4.size();i++){

					comboSueldo.addItem(lista4.get(i));
				}


				add(comboSueldo);	






				final	JComboBox comboFechaInicial = new JComboBox();
				comboFechaInicial.setBounds(583, 68, 211, 26);
				comboFechaInicial.addItem("Seleccione una opcion");


				ArrayList<String> lista5 = new ArrayList<String>();
				lista5 = serviceContrato.llenar_comboFechaInicial();
				for(int i = 0; i<lista5.size();i++){

					comboFechaInicial.addItem(lista5.get(i));
				}


				add(comboFechaInicial);	



				final	JComboBox comboPuesto = new JComboBox();
				comboPuesto.setBounds(536, 128, 270, 26);
				comboPuesto.addItem("Seleccione una opcion");


				ArrayList<String> lista6 = new ArrayList<String>();
				lista6 = serviceContrato.llenar_comboPuesto();
				for(int i = 0; i<lista6.size();i++){

					comboPuesto.addItem(lista6.get(i));
				}


				add(comboPuesto);	




				JRadioButton rbTipo = new JRadioButton("Tipo");
				rbTipo.setBounds(23, 70, 80, 23);
				add(rbTipo);

				JRadioButton rbSueldo = new JRadioButton("Sueldo");
				rbSueldo.setBounds(23, 129, 80, 23);
				add(rbSueldo);



				JRadioButton rbFechaInicial = new JRadioButton("Fecha inicial");
				rbFechaInicial.setBounds(443, 68, 142, 23);
				add(rbFechaInicial);


				JRadioButton rbPuesto = new JRadioButton("Puesto");
				rbPuesto.setBounds(444, 128, 80, 23);
				add(rbPuesto);



				JRadioButton rbFechaFinal = new JRadioButton("Fecha final");
				rbFechaFinal.setBounds(951, 68, 102, 23);
				add(rbFechaFinal);

				final JComboBox comboFechaFinal = new JComboBox();
				comboFechaFinal.setBounds(1052, 68, 215, 26);
				comboFechaFinal.addItem("Seleccione una opcion");


				ArrayList<String> lista9= new ArrayList<String>();
				lista9 = serviceContrato.llenar_comboFechaFin();
				for(int i = 0; i<lista9.size();i++){

					comboFechaFinal.addItem(lista9.get(i));
				}

				add(comboFechaFinal);

				JRadioButton rbRfc = new JRadioButton("RFC");
				rbRfc.setBounds(878, 128, 80, 23);
				add(rbRfc);

				JComboBox comboRfc = new JComboBox();
				comboRfc.setBounds(956, 128, 311, 26);
				comboRfc.addItem("Seleccione una opcion");

				ArrayList<String> lista10= new ArrayList<String>();
				lista10 = serviceContrato.llenar_comboEmpleado();
				for(int i = 0; i<lista10.size();i++){

					comboRfc.addItem(lista10.get(i));
				}

				add(comboRfc);



				table = new JTable();
				table.setBounds(1, 1, 0, 0);
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Tipo", "Fecha inicial", "Fecha final", "Sueldo", "Puesto", "RFC"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);




				opciones = new ButtonGroup();

				opciones.add(rbTipo);
				opciones.add(rbSueldo);
				opciones.add(rbFechaInicial);
				opciones.add(rbFechaFinal);


				opciones.add(rbPuesto);
				opciones.add(rbSueldo);
				opciones.add(rbRfc);



				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(1310, 167, 117, 29);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Contrato contrato = new Contrato();

						String variable = (String) comboTipo.getSelectedItem();
						String variable2 = (String) comboSueldo.getSelectedItem();
						String variable3 = (String) comboFechaInicial.getSelectedItem();
						String variable4 = (String) comboFechaFinal.getSelectedItem();
						String variable5 = (String) comboPuesto.getSelectedItem();
						String variable6 = (String) comboRfc.getSelectedItem();




						List<Contrato> contratos = new ArrayList<>();

						if(rbTipo.isSelected()) {
							contrato.setTipo(variable);
							contratos=serviceContrato.getContratos(contrato, rbTipo.getText());


						}

						if(rbFechaInicial.isSelected()) {
							contrato.setFechaI(variable3);
							contratos=serviceContrato.getContratos(contrato, rbFechaInicial.getText());

						}
						if(rbFechaFinal.isSelected()) {
							contrato.setFechaF(variable4);
							contratos=serviceContrato.getContratos(contrato, rbFechaFinal.getText());

						}
						if(rbSueldo.isSelected()) {
							contrato.setSueldo(variable2);
							contratos=serviceContrato.getContratos(contrato, rbSueldo.getText());

						}
						if(rbPuesto.isSelected()) {
							contrato.setPuesto(variable5);
							contratos=serviceContrato.getContratos(contrato, rbPuesto.getText());

						}
						if(rbRfc.isSelected()) {
							contrato.setRfc(variable6);
							contratos=serviceContrato.getContratos(contrato, rbRfc.getText());

						}


						String data[][] = new String[contratos.size()][6];

						for(int i=0; i<contratos.size(); i++) {

							data[i][0]=contratos.get(i).getTipo();
							data[i][1]=contratos.get(i).getFechaI();
							data[i][2]=contratos.get(i).getFechaF();
							data[i][3]=contratos.get(i).getSueldo();
							data[i][4]=contratos.get(i).getPuesto();
							data[i][5]=contratos.get(i).getRfc();


						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
						table.getColumnModel().getColumn(5).setPreferredWidth(200);


					}
				});
				add(btnBuscar);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(23, 196, 1404, 455);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

				JButton btnTodo = new JButton("Mostrar todo");
				btnTodo.setBounds(1226, 654, 185, 71);
				btnTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Contrato contrato = new Contrato();

						List<Contrato> contratos = new ArrayList<>();

						contratos=serviceContrato.getContratos(contrato, "Todo");

						String data[][] = new String[contratos.size()][6];

						for(int i=0; i<contratos.size(); i++) {
							data[i][0]=contratos.get(i).getTipo();
							data[i][1]=contratos.get(i).getFechaI();
							data[i][2]=contratos.get(i).getFechaF();
							data[i][3]=contratos.get(i).getSueldo();
							data[i][4]=contratos.get(i).getPuesto();
							data[i][5]=contratos.get(i).getRfc();
						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(300);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
						table.getColumnModel().getColumn(5).setPreferredWidth(200);
					}
				});
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

