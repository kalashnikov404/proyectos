package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificacionInsumos extends JPanel {
	
	private JTextField placasPrincipio, placas, modelo, color, hrEntrada, tamaño, tipo, lugarEstacionado, fcEntrada;
	private JButton modificarRegistro;

	public ModificacionInsumos() {
		setLayout(null);

		
		JLabel lblPlacasPrincipio = new JLabel("Ingresa la clave del insumo que deseas modificar");
		lblPlacasPrincipio.setFont(new Font("Khand", Font.PLAIN, 40));
		lblPlacasPrincipio.setOpaque(true);
		lblPlacasPrincipio.setBackground(Color.LIGHT_GRAY);
		lblPlacasPrincipio.setBounds(18, 18, 1150, 50);
		add(lblPlacasPrincipio);
		
		placasPrincipio .setFont(new Font("Khand", Font.PLAIN, 40));
		placasPrincipio .setBounds(18, 73, 300, 50);
		add(placasPrincipio );
		placasPrincipio .setColumns(10);
		
		
		JLabel lblInstrucciones = new JLabel("Llena los atributos que desees modificar");
		lblInstrucciones.setFont(new Font("Khand", Font.PLAIN, 40));
		lblInstrucciones.setOpaque(true);
		lblInstrucciones.setBackground(Color.LIGHT_GRAY);
		lblInstrucciones.setBounds(18, 148, 700, 50);
		add(lblInstrucciones);
		
		JLabel lblPlacas = new JLabel("Clave: ");
		lblPlacas.setFont(new Font("Khand", Font.PLAIN, 25));
		lblPlacas.setOpaque(true);
		lblPlacas.setBackground(Color.LIGHT_GRAY);
		lblPlacas.setBounds(18, 208, 75, 30);
		add(lblPlacas);
		
		placas = new JTextField();
		placas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.requestFocus();
			}
		});
		placas.setFont(new Font("Khand", Font.PLAIN, 25));
		placas.setBounds(98, 208, 100, 30);
		add(placas);
		placas.setColumns(10);
		
		JLabel lblModelo = new JLabel("Nombre: ");
		lblModelo.setFont(new Font("Khand", Font.PLAIN, 25));
		lblModelo.setOpaque(true);
		lblModelo.setBackground(Color.LIGHT_GRAY);
		lblModelo.setBounds(208, 208, 75, 30);
		add(lblModelo);
		
		modelo = new JTextField();
		modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color.requestFocus();
		}
		});
		modelo.setFont(new Font("Khand", Font.PLAIN, 25));
		modelo.setBounds(288, 208, 100, 30);
		add(modelo);
		modelo.setColumns(10);
		
		JLabel lblColor = new JLabel("Tipo: ");
		lblColor.setFont(new Font("Khand", Font.PLAIN, 25));
		lblColor.setOpaque(true);
		lblColor.setBackground(Color.LIGHT_GRAY);
		lblColor.setBounds(398, 208, 75, 30);
		add(lblColor);
		
		color = new JTextField();
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hrEntrada.requestFocus();
		}
		});
		color.setFont(new Font("Khand", Font.PLAIN, 25));
		color.setBounds(478, 208, 100, 30);
		add(color);
		color.setColumns(10);
		
		JLabel lblHrEntrada = new JLabel("Marca: ");
		lblHrEntrada.setFont(new Font("Khand", Font.PLAIN, 25));
		lblHrEntrada.setOpaque(true);
		lblHrEntrada.setBackground(Color.LIGHT_GRAY);
		lblHrEntrada.setBounds(588, 208, 105, 30);
		add(lblHrEntrada);
		
		hrEntrada = new JTextField();
		hrEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tamaño.requestFocus();
		}
		});
		hrEntrada.setFont(new Font("Khand", Font.PLAIN, 25));
		hrEntrada.setBounds(698, 208, 100, 30);
		add(hrEntrada);
		hrEntrada.setColumns(10);
		
		JLabel lblTamaño = new JLabel("Presentacion: ");
		lblTamaño.setFont(new Font("Khand", Font.PLAIN, 25));
		lblTamaño.setOpaque(true);
		lblTamaño.setBackground(Color.LIGHT_GRAY);
		lblTamaño.setBounds(808, 208, 85, 30);
		add(lblTamaño);
		
		tamaño = new JTextField();
		tamaño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo.requestFocus();
		}
		});
		tamaño.setFont(new Font("Khand", Font.PLAIN, 25));
		tamaño.setBounds(898, 208, 100, 30);
		add(tamaño);
		tamaño.setColumns(10);
		
		JLabel lblTipo = new JLabel("Contenido: ");
		lblTipo.setFont(new Font("Khand", Font.PLAIN, 25));
		lblTipo.setOpaque(true);
		lblTipo.setBackground(Color.LIGHT_GRAY);
		lblTipo.setBounds(1008, 208, 75, 30);
		add(lblTipo);
		
		tipo = new JTextField();
		tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lugarEstacionado.requestFocus();
		}
		});
		tipo.setFont(new Font("Khand", Font.PLAIN, 25));
		tipo.setBounds(1088, 208, 100, 30);
		add(tipo);
		tipo.setColumns(10);
		
		JLabel lblLugarEstacionado = new JLabel("Unidad de medidad: ");
		lblLugarEstacionado.setFont(new Font("Khand", Font.PLAIN, 25));
		lblLugarEstacionado.setOpaque(true);
		lblLugarEstacionado.setBackground(Color.LIGHT_GRAY);
		lblLugarEstacionado.setBounds(18, 248, 205, 30);
		add(lblLugarEstacionado);
		
		lugarEstacionado = new JTextField();
		lugarEstacionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fcEntrada.requestFocus();
		}
		});
		lugarEstacionado.setFont(new Font("Khand", Font.PLAIN, 25));
		lugarEstacionado.setBounds(228, 248, 100, 30);
		add(lugarEstacionado);
		lugarEstacionado.setColumns(10);
		
//		JLabel lblFcEntrada = new JLabel("Colonia: ");
//		lblFcEntrada.setFont(new Font("Khand", Font.PLAIN, 25));
//		lblFcEntrada.setOpaque(true);
//		lblFcEntrada.setBackground(Color.LIGHT_GRAY);
//		lblFcEntrada.setBounds(338, 248, 145, 30);
//		add(lblFcEntrada);
//		
//		fcEntrada = new JTextField();
//		fcEntrada.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				modificarRegistro.requestFocus();
//		}
//		});
//		fcEntrada.setFont(new Font("Khand", Font.PLAIN, 25));
//		fcEntrada.setBounds(488, 248, 120, 30);
//		add(fcEntrada);
//		fcEntrada.setColumns(10);
		
		modificarRegistro = new JButton("Modificar el registro del insumo");
		modificarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		modificarRegistro.setBounds(300, 382, 700, 60);
		modificarRegistro.setFont(new Font("Khand", Font.PLAIN, 40));
		add(modificarRegistro);

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);		
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

		fondo.setIcon(img22);

	}
	

}
	
	
