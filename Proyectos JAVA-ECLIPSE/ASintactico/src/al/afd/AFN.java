package al.afd;

import java.io.IOException;

public class AFN implements Cloneable {

    protected String alfabeto;
    protected int noEstados;
    protected String estadoInicial;
    protected String estadosFinales;
    protected Node[] estados;
    protected LeerAFN leer;
    protected String[]  lineas;
    protected int index = 0;
    
    
    public AFN(){
        this.leer = new LeerAFN();
        try{
            this.leer.abrirArchivo();
        }catch(IOException e){
            e.getMessage();
        }
        
        this.lineas = this.leer.leerArchivo();
        this.asignarValores();
    }
    
    public AFN(String alfabeto, int noEstados) {
        this.alfabeto = alfabeto;
        this.noEstados = noEstados;
        this.estadoInicial = "";
        this.estadosFinales = "";
        estados = new Node[noEstados];
    }
    
    private void asignarValores(){
        for(int i = 0; i < lineas.length;i++){
            if(i == 0){
             this.alfabeto = lineas[i];   
            }
            
            if(i == 1){
                this.noEstados = Integer.parseInt(lineas[i]);
                this.estados = new Node[this.noEstados];
            }
            
            if(i == 2){
                this.estadoInicial = lineas[i];
            }
            
            if(i == 3){
                this.estadosFinales = lineas[i];
            }
            
            if(i >3){
                this.llenarEstado(lineas[i],index++);
            }
            
        }
    }
    
    
    private void llenarEstado(String linea, int index){
        estados[index] = new Node();
        String[] tmpData = linea.split("@");
        String[] infoEstado = tmpData[1].split(",");
        estados[index].setNombre(tmpData[0]);
        for(int j = 0;j<infoEstado.length;j++){
            if(j == 0){
                estados[index].setInicial(infoEstado[j].equals("1"));
            }
            if(j == 1){
                estados[index].setFina(infoEstado[j].equals("1"));
            }
            if(j > 1){
                estados[index].setNuevaTransicion(infoEstado[j]);
            }
        }
    }

    public Node obtenerNodo(String nombreNodo) {
        Node estado = null;
        for (Node tmp : this.estados) {
            if (tmp.getNombre().equals(nombreNodo)) {
                estado = tmp;
            }
        }
        return estado;
    }

    public Node obtenerNodoInicial() {
        Node estado = null;
        for (Node tmp : this.estados) {
            if (tmp.inicial) {
                estado = tmp;
            }
        }
        return estado;
    }

    public boolean nodoEsFinal(Node n) {
        boolean f = false;
        for (Node tmp : this.estados) {
            if (n.fina == true) {
                f = true;
            }
        }
        return f;
    }

    public boolean eliminarNodo(Node n) {
        boolean eliminado = false;
        try {
            Node[] nn = new Node[noEstados - 1];
            int k = 0;
            for (int i = 0; i < noEstados; i++) {
                if (!estados[i].nombre.equals(n.nombre)) {
                    nn[k] = estados[i];
                    k++;
                } else {
                    eliminado = true;
                }
            }
            estados = nn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eliminado;
    }
    
    public void setEstadoInicial(String ei) {
        this.estadoInicial = ei;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public int getNoEstados() {
        return noEstados;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String getEstadosFinales() {
        return estadosFinales;
    }

    public Node[] getEstados() {
        return estados;
    }
    
    public void imprimirAutomata() {
        for (int i = 0; i < noEstados; i++) {
            String edoTransiciones = "";
            edoTransiciones = ("El estado " + estados[i].getNombre() + " va hacia --> \n");
            for (String s : this.alfabeto.split(",")) {
                //edoTransiciones += " en " + s + "\n"
                String es = estados[i].getTransicionDeSimbolo(s);
                if(es != null){
                    edoTransiciones += ( es + " en " + s + "\n");                
                }
            }
            System.out.println(" " + edoTransiciones);
        }
    }
}