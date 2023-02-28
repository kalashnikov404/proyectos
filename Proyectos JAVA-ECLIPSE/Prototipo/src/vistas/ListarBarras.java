package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import api.ServiceTransporte;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Transporte;
import modelo.Vocal;
import servicios.ServiceArchivosImpl;
import servicios.ServiceClienteImpl;
import servicios.ServiceTransporteImpl;
import modelo.Csv;
import modelo.Garantia;

public class ListarBarras extends JPanel {
	private JTable table;
	private JTextField textField;
    static final int MAX_CHAR = 256;
    String d="";
    static int aaa;
    static int eee;
    static int iii;
    static int ooo;
    static int uuu;
    
	public ListarBarras(String usuario) throws ConexionException {
			

			setBackground(new Color(157, 198, 69));

			JLabel lblTitulo = new JLabel("Graficas & Reducci\u00F3n de codigo");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(58, 131, 29));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(6, 6, 1428, 31);
			setLayout(null);
			
			
			
			JPanel panelUno = new JPanel();
			panelUno.setBounds(0, 0, 417, 539);
			panelUno.setLayout(null);
			panelUno.setBackground(Color.CYAN);
			add(panelUno);
			
			JTextPane textPaneSalidaUno = new JTextPane();
			textPaneSalidaUno.setForeground(Color.RED);
			textPaneSalidaUno.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
			textPaneSalidaUno.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			textPaneSalidaUno.setBounds(221, 115, 186, 417);
			panelUno.add(textPaneSalidaUno);
			
			textField = new JTextField();
			textField.setForeground(Color.BLUE);
			textField.setFont(new Font("Roboto Medium", Font.ITALIC, 20));
			textField.setColumns(10);
			textField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			textField.setBounds(10, 138, 186, 32);
			panelUno.add(textField);
			
			JButton btnEjecutarUno = new JButton("Ejecutar");
			btnEjecutarUno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					


			        String entrada=textField.getText();

			        //Capturar palabra
			    	
			    	//Cambiar palabra a minusculas para que identifique
			    	//a una letra igual si es tecleada en formato minuscula 
			    	//y mayuscula
			    	
			    	String cadena = entrada.toLowerCase();
			    	String salida ="";

			    	
			    	//crear contenedor de caracteres para clasificar las repeticiones
			    	  char charArray[] = cadena.toCharArray();
			          Arrays.sort(charArray);
			          String alfabetica=String.valueOf(charArray);  
			         
			          int a = 0, ee = 0, i = 0, o = 0, u = 0;

			          for (int x = 0; x < cadena.length(); x++) {
			              char actual = cadena.toLowerCase().charAt(x);

			              switch (actual) {
			                  case 'a':
			                      a++;
			                      break;
			                  case 'e':
			                      ee++;
			                      break;
			                  case 'i':
			                      i++;
			                      break;
			                  case 'o':
			                      o++;
			                      break;
			                  case 'u':
			                      u++;
			                      break;
			                  default:
			                      break;
			              }
			          }


			        salida+=("N° de a: " + a + "\n" );
			        salida+=("N° de e: " + ee + "\n" );
			        salida+=("N° de i: " + i + "\n" );
			        salida+=("N° de o: " + o + "\n" );
			        salida+=("N° de u: " + u + "\n" );
			      
			          Vocal vocal = new Vocal();
			          
			        aaa=a;
			       eee=ee;
			       iii=i;
			       ooo=o;
			       uuu=u;

			         
			         
						textPaneSalidaUno.setText( salida);
				
			          
			          
					    Main x;
						try {
							x = new Main(usuario);
						} catch (ConexionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					      java.awt.EventQueue.invokeLater(new Runnable() {
					          public void run() {
					          
					        	  
					              Main.ejecutar();
					          }
					       });
				}
			});
			btnEjecutarUno.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
			btnEjecutarUno.setBounds(10, 51, 89, 23);
			panelUno.add(btnEjecutarUno);
			
			JButton btnLimpiarUno = new JButton("Limpiar");
			btnLimpiarUno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					

					textPaneSalidaUno.setText(null);
					textField.setText(null);
					
				}
			});
			btnLimpiarUno.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
			btnLimpiarUno.setBounds(243, 51, 89, 23);
			panelUno.add(btnLimpiarUno);
			
			JLabel lblCadena = new JLabel("Cadena");
			lblCadena.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadena.setForeground(Color.BLUE);
			lblCadena.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
			lblCadena.setBounds(10, 115, 89, 14);
			panelUno.add(lblCadena);
			
			JLabel lblSalida = new JLabel("Salida");
			lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
			lblSalida.setForeground(Color.RED);
			lblSalida.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
			lblSalida.setBounds(267, 90, 89, 14);
			panelUno.add(lblSalida);
	
			
			

			

			JButton btnSalir = new JButton("");
			btnSalir.setBounds(0, 564, 85, 81);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Principal frame = new Principal(usuario);
					frame.setVisible(true);

					setVisible(false);
					removeAll();
					repaint();

				}
			});
			btnSalir.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagenes/salir.png")));
			add(btnSalir);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.ORANGE);
			panel.setBounds(414, 0, 358, 539);
			add(panel);
			
			

		}
			
	
	
	

	

    static String convertirPalabra(String str){
         
        // Creacion de un array de 256 caracteres
        
        int count[] = new int[MAX_CHAR];
 String salida = "";
        int len = str.length();
 
        //Inicialización de contador
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;
 
     //Creación de un array que obtiene la longitud
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
 
          // Si hay un caracter que se repita aumenta contador de apariciones
                if (str.charAt(i) == ch[j])
                    find++;
            }
 
            
            //Si hay una aparicion de caracter imprime salida
            if (find == 1)
            	
            	
                salida += (
                        "La letra -> "
                    + "'"+str.charAt(i)+ "'"+ " " +
                     "tiene " + count[str.charAt(i)] + " "+ "apariciones en la palabra" + "\n" );
        }
        
        return salida.toString();
                
    }
    

    private static Vector getPalabras(String cadena) {
        Vector palabras = new Vector();
        String palabra = "";
        cadena = cadena.trim().toLowerCase() + " ";
        char[] c = cadena.toCharArray();
        int i;
        for(i = 0; i < cadena.length(); i++){
            if ( c[i] == ' '){
                palabras.add(palabra);
                palabra = "";
            }
            else
                palabra = palabra + String.valueOf(c[i]);
        }
        return palabras;
    }
    /*private static int ContarSpacios(String cadena){
        int i, k ;
        cadena = cadena.trim() + " ";
        char c[] = cadena.toCharArray();
        k = 0;
        for ( i = 0; i < cadena.length(); i++){
            if ( c[i]  == ' ')
                k++;
        }
        return k;
    }*/
    private static boolean Verificar(String cadena){
        String s;
        char c[],x;
        int i,j,k;
        int error = 0;
        s = " abcdefghijklmnñopqrstuvwxyzáéíóúü";
        c = s.toCharArray();
        for( i=0 ;  i < cadena.length() && error == 0;i++){
            x = cadena.charAt(i);
            k = 0;
            for(j = 0 ;  j < s.length() && k == 0;j++){
                if(x==c[j])
                    k++;
            }
            if( k == 0)
                error++;
        }
        if(error == 0)
            return true;
        else
            return false;
    }

    
	public static boolean buscarMayusculas(String str) {
		

        int upper = 0, lower = 0, number = 0, special = 0;

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                upper++;
         
        }
        
        if(upper>=2) {
        	return true;
        }
		return false;
		
	}
	
	
	
	
	public static boolean buscarRepetidos(String str) {

        int upper = 0, lower = 0, number = 0, special = 0;

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
             if (ch >= '0' && ch <= '9')
                number++;
        }
        
        if(number>=3) {
        	return true;
        }
		return false;
		
	}
	
	
	
	public static boolean buscarEspeciales(String str) {
		int special = 0;
		
		// (* _ - ¿ ¡ ? # $)
		
		if (str.contains("*")) {

            special++;
		}
		if (str.contains("_")) {

            special++;
		}
		if (str.contains("-")) {

            special++;
		}
		if (str.contains("¿")) {

            special++;
		}
		if (str.contains("¡")) {

            special++;
		}
		
		if (str.contains("?")) {

            special++;
		}
		if (str.contains("#")) {

            special++;
		}
		if (str.contains("$")) {

            special++;
		}
		
    	
        if(special>=1) {
        	return true;
        }
        
        
        else {
        	
    	return false;

        }

	}


	public static boolean buscarEspacios(String cadena) {
		
		
		int cantidadDeEspacios = 0;
        // Recorremos la cadena:
        for (int i = 0; i < cadena.length(); i++) {
            // Si el carácter en [i] es un espacio (' ') aumentamos el contador 
            if (cadena.charAt(i) == ' ') 
            	cantidadDeEspacios++;
        }
	
        if(cantidadDeEspacios>=1) {
        	return false;
        }
        
    	return true;

        
	}
	
	
	
	public static boolean buscarCaracteres(String str) {
		
        

        int longitud = str.replace(" ", "").length();

        
		if (longitud>8  && longitud<15) {
			
			
			return true;
		}
		
		return false;
		
	}
	
	
	private static boolean esVocal(char letra) {
        return "aeiou".contains(String.valueOf(letra).toLowerCase());
    }
}
