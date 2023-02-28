package al;

public class ERegular implements Reglas {
    
    public static boolean esMayuscula(char c){
        String s = String.valueOf(c);
        
        return s.matches(MAYUSCULA);
    }
    
    public static boolean esMinuscula(char c){
        String s = String.valueOf(c);
        
        return s.matches(MINUSCULA);
    }
    
    public static boolean esDigito(char c){
        String s = String.valueOf(c);
        
        return s.matches(DIGITO);
    }
    
    public static boolean esPunto(char c){ 
        return c == PUNTO;
    }
    
    public static boolean esIgual(char c){ 
        return c == IGUAL;
    }
    
    public static boolean esDosPuntos(char c){ 
        return c == DOS_PUNTOS;
    }
    
     public static boolean esGuionBajo(char c){ 
        return c == GUIONBAJO;
    }
     
     public static boolean espacioBlanco(char c){ 
         String s = String.valueOf(c);
        
        return s.equals("") || s.equals(" ") || s.equals("\n") || s.equals("\t");
    } 
    
    public static boolean esReservada(String cadena){
        
        boolean es = false;
        
        for(String tmp:RESERVADAS){
            if(tmp.equals(cadena)){
                es = true;
            }
        }
        
        return es;
    }
    
    public static boolean esEspecial(char c){
        boolean es = false;
        
        for(char tmp:ESPECIALES){
            
            if(tmp == c){
                es = true;
            }
        }
        
        return es;
    }
    
}