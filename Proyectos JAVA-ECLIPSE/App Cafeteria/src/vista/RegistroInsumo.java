package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import modelo.Cafecito;
import modelo.Ciudad;
import modelo.Empleado;
import modelo.Insumo;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceInsumoImpl;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JFormattedTextField;
public class RegistroInsumo extends JPanel {
	private JTextField textNombre;
	private JTextField textTipo;
	private JTextField textMarca;
	private JTextField textClaveInsumo;

	private JTextField textPresentacion;
	private JTextField textUmedida;
	private JTextField textExistencia;
	private JTextField textMinima;
	private JTextField textClaveCafecito;
	private JTextField textContenido;
	ServiceInsumoImpl serviceInsumoImpl = new ServiceInsumoImpl();
	ServiceEmpleadoImpl serviceEmpleadoImpl = new ServiceEmpleadoImpl();
	private JTextField textMaxima;


	/**
	 * Create the panel.
	 */

	
//	  private BufferedImage imagen;
//
//	  
//
//	    public static void main(String[] args){
////	    	invocacion de libreria de estilos
//	    	
//	    	
//	    	EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						RegistroCafecito frame = new RegistroCafecito();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});}
//      
	public RegistroInsumo() throws IOException {
		
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(176, 143, 304, 37);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre  ");
		labelNombre.setBounds(0, 136, 166, 42);
		labelNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelNombre);
		
		textTipo = new JTextField();
		textTipo.setBounds(176, 196, 304, 37);
		add(textTipo);
		textTipo.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(176, 249, 304, 37);
		add(textMarca);
		textMarca.setColumns(10);
		
		JLabel labelTipo = new JLabel("Tipo ");
		labelTipo.setBounds(0, 189, 166, 42);
		labelTipo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelTipo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipo.setForeground(Color.BLACK);
		add(labelTipo);
		
		JLabel labelMarca = new JLabel("Marca ");
		labelMarca.setBounds(0, 242, 166, 42);
		labelMarca.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMarca.setHorizontalAlignment(SwingConstants.CENTER);
		labelMarca.setForeground(Color.BLACK);
		add(labelMarca);
		
		JLabel labelEstado = new JLabel("Estado");

		
		
		JButton botonRegistrarEmpleado = new JButton("Registrar Insumo");
		botonRegistrarEmpleado.setBounds(661, 548, 304, 37);
		botonRegistrarEmpleado.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		botonRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Insumo insumo= new Insumo();
//				
//				private int claveProducto;
//				private String nombre;
//				private String tipo;
//				private String marca;
//				private String presentacion;
//				private String contenido;
//				private String umedia;
//				
//			//tabla minmax
//				private int existencia;
//				private int minimo;
//				private int maximo;
//				private int claveProducto2;
//				private int claveCafecito;
//				
				
			
//				
//				Empleado empleado = new Empleado();
//			//	Ciudad ciudad = new Ciudad();
				
				
//				Tabla insumo
				insumo.setClaveProducto(Integer.parseInt((textClaveInsumo.getText())));
				insumo.setNombre(textNombre.getText());
				insumo.setTipo(textTipo.getText());
				insumo.setMarca(textMarca.getText());
				insumo.setPresentacion(textPresentacion.getText());
				insumo.setContenido(textContenido.getText());
				insumo.setUmedia(textUmedida.getText());


//				tablaMINMAX
				insumo.setExistencia(Integer.parseInt((textExistencia.getText())));
				insumo.setMinimo(Integer.parseInt((textMinima.getText())));
				insumo.setMaximo(Integer.parseInt((textMaxima.getText())));
				insumo.setClaveProducto2(Integer.parseInt((textClaveInsumo.getText())));
				insumo.setClaveCafecito(Integer.parseInt((textClaveCafecito.getText())));

				
				
				
				serviceInsumoImpl.guardarInsumo(insumo);

				serviceInsumoImpl.guardarInsumoMinMax(insumo);
				

				
				
				
				
				
//				
				} catch (Exception e2) {
//
					JOptionPane.showInternalMessageDialog(null, "No se pudo registrar, verifique e intentelo de nuevo");
//					
//
//				
				}

				JOptionPane.showInternalMessageDialog(null, "Empleado registrado con exito");
			}
			
			
			
		});
		botonRegistrarEmpleado.setForeground(Color.BLUE);
		add(botonRegistrarEmpleado);
		
		JLabel labelClaveInsumo = new JLabel("Clave insumo ");
		labelClaveInsumo.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveInsumo.setForeground(Color.BLACK);
		labelClaveInsumo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveInsumo.setBounds(10, 84, 166, 42);
		add(labelClaveInsumo);
		
		textClaveInsumo = new JTextField();
		textClaveInsumo.setColumns(10);
		textClaveInsumo.setBounds(176, 91, 304, 37);
		add(textClaveInsumo);
		
		JLabel labelPresentacion = new JLabel("Presentacion ");
		labelPresentacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelPresentacion.setForeground(Color.BLACK);
		labelPresentacion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelPresentacion.setBounds(0, 287, 166, 42);
		add(labelPresentacion);
		
		
		
			
		
			
		{	
		};
		
		JLabel lblIngresaLosDatos = new JLabel("Ingresa los datos del insumo ");
		lblIngresaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLosDatos.setOpaque(true);
		lblIngresaLosDatos.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblIngresaLosDatos.setBackground(Color.LIGHT_GRAY);
		lblIngresaLosDatos.setBounds(0, 27, 1290, 50);
		add(lblIngresaLosDatos);
		
		textPresentacion = new JTextField();
		textPresentacion.setColumns(10);
		textPresentacion.setBounds(176, 297, 304, 37);
		add(textPresentacion);
		
		JLabel labelContenido = new JLabel("Contenido ");
		labelContenido.setHorizontalAlignment(SwingConstants.CENTER);
		labelContenido.setForeground(Color.BLACK);
		labelContenido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelContenido.setBounds(0, 344, 166, 42);
		add(labelContenido);
		
		JLabel labelUmedida = new JLabel("U.Medida ");
		labelUmedida.setHorizontalAlignment(SwingConstants.CENTER);
		labelUmedida.setForeground(Color.BLACK);
		labelUmedida.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelUmedida.setBounds(0, 397, 166, 42);
		add(labelUmedida);
		
		textUmedida = new JTextField();
		textUmedida.setColumns(10);
		textUmedida.setBounds(176, 404, 304, 37);
		add(textUmedida);
		
		JLabel labelExistencia = new JLabel("Existencia ");
		labelExistencia.setHorizontalAlignment(SwingConstants.CENTER);
		labelExistencia.setForeground(Color.BLACK);
		labelExistencia.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelExistencia.setBounds(0, 450, 166, 42);
		add(labelExistencia);
		
		textExistencia = new JTextField();
		textExistencia.setColumns(10);
		textExistencia.setBounds(176, 452, 304, 37);
		add(textExistencia);
    
		
		JLabel labelMinimo = new JLabel("C.Minima");
		labelMinimo.setHorizontalAlignment(SwingConstants.CENTER);
		labelMinimo.setForeground(Color.BLACK);
		labelMinimo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMinimo.setBounds(0, 493, 166, 42);
		add(labelMinimo);
		
		textMinima = new JTextField();
		textMinima.setColumns(10);
		textMinima.setBounds(176, 500, 304, 37);
		add(textMinima);
		
		JLabel labelCafecito = new JLabel("Cafecito");
		labelCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCafecito.setForeground(Color.BLACK);
		labelCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelCafecito.setBounds(500, 84, 166, 42);
		add(labelCafecito);
		
		JLabel labelClaveCafecito = new JLabel("Clave cafecito");
		labelClaveCafecito.setHorizontalAlignment(SwingConstants.CENTER);
		labelClaveCafecito.setForeground(Color.BLACK);
		labelClaveCafecito.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelClaveCafecito.setBounds(490, 136, 166, 42);
		add(labelClaveCafecito);
		
		JComboBox comboBoxCafecito = new JComboBox();
		
	
		comboBoxCafecito.setBounds(661, 91, 629, 37);
		add(comboBoxCafecito);
        ArrayList<String> lista2 = new ArrayList<String>();
        lista2 = serviceEmpleadoImpl.llenar_comboCafecito();
        for(int i = 0; i<lista2.size();i++){
        	comboBoxCafecito.addItem(lista2.get(i));
        }
		
		textClaveCafecito = new JTextField();
		textClaveCafecito.setColumns(10);
		textClaveCafecito.setBounds(661, 143, 304, 37);
		add(textClaveCafecito);
		
		textContenido = new JTextField();
		textContenido.setColumns(10);
		textContenido.setBounds(176, 352, 304, 37);
		add(textContenido);
		
		JLabel labelMaxima = new JLabel("C.Maxima");
		labelMaxima.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaxima.setForeground(Color.BLACK);
		labelMaxima.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		labelMaxima.setBounds(0, 541, 166, 42);
		add(labelMaxima);
		
		textMaxima = new JTextField();
		textMaxima.setColumns(10);
		textMaxima.setBounds(176, 548, 304, 37);
		add(textMaxima);

//		
		
		
//		JLabel fondo = new JLabel("");
//		fondo.setBounds(0, 0, 1300, 795);
//		add(fondo);		
//		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
//		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
//		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));
//
//		fondo.setIcon(img22);

		

	}
}
	


    	

