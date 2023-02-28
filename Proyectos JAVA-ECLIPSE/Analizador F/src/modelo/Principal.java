package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.*;

public class Principal {
	//private static String[]  reglaInicio= {"palabra_Inicio","corcheteA"};
	private static String  reglaIncio2="palabra_Inicio corcheteA";

	private static String reglaTipo="palabra_tipo reglaVariable";
	private static String reglaVariable="identificador/identificador igual numero/identificador igual decimal/identificador igual numero coma reglaVariable/identificador igual decimal coma reglaVariable/identificador coma reglaVariable";


	private static String reglaFin="corcheteC palabra_fin";
	private static String reglaAsignacion="identificador igual numero/identificador igual reglaFuncion";

	private static String reglaFuncion="palabra_operacion parentesisA numero coma identificador parentesisC/"
			+ "palabra_operacion parentesisA numero coma numero parentesisC/"
			+ "palabra_operacion parentesisA identificador coma numero parentesisC/"
			+ "palabra_operacion parentesisA identificador coma identificador parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma numero parentesisC/"
			+ "palabra_operacion parentesisA numero coma reglaFuncion parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma identificador parentesisC/"
			+ "palabra_operacion parentesisA identificador coma reglaFuncion parentesisC/"//;
			+ "palabra_operacion parentesisA decimal coma decimal parentesisC/"//decimales
			+ "palabra_operacion parentesisA identificador coma decimal parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma decimal parentesisC/"
			+ "palabra_operacion parentesisA decimal coma reglaFuncion parentesisC/";

	private static String reglaAccion="palabra_accion parentesisA numero parentesisC/"
			+ "palabra_accion parentesisA identificador parentesisC";
	private static Stack<Token>stack=new Stack<Token>();
	private static boolean convertir=false;

	private static ArrayList<String>reglas;
	private static String reglaActual="";
	private static String subRegla="";
	private static int posicionSubPilaAnterior=0;
	private static int posicionSubPila=0;
	private static ArrayList<LineaArbol>lineasA;
	private static int numNodo=1;
	private static int countSubReglas=0;



	public static void main(String[] args) {
		reglas=new ArrayList<>();
		reglas.add(reglaIncio2);
		reglas.add(reglaAccion);
		reglas.add(reglaAsignacion);
		reglas.add(reglaFin);
		reglas.add(reglaFuncion);
		reglas.add(reglaTipo);
		reglas.add(reglaVariable);
		lineasA=new ArrayList<>();

		ArrayList<String> cadenas= new ArrayList<String>();
		File archivo = new File ("C:\\Users\\Grudges\\Desktop\\tokens.txt");
		FileReader fr=null;
		try {
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		try {
			String linea;
			String aux="";
			boolean empezar=false;
			while((linea=br.readLine())!=null) {
				//System.out.println(linea);
				if(linea.contains("Punto_y_coma")) {

				}
				else if(linea.contains("palabra_fin")) {
					aux+=linea+" ";
				}
				else if(linea.contains("espacio")) {
					cadenas.add(aux);
					//System.out.println("Lo que entra al vector: "+aux);
					aux="";   

				}  
				else {
					aux+=linea+" ";


				}
			}
			//System.out.println("---Linea---"+cadenas.get(0));
			//              for(int j=0;j<cadenas.size();j++) {
			//               	reglaActual="";
			//               	subRegla="";
			//               	posicionSubPila=0;
			//               	posicionSubPilaAnterior=0;
			//               	System.out.println("---Linea que va verificar--");
			//               	System.out.println(cadenas.get(j));
			//               	if(!comprobar(cadenas.get(j))) {
			//               		break;
			//               	} 	
			//            }
			if(!comprobar(cadenas.get(cadenas.size()-1))) {
				System.out.println("error");
			}

			//comprobar(cadenas.get(5));
			System.out.println(cadenas.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static boolean comprobar(String cadena) {
		String[] cadenaPartida=cadena.split(" ");
		System.out.println(cadenaPartida[0]);
		boolean primeraVez=true;
		String cadenaAux2="";
		String cadenaAux1="";
		ArrayList<String>cadenaSinCorchete=new ArrayList<String>();
		for(int i=0;i<cadenaPartida.length;i++) {
			cadenaAux1=cadenaPartida[i];
			for(int j=0;j<cadenaAux1.length();j++) {
				if(cadenaAux1.charAt(j)!='<' && cadenaAux1.charAt(j)!='>') {
					cadenaAux2+=cadenaAux1.charAt(j);	
				}
				else {
					if(cadenaAux1.charAt(j)=='>' && primeraVez) {
						cadenaAux2+=" ";
						primeraVez=false;

					}
				}

			}
			System.out.println("cadena sin corchete(metodo comprobar):"+cadenaAux2);
			cadenaSinCorchete.add(cadenaAux2);
			cadenaAux2="";
			primeraVez=true;	
		}
		System.out.println(cadenaAux2);
		return meterAPila(cadenaSinCorchete);



	}

	public static ArrayList<Token> generarListaTokens(ArrayList<String> cadenas){
		ArrayList <Token> tokens=new ArrayList<>();
		for(int i=0;i<cadenas.size();i++) {
			String []cadenasAux=cadenas.get(i).split(" ");
			Token token= new Token(cadenasAux[1],cadenasAux[0]);
			tokens.add(token);

		}
		return tokens;


	}


	public static boolean meterAPila(ArrayList<String> cadenas) {
		ArrayList <Token> tokens=generarListaTokens(cadenas);
		System.out.println("hola"+tokens.toString());
		String lex="";
		int regla=0;
		for(int i=0;i<tokens.size();i++) {
			String tokenSiguiente="";
			if(i!=tokens.size()-1) {
				tokenSiguiente=tokens.get(i+1).getToken();
			}

			stack.push(tokens.get(i));

			if(i==0) {
				regla=seleccionarRegla(stack.toArray());
				if(regla==-1) {
					System.out.println("Error no corresponde a ninguna regla de produccion");
				}
			}

			if(!subRegla.isEmpty()) {
				System.out.println("La subregla esta en curso");
				if(verficarSubRegla(stack.toArray(), tokenSiguiente)) {
					//					lex=tokens.get(i).getLexema();
					//					String token= tokens.get(i).getToken();
					//					generarArbol(lex,token);
					//					System.out.println("");
				}
				else {
					System.out.println("ERROR");
					return false;
				}

			}
			else {
				if(verificarReglas2(stack.toArray(),tokenSiguiente)) {
					//					lex=tokens.get(i).getLexema();
					//					String token= tokens.get(i).getToken();
					//					generarArbol(lex,token);

				}
				else {
					System.out.println("ERROR en "+cadenas.get(i));
					return false;

				}

			}
			if(esSimboloTerminal(tokens.get(i).getToken())) {
				lex=tokens.get(i).getLexema();
				String token= tokens.get(i).getToken();
				generarArbol(lex,token);

			}
		}
		if(reglaActual.contains("reglaVariable")) {
			remplazarReglaVariable(stack.toArray());

		}
		else if(reglaActual.contains("reglaAsignacion")||reglaActual.contains("reglaFuncion")) {
			remplazarReglaFuncion(stack.toArray());
			System.out.println("entro");

		}
		else {
			remplazarReglaNormal(stack.toArray());

		}
		//System.out.println("Arbol:"+cadena);
		System.out.println("Pila: "+imprimirPila(stack.toArray()));
		System.out.println("No hay errores");
		System.out.println("-------ARBOL-------");
		for(LineaArbol ln:lineasA) {
			System.out.println(ln);

		}
		System.out.println();
		System.out.println("--------------------");
		return true;
	}


	//---------------------------------------METODOOOOOO GENERAR ARBOL-------------------------------------------------------------------------------------------------------------
	public static void generarArbol(String lexema,String token) {
		LineaArbol lineaArbol= new LineaArbol("n"+numNodo, token, lexema,"null");
		lineasA.add(lineaArbol);
		numNodo++;
	}
	public static boolean esSimboloTerminal(String token) {
		if(token.equals("coma")|| token.equals("corcheteA") || token.equals("corcheteC")|| token.equals("parentesisA") || token.equals("parentesisC") || token.equals("igual")) {
			return true;
		}
		else {
			return false;
		}

	}

	public static int seleccionarRegla(Object[] pila) {
		System.out.println("--Metodo Seleccionar Regla--");
		for (int i = 0; i < reglas.size(); i++) {
			String [] aux= reglas.get(i).split(" ");
			System.out.println(aux[0]);
			Token token=(Token) pila[0];
			if(aux[0].equals(token.getToken())) {
				System.out.println("Regla seleccionada: "+ reglas.get(i));
				reglaActual=reglas.get(i);
				return i;
			}

		}
		return -1;

	}


	public static boolean verificarReglas2(Object[] pila,String tokenSiguiente) {
		int count=0;
		System.out.println("               ");
		System.out.println("\n");
		System.out.println("---INICIO DEL METODO VERIFICAR REGLA---");
		System.out.println("Pila (Metodo verificarRegla): "+imprimirPila(pila));
		String[] reglaActualAux=null;
		int tieneOr=0; //1es para si tiene la regla or, 0 para si no
		if(reglaActual.contains("/")) {
			tieneOr=1;
			reglaActualAux=reglaActual.split("/");
		}
		else {
			reglaActualAux=reglaActual.split(" ");
		}
		switch(tieneOr) {
		case 0:
			System.out.println("regla: "+imprimirRegla(reglaActualAux));
			for(int j=0;j<reglaActualAux.length;j++) {
				System.out.println(j+">"+(pila.length-1));
				if(j>pila.length-1) {
					if(!tokenSiguiente.isEmpty()) {
						System.out.println("Entro "+j+" token siguiente "+tokenSiguiente);
						if(count==pila.length) {
							if(reglaActualAux[j].equals(tokenSiguiente)) {
								System.out.println("Lo que viene corresponde");
								convertir=true;
								return true;
							}
							else if(imprimirRegla(reglaActualAux).contains("regla")) {
								System.out.println("Se ocupa sub regla");
								int posicion=seleccionarSubRegla(reglaActualAux,tokenSiguiente,pila,j);
								if(posicion>-1) {
									countSubReglas++;
									posicionSubPila=j;
									return true;
								}
							}
						}
					}
				}
				else{
					Token token=(Token)pila[j];
					if(token.getToken().equals(reglaActualAux[j])) {
						System.out.println("Son iguales pila: "+token.getToken()+" ,Regla incio: "+reglaActualAux[j]);
						count++;	
					}		
				}
			}



			break;
		case 1:
			System.out.println("Caso or");
			for(int i=0;i<reglaActualAux.length;i++) {
				String[] reglaActualSinEspacios=reglaActualAux[i].split(" ");
				System.out.println("for regla "+imprimirRegla(reglaActualSinEspacios));
				count=0;
				for(int j=0;j<reglaActualSinEspacios.length;j++) {
					//System.out.println(j+">"+(pila.length-1));
					if(j>pila.length-1) {
						if(!tokenSiguiente.isEmpty()) {
							System.out.println("Entro "+j+" token siguiente "+tokenSiguiente);
							if(count==pila.length) {
								if(reglaActualSinEspacios[j].equals(tokenSiguiente)) {
									System.out.println("Lo que viene corresponde");
									convertir=true;
									subRegla="";
									return true;
								}
								else if(imprimirRegla(reglaActualAux).contains("regla")) {
									System.out.println("Se ocupa sub regla");
									int posicion=seleccionarSubRegla(reglaActualSinEspacios,tokenSiguiente,pila,j);
									if(posicion>-1) {
										posicionSubPila=j;
										return true;
									}
								}
							}
						}
					}
					else{
						Token token= (Token) pila[j];
						if(token.getToken().equals(reglaActualSinEspacios[j])) {
							System.out.println("Son iguales pila: "+token.getToken()+" ,Regla incio: "+reglaActualSinEspacios[j]);
							count++;
							if(tokenSiguiente.isEmpty() && count==pila.length) {
								return true;
							}
						}		
					}

				}
			}


			break;

		}

		if(count==pila.length) {
			return true;
		}
		return false;
	}

	public static int seleccionarSubRegla(String [] regla,String tokenSiguiente,Object pila[],int posicion) {
		System.out.println("---INICIO DEL METODO seleccionarSUBREGLA---");
		if(imprimirRegla(regla).contains("reglaVariable")) {
			String[] reglaVarDividida=reglaVariable.split("/");
			System.out.println(imprimirRegla(reglaVarDividida));
			for (int i = 0; i < reglaVarDividida.length; i++) {
				String []reglaSinEspacios=null;
				if(reglaVarDividida[i].contains(" ")) {
					reglaSinEspacios=reglaVarDividida[i].split(" ");

				}
				else {
					reglaSinEspacios=reglaVarDividida;

				}
				if(!tokenSiguiente.isEmpty()) {
					if(tokenSiguiente.equals(reglaSinEspacios[0])){
						System.out.println("SubRegla que se ocupara "+reglaVariable);
						subRegla=reglaVariable;
						return posicion;
					}
				}
			}
		}
		else if(imprimirRegla(regla).contains("Funcion")){
			System.out.println("Se ocupara la regla de la funcion");
			subRegla=reglaFuncion;
			return posicion;
		}
		return -1;

	}


	public static boolean verficarSubRegla(Object[] pila,String tokenSiguiente) {
		System.out.println("--Incio del metodo SubRegla--");
		System.out.println("Token siguiente "+tokenSiguiente);
		System.out.println("lo que hay en pila: "+imprimirPila(pila));
		System.out.println("Inicio del metodo subpila: "+posicionSubPila);
		System.out.println("Lo que solo toma en cuenta de la pila"+imprimirPila(pila,posicionSubPila));
		System.out.println("Tamaño de la pila: "+pila.length);
		String [] reglaSinOr=subRegla.split("/");
		for(int i=0;i<reglaSinOr.length;i++) {
			String [] reglaSinEspacios=reglaSinOr[i].split(" ");
			int posicionSubPila1=posicionSubPila;
			System.out.println("(for) regla: "+imprimirRegla(reglaSinEspacios));
			for(int j=0;j<reglaSinEspacios.length;j++) {
				int num=pila.length-posicionSubPila;
				//System.out.println(num+" < "+j);
				if(num<=j) {
					if(!tokenSiguiente.isEmpty()) {

						System.out.println("TokenSiguiente "+tokenSiguiente);
						if(reglaSinEspacios[j].equals(tokenSiguiente)) {
							System.out.println("Lo que viene corresponde");
							return true;
						}
						else if(subRegla.equals(reglaFuncion)) {
							Token ultimoToken=(Token)pila[pila.length-1];
							if(reglaSinEspacios[j].contains("regla") && ultimoToken.getToken().equals("coma") && posicionSubPila1==pila.length && !tokenSiguiente.equals("decimal")) {
								System.out.println("--SE OCUPA DE NUEVO SUBREGLA--");
								System.out.println("Tamaño de la posicionSubPila1: "+posicionSubPila1);
								posicionSubPilaAnterior=posicionSubPila;
								posicionSubPila=posicionSubPila1;
								return true;

							}
						}
						else if(subRegla.equals(reglaVariable)) {
							Token ultimoToken=(Token)pila[pila.length-1];
							if(reglaSinEspacios[j].contains("regla") && ultimoToken.getToken().equals("coma") && posicionSubPila1==pila.length) {
								System.out.println("--SE OCUPA DE NUEVO SUBREGLA--");
								System.out.println("Tamaño de la posicionSubPila1: "+posicionSubPila1);
								posicionSubPilaAnterior=posicionSubPila;
								posicionSubPila=posicionSubPila1;
								countSubReglas++;

								return true;
							}


						}
					}
					else if(posicionSubPila1==pila.length) {
						return true;
					}
					System.out.println("subpila"+posicionSubPila1+"="+pila.length);


				}



				else if(retornarToken((Token)pila[posicionSubPila1]).getToken().equals(reglaSinEspacios[j])) {
					System.out.println("Son iguales (pila: "+retornarToken((Token)pila[posicionSubPila1]).getToken()+") = ("+"regla : "+reglaSinEspacios[j]+")" );
					posicionSubPila1++;
					if(j==reglaSinEspacios.length-1) {
						System.out.println("Verificacion final");
						if(posicionSubPila1==pila.length) {
							System.out.println("verifinal entro");
							if(!tokenSiguiente.isEmpty() && subRegla.equals(reglaFuncion)) {
								remplazar(posicionSubPila, posicionSubPila1);
							}
							return true;
						}

					}
				}
			}
		}

		return false;

	}
	public static Token retornarToken(Token token) {
		return token;
	}

	public static void remplazar(int inicio, int fin){
		for(int i=fin;i>inicio;i--) {
			Token token=stack.pop();
			generarArbol(token.getLexema(), token.getToken());

		}
		stack.add(new Token("null","reglaFuncion"));

		System.out.println("-Metodo Remplazar-");
		System.out.println(imprimirPila(stack.toArray()));
		System.out.println("-----------------------------");
		posicionSubPila=posicionSubPilaAnterior;

	}
	public static void remplazarReglaVariable(Object []pila) {
		int comas=0;
		int comasAux=0;
		System.out.println(imprimirPila(pila));
		Token tokenAux=new Token("","");
		while(!stack.empty()) {
			Token token=stack.pop();
			if(esSimboloTerminal(token.getToken())) {
				if(token.getToken().equals("coma") && !tokenAux.getToken().equals("reglaVariable")) {
					stack.push(token);
					stack.push(new Token("null","reglaVariable"));
				}	
			}
			else if(token.getToken().equals("palabra_tipo") &&  !tokenAux.getToken().equals("reglaVariable")) {
				stack.push(token);
				stack.push(new Token("null","reglaVariable"));	

			}
			else {
				if(token.getToken().equals("reglaVariable")|| token.getToken().equals("reglaTipo") ) {
					comasAux=comas;
					for(int i=lineasA.size()-1;i>=0;i--) {
						if(!lineasA.get(i).getToken().equals("coma")) {
							if(lineasA.get(i).getPadre().equals("null")) {
								lineasA.get(i).setPadre("n"+numNodo);

							}
						}
						else {
							if(comasAux==0) {
								comas++;
								break;
							}
							else {
								if(lineasA.get(i).getPadre().equals("null")) {
									lineasA.get(i).setPadre("n"+numNodo);
								}

								comasAux--;
							}
						}

					}

				}
				else if(token.getToken().equals("palabra_tipo")) {
					stack.push(new Token("null","reglaTipo"));

				}
				generarArbol(token.getLexema(), token.getToken());
				tokenAux=token;

			}




		}
	}

	public static void remplazarReglaFuncion(Object []pila) {
		System.out.println(imprimirPila(pila));
		Token tokenAux=new Token("","");
		while(!stack.empty()) {
			Token token=stack.pop();
			if(esSimboloTerminal(token.getToken())) {


			}
			else {
				if(token.getToken().equals("reglaFuncion")) {
					boolean asignar=false;
					for(int i=(lineasA.size()-1);i>=0;i--) {
						if(lineasA.get(i).getToken().equals("palabra_operacion") && lineasA.get(i).getPadre().equals("null")){
							asignar=true;
							lineasA.get(i).setPadre("n"+numNodo);
						}
						if(lineasA.get(i).getToken().equals("parensisA") && lineasA.get(i).getPadre().equals("null")) {
							lineasA.get(i).setPadre("n"+numNodo);
							break;
						}
						if(asignar){
							lineasA.get(i).setPadre("n"+numNodo);
						}

					}

				}
				else if(token.getToken().equals("identificador") && stack.isEmpty()) {
					stack.push(new Token("null","reglaAsignacion"));
				}
				else if(token.getToken().equals("reglaAsignacion")) {
					for(int i=lineasA.size()-1;i>=0;i--) {
						if(lineasA.get(i).getPadre().equals("null")){
							lineasA.get(i).setPadre("n"+numNodo);
						}

					}
				}
				else if(token.getToken().equals("palabra_operacion")&& stack.isEmpty()) {
					stack.push(new Token("null","reglaFuncion"));
				}
				generarArbol(token.getLexema(), token.getToken());
				tokenAux=token;

			}
		}
	}
    public static void remplazarReglaNormal(Object []pila) {
    	System.out.println(imprimirPila(pila));
    	while(!stack.isEmpty()) {
    		Token token= stack.pop();
    		if(!esSimboloTerminal(token.getToken())) {
    			if(token.getToken().equals("palabra_Inicio") && stack.isEmpty()) {
    				stack.push(new Token("null","reglaInicio"));

    			}
    			else if(token.getToken().equals("palabra_accion") && stack.isEmpty()) {
    				stack.push(new Token("null","reglaAccion"));
    			}
    			else if(token.getToken().equals("reglaAccion")|| token.getToken().equals("reglaInicio")) {
    				    for(int i=lineasA.size()-1;i>=0;i--) {
    				    	if(lineasA.get(i).getPadre().equals("null")) {
    				    		lineasA.get(i).setPadre("n"+numNodo);
    				    	}
    				    }
    			}
    			generarArbol(token.getLexema(), token.getToken());
    			
    		}
    	}
    	
    }
	public static String imprimirPila(Object[] pila) {
		String cadena="[";
		for(int i=0;i<pila.length;i++) {
			Token token= (Token)pila[i];
			cadena+=token.getToken()+",";
		}
		cadena+="]";
		return cadena;

	}
	public static String imprimirPila(Object[] pila,int k) {
		String cadena="[";
		for(int i=k;i<pila.length;i++) {
			Token token= (Token)pila[i];
			cadena+=token.getToken()+",";
		}
		cadena+="]";
		return cadena;

	}

	public static String imprimirRegla(String[] pila) {
		String cadena="[";
		for(int i=0;i<pila.length;i++) {
			cadena+=pila[i]+",";
		}
		cadena+="]";
		return cadena;

	}


}
