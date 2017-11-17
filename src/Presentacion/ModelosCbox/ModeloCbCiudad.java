/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosCbox;

import Dominio.Ciudad;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Negro
 */
public class ModeloCbCiudad extends AbstractListModel<Ciudad> implements ComboBoxModel<Ciudad>{
    private List<Ciudad> ciudades;
    private Object categoriaSeleccionada;
    
   @Override
    public int getSize() {
        return ciudades.size();
    }

    @Override
    public Ciudad getElementAt(int index) {
        return ciudades.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        categoriaSeleccionada = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return categoriaSeleccionada;
    }
    
    public ModeloCbCiudad(List<Ciudad> ciudades){
        this.ciudades = ciudades;
    }
}
