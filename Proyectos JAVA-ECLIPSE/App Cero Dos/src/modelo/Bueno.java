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
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class Bueno extends JFrame {

	
	
	
	
	

    String[] palabrasRes = {"INICIO", "FIN", "ENTERO", "DECIMAL", "LEER", "ESCRIBIR", "SUM", "RES", "MUL", "DIV", "{", "}", "(", ")", ";", ",", "=", "."};
    String[] palabrasToken = {"(tk_inicio, INICIO)", "(tk_fin, FIN)", "(tk_tipoEntero, ENTERO)", "(tk_tipoDecimal, DECIMAL)", "(tk_leer, LEER)", "(tk_escribir, ESCRIBIR)", "(tk_sum, SUMA)", "(tk_res, RESTA)", "(tk_mul, MULTIPLICACION)", "(tk_div, DIVISION)", "(tk_llave, {)", "(tk_llave, })", "(tk_paren, ()", "(tk_paren, ))", "(tk_puntoComa, ;)", "(tk_coma, ,)", "(tk_igual, =)", "(tk_punto, .)"};

    private String contenido;
    String[] tokens = new String[500];
    int cToken = 0, cLineas = 1;
    String errores = "";
    char[] c;
    char[] letrasMinu = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', '�', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] letrasMayu = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', '�', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char numeros[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char simbolos[] = {',', '(', ')', '[', ']', ';', '{', '}', '='};
	private JTextPane txp;
	private JFileChooser abrirArchivo;
	private JScrollPane jsp;
	private JButton btnAbrir;
	private JLabel lbError;
	private  JTextPane txp2;
	private  JTextPane txp3;
	private JScrollPane jsp3;


	private JScrollPane jsp2;
	private JButton btnGuardar;
	private JButton btnAnalizar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bueno frame = new Bueno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Bueno(){
		getContentPane().setBackground(new Color(135, 206, 250));
		//Para poder cerrar la ventana
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		getContentPane().setLayout(null);

		//Se crea el editor de texto y se agrega a un scroll
		txp = new JTextPane();
		jsp = new JScrollPane();
		jsp.setBounds(34, 145, 683, 348);
		jsp.setViewportView( txp );
		getContentPane().add( jsp );
		
		txp3 = new JTextPane();
		jsp3 = new JScrollPane();
		jsp3.setBounds(34, 545, 683, 126);
		jsp3.setViewportView( txp3 );
		getContentPane().add( jsp3 );
		
	

		//Se crea un boton para abrir el archivo
		btnAbrir = new JButton( "Abrir" );
		btnAbrir.setBounds(34, 95, 116, 23);
		btnAbrir.setAutoscrolls(true);
		btnAbrir.setFont(new Font("Arial", Font.PLAIN, 14));
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
						JOptionPane.showMessageDialog(null, "No se ha podido abrir ningun archivo, verifique e intentelo de nuevo");
					}
				}

			}
		});
		getContentPane().add( btnAbrir );

		JLabel lbTitulo = new JLabel("Analizador Lexico ");
		lbTitulo.setBounds(28, 37, 1217, 37);
		lbTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		getContentPane().add(lbTitulo);

		lbError = new JLabel("Error lexico: ");
		lbError.setFont(new Font("Arial", Font.PLAIN, 14));
		lbError.setBounds(34, 501, 116, 44);
		getContentPane().add(lbError);


		txp2 = new JTextPane();
		jsp2 = new JScrollPane();
		jsp2.setBounds(845, 145, 369, 348);
		jsp2.setViewportView( txp2 );
		
		
		
		getContentPane().add( jsp2 );

		JLabel lbTablaSim = new JLabel("Tabla Simbolos");
		lbTablaSim.setBounds(907, 104, 251, 30);
		lbTablaSim.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTablaSim.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbTablaSim);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(323, 95, 106, 23);
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
						         "El archivo se ha guardado exitosamente",
						             "Informaci�n",JOptionPane.INFORMATION_MESSAGE);
						    }
						 }
						  catch(IOException ex)
						  {
						   JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado"," Advertencia",JOptionPane.WARNING_MESSAGE);
						  }
						 
					
				
				
				
				
				
				
				
				
			}
		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(btnGuardar);

		btnAnalizar = new JButton("Analizar");
		btnAnalizar.setBounds(592, 95, 116, 23);
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				
				
				
			      
//				  File archivo = new File("C:/Users/Grudges/Desktop/uno.txt");
				  String nombre="";
				  JFileChooser file=new JFileChooser();
				  file.showSaveDialog(file);
				  File archivo =file.getSelectedFile();
				  File guarda =file.getSelectedFile();

				  if (contenido == null) {
			            contenido = txp.getText();
			            contenido = contenido.replaceAll("[\n\r]", "�");
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
			            } else if (c[i] == '�') {
			                cLineas++;
			            } else {
			                errores += "\nError Lexico (" + cLineas + "): simbolo no valido";
			            }
			        }
			        
			       
			      
			      
			        
			        
			        txp3.setText(errores);
			        try {
						escribeSinRepetidos();
				        muestraSinRepetidos();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        
			        generarArchivo();
			
			
			        
			        
			        
			        
			        
			        
			        
			        
			
		}
	});
		btnAnalizar.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(btnAnalizar);

		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
            	txp.setText(null);

            	txp2.setText(null);

				
            	txp3.setText(null);

				
				
				
			}
		});
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLimpiar.setBounds(799, 96, 116, 23);
		getContentPane().add(btnLimpiar);

		setSize( 1287, 721 );
		setLocationRelativeTo( null );
		setVisible( true );
	}

	
	
	public String removeDuplicates(String input){
	    String result = "";
	    for (int i = 0; i < input.length(); i++) {
	        if(!result.contains(String.valueOf(input.charAt(i)))) {
	            result += String.valueOf(input.charAt(i));
	        }
	    }
	    return result;
	}
	
	
	public void escribeSinRepetidos() throws IOException {
		 String filePath = "C:\\Users\\Grudges\\Desktop\\Uno.txt";
	      String input = null;
	      //Instantiating the Scanner class
	      Scanner sc = new Scanner(new File(filePath));
	      //Instantiating the FileWriter class
	      FileWriter writer = new FileWriter("C:\\Users\\Grudges\\Desktop\\Dos.txt");
	      //Instantiating the Set class
	      Set set = new HashSet();
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	         if(set.add(input)) {
	            writer.append(input+"\n");
	         }
	      }
	      writer.flush();
	}

	public void muestraSinRepetidos() {
		String codigo = new String(), path = "C:\\Users\\Grudges\\Desktop\\Dos.txt";
        File archivo = new File(path);

        FileReader fr = null;
        BufferedReader entrada = null;
        try {
            fr = new FileReader(path);
            entrada = new BufferedReader(fr);

            while(entrada.ready()){
                codigo += entrada.readLine() +"\n" ;
            }

        }catch(IOException e) {
            e.printStackTrace();
        }finally{
            try{                    
                if(null != fr){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
txp2.setText(codigo);
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
                                    } else if (c[i] == '�') {
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
                        } else if (c[i] == '�') {
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
                                    } else if (c[i] == '�') {
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
                                            } else if (c[i] == '�') {
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
                                        } else if (c[i] == '�') {
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
                        } else if (c[i] == '�') {
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
                            } else if (c[i] == '�') {
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
                        } else if (c[i] == '�') {
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
                        } else if (c[i] == '�') {
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
                        } else if (c[i] == '�') {
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
            } else if (c[j] == '�') {
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
            } else if (c[j] == '�') {
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

    
    private void crearArchivo(String texto) {
        try {
            FileWriter escrito = new FileWriter("C:\\Users\\Grudges\\Desktop\\ListaDeTokens.txt");
            PrintWriter imprime = new PrintWriter(escrito);
            imprime.print(texto);
            escrito.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void crearArchivo2(String texto) {
        try {
            FileWriter escrito = new FileWriter("C:\\Users\\Grudges\\Desktop\\Uno.txt");
            PrintWriter imprime = new PrintWriter(escrito);
            imprime.print(texto);
            escrito.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
            } else if (c[i] == '�') {
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
                    errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
                    i = recorrer(i);
                    termino = true;
                }
            } else if (c[i] == '.') {
                decimal++;
                cadena += '.';
            } else if (comparar(c[i], letrasMinu)) {
                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
                i = recorrer(i);
                termino = true;
            } else if (comparar(c[i], letrasMayu)) {
                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
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
                                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte decimal mayor a 2 digitos";
                            }
                        } else {
                            tokens[cToken] = cadena;
                            cToken++;
                            cadena = "";
                        }
                    } else {
                        errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte entera mayor a 5 digitos";
                    }
                } else {
                    errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
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
                                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte decimal mayor a 2 digitos";
                            }
                        } else {
                            tokens[cToken] = cadena;
                            cToken++;
                            cadena = "";
                        }
                    } else {
                        errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte entera mayor a 5 digitos";
                    }
                } else {
                    errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
                }
                termino = true;
            } else if (c[i] == '�') {
                cLineas++;
                if (decimal <= 1) {
                    if (ent <= 5) {
                        if (decimal == 1) {
                            if (dec <= 2) {
                                tokens[cToken] = cadena;
                                cToken++;
                                cadena = "";
                            } else {
                                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte decimal mayor a 2 digitos";
                            }
                        } else {
                            tokens[cToken] = cadena;

                            cToken++;
                            cadena = "";
                        }
                    } else {
                        errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido, parte entera mayor a 5 digitos";
                    }
                } else {
                    errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
                }
                termino = true;
            } else {
                errores += "\nERROR LEXICO (" + cLineas + "): N�mero invalido";
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

    public boolean comparar(String xx, char[] v) {
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

    public void mostrar() {
        String tabla = "";
        int tamanio = tamanio(tokens);
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < palabrasRes.length; j++) {
                if (comparar(tokens[i], numeros)) {
                    if (comparar(tokens[i], letrasMinu) || comparar(tokens[i], letrasMayu)) {
                        tabla += "" + tokens[i] + "\n";
                        j = palabrasRes.length;
                    }
                }
            }
        }
        
        crearArchivo2(tabla);

        
    }

    public void generarArchivo() {
        String archivo = "";
        int tamanio = tamanio(tokens);
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < palabrasRes.length; j++) {
                if (tokens[i].equals(palabrasRes[j])) {
                    archivo += palabrasToken[j] + "\n";
                    j = palabrasRes.length;
                } else if (comparar(tokens[i], numeros)) {
                    if (tokens[i].indexOf('.') >= 0) {
                        archivo += "(tk_numDecimal, " + tokens[i] + ")\n";
                        j = palabrasRes.length;
                    } else {
                        if (comparar(tokens[i], letrasMinu) || comparar(tokens[i], letrasMayu)) {
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
}