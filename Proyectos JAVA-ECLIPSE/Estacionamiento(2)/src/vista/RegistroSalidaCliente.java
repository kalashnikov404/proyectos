package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.JTextField;

import dao.TablaEstacionamiento;
import servicios.ServiceEstacionamientoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroSalidaCliente extends JPanel {
	private JTextField tfPlacas;
	
	public RegistroSalidaCliente() {
		
		setLayout(null);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));
		
		JLabel lblInstrucciones = new JLabel("Ingresa las placas del vehiculo que sale");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 609, 20);
		add(lblInstrucciones);
		
		JLabel lblPlacas = new JLabel("Placas:");
		lblPlacas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPlacas.setBounds(33, 107, 61, 16);
		add(lblPlacas);
		
		tfPlacas = new JTextField();
		tfPlacas.setBounds(102, 107, 130, 26);
		add(tfPlacas);
		tfPlacas.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de Salida:");
		lblFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFecha.setBounds(33, 274, 130, 20);
		add(lblFecha);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		JLabel lblFechaMostrar = new JLabel(localDateTime.toString());
		lblFechaMostrar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFechaMostrar.setBounds(33, 299, 444, 20);
		add(lblFechaMostrar);
		
		JButton btnRegistrarSalida = new JButton("Registrar Salida");
		btnRegistrarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServiceEstacionamientoImpl serviceEstacionamientoImpl = new ServiceEstacionamientoImpl();
				serviceEstacionamientoImpl.registrarSalida(tfPlacas.getText(), localDateTime);
			}
		});
		btnRegistrarSalida.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnRegistrarSalida.setBounds(50, 460, 280, 46);
		add(btnRegistrarSalida);

	}
}
