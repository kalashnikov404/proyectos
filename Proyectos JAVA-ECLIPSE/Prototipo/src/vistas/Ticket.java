package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.ServiceTicket;
import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Cliente;
import modelo.Venta;
import servicios.ServiceTicketImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.SwingConstants;

public class Ticket extends JFrame implements Printable{

	private JPanel contentPane;
	private Venta venta = new Venta();
	private Cliente cliente = new Cliente();
	private ServiceTicket serviceTicket;


	public Ticket(String fecha, String hora) {
		
		try {
			serviceTicket = new ServiceTicketImpl();


			venta = serviceTicket.getVenta(fecha, hora);
			cliente = serviceTicket.getCliente(fecha, hora);


			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 451, 698);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(Ticket.class.getResource("/imagenes/logo.png")));
			lblLogo.setBounds(6, 6, 250, 151);
			contentPane.add(lblLogo);

			JLabel lblDatosEmpresa = new JLabel("<html><body>"
					+ "TEnergy S.A. de C.V.<br>Leandro Valle Sur #224-A<br>"
					+ "Col. Melchor Ocampo<br>"
					+ "C.P. 61503<br>"
					+ "Zitácuaro, Mich.<br>"
					+ "Teléfono 7151208978<br>"
					+ "</body></html>");
			lblDatosEmpresa.setForeground(Color.DARK_GRAY);
			lblDatosEmpresa.setFont(new Font("Optima", Font.PLAIN, 15));
			lblDatosEmpresa.setBounds(268, 6, 178, 151);
			contentPane.add(lblDatosEmpresa);

			JLabel lblTituloRecibo = new JLabel("Recibo expedido a:");
			lblTituloRecibo.setForeground(Color.WHITE);
			lblTituloRecibo.setHorizontalAlignment(SwingConstants.LEFT);
			lblTituloRecibo.setBackground(new Color(58, 131, 29));
			lblTituloRecibo.setOpaque(true);
			lblTituloRecibo.setFont(new Font("Optima", Font.PLAIN, 20));
			lblTituloRecibo.setBounds(6, 193, 440, 25);
			contentPane.add(lblTituloRecibo);

			JLabel lblDatosCliente = new JLabel("<html><body>"
					+ "Nombre: "+cliente.getNombre()+"<br><br>"
					+ "Dirección: "+cliente.getDireccion()+"<br><br>"
					+ "Teléfono: "+cliente.getTelefono()+"<br><br>"
					+ "</body></html>");
			lblDatosCliente.setVerticalAlignment(SwingConstants.TOP);
			lblDatosCliente.setFont(new Font("Optima", Font.PLAIN, 13));
			lblDatosCliente.setBounds(6, 230, 440, 151);
			contentPane.add(lblDatosCliente);

			JLabel lblTituloCompra = new JLabel("Desglode de compra:");
			lblTituloCompra.setForeground(Color.WHITE);
			lblTituloCompra.setHorizontalAlignment(SwingConstants.LEFT);
			lblTituloCompra.setBackground(new Color(58, 131, 29));
			lblTituloCompra.setOpaque(true);
			lblTituloCompra.setFont(new Font("Optima", Font.PLAIN, 20));
			lblTituloCompra.setBounds(6, 401, 440, 25);
			contentPane.add(lblTituloCompra);


			JLabel lblDatosCompra = new JLabel("<html><body>"
					+ "Fecha y hora: "+Conversor.convertirDate(venta.getFecha())+" a la(s) "+venta.getHora()+"<br><br>"
					+ "Calentador:<br>"
					+"Tipo: "+venta.getCalentador().getTipo()+"<br>"
					+ "Numéro de cilindros: "+venta.getCalentador().getNumCilindros()+"<br>"
					+ "Dimensiones: "+venta.getCalentador().getDimensiones()+"<br>"
					+ "Marca: "+venta.getCalentador().getMarca()+"<br>"
					+ "Precio por unidad: "+venta.getCalentador().getPrecio()+"<br><br>"
					+ "</body></html>");
			lblDatosCompra.setVerticalAlignment(SwingConstants.TOP);
			lblDatosCompra.setFont(new Font("Optima", Font.PLAIN, 13));
			lblDatosCompra.setBounds(6, 436, 440, 151);
			contentPane.add(lblDatosCompra);

			JLabel lblUnidades = new JLabel("Unidades compradas: "+venta.getCantidad()+"");
			lblUnidades.setForeground(new Color(0, 100, 0));
			lblUnidades.setFont(new Font("Optima", Font.PLAIN, 15));
			lblUnidades.setBounds(6, 599, 268, 16);
			contentPane.add(lblUnidades);

			JLabel lblNewLabel = new JLabel("TOTAL A PAGAR:"+venta.getPrecioTotal());
			lblNewLabel.setForeground(new Color(0, 100, 0));
			lblNewLabel.setFont(new Font("Optima", Font.PLAIN, 20));
			lblNewLabel.setBounds(6, 639, 373, 16);
			contentPane.add(lblNewLabel);


			int res = JOptionPane.showConfirmDialog(null, "¿Desea imprimir el ticket?");

			if(res==0) {
				try{
					PrinterJob prt = PrinterJob.getPrinterJob();
					prt.setPrintable(this);
					prt.print();
				} 
				catch(PrinterException pex){
					JOptionPane.showMessageDialog(null,"Parece que hubo un error", "Error\n"+pex, JOptionPane.INFORMATION_MESSAGE);
				}     
			}

			if(res==1) {
				JOptionPane.showMessageDialog(null, "Se presentará el ticket para que le tome una foto");    
			}

		} catch (ConexionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int Index) throws PrinterException {
		if (Index>0){ 
			return NO_SUCH_PAGE;}

		Graphics2D pr = (Graphics2D) graphics;
		pr.scale(0.745, 0.745);
		pr.translate(pageFormat.getImageableX()+20,pageFormat.getImageableY()+20);
		contentPane.printAll(graphics);
		return PAGE_EXISTS;
	}

}
