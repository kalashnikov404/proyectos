
package codigo;

import static codigo.ListaConvertida.listaValores;
import java.sql.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalizadorSemantico {
        public Dato dato;
        public static ArrayList<Dato> arrayDatos= new ArrayList<>();
        public static ListaConvertida listaLexemas = new ListaConvertida();
        String patronEntero = new String("([0-9])|([0-9][0-9])|([0-9][0-9][0-9])|([0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9])");
        Pattern patronE = Pattern.compile(patronEntero);
        String patronDecimal = new String("(([0-9]{1,5})[.]([0-9][0-9]))|(([0-9]{1,5})[.]([0-9]))");
        Pattern patronD = Pattern.compile(patronDecimal);
       
      public  static  ArrayList<Error> erroresTipo = new ArrayList<Error>();
     
 
    public ArrayList<Error> decorarLista(ArrayList<Nodo> arrayNodos , ArrayList<String> listaVar,ArrayList<String> listaV){
        convertirTabla(listaV);
       /// Verifica los Tipos de datos en la declaracion
        for (int i = 0; i < arrayDatos.size(); i++) {
            System.out.println(arrayDatos.get(i).getId());
             Matcher mat;
          mat = patronE.matcher(arrayDatos.get(i).getValor());
            if (mat.matches()) {
                if (!arrayDatos.get(i).getTipo().equals("INTEGER")&& !arrayDatos.get(i).getTipo().equals("A")) {
                    int error2=Integer.parseInt(arrayNodos.get(i).getLinea());
                    error2=error2+1;
                    String s="";
                    s+=error2;
                    Error error = new Error(s, "Error cerca de "+ arrayDatos.get(i).getValor()+" tipo de dato incorrecto.");
                    erroresTipo.add(error);
                }
            }
            mat = patronD.matcher(arrayDatos.get(i).getValor());
            if (mat.matches()) {
               if (!arrayDatos.get(i).getTipo().equals("REAL")&& !arrayDatos.get(i).getTipo().equals("A")) {
                    int error2=Integer.parseInt(arrayNodos.get(i).getLinea());
                    error2=error2+1;
                    String s="";
                    s+=error2;
                   Error error = new Error(s, "Error cerca de "+ arrayDatos.get(i).getValor()+" tipo de dato incorrecto.");
                   erroresTipo.add(error);
                }
            }
            try {
                for (int j = 0; j < arrayDatos.size(); j++) {
                if (arrayDatos.get(i).getId().equals(arrayDatos.get(j).getId()) && !(i==j)) {
                    if (verificarErrores("1")) {
                       Error error = new Error(arrayNodos.get(i).getLinea(), "Error el id ya se encuentra declarado.");
                       erroresTipo.add(error);
                    }
                }
                
            }
                
            } catch (Exception e) {
            }
            
             
           //Verificamos que los valores que se asignen esten declarados y que sean del mismo tipo 
           if (arrayDatos.get(i).getTipo().equals("A")) {   
                if (verificarDeclaracion(arrayDatos.get(i).getId())>=0) {
                    int posDeclaracion=verificarDeclaracion(arrayDatos.get(i).getId());
                       if (verificarTipo(posDeclaracion, i)) {
                           arrayDatos.get(posDeclaracion).setValor(arrayDatos.get(i).getValor());
                    }else{
                            int error2=Integer.parseInt(arrayNodos.get(i).getLinea());
                    error2=error2+1;
                    String s="";
                    s+=error2;
                            Error error = new Error(s, "El "+ arrayDatos.get(i).getId()+"  es de tipo incorrecto .");
                            erroresTipo.add(error);
                        
                       }
                }else{
                     int error2=Integer.parseInt(arrayNodos.get(i).getLinea());
                    error2=error2+1;
                    String s="";
                    s+=error2;
                      Error error = new Error(s, "El "+ arrayDatos.get(i).getId()+"  no esta declarado.");
                      erroresTipo.add(error);
                 
                }
            }

       }
    
          int  punteroVar=0;
          int  punteroVal=0;
       for (int i = 0; i < arrayNodos.size(); i++) {
           if (arrayNodos.get(i).getId().equals("id")) {
               if (verificarDeclaracion(listaVar.get(punteroVar))>=0) {
                   int posDeclaracion=verificarDeclaracion(listaVar.get(punteroVar));
                   String var=" id\n \t"+ listaVar.get(punteroVar)+"\t\n \t"+arrayDatos.get(posDeclaracion).getTipo()+"\n";
                   arrayNodos.get(i).setId(var);
                   punteroVar++;
               }else{
                   if (verificarErrores(arrayNodos.get(i).getLinea())) {
                      Error error = new Error(arrayNodos.get(i).getLinea(), "El "+ listaVar.get(punteroVar)+"  no esta declarado.");
                      erroresTipo.add(error);
                      punteroVar++;
                   }
                  
                 
                } 
           }
           if (arrayNodos.get(i).getId().equals("tk_int")) {
                String var=" tk_int \n \t INTEGER \t\n \t "+listaLexemas.listaValores.get(punteroVal)+"\n";
                   arrayNodos.get(i).setId(var);
                   punteroVal++;
           }
           if (arrayNodos.get(i).getId().equals("tk_real")) {
                  String var=" tk_real\n \t REAL \t\n \t "+listaLexemas.listaValores.get(punteroVal)+"\n";
                   arrayNodos.get(i).setId(var);
                   punteroVal++;
           }
           if (arrayNodos.get(i).getId().equals("VALOR")) {
               String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
               nuevoId=quitarId(nuevoId,1);
                String var="VALOR \n "+nuevoId;
                  arrayNodos.get(i).setId(var);
           }
           
            if (arrayNodos.get(i).getId().equals("IDASIG")) {
                String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
                nuevoId=quitarId(nuevoId,1);
                String var="IDASIG \n "+nuevoId;
                arrayNodos.get(i).setId(var);
           }
            
            if (arrayNodos.get(i).getId().equals("COMBINACION")) {
                
                
             String tipo=validarCombinacion(arrayNodos, arrayNodos.get(i).getNumero(),arrayNodos.get(i).getLinea());
                 String var="COMBINACION \n \t"+tipo;
                 arrayNodos.get(i).setId(var);
             }
            
            if (arrayNodos.get(i).getId().equals("PARAOPERACION")) {
               String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
               nuevoId=quitarId(nuevoId,1);
               String var="PARAOPERACION \n "+nuevoId;
               arrayNodos.get(i).setId(var);
           }
            
            if (arrayNodos.get(i).getId().equals("OP")) {
               String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
               nuevoId=quitarId(nuevoId,1);
               String var="OP \n "+nuevoId;
               arrayNodos.get(i).setId(var);   
           }
            
             if (arrayNodos.get(i).getId().equals("ASIG")) {
               String numero=arrayNodos.get(i).getNumero();
               String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
               nuevoId=quitarId(nuevoId,2);
               validarTipoHijo(numero,nuevoId, arrayNodos);
               String var="ASIG \n "+nuevoId;
               arrayNodos.get(i).setId(var);
           }
             
             if (arrayNodos.get(i).getId().equals("LISTA")) {
               String nuevoId=gethijo(arrayNodos.get(i).getNumero(), arrayNodos);
               nuevoId=quitarId(nuevoId,2);
               String var="LISTA \n "+nuevoId;
               arrayNodos.get(i).setId(var);
           }
       }
       return erroresTipo;
   }
    
    public void validarTipoHijo(String padre,String tipo,ArrayList<Nodo> arrayNodos){
        try {
            for (int i = 0; i < arrayNodos.size(); i++) {
                if (arrayNodos.get(i).getPadre().equals(padre) && !arrayNodos.get(i).getId().equals("igual")) {
                    String[] vect=arrayNodos.get(i).getId().split("\n");
                    vect[0]=vect[0].trim();
                    if (vect[0].equals("OP")) {
                        vect[1]=vect[1].trim();
                        tipo=tipo.trim();
                     //   System.out.println("Tipo: "+tipo);
                      //  System.out.println("Op: "+vect[1]);
                        String[] vector={tipo,vect[1]};
                          if (!validarTipos(vector)) {
                              if (verificarErrores(arrayNodos.get(i).getLinea())) {
                                 Error error = new Error(arrayNodos.get(i).getLinea(), "Error en las Operaciones tipos de dato diferentes");
                                erroresTipo.add(error);    
                              }
                        
                           }  
                   }    
                }   
            }
        } catch (Exception e) {
        }
       
                  
    }
 
    
    public String gethijo(String padre,ArrayList<Nodo> arrayNodos){
        String nuevoPadre="";
           for (int i = 0; i < arrayNodos.size(); i++) {
               if (arrayNodos.get(i).getPadre().equals(padre)) {
                   if (!arrayNodos.get(i).getId().equals("coma") && !arrayNodos.get(i).getId().equals("dos_puntos") &&
                       !arrayNodos.get(i).getId().equals("parentesis_a") &&!arrayNodos.get(i).getId().equals("parentesis_c") &&
                       !arrayNodos.get(i).getId().equals("OPERADOR")    ) {
                       nuevoPadre=arrayNodos.get(i).getId();
                   }
                  
               }
        }
           return nuevoPadre;
    }
    
    public String quitarId(String cadena, int indice){
        String[] vector=cadena.split("\n");
        String salida="";
        for (int i = indice; i < vector.length; i++) {
           salida+=vector[i]+="\n";
        }
        return salida;
        
    }
   
   
   public String ImprimirErroresTipo(){
       String salida="";
       for (int i = 0; i < erroresTipo.size(); i++) {
          // System.out.println(erroresSintacticos.get(i));
           salida+="Error en la linea ("+erroresTipo.get(i).getLinea()+")  "+erroresTipo.get(i).getTipo()+"\n";
       }
       return salida;
   }
   
   
   public boolean esEntero(String token){
       Matcher mat;
          mat = patronE.matcher(token);
            if (mat.matches()) {
             return true;
            }
            mat = patronD.matcher(token);
            if (mat.matches()) {
              return false;
            }
            return true;
   }
   
   public int verificarDeclaracion(String id){
       for (int i = 0; i < arrayDatos.size(); i++) {
           if (arrayDatos.get(i).getId().equals(id) && !arrayDatos.get(i).getTipo().equals("A")) {
               return i;
           }   
       }
       return -1;
   }
   
   
   public void convertirTabla(ArrayList<String> listaV){
         arrayDatos.clear();
          for (int i = 0; i < listaV.size(); i++) {   
              dato = new Dato();
              String linea[]= listaV.get(i).split(","); 
              dato.setId(linea[0]);
              dato.setTipo(linea[1]);    
              dato.setValor(linea[2]);
              arrayDatos.add(dato);
     }
   }
   
   public boolean verificarTipo(int posDeclaracion,int posAsign){  
    
       if (arrayDatos.get(posDeclaracion).getTipo().equals("INTEGER")) {
           if (esEntero(arrayDatos.get(posAsign).getValor())) {
               return true;
           }
       }     
       if (arrayDatos.get(posDeclaracion).getTipo().equals("REAL")) {
           if (!esEntero(arrayDatos.get(posAsign).getValor()) ||arrayDatos.get(posAsign).getValor().equals("0")) {
               return true;
           }
       }
       return false;
   }
   
   public String validarCombinacion(ArrayList<Nodo> arrayNodos,String padre,String linea){
       String[] vectTipo= new String[2];
       int contador=0;
        String tipo="";
       for (int i = 0; i < arrayNodos.size(); i++) {
           if (arrayNodos.get(i).getPadre().equals(padre) && !arrayNodos.get(i).getId().equals("coma")) {
               String[] vector=arrayNodos.get(i).getId().split("\n");
               if (vector.length>1) {
                    vector[0]=vector[0].trim();
                   if (vector[0].equals("VALOR")) {
                       vector[1]=vector[1].trim();
                       vectTipo[contador]=vector[1];
                       contador++;
                   }
                   if (vector[0].equals("id")) {
                   
                      vector[2]=vector[2].trim();
                      vectTipo[contador]=vector[2];
                      contador++;
                   }
                   
                   if (vector[0].equals("OP")) {
                       vector[1]=vector[1].trim();
                       vectTipo[contador]=vector[1];
                       contador++;
                        
                   }
               } 
           }   
       }
       
      
       if (!validarTipos(vectTipo)) {
           if (verificarErrores(linea)) {
            Error error = new Error(linea, "Error en las Operaciones tipos de dato diferentes");
             erroresTipo.add(error);   
           }
           
            
       }else{
           tipo=vectTipo[0];
       }
       return tipo;
   }
   
   public boolean validarTipos(String [] vector){
       try {
            if (vector[0].equals("INTEGER") && vector[1].equals("INTEGER")) {
        return true;   
       }
       if (vector[0].equals("REAL") && vector[1].equals("REAL")) {
        return true;   
       }
      
       } catch (Exception e) {
        
       }
       return false;
   }
   
   
   public void pintarTablaValores(){ 
       for (int i = 0; i < arrayDatos.size(); i++) {
           if (!arrayDatos.get(i).getTipo().equals("A")) {
                 System.out.println(arrayDatos.get(i).getId()+","+arrayDatos.get(i).getTipo()+","+ arrayDatos.get(i).getValor());
           }
              
           
       }
   }
   
   public boolean verificarErrores(String linea){
       for (int i = 0; i < erroresTipo.size(); i++) {
           if (erroresTipo.get(i).getLinea().equals(linea)) {
               return false;
           }
           
       }
       return true;
   }

}
