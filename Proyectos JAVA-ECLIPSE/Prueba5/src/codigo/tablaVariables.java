/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class tablaVariables {
    public static ArrayList<String> tablaV = new ArrayList<String>();   
    public static void agregarRenglon(String id, String tipo, String valor){
       String line=id+","+tipo+","+valor;
       tablaV.add(line);
    }  
    public static void Imprimir(){
        for (int i = 0; i < tablaV.size(); i++) {
            System.out.println(tablaV.get(i));        
        }    
      }
    
    public static ArrayList getArray(){
        return tablaV;
    }
    }
