package al;

public interface Reglas {
    
    public static String MAYUSCULA = "[A-Z]";
    public static String MINUSCULA = "[a-z]";
    public static String DIGITO = "[0-9]";
    public static String [] RESERVADAS = {"programa","begin","end"};
    public static char [] ESPECIALES = {'(',')','-','+',';','*'};
    public static char IGUAL = '=';
    public static char DOS_PUNTOS = ':';
    public static char PUNTO = '.';
    public static char GUIONBAJO = '_';
    
}