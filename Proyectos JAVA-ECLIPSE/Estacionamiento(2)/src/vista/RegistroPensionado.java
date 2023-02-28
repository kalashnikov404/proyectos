package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistroPensionado extends JPanel {
	
	private JTextField tfPlacas;
	private JTextField tfModelo;
	private JTextField tfColor;
	private JRadioButton chico;
	private JRadioButton mediano;
	private JRadioButton grande;
	private JRadioButton moto;
	private JRadioButton carro;
	private JRadioButton camioneta;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JTextField tfFinContrato;

	public RegistroPensionado() {
		
		setLayout(null);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));
		JLabel lblPlacas = new JLabel("Placas:");
		lblPlacas.setFont(new Font("Khand", Font.PLAIN, 50));
		lblPlacas.setOpaque(true);
		lblPlacas.setBackground(Color.LIGHT_GRAY);
		lblPlacas.setBounds(18, 89, 140, 52);
		add(lblPlacas);
		
		tfPlacas = new JTextField();
		tfPlacas.setFont(new Font("Khand", Font.PLAIN, 50));
		tfPlacas.setBounds(188, 85, 300, 60);
		add(tfPlacas);
		tfPlacas.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Khand", Font.PLAIN, 50));
		lblModelo.setBackground(Color.LIGHT_GRAY);
		lblModelo.setOpaque(true);
		lblModelo.setBounds(18, 200, 140, 52);
		add(lblModelo);
		
		tfModelo = new JTextField();
		tfModelo.setFont(new Font("Khand", Font.PLAIN, 50));
		tfModelo.setBounds(188, 195, 300, 60);
		add(tfModelo);
		tfModelo.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Khand", Font.PLAIN, 50));
		lblColor.setBackground(Color.LIGHT_GRAY);
		lblColor.setOpaque(true);
		lblColor.setBounds(18, 312, 140, 52);
		add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setFont(new Font("Khand", Font.PLAIN, 50));
		tfColor.setBounds(188, 307, 300, 60);
		add(tfColor);
		tfColor.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha inicio de contrato");
		lblFecha.setFont(new Font("Khand", Font.PLAIN, 35));
		lblFecha.setBackground(Color.LIGHT_GRAY);
		lblFecha.setOpaque(true);
		lblFecha.setBounds(18, 424, 300, 52);
		add(lblFecha);
		
		JLabel lblInicioContrato = new JLabel("");
		lblInicioContrato.setFont(new Font("Khand", Font.PLAIN, 50));
		lblInicioContrato.setBackground(Color.LIGHT_GRAY);
		lblInicioContrato.setOpaque(true);
		lblInicioContrato.setBounds(348, 420, 300, 60);
		add(lblInicioContrato);
		
		JLabel lblOpciones = new JLabel("Elige las opciones: ");
		lblOpciones.setBackground(Color.LIGHT_GRAY);
		lblOpciones.setFont(new Font("Khand", Font.PLAIN, 50));
		lblOpciones.setBounds(18, 536, 500, 52);
		add(lblOpciones);
		
		chico = new JRadioButton("Chico");
		chico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblFInContrato = new JLabel("Selecciona la fecha fin:");
		lblFInContrato.setFont(new Font("Khand", Font.PLAIN, 25));
		lblFInContrato.setBounds(18, 500, 600, 23);
		add(lblFInContrato);
		
		tfFinContrato = new JTextField();
		tfFinContrato.setFont(new Font("Khand", Font.PLAIN, 25));
		tfFinContrato.setBounds(250, 500, 500, 26);
		add(tfFinContrato);
		tfFinContrato.setColumns(10);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Khand", Font.PLAIN, 25));
		lblNombre.setBounds(18, 25, 90, 23);
		add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Khand", Font.PLAIN, 25));
		tfNombre.setBounds(200, 25, 130, 26);
		add(tfNombre);
		
		
		tfNombre.setColumns(10);
		chico.setForeground(Color.BLACK);
		chico.setBounds(18, 600, 141, 23);
		add(chico);
		
		mediano = new JRadioButton("Mediano");
		mediano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mediano.setForeground(Color.BLACK);
		mediano.setBounds(179, 600, 141, 23);
		add(mediano);
		
		grande = new JRadioButton("Grande");
		grande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		grande.setForeground(Color.BLACK);
		grande.setBounds(340, 600, 141, 23);
		add(grande);
		
		ButtonGroup grupoTamaño = new ButtonGroup();
		grupoTamaño.add(chico);
		grupoTamaño.add(mediano);
		grupoTamaño.add(grande);
		
		moto = new JRadioButton("Moto");
		moto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		moto.setForeground(Color.BLACK);
		moto.setBounds(18, 643, 141, 23);
		add(moto);
		
		carro = new JRadioButton("Carro");
		carro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		carro.setForeground(Color.BLACK);
		carro.setBounds(179, 643, 141, 23);
		add(carro);
		
		camioneta = new JRadioButton("Camioneta");
		camioneta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		camioneta.setForeground(Color.BLACK);
		camioneta.setBounds(340, 643, 141, 23);
		add(camioneta);
		
		ButtonGroup grupoTipo = new ButtonGroup();
		grupoTipo.add(moto);
		grupoTipo.add(carro);
		grupoTipo.add(camioneta);
		
		JButton btnImprimir = new JButton("Imprimir ticket");
		btnImprimir.setFont(new Font("Khand", Font.PLAIN, 30));
		btnImprimir.setBounds(800, 89, 200, 40);
		add(btnImprimir);
		
		JButton btnLugar = new JButton("Elegir lugar estacionado");
		btnLugar.setFont(new Font("Khand", Font.PLAIN, 30));
		btnLugar.setBounds(750, 200, 300, 40);
		add(btnLugar);

	}
}
