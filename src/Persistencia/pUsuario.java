/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.TipoUsuario;
import Dominio.Usuario;
import Servicios.IABM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pUsuario extends MySql implements IABM<Usuario>{

    @Override
    public boolean alta(Usuario objeto) {
        strSQL = "INSERT INTO `usuario` (`nombreUsuario`, `contrasena`, `idTipoUsuario`) VALUES("+objeto.getNombreUsuario()+","+objeto.getContrasena()+","+objeto.getTipo().getId()+")";
        update();
        return true;
    }

    @Override
    public boolean baja(int id) {
        strSQL = "DELETE FROM `usuario` WHERE `id` = " + id;
        update();
        return true;
    }

    @Override
    public boolean modificar(Usuario objeto) {
        strSQL = "UPDATE `usuario` SET `nombreUsuario` = "+objeto.getNombreUsuario()+", `contrasena` = "+objeto.getContrasena()+", `idTipoUsuario` = " + objeto.getTipo().getId();
        update();
        return true;
    }

    @Override
    public List<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        strSQL = "SELECT * FROM `tanque` WHERE `estado` = 1";
        seleccionar();
        try{
            while(this.rs.next()){
                Usuario elUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), new TipoUsuario(rs.getInt(4)));
                usuarios.add(elUsuario);
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return usuarios;
    }

    @Override
    public Usuario buscar(int id) {
        Usuario elUsuario = null;
        strSQL = "SELECT * FROM `tanque` WHERE `id` = " + id;
        seleccionar();
        try{
            while(this.rs.next()){
                elUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), new TipoUsuario(rs.getInt(4)));
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return elUsuario;
    }
    
}
