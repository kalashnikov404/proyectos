package vista;

import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;


public class VentanaCombo extends javax.swing.JFrame {

 
    public VentanaCombo() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCombo.class.getResource("/imagenes/ocupado.jpg")));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        cbPaises = new javax.swing.JComboBox();
        cbCiudades = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        cbPaises.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Pais", "Mexico", "Estados Unidos" }));
        cbPaises.setPreferredSize(new java.awt.Dimension(150, 20));
        cbPaises.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPaisesItemStateChanged(evt);
            }
        });
        getContentPane().add(cbPaises);

        cbCiudades.setPreferredSize(new java.awt.Dimension(150, 20));
        getContentPane().add(cbCiudades);

        pack();
    }

    private void cbPaisesItemStateChanged(java.awt.event.ItemEvent evt) {
       if(evt.getStateChange() == ItemEvent.SELECTED)
       {
           if(this.cbPaises.getSelectedIndex()>0)
           {
               this.cbCiudades.setModel(new DefaultComboBoxModel(this.getCiudades(this.cbPaises.getSelectedItem().toString())));
           }
       }
    }

    public String[] getCiudades(String pais)
    {
        String[] ciudades = new String[6];
        if(pais.equalsIgnoreCase("Mexico"))
        {
        	
        	ciudades[0] = "Ciudades";
            ciudades[1] = "Cdmx";
            ciudades[2] = "Guadalajara";
            ciudades[3] = "Puebla";
            ciudades[4] = "Tijuana";
            ciudades[5] = "Ciudad Juarez";
        }
        
        if(pais.equalsIgnoreCase("Estados Unidos"))
        {
        	
        	
        	ciudades[0] = "Ciudades";
            ciudades[1] = "Chicago";
            ciudades[2] = "Los Angeles";
            ciudades[3] = "Nueva York";
            ciudades[4] = "San Francisco";
            ciudades[5] = "Las Vegas";
        }
        return ciudades;
    }
   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCombo().setVisible(true);
            }
        });
    }
    private javax.swing.JComboBox cbCiudades;
    private javax.swing.JComboBox cbPaises;
}
