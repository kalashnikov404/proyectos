package gramatica.al;

public class Nodo {
    
    protected Nodo siguiente;
    protected int indice;
    protected String simbolo;
    
    public Nodo (String simbolo,int indice){
        this.siguiente = null;
        this.simbolo = simbolo;
        this.indice = indice;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
}
