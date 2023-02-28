package vista;

import java.awt.ScrollPane;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TablaCafecito;
import modelo.Cafecito;
import modelo.Ciudad;
import modelo.Empleado;
import modelo.Insumo;
import modelo.Orden;
import modelo.Resurtido;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;
import servicios.ServiceOrdenImpl;
import servicios.ServiceResurtidoImpl;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaResurtidos extends JPanel {
	

	
		private JTable table;

		public ListaResurtidos() {
			

//			private int claveProducto;
//			private String nombre;
//			private String tipo;
//			private String marca;
//			private String presentacion;
//			private String contenido;
//			private String umedia;
//			
//		//tabla minmax
//			private int existencia;
//			private int minimo;
//			private int maximo;
//			private int claveProducto2;
//			private int claveCafecito;
//			
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"Clave Resurtido", "F.Resurtido", "Clave Proveedor", "Clave Cafecito", "Cantidad", "P/U", "Clave Producto"};
			
		//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
			//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
			ServiceResurtidoImpl serviceResurtidoImpl = new ServiceResurtidoImpl();

			//List<String> empleados = new ArrayList<>();
			List<Resurtido> resurtidos = new ArrayList<>();

			
			resurtidos=serviceResurtidoImpl.getResurtidos();

			

			String data[][] = new String[resurtidos.size()][7];


			
			for(int i=0; i<resurtidos.size(); i++) {
	

//				
//				resurtido.setClaveResurtido(rs.getInt("cve_pla"));
//				resurtido.setFechaResurtido(rs.getString("fecha_tic"));
//				resurtido.setClaveProveedor(rs.getInt("cve_pla"));
//				resurtido.setClaveCafecito(rs.getInt("cve_pla"));
//				resurtido.setCantidad(rs.getInt("cve_pla"));
//				resurtido.setPpu(rs.getInt("cve_pla"));
//				resurtido.setClaveProducto(rs.getInt("cve_pla"));

				data[i][0]=String.valueOf(resurtidos.get(i).getClaveResurtido());
				data[i][1]=resurtidos.get(i).getFechaResurtido();				
				data[i][2]=String.valueOf(resurtidos.get(i).getClaveProveedor());
				data[i][3]=String.valueOf(resurtidos.get(i).getClaveCafecito());
				data[i][4]=String.valueOf(resurtidos.get(i).getCantidad());
				data[i][5]=String.valueOf(resurtidos.get(i).getPpu());
				data[i][6]=String.valueOf(resurtidos.get(i).getClaveProducto());



		
				
			}
			

			


			table.setModel(new DefaultTableModel(data, nombreColunas));
			
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(140);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			
			


			setLayout(null);

			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(0, 0, 1430, 700);
			add(scrollPane);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
//			JLabel lblId = new JLabel("Clave            Calle          Numero        Orientacion        Colonia         Asentamiento        Zona        CP       Ciudad          Municipio          Estado");
//			lblId.setFont(new Font("Bernard MT Condensed", Font.BOLD, 20));
//			
//			add(lblId);
//			add(table);

			
			
			setVisible(true);


		}
}