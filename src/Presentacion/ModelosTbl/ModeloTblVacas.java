/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosTbl;

import Dominio.Vaca;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Negro
 */
public class ModeloTblVacas extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 6;
    private static final String[] TITULOS_COLUMNAS = new String[]{"Id","Caravana", "Peso", "Fecha de Nacimiento", "Raza", "Categoría"};
    private List<Vaca> vacas;

   @Override
    public int getRowCount() {
        return vacas.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vaca laVaca = vacas.get(rowIndex);
        switch(columnIndex){
            case 0:
                return laVaca.getId();
            case 1:
                return laVaca.getCaravana();
            case 2:
                return laVaca.getPeso();
            case 3:
                return laVaca.getFechaNacimiento();
            case 4: 
                return laVaca.getRaza().getNombre();
            case 5:
                return laVaca.getCategoria().getNombre();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4: 
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return TITULOS_COLUMNAS[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public void setDatos(List<Vaca> lista){
        vacas = lista;
    }
    
    public Vaca getVaca(int row){
        return vacas.get(row);
    } 
    
    public ModeloTblVacas(List<Vaca> vacas){
        this.vacas = vacas;
    }
}