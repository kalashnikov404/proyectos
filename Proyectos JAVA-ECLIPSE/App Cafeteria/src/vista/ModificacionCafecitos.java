package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Conexion;
import modelo.Cafecito;
import servicios.ServiceCafecitoImpl;

public class ModificacionCafecitos extends JPanel {
	
	private JTextField textClaveCafecito, textCalle, textNumero, textOrientacion;
	private JButton modificarRegistro;
	private JTextField textClaveColonia;
	ServiceCafecitoImpl serviceCafecitoImpl= new ServiceCafecitoImpl();
	private JTextField textClavePaBuscar;
	
	private int modificacion;
	private int CveCF;
	private Cafecito cafecitoPrub;
	
	public ModificacionCafecitos() {
		setBounds(100, 100, 1300, 794);
		setLayout(null);
		
		
		serviceCafecitoImpl = new ServiceCafecitoImpl();
		
		int resOp=1;

		while(resOp==1 || resOp==2) {
			CveCF=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la clave del cafecito que deseas modificar"));

			cafecitoPrub = new Cafecito();

			cafecitoPrub=serviceCafecitoImpl.consultarPorCve(CveCF);

			resOp=JOptionPane.showConfirmDialog(null, "¿Este es el cafecito que deseas modificar?\n"
					+ "Clave: "+cafecitoPrub.getCveCF()+", Calle: "+cafecitoPrub.getCalle()+", Numero: "+cafecitoPrub.getNumero()
					+", Orientacion: "+cafecitoPrub.getOrientacion() +", Clave colonia: "+cafecitoPrub.getCveCol()) ;
		

			JOptionPane.showMessageDialog(null, "Ingresa aquellos datos en los campos que se requieran para ser modificado el cafecito");


JLabel labelBienvenida = new JLabel("Ingresa los datos del cafecito que deseas modificar ");
labelBienvenida.setForeground(Color.RED);
labelBienvenida.setBounds(18, 18, 1200, 50);
labelBienvenida.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 38));
labelBienvenida.setOpaque(true);
labelBienvenida.setBackground(Color.LIGHT_GRAY);
add(labelBienvenida);

textClaveCafecito = new JTextField();
textClaveCafecito.setBounds(158, 317, 100, 30);
		

textClaveCafecito .setFont(new Font("Dialog", Font.PLAIN, 20));
add(textClaveCafecito );
textClaveCafecito .setColumns(10);


JLabel labelCalle = new JLabel("Calle: ");
labelCalle.setBounds(18, 209, 75, 30);
labelCalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
labelCalle.setOpaque(true);
labelCalle.setBackground(Color.LIGHT_GRAY);
add(labelCalle);

textCalle = new JTextField();
textCalle.setBounds(103, 209, 155, 30);

textCalle.setFont(new Font("Dialog", Font.PLAIN, 20));
add(textCalle);
textCalle.setColumns(10);

JLabel labelNumero = new JLabel("Numero: ");
labelNumero.setBounds(275, 209, 136, 30);
labelNumero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
labelNumero.setOpaque(true);
labelNumero.setBackground(Color.LIGHT_GRAY);
add(labelNumero);

textNumero = new JTextField();
textNumero.setBounds(421, 209, 100, 30);

textNumero.setFont(new Font("Dialog", Font.PLAIN, 20));
add(textNumero);
textNumero.setColumns(10);

JLabel labelOrientacion = new JLabel("Orientacion: ");
labelOrientacion.setBounds(542, 209, 155, 30);
labelOrientacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
labelOrientacion.setOpaque(true);
labelOrientacion.setBackground(Color.LIGHT_GRAY);
add(labelOrientacion);

textOrientacion = new JTextField();
textOrientacion.setBounds(707, 209, 148, 30);

textOrientacion.setFont(new Font("Dialog", Font.PLAIN, 20));
add(textOrientacion);
textOrientacion.setColumns(10);

modificarRegistro = new JButton("Modificar el registro del cafecito");
modificarRegistro.setBounds(300, 382, 373, 60);
modificarRegistro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//orientacion

			if(!textOrientacion.getText().isEmpty() && !textClaveColonia.getText().isEmpty()) {
				serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());
				serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

			}

			if(!textOrientacion.getText().isEmpty() && !textNumero.getText().isEmpty()) {
				serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());
				serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());


			}
			
		if(!textOrientacion.getText().isEmpty() && !textCalle.getText().isEmpty()) {
			serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());
			serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

				
			}
		
		
		if(!textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty()) {
			serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());
			serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

				
			}
		
		
		//calle

			if(!textCalle.getText().isEmpty() && !textOrientacion.getText().isEmpty()) {
				
				serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());
				serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());
		
			}
			if(!textCalle.getText().isEmpty() && !textClaveColonia.getText().isEmpty()) {
			
				serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

				serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

			}
			
			if(!textCalle.getText().isEmpty() && !textNumero.getText().isEmpty()) {
				
				serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

				serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());

			}
			
			
			if(!textCalle.getText().isEmpty() && !textClaveCafecito.getText().isEmpty()) {
				
				serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

				serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

			}

			
			
			//numero
			
		if(!textNumero.getText().isEmpty() && !textOrientacion.getText().isEmpty()) {
				

				serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
				serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());


			}

		if(!textNumero.getText().isEmpty() && !textClaveColonia.getText().isEmpty()) {
		

		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());


	}
	

	if(!textNumero.getText().isEmpty() && !textCalle.getText().isEmpty()) {
		

		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());


	}
	
	
	
	if(!textNumero.getText().isEmpty() && !textClaveCafecito.getText().isEmpty()) {
			
	serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());

			serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

		}
	
 //clavecolonia
	
		if(!textClaveColonia.getText().isEmpty() && !textOrientacion.getText().isEmpty()) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());


		}
		
		if(!textClaveColonia.getText().isEmpty() && !textNumero.getText().isEmpty()) {
			
			serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

			serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());


			}
		
	if(!textClaveColonia.getText().isEmpty() && !textCalle.getText().isEmpty()) {
			
			serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

			serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());


			}
		
			
	
	if(!textClaveColonia.getText().isEmpty() && !textClaveCafecito.getText().isEmpty()) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

				serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

			}
	
	//Clavecafeito
		if(!!textClaveCafecito.getText().isEmpty() && !textClaveColonia.getText().isEmpty()) {
		
				serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());
				serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

				
				
			}
		if(!!textClaveCafecito.getText().isEmpty() && !textOrientacion.getText().isEmpty()) {
			
			serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());
			serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

			
			
		}

		if(!!textClaveCafecito.getText().isEmpty() && !textNumero.getText().isEmpty()) {
			
			serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());
			serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());

			
			
		}

	if(!!textClaveCafecito.getText().isEmpty() && !textCalle.getText().isEmpty()) {
	
	serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());
	serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

	
	
	}

	
	//tres
	if(!textClaveColonia.getText().isEmpty()  && !textNumero.getText().isEmpty() && !textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty() ) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		
		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	
	if(!textClaveColonia.getText().isEmpty() && !textCalle.getText().isEmpty()  && !textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty() ) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());
		
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	if(!textClaveColonia.getText().isEmpty() && !textNumero.getText().isEmpty() && !textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty() ) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		
		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	
	if(!textClaveColonia.getText().isEmpty() && !textCalle.getText().isEmpty() && !textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty() ) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());
		
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	
	if(!textClaveColonia.getText().isEmpty() && !textCalle.getText().isEmpty() && !textNumero.getText().isEmpty() && !textOrientacion.getText().isEmpty()  ) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());
		
		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());


	}
	
	
	//todos
	
	if(!textClaveColonia.getText().isEmpty() && !textCalle.getText().isEmpty() && !textNumero.getText().isEmpty() && !textOrientacion.getText().isEmpty() && !textClaveCafecito.getText().isEmpty() ) {
	
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());
		
		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());
		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	//unos
	
	
	
	if(!textClaveColonia.getText().isEmpty()) {
		
		serviceCafecitoImpl.modificarClaveColoniaCafecito(Integer.parseInt(textClaveColonia.getText()) ,cafecitoPrub.getCveCF());
	
		
	}	
	

	
	if(!textCalle.getText().isEmpty()) {


		serviceCafecitoImpl.modificarCalleCafecito(textCalle.getText() ,cafecitoPrub.getCveCF());

	}	


	if(!textNumero.getText().isEmpty()) {


		serviceCafecitoImpl.modificarNumeroCafecito(Integer.parseInt(textNumero.getText()) ,cafecitoPrub.getCveCF());

	}
	
	
	if(!textOrientacion.getText().isEmpty()) {


		serviceCafecitoImpl.modificarOrientacionCafecito(textOrientacion.getText() ,cafecitoPrub.getCveCF());

	}
	
	
	if(!textClaveCafecito.getText().isEmpty()) {


		serviceCafecitoImpl.modificarClaveCafecito(Integer.parseInt(textClaveCafecito.getText()) ,cafecitoPrub.getCveCF());

	}
	
	
	
			JOptionPane.showMessageDialog(null, " Cafecito modificado con exito");

		
			
			
			

			
	
			
		
		}
});

modificarRegistro.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 24));
add(modificarRegistro);

JLabel labelClaveColonia = new JLabel("Clave colonia");
labelClaveColonia.setOpaque(true);
labelClaveColonia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
labelClaveColonia.setBackground(Color.LIGHT_GRAY);
labelClaveColonia.setBounds(890, 209, 163, 30);
add(labelClaveColonia);

textClaveColonia = new JTextField();
textClaveColonia.setFont(new Font("Dialog", Font.PLAIN, 20));
textClaveColonia.setColumns(10);
textClaveColonia.setBounds(1063, 209, 85, 30);
add(textClaveColonia);

JComboBox comboBox = new JComboBox();




      comboBox.removeAllItems();
      ArrayList<String> lista = new ArrayList<String>();
      lista = serviceCafecitoImpl.llenar_combo();
      for(int i = 0; i<lista.size();i++){
		comboBox.addItem(lista.get(i));
      }
      
      

comboBox.setBounds(218, 263, 1120, 50);
add(comboBox);









JLabel lblUbicacion = new JLabel("Ubicacion:");
lblUbicacion.setOpaque(true);
lblUbicacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
lblUbicacion.setBackground(Color.LIGHT_GRAY);
lblUbicacion.setBounds(21, 267, 187, 30);
add(lblUbicacion);

JLabel lblClave = new JLabel("Clave: ");
lblClave.setOpaque(true);
lblClave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
lblClave.setBackground(Color.LIGHT_GRAY);
lblClave.setBounds(18, 317, 113, 30);
add(lblClave);

		}
	}
}