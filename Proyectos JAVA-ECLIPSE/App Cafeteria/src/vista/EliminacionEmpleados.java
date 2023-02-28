package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import modelo.Empleado;
import servicios.ServiceEmpleadoImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminacionEmpleados extends JPanel {
	private JTextField tfId;

	private int modificacion;
	private Empleado empleadoPrub;
	
	public EliminacionEmpleados() {
		setLayout(null);

		
		JLabel lblInstrucciones = new JLabel("Ingresa la clave de la  persona vinculado al empleado a eliminar");
		lblInstrucciones.setFont(new Font("Zapf Dingbats", Font.PLAIN, 26));
		lblInstrucciones.setBounds(33, 44, 1000, 27);
		add(lblInstrucciones);

		tfId = new JTextField();
		tfId.setBounds(33, 81, 130, 26);
		add(tfId);
		tfId.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar empleado");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resOp=1;

				while(resOp==1 || resOp==2) {

					ServiceEmpleadoImpl serviceContratoImpl = new ServiceEmpleadoImpl();
					empleadoPrub = new Empleado();

					empleadoPrub=serviceContratoImpl.consultarPorFolio(Integer.parseInt(tfId.getText().toString()));

					resOp=JOptionPane.showConfirmDialog(null, "¿Este es el empleado que deseas eliminar?\n"
							+ "Clave persona: "+empleadoPrub.getCvePer()+	", Nombre: "+empleadoPrub.getNombre()  + ", A.Paterno: "+empleadoPrub.getPaterno()+	", A.Materno: "+empleadoPrub.getMaterno()+  ", Folio: "+empleadoPrub.getFolio()+ ", RFC: "+empleadoPrub.getRfc ()
			
							+ ", Puesto: "+empleadoPrub.getPuesto());
				}
				
//				"select folio_con, rfc_caf, fechaini_caf, fechafin_caf, sueldo_con, puesto_con from contrato";

				if(resOp==0) {
					ServiceEmpleadoImpl serviceContratoImpl = new ServiceEmpleadoImpl();
					JOptionPane.showMessageDialog(null, (serviceContratoImpl.eliminarEmpleado(Integer.parseInt(tfId.getText()))));	
					
					
					
				}
				
			}
		});
		btnEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnEliminar.setBounds(50, 200, 300, 47);
		add(btnEliminar);


	
		

	}

}