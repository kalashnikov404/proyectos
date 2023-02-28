package vista;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TablaCafecito;
import modelo.Cafecito;
import modelo.Ciudad;
import servicios.ServiceCafecitoImpl;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaCafecitos extends JPanel {
	

	
		private JTable table;

		public ListaCafecitos() {
			

			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};
			
		//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
			ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();

			List<Cafecito> cafecitos = new ArrayList<>();

			
			cafecitos=serviceCafecitoImpl.getCafecitos();

			

			String data[][] = new String[cafecitos.size()][11];

			
			

			for(int i=0; i<cafecitos.size(); i++) {
	
				data[i][0]=String.valueOf(cafecitos.get(i).getCveCF());
				data[i][1]=cafecitos.get(i).getCalle();
				data[i][2]=String.valueOf(cafecitos.get(i).getNumero());
				data[i][3]=cafecitos.get(i).getOrientacion();
			
			   
				data[i][4]=cafecitos.get(i).getColonia();
				data[i][5]=cafecitos.get(i).getAsentamiento();
				data[i][6]=cafecitos.get(i).getZona();
				
				data[i][7]=String.valueOf(cafecitos.get(i).getCp());

			    data[i][8]=cafecitos.get(i).getCiudad();
				data[i][9]=cafecitos.get(i).getMunicipio();
					
				data[i][10]=cafecitos.get(i).getEstado();

				//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

			}
			

			


			table.setModel(new DefaultTableModel(data, nombreColunas));
			
			table.getColumnModel().getColumn(0).setPreferredWidth(120);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(120);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(150);
			table.getColumnModel().getColumn(6).setPreferredWidth(80);
			table.getColumnModel().getColumn(7).setPreferredWidth(60);
			table.getColumnModel().getColumn(8).setPreferredWidth(120);
			table.getColumnModel().getColumn(9).setPreferredWidth(120);
			table.getColumnModel().getColumn(10).setPreferredWidth(120);


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