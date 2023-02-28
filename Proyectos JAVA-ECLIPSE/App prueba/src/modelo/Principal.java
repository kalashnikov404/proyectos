/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "C:/Users/Grudges/eclipse-workspace/App lexico/Lexer.flex";
//        String ruta = "C:/Users/Charly Ponce/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        jflex.Main.generate(archivo);
    }
}
