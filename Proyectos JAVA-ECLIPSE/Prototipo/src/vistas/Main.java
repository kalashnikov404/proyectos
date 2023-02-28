package vistas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import excepciones.ConexionException;
import modelo.Vocal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @see http://stackoverflow.com/a/12659576/230513
 */
public class Main extends ListarBarras{
	
	


	public Main(String usuario) throws ConexionException {
		super(usuario);
		// TODO Auto-generated constructor stub
	}



	static int x=2;
	
	
	
	static  void ejecutar() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
   
        Vocal vocal = new Vocal();
        
        
        dataset.setValue(aaa, "Vocal A", "");
        dataset.setValue(eee, "Vocal E", "");
        dataset.setValue(iii, "Vocal I", "");
        dataset.setValue(ooo, "Vocal O", "");
        dataset.setValue(uuu, "Vocal U", "");


        JFreeChart chart = ChartFactory.createBarChart(
            "Grafica de vocales", "Vocales", "Tendencia",
            dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.yellow);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer br = (BarRenderer) plot.getRenderer();
        br.setItemMargin(0);
        CategoryAxis domain = plot.getDomainAxis();
        domain.setLowerMargin(0.25);
        domain.setUpperMargin(0.25);

        JFrame f = new JFrame("Graficas");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel cp = new ChartPanel(chart){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 600);
            }
        };
        f.getContentPane().add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
		

        //try {
        //    ChartUtilities.saveChartAsJPEG(
        //        new File("temp.jpg"), chart, 300, 300);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }
}