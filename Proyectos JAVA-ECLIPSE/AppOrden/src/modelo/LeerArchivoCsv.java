package modelo;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LeerArchivoCsv {

	public static void main(String[] args) throws Exception  
	{  
	//parsing a CSV file into Scanner class constructor  
		try {
		
			
	//Ruta del arhivo csv a abrir e imprimir en consola		
		Scanner sc = new Scanner(new File("C:\\Users\\Grudges\\Desktop\\Datos.csv"));  
	sc.useDelimiter(" " + "," + " " + "\n");   
		
	while (sc.hasNext())  
	{  
	System.out.print(sc.next()); 
	}   
	sc.close();  
	 
		
		
	} catch (Exception e) {

		JOptionPane.showMessageDialog(null, "Error: Verifique la ruta del archivo csv");
		
		}
	}
}
	
	
	

