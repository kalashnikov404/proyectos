package modelo;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
	import java.io.FileReader; 
	import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class AlgoritmoTxt{

	private static JFileChooser abrirArchivo;
	ArrayList<String> lines = new ArrayList<String>();
	static Pattern temperatureRegex = Pattern.compile("^([0-9]+)");
	
	

JFileChooser seleccion=new JFileChooser();
File archivo;
FileInputStream entrada;
FileReader fr = null;
BufferedReader br = null;
static String texto;

public String abrirArchivo(File archivo) {
 String documento="";
 try {
    fr = new FileReader (archivo);
    br = new BufferedReader(fr);
    // Lectura del fichero
    String linea;
    while((linea=br.readLine())!=null)
       documento+=linea+"\n";
   
 }
 catch(Exception e){
    e.printStackTrace();
 }
 return documento;
}




public static String getArchivo( String ruta ){
	FileReader fr = null;
	BufferedReader br = null;
	//Cadena de texto donde se guardara el contenido del archivo
	String contenido = "";
	try
	{
		//ruta puede ser de tipo String o tipo File
		fr = new FileReader( ruta );
		br = new BufferedReader( fr );
		String linea;
		//Obtenemos el contenido del archivo linea por linea
		while( ( linea = br.readLine() ) != null ){ 
			contenido += linea + "\n";
		}
	}catch( Exception e ){  }
	//finally se utiliza para que si todo ocurre correctamente o si ocurre 
	//algun error se cierre el archivo que anteriormente abrimos
	finally
	{
		try{
			br.close();
		}catch( Exception ex ){}
	}
	return contenido;
}



public static void obtenerTxt() {
	
	JOptionPane.showMessageDialog(null, "Selecciona un archivo de tu directorio");

if( abrirArchivo == null ) abrirArchivo = new JFileChooser();


abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
int seleccion = abrirArchivo.showOpenDialog(abrirArchivo);
if( seleccion == JFileChooser.APPROVE_OPTION )
{
	File f = abrirArchivo.getSelectedFile();
	try
	{
		String path = f.getAbsolutePath();
		String contenido = getArchivo( path );

		//System.out.println(contenido);
		
		texto= contenido;
		
		insertarContenido(texto);

	}catch( Exception exp){
		JOptionPane.showMessageDialog(null, "No se ha abierto ningun archivo o es incorrecto, intenta de nuevo");
	}
}
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
		
	obtenerTxt();
	
	
	}
	

}