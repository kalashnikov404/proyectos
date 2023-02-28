package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.SeparaSilabas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AplicacionPuntoSingular extends JFrame {

	private JPanel contentPane;
	private JTextField textCadenaUno;
    static final int MAX_CHAR = 256;
    private JTextField textPalabra;
    private JTextField textContraseña;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		 try{
	            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");	
	            System.err.close();
	            System.setErr(System.out);
		 } catch(Exception e){
	        }

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionPuntoSingular frame = new AplicacionPuntoSingular();
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
	public AplicacionPuntoSingular() {
		setTitle("Aplicación Punto Singular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUno = new JPanel();
		panelUno.setBackground(Color.CYAN);
		panelUno.setBounds(10, 75, 342, 550);
		contentPane.add(panelUno);
		panelUno.setLayout(null);
		
		JTextPane textPaneSalidaUno = new JTextPane();
		textPaneSalidaUno.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textPaneSalidaUno.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
		textPaneSalidaUno.setForeground(Color.RED);
		textPaneSalidaUno.setBounds(146, 108, 186, 417);
		panelUno.add(textPaneSalidaUno);
		

		textCadenaUno = new JTextField();
		textCadenaUno.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		textCadenaUno.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textCadenaUno.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
		textCadenaUno.setForeground(Color.BLUE);
		textCadenaUno.setBounds(10, 138, 126, 32);
		panelUno.add(textCadenaUno);
		textCadenaUno.setColumns(10);
		
		JButton btnEjecutarUno = new JButton("Ejecutar");
		btnEjecutarUno.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnEjecutarUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

		        String entrada=textCadenaUno.getText();

		        //Capturar palabra
		    	
		    	//Cambiar palabra a minusculas para que identifique
		    	//a una letra igual si es tecleada en formato minuscula 
		    	//y mayuscula
		    	
		    	String cadena = entrada.toLowerCase();
		    	
		    	//crear contenedor de caracteres para clasificar las repeticiones
		    	  char charArray[] = cadena.toCharArray();
		          Arrays.sort(charArray);
		          String alfabetica=String.valueOf(charArray);  
		          

		         
				
					textPaneSalidaUno.setText( "La palabra tecleada es : " + entrada + " en forma alfabetica => " + alfabetica +  "\n" +
							convertirPalabra(alfabetica));

				
				
				
			}
		});
		btnEjecutarUno.setBounds(10, 51, 89, 23);
		panelUno.add(btnEjecutarUno);
		
		JButton btnLimpiarUno = new JButton("Limpiar");
		btnLimpiarUno.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnLimpiarUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneSalidaUno.setText(null);
				textCadenaUno.setText(null);

				
				
			}
		});
		btnLimpiarUno.setBounds(243, 51, 89, 23);
		panelUno.add(btnLimpiarUno);
		
		
		
		JLabel lblCadena = new JLabel("Cadena");
		lblCadena.setForeground(Color.BLUE);
		lblCadena.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblCadena.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadena.setBounds(10, 115, 89, 14);
		panelUno.add(lblCadena);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setForeground(Color.RED);
		lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblSalida.setBounds(196, 85, 89, 14);
		panelUno.add(lblSalida);
		
		JLabel lblNewLabel_1 = new JLabel("Punto Singular");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 255, 116, 77);
		panelUno.add(lblNewLabel_1);
		
		JPanel panelDos = new JPanel();
		panelDos.setBackground(Color.CYAN);
		panelDos.setBounds(399, 75, 342, 550);
		contentPane.add(panelDos);
		panelDos.setLayout(null);
		
		JTextPane textPaneSalidaDos = new JTextPane();
		textPaneSalidaDos.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		textPaneSalidaDos.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
		textPaneSalidaDos.setForeground(Color.RED);
		textPaneSalidaDos.setBounds(146, 112, 186, 417);
		panelDos.add(textPaneSalidaDos);
		
		JButton btnEjecutarDos = new JButton("Silabar");
		btnEjecutarDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Verificar(textPalabra.getText().trim().toLowerCase())){
	                Vector palabras = getPalabras(textPalabra.getText());
	                SeparaSilabas s = new SeparaSilabas();
	                int i;

	                for ( i = 0; i < palabras.size(); i++){
	                    s.setString((String)palabras.get(i));
	                    textPaneSalidaDos.setText(s.silabear());
	                }
	                
	            }else
	            	textPaneSalidaDos.setText("Palabra no válida");				
			}
		});
		btnEjecutarDos.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnEjecutarDos.setBounds(10, 53, 89, 23);
		panelDos.add(btnEjecutarDos);
		
		JButton btnLimpiarDos = new JButton("Limpiar");
		btnLimpiarDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPaneSalidaDos.setText(null);
				textPalabra.setText(null);
				
			}
		});
		btnLimpiarDos.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnLimpiarDos.setBounds(243, 53, 89, 23);
		panelDos.add(btnLimpiarDos);
		
		JLabel lblPalabra = new JLabel("Palabra");
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabra.setForeground(Color.BLUE);
		lblPalabra.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblPalabra.setBounds(22, 112, 89, 14);
		panelDos.add(lblPalabra);
		
		textPalabra = new JTextField();
		textPalabra.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		textPalabra.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
		textPalabra.setForeground(Color.BLUE);
		textPalabra.setColumns(10);
		textPalabra.setBounds(10, 137, 126, 32);
		panelDos.add(textPalabra);
		
		JLabel lblSalidaDos = new JLabel("Salida");
		lblSalidaDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaDos.setForeground(Color.RED);
		lblSalidaDos.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblSalidaDos.setBounds(202, 87, 89, 14);
		panelDos.add(lblSalidaDos);
		
		JLabel lblNewLabel_1_1 = new JLabel("Punto Singular");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(10, 261, 116, 77);
		panelDos.add(lblNewLabel_1_1);
		
		
		
		JPanel panelTres = new JPanel();
		panelTres.setBackground(Color.CYAN);
		panelTres.setBounds(794, 75, 342, 550);
		contentPane.add(panelTres);
		panelTres.setLayout(null);
		

		JTextPane textPaneSalidaTres = new JTextPane();
		textPaneSalidaTres.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		textPaneSalidaTres.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		textPaneSalidaTres.setForeground(Color.RED);
		textPaneSalidaTres.setBounds(146, 122, 186, 417);
		panelTres.add(textPaneSalidaTres);
		
		JButton btnEjecutarTres = new JButton("Evaluar");
		btnEjecutarTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		        String entrada=textContraseña.getText();

		        String salida="";

		       
		        if(buscarMayusculas(entrada)==true){
		 
			}else if (buscarMayusculas(entrada)==false){
				
				  salida += "✘ Error la contraseña debe contener al menos 2 letras mayúsculas" + "\n" ;
				
				  textPaneSalidaTres.setText( salida.toString());
			
			}
		        
		        if(buscarRepetidos(entrada)==true){
		        	
		        }else if(buscarRepetidos(entrada)==false){
		        	
		        	 salida +="✘ Error la contraseña debe contener al menos 3 numero no repetidos" + "\n";
		        
		        	 textPaneSalidaTres.setText(salida.toString());
		        	
		        }
		        
		        if(buscarEspacios(entrada)==true){
		        	
		        }else if(buscarEspacios(entrada)==false){
		        	 salida +="✘ Error la contraseña no debe tener espacios en blanco" + "\n";
		        	
		        	 textPaneSalidaTres.setText(salida.toString());
		        	
		        }
		        
		        
		        if(buscarEspeciales(entrada)==true){
		        	
		        }else if(buscarEspeciales(entrada)==false){
		        	
		        	salida +="✘ Error la contraseña debe tener al menos un carácter especial (* _ - ¿ ¡ ? # $)"
			       			 + "" + "\n";
		        	
		        	textPaneSalidaTres.setText(salida.toString());
		        	
		        }
		        
		        		if(buscarCaracteres(entrada)==true){
		        	
		        			
		        			
		        }else if(buscarCaracteres(entrada)==false){
		        	salida +="✘ Error la contraseña debe tener al menos 8 caracteres y ser menor a 15" + "\n";
		        	
		        	textPaneSalidaTres.setText(salida.toString());
		        	
		        }
		        		
		        if(buscarCaracteres(entrada)==true &&
		        		buscarRepetidos(entrada)==true &&
		        		buscarEspacios(entrada)==true &&
		        		buscarEspeciales(entrada)==true &&
		        		buscarCaracteres(entrada)==true) {
		        	textPaneSalidaTres.setText(
	  		       			 "✔ Contraseña valida");
		        		
		        
			}
		       /*
		        “FaciliTo22 ” -> 
		        
		        Contraseña: “ContraseñA495*”
		        */
		        else{
		        	salida += "✘ Hubo errores: Revisa tu entrada" + "\n";
		        	textPaneSalidaTres.setText(salida.toString());
		        }
		        
			
				
				
			}
		});
		btnEjecutarTres.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnEjecutarTres.setBounds(10, 56, 89, 23);
		panelTres.add(btnEjecutarTres);
		
		
		textContraseña = new JTextField();
		textContraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		textContraseña.setFont(new Font("Roboto Slab Black", Font.ITALIC, 13));
		textContraseña.setForeground(Color.BLUE);
		textContraseña.setColumns(10);
		textContraseña.setBounds(10, 142, 126, 32);
		panelTres.add(textContraseña);
		
		
		JButton btnLimpiarTres = new JButton("Limpiar");
		btnLimpiarTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				textPaneSalidaTres.setText(null);
				textContraseña.setText(null);
				
				
			}
		});
		btnLimpiarTres.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		btnLimpiarTres.setBounds(243, 56, 89, 23);
		panelTres.add(btnLimpiarTres);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.BLUE);
		lblContrasea.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblContrasea.setBounds(10, 116, 89, 14);
		panelTres.add(lblContrasea);
		
		
		JLabel lblSalidaDos_1 = new JLabel("Salida");
		lblSalidaDos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaDos_1.setForeground(Color.RED);
		lblSalidaDos_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		lblSalidaDos_1.setBounds(243, 97, 89, 14);
		panelTres.add(lblSalidaDos_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Punto Singular");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1.setBounds(10, 260, 116, 77);
		panelTres.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Ejercicio Uno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(26, 25, 283, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEjercicioDos = new JLabel("Ejercicio Dos");
		lblEjercicioDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjercicioDos.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		lblEjercicioDos.setBounds(422, 25, 283, 39);
		contentPane.add(lblEjercicioDos);
		
		JLabel lblEjercicioTres = new JLabel("Ejercicio Tres");
		lblEjercicioTres.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjercicioTres.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		lblEjercicioTres.setBounds(826, 25, 283, 39);
		contentPane.add(lblEjercicioTres);
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


    
    
}
