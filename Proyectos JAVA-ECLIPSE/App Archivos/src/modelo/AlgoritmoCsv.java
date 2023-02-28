package modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AlgoritmoCsv {
	static String contenido="";

	

	public static void obtenerArchivoPorUnaString() {
	

		//parsing a CSV file into Scanner class constructor  
			try {
			
				
				
				
		//Ruta del arhivo csv a abrir e imprimir en consola		
			Scanner sc = new Scanner(new File("C:\\Users\\Grudges\\Desktop\\Casos_Diarios.csv"));  
		sc.useDelimiter(" " + "," + " " + "\n");   
			
		while (sc.hasNext())  
		{  
		contenido+=sc.next(); 
		
		System.out.println(contenido.toString());
		
		
		
		
		
		
		}   
		sc.close();  
		 
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error: Verifique la ruta del archivo csv");
			
			}
//			
//			Valor 1,Valor 2,Valor 3,Valor 4
//			13,25,89,12
//			15,21,56,58
//			16,10,48,63
//			19,41,23,78
//			19,23,63,23
//			20,58,78,12
//			2,4,20,48
//			21,1,19,12
//			22,23,18,23
//			25,45,63,47
//			25,96,58,85
//			30,210,45,2
		
		
	}
	
	
	public static void obtenerArchivoEnArray() {
		

		//parsing a CSV file into Scanner class constructor  
			try {
			
				
				
				
		//Ruta del arhivo csv a abrir e imprimir en consola		
			Scanner sc = new Scanner(new File("C:\\Users\\Grudges\\Desktop\\Casos_Diarios.csv"));  
		sc.useDelimiter(" " + "," + " " + "\n");   
			
		while (sc.hasNext())  
		{  
		contenido+=sc.next(); 
		
		//Separar por condicion sangria
		String[] elements = contenido.split("\n");		
		
		// step two : convert String array to list of String

		List<String> fixedLenghtList = Arrays.asList(elements);


		// step three : copy fixed list to an ArrayList
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);

		System.out.println(listOfString);



		
		}   
		sc.close();  
		 
			
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error: Verifique la ruta del archivo csv");
			
			}
		
			/*
			salida
			
			list from pipe delimitedd String : [Valor 1,Valor 2,Valor 3,Valor 4
			                                    , 13,25,89,12
			                                    , 15,21,56,58
			                                    , 16,10,48,63
			                                    , 19,41,23,78
			                                    , 19,23,63,23
			                                    , 20,58,78,12
			                                    , 2,4,20,48
			                                    , 21,1,19,12
			                                    , 22,23,18,23
			                                    , 25,45,63,47
			                                    , 25,96,58,85
			                                    , 30,210,45,2
			                                    ]
*/
		
	}
	
	
	
	

public static void insertarContenido(String c) {
	  Connection con = null;
      PreparedStatement ps = null;
      try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/archivo?" + "useSSL=false", "root", "root");

         
         String query1 = "insert into contenedorcsv( cve_csv, valorUno, valorDos, valorTres, valorCuatro) values(?,?,?,?,?) ";
         
//         String query2 = "insert into contenedorcsv(valorDos) values(?) ";
//         String query3= "insert into contenedorcsv(valorTres) values(?) ";
//         String query4 = "insert into contenedorcsv(valorCuatro) values(?) ";

         ps = con.prepareStatement(query1);
         
//         ps = con.prepareStatement(query2);
//         ps = con.prepareStatement(query3);
//         ps = con.prepareStatement(query4);
         ps.setString(1, "2");
         ps.setString(2, c);
         ps.setString(3, c);
         ps.setString(4, c);
         ps.setString(5, c);

         
         
         ps.executeUpdate();
     	JOptionPane.showMessageDialog(null, "Contenido insertado en la base de datos con exito");

      
      
      }
      catch (Exception e) {
         e.printStackTrace();
      	JOptionPane.showMessageDialog(null, "Error: No se pudo insertar el contenido, verificalo");

      }
   }
	
	public static void main(String[] args){  
		obtenerArchivoEnArray();
	
		
		
		
	}	
}
	

