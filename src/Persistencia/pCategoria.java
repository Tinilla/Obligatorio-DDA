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
        ArrayList<Categoria> categorias = new ArrayList();
        strSQL = "SELECT * FROM `categoria`";
        seleccionar();
        try {
            while(rs.next()){
                categorias.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorias;
    }

    @Override
    public Categoria buscar(int id) {
        Categoria laCategoria = null;
        strSQL = "SELECT * FROM `categoria` WHERE `id` = " + id;
        seleccionar();
        try {
            if(rs.next()){
                laCategoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return laCategoria;
    }

    
}
