/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Ciudad;
import Servicios.IBuscarListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Negro
 */
public class pCiudad extends MySql implements IBuscarListar<Ciudad>{

    @Override
    public List<Ciudad> listar() {
        ArrayList<Ciudad> listaCiudades = new ArrayList();
        strSQL = "SELECT id, nombre FROM ciudad";
        try {
            while(rs.next()){
                Ciudad ciudad = new Ciudad(rs.getInt("id"), rs.getString("nombre"));
                listaCiudades.add(ciudad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCiudades;
    }

    @Override
    public Ciudad buscar(int id) {
        Ciudad ciudad = new Ciudad();
        strSQL = "SELECT nombre FROM ciudad WHERE nombre = " + id;
        seleccionar();
        try {
            if(rs.next()){
                ciudad.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ciudad;
    }

    
}
