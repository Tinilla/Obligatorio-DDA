/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Graficos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @author imssbora
 */
public class GraficoPuntos extends GraficoTemplate {
    private static final long serialVersionUID = 6294689542092367723L;

  public GraficoPuntos(String title) {
    super(title);

    // Create dataset
    /*XYDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
        "XY Line Chart Example",
        "X-Axis",
        "Y-Axis",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);*/
  }

 /* private XYDataset createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();

    XYSeries series = new XYSeries("Y = X + 2");
    series.add(2, 4);
    series.add(8, 10);
    series.add(10, 12);
    series.add(13, 15);
    series.add(17, 19);
    series.add(18, 20);
    series.add(21, 23);

    //Add series to dataset
    dataset.addSeries(series);
    
    return dataset;
  }
*/
    @Override
    protected Dataset crearSetDatos(ResultSet datos) {
        XYSeriesCollection losDatos = new XYSeriesCollection();
        XYSeries serieDatos = new XYSeries("Litros producidos a lo largo del tiempo");
        try {
            while(datos.next()){
                serieDatos.add(datos.getInt(1), datos.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficoPuntos.class.getName()).log(Level.SEVERE, null, ex);
        }
        losDatos.addSeries(serieDatos);
        return losDatos;
    }

    @Override
    protected JFreeChart dibujarGrafico(Dataset datos, String titulo) {
        JFreeChart grafico = ChartFactory.createXYLineChart(
        titulo,
        "Tiempo",
        "Litros",
        (XYDataset) datos,
        PlotOrientation.VERTICAL,
        true, true, false);
        return grafico;
    }
}
