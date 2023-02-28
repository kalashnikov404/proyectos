package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import servicios.ServiceArchivosImpl;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;
import modelo.Csv;
import modelo.Garantia;
import modelo.Json;

public class TratadoJson extends JPanel {
	private JTable table;

	public TratadoJson(String usuario) throws ConexionException {
		
		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
		setLayout(null);
		setBackground(new Color(157, 198, 69));

		JLabel lblTitulo = new JLabel("Tratado de archivo JSON");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBackground(new Color(58, 131, 29));
		lblTitulo.setOpaque(true);
		lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
		lblTitulo.setBounds(6, 6, 1428, 31);
		add(lblTitulo);
		
		
		table = new JTable();
		table.setBounds(1, 1, 0, 0);
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(242, 221, 192));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"ID", "NOMBRE ES", "SIGLAS", "PREFIJO TELEFONICO", "NOMBRE US"};
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(229, 78, 50));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
		
		
		add(table);

		
		ServiceArchivosImpl serviceArchivosImpl = new ServiceArchivosImpl();

		
	

		List<Json> jsons = new ArrayList<>();
		jsons=serviceArchivosImpl.getJsons();

		String data[][] = new String[jsons.size()][5];

		for(int i=0; i<jsons.size(); i++) {
			data[i][0]=String.valueOf(jsons.get(i).getId());
			data[i][1]=jsons.get(i).getNombreEs();
			data[i][2]=jsons.get(i).getSiglas();
			data[i][3]=jsons.get(i).getPrefijo();
			data[i][4]=jsons.get(i).getNombreUs();
		
			

		}
	

		setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(150, 187, 1404, 800);
		add(scrollPane);
	
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
