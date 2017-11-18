/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Graficos;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

public class GraficoBarras extends GraficoTemplate{


 private static final long serialVersionUID = 1L;

    public GraficoBarras(String tituloAplicacion) {
        super(tituloAplicacion);

        // Creamos el conjunto de datos con las votaciones
        /*DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset, chartTitle);
        // Ponemos el gráfico en un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Dejamos el tamaño por defecto
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // Lo añadimos a nuestra aplicación (PieChart)
        setContentPane(chartPanel);*/

    }
    /*
    public void crearGrafico(ResultSet datos, String titulo){
        DefaultCategoryDataset losDatos = crearSetDatos(datos);
        JFreeChart grafico = dibujarGrafico(losDatos, titulo);
        ChartPanel panel = new ChartPanel(grafico);
        panel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(panel);
    }*/
    @Override
    protected /*DefaultCategory*/Dataset crearSetDatos(ResultSet datos) {
       DefaultCategoryDataset resultado = new DefaultCategoryDataset();
        try {
            while(datos.next()){
                resultado.setValue(datos.getInt(1), datos.getString(2), datos.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }

       return resultado;
       }
 /**
  * Creates a sample dataset
  */
/*
 private DefaultCategoryDataset createDataset() {
  DefaultCategoryDataset result = new DefaultCategoryDataset();
 
   result.setValue(154, "PP", "2008");
  result.setValue(169, "PSOE", "2008");
  result.setValue(10, "CIU", "2008");
  result.setValue(2, "IU-LV", "2008");
  result.setValue(0, "AMAIUR", "2008");
  result.setValue(1, "UPyD", "2008");
  result.setValue(6, "EAJ-PNV", "2008");
  result.setValue(3, "ERC", "2008");
  result.setValue(2, "BNG", "2008");

  result.setValue(186, "PP", "2011");
  result.setValue(110, "PSOE", "2011");
  result.setValue(16, "CIU", "2011");
  result.setValue(11, "IU-LV", "2011");
  result.setValue(7, "AMAIUR", "2011");
  result.setValue(5, "UPyD", "2011");
  result.setValue(5, "EAJ-PNV", "2011");
  result.setValue(3, "ERC", "2011");
  result.setValue(2, "BNG", "2011");
 

 
     result.setValue(56, "PP", "2012");
  result.setValue(5, "PSOE", "2012");
  result.setValue(48, "CIU", "2012");
  result.setValue(67, "IU-LV", "2012");
  result.setValue(200, "AMAIUR", "2012");
  result.setValue(8, "UPyD", "2012");
  result.setValue(6, "EAJ-PNV", "2012");
  result.setValue(43, "ERC", "2012");
  result.setValue(21, "BNG", "2012");



 
  return result;

 }*/

 /**
  * Creates a chart por andres2288
  */

 /*private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {

  JFreeChart chart = ChartFactory.createBarChart3D(title, "Mes",
    "Ganancias totales", dataset, // data
    PlotOrientation.VERTICAL, true, // include legend
    true, false);
  CategoryPlot plot = (CategoryPlot) chart.getPlot();
  CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
  xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Inclinamos 45 grados las etiquetas del eje X
  plot.setBackgroundAlpha(0.5f);
  return chart;

 }*/
    @Override
    protected JFreeChart dibujarGrafico(/*DefaultCategory*/Dataset datos, String titulo){
        JFreeChart grafico = ChartFactory.createBarChart3D(titulo, "Mes", "Ganancias totales", (DefaultCategoryDataset)datos, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot trazo = (CategoryPlot) grafico.getPlot();
        CategoryAxis ejeX = (CategoryAxis) trazo.getDomainAxis();
        ejeX.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        trazo.setBackgroundAlpha(0.5f);
        return grafico;
    }
}
