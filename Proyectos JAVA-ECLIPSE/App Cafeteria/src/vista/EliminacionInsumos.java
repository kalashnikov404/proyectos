package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import modelo.Cafecito;
import modelo.Insumo;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceInsumoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminacionInsumos extends JPanel {
	private JTextField tfId;

	private int modificacion;
	private Insumo insumoPrub;
	
	public EliminacionInsumos() {
		setLayout(null);

		
		JLabel lblInstrucciones = new JLabel("Ingresa la clave del insumo a eliminar");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 1000, 27);
		add(lblInstrucciones);

		tfId = new JTextField();
		tfId.setBounds(33, 81, 130, 26);
		add(tfId);
		tfId.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar insumo");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resOp=1;

				while(resOp==1 || resOp==2) {

					ServiceInsumoImpl serviceInsumoImpl = new ServiceInsumoImpl();
					insumoPrub = new Insumo();

					insumoPrub=serviceInsumoImpl.consultarPorCveP(Integer.parseInt(tfId.getText().toString()));

					resOp=JOptionPane.showConfirmDialog(null, "¿Este es el insumo que deseas eliminar?\n"
//							+ "cve: "+insumoPrub.getCveP()+", nombre: "+insumoPrub.getNombre()+", numero: "+cafecitoPrub.getNumero()
//							+", orientacion: "+cafecitoPrub.getOrientacion());
					
					+ "clave insumo: "+ + insumoPrub.getClaveProducto()+ ", nombre: " + insumoPrub.getNombre() + ", tipo: "+ insumoPrub.getTipo() + ", marca: " 
					+ insumoPrub.getMarca() + ", presentacion: " + insumoPrub.getPresentacion() + ", contenido: " + insumoPrub.getContenido() +
					", umedida: " + insumoPrub.getUmedia());
					
//					 "select cve_pro, nombre_pro, tipo_pro, marca_pro, presentacion_pro, contenido_pro, umedidad_pro from producto";
				
					
				}
				
				

				if(resOp==0) {
					ServiceInsumoImpl serviceInsumoImpl = new ServiceInsumoImpl();
					JOptionPane.showMessageDialog(null, (serviceInsumoImpl.eliminarInsumo(Integer.parseInt(tfId.getText()))));	
				}
				
			}
		});
		btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnEliminar.setBounds(50, 200, 220, 47);
		add(btnEliminar);



	}

}