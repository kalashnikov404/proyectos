package asintactico;

import Stack.StackListaDoble;
import al.Analizador;
import al.IndiceCodigos;
import al.Token;
import gramatica.Gramatica;
import matriz.MatrizPre;

public class LlDriver implements IndiceCodigos {

    protected StackListaDoble stack;
    protected Gramatica gramar;
    protected MatrizPre mat;
    protected int matriz[][];
    protected Analizador anal;
    protected Token a;
    protected String x;
    protected boolean error;

    public LlDriver() throws Exception {
        gramar = new Gramatica();
        mat = new MatrizPre();
        stack = new StackListaDoble();
        matriz = mat.getMatriz();
        anal = new Analizador();
        error = false;
    }

    public void Ejecuta() {
        gramar.leerGramatica();
        gramar.imprimir();
        System.out.println("");
        System.out.println("");
        System.out.println("Matriz predictiva");
        mat.imprimirMatriz();
        System.out.println("");
        System.out.println("");
        System.out.println("Programa a analizar");
        this.imprimirCodigo();
        System.out.println("");
        System.out.println("");
        System.out.println("Corrida de analizador sintactico");
        this.liAlgoritmo();
    }

    private void liAlgoritmo() {

        stack.push(gramar.noTerminales.getElemento(0));

        x = stack.top();

        a = anal.obtenerToken();

        while (!stack.isEmpty() && !error) {
            if (gramar.noTerminales.existeSimbolo(x)) {

                if (predict(x, a) != 0) {
                    stack.pop();
                    produccion(predict(x, a));
                    x = stack.top();
                } else {
                    System.out.println("Error de sintaxis");
                    error = true;
                }

            } else {

                if (match(x, a)) {
                    stack.pop();
                    x = stack.top();
                    System.out.println(a.getLexema() + " ");
                    a = anal.obtenerToken();
                } else {
                    System.out.println("Error de sintaxis");
                    error = true;
                }

            }
        }

    }

    private int predict(String x, Token a) {
        int indice_x = -1;
        int indice_a = -1;

        for (int i = 0; i < gramar.noTerminales.size(); i++) {
            if (gramar.noTerminales.getElemento(i).equals(x)) {
                indice_x = i;
            }
        }

        for (int j = 0; j < gramar.terminales.size(); j++) {
            if (gramar.terminales.getElemento(j).equals(a.getLexema())) {
                indice_a = j;
            } else if (a.getAtributo() == ID 
                    && gramar.terminales.getElemento(j).equals(a.getClasficacion())
                   ) {
                indice_a = j;
            } else if (a.getAtributo() == INT 
                    && gramar.terminales.getElemento(j).equals(a.getClasficacion())) {
                indice_a = j;
            } else if (a.getAtributo() == DECIMAL 
                    && gramar.terminales.getElemento(j).equals(a.getClasficacion())) {
                indice_a = j;
            }
        }

        if (indice_x != -1 && indice_a != -1) {
            return matriz[indice_x][indice_a];
        } else {
            return 0;
        }

    }

    private void produccion(int produccionIndex) {

        String ladoIzq = gramar.producciones.getElemento(produccionIndex - 1);

        String prod = "";

        for (int i = ladoIzq.length() - 1; i >= 0; i--) {
            if (ladoIzq.charAt(i) == ' ') {
                stack.push(prod);
                prod = "";
            } else if (i == 0) {
                prod = ladoIzq.charAt(i) + prod;
                stack.push(prod);
            } else {
                prod = ladoIzq.charAt(i) + prod;
            }
        }
    }

    private void imprimirCodigo() {
        for (String s : anal.getLineas()) {
            System.out.println(s);
        }
    }

    private boolean match(String x, Token a) {

        boolean matchExito = false;

        if (x.equals(a.getLexema())) {
            matchExito = true;
        }

        if (a.getAtributo() == ID) {
            matchExito = x.equals(a.getClasficacion());
        }

        if (a.getAtributo() == INT) {
            matchExito = x.equals(a.getClasficacion());
        }

        if (a.getAtributo() == DECIMAL) {
            matchExito = x.equals(a.getClasficacion());
        }

        if (a.getAtributo() == ERROR) {
            matchExito = false;
            error = true;
        }

        return matchExito;
    }

}
