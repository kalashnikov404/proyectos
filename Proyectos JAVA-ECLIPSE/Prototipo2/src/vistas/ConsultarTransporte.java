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

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Transporte;
import servicios.ServiceTransporteImpl;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class ConsultarTransporte extends JPanel {
	private JTable table;
	private ButtonGroup opciones;

	private ServiceTransporte serviceTransporte;


	public ConsultarTransporte(String usuario) {
		
		if(usuario.equals("dueño") || usuario.equals("empleado")) {

		setBackground(new Color(255, 128, 128));
		setBounds(100, 100, 1366, 768);
		setLayout(null);

		try {

			serviceTransporte = new ServiceTransporteImpl();


			JLabel lblTitulo = new JLabel("Consultar Evento");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(64, 128, 128));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			add(lblTitulo);

			table = new JTable();
			table.setForeground(Color.black);
			table.setBackground(new Color(242, 221, 192));
			table.setBounds(23, 197, 799, 364);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"Evento", "Tipo"};
			table.getTableHeader().setOpaque(false);
			table.getTableHeader().setBackground(new Color(229, 78, 50));
			table.getTableHeader().setForeground(Color.white);
			table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
			add(table);


			JRadioButton rbTipo = new JRadioButton("Tipo");
			rbTipo.setBounds(355, 129, 141, 23);
			add(rbTipo);

			JRadioButton rbPlacas = new JRadioButton("Evento");
			rbPlacas.setBounds(23, 129, 141, 23);
			add(rbPlacas);

			opciones = new ButtonGroup();
			opciones.add(rbTipo);
			opciones.add(rbPlacas);

			List<String> pla = new ArrayList<>();
			pla=serviceTransporte.getListaPlacas();

			String[] placas = Conversor.getArrayDeList(pla);

			JComboBox cbPlacas = new JComboBox(placas);
			cbPlacas.setBounds(193, 127, 156, 27);
			add(cbPlacas);

			List<String> tip = new ArrayList<>();
			tip=serviceTransporte.getListaTipos();

			String[] tipos = Conversor.getArrayDeList(tip);

			JComboBox cbTipo = new JComboBox(tipos);
			cbTipo.setBounds(507, 127, 156, 27);
			add(cbTipo);


			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Transporte transporte = new Transporte();

					List<Transporte> transportes = new ArrayList<>();

					if(rbPlacas.isSelected()) {
						
						String placas = cbPlacas.getSelectedItem().toString();
						
						transporte.setPlacas(placas);
						transportes=serviceTransporte.getTransportes(transporte, rbPlacas.getText());
					}
					if(rbTipo.isSelected()) {

						String tipo = cbTipo.getSelectedItem().toString();

						transporte.setTipo(tipo);
						transportes=serviceTransporte.getTransportes(transporte, rbTipo.getText());
					}


					String data[][] = new String[transportes.size()][2];

					for(int i=0; i<transportes.size(); i++) {

						data[i][0]=transportes.get(i).getPlacas();
						data[i][1]=transportes.get(i).getTipo();

					}

					table.setModel(new DefaultTableModel(data, nombreColunas));
					table.getColumnModel().getColumn(0).setPreferredWidth(200);
					table.getColumnModel().getColumn(1).setPreferredWidth(200);


				}
			});
			btnBuscar.setBounds(1195, 145, 118, 31);
			add(btnBuscar);

			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(18, 187, 1404, 402);
			add(scrollPane);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

			JButton btnTodo = new JButton("Mostrar todo");
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Transporte transporte = new Transporte();

					List<Transporte> transportes = new ArrayList<>();

					transportes=serviceTransporte.getTransportes(transporte, "Todo");

					String data[][] = new String[transportes.size()][2];

					for(int i=0; i<transportes.size(); i++) {

						data[i][0]=transportes.get(i).getPlacas();
						data[i][1]=transportes.get(i).getTipo();

					}

					table.setModel(new DefaultTableModel(data, nombreColunas));
					table.getColumnModel().getColumn(0).setPreferredWidth(200);
					table.getColumnModel().getColumn(1).setPreferredWidth(200);

				}
			});
			btnTodo.setBounds(1128, 613, 185, 57);
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
			btnSalir.setBounds(23, 613, 85, 81);
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
