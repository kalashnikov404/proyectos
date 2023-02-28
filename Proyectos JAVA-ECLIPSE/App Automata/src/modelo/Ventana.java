package modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.io.PrintStream;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	 private static final int Q0 = 0;
	 private static final int Q1 = 1;
	 private static final int Q2 = 2;
	 private static final int Q3 = 3;
	 private static final int Q4 = 4;
	 private static final int Q5 = 5;
	 private static final int Q6 = 6;
	 private static final int Q7 = 7;
	 private static final int Q8 = 8;
	 private static final int Q9 = 9;
	 private static final int Q10 = 10;
	 private static final int Q11 = 11;
	 private static final int Q12 = 12;
	 
	 private int estado;
	 public StringBuilder buffer;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public Ventana() {
		estado = Q0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\tAUTOMATA");
		lblNewLabel.setBounds(10, 11, 762, 22);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa una cadena ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(481, 140, 178, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(481, 186, 178, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sobre el alfabeto binario, cadenas con un numero par de 0s y par de 1s");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(32, 47, 670, 54);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(Ventana.class.getResource("/recursos/diagra.jpeg")));
		lblNewLabel_3.setBounds(43, 112, 300, 316);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String string = textField.getText(); 
				 Ventana automata = new Ventana();
	 JOptionPane.showMessageDialog(null, "La Cadena '" + string + " es Aceptada?: " + (automata.acepta(string, true)|automata.acepta2(string, true)));
			}
		});
		btnNewButton.setBounds(522, 237, 100, 33);
		contentPane.add(btnNewButton);
		
		
		
	}	
	public int getEstado() {
		  return estado;
		 }

		 public boolean acepta(String str, boolean debug) {
		  init();
		  for (char c : str.toCharArray()) {
		   int estadoPrevio = estado;
		   adjuntarCaracter(c);
		   System.out.println("'" + c + "' " + getNombreEstado(estadoPrevio) + " -> " + getNombreEstado(estado));
		  }
		  return estado == Q11;
		 }
		 public boolean acepta2(String str, boolean debug) {
			  init();
			  for (char c : str.toCharArray()) {
			   int estadoPrevio = estado;
			   adjuntarCaracter(c);
			   System.out.println("'" + c + "' " + getNombreEstado(estadoPrevio) + " -> " + getNombreEstado(estado));
			  }
			  return estado == Q12;
			 }
		 
		 private void init() {
		  estado = Q0;
		  buffer = new StringBuilder();
		 }

		 private String getNombreEstado(int opcionEstado) {
		  String nombreEstado = "";
		  switch (opcionEstado) {
		   case Q0:
			   nombreEstado = "Q0";
		    break;
		   case Q1:
			   nombreEstado = "Q1";
		    break;
		   case Q2:
			   nombreEstado = "Q2";
		    break;
		   case Q3:
			   nombreEstado = "Q3";
		    break;
		   case Q4:
			   nombreEstado = "Q4";
			    break;
		   case Q5:
			   nombreEstado = "Q5";
			    break;
		   case Q6:
			   nombreEstado = "Q6";
			    break;
		   case Q7:
			   nombreEstado = "Q7";
			    break;
		   case Q8:
			   nombreEstado = "Q8";
			    break;
		   case Q9:
			   nombreEstado = "Q9";
			    break;
		   case Q10:
			   nombreEstado = "Q10";
			    break;
		   case Q11:
			   nombreEstado = "Q11";
			    break;
		   case Q12:
			   nombreEstado = "Q12";
			    break;
		  }
		  return nombreEstado;
		 }

		 private void adjuntarCaracter(char caracter) {
		  if (caracter != '1' && caracter != '0') {
		   JOptionPane.showMessageDialog(null,"Caracter invalido");
		   return;
		  }
		  buffer.append(caracter);
		  switch (estado) {
		   case Q0:
		    if (caracter == '1') {
		    	estado = Q2;
		    } else {
		    	estado = Q1;
		    }
		    break;
		   
		   case Q1:
			    if (caracter == '1') {
			    	estado = Q6;
			    } else {
			    	estado = Q3;
			    }
			    break;
		    
		   case Q2:
			    if (caracter == '1') {
			    	estado = Q4;
			    } else {
			    	estado = Q7;
			    }
			    break;    
			    
		   case Q3:
			    if (caracter == '1') {
			    	estado = Q5;
			    } else {
			    	estado = Q1;
			    }
			    break;    
			    
		   case Q4:
			    if (caracter == '1') {
			    	estado = Q2;
			    } else {
			    	estado = Q8;
			    }
			    break; 
			    
		   case Q7:
			    if (caracter == '1') {
			    	estado = Q8;
			    } else {
			    	estado = Q9;
			    }
			    break; 
			    
		   case Q8:
			    if (caracter == '1') {
			    	estado = Q7;
			    } else {
			    	estado = Q12;
			    }
			    break;   
			
		   case Q9:
			    if (caracter == '1') {
			    	estado = Q12;
			    } else {
			    	estado = Q7;
			    }
			    break;
			    
		   case Q12:
			    if (caracter == '1') {
			    	estado = Q9;
			    } else {
			    	estado = Q8;
			    }
			    break;    
			   
		   case Q5:
			    if (caracter == '1') {
			    	estado = Q11;
			    } else {
			    	estado = Q6;
			    }
			    break;
			    
		   case Q6:
			    if (caracter == '1') {
			    	estado = Q10;
			    } else {
			    	estado = Q5;
			    }
			    break;    
			
		   case Q10:
			    if (caracter == '1') {
			    	estado = Q6;
			    } else {
			    	estado = Q11;
			    }
			    break;    
			    
		   case Q11:
			    if (caracter == '1') {
			    	estado = Q5;
			    } else {
			    	estado = 10;
			    }
			    break;    
		   default:
		    System.err.println("Error");
		  }
		 }	
}

