/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizador {
    //Pattern nos dira si contiene los caracteres
	String patonVar=new String("(([a-z][0-9])|([a-z][0-9][0-9])|[a-z][0-9][0-9][0-9])");
	Pattern patronV=Pattern.compile(patonVar);
	String patronEntero=new String("([0-9])|([0-9][0-9])|([0-9][0-9][0-9])|([0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9])");
	Pattern patronE=Pattern.compile(patronEntero);
	String patronDecimal=new String("(([0-9]{1,5})[.]([0-9][0-9]))|(([0-9]{1,5})[.]([0-9]))");
	Pattern patronD=Pattern.compile(patronDecimal);
	String patronSimbolo=new String("[(|)]|[{]|[}]|[;]|[,]|[.]|[=]");
	Pattern patronS=Pattern.compile(patronSimbolo);
	String patronPalabra=new String("(END)|(BEGIN)|(ADD)|(INTEGER)|(WRITE)|(REAL)|(READ)|(SUB)|(MUL)|(DIV)");
	Pattern patronP=Pattern.compile(patronPalabra);
	ArrayList<String > listaT=new ArrayList<String>();
	ArrayList<String > listaE=new ArrayList<String>();
	ArrayList<String > listaST=new ArrayList<String>();
        ArrayList<String> listaVar=new ArrayList<String>();
	public void getTokens(ArrayList<String> listaTokens){
		Matcher mat;
		boolean band=false;
		for (int i = 0; i < listaTokens.size(); i++) {
			band=false;
			 mat=patronV.matcher(listaTokens.get(i));
			if (mat.matches()) {
				listaT.add("id "+listaTokens.get(i));//identificador
				listaST.add("id");
				if (listaVar.contains(listaTokens.get(i))) {
					
				}else
			           listaVar.add(listaTokens.get(i));
				//System.out.println(listaTokens.get(i)+" Es una variable");
				band=true;
			}
			mat=patronE.matcher(listaTokens.get(i));
			if (mat.matches()) {
				listaT.add("num "+listaTokens.get(i));
				listaST.add("num");
				//System.out.println(listaTokens.get(i)+" Es un entero");
				band=true;
			}
			mat=patronD.matcher(listaTokens.get(i));
			if (mat.matches()) {
				listaT.add("dec "+listaTokens.get(i));
				listaST.add("dec");
				//System.out.println(listaTokens.get(i)+" Es un decimal");
				band=true;
			}
			mat=patronS.matcher(listaTokens.get(i));
			if (mat.matches()) {
				listaT.add(listaTokens.get(i)+" "+listaTokens.get(i));
				listaST.add(listaTokens.get(i));
				//System.out.println(listaTokens.get(i)+" Es un simbolo");
				band=true;
			}
			mat=patronP.matcher(listaTokens.get(i));
			if (mat.matches()) {
				listaT.add(listaTokens.get(i)+" "+listaTokens.get(i));
				listaST.add(listaTokens.get(i));
				//System.out.println(listaTokens.get(i)+" Es una palabra");
				band=true;
			}
			if (!band) {
				if (listaTokens.get(i).equals("")) {
					
				}else
					listaE.add(listaTokens.get(i));
				//System.out.println(listaTokens.get(i)+" No pertenece al lenguaje");
			}
			
		}
	}
	public ArrayList<String> getListaT(){
		ArrayList<String> listaM=new ArrayList<String>();
		for (String string : listaT) {
			if (string.contains(";")|string.contains("{")|string.contains("END")) {
				listaM.add(string);
				listaM.add("$");
			}else{
				if (string.contains("/")|string.contains("*")) {
				}else{
					//System.out.println(string);
					listaM.add(string);
				}
			}
		}
		return listaM;
	}
	public ArrayList<String> getErrores(){
		return listaE;	
	}
	public ArrayList<String> getSoloT(){
		ArrayList<String> listaM=new ArrayList<String>();
		for (String string : listaST) {
			if (string.equals(";")|string.equals("{")|string.equals("END")) {
				listaM.add(string);
				listaM.add("$");
			}else{
				if (string.equals("/")|string.equals("*")) {
				}else{
					listaM.add(string);
				}
			}
		}
		return listaM;
	}
	public ArrayList<String> getVar(){
		return listaVar;
	}
}
