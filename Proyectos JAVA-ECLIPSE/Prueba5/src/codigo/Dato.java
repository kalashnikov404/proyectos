/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


public class Dato {
   
   private String id;
   private String tipo;
   private String valor;
  
   
   
   public Dato(String id, String tipo, String valor){
       this.id= id;
       this.tipo= tipo;
       this.valor=valor;
   }

    public Dato() { 
    }
   public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    } 
    
     public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    } 
    
}
