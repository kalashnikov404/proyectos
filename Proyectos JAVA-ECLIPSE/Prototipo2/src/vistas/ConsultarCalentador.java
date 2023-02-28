package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import api.ServiceCalentador;
import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Transporte;
import servicios.ServiceCalentadorImpl;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class ConsultarCalentador extends JPanel {

	private JTable table;
	private int nombreColumnas;
	private ButtonGroup opciones;

	private ServiceCalentador serviceCalentador;

	public ConsultarCalentador(String usuario) {


		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
				serviceCalentador = new ServiceCalentadorImpl();

				setLayout(null);
				setBackground(new Color(255, 128, 128));
				setBounds(100, 100, 1366, 768);

				JLabel lblTitulo = new JLabel("Consultar Medicamentos");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(64, 128, 128));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);


				table = new JTable();
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(255, 128, 128));
				table.setBounds(23, 197, 799, 364);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Tipo", "Cantidad","Dimensiones","Marca", "Precio"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 187, 1404, 385);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				JRadioButton rbTipo = new JRadioButton("Tipo");
				rbTipo.setBounds(23, 83, 130, 23);
				add(rbTipo);

				JRadioButton rbNumeroCilindros = new JRadioButton("Cantidad");
				rbNumeroCilindros.setBounds(23, 129, 143, 23);
				add(rbNumeroCilindros);

				JRadioButton rbDimensiones = new JRadioButton("Gramos");
				rbDimensiones.setBounds(686, 129, 130, 23);
				add(rbDimensiones);

				JRadioButton rbMarca = new JRadioButton("Marca");
				rbMarca.setBounds(377, 129, 73, 23);
				add(rbMarca);

				JRadioButton rbPrecio = new JRadioButton("Precio");
				rbPrecio.setBounds(1051, 129, 73, 23);
				add(rbPrecio);

				List<String> tip = new ArrayList();
				tip=serviceCalentador.getListaTipos();

				String[] tipos = Conversor.getArrayDeList(tip);

				JComboBox cbTipo = new JComboBox(tipos);
				cbTipo.setBounds(178, 82, 153, 24);
				add(cbTipo);

				List<String> numc =new ArrayList<>();
				numc=serviceCalentador.getListaNumeroCilindros();
				String[] numeroCilindros= Conversor.getArrayDeList(numc);

				JComboBox cbNumeroCilindros = new JComboBox(numeroCilindros);
				cbNumeroCilindros.setBounds(178, 130, 153, 24);
				add(cbNumeroCilindros);

				List<String> dim =new ArrayList<>();
				dim=serviceCalentador.getListaDimensiones();
				String[] dimensiones= Conversor.getArrayDeList(dim);

				JComboBox cbDimensiones = new JComboBox(dimensiones);
				cbDimensiones.setBounds(832, 128, 164, 24);
				add(cbDimensiones);

				List<String> mar =new ArrayList<>();
				mar=serviceCalentador.getListaMarca();
				String[] marcas= Conversor.getArrayDeList(mar);

				JComboBox cbMarca = new JComboBox(marcas);
				cbMarca.setBounds(462, 130, 171, 24);
				add(cbMarca);

				List<String> prec =new ArrayList<>();
				prec=serviceCalentador.getListaPrecio();
				String[] precios= Conversor.getArrayDeList(prec);

				JComboBox cbPrecio = new JComboBox(precios);
				cbPrecio.setBounds(1136, 130, 124, 24);
				add(cbPrecio);

				opciones = new ButtonGroup();
				opciones.add(rbTipo);
				opciones.add(rbNumeroCilindros);
				opciones.add(rbDimensiones);
				opciones.add(rbMarca);
				opciones.add(rbPrecio);

				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						Calentador calentador=new Calentador();
						List<Calentador> calentadores = new ArrayList<>();  

						if(rbTipo.isSelected()) {
							String tipo = cbTipo.getSelectedItem().toString();
							calentador.setTipo(tipo);
							calentadores=serviceCalentador.getCalentadores(calentador, rbTipo.getText());
						}

						if(rbNumeroCilindros.isSelected()) {
							String numeroCilindros = cbNumeroCilindros.getSelectedItem().toString();
							calentador.setNumCilindros(Integer.parseInt(numeroCilindros));
							calentadores=serviceCalentador.getCalentadores(calentador, rbNumeroCilindros.getText());
						}

						if(rbDimensiones.isSelected()) {
							String dimensiones = cbDimensiones.getSelectedItem().toString();
							calentador.setDimensiones(dimensiones);
							calentadores=serviceCalentador.getCalentadores(calentador, rbDimensiones.getText());
						}

						if(rbMarca.isSelected()) {
							String marca = cbMarca.getSelectedItem().toString();
							calentador.setMarca(marca);
							calentadores=serviceCalentador.getCalentadores(calentador, rbMarca.getText());
						}

						if(rbPrecio.isSelected()) {
							String precio = cbPrecio.getSelectedItem().toString();
							calentador.setPrecio(Double.parseDouble(precio));
							calentadores=serviceCalentador.getCalentadores(calentador, rbPrecio.getText());
						}

						String data[][] = new String[calentadores.size()][5];

						for(int i=0; i<calentadores.size(); i++) {

							data[i][0]=calentadores.get(i).getTipo();
							data[i][1]=String.valueOf(calentadores.get(i).getNumCilindros());
							data[i][2]=calentadores.get(i).getDimensiones();
							data[i][3]=calentadores.get(i).getMarca();
							data[i][4]=String.valueOf(calentadores.get(i).getPrecio());
						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);

					}
				});

				btnBuscar.setBounds(1155, 82, 105, 25);
				add(btnBuscar);

				JButton btnTodo = new JButton("Mostrar Todo");
				btnTodo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						Calentador calentador=new Calentador();
						List<Calentador> calentadores = new ArrayList<>();  

						calentadores=serviceCalentador.getCalentadores(calentador, "Todo");

						String data[][] = new String[calentadores.size()][5];

						for(int i=0; i<calentadores.size(); i++) {

							data[i][0]=calentadores.get(i).getTipo();
							data[i][1]=String.valueOf(calentadores.get(i).getNumCilindros());
							data[i][2]=calentadores.get(i).getDimensiones();
							data[i][3]=calentadores.get(i).getMarca();
							data[i][4]=String.valueOf(calentadores.get(i).getPrecio());
						}

						table.setModel(new DefaultTableModel(data, nombreColunas));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(200);
						table.getColumnModel().getColumn(4).setPreferredWidth(200);
					}
				});
				btnTodo.setBounds(1115, 583, 185, 71);
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
				btnSalir.setBounds(18, 580, 85, 81);
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
