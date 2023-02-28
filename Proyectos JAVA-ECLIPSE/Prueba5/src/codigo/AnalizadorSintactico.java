
package codigo;

import static codigo.AnalizadorSemantico.arrayDatos;
import java.util.ArrayList;
import java.util.Stack;

public class AnalizadorSintactico {
  private ReglasProduccion reglasProduccion;
  public ListaConvertida listaLexemas = new ListaConvertida();
  public Nodo nodo;
  public static ArrayList<Nodo> arrayNodos= new ArrayList<>();
  AnalizadorSemantico analizadorSemantico= new AnalizadorSemantico();
  
  public String analizarSintaxis(String cadena){
      String salida="";
      String[] linea=cadena.split("Salto");
      String errores="";
      String lineasArchivo="";
     reglasProduccion.contador2=1;
     
      for (int i = 0; i < linea.length-1; i++) {
            Stack pilaE = new Stack();
            Stack pilaS = new Stack();
            //  System.err.println(linea[i]);
            pilaS=regla(linea[i], pilaE,i);             
            if (pilaS.get(0).equals("E")) {
                errores+="Error en la linea ("+(i+1)+") cerca del token "+pilaS.pop()+" "+ pilaS.pop()+"\n";
                System.out.println("Error en la linea ("+(i+1)+")");
            }else{
                salida+=reglasProduccion.salida;
                
            }
            
             // System.out.println("-----------------Pila final en iteracion------------------------");
            //    for (int j= 0; j < pilaS.size(); j++) {
            //      System.out.println(pilaS.get(j));   
            // }
            //  System.out.println("-------------------fin----------------------------");     
      }
       convierteArray(salida);
       reglasProduccion.generarArchivo(generarLista(arrayNodos));
      //Una vez que generamos nuestra lista nodos, la guaradamos en un array y lo mandamos al analizador semantico
      //Este lo recibira y decorara con su lexema (variable  o valor)
         
      return errores;
  }
   
   public int verificarDeclaracion(String id){
       for (int i = 0; i < arrayDatos.size(); i++) {
           if (arrayDatos.get(i).getId().equals(id) && !arrayDatos.get(i).getTipo().equals("A")) {
               return i;
           }   
       }
       return -1;
   }
      
      
    public Stack regla(String linea,Stack pilaE,int line){
        boolean salidaLinea = true;
        Stack pilaS= new Stack();
        reglasProduccion = new ReglasProduccion();
        
        String[] token = linea.split(" ");
          for (int j = 0; j < token.length; j++) {
          pilaS=reglasProduccion.introducirPila(pilaE, token[j],token.length,line);
          }
          return pilaS;
     }
    
    
    public void convierteArray(String salida){
          String lineas[]= salida.split("\n"); 
          for (int i = 0; i < lineas.length; i++) {
             
              nodo=new Nodo();
              lineas[i]=lineas[i].replace("(", "");
              lineas[i]=lineas[i].replace(")", "");
              lineas[i]=lineas[i].replace(" ", "");
              String linea[]=lineas[i].split(",");    
              nodo.setNumero(linea[0]);
              nodo.setId(linea[1]);        
              nodo.setPadre(linea[2]);
              nodo.setLinea(linea[3]);
              arrayNodos.add(nodo);
              
        }
          getPadre();
          
    }
    
    
    public void getPadre(){
        for (int i = 0; i < arrayNodos.size(); i++) {
        boolean bandera=true;
            if (arrayNodos.get(i).getId().equals("I")) {
                setPadre(arrayNodos.get(i).getNumero(), i, "BEGIN");
                setPadre(arrayNodos.get(i).getNumero(), i, "llave_a");
            }  
            if (arrayNodos.get(i).getId().equals("VALOR")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "tk_int");
               setPadre(arrayNodos.get(i).getNumero(), i, "tk_real"); 
            }
            
             if (arrayNodos.get(i).getId().equals("IDASIG")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "id"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "ASIG"); 
            }
             
              if (arrayNodos.get(i).getId().equals("TIPO")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "INTEGER"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "REAL"); 
             
            }
               
             if (arrayNodos.get(i).getId().equals("ASIG")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "id"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "igual"); 
                setPadre(arrayNodos.get(i).getNumero(), i, "VALOR"); 
                setPadre(arrayNodos.get(i).getNumero(), i, "OP"); 
            }
             
             if (arrayNodos.get(i).getId().equals("LISTA")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "LISTA"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "coma"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "IDASIG"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "OP"); 
            }
             
              if (arrayNodos.get(i).getId().equals("DECLARACION")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "TIPO"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "LISTA"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "dos_puntos"); 
            }
              
              if (arrayNodos.get(i).getId().equals("PALABRA")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "READ");
               setPadre(arrayNodos.get(i).getNumero(), i, "WRITE"); 
            }
              
                if (arrayNodos.get(i).getId().equals("PARAMETROS")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "parentesis_a");
               setPadre(arrayNodos.get(i).getNumero(), i, "id"); 
                setPadre(arrayNodos.get(i).getNumero(), i, "parentesis_c");
            }
                
             if (arrayNodos.get(i).getId().equals("ACCION")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "dos_puntos");
               setPadre(arrayNodos.get(i).getNumero(), i, "PALABRA");  
               setPadre(arrayNodos.get(i).getNumero(), i, "PARAMETROS"); 
            }   
             
             if (arrayNodos.get(i).getId().equals("COMBINACION")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "id");
               setPadre(arrayNodos.get(i).getNumero(), i, "coma");  
               setPadre(arrayNodos.get(i).getNumero(), i, "tk_int"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "tl_real");
                 setPadre(arrayNodos.get(i).getNumero(), i, "VALOR"); 
                 setPadre(arrayNodos.get(i).getNumero(), i, "OP"); 
               
            }   
             
               if (arrayNodos.get(i).getId().equals("PARAOPERACION")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "parentesis_a");
               setPadre(arrayNodos.get(i).getNumero(), i, "COMBINACION");  
               setPadre(arrayNodos.get(i).getNumero(), i, "parentesis_c"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "dos_puntos"); 
               
            }
               
               if (arrayNodos.get(i).getId().equals("OPERADOR")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "ADD");
               setPadre(arrayNodos.get(i).getNumero(), i, "SUB"); 
               setPadre(arrayNodos.get(i).getNumero(), i, "DIV");
               setPadre(arrayNodos.get(i).getNumero(), i, "MUL"); 
               
            }
               
               if (arrayNodos.get(i).getId().equals("OP")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "PARAOPERACION");
               setPadre(arrayNodos.get(i).getNumero(), i, "OPERADOR");  
              
            }
               if (arrayNodos.get(i).getId().equals("FIN")) {
               setPadre(arrayNodos.get(i).getNumero(), i, "Llave_c");
               setPadre(arrayNodos.get(i).getNumero(), i, "END");   
            }
        }
    } 
    public void setPadre(String padre, int tope, String hijo){
          for (int i = 0; i <tope; i++) {
              if (arrayNodos.get(i).getPadre().equals("0") && arrayNodos.get(i).getId().equals(hijo)) {
                  if (arrayNodos.get(i).getId().equals("tk_int") || arrayNodos.get(i).getId().equals("tk_real")) {
                      if (estaRepetido(arrayNodos.get(i).getId(), padre)) {
                           arrayNodos.get(i).setPadre(padre);
                      }
                  }
                  if (arrayNodos.get(i).getId().equals("ADD") || arrayNodos.get(i).getId().equals("SUB") || arrayNodos.get(i).getId().equals("MUL") || arrayNodos.get(i).getId().equals("DIV")) {
                      if (estaRepetido(arrayNodos.get(i).getId(), padre)) {
                           arrayNodos.get(i).setPadre(padre);
                      }
                  } else{
                      arrayNodos.get(i).setPadre(padre);
                  }
                  
              }
        }
    }
    
    public boolean estaRepetido(String token, String padre){
        for (int i = 0; i <arrayNodos.size() ; i++) {
            if (arrayNodos.get(i).getId().equals(token) && arrayNodos.get(i).getPadre().equals(padre)) {
             return false;   
            }
            
        }
        return true;
    }
    
    
    public String generarLista(ArrayList<Nodo> arrayNodos){
        String salida="";
        for (int i = 0; i < arrayNodos.size(); i++) {
           salida+=arrayNodos.get(i).getNumero()+","+ arrayNodos.get(i).getId()+","+arrayNodos.get(i).getPadre()+"\n";
            
        }
        
        return salida;
    }
    
}
