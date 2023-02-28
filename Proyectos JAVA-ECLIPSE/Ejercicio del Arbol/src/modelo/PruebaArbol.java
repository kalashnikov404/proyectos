package modelo;

import javax.swing.JOptionPane;

public class PruebaArbol
{
    public static void main(String args [])
    {
        Arbol arbol = new Arbol();
        int valor;
        String Dato;
        
        System.out.println("Insertando los siguientes valores en la estructura del arbol: ");
        
        Dato = JOptionPane.showInputDialog("Ingresa la longitud de nodos del arbol!");
        int n = Integer.parseInt(Dato);
        
        for(int i = 1; i <= n; i++ )
        {
            Dato = JOptionPane.showInputDialog("Ingresa el " + i + " valor para introducir en la estructura del arbol");
            valor = Integer.parseInt(Dato);
            System.out.print(valor + " ");
            arbol.insertarNodo(valor);
        }
        
        
        
        
        
        System.out.println("\n\nEl recorrido del arbol en postorden es: ");
        arbol.recorridoPosorden();
        
        System.out.println("\n\nEl recorrido del arbol en inorden es: ");
        arbol.recorridoInorden();
        
        System.out.println("\n\nEl recorrido del arbol en preorden es: ");
        arbol.recorridoPreorden();
    }
}