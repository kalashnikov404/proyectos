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
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;
import servicios.ServiceOrdenImpl;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaTickets extends JPanel {
	

	
		private JTable table;

		public ListaTickets() {
			

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
			String nombreColunas[] = {"Clave orden", "N° Mes-Con", "ID Cafecito", "Cantidad", "ID Platillo", "P/U", "Fecha", "Total", "Folio"};
			
		//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
			//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
			ServiceOrdenImpl serviceOrdenImpl = new ServiceOrdenImpl();

			//List<String> empleados = new ArrayList<>();
			List<Orden> ordenes = new ArrayList<>();

			
			ordenes=serviceOrdenImpl.getOrdenes();

			

			String data[][] = new String[ordenes.size()][9];


			
			for(int i=0; i<ordenes.size(); i++) {
	

//				
//				orden.setClaveOrden(rs.getInt("cve_ord"));
//				orden.setNumeroMesaContrato(rs.getInt("num_mescon"));
//				orden.setCantidadDetalleOrden(rs.getInt("cant_detord"));
//				orden.setClavePlatillo(rs.getInt("cve_pla"));
//				orden.setPrecioVentaDetalleOrden(rs.getInt("pventa_detord"));
//				orden.setFechaticket(rs.getString("fecha_tic"));
//				orden.setTotal(rs.getInt("total_tic"));
//				orden.setFolio(rs.getInt("folio_con"));

				
				data[i][0]=String.valueOf(ordenes.get(i).getClaveOrden());
				data[i][1]=String.valueOf(ordenes.get(i).getNumeroMesaContrato());
				data[i][2]=String.valueOf(ordenes.get(i).getClaveCafecito());
				data[i][3]=String.valueOf(ordenes.get(i).getCantidadDetalleOrden());
				data[i][4]=String.valueOf(ordenes.get(i).getClavePlatillo());
				data[i][5]=String.valueOf(ordenes.get(i).getPrecioVentaDetalleOrden());
				data[i][6]=ordenes.get(i).getFechaticket();				
				data[i][7]=String.valueOf(ordenes.get(i).getTotal());
				data[i][8]=String.valueOf(ordenes.get(i).getFolio());


		
				
			}
			

			


			table.setModel(new DefaultTableModel(data, nombreColunas));
			
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);

			


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