package al.lista;

import al.Token;

public class Nodo {
   protected Token token;
   protected Nodo siguiente;
   
   public Nodo (Token token){
       this.token = token;
       siguiente = null;
   }

    public Token getToken() {
        return token;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        return  this.token.toString();
    }   
}