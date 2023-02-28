package modelo;

public class NodoArbol
{
    NodoArbol nodoizquierdo;
    int datos;
    NodoArbol nododerecho;
    
    public NodoArbol(int datosNodo)
    {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null; 
    }
    
    public synchronized void insertar(int valorInsertar)
    {
        if(valorInsertar < datos)
        {
            if(nodoizquierdo == null)
                nodoizquierdo = new NodoArbol(valorInsertar);
            else    
                nodoizquierdo.insertar(valorInsertar);
        }
        
        else if(valorInsertar > datos)
        {
            
            if(nododerecho == null)
                nododerecho = new NodoArbol(valorInsertar);
            else
                nododerecho.insertar(valorInsertar);
        }
    } 
}