package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import api.ServiceCalentador;
import api.ServiceCompra;
import api.ServiceProveedor;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.DetalleCompra;
import modelo.Horario;
import servicios.ServiceCalentadorImpl;
import servicios.ServiceCompraImpl;
import servicios.ServiceProveedorImpl;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ConsultarInventario extends JPanel {
	private JTable table;
	private ButtonGroup opciones;
	private ServiceCompra serviceCompra;

	public ConsultarInventario(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			setBackground(new Color(157, 198, 69));
			setBounds(100, 100, 1440, 900);
			setLayout(null);
			try {
				serviceCompra=new ServiceCompraImpl();


				JLabel lblTitulo = new JLabel("Consultar Inventario");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);


				table = new JTable();
				table.setForeground(Color.BLACK);
				table.setBackground(new Color(242, 221, 192));
				table.setBounds(23, 197, 799, 285);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"Tipo calentador","Num.Cilindros", "Dimenciones", "Marca", "Precio","Cantidad actual"};
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(229, 78, 50));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Bw Quinta Pro", Font.PLAIN, 14));
				add(table);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(18, 112, 1397, 515);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


				List<String> detallecompra = new ArrayList<>();
				detallecompra=serviceCompra.getInventario();
				String data[][] = new String[detallecompra.size()][6];
				int j=0;
				for(int i=0; i<detallecompra.size(); i++) {
					j=0;
					String[] partes = detallecompra.get(i).split(", ");

					data[i][0]=partes[j]; 
					j++;
					data[i][1]=partes[j];
					j++;
					data[i][2]=partes[j]; 
					j++;
					data[i][3]=partes[j];
					j++;
					data[i][4]=partes[j];
					j++;
					data[i][5]=partes[j];


				}
				table.setModel(new DefaultTableModel(data, nombreColunas));
				table.getColumnModel().getColumn(0).setPreferredWidth(200);
				table.getColumnModel().getColumn(1).setPreferredWidth(200);
				table.getColumnModel().getColumn(2).setPreferredWidth(200);
				table.getColumnModel().getColumn(3).setPreferredWidth(200);
				table.getColumnModel().getColumn(4).setPreferredWidth(200);
				table.getColumnModel().getColumn(5).setPreferredWidth(200);


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

			} catch (ConexionException e) {
				// TODO Auto-generated catch block
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
