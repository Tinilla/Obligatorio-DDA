/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.TipoUsuario;
import Dominio.Usuario;
import Servicios.IABM;
import Servicios.IUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pUsuario extends MySql implements IABM<Usuario>, IUsuario{

    @Override
    public boolean alta(Usuario objeto) {
        strSQL = "INSERT INTO `usuario` (`nombreUsuario`, `contrasena`, `idTipoUsuario`, `estado`) VALUES('"+objeto.getNombreUsuario()+"','"+objeto.getContrasena()+"',"+objeto.getTipo().getId()+", 1)";
        update();
        return true;
    }

    @Override
    public boolean baja(int id) {
        strSQL = "UPDATE `usuario` SET `estado` = 0 WHERE `id` = " + id;
        update();
        return true;
    }

    @Override
    public boolean modificar(Usuario objeto) {
        strSQL = "UPDATE `usuario` SET `nombreUsuario` = '"+objeto.getNombreUsuario()+"', `contrasena` = '"+objeto.getContrasena()+"', `idTipoUsuario` = " + objeto.getTipo().getId() + " WHERE `id` = " +objeto.getId();
        update();
        return true;
    }

    @Override
    public List<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        strSQL = "SELECT * FROM `usuario` WHERE `estado` = 1";
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
        strSQL = "SELECT * FROM `usuario` WHERE `id` = " + id;
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

    @Override
    public boolean verificar(Usuario elUsuario) {
        boolean encontrado = false;
        strSQL = "SELECT * FROM `usuario` WHERE `nombreUsuario` = '" + elUsuario.getNombreUsuario() + "' AND `contrasena` = '"+elUsuario.getContrasena()+"'";
        seleccionar();
        try{
            while(this.rs.next()){
                //usuarioEncontrado = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), new TipoUsuario(rs.getInt(4)));
                elUsuario.setContrasena("");
                elUsuario.setTipo(new TipoUsuario(rs.getInt(4)));
                elUsuario.setId(rs.getInt(1));
                encontrado = true;
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return encontrado;
    }
    
}
