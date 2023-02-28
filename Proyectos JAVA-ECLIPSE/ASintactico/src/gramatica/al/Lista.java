package gramatica.al;

public class Lista {
    protected Nodo inicio,fin;
    protected String tipo;
    protected int size;
    
    public Lista(){
        inicio = fin = null;
        this.tipo = null;
        this.size = 0;
    }
    
    public Lista(String tipo){
        inicio = fin = null;
        this.tipo = tipo;
        this.size = 0;
    }
    
    public void capturar(String simbolo){
        Nodo nuevo = new Nodo(simbolo,size);
            if(inicio == null){
                inicio = fin = nuevo;
            }else{
                fin.setSiguiente(nuevo);
                fin = nuevo;
            }
        size++;    
    }
    
    public void imprimir(){
        Nodo temp;
        temp = inicio;
        System.out.println(this.tipo);
        while (temp != null){
            String s = temp.getSimbolo();
            System.out.println(s);
            temp = temp.getSiguiente();
        }
    }
    
    
    public boolean existeSimbolo(String busqueda){
        boolean existe = false;
        Nodo temp = inicio;
        while(temp != null){
            
            if(temp.getSimbolo().equals(busqueda)){
                existe = true;
            }
            
            temp = temp.getSiguiente();
        }
        return existe;
    }
    
    
    public String getElemento(int indice){
        String elemento = null;
        Nodo temp = inicio;
        while(temp != null){
            
            if(temp.getIndice() == indice){
                elemento = temp.getSimbolo();
            }
            
            temp = temp.getSiguiente();
        }
        return elemento;
    }
    
    public int size(){
        return size;
    }
}
