package modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana2 extends JFrame {
	private JFileChooser abrirArchivo;
	private JPanel contentPane;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JTextPane textPaneErrores;

	private ArrayList<String> tokens = new ArrayList<String>();// tokens
	private ArrayList<String> identificadores = new ArrayList<String>();// identificadores
	private ArrayList<String> tokensSeparados = new ArrayList<String>();
	private ArrayList<String> lexemas = new ArrayList<String>();

	private int n = 0;
	private ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	private ArrayList<Token> pila = new ArrayList<Token>();
	private ArrayList<String> erroresSintacticos;
	private boolean baderaErrorSemantico = false;
	private ArrayList<String> errores = new ArrayList<String>();
	private int lineas = 1;
	private int i = 0;
	private boolean baderaErrores = false;
	// -------------------------------------------------------------Variables
	// Analisis sintactico----------------------------------------
	private String reglaIncio2 = "palabra_Inicio corcheteA";
	private String reglaTipo = "palabra_tipo reglaVariable";
	private String reglaVariable = "identificador/identificador igual numero/identificador igual decimal/identificador igual numero coma reglaVariable/identificador igual decimal coma reglaVariable/identificador coma reglaVariable";
	private String reglaFin = "corcheteC palabra_fin";
	private String reglaAsignacion = "identificador igual numero/identificador igual reglaFuncion";
	private String reglaFuncion = "palabra_operacion parentesisA numero coma identificador parentesisC/"
			+ "palabra_operacion parentesisA numero coma numero parentesisC/"
			+ "palabra_operacion parentesisA identificador coma numero parentesisC/"
			+ "palabra_operacion parentesisA identificador coma identificador parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma numero parentesisC/"
			+ "palabra_operacion parentesisA numero coma reglaFuncion parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma identificador parentesisC/"
			+ "palabra_operacion parentesisA identificador coma reglaFuncion parentesisC/"// ;
			+ "palabra_operacion parentesisA decimal coma decimal parentesisC/"// decimales
			+ "palabra_operacion parentesisA identificador coma decimal parentesisC/"
			+ "palabra_operacion parentesisA reglaFuncion coma decimal parentesisC/"
			+ "palabra_operacion parentesisA decimal coma reglaFuncion parentesisC/";
	private String reglaAccion = "palabra_accion parentesisA numero parentesisC/"
			+ "palabra_accion parentesisA identificador parentesisC";
	private Stack<Token> stack = new Stack<Token>();
	private boolean convertir = false;
	private ArrayList<String> reglas;
	private String reglaActual = "";
	private String subRegla = "";
	private int posicionSubPilaAnterior = 0;
	private int posicionSubPila = 0;
	private ArrayList<LineaArbol> lineasA;
	private int numNodo = 1;
	private int countSubReglas = 0;
	private ArrayList<Arbol> arboles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana2() {
		reglas = new ArrayList<>();
		reglas.add(reglaIncio2);
		reglas.add(reglaAccion);
		reglas.add(reglaAsignacion);
		reglas.add(reglaFin);
		reglas.add(reglaFuncion);
		reglas.add(reglaTipo);
		reglas.add(reglaVariable);
		lineasA = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 735);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollText = new JScrollPane();
		scrollText.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		scrollText.setBounds(22, 138, 546, 448);
		contentPane.add(scrollText);

		JTextPane textPaneCod = new JTextPane();
		scrollText.setViewportView(textPaneCod);
		textPaneCod.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		textPaneCod.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPaneCod.setForeground(new Color(0, 0, 0));

		JScrollPane scrollErrores = new JScrollPane();
		scrollErrores.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		scrollErrores.setBounds(22, 597, 956, 90);
		contentPane.add(scrollErrores);

		textPaneErrores = new JTextPane();
		scrollErrores.setRowHeaderView(textPaneErrores);
		textPaneErrores.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		scrollPane.setBounds(631, 138, 347, 448);
		contentPane.add(scrollPane);

		tabla = new JTable();
		tabla.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tabla.setBackground(new Color(255, 255, 255));
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("Valor");

		tabla.setModel(modeloTabla);
		scrollPane.setViewportView(tabla);

		JButton btnExportarArchivoTokens = new JButton("Analisis Lexico");
		btnExportarArchivoTokens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String codigo = textPaneCod.getText();
				if (!codigo.isEmpty()) {
					analizar(codigo);
					for (int i = 0; i < tokensSeparados.size(); i++) {
						System.out.println(tokensSeparados.get(i).toString());
					}
				}

				/*
				 * //yulia String pErrores=textPaneErrores.getText(); String m="No hay errores";
				 * if (pErrores==m) { JOptionPane.showMessageDialog(null,
				 * "Entra a no hay errores"); }else {
				 * 
				 * JOptionPane.showMessageDialog(null, "No se puede hasta quitar errores");
				 * 
				 * }
				 */

				if (!tokens.isEmpty()) {
					try {
						File fichero = new File(
								"C:\\Users\\Grudges\\eclipse-workspace\\APP ANALIZADOR SEMANTICO\\src\\tokens.txt"); // RUTA
																														// LAP
						FileOutputStream fos = new FileOutputStream(fichero);
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
						for (int i = 0; i < tokens.size(); i++) {
							bw.write(tokens.get(i)); // VA ESCRIBIENDO EL ARCHVIO
							bw.newLine();
						}

						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Tokens generados");
				} else {
					JOptionPane.showMessageDialog(null, "Tokens no generados");
				}

			}
		});
		btnExportarArchivoTokens.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

			}
		});
		btnExportarArchivoTokens.setForeground(Color.WHITE);
		btnExportarArchivoTokens.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnExportarArchivoTokens.setBackground(Color.RED);
		btnExportarArchivoTokens.setBounds(332, 77, 183, 39);
		contentPane.add(btnExportarArchivoTokens);

		JButton btnSintactico = new JButton("Analisis Sintactico");
		btnSintactico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				tokensSeparados.add("tk_BEGIN");
				erroresSintacticos = new ArrayList<String>();
				int j = 0;
				lineas = 1;
				verificaErrores(j);
				if (erroresSintacticos.isEmpty()) {
					// for (int h = 0; h < lexemas.size(); h++) {
					// System.out.println(lexemas.get(h).toString());
					// }
					/*
					 * for (int j = 0; j < nodos.size(); j++) {
					 * System.out.println(nodos.get(j).toString()); }
					 * 
					 * for (int j = 0; j < pila.size(); j++) {
					 * System.out.println(pila.get(j).toString()); }
					 */
					// nodos=new ArrayList<Nodo>();
					// pila=new ArrayList<Token>();
					int k = 0;
					nodos = new ArrayList<Nodo>();
					pila = new ArrayList<Token>();
					n = 0;
					AnalisisSitactico(k);
					for (int i = 0; i < nodos.size(); i++) {
						System.out.println(nodos.get(i).toString());
					}
					if (!nodos.isEmpty()) {
						try {
							File fichero = new File(
									"C:\\Users\\Grudges\\eclipse-workspace\\APP ANALIZADOR SEMANTICO\\src\\nodosSintactico.txt"); // RUTA
																																	// LAP
							FileOutputStream fos = new FileOutputStream(fichero);

							BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

							for (int i = 0; i < nodos.size(); i++) {
								bw.write("Numero=" + nodos.get(i).getNumero() + " Nombre=" + nodos.get(i).getNombre()
										+ " Padre=" + nodos.get(i).getPadre()); // VA ESCRIBIENDO EL ARCHVIO
								bw.newLine();
							}
							// nodos.clear();
							// pila.clear();
							System.out.println(nodos.size());
							System.out.println(pila.size());
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Nodos generados");

					} else {
						JOptionPane.showMessageDialog(null, "Nodos no generados");
					}

				} else {
					String cadenaErrores = "";
					for (int i = 0; i < erroresSintacticos.size(); i++) {
						cadenaErrores += erroresSintacticos.get(i) + "\n";
					}
					textPaneErrores.setText(cadenaErrores);
				}

			}
		});
		btnSintactico.setBounds(547, 77, 183, 39);
		btnSintactico.setForeground(new Color(255, 255, 255));
		btnSintactico.setBackground(new Color(50, 205, 50));
		btnSintactico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnSintactico);

		JButton btnNewButton = new JButton("Analisis Semantico");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cargarArchivo();
				int i = 0;
				baderaErrorSemantico = false;
				analisisSemantico(i, nodos);
				if (baderaErrorSemantico == false) {
					if (!nodos.isEmpty()) {
						try {
							File fichero = new File(
									"C:\\Users\\Grudges\\eclipse-workspace\\APP ANALIZADOR SEMANTICO\\src\\arbolSemantico.txt"); // RUTA
																																	// LAP
							FileOutputStream fos = new FileOutputStream(fichero);

							BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

							for (int j = 0; j < nodos.size(); j++) {
								bw.write(nodos.get(j).toString()); // VA ESCRIBIENDO EL ARCHVIO
								bw.newLine();
							}

							bw.close();
						} catch (IOException k) {
							// TODO Auto-generated catch block
							k.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Nodos generados");

					} else {
						JOptionPane.showMessageDialog(null, "Nodos no generados");
					}
				} else {

				}
			}
		});
		btnNewButton.setBounds(759, 77, 188, 39);
		contentPane.add(btnNewButton);
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (abrirArchivo == null)
					abrirArchivo = new JFileChooser();
				// Con esto solamente podamos abrir archivos
				abrirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int seleccion = abrirArchivo.showOpenDialog(abrirArchivo);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File f = abrirArchivo.getSelectedFile();
					try {
						String nombre = f.getName();
						String path = f.getAbsolutePath();
						String contenido = getArchivo(path);
						// En el editor de texto colocamos su contenido
						textPaneCod.setText(contenido);

					} catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "No se ha abierto ningun archivo, intenta de nuevo");
					}
				}

			}

		});
		btnAbrir.setForeground(Color.WHITE);
		btnAbrir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAbrir.setBackground(new Color(0, 191, 255));
		btnAbrir.setBounds(22, 77, 125, 39);
		contentPane.add(btnAbrir);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textPaneErrores.setText(null);
				textPaneCod.setText(null);
				DefaultTableModel model = (DefaultTableModel) tabla.getModel();
				model.setRowCount(0);

			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLimpiar.setBackground(new Color(0, 206, 209));
		btnLimpiar.setBounds(161, 77, 125, 39);
		contentPane.add(btnLimpiar);

		JLabel lblNewLabel = new JLabel("Analizador");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 36, 956, 30);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}

//Metodos 	
	public void analizar(String cod) {
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("Valor");
		tabla.setModel(modeloTabla);

		tokensSeparados = new ArrayList<String>();
		lexemas = new ArrayList<String>();
		tokens = new ArrayList<String>();// tokens
		identificadores = new ArrayList<String>();// identificadores
		errores = new ArrayList<String>();// errores que pueden llegarse a presentar
		int lineas = 1;

		String patron = ("(INICIO)|"// grupo 1
				+ "(FIN)|"// grupo 2
				+ "(ENTERO|REAL)|" // grupo 3
				+ "(SUM|RES|MUL|DIV)|"// grupo 4
				+ "(LEER|ESCRIBIR)|"// grupo 5
				+ "([a-z][0-9]{1,3})|" // grupo 6
				+ "(\\.)|" // grupo 7
				+ ("(;)|")// grupo 8
				+ ("(=)|")// grupo 9
				+ ("(\\()|")// grupo 10 parentesis
				+ ("(\\))|")// grupo 11 parentesis que cierra
				+ ("(\\{)|") // grupo 12 corchete abre
				+ ("(\\})|")// grupo 13 corchete c
				+ "([0-9]{1,5}\\.[0-9]{1,2})"// grupo 14
				+ "|([0-9]{1,5})|" // grupo 15
				+ "(,)|"// grupo 16 coma
				+ "(\r\n)|" // grupo 17 saltos de linea(para contabilizar
				+ "([\\S]+)"); // grupo 18 errores

		Pattern p = Pattern.compile(patron); // compila el patron
		Matcher m = p.matcher(cod);// hace match xD con los posibles grupos
		while (m.find()) { // mientras encuentre patrones se va repetir el ciclo
			String token1 = m.group(1);
			if (token1 != null) {
				tokens.add("<palabra_Inicio><" + token1 + ">"); // encontro una plabra reservada
				tokensSeparados.add("tk_" + token1);
				lexemas.add(token1);
				// System.out.println("entra");
			}
			String token2 = m.group(2);
			if (token2 != null) {
				// System.out.println("entro");
				tokens.add("<palabra_fin><" + token2 + ">"); // encontro una plabra reservada
				tokensSeparados.add("tk_" + token2);
				lexemas.add(token2);
			}
			String token3 = m.group(3);
			if (token3 != null) {
				tokens.add("<palabra_tipo><" + token3 + ">"); // encontro una plabra reservada
				tokensSeparados.add("tk_" + token3);
				lexemas.add(token3);
			}
			String token4 = m.group(4);
			if (token4 != null) {
				tokens.add("<palabra_operacion><" + token4 + ">"); // encontro una plabra reservada
				tokensSeparados.add("tk_" + token4);
				lexemas.add(token4);
			}
			String token5 = m.group(5);
			if (token5 != null) {
				tokens.add("<palabra_accion><" + token5 + ">"); // encontro una plabra reservada
				tokensSeparados.add("tk_" + token5);
				lexemas.add(token5);
			}

			String token6 = m.group(6);
			if (token6 != null) {
				if (tokens.size() > 0) {
					String tkaux = tokens.get(tokens.size() - 1);
					if (tokens.get(tokens.size() - 1).contains("numero")
							|| tokens.get(tokens.size() - 1).contains("decimal")) {
						if (tokens.get(tokens.size() - 1).contains("decimal")) {// caso en el que sea decimal parte de
																				// el error
							tkaux = tkaux.replace("<", "");
							tkaux = tkaux.replace(">", "");
							tkaux = tkaux.replace("decimal", "");
							System.out.println(tkaux);
						} else if (tkaux.contains("numero")) { // caso en el que el un numero sea el error
							tkaux = tkaux.replace("<", "");
							tkaux = tkaux.replace(">", "");
							tkaux = tkaux.replace("numero", "");
							System.out.println(tkaux);

						}
						token6 = tkaux + token6;
						errores.add("Error en la linea " + lineas + ": " + token6);
						tokens.remove(tokens.size() - 1);

					}

					else {
						tokens.add("<identificador><" + token6 + ">"); // encontro un identificador
						tokensSeparados.add("tk_var");
						lexemas.add(token6);
						boolean existe = false;
						for (int i = 0; i < identificadores.size(); i++) {
							if (identificadores.get(i).equals(token6)) { // si ya existe no lo mete al array de
																			// identificadores
								existe = true;
							}
						}
						if (!existe) {
							identificadores.add(token6);
						}

					}
				} else {
					tokens.add("<identificador><" + token6 + ">"); // encontro un identificador
					boolean existe = false;
					for (int i = 0; i < identificadores.size(); i++) {
						if (identificadores.get(i).equals(token6)) { // si ya existe no lo mete al array de
																		// identificadores
							existe = true;
						}
					}
					if (!existe) {
						identificadores.add(token6);
					}
				}

			}
			String token7 = m.group(7);
			if (token7 != null) {
				if (tokens.size() > 0) {
					String tkaux = tokens.get(tokens.size() - 1); // verifica si el punto no es parte de un numero
																	// decimal ya que solo se puede poner un punto no
																	// dos ejemplo(10.0.0)
					if (token7.equalsIgnoreCase(".") && tokens.get(tokens.size() - 1).contains("decimal")) { // checa en
																												// la
																												// posicion
																												// del
																												// array
																												// anterios
																												// si
																												// encontro
																												// un
																												// decimal
																												// si
																												// ese
																												// es el
																												// caso
																												// se
																												// quita
																												// el
																												// numero
																												// del
																												// array
																												// y se
																												// toma
																												// como
																												// error
																												// junto
																												// con
																												// el
																												// punto
						tkaux = tkaux.replace("<", "");
						tkaux = tkaux.replace(">", "");
						tkaux = tkaux.replace("decimal", "");
						token7 = tkaux + token7;
						tokens.remove(tokens.size() - 1);

						errores.add("Error en la linea " + lineas + ": " + token7);
					} else {
						tokens.add("<simbolo><" + token7 + ">"); // se agrega el simbolo si no hubo error

					}
				} else {
					tokens.add("<simbolo><" + token7 + ">");
					tokensSeparados.add("tk_" + token7);
					lexemas.add(token7);
				}
			}
			String token8 = m.group(8);
			if (token8 != null) {
				tokens.add("<Punto_y_coma><" + token8 + ">");
				tokensSeparados.add("tk_" + token8);
				lexemas.add(token8);
			}
			String token9 = m.group(9);
			if (token9 != null) {
				tokens.add("<igual><" + token9 + ">");
				tokensSeparados.add("tk_" + token9);
				lexemas.add(token9);
			}
			String token10 = m.group(10);
			if (token10 != null) {
				tokens.add("<parentesisA><" + token10 + ">");
				tokensSeparados.add("tk_" + token10);
				lexemas.add(token10);
			}
			String token11 = m.group(11);
			if (token11 != null) {
				tokens.add("<parentesisC><" + token11 + ">");
				tokensSeparados.add("tk_" + token11);
				lexemas.add(token11);
			}

			String token12 = m.group(12);
			if (token12 != null) {
				tokens.add("<corcheteA><" + token12 + ">");
				tokensSeparados.add("tk_" + token12);
				lexemas.add(token12);
			}

			String token13 = m.group(13);
			if (token13 != null) {
				tokens.add("<corcheteC><" + token13 + ">");
				tokensSeparados.add("tk_" + token13);
				lexemas.add(token13);
			}

			String token14 = m.group(14);
			if (token14 != null) {
				tokens.add("<decimal><" + token14 + ">");
				tokensSeparados.add("tk_decimal");
				lexemas.add(token14);
			}
			String token15 = m.group(15);
			if (token15 != null) {

				tokens.add("<numero><" + token15 + ">");
				tokensSeparados.add("tk_entero");
				lexemas.add(token15);

			}
			String token16 = m.group(16);
			if (token16 != null) {
				tokens.add("<coma><,>");
				tokensSeparados.add("tk_,");
				lexemas.add(",");
			}

			// String token17=m.group(17);
			// if (token17!=null) { // encontro un salto de linea las contabiliza
			// lineas=lineas+1;
			// tokens.add("<espacio>< >");
			// }
			String token18 = m.group(18);
			if (token18 != null) { // da a concocer los errores como palabras mal escrotas.
				errores.add("Error en la linea " + lineas + " :" + token18);
			}
			// lineas++;

		}
		System.out.println(tokens.toString());
		System.out.println(identificadores.toString());
		System.out.println(errores.toString());
		if (!errores.isEmpty()) {
			textPaneErrores.setText(errores.toString()); // imprime en la ventana los errores
		} else {
			textPaneErrores.setText("No hay errores");
		}
		llenar(identificadores); // llena la tabla de los identificadores

	}

	public void llenar(ArrayList<String> tokens) {
		// Object [] ob= new Object[1];
		for (int i = 0; i < tokens.size(); i++) {
			// if(tokens.get(i).contains("numero")) {
			//
			// }
			// else if(tokens.get(i).contains("decimal")) {
			//
			// }
			String aux = tokens.get(i);
			aux.replace("<", "");
			aux.replace(">", "");
			aux.replace("identificador", "");
			String arreglo[] = { aux, "", "" };

			modeloTabla.addRow(arreglo);

		}
	}

	public void AnalisisSitactico(int i) {
		if (i < tokensSeparados.size()) {
			if (tokensSeparados.get(i).equals("tk_INICIO")) {
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				// pila.add(tokensSeparados.get(i));
				i++;
				if (tokensSeparados.get(i).equals("tk_{")) {
					String token2 = tokensSeparados.get(i);
					String lexema2 = lexemas.get(i);
					pila.add(new Token(token2, lexema2));
					// pila.add(tokensSeparados.get(i));
					String cadena = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					verificaReglaInicio(cadena, i);
				}

			} else if (tokensSeparados.get(i).equals("tk_ESCRIBIR") || tokensSeparados.get(i).equals("tk_LEER")) {
				// System.out.println("entro a write");
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				// pila.add(tokensSeparados.get(i));
				verificaRegla(pila.get(pila.size() - 1).getToken(), i);
				i++;
				if (tokensSeparados.get(i).equals("tk_(")) {
					System.out.println("entro a (");
					String token2 = tokensSeparados.get(i);
					String lexema2 = lexemas.get(i);
					pila.add(new Token(token2, lexema2));
					// pila.add(tokensSeparados.get(i));
					// verificaRegla(pila.get(pila.size()-1).getToken(),i);
					i++;
					if (tokensSeparados.get(i).equals("tk_var") || tokensSeparados.get(i).equals("tk_entero")
							|| tokensSeparados.get(i).equals("tk_decimal")) {
						// System.out.println("entro a var");
						String token3 = tokensSeparados.get(i);
						String lexema3 = lexemas.get(i);
						pila.add(new Token(token3, lexema3));
						// pila.add(tokensSeparados.get(i));
						verificaRegla(pila.get(pila.size() - 1).getToken(), i);
						i++;
						if (tokensSeparados.get(i).equals("tk_)")) {
							// System.out.println("entro a )");
							String token4 = tokensSeparados.get(i);
							String lexema4 = lexemas.get(i);
							pila.add(new Token(token4, lexema4));
							// pila.add(tokensSeparados.get(i));
							String cadena = pila.get(pila.size() - 1 - 1 - 1).getToken() + ""
									+ pila.get(pila.size() - 1 - 1).getToken() + ""
									+ pila.get(pila.size() - 1).getToken();
							System.out.println(cadena);
							verificaRegla(" ", i);
							i++;
							if (tokensSeparados.get(i).equals("tk_;")) {
								// System.out.println("entro a ;");
								String token5 = tokensSeparados.get(i);
								String lexema5 = lexemas.get(i);
								pila.add(new Token(token5, lexema5));
								// pila.add(tokensSeparados.get(i));
								String cadena2 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
										+ pila.get(pila.size() - 1 - 1).getToken() + " "
										+ pila.get(pila.size() - 1).getToken();
								verificaRegla("DE", i);

							}
						}
					}
				}
			} else if (tokensSeparados.get(i).equals("tk_ENTERO") || tokensSeparados.get(i).equals("tk_REAL")) {
				// System.out.println("entro a integer");
				// pila.add(tokensSeparados.get(i));
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				verificaReglasDeclaracion(pila.get(pila.size() - 1).getToken());
				i++;
				if (tokensSeparados.get(i).equals("tk_var")) {
					// System.out.println("entro a var");
					// pila.add(tokensSeparados.get(i));
					String token2 = tokensSeparados.get(i);
					String lexema2 = lexemas.get(i);
					pila.add(new Token(token2, lexema2));
					i++;
					obtenerTokensDeclaracion(pila, i);

				}
			} else if (tokensSeparados.get(i).equals("tk_SUM") || tokensSeparados.get(i).equals("tk_RES")
					|| tokensSeparados.get(i).equals("tk_MUL") || tokensSeparados.get(i).equals("tk_DIV")) {
				// System.out.println("entro a ADD");
				// pila.add(tokensSeparados.get(i));
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
				i++;
				obtenerTokensOperacion(pila, i);

			} else if (tokensSeparados.get(i).equals("tk_}")) {
				// pila.add(tokensSeparados.get(i));
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				i++;
				if (tokensSeparados.get(i).equals("tk_FIN")) {
					// pila.add(tokensSeparados.get(i));
					String token2 = tokensSeparados.get(i);
					String lexema2 = lexemas.get(i);
					pila.add(new Token(token2, lexema2));
					String cadena = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					verificaReglaFin(cadena, i);
				}
			} else if (tokensSeparados.get(i).equals("tk_var")) {
				// pila.add(tokensSeparados.get(i));
				String token = tokensSeparados.get(i);
				String lexema = lexemas.get(i);
				pila.add(new Token(token, lexema));
				i++;
				if (tokensSeparados.get(i).equals("tk_=")) {
					// pila.add(tokensSeparados.get(i));
					String token2 = tokensSeparados.get(i);
					String lexema2 = lexemas.get(i);
					pila.add(new Token(token2, lexema2));
					i++;
					if (tokensSeparados.get(i).equals("tk_SUM") || tokensSeparados.get(i).equals("tk_RES")
							|| tokensSeparados.get(i).equals("tk_MUL") || tokensSeparados.get(i).equals("tk_DIV")) {
						// pila.add(tokensSeparados.get(i));
						String token3 = tokensSeparados.get(i);
						String lexema3 = lexemas.get(i);
						pila.add(new Token(token3, lexema3));
						verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
						i++;
						obtenerTokensOperacion(pila, i);

					} else if (tokensSeparados.get(i).equals("tk_var") || tokensSeparados.get(i).equals("tk_entero")
							|| tokensSeparados.get(i).equals("tk_decimal")) {
						String token4 = tokensSeparados.get(i);
						String lexema4 = lexemas.get(i);
						pila.add(new Token(token4, lexema4));
						i++;
						if (tokensSeparados.get(i).equals("tk_;")) {
							String token5 = tokensSeparados.get(i);
							String lexema5 = lexemas.get(i);
							pila.add(new Token(token5, lexema5));
							String cadena = pila.get(pila.size() - 1 - 1).getToken() + " "
									+ pila.get(pila.size() - 1).getToken();
							verificaReglaAsignacion(cadena, i);
						}

					}
				}
			}
		}
	}

	public void verificaReglaAsignacion(String tokens, int i) {
		if (tokens.equals("tk_var tk_;") || tokens.equals("tk_entero tk_;") || tokens.equals("tk_decimal tk_;")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("numero", "null"));
			String cadena = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
					+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
			if (cadena.equals("tk_var tk_= numero")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("ASIG", "null"));
				String cadena2 = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				if (cadena2.equals("codigo ASIG")) {
					agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
					pila.remove(pila.size() - 1);
					agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
					pila.remove(pila.size() - 1);
					pila.add(new Token("codigo", "null"));
					i++;
					AnalisisSitactico(i);
					// pila.add("codigo");
				} else {
					agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
					pila.remove(pila.size() - 1);
					pila.add(new Token("codigo", "null"));
					i++;
					AnalisisSitactico(i);
					// pila.add("codigo");
				}
			}

		}
	}

	public void obtenerTokensOperacion(ArrayList<Token> pila, int i) {
		if (tokensSeparados.get(i).equals("tk_(")) {
			// System.out.println("entro a ( OP");
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			i++;
			if (tokensSeparados.get(i).equals("tk_var") || tokensSeparados.get(i).equals("tk_entero")
					|| tokensSeparados.get(i).equals("tk_decimal")) {
				// System.out.println("entro a var OP");
				// pila.add(tokensSeparados.get(i));
				String token2 = tokensSeparados.get(i);
				String lexema2 = lexemas.get(i);
				pila.add(new Token(token2, lexema2));
				verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
				i++;
				if (tokensSeparados.get(i).equals("tk_,")) {
					// pila.add(tokensSeparados.get(i));
					String token3 = tokensSeparados.get(i);
					String lexema3 = lexemas.get(i);
					pila.add(new Token(token3, lexema3));
					String cadena = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena);
					i++;
					obtenerTokensOperacion2(pila, i);

				}
			} else if (tokensSeparados.get(i).equals("tk_SUM") || tokensSeparados.get(i).equals("tk_RES")
					|| tokensSeparados.get(i).equals("tk_MUL") || tokensSeparados.get(i).equals("tk_DIV")) {
				// pila.add(tokensSeparados.get(i));
				String token4 = tokensSeparados.get(i);
				String lexema4 = lexemas.get(i);
				pila.add(new Token(token4, lexema4));
				verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
				i++;
				obtenerTokensOperacion(pila, i);
			}
		}
	}

	public void obtenerTokensOperacion2(ArrayList<Token> pila, int i) {
		if (tokensSeparados.get(i).equals("tk_var") || tokensSeparados.get(i).equals("tk_entero")
				|| tokensSeparados.get(i).equals("tk_decimal")) {
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
			i++;
			if (tokensSeparados.get(i).equals("tk_)")) {
				// pila.add(tokensSeparados.get(i));
				String token2 = tokensSeparados.get(i);
				String lexema2 = lexemas.get(i);
				pila.add(new Token(token2, lexema2));
				i++;
				if (tokensSeparados.get(i).equals("tk_;")) {
					// pila.add(tokensSeparados.get(i));
					String token3 = tokensSeparados.get(i);
					String lexema3 = lexemas.get(i);
					pila.add(new Token(token3, lexema3));
					String cadena2 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena2);
					String cadena3 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion("finOP");
					String cadena5 = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					// System.out.println("RES DE CADENA 5: "+cadena5);
					if (cadena5.equals("inicio codigo")) {
						verificaReglasOperacion(cadena5);
						i++;
						AnalisisSitactico(i);
					} else if (cadena5.equals("tk_= codigo")) {
						String cadena6 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
								+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
						verificaReglasOperacion(cadena6);
						i++;
						AnalisisSitactico(i);
					}

				} else if (tokensSeparados.get(i).equals("tk_,")) {
					String cadena4 = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena4);

					String cadena5 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena5);

					// pila.add(tokensSeparados.get(i));
					String token3 = tokensSeparados.get(i);
					String lexema3 = lexemas.get(i);
					pila.add(new Token(token3, lexema3));
					String cadena6 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena6);
					i++;
					obtenerTokensOperacion2(pila, i);
				} else if (tokensSeparados.get(i).equals("tk_)")) {
					String cadena7 = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena7);

					String cadena8 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena8);
					obtenerTokensOperacion3(pila, i);
				}

			}
		} else if (tokensSeparados.get(i).equals("tk_SUM") || tokensSeparados.get(i).equals("tk_RES")
				|| tokensSeparados.get(i).equals("tk_MUL") || tokensSeparados.get(i).equals("tk_DIV")) {
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			verificaReglasOperacion(pila.get(pila.size() - 1).getToken());
			i++;
			obtenerTokensOperacion(pila, i);
		}

	}

	public void obtenerTokensOperacion3(ArrayList<Token> pila, int i) {
		if (tokensSeparados.get(i).equals("tk_)")) {
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			i++;
			if (tokensSeparados.get(i).equals("tk_)")) {
				String cadena = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				verificaReglasOperacion(cadena);

				String cadena2 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
						+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				verificaReglasOperacion(cadena2);
				obtenerTokensOperacion3(pila, i);
			} else if (tokensSeparados.get(i).equals("tk_;")) {
				// System.out.println("entro fin");
				// pila.add(tokensSeparados.get(i));
				String token2 = tokensSeparados.get(i);
				String lexema2 = lexemas.get(i);
				pila.add(new Token(token2, lexema2));
				String cadena3 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
						+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				verificaReglasOperacion(cadena3);
				String cadena4 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
						+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				if (cadena4.equals("R E S")) {
					verificaReglasOperacion("finOP");
					String cadena5 = pila.get(pila.size() - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1).getToken();
					// System.out.println("RES DE CADENA 5: "+cadena5);
					if (cadena5.equals("inicio codigo")) {
						verificaReglasOperacion(cadena5);
						i++;
						AnalisisSitactico(i);
					} else if (cadena5.equals("tk_= codigo")) {
						String cadena6 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
								+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
						verificaReglasOperacion(cadena6);
						i++;
						AnalisisSitactico(i);
					}
				}

			} else if (tokensSeparados.get(i).equals("tk_,")) {
				String cadena4 = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				verificaReglasOperacion(cadena4);

				String cadena5 = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				// System.out.println("RES DE CADENA 5: "+cadena5);
				if (cadena5.equals("inicio codigo")) {
					verificaReglasOperacion(cadena5);
					i++;
					AnalisisSitactico(i);
				} else if (cadena5.equals("tk_= codigo")) {
					String cadena6 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
							+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
					verificaReglasOperacion(cadena6);
					i++;
					AnalisisSitactico(i);
				}
//				String cadena5=pila.get(pila.size()-1-1-1).getToken() +" "+pila.get(pila.size()-1-1).getToken() +" " + pila.get(pila.size()-1).getToken();
//				System.out.println("cadena 5:" + cadena5);
//				verificaReglasOperacion(cadena5);

				// pila.add(tokensSeparados.get(i));
				String token3 = tokensSeparados.get(i);
				String lexema3 = lexemas.get(i);
				pila.add(new Token(token3, lexema3));
				String cadena6 = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
						+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
				verificaReglasOperacion(cadena6);
				i++;
				obtenerTokensOperacion2(pila, i);
			}

		}

	}

	public void verificaReglasOperacion(String token) {
		if (token.equals("tk_SUM") || token.equals("tk_RES") || token.equals("tk_MUL") || token.equals("tk_DIV")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("R");
			pila.add(new Token("R", "null"));
		} else if (token.equals("tk_( D tk_,") || token.equals("tk_( O tk_,")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("E");
			pila.add(new Token("E", "null"));

		} else if (token.equals("D tk_) tk_;")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("S");
			pila.add(new Token("S", "null"));

		} else if (token.equals("tk_var") || token.equals("tk_entero") || token.equals("tk_decimal")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("D");
			pila.add(new Token("D", "null"));
		} else if (token.equals("D tk_)")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("S");
			pila.add(new Token("S", "null"));
		} else if (token.equals("O tk_)")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("S");
			pila.add(new Token("S", "null"));
		} else if (token.equals("O tk_) tk_;")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			// pila.add("S");
			pila.add(new Token("S", "null"));

		} else if (token.equals("R E S")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("O", "null"));
			// pila.add("O");
		} else if (token.equals("finOP")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("O", "null"));
			// pila.add("O");
			String cadena = pila.get(pila.size() - 1 - 1) + " " + pila.get(pila.size() - 1);
			if (cadena.equals("codigo O")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			} else {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			}
		} else if (token.equals("tk_var tk_= codigo")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("ASIG", "null"));
			// pila.add("ASIG");
			String cadena = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
			if (cadena.equals("codigo ASIG")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			} else {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			}

		}

	}

	// AGREGAR Y SACAR DE PILA TODOS LOS TOKENS DE LA DECLARACION
	public void obtenerTokensDeclaracion(ArrayList<Token> pila, int i) {
		if (tokensSeparados.get(i).equals("tk_;")) {
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			verificaReglasDeclaracion(pila.get(pila.size() - 1).getToken());
			i++;
			AnalisisSitactico(i);
		} else if (tokensSeparados.get(i).equals("tk_,")) {
			// pila.add(tokensSeparados.get(i));
			String token2 = tokensSeparados.get(i);
			String lexema2 = lexemas.get(i);
			pila.add(new Token(token2, lexema2));
			i++;
			if (tokensSeparados.get(i).equals("tk_var")) {
				// pila.add(tokensSeparados.get(i));
				String token3 = tokensSeparados.get(i);
				String lexema3 = lexemas.get(i);
				pila.add(new Token(token3, lexema3));
				i++;
				obtenerTokensDeclaracion(pila, i);
			}
		} else if (tokensSeparados.get(i).equals("tk_=")) {
			// pila.add(tokensSeparados.get(i));
			String token = tokensSeparados.get(i);
			String lexema = lexemas.get(i);
			pila.add(new Token(token, lexema));
			i++;
			if (tokensSeparados.get(i).equals("tk_entero") || tokensSeparados.get(i).equals("tk_decimal")) {
				// pila.add(tokensSeparados.get(i));
				String token2 = tokensSeparados.get(i);
				String lexema2 = lexemas.get(i);
				pila.add(new Token(token2, lexema2));
				i++;
				obtenerTokensDeclaracion(pila, i);
			}
		}
	}

	// END

	// VERIFICACION DEL TOKEN PARA SABER SI PERTENECE A LA REGLA WRITE O READ
	public void verificaRegla(String toknen, int i) {
		if (toknen.equals("tk_ESCRIBIR") || toknen.equals("tk_LEER")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("funcion", "null"));
			// pila.add("funcion");
			// verificaRegla(pila.get(pila.size()-1));
		} else if (toknen.equals("tk_var") || toknen.equals("tk_entero") || toknen.equals("tk_decimal")) {
//			pila.add("A");
			// verificaRegla(pila.get(pila.size()-1));
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("A", "null"));

		} else if (toknen.equals(" ")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("parametro", "null"));

			// pila.add("parametro");
			// verificaRegla(pila.get(pila.size()-1));
		} else if (toknen.equals("DE")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("LW", "null"));
			// pila.add("LW");
			String cadena = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
			if (cadena.equals("codigo LW")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
				i++;
				AnalisisSitactico(i);
			} else {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
				i++;
				AnalisisSitactico(i);
			}

		}
	}

	public void verificaReglaInicio(String toknen, int i) {

		if (toknen.equals("tk_INICIO tk_{")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("inicio", "null"));
			// pila.add("inicio");
			i++;
			AnalisisSitactico(i);

		}
	}

	public void verificaReglaFin(String toknen, int i) {
		if (toknen.equals("tk_} tk_FIN")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("fin", "null"));
			// pila.add("fin");

			String cadenaFinal = pila.get(pila.size() - 1 - 1 - 1).getToken() + " "
					+ pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
			System.out.println(cadenaFinal);
			if (cadenaFinal.equals("inicio codigo fin")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigFinal", "null"));

				// pila.add("codigFinal");
			} else {
				JOptionPane.showMessageDialog(null, "se encontraron errores sintacticos");
				baderaErrores = true;
			}

		}
	}

	public void verificaReglasDeclaracion(String toknen) {
		if (toknen.equals("tk_ENTERO") || toknen.equals("tk_REAL")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("tipo", "null"));
			// pila.add("tipo");

		} else if (toknen.equals("tk_;")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("J", "null"));
			// pila.add("J");
			formarExpresionesDeclaracion(pila);
		} else if (toknen.equals("declaracion")) {
			String cadena = pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken();
			if (cadena.equals("codigo declaracion")) {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			} else {
				agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
				pila.remove(pila.size() - 1);
				pila.add(new Token("codigo", "null"));
				// pila.add("codigo");
			}
		}
	}

	public void formarExpresionesDeclaracion(ArrayList<Token> pila) {
		String cadena = String
				.valueOf(pila.get(pila.size() - 1 - 1).getToken() + " " + pila.get(pila.size() - 1).getToken());
		// String lexema1= pila.get(pila.size()-1);
		// System.out.println(cadena);

		if (cadena.equals("tk_var J")) {
			System.out.println("entro a tk_var J");

			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("V", "null"));
			// pila.add("V");
			formarExpresionesDeclaracion(pila);
		} else if (cadena.equals("tipo V")) {
			System.out.println("entro a tipo V");
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("declaracion", "null"));
			// pila.add("declaracion");
			verificaReglasDeclaracion(pila.get(pila.size() - 1).getToken());

		} else if (cadena.equals("tk_entero J") || cadena.equals("tk_decimal J")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("H", "null"));
			// pila.add("H");
			formarExpresionesDeclaracion(pila);
		} else if (cadena.equals("tk_= H")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("V", "null"));
			// pila.add("V");
			formarExpresionesDeclaracion(pila);
		} else if (cadena.equals("tk_, V")) {
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			agregarNodo(pila.get(pila.size() - 1).getLexema(), pila.get(pila.size() - 1).getToken());
			pila.remove(pila.size() - 1);
			pila.add(new Token("J", "null"));
			// pila.add("J");
			formarExpresionesDeclaracion(pila);
		}
	}

	public void agregarNodo(String lexema, String sacoPila) {
		Nodo nodo = new Nodo();
		n++;
		nodo.setNumero(n);
		nodo.setNombre(sacoPila);
		nodo.setLexema(lexema);
		nodos.add(nodo);

		if (nodos.get(nodos.size() - 1).getNombre().equals("A")) {
			boolean econtrarHijoDeA = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoDeA == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_var") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_entero") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_decimal")
								&& nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoDeA = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}

		} else if (nodos.get(nodos.size() - 1).getNombre().equals("parametro")) {
			boolean econtrarHijoParenIni = false;
			boolean econtrarHijoA = false;
			boolean econtrarHijoParenFin = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoParenIni == false && econtrarHijoA == false && econtrarHijoParenFin == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_(") && nodos.get(posiAtras).getPadre() == 0) {

					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("A") && nodos.get(posiAtras).getPadre() == 0) {

						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_)") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoParenFin = true;
							econtrarHijoA = true;
							econtrarHijoParenIni = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							posiAtras--;
							tamaņoNodos--;
						}

					} else {

						posiAtras--;
						tamaņoNodos--;
					}

				} else {
					posiAtras--;
					tamaņoNodos--;
					// }
				}
			}

		} else if (nodos.get(nodos.size() - 1).getNombre().equals("funcion")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_ESCRIBIR") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_LEER") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("LW")) {
			boolean econtrarHijoParenIni = false;
			boolean econtrarHijoA = false;
			boolean econtrarHijoParenFin = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoParenIni == false && econtrarHijoA == false && econtrarHijoParenFin == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("funcion") && nodos.get(posiAtras).getPadre() == 0) {

					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("parametro") && nodos.get(posiAtras).getPadre() == 0) {

						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_;") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoParenFin = true;
							econtrarHijoA = true;
							econtrarHijoParenIni = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							posiAtras--;
							tamaņoNodos--;
						}

					} else {

						posiAtras--;
						tamaņoNodos--;
					}

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}

		} else if (nodos.get(nodos.size() - 1).getNombre().equals("J")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_;") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());

				} else if (nodos.get(posiAtras).getNombre().equals("tk_,") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("V") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}

		} else if (nodos.get(nodos.size() - 1).getNombre().equals("V")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_var") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("J") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else if (nodos.get(posiAtras).getNombre().equals("tk_=")
							&& nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("H") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						}
					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("tipo")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_ENTERO") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_REAL") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}

		} else if (nodos.get(nodos.size() - 1).getNombre().equals("declaracion")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tipo") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("V") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("H")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_entero") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_decimal")
								&& nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("J") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("D")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_var") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_entero") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_decimal")
								&& nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("R")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_SUM") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_RES") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_MUL") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_DIV") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("E")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_(") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("D") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_,") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							posiAtras--;
							tamaņoNodos--;
						}
					} else if (nodos.get(posiAtras).getNombre().equals("O") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_,") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							posiAtras--;
							tamaņoNodos--;
						}

					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("S")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("D") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("tk_)") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_;") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());

						}
					}
				} else if (nodos.get(posiAtras).getNombre().equals("O") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("tk_)") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("tk_;") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());

						}
					} else {
						posiAtras--;
						tamaņoNodos--;
					}

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("O")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("R") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("E") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("S") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						}
					} else {
						posiAtras--;
						tamaņoNodos--;
					}

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("codigo")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("LW") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());

				} else if (nodos.get(posiAtras).getNombre().equals("declaracion")
						&& nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else if (nodos.get(posiAtras).getNombre().equals("O") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else if (nodos.get(posiAtras).getNombre().equals("codigo") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("O") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else if (nodos.get(posiAtras).getNombre().equals("LW") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else if (nodos.get(posiAtras).getNombre().equals("declaracion")
							&& nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else if (nodos.get(posiAtras).getNombre().equals("ASIG")
							&& nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					} else {
						posiAtras--;
						tamaņoNodos--;
					}
				} else if (nodos.get(posiAtras).getNombre().equals("ASIG") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("fin")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_}") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("tk_FIN") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					}

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("inicio")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_INICIO") && nodos.get(posiAtras).getPadre() == 0) {
					econtrarHijoInte = true;
					nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					nodos.get((posiAtras - 1)).setPadre(nodos.get(nodos.size() - 1).getNumero());

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("ASIG")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_var") && nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("tk_=") && nodos.get(posiAtras).getPadre() == 0) {
						int respaldo2 = posiAtras;
						posiAtras--;
						tamaņoNodos--;
						if (nodos.get(posiAtras).getNombre().equals("codigo") && nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						} else if (nodos.get(posiAtras).getNombre().equals("numero")
								&& nodos.get(posiAtras).getPadre() == 0) {
							econtrarHijoInte = true;
							nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(respaldo2).setPadre(nodos.get(nodos.size() - 1).getNumero());
							nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
						}

					}

				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		} else if (nodos.get(nodos.size() - 1).getNombre().equals("numero")) {
			boolean econtrarHijoInte = false;
			int tamaņoNodos = nodos.size();
			int posiAtras = nodos.size() - 1 - 1;
			while (econtrarHijoInte == false) {
				// if(tamaņoNodos>1) {
				if (nodos.get(posiAtras).getNombre().equals("tk_var") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_decimal") && nodos.get(posiAtras).getPadre() == 0
						|| nodos.get(posiAtras).getNombre().equals("tk_entero")
								&& nodos.get(posiAtras).getPadre() == 0) {
					int respaldo = posiAtras;
					posiAtras--;
					tamaņoNodos--;
					if (nodos.get(posiAtras).getNombre().equals("tk_;") && nodos.get(posiAtras).getPadre() == 0) {
						econtrarHijoInte = true;
						nodos.get(respaldo).setPadre(nodos.get(nodos.size() - 1).getNumero());
						nodos.get(posiAtras).setPadre(nodos.get(nodos.size() - 1).getNumero());
					}
				} else {
					posiAtras--;
					tamaņoNodos--;
				}
				// }
			}
		}
	}

	// VERICA ERRORES
	// SINTACTICOS------------------------------------------------------------------------------------
	public void verificaErrores(int j) {
		int lineas = 1;
		if (j < tokensSeparados.size()) {
			if (tokensSeparados.get(j).equals("tk_INICIO")) {
				j++;
				verificaErroresInicio(j);
			} else if (tokensSeparados.get(j).equals("tk_ESCRIBIR") || tokensSeparados.get(j).equals("tk_LEER")) {
				lineas++;
				j++;
				verificaErroresWriteRead(j);
			} else if (tokensSeparados.get(j).equals("tk_ENTERO") || tokensSeparados.get(j).equals("tk_REAL")) {
				lineas++;
				j++;
				System.out.println("entro a integer");
				if (tokensSeparados.get(j).equals("tk_var")) {
					j++;
					System.out.println("entro a var");

					verificaErroresDeclaracion(j);
				} else {
					System.out
							.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
					j++;
					encontrarPuntoComa(j);
				}

			} else if (tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
					|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")) {
				j++;
				verificaErroresOperacion1(j);
			} else if (tokensSeparados.get(j).equals("tk_}")) {
				j++;
				verificaErroresFin(j);

			} else if (tokensSeparados.get(j).equals("tk_var")) {
				j++;
				verificaErroresAsig(j);
			}
		} else {
			System.out.println("se paso de tamaņo");
		}
	}

	public void verificaErroresAsig(int j) {
		if (tokensSeparados.get(j).equals("tk_=")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_var") || tokensSeparados.get(j).equals("tk_entero")
					|| tokensSeparados.get(j).equals("tk_deciaml")) {
				j++;
				if (tokensSeparados.get(j).equals("tk_;")) {
					j++;
					lineas++;
					verificaErrores(j);
				}

			} else if (tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
					|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")) {
				j++;
				verificaErroresOperacion1(j);
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
				j++;
				encontrarPuntoComa(j);
			}
		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
			j++;
			encontrarPuntoComa(j);
		}

	}

	public void verificaErroresOperacion1(int j) {
		if (tokensSeparados.get(j).equals("tk_(")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_var") || tokensSeparados.get(j).equals("tk_entero")
					|| tokensSeparados.get(j).equals("tk_decimal")) {
				j++;
				if (tokensSeparados.get(j).equals("tk_,")) {
					j++;
					vericaErroresOperacion2(j);

				} else {
					System.out
							.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

					j++;
					encontrarPuntoComa(j);
				}
			} else if (tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
					|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")) {
				j++;
				verificaErroresOperacion1(j);
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

				j++;
				encontrarPuntoComa(j);
			}
		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			j++;
			encontrarPuntoComa(j);
		}
	}

	public void vericaErroresOperacion2(int j) {
		if (tokensSeparados.get(j).equals("tk_var") || tokensSeparados.get(j).equals("tk_entero")
				|| tokensSeparados.get(j).equals("tk_decimal")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_)")) {
				j++;
				if (tokensSeparados.get(j).equals("tk_;")) {
					j++;
					lineas++;
					verificaErrores(j);
				} else if (tokensSeparados.get(j).equals("tk_,")) {
					j++;
					vericaErroresOperacion2(j);
				} else if (tokensSeparados.get(j).equals("tk_)")) {
					verificaErroresOperacion3(j);
				} else {
					System.out
							.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
					j++;
					encontrarPuntoComa(j);
				}

			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
				j++;
				encontrarPuntoComa(j);
			}
		} else if (tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
				|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")) {
			j++;
			verificaErroresOperacion1(j);
		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
			j++;
			encontrarPuntoComa(j);
		}

	}

	public void verificaErroresOperacion3(int j) {
		if (tokensSeparados.get(j).equals("tk_)")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_)")) {// aqui me quede
				verificaErroresOperacion3(j);
			} else if (tokensSeparados.get(j).equals("tk_;")) {
				j++;
				lineas++;
				verificaErrores(j);

			} else if (tokensSeparados.get(j).equals("tk_,")) {
				j++;
				vericaErroresOperacion2(j);
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
				j++;
				encontrarPuntoComa(j);
			}

		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			j++;
			encontrarPuntoComa(j);
		}

	}

	public void verificaErroresDeclaracion(int j) {
		if (tokensSeparados.get(j).equals("tk_;")) {
			j++;
			lineas++;
			System.out.println("entro a puntoComa");
			verificaErrores(j);
		} else if (tokensSeparados.get(j).equals("tk_,")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_var")) {
				j++;
				verificaErroresDeclaracion(j);
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

				j++;
				encontrarPuntoComa(j);
			}
		} else if (tokensSeparados.get(j).equals("tk_=")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_entero") || tokensSeparados.get(j).equals("tk_decimal")) {
				j++;
				verificaErroresDeclaracion(j);
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

				j++;
				encontrarPuntoComa(j);
			}
		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			j++;
			encontrarPuntoComa(j);
		}
	}

	public void verificaErroresWriteRead(int j) {
		if (tokensSeparados.get(j).equals("tk_(")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_var")) {
				j++;
				if (tokensSeparados.get(j).equals("tk_)")) {
					j++;
					if (tokensSeparados.get(j).equals("tk_;")) {
						j++;
						lineas++;
						verificaErrores(j);
					} else {
						System.out.println(
								"error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
						erroresSintacticos
								.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

						j++;
						encontrarPuntoComa(j);
					}
				} else {
					System.out
							.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

					j++;
					encontrarPuntoComa(j);
				}
			} else {
				System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

				j++;
				encontrarPuntoComa(j);
			}

		} else {
			System.out.println("error sintactico:" + tokensSeparados.get(j).toString() + "en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			j++;
			encontrarPuntoComa(j);
		}
	}

	public void verificaErroresInicio(int j) {
		if (tokensSeparados.get(j).equals("tk_{")) {
			j++;
			if (tokensSeparados.get(j).equals("tk_ESCRIBIR") || tokensSeparados.get(j).equals("tk_LEER")
					|| tokensSeparados.get(j).equals("tk_ENTERO") || tokensSeparados.get(j).equals("tk_REAL")
					|| tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
					|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")
					|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_var")) {
				lineas++;
				verificaErrores(j);
			} else {
				System.out.println("error sintactico :" + tokensSeparados.get(j).toString() + " en la linea:" + lineas);
				erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

				j++;
				encontrarTokenPrincipal(j);

			}
		} else {
			System.out.println("error sintactico :" + tokensSeparados.get(j).toString() + " en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			j++;
			encontrarTokenPrincipal(j);
		}

	}

	public void verificaErroresFin(int j) {
		if (tokensSeparados.get(j).equals("tk_FIN")) {
			j++;
			if (j < tokensSeparados.size()) {
				if (tokensSeparados.get(j).equals("tk_ESCRIBIR") || tokensSeparados.get(j).equals("tk_LEER")
						|| tokensSeparados.get(j).equals("tk_ENTERO") || tokensSeparados.get(j).equals("tk_REAL")
						|| tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
						|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")) {
					System.out.println(
							"error sintactico :" + tokensSeparados.get(j).toString() + " en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
					// j++;
					// verificaErroresFin(j);
				} else {
					System.out.println(
							"error sintactico :" + tokensSeparados.get(j).toString() + " en la linea:" + lineas);
					erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);
					// j++;
					// encontrarTokenPrincipal(j);
					// verificaErroresFin(j);
				}
			}
		} else {
			System.out.println("error sintactico :" + tokensSeparados.get(j).toString() + " en la linea:" + lineas);
			erroresSintacticos.add("error sintactico: " + lexemas.get(j).toString() + " en la linea:" + lineas);

			// j++;
			// encontrarTokenPrincipal(j);
		}
	}

	// IGNORA TOKENS DESPUES DE ENCONTRAR UN ERROR EN LA REGLA INICIO HASTA
	// ENCONTRAR UN TOKEN QUE INCIA UNA NUEVA REGLA
	public void encontrarTokenPrincipal(int j) {
		if (tokensSeparados.get(j).equals("tk_ESCRIBIR") || tokensSeparados.get(j).equals("tk_LEER")
				|| tokensSeparados.get(j).equals("tk_ENTERO") || tokensSeparados.get(j).equals("tk_REAL")
				|| tokensSeparados.get(j).equals("tk_SUM") || tokensSeparados.get(j).equals("tk_RES")
				|| tokensSeparados.get(j).equals("tk_MUL") || tokensSeparados.get(j).equals("tk_DIV")
				|| tokensSeparados.get(j).equals("tk_var")) {
			lineas++;
			verificaErrores(j);
		} else {
			j++;
			encontrarTokenPrincipal(j);

		}
	}

	public void encontrarPuntoComa(int j) {
		if (tokensSeparados.get(j).equals("tk_;")) {
			j++;
			lineas++;
			verificaErrores(j);
		} else {
			j++;
			encontrarPuntoComa(j);
		}
	}

	public void analisisSemantico(int i, ArrayList<Nodo> nodos) {
		if (i < nodos.size()) {
			if (nodos.get(i).getNombre().equals("tk_ENTERO") || nodos.get(i).getNombre().equals("tk_REAL")) {
				int posicion = i;
				String tipoAux = nodos.get(i).getLexema();
				i++;
				buscarVariables(i, nodos, tipoAux, posicion);

			} else if (nodos.get(i).getNombre().equals("tk_entero") || nodos.get(i).getNombre().equals("tk_decimal")) {
				if (nodos.get(i).getNombre().equals("tk_entero")) {
					String tipoAux = "ENTERO";
					nodos.get(i).setTipo(tipoAux);
					int posicionNumero = i;
					i++;
					analisisAsignacionExterna(i, nodos, tipoAux, posicionNumero);
				} else if (nodos.get(i).getNombre().equals("tk_decimal")) {
					String tipoAux = "REAL";
					nodos.get(i).setTipo(tipoAux);
					int posicionNumero = i;
					i++;
					analisisAsignacionExterna(i, nodos, tipoAux, posicionNumero);
				}

			} else if (nodos.get(i).getNombre().equals("tk_var")) {
				String variable = nodos.get(i).getLexema();
				String tipo = sacarTipoVarTabla(variable);
				if (!tipo.equals("")) {
					nodos.get(i).setTipo(tipo);
					int posicionVariable = i;
					i++;
					analisisAsignacionExterna(i, nodos, tipo, posicionVariable);

				} else {
					System.out.println("La variable: " + variable + " No esta declarada");
					textPaneErrores.setText("La variable: " + variable + " No esta declarada");
					baderaErrorSemantico = true;
				}

			} else if (nodos.get(i).getNombre().equals("tk_SUM") || nodos.get(i).getNombre().equals("tk_MUL")
					|| nodos.get(i).getNombre().equals("tk_DIV") || nodos.get(i).getNombre().equals("tk_RES")) {
				System.out.println("entro a operacion");
				i++;
				analisisAsignacionOperacio(i, nodos);
			} else if (nodos.get(i).getNombre().equals("tk_ESCRIBIR") || nodos.get(i).getNombre().equals("tk_LEER")) {
				i++;
				analisisVaribleWriteRead(i, nodos);
			} else {
				i++;
				analisisSemantico(i, nodos);

			}
		} else {
			for (int j = 0; j < nodos.size(); j++) {
				System.out.println(nodos.get(j).toString());
			}
		}

	}

	public void analisisVaribleWriteRead(int i, ArrayList<Nodo> nodos) {
		if (!nodos.get(i).getNombre().equals("LW")) {
			if (nodos.get(i).getNombre().equals("tk_var")) {
				String variable = nodos.get(i).getLexema();
				String tipo = sacarTipoVarTabla(variable);
				if (!tipo.equals("")) {
					i++;
					analisisVaribleWriteRead(i, nodos);
				} else {
					System.out.println("La variable : " + variable + " No esta declarada");
					textPaneErrores.setText("La variable: " + variable + " No esta declarada");
					baderaErrorSemantico = true;
				}
			} else {
				i++;
				analisisVaribleWriteRead(i, nodos);
			}

		} else {
			i++;
			analisisSemantico(i, nodos);
		}

	}

	public void analisisAsignacionOperacio(int i, ArrayList<Nodo> nodos) {
		if (nodos.get(i).getNombre().equals("tk_entero") || nodos.get(i).getNombre().equals("tk_decimal")) {
			if (nodos.get(i).getNombre().equals("tk_entero")) {
				System.out.println("entro a entero");
				int numeroPadre = nodos.get(i).getPadre();
				int posicionNumero = i;
				nodos.get(i).setTipo("ENTERO");
				String tipo = nodos.get(i).getTipo();
				i++;
				buscarPadres(i, nodos, numeroPadre, tipo, posicionNumero);

			} else if (nodos.get(i).getNombre().equals("tk_decimal")) {
				int numeroPadre = nodos.get(i).getPadre();
				int posicionNumero = i;
				nodos.get(i).setTipo("REAL");
				String tipo = nodos.get(i).getTipo();
				i++;
				buscarPadres(i, nodos, numeroPadre, tipo, posicionNumero);
			}

		} else if (nodos.get(i).getNombre().equals("tk_var")) {
			String variable = nodos.get(i).getLexema();
			String tipo = sacarTipoVarTabla(variable);
			if (!tipo.equals("")) {
				nodos.get(i).setTipo(tipo);
				int numeroPadreVar = nodos.get(i).getPadre();
				int posicionNumeroVar = i;
				String tipoVar = nodos.get(i).getTipo();
				i++;
				buscarPadres(i, nodos, numeroPadreVar, tipoVar, posicionNumeroVar);

			} else {
				System.out.println("La variable: " + variable + " No esta declarada");
				textPaneErrores.setText("La variable: " + variable + " No esta declarada");
				baderaErrorSemantico = true;
			}
		} else {
			i++;
			analisisAsignacionOperacio(i, nodos);
		}

	}

	public void buscarPadres(int i, ArrayList<Nodo> nodos, int numeroPadre, String tipo, int posicionNumero) {
		if (nodos.get(i).getNombre().equals("D") && nodos.get(i).getNumero() == numeroPadre) {

			nodos.get(i).setTipo(tipo);
			int numeroPadre2 = nodos.get(i).getPadre();
			String tipo2 = nodos.get(i).getTipo();
			int posicionD = i;
			i++;
			buscarPadres(i, nodos, numeroPadre2, tipo2, posicionD);

		} else if (nodos.get(i).getNombre().equals("E") && nodos.get(i).getNumero() == numeroPadre) {
			nodos.get(i).setTipo(tipo);
			i = (posicionNumero + 1);
			int posicionAuxE = posicionNumero;
			analisisAsignacionOperacio(posicionNumero, nodos);

		} else if (nodos.get(i).getNombre().equals("S") && nodos.get(i).getNumero() == numeroPadre) {
			nodos.get(i).setTipo(tipo);
			if (nodos.get(i).getTipo().equals(nodos.get(i + 1).getTipo())) {

				int numeroPadre3 = nodos.get(i).getPadre();
				String tipo3 = nodos.get(i).getTipo();
				int posicionS = i;

				i++;
				buscarPadres(i, nodos, numeroPadre3, tipo3, posicionS);

			} else {
				System.out.println("los valores de la operacion no coinciden con la misma declaracion");
				textPaneErrores.setText("los valores de la operacion no coinciden con la misma declaracion");
				baderaErrorSemantico = true;
			}

		} else if (nodos.get(i).getNombre().equals("O") && nodos.get(i).getNumero() == numeroPadre) {
			nodos.get(i).setTipo(tipo);
			int numeroPadre4 = nodos.get(i).getPadre();
			String tipo4 = nodos.get(i).getTipo();
			int posicionO = i;

			i++;
			buscarPadres(i, nodos, numeroPadre4, tipo4, posicionO);
		} else if (nodos.get(i).getNombre().equals("codigo") && nodos.get(i).getNumero() == numeroPadre) {
			nodos.get(i).setTipo(tipo);
			int posicionCodigo = i;
			i++;
			if (nodos.get(i).getNombre().equals("tk_=")) {
				i++;
				if (nodos.get(i).getNombre().equals("tk_var")) {
					String variable = nodos.get(i).getLexema();
					String tipoVariable = sacarTipoVarTabla(variable);

					if (!tipoVariable.equals("")) {
						nodos.get(i).setTipo(tipoVariable);
						if (nodos.get(posicionCodigo).getTipo().equals(nodos.get(i).getTipo())) {
							i++;
							if (nodos.get(i).getNombre().equals("ASIG")
									&& nodos.get(i).getNumero() == nodos.get(i - 1).getPadre()) {
								nodos.get(i).setTipo(tipoVariable);

								i++;
								analisisSemantico(i, nodos);
							}

						} else {
							System.out.println("No esta correctamente asignada la operacion a la variable: "
									+ nodos.get(i).getLexema());
							textPaneErrores.setText("No esta correctamente asignada la operacion a la variable: "
									+ nodos.get(i).getLexema());
							baderaErrorSemantico = true;
						}
					} else {
						System.out.println("La variable: " + nodos.get(i).getLexema() + " no esta declarada");
						textPaneErrores.setText("La variable: " + nodos.get(i).getLexema() + " no esta declarada");
						baderaErrorSemantico = true;
					}
				}
			}
		} else {
			i++;
			buscarPadres(i, nodos, numeroPadre, tipo, posicionNumero);
		}
	}

	public void analisisAsignacionExterna(int i, ArrayList<Nodo> nodos, String tipoAux, int posicionNumero) {
		if (nodos.get(i).getNombre().equals("numero")) {
			nodos.get(i).setTipo(tipoAux);
			int posicionRegla = i;
			i++;
			if (nodos.get(i).getNombre().equals("tk_=")) {
				i++;
				if (nodos.get(i).getNombre().equals("tk_var")) {
					String variable = nodos.get(i).getLexema();
					String tipo = sacarTipoVarTabla(variable);

					if (!tipo.equals("")) {
						nodos.get(i).setTipo(tipo);
						if (nodos.get(posicionRegla).getTipo().equals(nodos.get(i).getTipo())) {
							if (!nodos.get(posicionNumero).getNombre().equals("tk_var")) {
								String valor = nodos.get(posicionNumero).getLexema();
								asignarValorVarTabla(variable, valor);
								i++;
								nodos.get(i).setTipo(nodos.get(posicionRegla).getTipo());
								i++;
								analisisSemantico(i, nodos);
							} else {
								String variable2 = nodos.get(posicionNumero).getLexema();
								String valor = sacarValorVarTabla(variable2);

								asignarValorVarTabla(variable, valor);
								i++;
								nodos.get(i).setTipo(nodos.get(posicionRegla).getTipo());
								i++;
								analisisSemantico(i, nodos);

							}

						} else {
							System.out.println("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
							textPaneErrores.setText("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
							baderaErrorSemantico = true;

						}
					} else {
						System.out.println("La variable: " + nodos.get(i).getLexema() + " no esta declarada");
						textPaneErrores.setText("La variable: " + nodos.get(i).getLexema() + " no esta declarada");
						baderaErrorSemantico = true;
					}
				}
			}
		}
	}

	public void analisisAsignacion(int i, ArrayList<Nodo> nodos) {
		if (i < nodos.size()) {
			if (nodos.get(i).getNombre().equals("tk_ENTERO") || nodos.get(i).getNombre().equals("tk_REAL")) {
				i++;
				analisisAsignacion2(i, nodos);
			} else {
				i++;
				analisisAsignacion(i, nodos);
			}
		}

	}

	public void analisisAsignacion2(int i, ArrayList<Nodo> nodos) {
		if (!nodos.get(i).getNombre().equals("declaracion")) {
			if (nodos.get(i).getNombre().equals("tk_entero") || nodos.get(i).getNombre().equals("tk_decimal")) {
				if (nodos.get(i).getNombre().equals("tk_entero")) {
					nodos.get(i).setTipo("ENTERO");
					int posicionNumero = i;
					i++;
					if (nodos.get(i).getNombre().equals("H")) {
						nodos.get(i).setTipo("ENTERO");
						int posicionH = i;
						i++;

						if (nodos.get(i).getNombre().equals("tk_=")) {
							i++;
							if (nodos.get(i).getNombre().equals("tk_var")) {
								String variable = nodos.get(i).getLexema();
								String tipo = sacarTipoVarTabla(variable);
								System.out.println("valor var_" + tipo);
								nodos.get(i).setTipo(tipo);
								if (nodos.get(posicionH).getTipo().equals(nodos.get(i).getTipo())) {
									String valor = nodos.get(posicionNumero).getLexema();
									asignarValorVarTabla(variable, valor);
									i++;
									nodos.get(i).setTipo("ENTERO");
									i++;
									analisisAsignacion2(i, nodos);
								} else {
									System.out
											.println("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
									textPaneErrores
											.setText("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
									baderaErrorSemantico = true;
								}

							}
						}
					}
				} else if (nodos.get(i).getNombre().equals("tk_decimal")) {
					nodos.get(i).setTipo("REAL");
					int posicionNumero = i;
					i++;
					if (nodos.get(i).getNombre().equals("H")) {
						nodos.get(i).setTipo("REAL");
						int posicionH = i;
						i++;

						if (nodos.get(i).getNombre().equals("tk_=")) {
							i++;
							if (nodos.get(i).getNombre().equals("tk_var")) {
								String variable = nodos.get(i).getLexema();
								String tipo = sacarTipoVarTabla(variable);
								System.out.println("valor var_" + tipo);
								nodos.get(i).setTipo(tipo);
								if (nodos.get(posicionH).getTipo().equals(nodos.get(i).getTipo())) {
									String valor = nodos.get(posicionNumero).getLexema();
									asignarValorVarTabla(variable, valor);
									i++;
									nodos.get(i).setTipo("REAL");
									i++;
									analisisAsignacion2(i, nodos);
								} else {
									System.out
											.println("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
									textPaneErrores
											.setText("Asignacion invalida en la variable: " + nodos.get(i).getLexema());
									baderaErrorSemantico = true;
								}

							}
						}
					}
				}

			} else {

				i++;
				analisisAsignacion2(i, nodos);
			}
		} else {
			i++;
			analisisSemantico(i, nodos);
		}
	}

	public void buscarVariables(int i, ArrayList<Nodo> nodos, String tipoAux, int posicion) {
		if (!nodos.get(i).getNombre().equals("declaracion")) {
			if (nodos.get(i).getNombre().equals("tk_var")) {
				String variable = nodos.get(i).getLexema();
				if (buscarVariableEnTabla(variable, tipoAux)) {
					i++;
					buscarVariables(i, nodos, tipoAux, posicion);
				} else {
					System.out.println("la variable " + variable + "ya esta declarada");
					textPaneErrores.setText("la variable " + variable + "ya esta declarada");
					baderaErrorSemantico = true;
				}
			} else {

				i++;
				buscarVariables(i, nodos, tipoAux, posicion);
			}
		} else {
			i = posicion;
			analisisAsignacion(i, nodos);
		}
	}

	public String sacarTipoVarTabla(String variable) {
		for (int i = 0; i < tabla.getRowCount(); i++) {
			if (variable.equals(modeloTabla.getValueAt(i, 0).toString())
					&& !modeloTabla.getValueAt(i, 1).toString().equals("")) {
				return modeloTabla.getValueAt(i, 1).toString();
			}
		}

		return "";
	}

	public String sacarValorVarTabla(String variable) {
		for (int i = 0; i < tabla.getRowCount(); i++) {
			if (variable.equals(modeloTabla.getValueAt(i, 0).toString())) {
				return modeloTabla.getValueAt(i, 2).toString();
			}
		}

		return "";
	}

	public void asignarValorVarTabla(String variable, String valor) {
		for (int i = 0; i < tabla.getRowCount(); i++) {
			if (variable.equals(modeloTabla.getValueAt(i, 0).toString())) {
				modeloTabla.setValueAt(valor, i, 2);

			}
		}

	}

	public boolean buscarVariableEnTabla(String variable, String tipoAux) {

		for (int i = 0; i < tabla.getRowCount(); i++) {
			if (variable.equals(modeloTabla.getValueAt(i, 0).toString())
					&& modeloTabla.getValueAt(i, 1).toString().equals("")) {
				modeloTabla.setValueAt(tipoAux, i, 1);
				return true;
			}
		}

		return false;
	}

	public String getArchivo(String ruta) {
		FileReader fr = null;
		BufferedReader br = null;
		// Cadena de texto donde se guardara el contenido del archivo
		String contenido = "";
		try {
			// ruta puede ser de tipo String o tipo File
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);
			String linea;
			// Obtenemos el contenido del archivo linea por linea
			while ((linea = br.readLine()) != null) {
				contenido += linea + "\n";
			}
		} catch (Exception e) {
		}
		// finally se utiliza para que si todo ocurre correctamente o si ocurre
		// algun error se cierre el archivo que anteriormente abrimos
		finally {
			try {
				br.close();
			} catch (Exception ex) {
			}
		}
		return contenido;
	}
}
