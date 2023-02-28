package modelo;

import java.io.File;

public class Principal {

	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String ruta= "C:/Users/Grudges/eclipse-workspace/App Cero/src/modelo/Lexer.flex";
		
		generaLexer(ruta);
		
		

	}

	public static void generaLexer(String ruta) {
		
		
		File archivo= new File(ruta);
		JFlex.Main.generate(archivo);
		
		
	}
	
	
	
	
	
	
	
	
	
}
