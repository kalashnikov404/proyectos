/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Rodrigo
 */
public class Archivo {
    private int numero;
    private String lexema;
    private int padre ;
  
    public Archivo(){}
  
    public Archivo(int numero, String lexema, int padre){
        this.numero = numero;
        this.lexema = lexema;
        this.padre = padre;
    }

   
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setLexema(String lexema){
        this.lexema = lexema;
    }
    public String getLexema(){
        return this.lexema;
    }
    public void setPadre(int padre){
        this.padre = padre;
    }
    public int getPadre(){
        return this.padre;
    }
   
}
