
package Stack;


public class Nodo_doble {
    String valor;
        Nodo_doble der;
        Nodo_doble izq;
        
        Nodo_doble (){
            valor = null;
            der = izq = null;          
        }
        Nodo_doble (String valor){
            this.valor = valor;
            der = izq = null;
        }

   
}
