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
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaEmpleados extends JPanel {
	

	
		private JTable table;

		public ListaEmpleados() {
			

			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			String nombreColunas[] = {"ID", "Nombre", "A.Paterno", "A.Materno", "Calle", "Numero", "Orientacion", "F.Nacimiento", "Genero", "Telefono", "Cve Colonia", "Folio", "RFC", "F.Inicio", "F.Fin", "Sueldo", "Puesto","Clave Cafecito"};
			
		//	select cafecito.cve_caf, cafecito.calle_caf, cafecito.num_caf, cafecito.orientacion_caf, colonia.nom_col, colonia.tipoasen_col, colonia.zona_col, codigopostal.cve_cp, nom_ciu, mun_ciu, nom_edo 
			//ServiceCafecitoImpl serviceCafecitoImpl = new ServiceCafecitoImpl();
			ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();

			//List<String> empleados = new ArrayList<>();
			List<Empleado> empleados = new ArrayList<>();

			
			empleados=serviceEmpleadoImpl.getEmpleados2();

			

			String data[][] = new String[empleados.size()][18];


//
//
//			int i=0;
//			for(int k=0; k<empleados.size()/17; k++) {
//				for(int j=0; j<17; j++) {
//					data[k][j]=empleados.get(i); i++;
//				}
//			}
			
			for(int i=0; i<empleados.size(); i++) {
	
//				empleado.setCvePer(rs.getInt("cve_per"));
//				empleado.setNombre(rs.getString("nom_per"));
//				empleado.setPaterno(rs.getNString("ap_per"));
//				empleado.setMaterno(rs.getNString("am_per"));
//				empleado.setCalle(rs.getNString("calle_per"));
//				empleado.setNumero(rs.getInt("num_per"));
//				empleado.setOrientacion(rs.getNString("orientacion_per"));
//				
//				empleado.setNacimiento(rs.getDate("fechanac_per"));
//				empleado.setGenero(rs.getNString("genero_per"));
//				empleado.setTelefono(rs.getInt("telefono_per"));
//				empleado.setCveColonia(rs.getInt("cve_col"));
//
//		
//				//datos del contrato
//				empleado.setFolio(rs.getInt("folio_con"));
//				empleado.setRfc(rs.getString("rfc_con"));
//				empleado.setfInicio(rs.getDate("fechaini_con"));
//				empleado.setfFinal(rs.getDate("fechafin_con"));
//				empleado.setSueldo(rs.getDouble("sueldo_con"));
//				empleado.setPuesto(rs.getString("puesto_con"));
//				empleado.setCveCaf(rs.getInt("cve_caf"));	
				
				
				data[i][0]=String.valueOf(empleados.get(i).getCvePer());
				data[i][1]=empleados.get(i).getNombre();
				data[i][2]=empleados.get(i).getPaterno();
				data[i][3]=empleados.get(i).getMaterno();
				data[i][4]=empleados.get(i).getCalle();
				data[i][5]=String.valueOf(empleados.get(i).getNumero());
				data[i][6]=empleados.get(i).getOrientacion();
				data[i][7]=	String.valueOf(empleados.get(i).getNacimiento());
				data[i][8]=	empleados.get(i).getGenero();
				data[i][9]=	String.valueOf(empleados.get(i).getTelefono());
				data[i][10]=	String.valueOf(empleados.get(i).getCveColonia());
				data[i][11]=	String.valueOf(empleados.get(i).getFolio());
				data[i][12]=	empleados.get(i).getRfc();
				data[i][13]=	String.valueOf(empleados.get(i).getfInicio());
				data[i][14]=	String.valueOf(empleados.get(i).getfFinal());
				data[i][15]=	String.valueOf(empleados.get(i).getSueldo());
				data[i][16]=	empleados.get(i).getPuesto();
				data[i][17]=	String.valueOf(empleados.get(i).getCveCaf());


				



				

				
		
				//String nombreColunas[] = {"Clave", "Calle", "Numero", "Orientacion", "Colonia", "Asentamiento",  "Zona", "CP", "Ciudad", "Municipio", "Estado"};

			}
			

			


			table.setModel(new DefaultTableModel(data, nombreColunas));
			
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.getColumnModel().getColumn(6).setPreferredWidth(80);
			table.getColumnModel().getColumn(7).setPreferredWidth(80);
			table.getColumnModel().getColumn(8).setPreferredWidth(60);
			table.getColumnModel().getColumn(9).setPreferredWidth(80);
			table.getColumnModel().getColumn(10).setPreferredWidth(80);
			table.getColumnModel().getColumn(11).setPreferredWidth(40);
			table.getColumnModel().getColumn(12).setPreferredWidth(120);
			table.getColumnModel().getColumn(13).setPreferredWidth(80);
			table.getColumnModel().getColumn(14).setPreferredWidth(80);
			table.getColumnModel().getColumn(15).setPreferredWidth(80);
			table.getColumnModel().getColumn(16).setPreferredWidth(60);
			table.getColumnModel().getColumn(17).setPreferredWidth(80);



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