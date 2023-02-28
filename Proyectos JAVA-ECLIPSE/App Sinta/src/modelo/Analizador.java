package modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Analizador extends JFrame {

	private JPanel contentPane;
	private JTextField textEntrada;
	private JTextArea texto;
    JFileChooser abrirArchivo;

	
	
	private JTextField textField_1;
	private JButton btnAbrir;
	private JButton btnAnalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analizador frame = new Analizador();
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
	public Analizador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Analizador lexico ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setBounds(30, 32, 1020, 41);
		contentPane.add(lblNewLabel);
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				  JButton btn = (JButton)e.getSource();
			            if( analizador == null ) abrirArchivo = new JFileChooser();
			            //Con esto solamente podamos abrir archivos
			            abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
			 
			            int seleccion = abrirArchivo.showOpenDialog( this );
			 
			            if( seleccion == JFileChooser.APPROVE_OPTION )
			            {
			                File f = abrirArchivo.getSelectedFile();
			                try
			                {
			                    String nombre = f.getName();
			                    String path = f.getAbsolutePath();
			                    String contenido = getArchivo( path );
			                    //Colocamos en el titulo de la aplicacion el 
			                    //nombre del archivo
			                    this.setTitle( nombre );
			 
			                    //En el editor de texto colocamos su contenido
			                    textEntrada.setText( contenido );
			 
			                }catch( Exception exp){}
			            }
			        }
			    
				
				
			}
		
				
			}
		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardar.setBounds(364, 84, 103, 34);
		contentPane.add(btnGuardar);
		
		btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				  File archivo = new File("C:/Users/Grudges/Desktop/uno.txt");
			        PrintWriter escribir;
			        try {
			            escribir = new PrintWriter(archivo);
			            escribir.print(textEntrada.getText());
			            escribir.close();
			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			        }
			        
			        try {
			            Reader lector = new BufferedReader(new FileReader("C:/Users/Grudges/Desktop/uno.txt"));
			            Lexer lexer = new Lexer(lector);
			            String resultado = "";
			            while (true) {
			                Tokens tokens = lexer.yylex();
			                if (tokens == null) {
			                    resultado += "FIN";
			                    textEntrada.setText(resultado);
			                    return;
			                }
			                switch (tokens) {
			                    case ERROR:
			                        resultado +=  "\n" + "Simbolo no definido\n";
			                        break;
			                    case Identificador: case Numero: case Reservadas:
			                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
			                        break;
			                    default:
			                        resultado += "\n" + "Token: " + tokens + "\n";
			                        break;
			                }
			            }
			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			        } catch (IOException ex) {
			            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			        }
			    }//GEN-LAST:event_btnAnalizarActionPerformed

				
				
				
				
				
			
		});
		
		
		btnAnalizar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAnalizar.setBounds(636, 84, 103, 34);
		contentPane.add(btnAnalizar);
		
		
//		JTextArea texto = new JTextArea(10,40); //numero de filas y columnas
//		texto.setEditable(true); //solo lectura
		
		
		
		
		
		
		textEntrada = new JTextField();
		textEntrada.setBounds(97, 170, 645, 243);
		contentPane.add(textEntrada);
		
		JLabel lblNewLabel_1 = new JLabel("Error lexico en: ");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(96, 536, 646, 89);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tabla de simbolos");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(878, 131, 146, 23);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(819, 170, 231, 275);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textIdentificador = new JTextField();
		textIdentificador.setBounds(95, 424, 644, 143);
		contentPane.add(textIdentificador);
		textIdentificador.setColumns(10);
	}
}