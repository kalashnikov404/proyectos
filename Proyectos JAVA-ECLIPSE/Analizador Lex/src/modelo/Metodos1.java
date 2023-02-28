package modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Metodos1 {
	private  int linea;
	private String token="";
	private ArrayList<String> ids;
	private  DefaultListModel<String> modelerrores;
	public Metodos1(){
		modelerrores=new DefaultListModel<String>();
		ids=new ArrayList<String>();
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public void getLimpiar() {
		modelerrores.clear();
	}
	public String getTokens() {
		return token;
	}
	public void SetTokens() {
		token="";
	}
	public String getIds() {
		String idses="";
		for (int i = 0; i < ids.size(); i++) {
			idses+=ids.get(i)+"\n";
		}
		return idses;
	}
	public void SetIds() {
		ids.clear();
	}
	public int recorrer(String codigo,int i) {
		String id="";
		String valor="";
		while (i<codigo.length()&&simblos(i, codigo)==true) {
			i++;
		}
		if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
			valor=valor+codigo.charAt(i);
			i++;
			if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
				valor=valor+codigo.charAt(i);
				i++;
				if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
					valor=valor+codigo.charAt(i);
					i++;
					if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
						valor=valor+codigo.charAt(i);
						i++;
						if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
							valor=valor+codigo.charAt(i);
							i++;
							if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
								erroresNum();
								while (i<codigo.length()&&simblos(i, codigo)==false) {
									i++;
								}
								if (i<codigo.length()) {
									i++;
									i=recorrer(codigo, i);
								}
								}
							}
						}
					}
				}
			if (i<codigo.length()&&Character.isLetter(codigo.charAt(i))) {
				erroresNum();
				while (i<codigo.length()&&simblos(i, codigo)==false) {
					i++;
				}
			}
			if (i<codigo.length()&&codigo.charAt(i)=='.') {
				valor=valor+codigo.charAt(i);
				i++;
				if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
					valor=valor+codigo.charAt(i);
					i++;
					if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
						valor=valor+codigo.charAt(i);
						i++;
						if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
							erroresNum();
							while (i<codigo.length()&&simblos(i, codigo)==false) {
								i++;
							}
								}	
				}
			}else {
				erroresNum();
				while (i<codigo.length()&&simblos(i, codigo)==false) {
					i++;
				}
			}
				token+="("+valor+",TK_real)\n";
			}else {
				token+="("+valor+",TK_entero)\n";
			}
			
			if (i<codigo.length()) {
				i=recorrer(codigo, i);
			}
			}
		/// end if
		if(i<codigo.length()&&Character.isLetter(codigo.charAt(i))) {
			id+=codigo.charAt(i);
			i++;
			if(i<codigo.length()&&Character.isLetter(codigo.charAt(i))){
				i--;
				switch (codigo.charAt(i)) {
				case 'B':
					 begin(i, codigo);
					break;
				case 'E':
					 end(i, codigo);
					break;
				case 'I':
					 integer(i, codigo);
					break;
				case 'R':
					readl(i, codigo);
					break;
				case 'W':
					 write(i, codigo);
					break;
				case 'A':
					 add(i, codigo);
					break;
				case 'S':
					 sub(i, codigo);
					break;
				case 'M':
					 mul(i, codigo);
					break;
				case 'D':
					 div(i, codigo);
					break;
				default:
					erroresPreser();
					while (i<codigo.length()&&simblos(i, codigo)==false) {
						i++;
					}
					if (i<codigo.length()) {
						i++;
						i=recorrer(codigo, i);
					}
					break;
				}
			}else {
				boolean paso=true;
				if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
					id+=codigo.charAt(i);
					i++;
					if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
						id+=codigo.charAt(i);
						i++;
						if (i<codigo.length()&&Character.isDigit(codigo.charAt(i))) {
							id+=codigo.charAt(i);
							i++;
							if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
								erroresidenti();
								i++;
								paso=false;
								while (i<codigo.length()&&simblos(i, codigo)==false) {
									i++;
								}
								if (i<codigo.length()) {
									i++;
									i=recorrer(codigo, i);
								}
							}else {
							}
						}
					}else {
					}
					if (paso==true) {
					if (ids.size()==0) {
						ids.add(id);
					}else {
						int tam=ids.size();
						int sino=0;
					for (int j = 0; j <tam ; j++) {
						if (ids.get(j).equals(id)) {
							sino++;
						}
						}
					if (sino==0) {
						ids.add(id);
					}
					}
					}
					if (i<codigo.length()&&Character.isLetter(codigo.charAt(i))) {
						i++;
						erroresidenti();
						paso=false;
					}
					if (paso==true) {
						token+="("+id+",TK_id)\n";
					}
					while (i<codigo.length()&&simblos(i, codigo)==false) {
						i++;
					}
					
					if (i<codigo.length()) {
						i++;
						i=recorrer(codigo, i);
					
					}
					}else {
						erroresidenti();
						while (i<codigo.length()&&simblos(i, codigo)==false) {
							i++;
						}
						if (i<codigo.length()) {
							i++;
						i=recorrer(codigo, i);
						
						}
					}
				
				}
		}
		return i;
		
	}
	public void begin(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='B') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='E') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='G') {
					i++;
					if (i<codigo.length()&&codigo.charAt(i)=='I') {
						i++;
						if (i<codigo.length()&&codigo.charAt(i)=='N') {
							i++;
							if(i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
								erroresPreser();
							}else {
								token+="(BEGIN,TK_BEGIN)\n";
								paso=true;
							}}}}}}
		if (paso==false) {
			erroresPreser();
		}		
		while (i<codigo.length()&&simblos(i, codigo)==false) {
			i++;
		}
		if (i<codigo.length()) {
			i++;
			recorrer(codigo, i);
		}
	}
	public boolean simblos(int i, String codigo) {
		if (codigo.charAt(i)=='{') {
			token+="({,TK_{)\n";
			return true;
		}	
		if (codigo.charAt(i)=='}') {
			token+="(},TK_})\n";
			return true;
		}	
		if (codigo.charAt(i)=='(') {
			token+="((,TK_()\n";
			return true;
		}
		if (codigo.charAt(i)==')') {
			token+="(),TK_))\n";
			return true;
		}	
		if (codigo.charAt(i)==';') {
			token+="(;,TK_;)\n";
			return true;
		}
		if (codigo.charAt(i)==',') {
			token+="(,,TK_,)\n";
			return true;
		}
		if (codigo.charAt(i)=='.') {
			token+="(.,TK_.)\n";
			return true;
		}
		if (codigo.charAt(i)=='=') {
			token+="(=,TK_=)\n";
			return true;
		}	
		if (codigo.charAt(i)==' ') {
			return true;
		}
		if (!Character.isDigit(codigo.charAt(i))&&!Character.isLetter(codigo.charAt(i))) {
			erroresSym();
			return true;
		}
		return false;
	}
	public void integer(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='I') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='N') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='T') {
					i++;
					if (i<codigo.length()&&codigo.charAt(i)=='E') {
						i++;
						if (i<codigo.length()&&codigo.charAt(i)=='G') {
							i++;
							if (i<codigo.length()&&codigo.charAt(i)=='E') {
								i++;
								if (i<codigo.length()&&codigo.charAt(i)=='R') {
									i++;
									if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
										erroresPreser();
									}else {
									token+="(INTEGER,TK_INTEGER)\n";
									paso=true;
								   }}}}}}}}
				if (paso==false) {
					erroresPreser();
				}		
				while (i<codigo.length()&&simblos(i, codigo)==false) {
					i++;
				}
				if (i<codigo.length()) {
					i++;
					recorrer(codigo, i);
				}
	}
	public void end(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='E') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='N') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='D') {
					i++;
					if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
						erroresPreser();
					}else {
						i++;
					token+="(END,TK_END)\n";
					paso=true;
					}}}}
		if (paso==false) {
			erroresPreser();
		}
		while (i<codigo.length()&&simblos(i, codigo)==false) {
			i++;
		}
		if (i<codigo.length()) {
			i++;
			recorrer(codigo, i);
		}
	}
	public void readl(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='R') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='E') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='A') {
					i++;
					if (i<codigo.length()&&codigo.charAt(i)=='D') {
						i++;
						if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
							erroresPreser();
						}else {
							
						token+="(READ,TK_READ)\n";
						paso=true;
						}
					} else {
						if (i<codigo.length()&&codigo.charAt(i)=='L') {
							i++;
							if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
								erroresPreser();
							}else {
							token+="(REAL,TK_REAL)\n";
							paso=true;
							}}}}}}
	if (paso==false) {
		erroresPreser();
	}	
	while (i<codigo.length()&&simblos(i, codigo)==false) {
		i++;
	}
	if (i<codigo.length()) {
		i++;
		recorrer(codigo, i);
	}
	}
	public void write(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='W') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='R') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='I') {
					i++;
					if (i<codigo.length()&&codigo.charAt(i)=='T') {
						i++;
						if (i<codigo.length()&&codigo.charAt(i)=='E') {
							i++;
							if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
							erroresPreser();	
							}else {
								i++;
							token+="(WRITE,TK_WRITE)\n";
							paso=true;
							}}}}}}
		if (paso==false) {
			erroresPreser();
		}		
		while (i<codigo.length()&&simblos(i, codigo)==false) {
			i++;
		}
		if (i<codigo.length()) {
			i++;
			recorrer(codigo, i);
		}
	}
	public void add(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='A') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='D') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='D') {
					i++;
					if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
					erroresPreser();	
					}else {
						
					token+="(ADD,TK_ADD)\n";
					paso=true;
					}}}}
if (paso==false) {
	erroresPreser();
}		
while (i<codigo.length()&&simblos(i, codigo)==false) {
	i++;
}
if (i<codigo.length()) {
	i++;
	recorrer(codigo, i);
}
	}
	public void sub(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='S') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='U') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='B') {
					i++;
					if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
						erroresPreser();
					}else {
					token+="(SUB,TK_SUB)\n";
					paso=true;
					}}}}
if (paso==false) {
	erroresPreser();
}		
while (i<codigo.length()&&simblos(i, codigo)==false) {
	i++;
}
if (i<codigo.length()) {
	i++;
	recorrer(codigo, i);
}
	}
	public void mul(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='M') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='U') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='L') {
					i++;
					if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
					erroresPreser();	
					}else {
					token+="(MUL,TK_MUL)\n";
					paso=true;
					}}}}
if (paso==false) {
	erroresPreser();
}		
while (i<codigo.length()&&simblos(i, codigo)==false) {
	i++;
}
if (i<codigo.length()) {
	i++;
	recorrer(codigo, i);
}
	}
	public void div(int i, String codigo) {
		boolean paso=false;
		if (i<codigo.length()&&codigo.charAt(i)=='D') {
			i++;
			if (i<codigo.length()&&codigo.charAt(i)=='I') {
				i++;
				if (i<codigo.length()&&codigo.charAt(i)=='V') {
					i++;
					if (i<codigo.length()&&(Character.isLetter(codigo.charAt(i))||Character.isDigit(codigo.charAt(i)))) {
						erroresPreser();
					}else {
					token+="(DIV,TK_DIV)\n";
					paso=true;
					}}}}
if (paso==false) {
	erroresPreser();
}		
while (i<codigo.length()&&simblos(i, codigo)==false) {
	i++;
}
if (i<codigo.length()) {
	i++;
	recorrer(codigo, i);
}
	}
	public DefaultListModel<String > geterrores(){
		return modelerrores;
	}
	public  void erroresPreser() {
		modelerrores.addElement("Cadena Desconocida linea "+(linea+1));
	}
	public  void erroresSym() {
		modelerrores.addElement("Simbolo Desconocido linea "+(linea+1));
	}
	public  void erroresidenti() {
		modelerrores.addElement("ID no Valido linea "+(linea+1));
	}
	public  void erroresNum() {
		modelerrores.addElement("Valor no valido linea "+(linea+1));
	}
	
}
