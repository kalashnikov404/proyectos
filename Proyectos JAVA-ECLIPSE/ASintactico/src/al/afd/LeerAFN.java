package al.afd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LeerAFN {
    
    String[] lineas;
    File archivo;
    String ruta = "src/datos/automata.txt";

    public void abrirArchivo() throws FileNotFoundException, IOException {
        archivo = new File(ruta);

        if (!archivo.exists()) {
            JFileChooser promptFile = new JFileChooser();
            promptFile.setFileFilter(new FileNameExtensionFilter("Documentos", "txt"));
            int option = promptFile.showDialog(null, "Seleccionar");
            System.out.println(option);
            System.out.println(promptFile.getSelectedFile().toString());
            archivo = new File(promptFile.getSelectedFile().toString());
        }
    }

    private void contarLineas() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        int i = 0;

        while (br.readLine() != null) {
            i++;
        }
        lineas = new String[i];
    }

    public String[] leerArchivo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String cadena;
            int i = 0;
            contarLineas();

            while ((cadena = br.readLine()) != null) {
                lineas[i] = cadena;
                i++;
                //System.out.println(cadena);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return lineas;
    }
}