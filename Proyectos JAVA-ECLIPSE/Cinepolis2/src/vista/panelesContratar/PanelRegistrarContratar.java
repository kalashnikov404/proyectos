package vista.panelesContratar;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import com.toedter.calendar.JDateChooser;

import utilidades.IOFile;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;

public class PanelRegistrarContratar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField cajaCurp;
	private static  JTextField cajaNombre;
	private static JTextField cajaPaterno;
	private static JTextField cajaMaterno;
	private static JTextField cajaTelefono;
	private static  JTextField cajaCalle;
	private static JTextField cajaNumero;
	private static JTextField cajaSueldo;
	private static JDateChooser calendarioNacimiento;
	private static final ButtonGroup grupoGenero = new ButtonGroup();
	private static JRadioButton radioFemenino;
	private static  JRadioButton radioMasculino;
	private static JComboBox<String> comboOrientacion;
	private static JComboBox<String> comboColonia;
	private static JDateChooser calendarioFin;
	private static  JComboBox<String> comboPuesto;
	private static JComboBox<String> comboDiaDescanso;
	private static JComboBox<String> comboSucursal;
	private static JComboBox<String> comboHorasE;
	private static JComboBox<String> comboMinutosE;
	private static JComboBox<String> comboSegundosE;
	private static JComboBox<String> comboMinutosS;
	private static JComboBox<String> comboHorasS;
	private static JComboBox<String> comboSegundosS;
	
	

	public static JComboBox<String> getComboHorasE() {
		return comboHorasE;
	}



	public static JComboBox<String> getComboMinutosE() {
		return comboMinutosE;
	}



	public static JComboBox<String> getComboSegundosE() {
		return comboSegundosE;
	}



	public static JComboBox<String> getComboMinutosS() {
		return comboMinutosS;
	}



	public static JComboBox<String> getComboHorasS() {
		return comboHorasS;
	}



	public static JComboBox<String> getComboSegundosS() {
		return comboSegundosS;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static JTextField getCajaCurp() {
		return cajaCurp;
	}



	public static JTextField getCajaNombre() {
		return cajaNombre;
	}



	public static JTextField getCajaPaterno() {
		return cajaPaterno;
	}



	public static JTextField getCajaMaterno() {
		return cajaMaterno;
	}



	public static JTextField getCajaTelefono() {
		return cajaTelefono;
	}



	public static JTextField getCajaCalle() {
		return cajaCalle;
	}



	public static JTextField getCajaNumero() {
		return cajaNumero;
	}



	public static JTextField getCajaSueldo() {
		return cajaSueldo;
	}



	public static JDateChooser getCalendarioNacimiento() {
		return calendarioNacimiento;
	}



	public static ButtonGroup getGrupogenero() {
		return grupoGenero;
	}



	public static JRadioButton getRadioFemenino() {
		return radioFemenino;
	}



	public static JRadioButton getRadioMasculino() {
		return radioMasculino;
	}



	public static JComboBox<String> getComboOrientacion() {
		return comboOrientacion;
	}



	public static JComboBox<String> getComboColonia() {
		return comboColonia;
	}



	public static JDateChooser getCalendarioFin() {
		return calendarioFin;
	}



	public static JComboBox<String> getComboPuesto() {
		return comboPuesto;
	}



	public static JComboBox<String> getComboDiaDescanso() {
		return comboDiaDescanso;
	}



	public static JComboBox<String> getComboSucursal() {
		return comboSucursal;
	}



	/**
	 * Create the panel.
	 */
	public PanelRegistrarContratar() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 66, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{24, 35, 36, 36, 36, 36, 36, 36, 30, 36, 36, 36, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Datos Personales");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lblNewLabel_2.setForeground(new Color(204, 51, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_13 = new JLabel("Datos de contrato");
		lblNewLabel_13.setForeground(new Color(204, 51, 255));
		lblNewLabel_13.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 4;
		gbc_lblNewLabel_13.gridy = 0;
		add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JLabel lblNewLabel = new JLabel("Curp");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		cajaCurp = new JTextField();
		cajaCurp.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaCurp = new GridBagConstraints();
		gbc_cajaCurp.insets = new Insets(0, 0, 5, 5);
		gbc_cajaCurp.fill = GridBagConstraints.BOTH;
		gbc_cajaCurp.gridx = 2;
		gbc_cajaCurp.gridy = 1;
		add(cajaCurp, gbc_cajaCurp);
		cajaCurp.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Fin");
		lblNewLabel_15.setForeground(new Color(30, 144, 255));
		lblNewLabel_15.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 3;
		gbc_lblNewLabel_15.gridy = 1;
		add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		calendarioFin = new JDateChooser();
		calendarioFin.getCalendarButton().setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_calendarioFin = new GridBagConstraints();
		gbc_calendarioFin.insets = new Insets(0, 0, 5, 0);
		gbc_calendarioFin.fill = GridBagConstraints.BOTH;
		gbc_calendarioFin.gridx = 4;
		gbc_calendarioFin.gridy = 1;
		add(calendarioFin, gbc_calendarioFin);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaNombre = new GridBagConstraints();
		gbc_cajaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_cajaNombre.fill = GridBagConstraints.BOTH;
		gbc_cajaNombre.gridx = 2;
		gbc_cajaNombre.gridy = 2;
		add(cajaNombre, gbc_cajaNombre);
		cajaNombre.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Puesto");
		lblNewLabel_16.setForeground(new Color(30, 144, 255));
		lblNewLabel_16.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 3;
		gbc_lblNewLabel_16.gridy = 2;
		add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		comboPuesto = new JComboBox<>(IOFile.getOpciones("archivos//Puestos"));
		comboPuesto.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboPuesto = new GridBagConstraints();
		gbc_comboPuesto.insets = new Insets(0, 0, 5, 0);
		gbc_comboPuesto.fill = GridBagConstraints.BOTH;
		gbc_comboPuesto.gridx = 4;
		gbc_comboPuesto.gridy = 2;
		add(comboPuesto, gbc_comboPuesto);
		
		JLabel lblNewLabel_3 = new JLabel("Paterno");
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cajaPaterno = new JTextField();
		cajaPaterno.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaPaterno = new GridBagConstraints();
		gbc_cajaPaterno.insets = new Insets(0, 0, 5, 5);
		gbc_cajaPaterno.fill = GridBagConstraints.BOTH;
		gbc_cajaPaterno.gridx = 2;
		gbc_cajaPaterno.gridy = 3;
		add(cajaPaterno, gbc_cajaPaterno);
		cajaPaterno.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Sueldo $");
		lblNewLabel_14.setForeground(new Color(30, 144, 255));
		lblNewLabel_14.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 3;
		gbc_lblNewLabel_14.gridy = 3;
		add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		cajaSueldo = new JTextField();
		cajaSueldo.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaSueldo = new GridBagConstraints();
		gbc_cajaSueldo.insets = new Insets(0, 0, 5, 0);
		gbc_cajaSueldo.fill = GridBagConstraints.BOTH;
		gbc_cajaSueldo.gridx = 4;
		gbc_cajaSueldo.gridy = 3;
		add(cajaSueldo, gbc_cajaSueldo);
		cajaSueldo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Materno");
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		cajaMaterno = new JTextField();
		cajaMaterno.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaMaterno = new GridBagConstraints();
		gbc_cajaMaterno.insets = new Insets(0, 0, 5, 5);
		gbc_cajaMaterno.fill = GridBagConstraints.BOTH;
		gbc_cajaMaterno.gridx = 2;
		gbc_cajaMaterno.gridy = 4;
		add(cajaMaterno, gbc_cajaMaterno);
		cajaMaterno.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Dia Descanso");
		lblNewLabel_17.setForeground(new Color(30, 144, 255));
		lblNewLabel_17.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 3;
		gbc_lblNewLabel_17.gridy = 4;
		add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		comboDiaDescanso = new JComboBox<>(IOFile.getOpciones("archivos//Dias"));
		comboDiaDescanso.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboDiaDescanso = new GridBagConstraints();
		gbc_comboDiaDescanso.insets = new Insets(0, 0, 5, 0);
		gbc_comboDiaDescanso.fill = GridBagConstraints.BOTH;
		gbc_comboDiaDescanso.gridx = 4;
		gbc_comboDiaDescanso.gridy = 4;
		add(comboDiaDescanso, gbc_comboDiaDescanso);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setForeground(new Color(30, 144, 255));
		lblNewLabel_5.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		calendarioNacimiento = new JDateChooser();
		calendarioNacimiento.getCalendarButton().setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_calendarioNacimiento = new GridBagConstraints();
		gbc_calendarioNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_calendarioNacimiento.fill = GridBagConstraints.BOTH;
		gbc_calendarioNacimiento.gridx = 2;
		gbc_calendarioNacimiento.gridy = 5;
		add(calendarioNacimiento, gbc_calendarioNacimiento);
		
		JLabel lblNewLabel_20 = new JLabel("Sucursal");
		lblNewLabel_20.setForeground(new Color(30, 144, 255));
		lblNewLabel_20.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 3;
		gbc_lblNewLabel_20.gridy = 5;
		add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		comboSucursal = new JComboBox<>();
		comboSucursal.addItem("Seleccione una opción");
		comboSucursal.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboSucursal = new GridBagConstraints();
		gbc_comboSucursal.insets = new Insets(0, 0, 5, 0);
		gbc_comboSucursal.fill = GridBagConstraints.BOTH;
		gbc_comboSucursal.gridx = 4;
		gbc_comboSucursal.gridy = 5;
		add(comboSucursal, gbc_comboSucursal);
		
		JLabel lblNewLabel_6 = new JLabel("G\u00E9nero");
		lblNewLabel_6.setForeground(new Color(30, 144, 255));
		lblNewLabel_6.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		radioFemenino = new JRadioButton("Femenino");
		radioFemenino.setFont(new Font("Impact", Font.PLAIN, 25));
		grupoGenero.add(radioFemenino);
		GridBagConstraints gbc_radioFemenino = new GridBagConstraints();
		gbc_radioFemenino.insets = new Insets(0, 0, 5, 5);
		gbc_radioFemenino.anchor = GridBagConstraints.WEST;
		gbc_radioFemenino.gridx = 1;
		gbc_radioFemenino.gridy = 6;
		add(radioFemenino, gbc_radioFemenino);
		
		radioMasculino = new JRadioButton("Masculino");
		radioMasculino.setFont(new Font("Impact", Font.PLAIN, 25));
		grupoGenero.add(radioMasculino);
		GridBagConstraints gbc_radioMasculino = new GridBagConstraints();
		gbc_radioMasculino.anchor = GridBagConstraints.WEST;
		gbc_radioMasculino.insets = new Insets(0, 0, 5, 5);
		gbc_radioMasculino.gridx = 2;
		gbc_radioMasculino.gridy = 6;
		add(radioMasculino, gbc_radioMasculino);
		
		JLabel lblNewLabel_18 = new JLabel("Hora entrada");
		lblNewLabel_18.setForeground(new Color(30, 144, 255));
		lblNewLabel_18.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 3;
		gbc_lblNewLabel_18.gridy = 6;
		add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		comboHorasE = new JComboBox<>(IOFile.getOpciones("archivos//Horas"));
		comboHorasE.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboHorasE = new GridBagConstraints();
		gbc_comboHorasE.insets = new Insets(0, 0, 5, 0);
		gbc_comboHorasE.fill = GridBagConstraints.BOTH;
		gbc_comboHorasE.gridx = 4;
		gbc_comboHorasE.gridy = 6;
		add(comboHorasE, gbc_comboHorasE);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono");
		lblNewLabel_7.setForeground(new Color(30, 144, 255));
		lblNewLabel_7.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaTelefono = new GridBagConstraints();
		gbc_cajaTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_cajaTelefono.fill = GridBagConstraints.BOTH;
		gbc_cajaTelefono.gridx = 2;
		gbc_cajaTelefono.gridy = 7;
		add(cajaTelefono, gbc_cajaTelefono);
		cajaTelefono.setColumns(10);
		
		comboMinutosE = new JComboBox<>(IOFile.getOpciones("archivos//Minutos"));
		comboMinutosE.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboMinutosE = new GridBagConstraints();
		gbc_comboMinutosE.insets = new Insets(0, 0, 5, 0);
		gbc_comboMinutosE.fill = GridBagConstraints.BOTH;
		gbc_comboMinutosE.gridx = 4;
		gbc_comboMinutosE.gridy = 7;
		add(comboMinutosE, gbc_comboMinutosE);
		
		JLabel lblNewLabel_8 = new JLabel("Datos de domicilio");
		lblNewLabel_8.setForeground(new Color(204, 51, 255));
		lblNewLabel_8.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 3;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		comboSegundosE = new JComboBox<>(IOFile.getOpciones("archivos//Segundos"));
		comboSegundosE.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboSegundosE = new GridBagConstraints();
		gbc_comboSegundosE.insets = new Insets(0, 0, 5, 0);
		gbc_comboSegundosE.fill = GridBagConstraints.BOTH;
		gbc_comboSegundosE.gridx = 4;
		gbc_comboSegundosE.gridy = 8;
		add(comboSegundosE, gbc_comboSegundosE);
		
		JLabel lblNewLabel_9 = new JLabel("Calle");
		lblNewLabel_9.setForeground(new Color(30, 144, 255));
		lblNewLabel_9.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		cajaCalle = new JTextField();
		cajaCalle.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaCalle = new GridBagConstraints();
		gbc_cajaCalle.insets = new Insets(0, 0, 5, 5);
		gbc_cajaCalle.fill = GridBagConstraints.BOTH;
		gbc_cajaCalle.gridx = 2;
		gbc_cajaCalle.gridy = 9;
		add(cajaCalle, gbc_cajaCalle);
		cajaCalle.setColumns(10);
		
		comboHorasS = new JComboBox<>(IOFile.getOpciones("archivos//Horas"));
		comboHorasS.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboHorasS = new GridBagConstraints();
		gbc_comboHorasS.insets = new Insets(0, 0, 5, 0);
		gbc_comboHorasS.fill = GridBagConstraints.BOTH;
		gbc_comboHorasS.gridx = 4;
		gbc_comboHorasS.gridy = 9;
		add(comboHorasS, gbc_comboHorasS);
		
		JLabel lblNewLabel_10 = new JLabel("N\u00FAmero");
		lblNewLabel_10.setForeground(new Color(30, 144, 255));
		lblNewLabel_10.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 10;
		add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		cajaNumero = new JTextField();
		cajaNumero.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_cajaNumero = new GridBagConstraints();
		gbc_cajaNumero.insets = new Insets(0, 0, 5, 5);
		gbc_cajaNumero.fill = GridBagConstraints.BOTH;
		gbc_cajaNumero.gridx = 2;
		gbc_cajaNumero.gridy = 10;
		add(cajaNumero, gbc_cajaNumero);
		cajaNumero.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Hora de salida");
		lblNewLabel_19.setForeground(new Color(30, 144, 255));
		lblNewLabel_19.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 3;
		gbc_lblNewLabel_19.gridy = 10;
		add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		comboMinutosS = new JComboBox<>(IOFile.getOpciones("archivos//Minutos"));
		comboMinutosS.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboMinutosS = new GridBagConstraints();
		gbc_comboMinutosS.insets = new Insets(0, 0, 5, 0);
		gbc_comboMinutosS.fill = GridBagConstraints.BOTH;
		gbc_comboMinutosS.gridx = 4;
		gbc_comboMinutosS.gridy = 10;
		add(comboMinutosS, gbc_comboMinutosS);
		
		JLabel lblNewLabel_11 = new JLabel("Orientaci\u00F3n ");
		lblNewLabel_11.setForeground(new Color(30, 144, 255));
		lblNewLabel_11.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 11;
		add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		comboOrientacion = new JComboBox<>(IOFile.getOpciones("archivos//Orientacion"));
		comboOrientacion.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboOrientacion = new GridBagConstraints();
		gbc_comboOrientacion.insets = new Insets(0, 0, 5, 5);
		gbc_comboOrientacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboOrientacion.gridx = 2;
		gbc_comboOrientacion.gridy = 11;
		add(comboOrientacion, gbc_comboOrientacion);
		
		comboSegundosS = new JComboBox<>(IOFile.getOpciones("archivos//Segundos"));
		comboSegundosS.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboSegundosS = new GridBagConstraints();
		gbc_comboSegundosS.insets = new Insets(0, 0, 5, 0);
		gbc_comboSegundosS.fill = GridBagConstraints.BOTH;
		gbc_comboSegundosS.gridx = 4;
		gbc_comboSegundosS.gridy = 11;
		add(comboSegundosS, gbc_comboSegundosS);
		
		JLabel lblNewLabel_12 = new JLabel("Colonia");
		lblNewLabel_12.setForeground(new Color(30, 144, 255));
		lblNewLabel_12.setFont(new Font("Impact", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 12;
		add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		comboColonia = new JComboBox<>();
		comboColonia.addItem("Seleccione una opción");
		comboColonia.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboColonia = new GridBagConstraints();
		gbc_comboColonia.insets = new Insets(0, 0, 0, 5);
		gbc_comboColonia.fill = GridBagConstraints.BOTH;
		gbc_comboColonia.gridx = 2;
		gbc_comboColonia.gridy = 12;
		add(comboColonia, gbc_comboColonia);
		
		

	}
public boolean estanVaciasPeliculas() {
		
		return cajaCalle.getText().isEmpty()||cajaCurp.getText().isEmpty()||cajaMaterno.getText().isEmpty()||cajaNombre.getText().isEmpty()||
				cajaNumero.getText().isEmpty()||cajaPaterno.getText().isEmpty()||cajaSueldo.getText().isEmpty()||cajaTelefono.getText().isEmpty()||
				comboColonia.getSelectedItem().equals("Seleccione una opción");
	}
	public void vaciarCajasPeliculas() {
	
		
	}
}
