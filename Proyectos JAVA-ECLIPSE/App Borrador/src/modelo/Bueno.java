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
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class Bueno extends JFrame {

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

				  
//					abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );

				  
			        PrintWriter escribir;
			        try {
			            Reader lector = new BufferedReader(new FileReader(guarda));     
					      int cont = 1;

			            Lexer lexer = new Lexer(lector);
			            String resultado = "";
			            String resultado2 = "LINEA " + cont + "\t\tSIMBOLO\n";
			            
			            
			            while (true) {
			                Tokens tokens = lexer.yylex();
			               
			                switch (tokens) {
			                    case ERROR:
			                        resultado2 += "\n" + "Error lexico  "+ lexer.lexeme+"\n";
				                    txp3.setText(resultado2);
			                        break;
			                    default:
			                    	 resultado2 +=  "\n"+tokens +": "+lexer.lexeme+"\n" ;
			                    	 //resultado = "\n" + "Token: " + tokens + "\n";
			                        txp2.setText(resultado2);
			                        break;
			                }
			                
			                
			                
			            
			            } 
			            
			        } 
			        catch(IOException ex)
					  {
					   JOptionPane.showMessageDialog(null,"Su archivo no ha podido ser analizado"," Advertencia",JOptionPane.WARNING_MESSAGE);
					  }
					 
				
			
			
			
			
			
			
			
			
		}
	});
		btnAnalizar.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(btnAnalizar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(108, 566, 453, 105);
		getContentPane().add(lblNewLabel);

	
		
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

	
	
	
	
	public void atrapaErrores() {
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
}