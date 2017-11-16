/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosTbl;

import Dominio.Categoria;
import Dominio.Tanque;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Equipo
 */
public class ModeloTblTanque extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 2;
    private static final String[] TITULOS_COLUMNAS = new String[]{"N° tanque", "Stock", "Volumen", "Categoría"};
    private List<Tanque> tanques;
    @Override
    public int getRowCount() {
        return tanques.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tanque elTanque = tanques.get(rowIndex);
        switch(columnIndex){
            case 0:
                return elTanque.getNumero();
            case 1:
                return elTanque.getStock();
            case 2:
                return elTanque.getVolumen();
            case 3: 
                return elTanque.getCategoria();               
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3: 
                return Categoria.class;
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
    
    public void setDatos(List<Tanque> lista){
        tanques = lista;
    }
    
    public Tanque getTanque(int row){
        return tanques.get(row);
    } 
    
    public ModeloTblTanque(List<Tanque> tanques){
        this.tanques = tanques;
    }
}
