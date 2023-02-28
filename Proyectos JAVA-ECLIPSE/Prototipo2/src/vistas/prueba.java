package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JTextField tfP;
	private JTextField tfS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfP = new JTextField();
		tfP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfS.setText(String.valueOf(Integer.parseInt(tfP.getText())*6));
				
			}
		});
		tfP.setBounds(27, 54, 130, 26);
		contentPane.add(tfP);
		tfP.setColumns(10);
		
		tfS = new JTextField();
		tfS.setBounds(27, 136, 130, 26);
		contentPane.add(tfS);
		tfS.setColumns(10);
	}
}
