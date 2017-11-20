/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.ModelosCbox;

import Dominio.Raza;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Negro
 */
public class ModeloCbRaza extends AbstractListModel<Raza> implements ComboBoxModel<Raza>{
    private static List<Raza> razas;
    private static Object razaSeleccionada;

    @Override
    public int getSize() {
        return razas.size();
    }

    @Override
    public Raza getElementAt(int index) {
        return razas.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        razaSeleccionada = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return razaSeleccionada;
    }
    
    public ModeloCbRaza(List<Raza> razas){
        this.razas = razas;
    }
}
