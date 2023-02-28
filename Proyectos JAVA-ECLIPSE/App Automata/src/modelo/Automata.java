package modelo;

import javax.swing.JOptionPane;

public class Automata {

	 private static final int Q0 = 0;//Variables
	 private static final int Q1 = 1;
	 private static final int Q2 = 2;
	 private static final int Q3 = 3;
	 private static final int Q4 = 4;
	 private static final int Q5 = 5;
	 private static final int Q6 = 6;
	 private static final int Q7 = 7;
	 private static final int Q8 = 8;
	 private static final int Q9 = 9;
	 private static final int Q10 = 10;
	 private static final int Q11 = 11;
	 private static final int Q12 = 12;
	 
	 private int state;
	 public StringBuilder buffer;

	 public Automata() {//Estado Inicial
	  state = Q0;
	 }

	 public int getState() {//Estado Final
	  return state;
	  
	 }
	
	 
	 

	 public boolean accept(String str, boolean debug) {//Metodo de Estado de Aceptación Q11.
	  init();
	  for (char c : str.toCharArray()) {
	   int previousState = state;
	   appendChar(c);
	   System.out.println("'" + c + "' " + getStateName(previousState) + " -> " + getStateName(state));
	  }
	 return state == Q11;

	 }
	 
	 
	 public boolean accept2(String str, boolean debug) {//Metodo de Estado de Aceptación Q12.
		  init();
		  for (char c : str.toCharArray()) {
		   int previousState = state;
		   appendChar(c);
		   System.out.println("'" + c + "' " + getStateName(previousState) + " -> " + getStateName(state));
		  }
		  return state == Q12;
		 }

	 private void init() {//Inicio de Estados
	  state = Q0;
	  buffer = new StringBuilder();
	 }

	 private String getStateName(int stateToGet) {//Asignaciones de nombres de estados..
	  String stateName = "";
	  switch (stateToGet) {
	   case Q0:
	    stateName = "Q0";
	    break;
	   case Q1:
	    stateName = "Q1";
	    break;
	   case Q2:
	    stateName = "Q2";
	    break;
	   case Q3:
	    stateName = "Q3";
	    break;
	   case Q4:
		stateName = "Q4";
		break;
	   case Q5:
		stateName = "Q5";
		break;
	   case Q6:
		stateName = "Q6";
		break;
	   case Q7:
		stateName = "Q7";
		break;
	   case Q8:
		stateName = "Q8";
		break;
	   case Q9:
		stateName = "Q9";
		break;
	   case Q10:
		stateName = "Q10";
		break;
	   case Q11:
		stateName = "Q11";
		break;
	   case Q12:
		stateName = "Q12";
		break;
	  }
	  return stateName;
	 }

	 private void appendChar(char character) {//Comprueba caracteres validos.
	  if (character != '1' && character != '0') {
	   System.err.println("Caracter Invalido");
	   return;
	  }
	  buffer.append(character);
	  switch (state) {
	  
	   case Q0:
	    if (character == '1') {
	     state = Q2;
	    } else {
	     state = Q1;
	    }
	    break;
	   
	   case Q1:
		    if (character == '1') {//Caminos que puede tomar.
		     state = Q6;
		    } else {
		     state = Q3;
		    }
		    break;
	    
	   case Q2:
		    if (character == '1') {
		     state = Q4;
		    } else {
		     state = Q7;
		    }
		    break;    
		    
	   case Q3:
		    if (character == '1') {
		     state = Q5;
		    } else {
		     state = Q1;
		    }
		    break;    
		    
	   case Q4:
		    if (character == '1') {
		     state = Q2;
		    } else {
		     state = Q8;
		    }
		    break; 
		    
	   case Q7:
		    if (character == '1') {
		     state = Q8;
		    } else {
		     state = Q9;
		    }
		    break; 
		    
	   case Q8:
		    if (character == '1') {
		     state = Q7;
		    } else {
		     state = Q12;
		    }
		    break;   
		
	   case Q9:
		    if (character == '1') {
		     state = Q12;
		    } else {
		     state = Q7;
		    }
		    break;
		    
	   case Q12:
		    if (character == '1') {
		     state = Q9;
		    } else {
		     state = Q8;
		    }
		    break;    
		   
	   case Q5:
		    if (character == '1') {
		     state = Q11;
		    } else {
		     state = Q6;
		    }
		    break;
		    
	   case Q6:
		    if (character == '1') {
		     state = Q10;
		    } else {
		     state = Q5;
		    }
		    break;    
		
	   case Q10:
		    if (character == '1') {
		     state = Q6;
		    } else {
		     state = Q11;
		    }
		    break;    
		    
	   case Q11:
		    if (character == '1') {
		     state = Q5;
		    } else {
		     state = Q10;
		    }
		    break;    
		    
	    
	   default:
	    System.err.println("Error");

	  }
	 }

	 public static void main(String args[]) {//Metodo main, principal.
	  String string = JOptionPane.showInputDialog(null, "Ingrese su Cadena Binaria");
	  Automata automata = new Automata();
	  System.out.println("La Cadena '" + string + " es Aceptada?:" + (automata.accept(string, true)|automata.accept2(string, true)));
	  

	 }
	}