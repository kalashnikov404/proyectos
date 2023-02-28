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
import servicios.ServiceCafecitoImpl;
	import servicios.ServiceEmpleadoImpl;
import servicios.ServiceLugarImpl;

import java.awt.FlowLayout;

	import javax.swing.ImageIcon;
	import javax.swing.JLabel;
	import java.awt.Font;

	public class ListaLugares extends JPanel {
		

		
			private JTable table;

			public ListaLugares() {
				
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
				
				table = new JTable();
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String nombreColunas[] = {"ID", "Capacidad", "Numero", "Ubicacion", "Clave cafecito", "ID.MesCon", "Fecha", "Folio"};
				
			//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
				//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
				ServiceLugarImpl serviceLugarImpl = new ServiceLugarImpl();

				//List<String> empleados = new ArrayList<>();
				List<Lugar> lugares = new ArrayList<>();

				
				lugares=serviceLugarImpl.getLugares();

				

				String data[][] = new String[lugares.size()][8];


	//
	//
//				int i=0;
//				for(int k=0; k<empleados.size()/17; k++) {
//					for(int j=0; j<17; j++) {
//						data[k][j]=empleados.get(i); i++;
//					}
//				}
				
				for(int i=0; i<lugares.size(); i++) {
		
//					//mesa
//					private int claveMesa;
//					private int capacidad;
//					
//					//mesa cafecito
//					private int numeroMesa;
//					private int numero;
//					private String Ubicacion;
//					private int claveMesa2;
//					private int claveCafecito;
//					
//					//mesa contrato
//					private int mesaContrato;
//					private String fecha;
//					private int folio;
//					private int claveMesa3;
					data[i][0]=String.valueOf(lugares.get(i).getClaveMesa());
					data[i][1]=String.valueOf(lugares.get(i).getCapacidad());
					
					data[i][2]=String.valueOf(lugares.get(i).getNumeroMesa());
					data[i][3]=lugares.get(i).getUbicacion();
					data[i][4]=String.valueOf(lugares.get(i).getClaveCafecito());
					
					
					data[i][5]=String.valueOf(lugares.get(i).getMesaContrato());
					data[i][6]=lugares.get(i).getFecha();
					data[i][7]=String.valueOf(lugares.get(i).getFolio());

				
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
