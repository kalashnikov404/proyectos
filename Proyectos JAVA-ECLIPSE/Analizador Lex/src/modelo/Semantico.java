package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.plaf.SliderUI;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.itextpdf.text.pdf.ArabicLigaturizer;

public class Semantico {
	private ArrayList<Padre>  array;
	private ArrayList<IDsVa> ides;
	private ArrayList<String>noDeclarados;
	private DefaultListModel<String>errores;
	private int posIdes;
	private boolean bandera;


	public Semantico(ArrayList<Padre> arr) {
		array=arr;
		ides=new ArrayList<IDsVa>();
		posIdes=-1;
		errores=new DefaultListModel<String>();
		noDeclarados=new ArrayList<String>();
		bandera=true;
	}
	public void mostrar() {
		for (Padre padre : array) {
			System.out.println(padre.toString());
		}
	}
	public DefaultListModel<String> getErrores() {
		return errores;
	}

	public void moricion() {
		for (int i = array.size()-1; i >=0 ; i--) {
			if (array.get(i).getNombre().equals("DECLARACION")) {
				String tipo=buscarTipo(array.get(i).getNumero(),i);
				buscarIDs(array.get(i).getNumero(), i, tipo);
			}
		}

		for (int i = 0; i <array.size() ; i++) {
			if (array.get(i).getNombre().equals("OPERACIONCO")) {
				buscaAsignacion(array.get(i).getNumero(), i-1);
			}
		}
		for (int i = 0; i <array.size() ; i++) {
			if (array.get(i).getNombre().contains("id")) {
				checarID(array.get(i).getNombre());
			}
		}

	}

	public String ArchivoIdes() {
		String cadena="";
		for (IDsVa linea : ides) {
			cadena+=linea+"\n";
		}
		if (noDeclarados.size()>0) {
			for (int i = noDeclarados.size()-1; i >=0 ; i--) {
				cadena+=noDeclarados.get(i)+"	null	Indefinido\n";
			}
		}
		return cadena;
	}

	public String buscarTipo(int p,int i) {
		while (i>=0&&!(array.get(i).getNombre().equals("TIPO")&&array.get(i).getPadre()==p)) {
			i--;
		}

		int a=array.get(i).getNumero();
		while (i>=0&&array.get(i).getPadre()!=a) {
			i--;
		}
		return array.get(i).getNombre();
	}


	public boolean BuscarDuplicados(String nombre,String mj) {
		for (IDsVa iDsVa : ides) {
			if (iDsVa.getNombre().equals(nombre)) {
				mandarError(mj);
				return false;
			}
		}
		return true;
	}
	public void buscarIDs(int p,int i,String tipo) {
		while (i>=0&&!(array.get(i).getNombre().equals("LISTA")&&array.get(i).getPadre()==p)) {
			i--;
		}

		int a=array.get(i).getNumero();
		while (i>=0&&!(array.get(i).getNombre().equals("IDAsig")&&array.get(i).getPadre()==a)) {
			i--;
		}

		int ida=i-2,h3=array.get(i).getNumero();
		while (i>=0&&!((array.get(i).getNombre().equals("ASIGNACION")||array.get(i).getNombre().contains("id"))&&array.get(i).getPadre()==h3)) {
			i--;
		}
		if(i>=0&&array.get(i).getNombre().contains("id")&& BuscarDuplicados(setNombre(array.get(i).getNombre()),"Error doble declaracion de id")){

			ides.add(new IDsVa());
			posIdes++;
			ides.get(posIdes).setNombre(setNombre(array.get(i).getNombre()));
			ides.get(posIdes).setTipo(tipo);			

		}else {
			if(i>=0&&array.get(i).getNombre().equals("ASIGNACION")) {

				int h=array.get(i).getNumero();
				while (i>=0&&!(array.get(i).getNombre().contains("id")&&array.get(i).getPadre()==h)) {
					i--;
				}
				if (BuscarDuplicados(setNombre(array.get(i).getNombre()),"Error doble declaracion de id")) {
					ides.add(new IDsVa());
					posIdes++;
					ides.get(posIdes).setNombre(setNombre(array.get(i).getNombre()));
					ides.get(posIdes).setTipo(tipo);
					i=i-2;
					int h2=array.get(i).getNumero();
					while (i>=0&&!((array.get(i).getNombre().contains("entero")||array.get(i).getNombre().contains("real"))&&array.get(i).getPadre()==h2)) {
						i--;
					}
					if (array.get(i).getNombre().charAt(6)=='(') {
						String c="";
						for (int j = 7; j < array.get(i).getNombre().length()-1; j++) {
							c+=array.get(i).getNombre().charAt(j);
						}
						if (tipo.equals("INTEGER")) {
							ides.get(posIdes).setValor(c);
							//tipos al arbol
							array.get(h2-1).setTipo(tipo);
							array.get(h2+1).setTipo(tipo);
							array.get(h-1).setTipo(tipo);
							array.get(i).setTipo(tipo);

						}else {

							mandarError("Error asignacion invalida, los tipos no son igual");

						}
					} else {
						String c="";
						for (int j = 5; j < array.get(i).getNombre().length()-1; j++) {
							c+=array.get(i).getNombre().charAt(j);
						}
						if (tipo.equals("REAL")) {
							ides.get(posIdes).setValor(c);
							//tipos al arbol
							array.get(h2-1).setTipo(tipo);
							array.get(h2+1).setTipo(tipo);
							array.get(h-1).setTipo(tipo);
							array.get(i).setTipo(tipo);

						}else {
							mandarError("Error asignacion invalida, los tipos no son igual");

						}

					}

				}
			}
		}
		if(array.get(ida).getNombre().equals("LISTA")) {
			buscarIDs(array.get(ida).getPadre(),ida, tipo);
		}
	}
	public String setNombre(String nom) {
		String nom2="";
		for (int i = 3; i < nom.length()-1; i++) {
			nom2+=nom.charAt(i);
		}
		return nom2;
	}
	public void mandarError(String mj) {
		errores.addElement(mj);

	}
	public void buscaAsignacion(int p,int i) {
		while (i>=0&&!(array.get(i).getNombre().equals("ASIGNACION")&&array.get(i).getPadre()==p)) {
			i--;
		}
		int p2=array.get(i).getNumero();
		while (i>=0&&!(array.get(i).getNombre().contains("id")&&array.get(i).getPadre()==p2)) {
			i--;
		}

		if (array.get(i-2).getNombre().equals("VALOR")) {
			int p3=array.get(i-2).getNumero();
			int ip=i;

			while (i>=0&&!((array.get(i).getNombre().contains("entero")||array.get(i).getNombre().contains("real"))&&array.get(i).getPadre()==p3)) {
				i--;
			}

			if (array.get(i).getNombre().charAt(6)=='(') {
				String c="";
				for (int j = 7; j < array.get(i).getNombre().length()-1; j++) {
					c+=array.get(i).getNombre().charAt(j);
				}
				int in=posID(setNombre(array.get(ip).getNombre()));
				if (in>=0) {
					if (ides.get(in).getTipo().equals("INTEGER")) {
						ides.get(in).setValor(c);
						//tipos al arbol
						String tipo=ides.get(in).getTipo();
						array.get(p2-1).setTipo(tipo);
						array.get(p3+1).setTipo(tipo);
						array.get(p3-1).setTipo(tipo);
						array.get(i).setTipo(tipo);


					}else {

						mandarError("Error asignacion invalida, los tipos no son igual");

					}
				} else {
					mandarError("Error ID no declarado");

				}

			} else {
				String c="";
				for (int j = 5; j < array.get(i).getNombre().length()-1; j++) {
					c+=array.get(i).getNombre().charAt(j);
				}
				int in=posID(setNombre(array.get(ip).getNombre()));
				if (in>=0) {
					if (ides.get(in).getTipo().equals("REAL")) {
						String tipo=ides.get(in).getTipo();

						ides.get(in).setValor(c);
						array.get(p2-1).setTipo(tipo);
						array.get(p3+1).setTipo(tipo);
						array.get(i).setTipo(tipo);
					}else {

						mandarError("Error asignacion invalida, los tipos no son igual");

					}
				} else {

					mandarError("Error ID no declarado");

				}
			}
		}else {
			bandera=true;
			int in=posID(setNombre(array.get(i).getNombre()));
			if (in>-1) {
				String tipoID=ides.get(in).getTipo();
				//p2-1,p3+1,p3-1
				ArrayList<Integer>d=new ArrayList<Integer>();
				d.add(p2-1);// asigmacion
				
				d.add(i);// id
				int pos=posID(setNombre(array.get(i).getNombre()));
				String tipo=ides.get(pos).getTipo();

				d=revizarOperaciones(i-2,tipoID,d);
				///
				if (!bandera) {
					errores.addElement("Error de tipos en la Operacion");
				}else {
					for (int j = 0; j < d.size(); j++) {

						array.get(d.get(j)).setTipo(tipo);
					}
				}
			}else {

				mandarError("Error ID no declarado");
			}

		}	
	}
	public int posID(String id) {
		for (int i = 0; i < ides.size(); i++) {
			if (ides.get(i).getNombre().equals(id)) {
				return i;
			}
		}
		for (int i = 0; i < noDeclarados.size(); i++) {
			if (noDeclarados.get(i).equals(id)) {
				return -1;
			}
		}
		noDeclarados.add(id);
		return -1;
	}
	public void checarID(String id) {
		int i;
		boolean b=true;
		id=setNombre(id);
		for ( i = 0; i < ides.size(); i++) {
			if (ides.get(i).getNombre().equals(id)) {
				b=false;
			}
		}
		if (b) {
			for ( i = 0; i < noDeclarados.size(); i++) {
				if (noDeclarados.get(i).equals(id)) {
					b=false;
				}

			}
			if (b) {
				noDeclarados.add(id);
				System.out.println("chale");
				errores.addElement("Error ID no declarado");
			}
		}
	}
	public ArrayList<Integer> revizarOperaciones(int i,String tipoID,ArrayList<Integer> d) {
		if (array.get(i).getNombre().equals("OPERACION")) {

			int o=array.get(i).getNumero();
			d.add(o-1);
			while (i>=0&&!(array.get(i).getNombre().equals("CONTENEDOR")&&array.get(i).getPadre()==o)) {
				i--;
			}

			int o2=array.get(i).getNumero();
			d.add(o2-1);
			while (i>=0&&!(array.get(i).getNombre().equals("DIJITOS")&&array.get(i).getPadre()==o2)) {
				i--;
			}
			int o3=array.get(i).getNumero();
			d.add(o3-1);
			while (i>=0&&!(array.get(i).getNombre().equals("OP")&&array.get(i).getPadre()==o3)) {
				i--;
			}


			int o4=array.get(i).getNumero();
			int o5=array.get(i-2).getNumero();
			d.add(o4-1);
			d.add(o5-1);
			d=revicion(i, o4, tipoID,d);
			d=revicion(i, o5, tipoID,d);

		}
		return d;
	}

	public ArrayList<Integer> revicion(int i,int os,String tipoID,ArrayList<Integer>d) {
		int inp;

		while (i>=0&&!((array.get(i).getNombre().contains("id")||array.get(i).getNombre().equals("VALOR")||array.get(i).getNombre().equals("OPERACION"))&&array.get(i).getPadre()==os)) {
			i--;
		}
		
		if (array.get(i).getNombre().contains("id")) {
			d.add(i);
			inp=posID(setNombre(array.get(i).getNombre()));
			if (inp>-1) {
				if (ides.get(inp).getTipo().equals(tipoID)) {

				} else {
					bandera=false;
				}
			}else {
				mandarError("Error ID no declarado");

			}

		} else {
			if (array.get(i).getNombre().equals("VALOR")) {
				d.add(i);
				int o5=array.get(i).getNumero();
				while (i>=0&&!((array.get(i).getNombre().contains("entero")||array.get(i).getNombre().contains("real"))&&array.get(i).getPadre()==o5)) {
					i--;
				}
				d.add(i);
				if (tipoID.equals("INTEGER")) {
					if (!array.get(i).getNombre().contains("entero")) {
						bandera=false;
					} 
				} else {
					if (tipoID.equals("REAL")) {
						if (!array.get(i).getNombre().contains("real")) {
							bandera=false;
						} 
					}
				}

			} else {
				if (array.get(i).getNombre().equals("OPERACION")) {
					revizarOperaciones(i, tipoID,d);
				} else {

				}
			}
		}
		return d;

	}

}
