package matriz;

import java.io.IOException;

public class MatrizPre {

    protected LeerMatriz leer;
    protected String[] lineas;
    protected int index = 0;
    private int matriz[][];

    public MatrizPre() {
        matriz = new int[8][13];
        this.leer = new LeerMatriz();
        try {
            this.leer.abrirArchivo();
        } catch (IOException e) {
            e.getMessage();
        }

        this.lineas = this.leer.leerArchivo();
        this.asignarValores();
    }

    private void asignarValores() {
        for (String linea : lineas) {
            String[] row = linea.split(",");
            String[] column = row[1].split("@");
            int r = Integer.parseInt(row[0]);
            int c = Integer.parseInt(column[0]);
            int value = Integer.parseInt(column[1]);
            matriz[r][c] = value;
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    public void imprimirMatriz(){
        for (int x = 0; x < matriz.length; x++) {
            System.out.println("");
            for (int y = 0; y < matriz[0].length; y++) {
                System.out.print("[" +matriz[x][y]+ "] " );
            }
        }
        
    }
    
}
