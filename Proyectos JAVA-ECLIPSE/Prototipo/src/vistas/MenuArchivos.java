package vistas;


	import java.awt.Color;
	import java.awt.Font;
	import java.awt.GridLayout;

	import javax.swing.JButton;
	import javax.swing.JPanel;
	import javax.swing.SwingConstants;
	import javax.swing.ImageIcon;

	public class MenuArchivos extends JPanel {

		private JButton btnTratadoCsv;
		private JButton btnTratadoJson;
		private JButton btnTratadoTxt;
		private JButton btnTratadoXml;
		private JButton btnTratado;

		
		public JButton getBtnTratadoCsv() {
			return btnTratadoCsv;
		}
		
		public JButton getBtnTratadoJson() {
			return btnTratadoJson;
		}

		public JButton getBtnTratadoTxt() {
			return btnTratadoTxt;
		}
		
		public JButton getBtnTratadoXml() {
			return btnTratadoXml;
		}
		
		
		public JButton getBtnTratado() {
			return btnTratado;
		}
		
		
		
		public MenuArchivos() {
			
			setLayout(new GridLayout(0, 5, 0, 0));
			
			btnTratado = new JButton("");
			btnTratado.setIcon(new ImageIcon(MenuArchivos.class.getResource("/imagenes/tratado2.png")));
			btnTratado.setBackground(new Color(0, 0, 25));
			btnTratado.setOpaque(true);
			btnTratado.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			btnTratado.setHorizontalTextPosition(SwingConstants.CENTER);
			add(btnTratado);
			
			btnTratadoCsv = new JButton("");
			btnTratadoCsv.setIcon(new ImageIcon(MenuArchivos.class.getResource("/imagenes/csv.png")));
			btnTratadoCsv.setBackground(new Color(0, 255, 0));
			btnTratadoCsv.setOpaque(true);
			btnTratadoCsv.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			btnTratadoCsv.setHorizontalTextPosition(SwingConstants.CENTER);
			add(btnTratadoCsv);
			
			btnTratadoJson = new JButton("");
			btnTratadoJson.setIcon(new ImageIcon(MenuSocio.class.getResource("/imagenes/json.png")));
			btnTratadoJson.setBackground(new Color(229, 78, 50));
			btnTratadoJson.setOpaque(true);
			btnTratadoJson.setFont(new Font("Bw Quinta Pro", Font.PLAIN, 20));
			btnTratadoJson.setHorizontalTextPosition(SwingConstants.CENTER);
			add(btnTratadoJson);
			
		
			
			
			
			}

	}
