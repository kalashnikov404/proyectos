/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;


public class Nodo {
   private String numero;
   private String id;
   private String padre;
   private String linea;
  
   
   
   public Nodo(String numero, String id, String padre,String linea){
       this.numero= numero;
       this.id= id;
       this.padre=padre;
       this.linea=linea;
   }

    public Nodo() { 
    }
   public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    } 
    
     public String getPadre() {
        return padre;
    }
    public void setPadre(String padre) {
        this.padre = padre;
    } 
    
     public String getLinea() {
        return linea;
    }
    public void setLinea(String linea) {
        this.linea = linea;
    } 
    
}
