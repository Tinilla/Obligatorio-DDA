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

/**
 *
 * @author Equipo
 */
public class GraficoBarras extends JFrame{
    
    private static final long serialVersionUID = 1L;
    
    public GraficoBarras(String tituloAplicacion, String tituloGrafico){
    super(tituloAplicacion);
    //crea conjunto de datos
    DefaultCategoryDataset dataset = createDataset();

    JFreeChart chart = createChart(dataset, chartTitle);
  // Ponemos el gráfico en un panel
    ChartPanel chartPanel = new ChartPanel(chart);
  // Dejamos el tamaño por defecto
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
  // Lo añadimos a nuestra aplicación (PieChart)
    setContentPane(chartPanel);
    }
  // Creamos el conjunto de datos con las votaciones
  DefaultCategoryDataset dataset = createDataset();

  JFreeChart chart = createChart(dataset, chartTitle);
  // Ponemos el gráfico en un panel
  ChartPanel chartPanel = new ChartPanel(chart);
  // Dejamos el tamaño por defecto
  chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
  // Lo añadimos a nuestra aplicación (PieChart)
  setContentPane(chartPanel);

    private DefaultCategoryDataset crearSetDatos(ResultSet datosRecibidos) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(WIDTH, NORMAL, NORMAL);
        
        try{
            while(datosRecibidos.next()){
                datos
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return tanques;
   /*result.setValue(154, "PP", "2008");
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
*/


 
  return datos;

 }
    
}
