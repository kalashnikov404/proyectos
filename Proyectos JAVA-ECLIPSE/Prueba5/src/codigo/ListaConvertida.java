package codigo;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rodrigo
 */
public class ListaConvertida {
    public static  ArrayList<String> listaVar = new ArrayList<String>();
    public static  ArrayList<String> listaValores = new ArrayList<String>();
    public static  ArrayList<String> listaED = new ArrayList<String>();
    
    public ArrayList<String> convertir(ArrayList<String> tokens) {
        listaED.clear();
        listaValores.clear();
        listaVar.clear();
        ReglasProduccion.punteroVar=0;
        
        ReglasProduccion.punteroVal=0;
        AnalizadorSemantico.arrayDatos.clear();
        AnalizadorSintactico.arrayNodos.clear();
        AnalizadorSemantico.erroresTipo.clear();
     
        
        String patonVar = new String("(([a-z][0-9])|([a-z][0-9][0-9])|[a-z][0-9][0-9][0-9])");
        Pattern patronV = Pattern.compile(patonVar);
        String patronEntero = new String("([0-9])|([0-9][0-9])|([0-9][0-9][0-9])|([0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9])");
        Pattern patronE = Pattern.compile(patronEntero);
        String patronDecimal = new String("(([0-9]{1,5})[.]([0-9][0-9]))|(([0-9]{1,5})[.]([0-9]))");
        Pattern patronD = Pattern.compile(patronDecimal);
        String patronSimbolo = new String("[(|)]|[{]|[}]|[;]|[,]|[.]|[=]");
        Pattern patronS = Pattern.compile(patronSimbolo);
        String patronPalabra = new String("(END)|(BEGIN)|(ADD)|(INTEGER)|(WRITE)|(REAL)|(READ)|(SUB)|(MUL)|(DIV)");
        Pattern patronP = Pattern.compile(patronPalabra);
        ArrayList<String> listaConvertida = new ArrayList<String>();

        for (int i = 0; i < tokens.size(); i++) {
            Matcher mat;
            mat = patronV.matcher(tokens.get(i));
            if (mat.matches()) {
                tokens.add("id " + tokens.get(i));//identificador
                listaConvertida.add("id");
                listaVar.add(tokens.get(i));
                
            }
            mat = patronE.matcher(tokens.get(i));
            if (mat.matches()) {
                listaConvertida.add("VALOR");
                listaValores.add(tokens.get(i));
             
            }
            mat = patronD.matcher(tokens.get(i));
            if (mat.matches()) {
                listaConvertida.add("VALOR");
                listaValores.add(tokens.get(i));
                //System.out.println(listaTokens.get(i)+" Es un decimal");
            }
            mat = patronS.matcher(tokens.get(i));
            if (mat.matches()) {

                if (tokens.get(i).equals("{")) {
                    listaConvertida.add("llave_a");
                }

                if (tokens.get(i).equals("}")) {
                    listaConvertida.add("llave_c");
                }

                if (tokens.get(i).equals("=")) {
                    listaConvertida.add("igual");
                }

                if (tokens.get(i).equals(";")) {
                    listaConvertida.add("dos_puntos");
                }

                if (tokens.get(i).equals(",")) {
                    listaConvertida.add("coma");
                }

                if (tokens.get(i).equals("(")) {
                    listaConvertida.add("parentesis_a");
                }
                if (tokens.get(i).equals(")")) {
                    listaConvertida.add("parentesis_c");
                }

            }
            mat = patronP.matcher(tokens.get(i));
            if (mat.matches()) {
                if (tokens.get(i).equals("INTEGER")) {
                    listaConvertida.add("INTEGER");
                }
                if (tokens.get(i).equals("BEGIN")) {
                    listaConvertida.add("BEGIN");
                }
                if (tokens.get(i).equals("ADD")) {
                    listaConvertida.add("ADD");
                }
                if (tokens.get(i).equals("SUB")) {
                    listaConvertida.add("SUB");
                }
                if (tokens.get(i).equals("DIV")) {
                    listaConvertida.add("DIV");
                }
                if (tokens.get(i).equals("MUL")) {
                    listaConvertida.add("MUL");
                }
                if (tokens.get(i).equals("END")) {
                    listaConvertida.add("END");
                }
                if (tokens.get(i).equals("REAL")) {
                    listaConvertida.add("REAL");
                }
                if (tokens.get(i).equals("READ")) {
                    listaConvertida.add("READ");
                }
                if (tokens.get(i).equals("WRITE")) {
                    listaConvertida.add("WRITE");
                }
                //System.out.println(" Es una palabra");
                
            }
            if (tokens.get(i).equals("Salto")) {
                listaConvertida.add("Salto");
            }
        }
        return listaConvertida;
    }
    
  
}
