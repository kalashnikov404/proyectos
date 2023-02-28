package al.lista;

import al.Token;

public class Lista {
    protected Nodo inicio,fin;
    protected String tipo;
    public Lista(){
        inicio = fin = null;
        this.tipo = null;
    }
    
    public Lista(String tipo){
        inicio = fin = null;
        this.tipo = tipo;
    }
    
    public void capturar(Token token){
        Nodo t = new Nodo(token);
        boolean contiene = false;
        Nodo temp;
        temp = inicio;
        
        while (temp != null){
            if(t.toString().equals(temp.toString())){
                contiene=true;
            }
            temp = temp.getSiguiente();
        }
        if(contiene==false){
            if(inicio == null){
                inicio = fin = t;
            }else{
                fin.setSiguiente(t);
                fin = t;
            }
        }
    }
   
    
    public void imprimir(){
        Nodo temp;
        temp = inicio;
        System.out.println(this.tipo);
        System.out.println("Lexema\t|Clasificacion\t|Atributo");
        while (temp != null){
            String s = temp.toString();
            System.out.println(s);
            temp = temp.getSiguiente();
        }
    }
    
    public int size(){
        Nodo temp;
        temp = inicio;
        int cont = 0;
        while(temp != null){
            cont++;
            temp = temp.getSiguiente();
        }
        return cont;
    }
}