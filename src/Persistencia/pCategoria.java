/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Categoria;
import Servicios.IBuscarListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pCategoria extends MySql implements IBuscarListar<Categoria>{

    @Override
    public List<Categoria> listar() {
        ArrayList<Categoria> listaCiudades = new ArrayList();
        strSQL = "SELECT id, nombre FROM ciudad";
        try {
            while(rs.next()){
                Categoria categoria = new Categoria(rs.getInt("id"), rs.getString("nombre"));
                listaCiudades.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCiudades;
    }

    @Override
    public Categoria buscar(int id) {
        Categoria ciudad = new Categoria();
        strSQL = "SELECT nombre FROM categoria WHERE nombre = " + id;
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
