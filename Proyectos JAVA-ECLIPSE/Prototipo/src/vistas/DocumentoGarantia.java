package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conversores.Conversor;
import excepciones.ConexionException;
import modelo.Calentador;
import modelo.Cliente;
import modelo.Garantia;
import servicios.ServiceTicketImpl;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.border.LineBorder;

import api.ServiceTicket;

import javax.swing.ImageIcon;

public class DocumentoGarantia extends JFrame implements Printable{

	private JPanel contentPane;

	private Cliente cliente;
	private Garantia garantia;

	private ServiceTicket serviceTicket;

	public DocumentoGarantia(String fecha, String hora) {

		try {
			serviceTicket = new ServiceTicketImpl();

			garantia = serviceTicket.getGarantia(fecha, hora);
			cliente = serviceTicket.getCliente(fecha, hora);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 698, 532);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblTituloCompra = new JLabel("Documento de Garantía");
			lblTituloCompra.setForeground(Color.WHITE);
			lblTituloCompra.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloCompra.setBackground(new Color(58, 131, 29));
			lblTituloCompra.setOpaque(true);
			lblTituloCompra.setFont(new Font("Optima", Font.PLAIN, 20));
			lblTituloCompra.setBounds(6, 6, 686, 25);
			contentPane.add(lblTituloCompra);

			JLabel lblVigencia = new JLabel("<html><body>"
					+ "El presente documento tiene una vigencia del día "+Conversor.convertirDate(garantia.getFechaInicio())+""
					+ "hasta el día "+Conversor.convertirDate(garantia.getFechaFin())+"<br>"
					+ "</body></html>");
			lblVigencia.setForeground(new Color(0, 100, 0));
			lblVigencia.setFont(new Font("Optima", Font.PLAIN, 13));
			lblVigencia.setBounds(6, 30, 676, 37);
			contentPane.add(lblVigencia);

			JLabel lblCalentador = new JLabel("<html><body>"
					+ "Se expide por el calentador con las siguientes características:<br>"
					+ ""+"Tipo: "+garantia.getCalentador().getTipo()+"<br>"
					+ "Numéro de cilindros: "+garantia.getCalentador().getNumCilindros()+"<br>"
					+ "Dimensiones: "+garantia.getCalentador().getDimensiones()+"<br>"
					+ "Marca: "+garantia.getCalentador().getMarca()+"<br>"
					+ "Precio por unidad: "+garantia.getCalentador().getPrecio()+"<br><br>"
					+ "</body></html>");
			lblCalentador.setFont(new Font("Optima", Font.PLAIN, 13));
			lblCalentador.setBounds(6, 79, 686, 107);
			contentPane.add(lblCalentador);

			JLabel lblNewLabel = new JLabel("<html><body>"
					+ "Al cliente:<br>"
					+cliente.getNombre()+"<br><br>"
					+ "Con la dirección: "+cliente.getDireccion()+"<br>"
					+ "y el teléfono: "+cliente.getTelefono()+"<br>"
					+ "</body></html>");
			lblNewLabel.setFont(new Font("Optima", Font.PLAIN, 13));
			lblNewLabel.setBounds(6, 214, 686, 107);
			contentPane.add(lblNewLabel);

			JLabel lblValidoEnLa = new JLabel("<html><body>"
					+ "Valido en la SUCURSAL: <br><br>"
					+ "TEnergy S.A. de C.V.<br>Leandro Valle Sur #224-A<br>"
					+ "Col. Melchor Ocampo<br>"
					+ "C.P. 61503<br>"
					+ "Zitácuaro, Mich.<br>"
					+ "Teléfono 7151208978<br>"
					+ "</body></html>");
			lblValidoEnLa.setVerticalAlignment(SwingConstants.TOP);
			lblValidoEnLa.setOpaque(true);
			lblValidoEnLa.setHorizontalAlignment(SwingConstants.RIGHT);
			lblValidoEnLa.setForeground(Color.WHITE);
			lblValidoEnLa.setFont(new Font("Optima", Font.PLAIN, 13));
			lblValidoEnLa.setBackground(new Color(58, 131, 29));
			lblValidoEnLa.setBounds(256, 350, 436, 154);
			contentPane.add(lblValidoEnLa);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBorder(new LineBorder(new Color(0, 100, 0)));
			lblNewLabel_1.setIcon(new ImageIcon(DocumentoGarantia.class.getResource("/imagenes/logo.png")));
			lblNewLabel_1.setBounds(6, 350, 278, 154);
			contentPane.add(lblNewLabel_1);
			
			int res = JOptionPane.showConfirmDialog(null, "¿Desea imprimir la garantía?");

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
				JOptionPane.showMessageDialog(null, "Se presentará la garantía para que le tome una foto");    
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
