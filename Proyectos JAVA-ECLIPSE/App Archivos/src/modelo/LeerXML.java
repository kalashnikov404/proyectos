package modelo;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Objects;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;

public class LeerXML {
	

	static String contenido="";
	static String salida="";

	
	public static void main(String[] args) {
		
		
		
		obtenerXML();

		
				}
	


JFileChooser seleccion=new JFileChooser();
File archivo;
FileInputStream entrada;
FileReader fr = null;
BufferedReader br = null;


public static void obtenerXML() {
	

	

	try {
		
		
	//Archivo xml ubicado en el escritorio reemplazar por el propio	
	File archivo=new File("C:\\Users\\Grudges\\Desktop\\datos.XML");
		
DocumentBuilderFactory doc=DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder =doc.newDocumentBuilder();
Document document = documentBuilder.parse(archivo);
document.getDocumentElement().normalize();
contenido+=("Primer elemento: "+document.getDocumentElement().getNodeName());
NodeList listaAlumnos=document.getElementsByTagName("empleado");
for (int i = 0; i < listaAlumnos.getLength(); i++) {
	
Node nodo = listaAlumnos.item(i);
contenido+=("Elmento "+nodo.getNodeName());

if(nodo.getNodeType()==Node.ELEMENT_NODE) {
	Element elemento =(Element) nodo;
	
	contenido+= ("ID " + elemento.getAttribute("Id") +  "\n");
	contenido+=("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent() +  "\n");
	contenido+=("Username: " + elemento.getElementsByTagName("username").item(0).getTextContent() +  "\n");
	contenido+=("Password: " + elemento.getElementsByTagName("password").item(0).getTextContent() +  "\n");

	
	
	
	
}

String salida = contenido.toString();

generarArchivo(salida);



}

JOptionPane.showMessageDialog(null, "Archivo.txt con contenido XML guardado con exito en tu escritorio");



}catch(Exception e) {
	
	e.printStackTrace();
	JOptionPane.showMessageDialog(null,"Error: Verifica las rutas de entrada del archivo XML y de salida TXT");

}

}






public static void generarArchivo(String c) {
	
	
	 PrintWriter sprintWriter  = null;
        
        {
            try {
            	
            	//Archivo Xml guardado en escritorio
            	sprintWriter = new PrintWriter("C:\\Users\\Grudges\\Desktop\\Archivo.txt");

            } catch (FileNotFoundException e) {
            
            }
            Objects.requireNonNull(sprintWriter).println(c);
            sprintWriter.close();

        }
        

}
}

