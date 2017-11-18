/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Graficos;

/**
 *
 * @author Equipo
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


public class GraficoTorta extends GraficoTemplate {

    private static final long serialVersionUID = 1L;

    public GraficoTorta(String tituloAplicacion) {
        super(tituloAplicacion);
        // This will create the dataset
        /*PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, tituloGrafico);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);*/

    }
    /*public void crearGrafico(ResultSet datos, String titulo){
        PieDataset losDatos = (PieDataset)crearSetDatos(datos);
        JFreeChart grafico = dibujarGrafico(losDatos, titulo);
        ChartPanel panel = new ChartPanel(grafico);
        panel.setPreferredSize(new java.awt.Dimension(500,270));
        setContentPane(panel);
    }*/
    
    @Override
    protected /*Pie*/Dataset crearSetDatos(ResultSet datos){
        DefaultPieDataset resultado = new DefaultPieDataset();
        try {
            while(datos.next()){
                resultado.setValue(datos.getString(1), datos.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficoTorta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    /**
     * Creates a sample dataset
     */
    /*private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux", 29);
        result.setValue("Mac", 20);
        result.setValue("Windows", 51);
        return result;

    }*/

    /**
     * Creates a chart
     */
    @Override
    protected JFreeChart dibujarGrafico(Dataset datos, String titulo) {

        JFreeChart grafico = ChartFactory.createPieChart3D(
            titulo,                  // chart title
            (DefaultPieDataset)datos,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D trazo = (PiePlot3D) grafico.getPlot();
        trazo.setStartAngle(290);
        trazo.setDirection(Rotation.CLOCKWISE);
        trazo.setForegroundAlpha(0.5f);
        return grafico;
    }
    
    /*private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }*/
}
