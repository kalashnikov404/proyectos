package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import api.ServiceCalentador;
import api.ServiceCliente;
import api.ServiceEmpleado;
import api.ServiceGarantia;
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
import servicios.ServiceGarantiaImpl;
import servicios.ServiceVentaImpl;

public class ModificarVenta extends JPanel {

	private JTextField tfPrecioTotal;
	private JTextField tfCantidad;

	private Venta newVenta;
	private Venta oldVenta;
	
	private int antiguacant = 0;

	private ServiceCliente serviceCliente;
	private ServiceCalentador serviceCalentador;
	private ServiceEmpleado serviceEmpleado;
	private ServiceVenta serviceVenta;
	private ServiceGarantia serviceGarantia;
	private Double precio=0.0;

	public ModificarVenta(String usuario) {

		if(usuario.equals("due�o") || usuario.equals("empleado")) {

			try {
				serviceCliente = new ServiceClienteImpl();
				serviceCalentador = new ServiceCalentadorImpl();
				serviceEmpleado = new ServiceEmpleadoImpl();
				serviceVenta = new ServiceVentaImpl();
				serviceGarantia = new ServiceGarantiaImpl();


				setBackground(new Color(157, 198, 69));
				setBounds(100, 100, 1366, 768);
				setLayout(null);

				JLabel lblTitulo = new JLabel("Modificar Venta");
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setBackground(new Color(58, 131, 29));
				lblTitulo.setOpaque(true);
				lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
				lblTitulo.setBounds(6, 6, 1428, 31);
				add(lblTitulo);

				JLabel lblFcIni = new JLabel("Fecha de inicio de la garantía:");
				lblFcIni.setBounds(344, 544, 187, 16);
				add(lblFcIni);

				JLabel lblNewLabel = new JLabel("Fecha de fin de la agarantía:");
				lblNewLabel.setBounds(342, 609, 189, 16);
				add(lblNewLabel);

				JDateChooser dcFcIni = new JDateChooser();
				dcFcIni.setBounds(620, 534, 130, 26);
				add(dcFcIni);

				JDateChooser dcFcFin = new JDateChooser();
				dcFcFin.setBounds(620, 599, 130, 26);
				add(dcFcFin);

				JLabel lblVenta = new JLabel("Venta:");
				lblVenta.setBounds(18, 149, 61, 16);
				add(lblVenta);

				JLabel lblPrecio = new JLabel("Precio total:");
				lblPrecio.setBounds(470, 238, 83, 16);
				add(lblPrecio);

				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(470, 293, 61, 16);
				add(lblCantidad);

				JLabel lblCalentador = new JLabel("Calentador:");
				lblCalentador.setBounds(470, 352, 83, 16);
				add(lblCalentador);

				tfPrecioTotal = new JTextField();
				tfPrecioTotal.setBounds(620, 233, 130, 26);
				add(tfPrecioTotal);
				tfPrecioTotal.setColumns(10);

				tfCantidad = new JTextField();
				tfCantidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						tfPrecioTotal.setText(String.valueOf(Integer.parseInt(tfCantidad.getText())*precio));

					}
				});
				tfCantidad.setBounds(620, 288, 130, 26);
				add(tfCantidad);
				tfCantidad.setColumns(10);

				JLabel lblCliente = new JLabel("Cliente:");
				lblCliente.setBounds(470, 415, 61, 16);
				add(lblCliente);

				JLabel lblEmpleado = new JLabel("Empleado:");
				lblEmpleado.setBounds(470, 468, 83, 16);
				add(lblEmpleado);

				List<String> cal = new ArrayList<>();
				cal=serviceCalentador.getListaCalentador();

				String[] calentadores = Conversor.getArrayDeList(cal);

				JComboBox cbCalentador = new JComboBox(calentadores);
				cbCalentador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo= cbCalentador.getSelectedItem().toString();
						String [] partes=todo.split(", ");
						precio= Double.parseDouble(partes[4]);

						tfPrecioTotal.setText(String.valueOf(Integer.parseInt(tfCantidad.getText())*precio));

					}
				});
				cbCalentador.setBounds(620, 348, 796, 27);
				add(cbCalentador);

				List<String> cli = new ArrayList<>();
				cli=serviceCliente.getListaClientes();

				String[] clientes = Conversor.getArrayDeList(cli);

				JComboBox cbCliente = new JComboBox(clientes);
				cbCliente.setBounds(620, 411, 796, 27);
				add(cbCliente);

				List<String> emp =new ArrayList();
				emp=serviceEmpleado.getListaEmpleado();
				String[] empleado= Conversor.getArrayDeList(emp);

				JComboBox cbEmpleado = new JComboBox(empleado);
				cbEmpleado.setBounds(620, 464, 796, 27);
				add(cbEmpleado);

				List<String> ven =new ArrayList();
				ven=serviceVenta.getListaVentas();
				String[] ventas= Conversor.getArrayDeList(ven);

				JComboBox cbVenta = new JComboBox(ventas);
				cbVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String todo = cbVenta.getSelectedItem().toString();

						String[] partes = todo.split(", ");

						tfPrecioTotal.setText(partes[2]);
						tfCantidad.setText(partes[3]);
						
						antiguacant = Integer.parseInt(partes[3]);

						Venta venta = new Venta();

						venta.setFecha(Conversor.convertirADate(partes[0]));
						venta.setHora(Time.valueOf(partes[1]));

						String calentadorS = serviceVenta.getCalentadorDeVenta(venta);
						String clienteS = serviceVenta.getClienteDeVenta();
						String empleadoS = serviceVenta.getEmpleadoDeVenta();


						cbCalentador.setSelectedItem(calentadorS);
						cbCliente.setSelectedItem(clienteS);
						cbEmpleado.setSelectedItem(empleadoS);

						String todoC= cbCalentador.getSelectedItem().toString();
						String [] partesC=todoC.split(", ");
						precio= Double.parseDouble(partesC[4]);

						String todoG = serviceVenta.getGarantiaFechas(venta);

						String[] partesG = todoG.split(", ");

						dcFcIni.setDate(Conversor.convertirADate(partesG[0]));
						dcFcFin.setDate(Conversor.convertirADate(partesG[1])); 

						oldVenta = new Venta();
						oldVenta = venta;

					}
				});
				cbVenta.setBounds(91, 145, 1306, 27);
				add(cbVenta);

				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						newVenta = new Venta();

						newVenta.setPrecioTotal(Double.parseDouble(tfPrecioTotal.getText()));
						newVenta.setCantidad(Integer.parseInt(tfCantidad.getText()));

						String todoCal= cbCalentador.getSelectedItem().toString();
						String [] partesCal=todoCal.split(", ");

						Calentador calentador =new Calentador(partesCal[0],Integer.parseInt(partesCal[1]), 
								partesCal[2],partesCal[3], Double.parseDouble(partesCal[4]));
						newVenta.setCalentador(calentador);

						String todoCli = cbCliente.getSelectedItem().toString();
						String[] partesCli = todoCli.split(", ");

						Cliente cliente = new Cliente(partesCli[0], partesCli[1] , partesCli[2], partesCli[3] );
						newVenta.setCliente(cliente);

						String todoEmpleado = cbEmpleado.getSelectedItem().toString();
						String[] partesEmpleado = todoEmpleado.split(", ");
						Persona persona=new Persona(partesEmpleado[0], partesEmpleado[1],partesEmpleado[2]);
						Empleado empleado=new Empleado(partesEmpleado[3], partesEmpleado[4],partesEmpleado[5]);
						newVenta.setEmpleado(empleado);


						Garantia garantia = new Garantia();
						garantia.setFechaInicio(dcFcIni.getDate());
						garantia.setFechaFin(dcFcFin.getDate());
						String salida2 = serviceGarantia.modificarGarantia(oldVenta, newVenta, garantia);

						String salida = serviceVenta.modificarVenta(oldVenta, newVenta);
						
						System.out.println(salida+" "+ salida2);
						
						serviceVenta.modificarCantidad(oldVenta, newVenta, antiguacant);

						if(salida.equals("Venta modificada") && salida2.equals("Garantia modificada")) {
							tfPrecioTotal.setText(null);
							tfCantidad.setText(null);
							JOptionPane.showMessageDialog(null, salida);

							Ticket ticket = new Ticket(Conversor.convertirDate(oldVenta.getFecha()), String.valueOf(oldVenta.getHora()));
							ticket.setVisible(true);

							DocumentoGarantia garantiaV = new DocumentoGarantia(Conversor.convertirDate(oldVenta.getFecha()), String.valueOf(oldVenta.getHora()));
							garantiaV.setVisible(true);

						}else { 
							JOptionPane.showMessageDialog(null, "Algo salió mal. Revisa los datos ingresados");
						}

					}
				});
				btnModificar.setBounds(1212, 609, 185, 71);
				add(btnModificar);

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

			} catch (ConexionException e1) {
				e1.printStackTrace();
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
