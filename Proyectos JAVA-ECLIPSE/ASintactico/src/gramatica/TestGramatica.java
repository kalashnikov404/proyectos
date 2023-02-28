/*
 * LENGUAJES Y AUTOMATAS I - GRAMATICA (ANALISIS SINTACTICO)  (27-05-20)
 * Programa No. 04
 *por:
 *  GOMEZ GUIZAR CRISTIAN ROGELIO
 *  LOPEZ SOTO IVAN DE JESUS
 */
package gramatica;

public class TestGramatica {

    public static void main(String[] args) {
        try{
            Gramatica grama = new Gramatica();
            grama.leerGramatica();
            grama.imprimir();
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
    }
    
}
