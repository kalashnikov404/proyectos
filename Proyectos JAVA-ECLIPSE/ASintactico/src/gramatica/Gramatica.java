package gramatica;

import gramatica.al.Lista;

public class Gramatica {
    protected Archivo archivo;
    public Lista producciones,noTerminales,terminales;
    protected String [] lineas;
    
    public Gramatica() throws Exception{
        this.archivo = new Archivo();
        this.archivo.abrirArchivo();
        this.producciones = new Lista("Producciones");
        this.noTerminales = new Lista("No terminales");
        this.terminales = new Lista("Terminales");
        this.lineas = this.archivo.leerArchivo();
    }
    
    public void leerGramatica(){
        this.getNoTerminales();
        this.getProducciones();
        this.getTerminales();
    }
    
    public void imprimir(){
        System.out.println("Gramatica");
        this.imprimirGramatica();
        System.out.println("");
        this.noTerminales.imprimir();
        System.out.println("");
        this.producciones.imprimir();
        System.out.println("");
       this.terminales.imprimir();
        
    }
    
    private void imprimirGramatica(){
        for(String linea:this.lineas){
            System.out.println(linea);
        }
    }
    
    private String obtenerLadoIzquierdo(String linea){
        String simbolo = "";
        char state = 'i';
        for(int i = 0; i<linea.length();i++){
            char car = linea.charAt(i);
            switch(state){
                case 'i':
                    if(car != '-' || car != ' ' || car != '\t'){
                        state = 's';
                        simbolo += car;
                    }else{
                        state = 'e';
                    }
                    break;
                case 's':
                    if(car == '-'){
                        state = '-';
                    }else if(car == ' ' || car == '\t'){
                        state = 'v';
                    }else{
                        simbolo += car;
                    }
                    break;
                case '-':
                    if(car == '>'){
                        state = '>';
                    }else{
                        state = 'e';
                    }
                    break;
                case 'v':
                    if(car == '-'){
                        state = '-';
                    }else if(car == ' ' || car == '\t'){
                        state = 'v';
                    }else{
                        state = 'e';
                    }
                    break;
                case 'e':
                    simbolo = null;
                    break;
            }
        }
        return simbolo;    
    }
    
    
    private void getNoTerminales(){
        for(String linea:lineas){
            String simbolo = this.obtenerLadoIzquierdo(linea);
            if(simbolo != null &&
                    !simbolo.equals("")
                    && !this.noTerminales.existeSimbolo(simbolo)){
                this.noTerminales.capturar(simbolo);
            }
        }
    }
    
    private String obtenerLadoDerecho(String linea){
        char state = 'i';
        String produccion = "";
        for(int i = 0;i<linea.length();i++){
            char car = linea.charAt(i);
            switch(state){
                case 'i':
                    if(car == '-'){
                        state = '-';
                    }
                    break;
                case '-':
                    if(car == '>'){
                        state = '>';
                    }else{
                        state = 'e';
                    }
                    break;
                case '>':
                    if(car == ' ' || car == '\t'){
                        state = 's';
                    }else {
                        state = 'e';
                    }
                    break;
                case 's':
                    if(car != '\n' || i <= linea.length()-1){
                        produccion += car;
                    }else{
                        state = 'e';
                    }
                    break;
                case 'e':
                    produccion = null;
                    break;
            }
        }
        
        return produccion;
    }
    
    private void getProducciones(){
        for(String linea:lineas){
            String simbolo = this.obtenerLadoDerecho(linea);
            if(simbolo != null
                    && !this.terminales.existeSimbolo(simbolo)){
                this.producciones.capturar(simbolo.trim());
            }
        }
    }
    
    private void getTerminales(){
        for(int k = 0;k < this.producciones.size();k++){
            String produccion = this.producciones.getElemento(k);
            String terminal = "";
            for(int j = 0;j<produccion.length();j++){
                char car = produccion.charAt(j);
                
                if(car == ' ' || car == '\t'){
                    this.guardarTerminal(terminal);
                    terminal = "";
                    
                }else{
                    terminal += car;
                    if( j == produccion.length() -1){
                        this.guardarTerminal(terminal);
                    }
                    
                }
                
            }
        }
    }
    
    private void guardarTerminal(String terminal){
        
        if(!terminal.equals("") && 
            !this.noTerminales.existeSimbolo(terminal) &&
            !this.terminales.existeSimbolo(terminal)){
             
        this.terminales.capturar(terminal);
                        
        }
    }
    
}
