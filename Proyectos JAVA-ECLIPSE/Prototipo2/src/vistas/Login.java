package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import api.ServiceUsuarios;
import dao.TablaUsuarios;
import excepciones.ConexionException;
import servicios.ServiceUsuariosImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfU;
	private JTextField tfC;
	private JLabel lblRes;
	private ServiceUsuarios serviceUsuarios;

	
	

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					 UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");	
					 
			           System.err.close();
			           System.setErr(System.out);
					Login frame = new Login();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {

		try {
			serviceUsuarios = new ServiceUsuariosImpl();


			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 572, 464);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(211, 211, 211));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblTitulo = new JLabel("Login de acceso");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBackground(new Color(255, 128, 128));
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			lblTitulo.setBounds(0, 6, 556, 31);
			getContentPane().add(lblTitulo);

			JLabel lblU = new JLabel("Usuario:");
			lblU.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblU.setForeground(new Color(0, 100, 0));
			lblU.setBounds(41, 94, 97, 16);
			contentPane.add(lblU);

			JLabel lblC = new JLabel("Contraseña:");
			lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblC.setForeground(new Color(0, 100, 0));
			lblC.setBounds(22, 166, 116, 16);
			contentPane.add(lblC);

			tfU = new JTextField();
			tfU.setForeground(new Color(0, 100, 0));
			tfU.setBounds(163, 89, 235, 26);
			contentPane.add(tfU);
			tfU.setColumns(10);

			tfC = new JTextField();
			tfC.setBounds(163, 161, 235, 26);
			contentPane.add(tfC);
			tfC.setColumns(10);

			lblRes = new JLabel("");
			lblRes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			lblRes.setHorizontalAlignment(SwingConstants.CENTER);
			lblRes.setForeground(new Color(255, 0, 0));
			lblRes.setBounds(163, 241, 223, 47);
			contentPane.add(lblRes);

			JButton btnIniciar = new JButton("Iniciar sesion");
			btnIniciar.setBackground(Color.ORANGE);
			btnIniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String salida = serviceUsuarios.getUsuario(tfU.getText(), tfC.getText());

					if(salida.equals("Usuario o contraseña invalidos")) {
						lblRes.setText(salida);
						tfU.setText("");
						tfC.setText("");
					}else if(salida.equals("Acceso valido")) {
						lblRes.setText("");
						JOptionPane.showMessageDialog(null, salida);
						
						Principal frame = new Principal(tfU.getText());
						frame.setVisible(true);
						
						setVisible(false);
						removeAll();
						repaint();
					}

				}
			});
			btnIniciar.setBounds(163, 241, 190, 29);
			contentPane.add(btnIniciar);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/EdoMex.png")));
			lblNewLabel.setBounds(22, 333, 534, 81);
			contentPane.add(lblNewLabel);

		} catch (ConexionException e1) {
			e1.printStackTrace();
		}
	}
}
