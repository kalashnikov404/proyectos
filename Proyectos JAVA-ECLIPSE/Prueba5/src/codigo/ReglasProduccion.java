/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rodrigo
 */
public class ReglasProduccion {
      ListaConvertida variable= new ListaConvertida();
      static  tablaVariables tb= new tablaVariables();
      ArrayList<Archivo> listaSalida = new ArrayList<>();
      public  static int punteroVar=0;
     
      public static int punteroVal=0;
      public  String tipo="";
      public  String salida="";
      private String tokenDos_puntos="";
      private String token="";
      private String tokenOp="";
      private String tokenAux3="";
      private String tokenAux="";
      private String tokenTipo="";
      private Stack pilaParentesis = new Stack();
      private int contador=0;
      public static int contador2=1;
      private Stack pilaFinal = new Stack();
      private Stack errores = new Stack();
     
      AnalizadorSemantico as= new AnalizadorSemantico();
      public Stack evaluarPila(Stack pila, int tamanio,int line){
         contador++;
         line+=1;
        // System.err.println(line);
         boolean booleano=false;
          String tipoToken="tk_real";       
                 for (int i = 0; i < pila.size(); i++) {
                      token+=pila.pop()+"/";
                  }
                     // System.out.println(token);
                         
                       if (token.equals("BEGIN/llave_a/")) {
                       //  System.out.println("Cumple con Regla I");
                       token="";
                       pilaFinal.push("I");
                      /// System.out.println("I");
                       //Codigo para mandar al Archivo
                       salida+="("+contador2+"),BEGIN,0,"+line+" \n";
                       contador2++;
                       salida+="("+contador2+"),llave_a,0,"+line+" \n";
                       contador2++;
                       salida+="("+contador2+"),I,0,"+line+" \n";
                       contador2++;
                       }
                       
                       
                       if (token.equals("/INTEGER/") || token.equals("/REAL/")) {
                       //Codigo para mandar al Archivo
                       salida+="("+contador2+"),"+token.replaceAll("/","")+",0,"+line+" \n";
                       tipo=token;
                       contador2++;
                       token="TIPO/";
                       tokenTipo="TIPO/";
                      /// System.out.println("TIPO");
                     
                        //  System.out.println("Cumple con Regla TIPO");
                       }
    
                       
                       if (token.equals("TIPO/id/igual/VALOR/coma/")) {
                          token="TIPO/";    
                          // System.out.println("ASIG");
                           //System.out.println("IDASIG");
                          tokenAux+=("IDASIG/");
                          if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                             tipoToken="tk_int";
                            }else{
                              tipoToken="tk_real";
                          }
                             //Codigo para mandar al Archivo
                          salida+="("+contador2+"),"+tipoToken+",0,"+line+" \n";
                          contador2++;
                          salida+="("+contador2+"),"+"VALOR,0,"+line+" \n";
                          contador2++;
                          salida+="("+contador2+"),"+"igual,0,"+line+" \n";
                          contador2++;
                          salida+="("+contador2+"),"+"id,0,"+line+" \n";
                          contador2++;
                           salida+="("+contador2+"),"+"ASIG,0,"+line+" \n";
                          contador2++;
                            
                             //Codigo para mandar a la tabla de valores 
                            
                            tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroVar),tipo.replaceAll("/",""), (String) ListaConvertida.listaValores.get(punteroVal));
                            punteroVal++;
                            punteroVar++;
                        //  System.out.println("Cumple con Regla IDASIG");
                       }
                       
                       
                       if (token.equals("TIPO/id/igual/VALOR/dos_puntos/") ) {
                          token="";  
                          tokenDos_puntos="dos_puntos";
                          tokenAux+=("IDASIG/");
                          //System.out.println("ASIG");
                          //System.out.println("IDASIG");
                          //Codigo para mandar al Archivo
                           if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                             tipoToken="tk_int";
                            }else{
                               tipoToken="tk_real";
                           }
                             //Codigo para mandar al Archivo
                          salida+="("+contador2+"),"+tipoToken+",0,"+line+" \n";
                          salida+="("+contador2+"),"+"VALOR,0,"+line+" \n";
                          contador2++;
                          salida+="("+contador2+"),"+"igual,0,"+line+" \n";
                          contador2++;
                          salida+="("+contador2+"),"+"id,0,"+line+" \n";
                          contador2++;
                           salida+="("+contador2+"),"+"ASIG,0,"+line+" \n";
                          contador2++;
                            //Codigo para mandar a la tabla de valores
                           tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroVar),tipo.replaceAll("/",""), (String) ListaConvertida.listaValores.get(punteroVal));
                           punteroVal++;
                           punteroVar++;
                          
                       }
                       
                       
                       if (token.equals("TIPO/id/coma/") || token.equals("TIPO/coma/id/")){
                             token="TIPO/";
                             tokenAux+=("LISTA/");
                            // System.out.println("IDASIG");
                             salida+="("+contador2+"),"+"id,0,"+line+" \n";
                             contador2++;
                             //System.out.println("LISTA");
                             salida+="("+contador2+"),"+"IDASIG,0,"+line+" \n";
                             contador2++;
                             tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroVar),tipo.replaceAll("/",""), "-");
                             punteroVar++;
                           
                          // System.out.println("Cumple con Regla IDASIG");
                       }
                       
                       if (token.equals("TIPO/id/dos_puntos/")) {
                            token="";
                            tokenDos_puntos="dos_puntos";
                            tokenAux+=("LISTA/");
                           // System.out.println("id");
                            salida+="("+contador2+"),"+"id,0,"+line+" \n";
                            tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroVar),tipo.replaceAll("/",""), "-");
                            punteroVar++;
                            contador2++;
                            salida+="("+contador2+"),"+"IDASIG,0,"+line+" \n";
                            contador2++;
                           
                          //  tb.Imprimir();a          
                       }
                       
                     
                       if (token.equals("/READ/") || token.equals("/WRITE/")) {
                       tokenAux="/PALABRA/";
                      // System.out.println("PALABRA");
                       salida+="("+contador2+"),"+token.replaceAll("/","")+",0,"+line+" \n";
                       token="";
                          contador2++;
                  
                       }

                       if (token.equals("VALOR/parentesis_c/") || token.equals("id/parentesis_c/")) {
                           if (!pilaParentesis.isEmpty()) {
                             if (pilaParentesis.pop().equals("parentesis_a/")) {
                              if (tokenAux.equals("/PALABRA/")) {
                               String[] vecTo=token.split("/");
                                  if (vecTo[0].equals("VALOR")) {
                                      salida+="("+contador2+"),"+ListaConvertida.listaValores.get(ListaConvertida.listaValores.size()-1)+",0,"+line+"\n";
                                      punteroVal++;
                                      contador2++;
                                  }
                               token="PALABRA/PARAMETROS/";    
                                //System.out.println(token);
                                salida+="("+contador2+"),parentesis_a,0,"+line+" \n";
                                   contador2++;
                                salida+="("+contador2+"),"+vecTo[0]+",0,"+line+" \n";
                                   contador2++;
                                salida+="("+contador2+"),parentesis_c,0,"+line+" \n";
                                   contador2++;  
                                   
                                tokenAux="";
                           //  System.out.println("Cumple con Regla PARAMETROS");
                              }
                           }   
                         }  
                       }
                       
                       
                       if (token.equals("PALABRA/PARAMETROS/dos_puntos/")) {
                       token="";    
                       pilaFinal.push("ACCION");
                      // System.out.println("ACCION");
                        salida+="("+contador2+"),"+"PARAMETROS,0,"+line+" \n";
                        contador2++;  
                        salida+="("+contador2+"),"+"PALABRA,0,"+line+" \n";
                        contador2++;
                        salida+="("+contador2+"),"+"ACCION,0 ,"+line+"\n";
                        contador2++;    
                          
                           //  System.out.println("Cumple con Regla ACCION");
                       }
                       
                      
                      if (token.equals("/id/igual/")) {
                          tokenAux3+="/id/igual/";
                          token="";
                         }
                       if (token.equals("ADD/") || token.equals("SUB/") || token.equals("DIV/") || token.equals("MUL/")) {     
                           token=token.replace("/","");
                         salida+="("+contador2+"), "+token+",0,"+line+" \n";
                             contador2++;
                          tokenOp+="OPERADOR";        
                          token="";
                         // System.out.println(tokenAux3+tokenOp);   
                         
                          //   System.out.println("Cumple con Regla ACCION");
                       }
                       
                       if (token.equals("parentesis_a/")) {
                               pilaParentesis.push(token);
                               token="";
                             
                       }
                       
                    
                       
                       if (token.equals("id/coma/id/") || token.equals("OP/coma/OP/") || token.equals("VALOR/coma/id/") || token.equals("id/coma/VALOR/")||
                           token.equals("OP/coma/id/") || token.equals("id/coma/OP/") || token.equals("VALOR/coma/OP/") || token.equals("OP/coma/VALOR/") || token.equals("VALOR/coma/VALOR/")) {
                               // System.out.println("COMBINACION");
                                
                           if (!pilaParentesis.isEmpty()) {
                               if (pilaParentesis.pop().equals("parentesis_a/")) {
                               
                                   String[] vecTo=token.split("/");
                                   if (vecTo[0].equals("VALOR")) {
                                    
                                       if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                                               tipoToken="tk_int";
                                        }else{
                                           tipoToken="tk_real";
                                       }
                                       salida+="("+contador2+"),"+tipoToken+",0,"+line+"\n";
                                       punteroVal++;
                                       contador2++;                  
                                   }
                                   
                                   if (vecTo[2].equals("VALOR")) {
                                       
                                        if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                                               tipoToken="tk_int";
                                        }else{
                                            tipoToken="tk_real";
                                        }
                                       salida+="("+contador2+"),"+tipoToken+",0,"+line+"\n";
                                       punteroVal++;
                                       contador2++;
                                   }
                                 
                                  salida+="("+contador2+"),"+vecTo[0]+",0,"+line+" \n";
                                  contador2++;
                                  salida+="("+contador2+"),"+vecTo[1]+",0,"+line+" \n";
                                  contador2++;
                                  salida+="("+contador2+"),"+vecTo[2]+",0,"+line+" \n";
                                  contador2++;
                                  token="parentesis_a/COMBINACION/";                   
                               }
                               
                           }
                        }
                       
                       
                       if (token.equals("parentesis_a/COMBINACION/parentesis_c/dos_puntos/")) {
                           if (tokenOp.equals("OPERADOR")) {
                             //  System.out.println(tokenAux3+tokenOp+"/PARAOPERACION");
                               salida+="("+contador2+"),parentesis_a,0,"+line+" \n";
                               contador2++;
                            //   System.out.println(tokenAux3+"OP");
                               salida+="("+contador2+"),COMBINACION,0,"+line+" \n";
                               contador2++;
                             //  System.out.println("ASIG");
                               salida+="("+contador2+"),parentesis_c,0,"+line+" \n";
                               contador2++;
                               pilaFinal.push("ASIG");
                               salida+="("+contador2+"),dos_puntos,0,"+line+"\n";
                               contador2++;
                               salida+="("+contador2+"),PARAOPERACION,0,"+line+"\n";
                               contador2++;
                               salida+="("+contador2+"),"+tokenOp+",0,"+line+"\n";
                               contador2++;
                               salida+="("+contador2+"),"+"OP,0,"+line+" \n";
                               contador2++;
                               salida+="("+contador2+"),"+"igual,0,"+line+" \n";
                               contador2++;  
                               salida+="("+contador2+"),"+"id,0,"+line+"\n";
                               contador2++;  
                               salida+="("+contador2+"),"+"ASIG,0,"+line+"\n";
                               contador2++;   
                               token="";    
                               tokenAux="";
                              // tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroPila2),"A","0");
                               //punteroPila2--;
                           }
                       }
                       
                       if (token.equals("parentesis_a/COMBINACION/parentesis_c/parentesis_c/")) {
                           //System.out.println(tokenOp+"/PARAOPERACION");
                             salida+="("+contador2+"),parentesis_c,0,"+line+"\n";
                              contador2++;
                              
                              salida+="("+contador2+"),COMBINACION,0,"+line+"\n";
                              contador2++;
                              
                              salida+="("+contador2+"),parentesis_a,0,"+line+" \n";
                              contador2++;
                              salida+="("+contador2+"),PARAOPERACION,0,"+line+" \n";
                              contador2++;
                              salida+="("+contador2+"),"+tokenOp+",0,"+line+"\n";
                              contador2++;
                             
                            //  System.out.println("OP");
                         
                            String[] vecTo=tokenAux.split("/");
                            //System.err.println(tokenAux);
                                   if (vecTo[0].equals("VALOR")) {
                                       if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                                               tipoToken="tk_int";
                                        }else{
                                           tipoToken="tk_real";
                                       }
                                       salida+="("+contador2+"),"+tipoToken+",0,"+line+"\n";
                                       punteroVal++;
                                       contador2++;       
                                   }
                                    salida+="("+contador2+"),"+"OP,0,"+line+"\n";
                                    contador2++;
                                    salida+="("+contador2+"),coma,0,"+line+"\n";
                                    contador2++;
                                    salida+="("+contador2+"),"+vecTo[0]+",0,"+line+" \n";
                                    contador2++;
                                   
                           if (!pilaParentesis.isEmpty()) {
                                 token="parentesis_a/COMBINACION/parentesis_c/"; 
                           }else{
                               token+="";
                           }
                         
                          
                       }
                       
                       if (token.equals("id/coma/SUB/") || token.equals("id/coma/ADD/") || token.equals("id/coma/DIV/") || token.equals("id/coma/MUL/")
                               || token.equals("VALOR/coma/SUB/") || token.equals("VALOR/coma/ADD/") || token.equals("VALOR/coma/DIV/") || token.equals("VALOR/coma/MUL/")) {
                           String[] vecTo=token.split("/");
                           salida+="("+contador2+"),"+vecTo[2]+",0,"+line+" \n";
                           contador2++;
                           tokenAux=vecTo[0]+"/coma/";
                           tokenOp="OPERADOR";
                           token="";
                        }
                       
                        if (token.equals("/llave_c/END/")) {
                         token="";    
                         pilaFinal.push("FIN");
                        // System.out.println("FIN");
                           salida+="("+contador2+"),"+"END,0,"+line+" \n";
                             contador2++;
                           salida+="("+contador2+"),"+"Llave_c,0,"+line+"\n";
                            contador2++;
                           salida+="("+contador2+"),"+"FIN,0,"+line+" \n";
                            contador2++;
                         //  System.out.println("Cumple con Regla ACCION");
                       }
                         if (token.equals("VALOR/dos_puntos/")) {
                              if (tokenAux3.equals("/id/igual/")) {
                        //   System.out.println(tokenAux3+token);
                           tb.agregarRenglon((String) ListaConvertida.listaVar.get(punteroVar),"A", (String) ListaConvertida.listaValores.get(punteroVal));
                             if (as.esEntero((String) ListaConvertida.listaValores.get(punteroVal))) {
                             tipoToken="tk_int";
                           
                            }
                                salida+="("+contador2+"),"+tipoToken+",0,"+line+"\n";
                              
                                contador2++;
                                 salida+="("+contador2+"),"+"VALOR,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"igual,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"id,0,"+line+" \n";
                                 contador2++;
                                  salida+="("+contador2+"),"+"ASIG,0,"+line+" \n";
                                 contador2++;
                             //   System.out.println("ASIG");
                                pilaFinal.push("ASIG");
                                token="";
                                 punteroVal++;
                                 punteroVar++;
                                
                            }
                     }
                   
                    
                            if (contador==tamanio) {      
                                if (!token.isEmpty()) {
                                    try {
                                         String[] tokensE=token.split("/");
                                         errores.push("E");
                                         errores.push(tokensE[1]);
                                         errores.push(tokensE[0]);
                                
                                    } catch (Exception e) {
                                          errores.push("E");
                                          errores.push("Falta ;");
                                          errores.push("VALOR");
                                    }
                                      return errores; 
                                }
                            }
                            
                   if (tokenAux.equals("LISTA/IDASIG/") || tokenAux.equals("IDASIG/LISTA/") || tokenAux.equals("LISTA/LISTA/")) {
                     
                       if (tokenAux.equals("LISTA/IDASIG/")) {
                           salida+="("+contador2+"),IDASIG,0,"+line+" \n";
                           contador2++;
                           salida+="("+contador2+"),coma,0,"+line+" \n";
                           contador2++;
                           salida+="("+contador2+"),LISTA,0,"+line+" \n";
                           contador2++; 
                       }
                       
                       if (tokenAux.equals("IDASIG/LISTA/")) {
                           salida+="("+contador2+"),LISTA,0,"+line+" \n";
                           contador2++;
                           salida+="("+contador2+"),coma,0,"+line+" \n";
                           contador2++;
                           salida+="("+contador2+"),IDASIG,0,"+line+" \n";
                           contador2++; 
                       }
                       
                       
                       
                       if (tokenAux.equals("LISTA/LISTA/")) {
//                          
                           salida+="("+contador2+"),coma,0,"+line+" \n";
                           contador2++;
                           salida+="("+contador2+"),LISTA,0,"+line+" \n";
                           contador2++; 
                       }
                    //   System.out.println(tokenTipo+tokenAux);
                       tokenAux="LISTA/";   
                     //  System.out.println("TIPO/"+"LISTA");
                       
                    }
                   
                  
                
                    if (contador==tamanio) {
                 if ((tokenTipo+=tokenAux+=tokenDos_puntos).equals("TIPO/LISTA/dos_puntos")) {
                                 //System.out.println("TIPO/LISTA/dos_puntos");
                                 salida+="("+contador2+"),"+"dos_puntos,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"LISTA,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"TIPO,0,"+line+"\n";
                                 contador2++;
                                 pilaFinal.push("DECLARACION");
                                 salida+="("+contador2+")"+",DECLARACION,0,"+line+" \n";
                                 contador2++;
                                 tokenDos_puntos="";
                                 tokenAux="";
                          }
                          
                        if (tokenTipo.equals("TIPO/IDASIG/dos_puntos")) {
                                 salida+="("+contador2+"),"+"IDASIG,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"dos_puntos,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"LISTA,0,"+line+" \n";
                                 contador2++;
                                 salida+="("+contador2+"),"+"TIPO,0,"+line+"\n";
                                 contador2++;
                                 pilaFinal.push("DECLARACION");
                                 salida+="("+contador2+") "+",DECLARACION,0,"+line+" \n";
                                 contador2++;
                                 tokenDos_puntos="";
                                 tokenAux="";
                       }
                       }
                 return pilaFinal;                 
    }
    
    public Stack introducirPila(Stack pila, String token, int tamanio,int line){
        boolean boleano= true;     
        pila.push(token);    
     //   System.out.println("Entra a pila el sig "+ token);
        pila=evaluarPila(pila,tamanio,line);    
        
        return pila;
    }
    
    public Stack regresarPila(String tokenPila){
        String[] vectorPila=tokenPila.split("/");
        Stack pila = new Stack();
        for (int i = 0; i <vectorPila.length; i++) {
            if (!vectorPila[i].isEmpty()) {
                    //System.out.println("Regresando a pila "+i+" "+ vectorPila[i]); 
                     pila.push(vectorPila[i]);
                     
            } 
        }
        return pila;
    }
    
   
        //Metodo para generar el archivo
    public  void generarArchivo(String contenido){
            try {
            String ruta = "C:/Users/52715/Documents/salida.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
