package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerArchivosJson {

	
	
	public static void main(String[] args) {
        EscribirArchivosJSON();
    }
    
    
  public static void EscribirArchivosJSON(){
      JSONObject objson= new JSONObject();
      JSONObject objson2= new JSONObject();
      
     Integer edad= 24;
     String nombre="Rodrigo";
     String domicilio ="conocido";
     double[] arreglo = {20.1,14.6,8.9,5.6};
     objson.put("Edad: ", edad);
     objson.put("Nombre: ",nombre );
     objson.put("Domicilio: ", domicilio);
     objson.put("Arreglo: ", arreglo);
     objson2.put("Arreglo: ", arreglo);
     objson.put("Objeto 2: ", objson2);
     
      try {
          FileWriter fileWriter= new FileWriter("C:\\Users\\Grudges\\Desktop\\prueba.json");
          fileWriter.write(objson.toString());
          fileWriter.close();
      } catch (IOException e) {
      }
  
	
  }

}


