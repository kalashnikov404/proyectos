package al;

import al.afd.AFN;
import al.afd.Node;
import al.lista.Lista;

public class Analizador implements IndiceCodigos {

    protected Archivo archivo;
    protected Lista errores, identificadores, general, reservadas, especiales, digitos, operadoresEspeciales;
    protected String[] lineas;
    protected String lexema;
    protected AFN afn;
    protected String estado;
    protected String linea;
    protected int fin;
    protected Node tmp;
    protected boolean findToken;
    protected int indiceLineas;
    protected int contReservada = 600;
    protected int ID_TOKEN;
    protected Token token;

    /**
     *
     * @throws Exception
     */
    public Analizador() throws Exception {
        this.archivo = new Archivo();
        this.archivo.abrirArchivo();
        this.errores = new Lista("Errores");
        this.identificadores = new Lista("Identificadores");
        this.operadoresEspeciales = new Lista("Operador Especial");
        this.general = new Lista("General");
        this.reservadas = new Lista("Reservadas");
        this.especiales = new Lista("Especiales");
        this.digitos = new Lista("Digitos");
        this.lineas = this.archivo.leerArchivo();
        this.lexema = "";
        this.fin = 0;
        this.indiceLineas = 0;
        this.linea = "";
        this.findToken = true;
        this.estado = "q0";
        this.afn = new AFN();
    }

    public Token obtenerToken() {

        this.lexema = "";
        this.estado = "q0";
        this.findToken = true;
        tmp = null;

        if (lineas.length > indiceLineas) {
            if ((linea.length() == fin || linea.equals(""))) {
                linea = lineas[indiceLineas++];
                fin = 0;
            }

            analizar();
        }

        return token;
    }

    public void analizar() {

        while (findToken) {
            switch (this.estado) {
                case "q0":
                    tmp = this.afn.obtenerNodo("q0");
                    if (ERegular.esMayuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MAYUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.esMinuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MINUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.esEspecial(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(linea.charAt(fin)));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        this.agregarEspecial(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.espacioBlanco(linea.charAt(fin))) {
                        this.estado = "q0";
                        if (fin == linea.length() - 1) {
                           linea = lineas[indiceLineas++];
                           fin = 0;
                           continue;
                        }
                        fin++;
                    } else if (ERegular.esDosPuntos(linea.charAt(fin))) {
                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.DOS_PUNTOS));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;
                    } else {
                        this.lexema += String.valueOf(linea.charAt(fin));
                        this.agregarLista(errores, lexema, 500, "Error");
                        this.lexema = "";
                        this.estado = "q0";
                        fin++;
                    }
                    break;

                case "q1":
                    tmp = this.afn.obtenerNodo("q1");
                    if (ERegular.esMayuscula(linea.charAt(fin))) {
                        this.agregarError();
                        fin--;

                    } else if (ERegular.esMinuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MINUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.esEspecial(linea.charAt(fin))) {

                        this.agregarError();
                        fin--;

                    } else if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.esGuionBajo(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.GUIONBAJO));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;

                    } else if (ERegular.espacioBlanco(linea.charAt(fin))) {

                        this.agregarError();
                        fin++;
                    } else {
                        this.agregarError();
                        fin--;
                    }
                    break;

                case "q2":
                    tmp = this.afn.obtenerNodo("q2");
                    if (ERegular.esMinuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MINUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));

                        if (fin == linea.length() - 1) {
                            this.agregarIdentificador();
                        }
                        fin++;

                    } else if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarIdentificador();
                        }
                        fin++;

                    } else if (ERegular.esGuionBajo(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.GUIONBAJO));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarIdentificador();
                        }
                        fin++;
                    } else {

                        this.agregarIdentificador();
                    }
                    break;

                case "q3":
                    tmp = this.afn.obtenerNodo("q3");
                    if (ERegular.esMayuscula(linea.charAt(fin))) {
                        this.agregarError();
                        fin--;

                    } else if (ERegular.esMinuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MINUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarIdentificador();
                        }
                        fin++;

                    } else if (ERegular.esEspecial(linea.charAt(fin))) {

                        this.agregarError();
                        fin--;

                    } else if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarIdentificador();
                        }
                        fin++;

                    } else if (ERegular.esGuionBajo(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.GUIONBAJO));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarError();
                        }
                        fin++;

                    } else if (ERegular.espacioBlanco(linea.charAt(fin))) {

                        this.agregarError();
                        fin++;

                    } else {
                        this.agregarError();
                        fin--;
                    }
                    break;

                case "q4":
                    tmp = this.afn.obtenerNodo("q4");
                    if (ERegular.esMinuscula(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.MINUSCULA);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarPalabra();
                        }
                        fin++;

                    } else {
                        this.agregarPalabra();

                    }
                    break;

                case "q5":
                    tmp = this.afn.obtenerNodo("q5");
                    if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarDigito("intliteral", 257);
                        }
                        fin++;

                    } else if (ERegular.esPunto(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.PUNTO));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        fin++;
                    } else {
                        this.agregarDigito("intliteral", 257);
                    }
                    break;

                case "q6":
                    tmp = this.afn.obtenerNodo("q6");
                    if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarDigito("realliteral", 258);
                        }
                        fin++;

                    } else {
                        this.agregarError();
                        fin--;
                    }
                    break;

                case "q7":
                    tmp = this.afn.obtenerNodo("q7");
                    if (ERegular.esDigito(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(ERegular.DIGITO);
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarDigito("realliteral", 258);
                        }
                        fin++;

                    } else {
                        this.agregarDigito("realliteral", 258);
                    }
                    break;
                case "q9":
                    tmp = this.afn.obtenerNodo("q9");
                    if (ERegular.esIgual(linea.charAt(fin))) {

                        this.estado = tmp.getTransicionDeSimbolo(String.valueOf(ERegular.IGUAL));
                        this.lexema += String.valueOf(linea.charAt(fin));
                        if (fin == linea.length() - 1) {
                            this.agregarOperadorEspecial();
                        }
                        fin++;

                    } else {
                        this.agregarError();
                        fin--;
                    }
                    break;
                case "q10":
                    if (fin == linea.length() - 1) {
                        this.agregarOperadorEspecial();
                        fin++;
                    } else {
                        this.agregarOperadorEspecial();
                    }
                    break;
            }
        }
    }

    public void imprimir() {
        this.identificadores.imprimir();
        System.out.println("");
        this.reservadas.imprimir();
        System.out.println("");
        this.digitos.imprimir();
        System.out.println("");
        this.especiales.imprimir();
        System.out.println("");
        this.errores.imprimir();
        System.out.println("");
        this.general.imprimir();
    }

    private void agregarEspecial(char c) {
        this.agregarLista(especiales, lexema, (int) c, "Caracter especial");
        this.agregarLista(general, lexema, (int) c, "Caracter especial");
        this.lexema = "";
        this.estado = "q0";
    }

    private void agregarDigito(String clasificacion, int atributo) {
        this.agregarLista(digitos, lexema, atributo, clasificacion);
        this.agregarLista(general, lexema, atributo, clasificacion);
        this.lexema = "";
        this.estado = "q0";
    }

    private void agregarPalabra() {
        if (ERegular.esReservada(lexema)) {
            this.agregarLista(reservadas, lexema, contReservada, "Palabra reservada");
            this.agregarLista(general, lexema, contReservada++, "Palabra reservada");
            this.lexema = "";
            this.estado = "q0";
        } else {
            this.agregarError();
        }
    }

    private void agregarIdentificador() {
        this.agregarLista(identificadores, lexema, 295, "id");
        this.agregarLista(general, lexema, 295, "id");
        this.lexema = "";
        this.estado = "q0";
    }

    private void agregarOperadorEspecial() {
        this.agregarLista(operadoresEspeciales, lexema, 297, "Operador Especial");
        this.agregarLista(general, lexema, 297, "Operador Especial");
        this.lexema = "";
        this.estado = "q0";
    }

    private void agregarError() {
        this.agregarLista(errores, lexema, 500, "Error");
        this.lexema = "";
        this.estado = "q0";
    }

    private void agregarLista(Lista lista, String cadena,
            int atributo, String clasificacion) {
        this.token = new Token(cadena, atributo, clasificacion);
        this.ID_TOKEN = atributo;
        this.findToken = false;
        lista.capturar(token);
    }
    
    public String[] getLineas(){
        return this.lineas;
    }

}
