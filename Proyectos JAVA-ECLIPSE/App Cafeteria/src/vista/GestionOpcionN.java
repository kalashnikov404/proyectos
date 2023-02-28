package vista;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import vista.VentanaPrueba;
public class GestionOpcionN extends JPanel {

	/**	private JPanel contentPane;

	 * Create the panel.
	 */


	private RegistroCafecito registroCafecito;
	private RegistroCafecito2 registroCafecito2;

//	private VentanaPrueba ventanaPrueba;
	private GestionOpcionN gestionOpcionN;
	private VentanaPrueba ventanaPrueba;

//	JFrame f = new JFrame();
//	f.getContentPane().add(componentes);
//	f.setVisible(true);
//	
	


	private JPanel panel;

	
	public GestionOpcionN() {
		

		

	JPanel panel = new JPanel();

//
//	
//	final JToolBar toolBar = new JToolBar();
//	toolBar.setBounds(0, 0, 527, 100);
//
//    //Create the popup menu.
//    final JPopupMenu popup = new JPopupMenu();
//    
//    
//    popup.add(new JMenuItem(new AbstractAction("Option 1") {
//        public void actionPerformed(ActionEvent e) {
//        }
//    }));
//    popup.add(new JMenuItem(new AbstractAction("Option 2") {
//        public void actionPerformed(ActionEvent e) {
//        }
//    }));
//
//    final JButton registrarC = new JButton("Gestionar Negocio");
//    registrarC.addMouseListener(new MouseAdapter() {
//        public void mousePressed(MouseEvent e) {
//            popup.show(e.getComponent(), e.getX(), e.getY());
//        }
//    });
//	setLayout(null);
//	
//	
//	registrarC.setPressedIcon(new ImageIcon("/imagenes/presionado.png"));
//	registrarC.setRolloverIcon(new ImageIcon("/imagenes/seleccionado.png"));
//	registrarC.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
//	registrarC.setHorizontalTextPosition(SwingConstants.CENTER);
//	registrarC.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/normal.png")));
//	registrarC.setFocusPainted(false);
//	registrarC.setContentAreaFilled(false);
//	registrarC.setBorderPainted(false);
//    toolBar.add(registrarC);
//    add(toolBar);

		
		JLabel lblNewLabel = new JLabel("Gestion de negocio");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 28));
		lblNewLabel.setBounds(-68, 11, 1300, 46);
		add(lblNewLabel);
		
		
		
		JButton btnRegistrarN = new JButton("Registrar negocio ");
		btnRegistrarN.setForeground(Color.BLUE);
		btnRegistrarN.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 17));
		
		btnRegistrarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						registroCafecito = new RegistroCafecito();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					ventanaPrueba.getContentPanel().
					setVisible(false);
			    	
					repaint();
				
					ventanaPrueba.getContentPanel().add(registroCafecito, BorderLayout.CENTER);
					setVisible(true);
					repaint();
					
//				
//
//				
				
			
//					gestionOpcionN = new GestionOpcionN();
//			
//				
//					contentPane.removeAll();
//					repaint();
//					contentPane.add(gestionOpcionN, BorderLayout.CENTER);
//					setVisible(true);
//				
				
//				try {
//					registroCafecito = new RegistroCafecito();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		
//		    removeAll();
//			repaint();
//			add(registroCafecito, BorderLayout.CENTER);
//			setVisible(true);
//			repaint();
			
			}
		});
		
		
		
		btnRegistrarN.setBounds(81, 115, 151, 29);
		add(btnRegistrarN);

		
		JButton btnListarN = new JButton("Listar negocios ");
		btnListarN.setForeground(Color.BLUE);
		btnListarN.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 17));
		btnListarN.setBounds(81, 191, 133, 29);
		add(btnListarN);
		
		JButton btnModificarN = new JButton("Modificar negocio ");
		btnModificarN.setForeground(Color.BLUE);
		btnModificarN.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 17));
		btnModificarN.setBounds(81, 272, 151, 29);
		add(btnModificarN);
		
		JButton btnConsultarN = new JButton("Consultar negocio ");
		btnConsultarN.setForeground(Color.BLUE);
		btnConsultarN.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 17));
		btnConsultarN.setBounds(81, 359, 151, 29);
		
		
	
//
//
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1300, 795);
		add(fondo);		
		fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cafeteria.jpg")));
		Image img44= new ImageIcon(VentanaPrueba.class.getResource("/imagenes/cafeteria.jpg")).getImage();
		ImageIcon img22=new ImageIcon(img44.getScaledInstance(1300, 794, Image.SCALE_SMOOTH));

		fondo.setIcon(img22);
		
		panel.setBounds(10, 11, 1300, 795);
		add(panel);
		panel.setLayout(null);
		setLayout(null);
		

		
//		add(btnConsultarN);
//
//		
//		Image img= new ImageIcon(GestionOpcionN.class.getResource("/imagenes/tienda.jpg")).getImage();
//		ImageIcon img2=new ImageIcon(img.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
//		


	
		

	}

                
}