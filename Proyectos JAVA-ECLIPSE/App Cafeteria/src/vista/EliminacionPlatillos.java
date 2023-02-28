package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import modelo.Cafecito;
import servicios.ServiceCafecitoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminacionPlatillos extends JPanel {
	private JTextField tfId;

	private int modificacion;
	private Cafecito cafecitoPrub;
	
	public EliminacionPlatillos() {
		setLayout(null);

		
		JLabel lblInstrucciones = new JLabel("Ingresa la clave del platillo a eliminar");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 1000, 27);
		add(lblInstrucciones);

		tfId = new JTextField();
		tfId.setBounds(33, 81, 130, 26);
		add(tfId);
		tfId.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar platillo");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resOp=1;

				while(resOp==1 || resOp==2) {

					ServiceCafecitoImpl serviceClienteImpl = new ServiceCafecitoImpl();
					cafecitoPrub = new Cafecito();

					cafecitoPrub=serviceClienteImpl.consultarPorCve(Integer.parseInt(tfId.getText().toString()));

					resOp=JOptionPane.showConfirmDialog(null, "¿Este es el cafecito que deseas eliminar?\n"
							+ "cve: "+cafecitoPrub.getCveCF()+", calle: "+cafecitoPrub.getCalle()+", numero: "+cafecitoPrub.getNumero()
							+", orientacion: "+cafecitoPrub.getOrientacion());
				}

				if(resOp==0) {
					ServiceCafecitoImpl serviceClienteImpl = new ServiceCafecitoImpl();
					JOptionPane.showMessageDialog(null, (serviceClienteImpl.eliminarCafecito(Integer.parseInt(tfId.getText()))));	
				}
				
			}
		});
		btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnEliminar.setBounds(50, 200, 163, 47);
		add(btnEliminar);


		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);		
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

		fondo.setIcon(img22);

		

	}

}