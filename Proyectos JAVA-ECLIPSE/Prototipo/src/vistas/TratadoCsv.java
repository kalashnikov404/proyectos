package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import modelo.Vocal;
import servicios.ServiceArchivosImpl;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;
import modelo.Csv;
import modelo.Garantia;

public class TratadoCsv extends JPanel {
	private JTable table;
	

	
	public TratadoCsv(String usuario) throws ConexionException, ClassNotFoundException, SQLException {
		
		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
		setLayout(null);
		

		setBackground(new Color(157, 198, 69));


		JLabel lblTitulo = new JLabel("Tratado de archivo CSV");
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
		String nombreColunas[] = {"ID", "POBLACION", "NOMBRE", "F1",  "F2",  "F3", "F4",
				"F5","F6","F7","F8","F9","F10","F11","F12",
				"F13","F14","F15"};
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(229, 78, 50));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
		
		
		add(table);

		
		ServiceArchivosImpl serviceArchivosImpl = new ServiceArchivosImpl();

		
	

		List<Csv> csvs = new ArrayList<>();
		csvs=serviceArchivosImpl.getCsvs();

		String data[][] = new String[csvs.size()][18];

	        
		   
	        Vocal vocal = new Vocal();
	        String x;
		
		for(int i=0; i<csvs.size(); i++) {
			data[i][0]=String.valueOf(csvs.get(i).getId());
			data[i][1]=csvs.get(i).getPoblacion();
			data[i][2]=csvs.get(i).getNombre();
			data[i][3]=csvs.get(i).getF1();
			data[i][4]=csvs.get(i).getF2();
			data[i][5]=csvs.get(i).getF3();
			data[i][6]=csvs.get(i).getF4();
			data[i][7]=csvs.get(i).getF5();
			data[i][8]=csvs.get(i).getF6();
			data[i][9]=csvs.get(i).getF7();
			data[i][10]=csvs.get(i).getF8();
			data[i][11]=csvs.get(i).getF9();
			data[i][12]=csvs.get(i).getF10();
			data[i][13]=csvs.get(i).getF11();
			data[i][14]=csvs.get(i).getF12();
			data[i][15]=csvs.get(i).getF13();
			data[i][16]=csvs.get(i).getF14();
			data[i][17]=csvs.get(i).getF15();

			

	        
	    

			

		}
		
		String query = "SELECT nombre, poblacion from csv";
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(
				"jdbc:mysql://localhost:3306/tenergy", "com.mysql.jdbc.Driver",
				"root", "root");
		dataset.executeQuery(query);

		JFreeChart chart = ChartFactory.createLineChart("poblacion", "nombre", "",
				dataset, PlotOrientation.HORIZONTAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBackground(Color.RED);
		
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		ApplicationFrame f = new ApplicationFrame("Chart");
		f.setContentPane(chartPanel);
		f.pack();
		f.setVisible(true);
		
	

		setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(100);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		table.getColumnModel().getColumn(12).setPreferredWidth(100);
		table.getColumnModel().getColumn(13).setPreferredWidth(100);
		table.getColumnModel().getColumn(14).setPreferredWidth(100);
		table.getColumnModel().getColumn(15).setPreferredWidth(100);
		table.getColumnModel().getColumn(16).setPreferredWidth(100);
		table.getColumnModel().getColumn(17).setPreferredWidth(100);

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
		btnSalir.setBounds(45, 550, 85, 81);
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
