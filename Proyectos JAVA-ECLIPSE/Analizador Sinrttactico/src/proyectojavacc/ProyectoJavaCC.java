/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojavacc;

import Analizador.Gramatica;
import Analizador.ParseException;
import Analizador.TokenMgrError;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pavel
 */
public class ProyectoJavaCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Gramatica parser = new Gramatica(new BufferedReader(new FileReader("./entrada.txt")));
            parser.Analizar();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
            Logger.getLogger(ProyectoJavaCC.class.getName()).log(Level.SEVERE, "Error al intentar leer el archivo.", e);
        } catch(TokenMgrError e){
            System.err.println(e.getMessage());
        }
    }
    
}
