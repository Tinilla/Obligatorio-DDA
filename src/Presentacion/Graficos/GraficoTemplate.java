/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Graficos;

import java.sql.ResultSet;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

/**
 *
 * @author Equipo
 */
public abstract class GraficoTemplate extends JFrame{
    public GraficoTemplate(String tituloAplicacion){
        super(tituloAplicacion);
    }
    
    public void crearGrafico(){
        
    }
    
    public void crearGrafico(ResultSet datos, String titulo){
        Dataset losDatos = crearSetDatos(datos);
        JFreeChart grafico = dibujarGrafico(losDatos, titulo);
        ChartPanel panel = new ChartPanel(grafico);
        panel.setPreferredSize(new java.awt.Dimension(500,270));
        setContentPane(panel);
    }
    
    protected abstract Dataset crearSetDatos(ResultSet datos);
    
    protected abstract JFreeChart dibujarGrafico(Dataset datos, String titulo);
}
