/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosTbl;

import Dominio.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Negro
 */
public class ModeloTblClientes extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 4;
    private static final String[] TITULOS_COLUMNAS = new String[]{"Id", "Nombre de cliente", "Razon Social", "Rut"};
    private List<Cliente> clientes;
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente elCliente = clientes.get(rowIndex);
        switch(columnIndex){
            case 0:
                return elCliente.getId();
            case 1:
                return elCliente.getNombre();
            case 2:
                return elCliente.getRazonSocial();
            case 3:
                return elCliente.getRut();
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
                return String.class;
            case 3:
                return Integer.class;
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
    
    public void setDatos(List<Cliente> lista){
        clientes=lista;
    }
    
    public Cliente getCliente(int row){
        return clientes.get(row);
    } 
    
    public ModeloTblClientes(List<Cliente> clientes){
        this.clientes = clientes;
    }
}
