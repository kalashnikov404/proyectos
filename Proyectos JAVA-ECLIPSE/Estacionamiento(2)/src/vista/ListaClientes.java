package vista;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import servicios.ServiceClienteImpl;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaClientes extends JPanel {
	private JTable table;

	public ListaClientes() {
		setLayout(null);
		

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String nombreColunas[] = {"ID", "CELULAR", "CORREO", "PLACAS"};

		ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();

		List<Cliente> clientes = new ArrayList<>();
		clientes=serviceClienteImpl.getClientes();

		String data[][] = new String[clientes.size()][4];

		for(int i=0; i<clientes.size(); i++) {
			data[i][0]=String.valueOf(clientes.get(i).getId());
			data[i][1]=clientes.get(i).getCelular();
			data[i][2]=clientes.get(i).getCorreo();
			data[i][3]=clientes.get(i).getVehiculo().getPlacas();
		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		table.setModel(new DefaultTableModel(data, nombreColunas));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(350);
		
		JLabel lblId = new JLabel("Id                                   Celular                                   Correo                                  Placas");
		lblId.setFont(new Font("Zapf Dingbats", Font.BOLD, 26));
		
		add(lblId);
		add(table);

		setVisible(true);


	}
}
