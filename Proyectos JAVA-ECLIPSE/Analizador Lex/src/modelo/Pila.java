package modelo;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.DefaultListModel;

public class Pila {
	private Stack<String> pila;
	private ArrayList<String>tk;
	private ArrayList<Padre> arbol;
	private DefaultListModel<String>error;
	private int i;
	private int p;	
	private int linea;	
	public Pila(ArrayList<String>tk) {
		pila=new Stack<String>();
		this.tk=tk;
		arbol=new ArrayList();
		error=new DefaultListModel<String>();

	}
	public String mostrar() {
		String salida="Numero	Nombre	Padre \n";

		while (!pila.empty()) {

			System.out.println(pila.pop());

		}

		//		for (int i = 0; i < tk.size(); i++) {
		//			System.out.println(tk.get(i));
		//		}
		for (Padre padre : arbol) {
			salida+=padre.toString()+"\n";;
		}
		return salida;
	}


	public void reglas() {
		i=0;
		p=1;
		linea=1;
		while (tk.size()>i) {
			String aux1;
			String aux2;
			String aux3;
			String auxid=ides(tk.get(i));
			if(!auxid.equals("id")) {
				auxid=tk.get(i);
			}

			switch (auxid) {
			case "BEGIN":
				Begin();
				break;
			case "INTEGER":
				pila.push("TIPO");
				hoja("INTEGER");
				i++;
				Declaracion();

				if (i<tk.size()&&tk.get(i).equals(";")) {
					pila.push(";");
					i++;
				}else {
					mandarErrores();
					sacarError();
				}
				if (pila.size()>2) {
					aux1=pila.pop();
					aux2=pila.pop();
					aux3=pila.pop();
					if (aux1.equals(";")&& aux2.equals("LISTA") && aux3.equals("TIPO")) {
						hoja(aux1);
						buscaLista();
						hoja(aux2);
						buscaTipo();
						hoja(aux3);
						pila.push("DECLARACION");
						linea++;
					}
				}


				break;
			case "REAL":
				pila.push("TIPO");
				hoja("REAL");
				i++;
				Declaracion();
				if(tk.size()>i) {
					if (tk.get(i).equals(";")) {
						pila.push(";");
						i++;

					}else {
						mandarErrores();
						sacarError();
					}
					if (pila.size()>2) {
						aux1=pila.pop();
						aux2=pila.pop();
						aux3=pila.pop();
						if (aux1.equals(";")&& aux2.equals("LISTA") && aux3.equals("TIPO")) {
							hoja(aux1);
							buscaLista();
							hoja(aux2);
							buscaTipo();
							hoja(aux3);
							pila.push("DECLARACION");
							linea++;
						}
					}
				}

				break;

			case"id":

				pila.push(tk.get(i));
				i++;
				if(tk.get(i).equals("=")) {
					pila.push("=");
					i++;
					if (asignacion()) {
						i++;
						if(tk.get(i).equals(";")) {
							pila.push(";");
							aux1=pila.pop();
							aux2=pila.pop();
							if (aux1.equals(";")&&aux2.equals("ASIGNACION")) {
								hoja(aux1);
								buscaAsignacion();
								hoja(aux2);
								pila.push("OPERACIONCO");
								linea++;
							}else {
								pila.push(aux2);
								pila.push(aux1);
							}
							i++;
						}
					}else {
						operacion();				
					}
				}else {
					mandarErrores();
					sacarError();
				}
				break;
			case "READ":
				metrecu();
				break;
			case "WRITE":
				metrecu();
				break;
			case"}":
				pila.push("}");
				i++;
				if(i<tk.size()) {
					if(tk.get(i).equals("END")) {
						pila.push("END");
						String aux=pila.pop();
						String au=pila.pop();
						if (aux.equals("END")&&au.equals("}")) {

							codigoM();
							hoja(aux);
							hoja(au);
							pila.push("FIN");

							if (pila.size()>2) {


								aux=pila.pop();
								au=pila.pop();
								String auxi=pila.pop();
								if (aux.equals("FIN")&&au.equals("CODIGO")&&auxi.equals("INICIO")) {
									buscaFin();
									hoja(aux);
									buscaHcodigo();
									hoja(au);
									buscaInicio();
									hoja(auxi);
									pila.push("E");
									buscarE();
									pila.pop();

								} else {

								}

							}
							i++;
						} else {

							pila.push(aux);
							pila.push(au);
						}
					}else {
						sacarError();
						mandarErrores();

					}
				}else {
					sacarError();
				}
				break;
			default:
				mandarErrores();
				sacarError();

				break;
			}

		}


	}
	public void Begin(){
		if (i<tk.size()&&tk.get(i).equals("BEGIN")) {
			pila.push("BEGIN");
			i++;
			String aux=pila.pop();
			if (i<tk.size()&&aux.equals("BEGIN")&&tk.get(i).equals("{")) {
				hoja("BEGIN");
				hoja("{");
				pila.push("INICIO");
				i++;
				linea++;
			} else {
				mandarErrores();
				sacarError();
			}
		} 
	}

	public void Declaracion() {
//				 se busca el id
		if (i<tk.size()&&tk.get(i).contains("id")) {
// 				se buca el igual
			if(i<tk.size()&&tk.get(i+1).equals("=")){
				pila.push(tk.get(i));
				i++;
				pila.push("=");
				i++;
				//llamamos a asignacion() para ver si tiene el patron de una asignacion
				asignacion();
				// asignamos los hijos de Asignacion
				buscaAsignacion();
				
				hoja("ASIGNACION");
				
				pila.pop();
			}else {
				// en caso de no haber el = no es una asignacion y se crea la hoja id
				hoja(tk.get(i));
			}
			// imdependinte si es una asignacion o un id se tyranforman a IDAsig
			pila.push("IDAsig");
			//	hoja("");
			i++;
			//Revisamos si es ; para ver si ya acabo
			if (i<tk.size()&&tk.get(i).equals(";")) {
				// si ya acabo sacamos las cosa de la pila para aplicar las demas reglas 
				pila.pop();
				//busca  los hijo de IDAsig (id o ASIGNACION)
				buscaID();
				hoja("IDAsig");
				pila.push("LISTA");
				// busca los hijos de lista que es IDAsig
				buscaIDAsig();
			} else {
				// si no es ; buscamos una , para 
				if (i<tk.size()&&tk.get(i).equals(",")) {
					pila.push(",");
					i++;

					Declaracion();
					if(pila.size()>2) {
						String aux1=pila.pop();
						String aux2=pila.pop();
						String aux3=pila.pop();
						if (aux1.equals("LISTA")&& aux2.equals(",") && aux3.equals("IDAsig")) {
							buscaLista();
							hoja(aux1);
							hoja(aux2);
							buscaID();
							hoja(aux3);
							pila.push("LISTA");

						}
					}
				}
			}
		}else {
			
			mandarErrores();
			sacarError();

		}
	}
//checa sobre los tokens su hay una asignacion en las declaraciones para poder inpmentar la regla 	
	public boolean asignacion() {
		// si viene un numero revisaremos si es una asignacion
		if (num()) {

			String aux1=pila.pop();
			String aux2=pila.pop();
			String aux3=pila.pop();
			if (aux1.equals("VALOR")&& aux2.equals("=") && aux3.contains("id")) {
				buscaValor();
				hoja(aux1);
				hoja(aux2);
				hoja(aux3);
				//transformamos los tokes a ASIGNACION
				pila.push("ASIGNACION");

				return true;
			}

		}else {
			
		}
		return false;
	}

	//este metodo checa si el numero es entero o decimal para poder aplcar las reglas que incluyen valor


	public boolean num() {
		if(tk.get(i).contains("entero")||tk.get(i).contains("real")) {
			pila.push("VALOR");
			hoja(tk.get(i));
			return true;
		}
		return false;
	}
	
	// checa si es una palabra para operacion
	public boolean ops() {
		if(tk.get(i).equals("ADD")||tk.get(i).equals("MUL")||tk.get(i).equals("DIV")||tk.get(i).equals("SUB")) {
			return true;
		}else {
			return false;
		}
	}

	
	// con este metodo se hacen todas las reglas para caundo hay una asignacion con operaciones incluyendo recursibidad
	//si hay una operacion dentro de otra
	public void operacion() {
		if(ops()) {
			pila.push("OPE");
			hoja(tk.get(i));
			i++;
			if(tk.get(i).equals("(")) {
				pila.push("(");
				i++;
				if(!num()) {
					pila.push(tk.get(i));
				}
				String p=pila.pop();
				if(p.equals("VALOR")||p.contains("id")) {
					buscaValor();
					hoja(p);
					pila.push("OP");
					i++;
				}else {
					operacion();

				}
				if(tk.get(i).equals(",")) {
					pila.push(",");
					i++;
					if(!num()) {
						pila.push(tk.get(i));
					}
					p=pila.pop();
					if(p.equals("VALOR")||p.contains("id")) {
						buscaValor();
						hoja(p);
						pila.push("OP");
						i++;
					}else {

						operacion();
					}

					String pops=pila.pop();
					String pops1=pila.pop();
					String pops2=pila.pop();
					if(pops.equals("OP")&&pops1.equals(",")&&pops2.equals("OP")) {
						buscaOP();
						hoja(pops);
						hoja(pops1);
						buscaOP();
						hoja(pops2);
						pila.push("DIJITOS");
					}else {
						pila.push(pops2);
						pila.push(pops1);
						pila.push(pops);
					}
					if (tk.get(i).equals(")")) {
						i++;
						pila.push(")");
					} else {
						mandarErrores();

						sacarError();//\n
					}
					pops=pila.pop();
					pops1=pila.pop();
					pops2=pila.pop();
					if(pops.equals(")")&&pops1.equals("DIJITOS")&&pops2.equals("(")) {

						hoja(pops);
						buscarOPs();
						hoja(pops1);
						hoja(pops2);
						pila.push("CONTENEDOR");
					}else {
						pila.push(pops2);
						pila.push(pops1);
						pila.push(pops);
					}

					pops=pila.pop();
					pops1=pila.pop();
					if(pops.equals("CONTENEDOR")&&pops1.equals("OPE")) {
						buscarDijitos();
						hoja(pops);
						buscaOperaciones();
						hoja(pops1);
						pila.push("OPERACION");
					}else {
						pila.push(pops1);
						pila.push(pops);
					}
					pops=pila.pop();
					pops1=pila.pop();
					if(pops.equals("OPERACION")&&!pops1.equals("=")) {
						buscarContenedor();
						hoja("OPERACION");
						pila.push(pops1);
						pila.push("OP");

					}else {
						pila.push(pops1);
						pila.push(pops);
					}
					pops=pila.pop();
					pops1=pila.pop();
					pops2=pila.pop();
					if(pops.equals("OPERACION")&&pops1.equals("=")&&pops2.contains("id")) {
						buscarContenedor();
						hoja(pops);
						hoja(pops1);
						hoja(pops2);
						pila.push("ASIGNACION");

					}else {
						pila.push(pops2);
						pila.push(pops1);
						pila.push(pops);
					}
					pops=pila.pop();
					if(pops.equals("ASIGNACION")&&";".equals(tk.get(i))) {
						hoja(";");
						linea++;
						buscarOperacion();
						hoja("ASIGNACION");
						i++;
						pila.push("OPERACIONCO");

					}else {
						pila.push(pops);
					}
				}else {

				}
			}else {

			}

		}else {

		}


	} 




// busca que en la pila este los parentecis o valor y parentecis para las partes que leen y escriben
	public void metrecu() {

		pila.push("LE");
		hoja(tk.get(i));
		i++;
		if (i<tk.size()&&tk.get(i).equals("(")) {
			pila.push("(");
			i++;
			String a;
			if(num()) {
				a=pila.pop();
			}else {
				a=tk.get(i);
			}
			if (a.contains("id")||a.equals("VALOR")) {
				i++;
				pila.push("DIG");
				hoja(a);
				if (i<tk.size()&&tk.get(i).equals(")")) {
					pila.push(")");
					String aux=pila.pop();
					String aux2=pila.pop();
					String aux3=pila.pop();


					if (aux.equals(")")&&aux2.equals("DIG")&&aux3.equals("(")) {
						hoja(aux);
						buscaIDEnsa();
						hoja(aux2);
						hoja(aux3);
						pila.push("ENSA");
						aux=pila.pop();
						aux2=pila.pop();
						i++;
						if (i<tk.size()&&aux.equals("ENSA")&&aux2.equals("LE")&&tk.get(i).equals(";")) {
							hoja(";");
							buscarDig();
							hoja(aux);
							buscarLE();
							hoja(aux2);
							linea++;
							i++;
							pila.push("METRECU");


						}else {
							pila.push(aux2);
							pila.push(aux);
							mandarErrores();
							sacarError();
						}
					} else {
						pila.push(aux3);
						pila.push(aux2);
						pila.push(aux);
					}

				} else {
					mandarErrores();
					sacarError();
				}
			} else {
				mandarErrores();
				sacarError();
			}

		} else {
			mandarErrores();
			sacarError();
		}

	}
	
	
	//este metodo sacaremos los metrescu, declaracinoes y operaciones de las lineas de codigo que fuimos tratando 
	public void codigoM() {
		String cod,cod2;
		boolean pop=false,error=false;
		do {
			cod=pila.pop();
			if ((cod.equals("METRECU")||cod.equals("DECLARACION")||cod.equals("OPERACIONCO"))&&!pop) {
				buscaCodigoF(cod);
				hoja(cod);
				pila.push("CODIGO");
				pop=true;
			} else {
				if(!pila.empty()) {


					cod2=pila.pop();
					if ((cod2.equals("METRECU")&&cod.equals("CODIGO"))||(cod2.equals("DECLARACION")&&cod.equals("CODIGO"))||(cod2.equals("OPERACIONCO")&&cod.equals("CODIGO"))) {

						buscaHcodigo();
						hoja(cod);
						buscaCodigoF(cod2);
						hoja(cod2);
						pila.push("CODIGO");
					}else {
						pila.push(cod2);
						pila.push(cod);
						error=true;
					}

				}else {
					pila.push(cod);
					error=true;
				}
			}
		} while (!pila.empty()&&!cod.equals("INICIO")&&!error);


	}
	
	//en este metodo creamos las hojas del arbol mediante un objeto para despues asignarle un padre
	public void hoja(String nombre) {
		Padre hoja=new Padre();
		hoja.setNumero(p);
		p++;
		hoja.setNombre(nombre);
		arbol.add(hoja);
	}
	
	// este metodo busca los hijos de valor ya que valor solo puede tener como hijos valores entero  decimal 
	public void buscaValor(){
		for (int j = arbol.size()-1; j >=0; j--) {		
			if ((arbol.get(j).getNombre().contains("entero")||arbol.get(j).getNombre().contains("real"))&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
		}
	}

	//para este metodo busc los hijos IDAsig ya que un IDAsig  puede tener como hijos un id o una asignacion
	public void buscaID(){
		for (int j = arbol.size()-1; j >=0; j--) {		
			if ((arbol.get(j).getNombre().contains("id")||arbol.get(j).getNombre().equals("ASIGNACION"))&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
		}
	}
	
	
	//busca los hojos de una asignacion ya que una asignacion debe tener sus hijos id,= y valor
	public void buscaAsignacion(){
		boolean bani=false,banid=false,banva=false;	
	//buscamos los hijos de asignacion 
		for (int j = arbol.size()-1; j >=0; j--) {		
			if (arbol.get(j).getNombre().contains("id")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("=")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}
			if (arbol.get(j).getNombre().equals("VALOR")&&!banva&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				banva=true;
			}
		}
	}
	
	
	//busca los hijos de lista cuando se rea la primer lista 
	public void buscaIDAsig() {
		for (int j = arbol.size()-1; j >=0; j--) {		
			if (arbol.get(j).getNombre().equals("IDAsig")&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
		}
	}
	//busca los hijos de lista , IDAsig cuando ya ay una lista  
	public void buscaLista() {
		boolean bani=false,banid=false,banva=false;	
		for (int j = arbol.size()-1; j >=0; j--) {		
			if (!arbol.get(j).getNombre().equals("TIPO")) {
				if (arbol.get(j).getNombre().equals("IDAsig")&&!banid&&arbol.get(j).getPadre()==0) {
					banid=true;
					arbol.get(j).setPadre(p);
				}	
				if (arbol.get(j).getNombre().equals(",")&&!bani&&arbol.get(j).getPadre()==0) {
					arbol.get(j).setPadre(p);
					bani=true;
				}
				if (arbol.get(j).getNombre().equals("LISTA")&&!banva&&arbol.get(j).getPadre()==0) {
					arbol.get(j).setPadre(p);
					banva=true;
				}
			}else {
				break;
			}
		}
	}
	// busca los hijos de tipo en las declaraciones 
	public void buscaTipo() {
		boolean banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if ((arbol.get(j).getNombre().equals("INTEGER")||arbol.get(j).getNombre().equals("REAL"))&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}
		}

	}
	// busca los hijos de declaracion  
	public void buscarDeclaracion() {
		boolean bani=false,banid=false,banva=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("LISTA")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals(";")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}
			if (arbol.get(j).getNombre().equals("TIPO")&&!banva&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				banva=true;
			}
		}
	}
	// busca los hijos de un OP
	public void buscaOP(){
		for (int j = arbol.size()-1; j >=0; j--) {		
			if ((arbol.get(j).getNombre().contains("id")||arbol.get(j).getNombre().equals("VALOR")||arbol.get(j).getNombre().equals("OPERACION"))&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
		}
	}
	
	// busca los hijos de dijitos  
	public void buscarOPs() {
		boolean bani=false,banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("OP")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals(",")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("OP")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
	}
	// busca hijos de contenedor
	public void buscarDijitos() {
		boolean bani=false,banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("(")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("DIJITOS")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals(")")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
	}
	// busca hijos de OPE 
	public void buscaOperaciones() {

		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("ADD")&&arbol.get(j).getPadre()==0) {

				arbol.get(j).setPadre(p);
				break;
			}	
			if (arbol.get(j).getNombre().equals("SUB")&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
			if (arbol.get(j).getNombre().equals("MUL")&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}
			if (arbol.get(j).getNombre().equals("DIV")&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}

		}
	}
	// busca hijos de operacion
	public void buscarContenedor() {
		boolean bani=false,banid=false;
		for (int j = arbol.size()-1; j >=0; j--) {	

			if (arbol.get(j).getNombre().equals("OPE")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("CONTENEDOR")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
	}
	
	//busca lo hijos de asignacion
	public void buscarOperacion() {
		boolean bani=false,banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("OPERACION")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("=")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().contains("id")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
	}
	
	//busca los hijos de dig
	public void buscaIDEnsa(){
		for (int j = arbol.size()-1; j >=0; j--) {		
			if ((arbol.get(j).getNombre().contains("id")||arbol.get(j).getNombre().equals("VALOR"))&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	
		}
	}
	
	//busca los hijos de ENSA
	public void buscarDig() {
		boolean bani=false,banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("(")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("DIG")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals(")")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
	}
	
	//busca los hijos de LE
	public void buscarLE() {
		for (int j = arbol.size()-1; j >=0; j--) {	
			if ((arbol.get(j).getNombre().equals("READ")||arbol.get(j).getNombre().equals("WRITE"))&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				break;
			}	


		}
	}
	
	
	//busca los hijos de METRECU o de DECLARACION u OPERACIONCO
	public void buscaCodigoF(String pa) {
		boolean bani=false,banid=false,banin=false;

		if (pa.equals("METRECU")) {
			for (int j = arbol.size()-1; j >=0; j--) {	
				if (arbol.get(j).getNombre().equals("LE")&&!banin&&arbol.get(j).getPadre()==0) {
					banin=true;
					arbol.get(j).setPadre(p);
				}	
				if (arbol.get(j).getNombre().equals("ENSA")&&!banid&&arbol.get(j).getPadre()==0) {
					banid=true;
					arbol.get(j).setPadre(p);
				}	
				if (arbol.get(j).getNombre().equals(";")&&!bani&&arbol.get(j).getPadre()==0) {
					arbol.get(j).setPadre(p);
					bani=true;
				}

			}
		}else {
			if (pa.equals("DECLARACION")) {
				for (int j = arbol.size()-1; j >=0; j--) {	
					if (arbol.get(j).getNombre().equals("TIPO")&&!banin&&arbol.get(j).getPadre()==0) {
						banin=true;
						arbol.get(j).setPadre(p);
					}	
					if (arbol.get(j).getNombre().equals("LISTA")&&!banid&&arbol.get(j).getPadre()==0) {
						banid=true;
						arbol.get(j).setPadre(p);
					}	
					if (arbol.get(j).getNombre().equals(";")&&!bani&&arbol.get(j).getPadre()==0) {
						arbol.get(j).setPadre(p);
						bani=true;
					}

				}
			} else {
				for (int j = arbol.size()-1; j >=0; j--) {	
					if (arbol.get(j).getNombre().equals("ASIGNACION")&&!banin&&arbol.get(j).getPadre()==0) {
						banin=true;
						arbol.get(j).setPadre(p);
					}	
					if (arbol.get(j).getNombre().equals(";")&&!bani&&arbol.get(j).getPadre()==0) {
						arbol.get(j).setPadre(p);
						bani=true;
					}

				}
			}
		}
	}
	
	//busca los hijos de codigo
	public void buscaHcodigo() {
		boolean banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("CODIGO")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}
			if ((arbol.get(j).getNombre().equals("METRECU")||arbol.get(j).getNombre().equals("OPERACIONCO")||arbol.get(j).getNombre().equals("DECLARACION"))&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
		}
	}
	
	//busca los hijos de fin
	public void buscaFin() {
		boolean banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("END")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}
			if (arbol.get(j).getNombre().equals("}")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
		}
	}
	
	//busca los hijos de INICIO
	public void buscaInicio() {
		boolean banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("BEGIN")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}
			if (arbol.get(j).getNombre().equals("{")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
		}
	}
	//busca los hijos de E
	public void buscarE() {
		boolean bani=false,banid=false,banin=false;
		for (int j = arbol.size()-1; j >=0; j--) {	
			if (arbol.get(j).getNombre().equals("FIN")&&!banin&&arbol.get(j).getPadre()==0) {
				banin=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("CODIGO")&&!banid&&arbol.get(j).getPadre()==0) {
				banid=true;
				arbol.get(j).setPadre(p);
			}	
			if (arbol.get(j).getNombre().equals("INICIO")&&!bani&&arbol.get(j).getPadre()==0) {
				arbol.get(j).setPadre(p);
				bani=true;
			}

		}
		hoja("E");
	}
	//saca los dos primeros carateres para compara si es un id  
	public String ides(String cadena) {
		String p="";
		if (cadena.length()>=2) {
			for (int j = 0; j < 2; j++) {
				p+=cadena.charAt(j);
			}

		} 
		return p;
	}
	
	public void mandarErrores() {
		error.addElement("Error de Syntaxis en linea "+linea);
	}

	public DefaultListModel<String> getErrores() {
		return error;
	}
	public void sacarError() {
		boolean ban=false;
		while (tk.size()>i&&!tk.get(i).equals(";")) {
			
			ban=true;
			if (tk.get(i).equals("INTEGER")||tk.get(i).equals("REAL")||tk.get(i).equals("WRITE")||tk.get(i).equals("READ")) {
				i--;
				break;

			}else {
				if (i+1<tk.size()) {
					if (tk.get(i).equals("}")&&tk.get(i+1).equals("END")) {
						i--;
						break;
					}else {
						if (i+2<tk.size()) {
							if (tk.get(i).contains("id")&&tk.get(i+1).equals("=")&&(tk.get(i+2).contains("real")||tk.get(i+2).contains("entero")||ops())) {
								i--;
								break;
							}
						} 
					}
				} 
			}


			i++;
		}
		if(ban){
			linea++;
		}
		i++;
	}
}
