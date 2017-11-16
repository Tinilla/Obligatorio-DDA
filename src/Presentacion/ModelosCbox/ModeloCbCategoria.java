/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosCbox;

import Dominio.Categoria;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Equipo
 */
public class ModeloCbCategoria extends AbstractListModel<Categoria> implements ComboBoxModel<Categoria>{
    private static List<Categoria> categorias;
    private static Object categoriaSeleccionada;

    @Override
    public int getSize() {
        return categorias.size();
    }

    @Override
    public Categoria getElementAt(int index) {
        return categorias.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        categoriaSeleccionada = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return categoriaSeleccionada;
    }
    
    public ModeloCbCategoria(List<Categoria> categorias){
        this.categorias = categorias;
    }
}

