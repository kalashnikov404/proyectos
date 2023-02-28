package modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.ActionEvent;
import modelo.Archivos;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextArea textPane;
	private Metodos1 met;
	private Archivos ar;
	private JList listErrors;
	private Pila pila;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		met =new Metodos1();
		ar=new Archivos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 755);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(ar.btnSeleccionarArchivo());

			}
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		btnNewButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				met.getLimpiar();
				met.SetTokens();
				met.SetIds();
				String codigo=textPane.getText();
				String[] lineasCod = codigo. split("\n");
				for (int i = 0; i < lineasCod.length; i++) {
					met.setLinea(i);
					met.recorrer(lineasCod[i],0);
				}
				
				DefaultListModel<String>f=met.geterrores();
				
				try {
					ar.archivosTKID(met.getTokens(),"C:\\Users\\Grudges\\Desktop\\tokens.txt");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ar.abrir("C:\\Users\\Grudges\\Desktop\\tokens.txt");
				ar.abrir("C:\\Users\\Grudges\\Desktop\\ids.txt");
				
				//aqui empieza el sintactico
				
				
				ArrayList<String> tokens=ar.abrirSemen("C:\\Users\\Grudges\\Desktop\\tokens.txt");
				pila=new Pila(tokens);
				pila.reglas();
				
				DefaultListModel<String>e=pila.getErrores();

				for (int i = 0; i < e.size(); i++) {
					f.addElement(e.get(i));
				}
				listErrors.setModel(f);
				try {
					ar.archivosTKID(pila.mostrar(),"C:\\Users\\Grudges\\Desktop\\arbol.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				ar.abrir("C:\\Users\\Grudges\\Desktop\\arbol.txt");	
				Semantico s=new Semantico(ar.abrirSemento("C:\\Users\\Grudges\\Desktop\\arbol.txt"));
					//s.mostrar();
					s.moricion();
					s.mostrar();
					
					try {
						ar.archivoModificacionID(s.ArchivoIdes(),"C:\\Users\\Grudges\\Desktop\\ids.txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					DefaultListModel<String>ids=s.getErrores();

					for (int i = 0; i < ids.size(); i++) {
						f.addElement(ids.get(i));
					}
					listErrors.setModel(f);

			}
		});
		
		JLabel label = new JLabel("");
		panel.add(label);
		btnAnalizar.setBackground(Color.WHITE);
		btnAnalizar.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		panel.add(btnAnalizar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		textPane = new JTextArea();
		textPane.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		textPane.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 0, 0)));
		scrollPane_1.setViewportView(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		listErrors = new JList();
		listErrors.setModel(new AbstractListModel() {
		
			String[] values = new String[] {"Consola"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listErrors.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 20));
		listErrors.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		scrollPane.setViewportView(listErrors);
	}
}

