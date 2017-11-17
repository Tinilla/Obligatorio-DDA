/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosCbox;

import Dominio.TipoUsuario;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Equipo
 */
public class ModeloCbTipoUsuario extends AbstractListModel<TipoUsuario> implements ComboBoxModel<TipoUsuario>{
    private List<TipoUsuario> tipos;
    private Object usuarioSeleccionado;

    @Override
    public int getSize() {
        return tipos.size();
    }

    @Override
    public TipoUsuario getElementAt(int index) {
        return tipos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        usuarioSeleccionado = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return usuarioSeleccionado;
    }
    
    public ModeloCbTipoUsuario(List<TipoUsuario> tipos){
        this.tipos = tipos;
    }
}
