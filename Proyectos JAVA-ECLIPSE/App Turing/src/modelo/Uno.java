package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Uno {
	//Declaración de las variables
	public static String cadena, cadena2,aux;		
	public static BufferedReader reader;
	public static int longitud;
	public String complemento="";
	public String arreglo[];
	public int apuntador=1;
	int count = 0;

	//El constructor del objeto te muestra la cadena ingresada
	public Uno(){
		System.out.println("Cadena: "+cadena); 
		decodificar(cadena);
	}

	//Metodo decodificar se encarga de crear el arreglo que contendrá la cadena
	public void decodificar(String dec){
		cadena2="#"+cadena+"#";



		for (char c : cadena2.toCharArray()) {
		    count++;
  
		}
		

		
		//System.out.println("Esta es la cinta "+cadena2);
		arreglo = new String[count];
		for(int i=0;i<count;i++){
			arreglo[i]=""+cadena2.charAt(i);
			//System.out.println("Arreglo "+arreglo[i]);
		}
		q0();
	}
	
	//El metodo e0 representa al estado 0, el estado inicial
	public void q0(){
		aux= arreglo[apuntador];
		if (aux.equals("(")){
			arreglo[apuntador]="1";
			moverDerecha();
			//System.out.println("Movimieto ( q0" );
			q1();
		}
		else if (aux.equals("2")){
			arreglo[apuntador]="2";
			moverDerecha();
			q0();
		}
		else if (aux.equals("#")){
			arreglo[apuntador]="#";
			moverIzquierda();
			q3();
		}else{
		//	rechazar(aux);
			if(aux.equals(")")){
				System.out.println("Cadena no aceptada");
			}
			else {System.out.println("Cadena no aceta en q0");}
			
		}
			
	}

	//El metodo e1 representa al estado 1
	public void q1(){
		aux= arreglo[apuntador];
		if (aux.equals(")")){
			arreglo[apuntador]="2";
			moverIzquierda();
			//System.out.println("Movimiento ) q1"+aux);
			q2();
		}
		else if (aux.equals("2")){
			arreglo[apuntador]="2";
			moverDerecha();
			q1();
		}
		else{
			if (aux.equals("(")){
				arreglo[apuntador]="(";
				moverDerecha();
				q1();
			}
			else {
				System.out.println("Cadena no aceta en q1");
			}
		}
	}

	//El metodo e2 representa al estado 2
	public void q2(){
		aux= arreglo[apuntador];
		if (aux.equals("2")){
			arreglo[apuntador]="2";
			moverIzquierda();
			q2();
		}
		else if (aux.equals("(")){
			arreglo[apuntador]="(";
			moverIzquierda();
			q2();
		}
		else if (aux.equals("1")){
			arreglo[apuntador]="1";
			moverDerecha();
			q0();
		}else{
			//rechazar(aux);
			System.out.println("Cadena no aceta en q2");
		}
	}

	//El metodo e3 representa al estado 3, el estado de aceptación
	
	public void q3(){
		aux= arreglo[apuntador];
		if (aux.equals("1")){
			arreglo[apuntador]="(";
			moverIzquierda();
			q3();
		}
		else if (aux.equals("2")){
			arreglo[apuntador]=")";
			moverIzquierda();
			q3();
		}
		else if (aux.equals("#")){
			arreglo[apuntador]="#";
			moverIzquierda();
			q4();
		}else{
			//rechazar(aux);
			System.out.println("Cadena no acepta en q3");
		}
	}

	public void q4(){
			System.out.println("La cinta es aceptada");
		
	}



	//Mueve el puntero de la MT a la derecha
	public void moverDerecha(){
		apuntador++;
		//System.out.println(apuntador +" apuntador valor der");
	}
	
	//Mueve el puntero de la MT a la izquierda
	public void moverIzquierda(){
		apuntador=apuntador-1;
		//System.out.println(apuntador +" apuntador valor iz");
	}

	//Si entra en este estado, significa que se encontró un caracter no valido
	/*public void rechazar(String noval){
		System.out.println("Caracter no valido: "+noval);
	}*/



	//Pide el numero binario y lo guarda en la variable cadena
	public static void main(String args[]){
		System.out.print("Ingrese parentesis : ");
		try{
			reader = new BufferedReader(new InputStreamReader(System.in));
			cadena = reader.readLine();
		}catch(IOException e){
			e.getMessage();
		}
		Uno obj = new Uno();
	}
}