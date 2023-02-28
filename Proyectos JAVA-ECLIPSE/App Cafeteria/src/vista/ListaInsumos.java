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
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaInsumos extends JPanel {
	

	
		private JTable table;

		public ListaInsumos() {
			

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
			String nombreColunas[] = {"Clave producto", "Nombre", "Tipo", "Marca", "Presentacion", "Contenido", "U.Medida", "Existencia", "Minimo", "Maximo", "Clave cafecito"};
			
		//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
			//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
			ServiceInsumoImpl serviceInsumoImpl = new ServiceInsumoImpl();

			//List<String> empleados = new ArrayList<>();
			List<Insumo> insumos = new ArrayList<>();

			
			insumos=serviceInsumoImpl.getInsumos();

			

			String data[][] = new String[insumos.size()][11];


			
			for(int i=0; i<insumos.size(); i++) {
	
//			
//				private int claveProducto;
//				private String nombre;
//				private String tipo;
//				private String marca;
//				private String presentacion;
//				private String contenido;
//				private String umedia;
//				
//			//tabla minmax
//				private int existencia;
//				private int minimo;
//				private int maximo;
//				private int claveProducto2;
//				private int claveCafecito;
//				
				
				data[i][0]=String.valueOf(insumos.get(i).getClaveProducto());
				
				data[i][1]=insumos.get(i).getNombre();
				data[i][2]=insumos.get(i).getTipo();
				data[i][3]=insumos.get(i).getMarca();
				data[i][4]=insumos.get(i).getPresentacion();
				data[i][5]=insumos.get(i).getContenido();
				data[i][6]=insumos.get(i).getUmedia();
				
				data[i][7]=	String.valueOf(insumos.get(i).getExistencia());
				data[i][8]=	String.valueOf(insumos.get(i).getMinimo());
				data[i][9]=	String.valueOf(insumos.get(i).getMaximo());
				data[i][10]=	String.valueOf(insumos.get(i).getClaveCafecito());
		
				
			}
			

			


			table.setModel(new DefaultTableModel(data, nombreColunas));
			
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);
			table.getColumnModel().getColumn(9).setPreferredWidth(100);
			table.getColumnModel().getColumn(10).setPreferredWidth(100);
			


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