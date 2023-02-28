package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.PdfWriter;

public class Archivos {
 JFileChooser seleccion=new JFileChooser();
 File archivo;
 FileInputStream entrada;
 FileReader fr = null;
 BufferedReader br = null;
 
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
	public String btnSeleccionarArchivo() {
		String documento="";
		if (seleccion.showDialog(null,"abrir")==JFileChooser.APPROVE_OPTION) {
			archivo=seleccion.getSelectedFile();
			if (archivo.canRead()) {
				if (archivo.getName().endsWith(".txt")) {
					documento=abrirArchivo(archivo);
					return documento;
				}else {
					JOptionPane.showMessageDialog(null,"archivo no compatible");
				}
			}
		}
		return documento;
	}
	public void archivosTKID(String tokens,String ruta)throws IOException  {
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(tokens);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }
	
	public void abrir(String ruta) {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("C:\\Windows\\notepad.exe "+ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public ArrayList<String> abrirSemen(String ruta) {
	File archivo=new File(ruta);
	ArrayList<String> tk=new ArrayList<String>();
	try {
		FileReader fr=new FileReader(archivo);
		BufferedReader br=new BufferedReader(fr);
		String linea;
		while ((linea=br.readLine())!=null) {
		  String[] put=linea.split("_");
		  String cad="",dos="";
		  String[] nom=linea.split(",");
		  for (int i = 0; i < put[1].length()-1; i++) {
			cad+=put[1].charAt(i);
		}
		  //System.out.println(nom[1]);
		  if(nom[1].equals("TK_id)")) {
			  tk.add(cad+nom[0]+")");
//				System.out.println(cad+nom[0]+")");

		  }else {
			  if(nom[1].equals("TK_entero)")||nom[1].equals("TK_real)")) {
				  tk.add(cad+nom[0]+")");
					//System.out.println(cad+nom[0]+")");

			  }else {
					tk.add(cad); 
			  }

		  }
		  
//		tk.add(cad); 

		}
		return tk;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
public ArrayList<Padre> abrirSemento(String ruta) {
	File archivo=new File(ruta);
	ArrayList<Padre> arbol=new ArrayList<Padre>();
	try {
		FileReader fr=new FileReader(archivo);
		BufferedReader br=new BufferedReader(fr);
		String linea;
		while ((linea=br.readLine())!=null) {
		  String[] nom=linea.split("	");
		  if(!nom[0].equals("Numero")) {
			 
			  arbol.add(new Padre(Integer.parseInt(nom[0]),nom[1],Integer.parseInt(nom[2])));
		  }
		  //System.out.println(nom[1]);
		  
//		tk.add(cad); 

		}
		return arbol;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
public void archivoModificacionID(String linea,String ruta)throws IOException  {
    File archivo = new File(ruta);
    BufferedWriter bw;
    if(archivo.exists()) {
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(linea);
    } else {
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("Acabo de crear el fichero de texto.");
    }
    bw.close();
}
}
