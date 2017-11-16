/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.TipoUsuario;
import Servicios.IBuscarListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pTipoUsuario extends MySql implements IBuscarListar<TipoUsuario>{

    @Override
    public List<TipoUsuario> listar() {
        ArrayList<TipoUsuario> tipos = new ArrayList<>();
        strSQL = "SELECT * FROM `tipo_usuario`";
        seleccionar();
        try{
            while(this.rs.next()){
                TipoUsuario elTipo = new TipoUsuario(rs.getInt(1), rs.getString(2));
                tipos.add(elTipo);
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return tipos;
    }

    @Override
    public TipoUsuario buscar(int id) {
        TipoUsuario elTipo = null;
        strSQL = "SELECT * FROM `tipo_usuario` WHERE `id` = "+ id;
        seleccionar();
        try{
            while(this.rs.next()){
                elTipo = new TipoUsuario(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return elTipo;
    }

    
}
