package al.afd;

import java.util.HashMap;
import java.util.Map;

public class Node {

    protected String nombre;
    protected boolean inicial, fina;
    //protected Node apuntado;
    protected Map<String, String> transiciones;
    
    public Node(){
        this.transiciones = new HashMap();
    }

    public Node(String name, boolean i, boolean f) {
        this.nombre = name;
        this.inicial = i;
        this.fina = f;
        this.transiciones = new HashMap();
    }
    
    public void setNuevaTransicion(String data){
        String[] tmp = data.split("#");
        this.transiciones.put(tmp[0],tmp[1]);
    }
    
    public String getTransicionDeSimbolo(String simbolo){
        return this.transiciones.get(simbolo);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInicial(boolean inicial) {
        this.inicial = inicial;
    }

    public void setFina(boolean fina) {
        this.fina = fina;
    }

    public void setTransiciones(Map<String, String> transiciones) {
        this.transiciones = transiciones;
    }
    
    public String getNombre() {
        return nombre;
    }

    public boolean isInicial() {
        return inicial;
    }

    public boolean isFina() {
        return fina;
    }

    public Map<String, String> getTransiciones() {
        return transiciones;
    }
}