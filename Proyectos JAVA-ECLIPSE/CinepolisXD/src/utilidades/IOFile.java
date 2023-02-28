package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class IOFile {

	public static Vector<String> getOpciones(String origen) {
		File file = new File(origen);
		try {
			Scanner entrada = new Scanner(file);
			Vector<String> opciones = new Vector<String>();
			while (entrada.hasNext()) {
				opciones.add(entrada.nextLine());

			}
			return opciones;
		} catch (FileNotFoundException e) {
			return null;
		}

	}

	
}
