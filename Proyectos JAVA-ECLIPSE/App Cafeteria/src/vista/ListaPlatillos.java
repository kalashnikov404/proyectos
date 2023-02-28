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
import modelo.Lugar;
import modelo.Platillo;
import servicios.ServiceCafecitoImpl;
	import servicios.ServiceEmpleadoImpl;
import servicios.ServiceLugarImpl;
import servicios.ServicePlatilloImpl;

import java.awt.FlowLayout;

	import javax.swing.ImageIcon;
	import javax.swing.JLabel;
	import java.awt.Font;

	public class ListaPlatillos extends JPanel {
		

		
			private JTable table;

			public ListaPlatillos() {
				
//				lugar.setClaveMesa(rs.getInt("cve_mes"));
//				lugar.setCapacidad(rs.getInt("capacidad_mes"));
//				
//			
//				lugar.setNumeroMesa(rs.getInt("num_mescaf"));
//				lugar.setNumero(rs.getInt("numero_mescaf"));
//				lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
//				lugar.setClaveCafecito(rs.getInt("cve_caf"));
//				
//				lugar.setMesaContrato(rs.getInt("num_mescon"));
//				lugar.setFecha(rs.getString("fecha_mescon"));
//				lugar.setFolio(rs.getInt("num_mescaf"));
				
//				
//
//				//platillo
//				platillo.setClavePlatillo(rs.getInt("cve_pro"));
//				platillo.setNombre(rs.getString("nom_pro"));
//				platillo.setTipo(rs.getString("tipo_pro"));
//				platillo.setDescripcion(rs.getString("marca_pro"));
//				platillo.setTiempo(rs.getString("presentacion_pro"));
//				platillo.setPorcion(rs.getInt("cve_pro"));
//				
//				//ingredienteplatillo
//				platillo.setNumeroIngredientePlatillo(rs.getInt("cve_pro"));
//				platillo.setCantidad(rs.getInt("cve_pro"));
//				platillo.setUmedida(rs.getString("cve_pro"));
//				platillo.setClaveProducto(rs.getInt("cve_pro"));
//
//				
//				
////				tabla costos
//				platillo.setCosto(rs.getInt("num_minmax"));
//			
//				//
//				//tabla platillo cafecito
//				platillo.setNumeroPlatilloCafecito(rs.getInt("min_minmax"));
//				platillo.setFechaPlatilloCafecito(rs.getString("min_minmax"));
				table = new JTable();
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"ID", "Nombre", "Tipo", "Descripcion", "Tiempo", "Porcion", "N.IgPla", "Cantidad", "Umedida", "ID producto", "Costo", "ID PlaCad", "Fecha"};
				
			//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
				//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
				ServicePlatilloImpl servicePlatilloImpl = new ServicePlatilloImpl();

				//List<String> empleados = new ArrayList<>();
				List<Platillo> platillos = new ArrayList<>();

				
				platillos=servicePlatilloImpl.getPlatillos();

				

				String data[][] = new String[platillos.size()][13];


	//
	//
//				int i=0;
//				for(int k=0; k<empleados.size()/17; k++) {
//					for(int j=0; j<17; j++) {
//						data[k][j]=empleados.get(i); i++;
//					}
//				}
				
				for(int i=0; i<platillos.size(); i++) {

					
				
			

//					//
//					//tabla platillo cafecito
//					platillo.setNumeroPlatilloCafecito(rs.getInt("min_minmax"));
//					platillo.setFechaPlatilloCafecito(rs.getString("min_minmax"));


					
					data[i][0]=String.valueOf(platillos.get(i).getClavePlatillo());
					data[i][1]=platillos.get(i).getNombre();
					data[i][2]=platillos.get(i).getTipo();
					data[i][3]=platillos.get(i).getDescripcion();
					data[i][4]=platillos.get(i).getTiempo();
					data[i][5]=String.valueOf(platillos.get(i).getPorcion());
					

					data[i][6]=String.valueOf(platillos.get(i).getNumeroIngredientePlatillo());
					data[i][7]=String.valueOf(platillos.get(i).getCantidad());
					data[i][8]=platillos.get(i).getUmedida();
					data[i][9]=String.valueOf(platillos.get(i).getClaveProducto());
					
					data[i][10]=String.valueOf(platillos.get(i).getCosto());

					data[i][11]=String.valueOf(platillos.get(i).getNumeroPlatilloCafecito());

					data[i][12]=platillos.get(i).getFechaPlatilloCafecito();

				
				}
				

				


				table.setModel(new DefaultTableModel(data, nombreColunas));
				
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(120);
				table.getColumnModel().getColumn(2).setPreferredWidth(120);
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

				


				setLayout(null);

				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(0, 0, 1430, 700);
				add(scrollPane);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
//				JLabel lblId = new JLabel("Clave            Calle          Numero        Orientacion        Colonia         Asentamiento        Zona        CP       Ciudad          Municipio          Estado");
//				lblId.setFont(new Font("Bernard MT Condensed", Font.BOLD, 20));
//				
//				add(lblId);
//				add(table);

				
				
				setVisible(true);


			}

}
