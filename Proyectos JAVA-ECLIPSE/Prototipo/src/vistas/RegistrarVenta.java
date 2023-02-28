package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import api.ServiceCalentador;
import api.ServiceCliente;
import api.ServiceEmpleado;
import api.ServiceVenta;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Garantia;
import modelo.Persona;
import modelo.Venta;
import servicios.ServiceCalentadorImpl;
import servicios.ServiceClienteImpl;
import servicios.ServiceEmpleadoImpl;
import servicios.ServiceVentaImpl;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class RegistrarVenta extends JPanel {
	private JTextField tfCantidad;
	private JTextField tfPrecioTotal;
	private ServiceCalentador serviceCalentador;
	private ServiceCliente serviceCliente;
	private ServiceEmpleado serviceEmpleado;
	private ServiceVenta serviceVenta;
	private Double precio=0.0;

	public RegistrarVenta(String usuario) {

		if(usuario.equals("dueño") || usuario.equals("empleado")) {

			try {
				serviceCalentador = new ServiceCalentadorImpl();

				serviceCliente = new ServiceClienteImpl();

				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceVenta = new ServiceVentaImpl();

				setLayout(null);
				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1440, 900);

				JLabel lblTitulo = new JLabel("Registrar Venta");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblCalentador = new JLabel("Calentador: ");
				lblCalentador.setBounds(18, 114, 97, 16);
				add(lblCalentador);

				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(18, 173, 85, 16);
				add(lblCantidad);

				JLabel lblPrecioTotal = new JLabel("Precio total:");
				lblPrecioTotal.setBounds(18, 251, 97, 16);
				add(lblPrecioTotal);

				JLabel lblCliente = new JLabel("Cliente:");
				lblCliente.setBounds(18, 326, 97, 16);
				add(lblCliente);



				JLabel lblEmpleado = new JLabel("Empleado:");
				lblEmpleado.setBounds(18, 393, 97, 16);
				add(lblEmpleado);

				List<String> cal = new ArrayList<>();
				cal=serviceCalentador.getListaCalentador();

				String[] calentadores = Conversor.getArrayDeList(cal);

				JComboBox cbCalentador = new JComboBox(calentadores);
				cbCalentador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String todo= cbCalentador.getSelectedItem().toString();
						String [] partes=todo.split(", ");
						precio= Double.parseDouble(partes[4]);
					}

				});

				cbCalentador.setBounds(263, 110, 647, 27);
				add(cbCalentador);

				List<String> cli = new ArrayList<>();
				cli=serviceCliente.getListaClientes();

				String[] clientes = Conversor.getArrayDeList(cli);

				JComboBox cbClientes = new JComboBox(clientes);
				cbClientes.setBounds(263, 322, 765, 27);
				add(cbClientes);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(263, 389, 765, 27);
				add(cbEmpleado);

				tfCantidad = new JTextField();
				tfCantidad.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						tfPrecioTotal.setText(String.valueOf(Integer.parseInt(tfCantidad.getText())*precio));
					}
				});
				tfCantidad.setBounds(263, 168, 130, 26);
				add(tfCantidad);
				tfCantidad.setColumns(10);

				tfPrecioTotal = new JTextField();
				tfPrecioTotal.setBounds(263, 246, 130, 26);
				add(tfPrecioTotal);
				tfPrecioTotal.setColumns(10);

				JLabel lblDetallesVenta = new JLabel("Detalles Garantia");
				lblDetallesVenta.setBounds(1115, 114, 146, 16);
				add(lblDetallesVenta);

				JLabel lblFechaInicio = new JLabel("Fecha inicio:");
				lblFechaInicio.setBounds(1048, 173, 91, 16);
				add(lblFechaInicio);

				JLabel lblFechaFin = new JLabel("Fecha fin:");
				lblFechaFin.setBounds(1048, 251, 91, 16);
				add(lblFechaFin);

				JDateChooser dcFechaFin = new JDateChooser();
				dcFechaFin.setBounds(1196, 241, 130, 26);
				add(dcFechaFin);

				JDateChooser dcFechaInicio = new JDateChooser();
				dcFechaInicio.setBounds(1196, 163, 130, 26);
				add(dcFechaInicio);

				JButton btnRegistrar = new JButton("Vender");
				btnRegistrar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {

						Calentador calentador;

						String todoCalentador= cbCalentador.getSelectedItem().toString();
						String [] partesCalentador=todoCalentador.split(", ");
						calentador =new Calentador(partesCalentador[0],Integer.parseInt(partesCalentador[1]), partesCalentador[2],partesCalentador[3], Double.parseDouble(partesCalentador[4]));	

						int cantidadExistente = serviceVenta.getTotalCant(calentador);

						if(cantidadExistente>Integer.parseInt(tfCantidad.getText())) {



							Venta venta = new Venta();

							String ahora = Conversor.convertirTiempoSistema();

							String[] partes = ahora.split(" ");

							venta.setHora(Time.valueOf(partes[1]));
							venta.setFecha(Date.valueOf(partes[0]));

							venta.setCantidad(Integer.parseInt(tfCantidad.getText()));
							venta.setPrecioTotal(Double.parseDouble(tfPrecioTotal.getText()));


							Cliente cliente;
							Empleado empleado;
							Garantia garantia = new Garantia();
							Persona persona;


							String todoEmpleado = cbEmpleado.getSelectedItem().toString();
							String[] partesEmpleado = todoEmpleado.split(", ");
							persona=new Persona(partesEmpleado[0], partesEmpleado[1],partesEmpleado[2]);
							empleado=new Empleado(partesEmpleado[3], partesEmpleado[4],partesEmpleado[5]);

							String todoCliente = cbClientes.getSelectedItem().toString();
							String[] partesCliente = todoCliente.split(", ");
							cliente = new Cliente(partesCliente[0], partesCliente[1] , partesCliente[2], partesCliente[3] );

							venta.setCalentador(calentador);
							venta.setCliente(cliente);
							venta.setEmpleado(empleado);

							garantia.setFechaInicio(dcFechaInicio.getDate());
							garantia.setFechaFin(dcFechaFin.getDate());
							garantia.setCalentador(calentador);
							garantia.setCliente(cliente);

							String salida = serviceVenta.registrarVentaGarantia(garantia);
							String salida2 =serviceVenta.registrarVenta(venta);
							
							serviceVenta.actualizarCantidad(garantia, venta, cantidadExistente-Integer.parseInt(tfCantidad.getText()));

							if(salida.equals("Garantia registrada") && salida2.equals("Venta registrada")) {
								tfCantidad.setText(null);
								tfPrecioTotal.setText(null);
								JOptionPane.showMessageDialog(null, salida2);

								Ticket ticket = new Ticket(partes[0], partes[1]);
								ticket.setVisible(true);

								DocumentoGarantia garantiaV = new DocumentoGarantia(partes[0], partes[1]);
								garantiaV.setVisible(true);


							}else {
								JOptionPane.showMessageDialog(null, "Algo salio mal. Revisa los datos ingresados");
							}

						}else {
							JOptionPane.showMessageDialog(null, "No hay suficientes calentadores de ese tipo en el inventario\nLa cantidad de existencias que tenemos es: "+cantidadExistente+"");
						}
					}
				});
				btnRegistrar.setBounds(1212, 609, 185, 71);
				add(btnRegistrar);

				JButton btnSalir = new JButton("");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Principal frame = new Principal(usuario);
						frame.setVisible(true);

						setVisible(false);
						removeAll();
						repaint();


					}
				});
				btnSalir.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagenes/salir.png")));
				btnSalir.setBounds(45, 599, 85, 81);
				add(btnSalir);

			} catch (ConexionException e) {
				e.printStackTrace();
			}

		}else {
			JOptionPane.showMessageDialog(null, "No puedes ingresar a esta ventana");

			Principal frame = new Principal(usuario);
			frame.setVisible(true);

			setVisible(false);
			removeAll();
			repaint();

		}

	}
}
