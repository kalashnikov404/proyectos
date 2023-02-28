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
import modelo.Lugar;
import servicios.ServiceCafecitoImpl;
import servicios.ServiceInsumoImpl;
import servicios.ServiceLugarImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminacionLugares extends JPanel {
	private JTextField tfId;

	private int modificacion;
	private Lugar lugarPrub;
	
	public EliminacionLugares() {
		setLayout(null);

		
		// recuerda implementar o tratar de meter un trigger que elimine la tabla mesa despues de eliminar lasd foreaneas
		
		JLabel lblInstrucciones = new JLabel("Ingresa la clave del lugar a eliminar");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 1000, 27);
		add(lblInstrucciones);

		tfId = new JTextField();
		tfId.setBounds(33, 81, 130, 26);
		add(tfId);
		tfId.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar lugar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resOp=1;

				while(resOp==1 || resOp==2) {

					ServiceLugarImpl serviceLugarImpl = new ServiceLugarImpl();
					lugarPrub = new Lugar();

					lugarPrub=serviceLugarImpl.consultarPorClaveMesa(Integer.parseInt(tfId.getText().toString()));
					
					
					

					resOp=JOptionPane.showConfirmDialog(null, "¿Este es el cafecito que deseas eliminar?\n"
							+ "Clave Mesa: "+lugarPrub.getClaveMesa()+", Capacidad: "+lugarPrub.getCapacidad()+", Numero: "+lugarPrub.getNumeroMesa()
							+", Ubicacion: "+lugarPrub.getUbicacion() +", Clave Cafecito: "+lugarPrub.getClaveCafecito() +", Fecha: "+lugarPrub.getFecha()
							+", Folio: "+lugarPrub.getFolio());
				}
				
				
//
//				lugar.setClaveMesa(rs.getInt("cve_mes"));
//				lugar.setCapacidad(rs.getInt("capacidad_mes"));
//				
//			
//				lugar.setNumeroMesa(rs.getInt("num_mescaf"));
//				lugar.setUbicacion(rs.getString("ubicacion_mescaf"));
//				lugar.setClaveCafecito(rs.getInt("cve_caf"));
//				
//				lugar.setMesaContrato(rs.getInt("num_mescon"));
//				lugar.setFecha(rs.getString("fecha_mescon"));
//				lugar.setFolio(rs.getInt("folio_con"));
//

			

				if(resOp==0) {
					ServiceLugarImpl serviceLugarImpl = new ServiceLugarImpl();
					serviceLugarImpl.eliminarMesaCafecito(Integer.parseInt(tfId.getText()));	
					serviceLugarImpl.eliminarMesaContrato(Integer.parseInt(tfId.getText()));
					JOptionPane.showMessageDialog(null, (serviceLugarImpl.eliminarMesa(Integer.parseInt(tfId.getText()))));	
				}
				
				
				
//				ServiceInsumoImpl serviceInsumoImpl = new ServiceInsumoImpl();
//				insumoPrub = new Insumo();
//
//				insumoPrub=serviceInsumoImpl.consultarPorCveP(Integer.parseInt(tfId.getText().toString()));
//
//				resOp=JOptionPane.showConfirmDialog(null, "¿Este es el insumo que deseas eliminar?\n"
////						+ "cve: "+insumoPrub.getCveP()+", nombre: "+insumoPrub.getNombre()+", numero: "+cafecitoPrub.getNumero()
////						+", orientacion: "+cafecitoPrub.getOrientacion());
//				
//				+ "clave insumo: "+ + insumoPrub.getClaveProducto()+ ", nombre: " + insumoPrub.getNombre() + ", tipo: "+ insumoPrub.getTipo() + ", marca: " 
//				+ insumoPrub.getMarca() + ", presentacion: " + insumoPrub.getPresentacion() + ", contenido: " + insumoPrub.getContenido() +
//				", umedida: " + insumoPrub.getUmedia());
			}
		});
		btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnEliminar.setBounds(50, 200, 220, 47);
		add(btnEliminar);



	}

}