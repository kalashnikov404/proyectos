/*
 * LENGUAJES Y AUTOMATAS I - ANALIZADOR LEXICO (13-05-20)
 * Programa No. 03
 *por:
 *  GOMEZ GUIZAR CRISTIAN ROGELIO
 *  LOPEZ SOTO IVAN DE JESUS
 */
package al;

public class ALTest {

    public static void main(String[] args) {
        try{
            Analizador anal = new Analizador();
            anal.analizar();
            anal.imprimir();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}