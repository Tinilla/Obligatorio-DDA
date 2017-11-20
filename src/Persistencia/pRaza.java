/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Raza;
import Servicios.IABM;
import Servicios.IBuscarListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Negro
 */
public class pRaza extends MySql implements IBuscarListar<Raza> {

    @Override
    public List<Raza> listar() {
        ArrayList<Raza> listaRazas = new ArrayList<>();
        strSQL = "SELECT id, nombre FROM raza ";
        seleccionar();
        Raza raza;
        try {
            while(rs.next()){
                raza = new Raza(); 
                raza.setId(rs.getInt("id"));
                raza.setNombre(rs.getString("nombre"));
                listaRazas.add(raza);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaRazas;
    }

    @Override
    public Raza buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
