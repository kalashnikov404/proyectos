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
		
		comboPuesto = new JComboBox<>();
		comboPuesto.addItem("Seleccione una opción");
		comboPuesto.addItem("Taquilla");
		comboPuesto.addItem("Vendedor");
		comboPuesto.addItem("Limpieza ");
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
		
		comboDiaDescanso = new JComboBox<>();
		comboDiaDescanso.addItem("Seleccione una opción");
		comboDiaDescanso.addItem("Lunes");
		comboDiaDescanso.addItem("Martes");
		comboDiaDescanso.addItem("Miercoles");
		comboDiaDescanso.addItem("Jueves");
		comboDiaDescanso.addItem("Viernes");
		comboDiaDescanso.addItem("Sábado");
		comboDiaDescanso.addItem("Domingo");
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
		
		comboHorasE = new JComboBox<>();
		comboHorasE.addItem("Horas");
		comboHorasE.addItem("00");
		comboHorasE.addItem("01");
		comboHorasE.addItem("02");
		comboHorasE.addItem("03");
		comboHorasE.addItem("04");
		comboHorasE.addItem("05");
		comboHorasE.addItem("06");
		comboHorasE.addItem("07");
		comboHorasE.addItem("08");
		comboHorasE.addItem("09");
		comboHorasE.addItem("10");
		comboHorasE.addItem("11");
		comboHorasE.addItem("12");
		comboHorasE.addItem("13");
		comboHorasE.addItem("14");
		comboHorasE.addItem("15");
		comboHorasE.addItem("16");
		comboHorasE.addItem("17");
		comboHorasE.addItem("18");
		comboHorasE.addItem("19");
		comboHorasE.addItem("20");
		comboHorasE.addItem("21");
		comboHorasE.addItem("22");
		comboHorasE.addItem("23");
		
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
		
		comboMinutosE = new JComboBox<>();
		comboMinutosE.addItem("Minutos");
		comboMinutosE.addItem("00");
		comboMinutosE.addItem("01");
		comboMinutosE.addItem("02");
		comboMinutosE.addItem("03");
		comboMinutosE.addItem("04");
		comboMinutosE.addItem("05");
		comboMinutosE.addItem("06");
		comboMinutosE.addItem("07");
		comboMinutosE.addItem("08");
		comboMinutosE.addItem("09");
		comboMinutosE.addItem("10");
		comboMinutosE.addItem("11");
		comboMinutosE.addItem("12");
		comboMinutosE.addItem("13");
		comboMinutosE.addItem("14");
		comboMinutosE.addItem("15");
		comboMinutosE.addItem("16");
		comboMinutosE.addItem("17");
		comboMinutosE.addItem("18");
		comboMinutosE.addItem("19");
		comboMinutosE.addItem("20");
		comboMinutosE.addItem("21");
		comboMinutosE.addItem("22");
		comboMinutosE.addItem("23");
		comboMinutosE.addItem("24");
		comboMinutosE.addItem("25");
		comboMinutosE.addItem("26");
		comboMinutosE.addItem("27");
		comboMinutosE.addItem("28");
		comboMinutosE.addItem("29");
		comboMinutosE.addItem("30");
		comboMinutosE.addItem("31");
		comboMinutosE.addItem("32");
		comboMinutosE.addItem("33");
		comboMinutosE.addItem("34");
		comboMinutosE.addItem("35");
		comboMinutosE.addItem("36");
		comboMinutosE.addItem("37");
		comboMinutosE.addItem("38");
		comboMinutosE.addItem("39");
		comboMinutosE.addItem("40");
		comboMinutosE.addItem("41");
		comboMinutosE.addItem("42");
		comboMinutosE.addItem("43");
		comboMinutosE.addItem("44");
		comboMinutosE.addItem("45");
		comboMinutosE.addItem("46");
		comboMinutosE.addItem("47");
		comboMinutosE.addItem("48");
		comboMinutosE.addItem("49");
		comboMinutosE.addItem("50");
		comboMinutosE.addItem("51");
		comboMinutosE.addItem("52");
		comboMinutosE.addItem("53");
		comboMinutosE.addItem("54");
		comboMinutosE.addItem("55");
		comboMinutosE.addItem("56");
		comboMinutosE.addItem("57");
		comboMinutosE.addItem("58");
		comboMinutosE.addItem("59");
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
		
		comboSegundosE = new JComboBox<>();
		comboSegundosE.addItem("Segundos");
		comboSegundosE.addItem("00");
		comboSegundosE.addItem("01");
		comboSegundosE.addItem("02");
		comboSegundosE.addItem("03");
		comboSegundosE.addItem("04");
		comboSegundosE.addItem("05");
		comboSegundosE.addItem("06");
		comboSegundosE.addItem("07");
		comboSegundosE.addItem("08");
		comboSegundosE.addItem("09");
		comboSegundosE.addItem("10");
		comboSegundosE.addItem("11");
		comboSegundosE.addItem("12");
		comboSegundosE.addItem("13");
		comboSegundosE.addItem("14");
		comboSegundosE.addItem("15");
		comboSegundosE.addItem("16");
		comboSegundosE.addItem("17");
		comboSegundosE.addItem("18");
		comboSegundosE.addItem("19");
		comboSegundosE.addItem("20");
		comboSegundosE.addItem("21");
		comboSegundosE.addItem("22");
		comboSegundosE.addItem("23");
		comboSegundosE.addItem("24");
		comboSegundosE.addItem("25");
		comboSegundosE.addItem("26");
		comboSegundosE.addItem("27");
		comboSegundosE.addItem("28");
		comboSegundosE.addItem("29");
		comboSegundosE.addItem("30");
		comboSegundosE.addItem("31");
		comboSegundosE.addItem("32");
		comboSegundosE.addItem("33");
		comboSegundosE.addItem("34");
		comboSegundosE.addItem("35");
		comboSegundosE.addItem("36");
		comboSegundosE.addItem("37");
		comboSegundosE.addItem("38");
		comboSegundosE.addItem("39");
		comboSegundosE.addItem("40");
		comboSegundosE.addItem("41");
		comboSegundosE.addItem("42");
		comboSegundosE.addItem("43");
		comboSegundosE.addItem("44");
		comboSegundosE.addItem("45");
		comboSegundosE.addItem("46");
		comboSegundosE.addItem("47");
		comboSegundosE.addItem("48");
		comboSegundosE.addItem("49");
		comboSegundosE.addItem("50");
		comboSegundosE.addItem("51");
		comboSegundosE.addItem("52");
		comboSegundosE.addItem("53");
		comboSegundosE.addItem("54");
		comboSegundosE.addItem("55");
		comboSegundosE.addItem("56");
		comboSegundosE.addItem("57");
		comboSegundosE.addItem("58");
		comboSegundosE.addItem("59");
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
		
		comboHorasS = new JComboBox<>();
		comboHorasS.addItem("Horas");
		comboHorasS.addItem("00");
		comboHorasS.addItem("01");
		comboHorasS.addItem("02");
		comboHorasS.addItem("03");
		comboHorasS.addItem("04");
		comboHorasS.addItem("05");
		comboHorasS.addItem("06");
		comboHorasS.addItem("07");
		comboHorasS.addItem("08");
		comboHorasS.addItem("09");
		comboHorasS.addItem("10");
		comboHorasS.addItem("11");
		comboHorasS.addItem("12");
		comboHorasS.addItem("13");
		comboHorasS.addItem("14");
		comboHorasS.addItem("15");
		comboHorasS.addItem("16");
		comboHorasS.addItem("17");
		comboHorasS.addItem("18");
		comboHorasS.addItem("19");
		comboHorasS.addItem("20");
		comboHorasS.addItem("21");
		comboHorasS.addItem("22");
		comboHorasS.addItem("23");
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
		
		comboMinutosS = new JComboBox<>();
		comboMinutosS.addItem("Minutos");
		comboMinutosS.addItem("00");
		comboMinutosS.addItem("01");
		comboMinutosS.addItem("02");
		comboMinutosS.addItem("03");
		comboMinutosS.addItem("04");
		comboMinutosS.addItem("05");
		comboMinutosS.addItem("06");
		comboMinutosS.addItem("07");
		comboMinutosS.addItem("08");
		comboMinutosS.addItem("09");
		comboMinutosS.addItem("10");
		comboMinutosS.addItem("11");
		comboMinutosS.addItem("12");
		comboMinutosS.addItem("13");
		comboMinutosS.addItem("14");
		comboMinutosS.addItem("15");
		comboMinutosS.addItem("16");
		comboMinutosS.addItem("17");
		comboMinutosS.addItem("18");
		comboMinutosS.addItem("19");
		comboMinutosS.addItem("20");
		comboMinutosS.addItem("21");
		comboMinutosS.addItem("22");
		comboMinutosS.addItem("23");
		comboMinutosS.addItem("24");
		comboMinutosS.addItem("25");
		comboMinutosS.addItem("26");
		comboMinutosS.addItem("27");
		comboMinutosS.addItem("28");
		comboMinutosS.addItem("29");
		comboMinutosS.addItem("30");
		comboMinutosS.addItem("31");
		comboMinutosS.addItem("32");
		comboMinutosS.addItem("33");
		comboMinutosS.addItem("34");
		comboMinutosS.addItem("35");
		comboMinutosS.addItem("36");
		comboMinutosS.addItem("37");
		comboMinutosS.addItem("38");
		comboMinutosS.addItem("39");
		comboMinutosS.addItem("40");
		comboMinutosS.addItem("41");
		comboMinutosS.addItem("42");
		comboMinutosS.addItem("43");
		comboMinutosS.addItem("44");
		comboMinutosS.addItem("45");
		comboMinutosS.addItem("46");
		comboMinutosS.addItem("47");
		comboMinutosS.addItem("48");
		comboMinutosS.addItem("49");
		comboMinutosS.addItem("50");
		comboMinutosS.addItem("51");
		comboMinutosS.addItem("52");
		comboMinutosS.addItem("53");
		comboMinutosS.addItem("54");
		comboMinutosS.addItem("55");
		comboMinutosS.addItem("56");
		comboMinutosS.addItem("57");
		comboMinutosS.addItem("58");
		comboMinutosS.addItem("59");
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
		
		comboOrientacion = new JComboBox<>();
		comboOrientacion.addItem("Seleccione una opción");
		comboOrientacion.addItem("Norte");
		comboOrientacion.addItem("Oeste");
		comboOrientacion.addItem("Este");
		comboOrientacion.addItem("Sur");
		comboOrientacion.addItem("Noreste");
		comboOrientacion.addItem("Noroeste");
		comboOrientacion.addItem("Sureste");
		comboOrientacion.addItem("Suroeste");
		comboOrientacion.addItem("Centro");
		comboOrientacion.setFont(new Font("Impact", Font.PLAIN, 25));
		GridBagConstraints gbc_comboOrientacion = new GridBagConstraints();
		gbc_comboOrientacion.insets = new Insets(0, 0, 5, 5);
		gbc_comboOrientacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboOrientacion.gridx = 2;
		gbc_comboOrientacion.gridy = 11;
		add(comboOrientacion, gbc_comboOrientacion);
		
		comboSegundosS = new JComboBox<>();
		comboSegundosS.addItem("Segundos");
		comboSegundosS.addItem("00");
		comboSegundosS.addItem("01");
		comboSegundosS.addItem("02");
		comboSegundosS.addItem("03");
		comboSegundosS.addItem("04");
		comboSegundosS.addItem("05");
		comboSegundosS.addItem("06");
		comboSegundosS.addItem("07");
		comboSegundosS.addItem("08");
		comboSegundosS.addItem("09");
		comboSegundosS.addItem("10");
		comboSegundosS.addItem("11");
		comboSegundosS.addItem("12");
		comboSegundosS.addItem("13");
		comboSegundosS.addItem("14");
		comboSegundosS.addItem("15");
		comboSegundosS.addItem("16");
		comboSegundosS.addItem("17");
		comboSegundosS.addItem("18");
		comboSegundosS.addItem("19");
		comboSegundosS.addItem("20");
		comboSegundosS.addItem("21");
		comboSegundosS.addItem("22");
		comboSegundosS.addItem("23");
		comboSegundosS.addItem("24");
		comboSegundosS.addItem("25");
		comboSegundosS.addItem("26");
		comboSegundosS.addItem("27");
		comboSegundosS.addItem("28");
		comboSegundosS.addItem("29");
		comboSegundosS.addItem("30");
		comboSegundosS.addItem("31");
		comboSegundosS.addItem("32");
		comboSegundosS.addItem("33");
		comboSegundosS.addItem("34");
		comboSegundosS.addItem("35");
		comboSegundosS.addItem("36");
		comboSegundosS.addItem("37");
		comboSegundosS.addItem("38");
		comboSegundosS.addItem("39");
		comboSegundosS.addItem("40");
		comboSegundosS.addItem("41");
		comboSegundosS.addItem("42");
		comboSegundosS.addItem("43");
		comboSegundosS.addItem("44");
		comboSegundosS.addItem("45");
		comboSegundosS.addItem("46");
		comboSegundosS.addItem("47");
		comboSegundosS.addItem("48");
		comboSegundosS.addItem("49");
		comboSegundosS.addItem("50");
		comboSegundosS.addItem("51");
		comboSegundosS.addItem("52");
		comboSegundosS.addItem("53");
		comboSegundosS.addItem("54");
		comboSegundosS.addItem("55");
		comboSegundosS.addItem("56");
		comboSegundosS.addItem("57");
		comboSegundosS.addItem("58");
		comboSegundosS.addItem("59");
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
