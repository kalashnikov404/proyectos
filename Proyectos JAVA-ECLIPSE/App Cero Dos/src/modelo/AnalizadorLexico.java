package modelo;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class AnalizadorLexico extends JFrame {

	private JFileChooser abrirArchivo;
	private JButton btnAbrir;
	private JLabel lbError;
	private JTextArea txp;
	private JScrollPane jsp;
	private  JTextArea txp2;
	private JScrollPane jsp2;
	private JTextArea txp3;
	private JScrollPane jsp3;

	private JButton btnGuardar;
	private JButton btnAnalizar;


	String[] palabrasRes = {"INICIO", "FIN", "ENTERO", "DECIMAL", "LEER", "ESCRIBIR", "SUM", "RES", "MUL", "DIV", "{", "}", "(", ")", ";", ",", "=", "."};
	String[] palabrasToken = {"(tk_INICIO, INICIO)", "(tk_FIN, FIN)", "(tk_ENTERO, ENTERO)", "(tk_DECIMAL, DECIMAL)", "(tk_LEER, LEER)", "(tk_ESCRIBIR, ESCRIBIR)", "(tk_SUM, SUM)", "(tk_RES, RES)", "(tk_MUL, MUL)", "(tk_DIV, DIV)", "(tk_CORCHETE_A, {)", "(tk_CORCHETE_C, })", "(tk_PARENTESIS_A, ()", "(tk_PARENTESIS_C, ))", "(tk_PUNTO_COMA, ;)", "(tk_COMA, ,)", "(tk_IGUAL, =)", "(tk_PUNTO, .)"};
	private String contenido;
	String[] tokens = new String[500];
	int cToken = 0, cLineas = 1;
	String errores = "";
	char[] c;
	char[] letrasMinu = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	char[] letrasMayu = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	char numeros[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	char simbolos[] = {',', '(', ')', '[', ']', ';', '{', '}', '='};
	private JButton btnLimpiar;
	private JButton btnGenerarTokens;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalizadorLexico frame = new AnalizadorLexico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public AnalizadorLexico(){
		getContentPane().setBackground(new Color(135, 206, 250));
		//Para poder cerrar la ventana
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		getContentPane().setLayout(null);

		//Se crea el editor de texto y se agrega a un scroll
		txp = new JTextArea();
		jsp = new JScrollPane();
		jsp.setBounds(34, 145, 683, 400);
		jsp.setViewportView( txp );
		getContentPane().add( jsp );

		//Se crea un boton para abrir el archivo
		btnAbrir = new JButton( "Abrir" );
		btnAbrir.setAutoscrolls(true);
		btnAbrir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAbrir.setBounds(34, 95, 116, 23);
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( abrirArchivo == null ) abrirArchivo = new JFileChooser();
				//Con esto solamente podamos abrir archivos
				abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
				int seleccion = abrirArchivo.showOpenDialog(abrirArchivo);
				if( seleccion == JFileChooser.APPROVE_OPTION )
				{
					File f = abrirArchivo.getSelectedFile();
					try
					{
						String nombre = f.getName();
						String path = f.getAbsolutePath();
						String contenido = getArchivo( path );
						//En el editor de texto colocamos su contenido
						txp.setText( contenido );

					}catch( Exception exp){
						JOptionPane.showMessageDialog(null, "Ostia! que no se ha abierto ningun archivo");
					}
				}

			}
		});
		getContentPane().add( btnAbrir );

		JLabel lbTitulo = new JLabel("Analizador Lexico ");
		lbTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Arial", Font.PLAIN, 25));
		lbTitulo.setBounds(28, 37, 1217, 37);
		getContentPane().add(lbTitulo);

		lbError = new JLabel("Error lexico: ");
		lbError.setFont(new Font("Arial", Font.PLAIN, 16));
		lbError.setBounds(34, 579, 138, 68);
		getContentPane().add(lbError);
		txp3 = new JTextArea();
		jsp3 = new JScrollPane();
		jsp3.setBounds(182, 567, 881, 104);
		jsp3.setViewportView(txp3);
		getContentPane().add(jsp3);

		txp2 = new JTextArea();
		jsp2 = new JScrollPane();
		jsp2.setBounds(845, 145, 369, 400);
		jsp2.setViewportView( txp2 );
		getContentPane().add( jsp2 );

		JLabel lbTablaSim = new JLabel("Tabla Simbolos");
		lbTablaSim.setFont(new Font("Arial", Font.PLAIN, 16));
		lbTablaSim.setHorizontalAlignment(SwingConstants.CENTER);
		lbTablaSim.setBounds(907, 104, 251, 30);
		getContentPane().add(lbTablaSim);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String nombre="";
					JFileChooser file=new JFileChooser();
					file.showSaveDialog(file);
					File guarda =file.getSelectedFile();

					if(guarda !=null)
					{
						/*guardamos el archivo y le damos el formato directamente,
						 * si queremos que se guarde en formato doc lo definimos como .doc*/
						String contenido=txp.getText();
						FileWriter  save=new FileWriter(guarda+".txt");
						save.write(contenido);
						save.close();
						JOptionPane.showMessageDialog(null,
								"El archivo se a guardado Exitosamente",
								"Información",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(IOException ex)
				{
					JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado"," Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardar.setBounds(175, 95, 106, 23);
		getContentPane().add(btnGuardar);

		btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contenido == null) {
					contenido = txp.getText();
					contenido = contenido.replaceAll("[\n\r]", "¬");
				}
				c = contenido.toCharArray();
				for (int i = 0; i < c.length; i++) {
					if (comparar(c[i], letrasMinu)) {
						i = minusculas(i);
					} else if (comparar(c[i], letrasMayu)) {
						i = mayusculas(i);
					} else if (comparar(c[i], numeros)) {
						i = num(i);
					} else if (comparar(c[i], simbolos)) {
						tokens[cToken] = "" + c[i];
						cToken++;
					} else if (c[i] == ' ') {
					} else if (c[i] == '¬') {
						cLineas++;
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Simbolo no valido";
					}
				}
				txp3.setText(errores);
				mostrar();
				JOptionPane.showMessageDialog(null, "Ejecutado");
			
				//generarArchivo();
			}
		});
		btnAnalizar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAnalizar.setBounds(303, 95, 116, 23);
		getContentPane().add(btnAnalizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txp.setText("");
				txp2.setText("");
				txp3.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLimpiar.setBounds(446, 96, 89, 23);
		getContentPane().add(btnLimpiar);
		
		btnGenerarTokens = new JButton("Generar Tokens");
		btnGenerarTokens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarArchivo();
			}
		});
		btnGenerarTokens.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGenerarTokens.setBounds(572, 96, 145, 23);
		getContentPane().add(btnGenerarTokens);

		setSize( 1287, 721 );
		setLocationRelativeTo( null );
		setVisible( true );
	}


	//-------------------------Se obtiene el contenido del Archivo----------------//
	public String getArchivo( String ruta ){
		FileReader fr = null;
		BufferedReader br = null;
		//Cadena de texto donde se guardara el contenido del archivo
		String contenido = "";
		try
		{
			//ruta puede ser de tipo String o tipo File
			fr = new FileReader( ruta );
			br = new BufferedReader( fr );
			String linea;
			//Obtenemos el contenido del archivo linea por linea
			while( ( linea = br.readLine() ) != null ){ 
				contenido += linea + "\n";
			}
		}catch( Exception e ){  }
		//finally se utiliza para que si todo ocurre correctamente o si ocurre 
		//algun error se cierre el archivo que anteriormente abrimos
		finally
		{
			try{
				br.close();
			}catch( Exception ex ){}
		}
		return contenido;
	}

	private void crearArchivo(String texto) {
		try
		{
			String nombre="";
			JFileChooser file=new JFileChooser();
			file.showSaveDialog(file);
			File guarda =file.getSelectedFile();

			if(guarda !=null)
			{
				/*guardamos el archivo y le damos el formato directamente,
				 * si queremos que se guarde en formato doc lo definimos como .doc*/	
				FileWriter  save=new FileWriter(guarda+".txt");
				save.write(texto);
				save.close();
				JOptionPane.showMessageDialog(null,
						"El archivo se a guardado Exitosamente",
						"Información",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado"," Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		
	}


	public int reservada(int q) {
		q = q - 1;
		boolean termino = false, error = false;
		for (int i = q; i < c.length; i++) {
			if (c[i] == 'I') {
				i++;
				if (c[i] == 'N') {
					i++;
					if (c[i] == 'I') {
						i++;
						if (c[i] == 'C') {
							i++;
							if (c[i] == 'I') {
								i++;
								if (c[i] == 'O') {
									i++;
									if (comparar(c[i], simbolos)) {
										tokens[cToken] = "INICIO";
										cToken++;
										tokens[cToken] = "" + c[i];
										cToken++;
										termino = true;
									} else if (c[i] == ' ') {
										tokens[cToken] = "INICIO";
										cToken++;
										termino = true;
									} else if (c[i] == '¬') {
										tokens[cToken] = "INICIO";
										cLineas++;
										cToken++;
										termino = true;
									} else {
										errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
										error = true;
									}
								} else {
									errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
									error = true;
								}
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
								error = true;
							}
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'F') {
				i++;
				if (c[i] == 'I') {
					i++;
					if (c[i] == 'N') {
						i++;
						if (comparar(c[i], simbolos)) {
							tokens[cToken] = "FIN";
							cToken++;
							tokens[cToken] = "" + c[i];
							cToken++;
							termino = true;
						} else if (c[i] == ' ') {
							tokens[cToken] = "FIN";
							cToken++;
							termino = true;
						} else if (c[i] == '¬') {
							tokens[cToken] = "FIN";
							cToken++;
							cLineas++;
							termino = true;
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'E') {
				i++;
				if (c[i] == 'N') {
					i++;
					if (c[i] == 'T') {
						i++;
						if (c[i] == 'E') {
							i++;
							if (c[i] == 'R') {
								i++;
								if (c[i] == 'O') {
									i++;
									if (comparar(c[i], simbolos)) {
										tokens[cToken] = "ENTERO";
										cToken++;
										tokens[cToken] = "" + c[i];
										cToken++;
										termino = true;
									} else if (c[i] == ' ') {
										tokens[cToken] = "ENTERO";
										cToken++;
										termino = true;
									} else if (c[i] == '¬') {
										tokens[cToken] = "ENTERO";
										cLineas++;
										cToken++;
										termino = true;
									} else {
										errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
										error = true;
									}
								} else {
									errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
									error = true;
								}
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
								error = true;
							}
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else if (c[i] == 'S') {
					i++;
					if (c[i] == 'C') {
						i++;
						if (c[i] == 'R') {
							i++;
							if (c[i] == 'I') {
								i++;
								if (c[i] == 'B') {
									i++;
									if (c[i] == 'I') {
										i++;
										if (c[i] == 'R') {
											i++;
											if (comparar(c[i], simbolos)) {
												tokens[cToken] = "ESCRIBIR";
												cToken++;
												tokens[cToken] = "" + c[i];
												cToken++;
												termino = true;
											} else if (c[i] == ' ') {
												tokens[cToken] = "ESCRIBIR";
												cToken++;
												termino = true;
											} else if (c[i] == '¬') {
												tokens[cToken] = "ESCRIBIR";
												cToken++;
												cLineas++;
												termino = true;
											} else {
												errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
												error = true;
											}
										} else {
											errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
											error = true;
										}
									} else {
										errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
										error = true;
									}

								}
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
								error = true;
							}
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'D') {
				i++;
				if (c[i] == 'E') {
					i++;
					if (c[i] == 'C') {
						i++;
						if (c[i] == 'I') {
							i++;
							if (c[i] == 'M') {
								i++;
								if (c[i] == 'A') {
									i++;
									if (c[i] == 'L') {
										i++;
										if (comparar(c[i], simbolos)) {
											tokens[cToken] = "DECIMAL";
											cToken++;
											tokens[cToken] = "" + c[i];

											cToken++;
											termino = true;
										} else if (c[i] == ' ') {
											tokens[cToken] = "DECIMAL";

											cToken++;
											termino = true;
										} else if (c[i] == '¬') {
											tokens[cToken] = "DECIMAL";

											cToken++;
											cLineas++;
											termino = true;
										} else {
											errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
											error = true;
										}
									} else {
										errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
										error = true;
									}
								} else {
									errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
									error = true;
								}
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
								error = true;
							}
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else if (c[i] == 'I') {
					i++;
					if (c[i] == 'V') {
						i++;
						if (comparar(c[i], simbolos)) {
							tokens[cToken] = "DIV";

							cToken++;
							tokens[cToken] = "" + c[i];

							cToken++;
							termino = true;
						} else if (c[i] == ' ') {
							tokens[cToken] = "DIV";

							cToken++;
							termino = true;
						} else if (c[i] == '¬') {
							tokens[cToken] = "DIV";

							cToken++;
							cLineas++;
							termino = true;
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'L') {
				i++;
				if (c[i] == 'E') {
					i++;
					if (c[i] == 'E') {
						i++;
						if (c[i] == 'R') {
							i++;
							if (comparar(c[i], simbolos)) {
								tokens[cToken] = "LEER";

								cToken++;
								tokens[cToken] = "" + c[i];

								cToken++;
								termino = true;
							} else if (c[i] == ' ') {
								tokens[cToken] = "LEER";

								cToken++;
								termino = true;
							} else if (c[i] == '¬') {
								tokens[cToken] = "LEER";

								cToken++;
								cLineas++;
								termino = true;
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
								error = true;
							}
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'S') {
				i++;
				if (c[i] == 'U') {
					i++;
					if (c[i] == 'M') {
						i++;
						if (comparar(c[i], simbolos)) {
							tokens[cToken] = "SUM";

							cToken++;
							tokens[cToken] = "" + c[i];

							cToken++;
							termino = true;
						} else if (c[i] == ' ') {
							tokens[cToken] = "SUM";

							cToken++;
							termino = true;
						} else if (c[i] == '¬') {
							tokens[cToken] = "SUM";

							cToken++;
							cLineas++;
							termino = true;
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'R') {
				i++;
				if (c[i] == 'E') {
					i++;
					if (c[i] == 'S') {
						i++;
						if (comparar(c[i], simbolos)) {
							tokens[cToken] = "RES";

							cToken++;
							tokens[cToken] = "" + c[i];

							cToken++;
							termino = true;
						} else if (c[i] == ' ') {
							tokens[cToken] = "RES";

							cToken++;
							termino = true;
						} else if (c[i] == '¬') {
							tokens[cToken] = "RES";

							cToken++;
							cLineas++;
							termino = true;
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (c[i] == 'M') {
				i++;
				if (c[i] == 'U') {
					i++;
					if (c[i] == 'L') {
						i++;
						if (comparar(c[i], simbolos)) {
							tokens[cToken] = "MUL";

							cToken++;
							tokens[cToken] = "" + c[i];

							cToken++;
							termino = true;
						} else if (c[i] == ' ') {
							tokens[cToken] = "MUL";

							cToken++;
							termino = true;
						} else if (c[i] == '¬') {
							tokens[cToken] = "MUL";

							cToken++;
							cLineas++;
							termino = true;
						} else {
							errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
							error = true;
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
						error = true;
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Palabra reservada invalida";
					error = true;
				}
			}

			if (error) {
				i = recorrer(i);
				termino = true;
				error = false;
			}

			if (termino) {
				q = i;
				i = c.length;
			}

		}
		return q;
	}

	public int recorrer(int i) {
		for (int j = i; j < c.length; j++) {
			if (c[j] == ' ') {
				i = j;
				j = c.length;
			} else if (c[j] == '¬') {
				cLineas++;
				i = j;
				j = c.length;
			} else if (comparar(c[j], simbolos)) {
				tokens[cToken] = "" + c[j];

				cToken++;
				i = j;
				j = c.length;
			}
		}
		return i;
	}

	public int minusculas(int q) {
		int cont = 0;
		String cadena;
		cadena = "" + c[q];
		q++;
		boolean termino = false, id = false;
		for (int j = q; j < c.length; j++) {
			if (comparar(c[j], numeros)) {
				cont++;
				id = true;
				cadena += "" + c[j];
			} else if (c[j] == ' ') {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): identificador no valido";
				}
				termino = true;
			} else if (comparar(c[j], simbolos)) {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				}
				tokens[cToken] = "" + c[j];
				cToken++;
				termino = true;
			} else if (c[j] == '¬') {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				}
				termino = true;
				cLineas++;
			} else {
				errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				j = recorrer(j);
				termino = true;
			}
			if (termino) {
				q = j;
				j = c.length;
			}
		}
		return q;
	}

	public int mayusculas(int q) {
		int cont = 0;
		String cadena;
		cadena = "" + c[q];
		q++;
		boolean termino = false, id = false;
		for (int i = q; i < c.length; i++) {
			if (comparar(c[i], letrasMinu)) {
				errores += "\nERROR LEXICO (" + cLineas + "): Identificador o palabra reservada no valido";
				i = recorrer(i);
				termino = true;
			} else if (comparar(c[i], numeros)) {
				cont++;
				id = true;
				cadena += "" + c[i];
			} else if (comparar(c[i], letrasMayu)) {
				i = reservada(i);
				termino = true;
			} else if (comparar(c[i], simbolos)) {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
						tokens[cToken] = "" + c[i];
						cToken++;
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				}
				termino = true;
			} else if (c[i] == ' ') {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): identificador no valido";
				}
				termino = true;
			} else if (c[i] == '¬') {
				if (id) {
					if (cont <= 3) {
						tokens[cToken] = cadena;
						cToken++;
						cadena = "";
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				}
				termino = true;
				cLineas++;
			} else {
				errores += "\nERROR LEXICO (" + cLineas + "): Identificador no valido";
				i = recorrer(i);
				termino = true;
			}
			if (termino) {
				q = i;
				i = c.length;
			}
		}
		return q;
	}

	public int num(int q) {
		String cadena = "";
		int ent = 0, dec = 0, decimal = 0;
		boolean termino = false;
		for (int i = q; i < c.length; i++) {
			if (comparar(c[i], numeros)) {
				if (decimal == 0) {
					cadena += "" + c[i];
					ent++;
				} else if (decimal == 1) {
					cadena += "" + c[i];
					dec++;
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
					i = recorrer(i);
					termino = true;
				}
			} else if (c[i] == '.') {
				decimal++;
				cadena += '.';
			} else if (comparar(c[i], letrasMinu)) {
				errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
				i = recorrer(i);
				termino = true;
			} else if (comparar(c[i], letrasMayu)) {
				errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
				i = recorrer(i);
				termino = true;
			} else if (comparar(c[i], simbolos)) {
				if (decimal <= 1) {
					if (ent <= 5) {
						if (decimal == 1) {
							if (dec <= 2) {
								tokens[cToken] = cadena;
								cToken++;
								cadena = "";
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte decimal mayor a 2 digitos";
							}
						} else {
							tokens[cToken] = cadena;
							cToken++;
							cadena = "";
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte entera mayor a 5 digitos";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
				}
				termino = true;
				tokens[cToken] = "" + c[i];
				cToken++;
			} else if (c[i] == ' ') {
				if (decimal <= 1) {
					if (ent <= 5) {
						if (decimal == 1) {
							if (dec <= 2) {
								tokens[cToken] = cadena;
								cToken++;
								cadena = "";
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte decimal mayor a 2 digitos";
							}
						} else {
							tokens[cToken] = cadena;
							cToken++;
							cadena = "";
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte entera mayor a 5 digitos";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
				}
				termino = true;
			} else if (c[i] == '¬') {
				cLineas++;
				if (decimal <= 1) {
					if (ent <= 5) {
						if (decimal == 1) {
							if (dec <= 2) {
								tokens[cToken] = cadena;
								cToken++;
								cadena = "";
							} else {
								errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte decimal mayor a 2 digitos";
							}
						} else {
							tokens[cToken] = cadena;

							cToken++;
							cadena = "";
						}
					} else {
						errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido, parte entera mayor a 5 digitos";
					}
				} else {
					errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
				}
				termino = true;
			} else {
				errores += "\nERROR LEXICO (" + cLineas + "): NÃºmero invalido";
			}
			if (termino) {
				q = i;
				i = c.length;
			}
		}
		return q;
	}

	public boolean comparar(char c, char[] v) {
		boolean es = false;
		for (int i = 0; i < v.length; i++) {
			if (c == v[i]) {
				es = true;
			}
		}
		return es;
	}

	public boolean comparar2(String xx, char[] v) {
		boolean es = false;
		char x[];
		x = xx.toCharArray();
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < v.length; j++) {
				if (x[i] == v[j]) {
					es = true;
				}
			}
		}
		return es;
	}

	public int tamanio(String[] v) {
		int t = 0;
		for (int i = 0; i < 500; i++) {
			if (v[i] != null) {
				t++;
			}
		}
		return t;
	}



	public void generarArchivo() {
		String archivo = "";
		int tamanio = tamanio(tokens);
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < palabrasRes.length; j++) {
				if (tokens[i].equals(palabrasRes[j])) {
					archivo += palabrasToken[j] + "\n";
					j = palabrasRes.length;
				} else if (comparar2(tokens[i], numeros)) {
					if (tokens[i].indexOf('.') >= 0) {
						archivo += "(tk_numDecimal, " + tokens[i] + ")\n";
						j = palabrasRes.length;
					} else {
						if (comparar2(tokens[i], letrasMinu) || comparar2(tokens[i], letrasMayu)) {
							archivo += "(tk_id, " + tokens[i] + ")\n";
							j = palabrasRes.length;
						} else {
							archivo += "(tk_numEntero, " + tokens[i] + ")\n";
							j = palabrasRes.length;
						}
					}
				}
			}
		}
		 crearArchivo(archivo);
	}





	public void mostrar() {
		String tabla = "";
		int tamanio = tamanio(tokens);
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < palabrasRes.length; j++) {
				if (comparar2(tokens[i], numeros)) {
					if (comparar2(tokens[i], letrasMinu) || comparar2(tokens[i], letrasMayu)) {
						tabla += "" + tokens[i] + "\n";
						j = palabrasRes.length;
					}
				}
			}
		}
		txp2.setText(tabla);
	}
}