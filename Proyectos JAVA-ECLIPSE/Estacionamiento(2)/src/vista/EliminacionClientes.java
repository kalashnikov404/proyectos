package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;

import modelo.Cliente;
import servicios.ServiceClienteImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminacionClientes extends JPanel {
	private JTextField tfId;

	private int modificacion;
	private Cliente clientePrub;
	
	public EliminacionClientes() {
		setLayout(null);

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 794);
		add(fondo);
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/garage.png")));

		JLabel lblInstrucciones = new JLabel("Ingresa el id del cliente que deseas eliminar");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 1000, 27);
		add(lblInstrucciones);

		tfId = new JTextField();
		tfId.setBounds(33, 81, 130, 26);
		add(tfId);
		tfId.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resOp=1;

				while(resOp==1 || resOp==2) {

					ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();
					clientePrub = new Cliente();

					clientePrub=serviceClienteImpl.consultarPorId(Integer.parseInt(tfId.getText().toString()));

					resOp=JOptionPane.showConfirmDialog(null, "¿Este es el usuario que deseas modificar?\n"
							+ "id: "+clientePrub.getId()+", celular: "+clientePrub.getCelular()+", correo: "+clientePrub.getCorreo());
				}

				if(resOp==0) {
					ServiceClienteImpl serviceClienteImpl = new ServiceClienteImpl();
					JOptionPane.showMessageDialog(null, (serviceClienteImpl.eliminarCliente(Integer.parseInt(tfId.getText()))));	
				}
				
			}
		});
		btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnEliminar.setBounds(50, 200, 163, 47);
		add(btnEliminar);



	}

}
