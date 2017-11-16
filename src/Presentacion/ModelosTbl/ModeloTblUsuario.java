/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosTbl;

import Dominio.TipoUsuario;
import Dominio.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Equipo
 */
public class ModeloTblUsuario extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 2;
    private static final String[] TITULOS_COLUMNAS = new String[]{"Nombre de usuario", "Tipo de usuario"};
    private List<Usuario> usuarios;
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario elUsuario = usuarios.get(rowIndex);
        switch(columnIndex){
            case 0:
                return elUsuario.getNombreUsuario();
            case 1:
                return elUsuario.getTipo();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return TipoUsuario.class;
            case 2:
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
    
    public void setDatos(List<Usuario> lista){
        usuarios=lista;
    }
    
    public Usuario getUsuario(int row){
        return usuarios.get(row);
    } 
    
    public ModeloTblUsuario(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
}
