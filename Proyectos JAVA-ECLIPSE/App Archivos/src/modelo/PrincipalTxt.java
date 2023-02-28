package modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class PrincipalTxt extends JFrame {

	

	
	private JPanel contentPane;
	private JFileChooser abrirArchivo;
	ArrayList<String> lines = new ArrayList<String>();
	static Pattern temperatureRegex = Pattern.compile("^([0-9]+)");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalTxt frame = new PrincipalTxt();
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
	public PrincipalTxt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Salida");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel.setBounds(401, 9, 105, 26);
		contentPane.add(lblNewLabel);
		

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Roboto Slab", Font.BOLD | Font.ITALIC, 16));
		textPane.setBackground(Color.PINK);
		textPane.setBounds(295, 85, 382, 354);
		contentPane.add(textPane);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if( abrirArchivo == null ) abrirArchivo = new JFileChooser();
				//Con esto solamente podamos abrir archivos
				abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
				int seleccion = abrirArchivo.showOpenDialog(abrirArchivo);
				if( seleccion == JFileChooser.APPROVE_OPTION )
				{
					File f = abrirArchivo.getSelectedFile();
					try
					{
						String path = f.getAbsolutePath();
						String contenido = getArchivo( path );
						//En el editor de texto colocamos su contenido
						textPane.setText( contenido );
						
						

					}catch( Exception exp){
						JOptionPane.showMessageDialog(null, "No se ha abierto ningun archivo, intenta de nuevo");
					}
				}

			
				
				
			}
		});
		btnAbrir.setForeground(Color.RED);
		btnAbrir.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnAbrir.setBounds(10, 11, 93, 31);
		contentPane.add(btnAbrir);
		
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				textPane.setText(null);
				
			}
		});
		btnLimpiar.setForeground(Color.RED);
		btnLimpiar.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnLimpiar.setBounds(128, 11, 114, 31);
		contentPane.add(btnLimpiar);
		
		JButton btnEvaluar = new JButton("ordenar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo=textPane.getText();
				String[] numbers = codigo.split(",");

		        Integer[] intValues = new Integer[numbers.length];
		        for (int i = 0; i < numbers.length; i++) {
		            intValues[i] = Integer.parseInt(numbers[i].trim());
		        }
		        
		       
		        Arrays.sort(intValues);

		        StringBuilder builder = new StringBuilder();
		        for (int i = 0; i < intValues.length; i++) {
		            Integer intValue = intValues[i];
		            builder.append(intValue);
		            if (i < intValues.length - 1) {
		                builder.append(", ");
		            }
		        }
		        
		        

				String codigo2=textPane.getText();
				String[] numbers2 = codigo2.split(",");

		        Integer[] intValues2 = new Integer[numbers2.length];
		        for (int i = 0; i < numbers2.length; i++) {
		            intValues2[i] = Integer.parseInt(numbers2[i].trim());
		        }
		        
		       
		        Arrays.sort(intValues2, Collections.reverseOrder());

		        StringBuilder builder2 = new StringBuilder();
		        for (int i = 0; i < intValues2.length; i++) {
		            Integer intValue2 = intValues2[i];
		            builder2.append(intValue2);
		            if (i < intValues2.length - 1) {
		                builder2.append(", ");
		            }
		        }
		        
		       
		        
				textPane.setText("La entrada fue: "+  codigo + "\n" + "La salida ascendente es: "+builder + "\n"
						+  "\n" + "La salida descendente es: "+builder2 );

		        
				
			}
		});
		btnEvaluar.setForeground(Color.RED);
		btnEvaluar.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnEvaluar.setBounds(258, 11, 105, 31);
		contentPane.add(btnEvaluar);
		
		JLabel lblNewLabel_1 = new JLabel("Lectura de datos y ordenamiento");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 38, 218, 82);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Instrucciones:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setForeground(Color.BLUE);
		
		lblNewLabel_2.setBounds(10, 105, 167, 97);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*Presione abrir y busque un txt en su directorio");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 184, 262, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*Despues pulse ordenar");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(10, 219, 262, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblSiDeseaRealizar = new JLabel("*Si desea realizar un nuevo orden pulse limpiar");
		lblSiDeseaRealizar.setForeground(Color.RED);
		lblSiDeseaRealizar.setBounds(10, 244, 262, 14);
		contentPane.add(lblSiDeseaRealizar);
		
		JLabel lblNewLabel_5 = new JLabel("*Y repita los pasos (No agregue \".\" o \"letras\" )");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(10, 269, 262, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("*Solo comas: 1,2,4,5,6*");
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setBounds(10, 294, 252, 14);
		contentPane.add(lblNewLabel_5_1);

	}


JFileChooser seleccion=new JFileChooser();
File archivo;
FileInputStream entrada;
FileReader fr = null;
BufferedReader br = null;

public String abrirArchivo(File archivo) {
 String documento="";
 try {
    fr = new FileReader (archivo);
    br = new BufferedReader(fr);
    // Lectura del fichero
    String linea;
    while((linea=br.readLine())!=null)
       documento+=linea+"\n";
   
 }
 catch(Exception e){
    e.printStackTrace();
 }
 return documento;
}


public String btnSeleccionarArchivo() {
	String documento="";
	if (seleccion.showDialog(null,"abrir")==JFileChooser.APPROVE_OPTION) {
		archivo=seleccion.getSelectedFile();
		if (archivo.canRead()) {
			if (archivo.getName().endsWith(".txt")) {
				documento=abrirArchivo(archivo);
				return documento;
			}else {
				JOptionPane.showMessageDialog(null,"archivo no compatible");
			}
		}
	}
	return documento;
}



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





