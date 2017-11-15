/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Servicios.FachadaPersistencia;
import java.util.List;

/**
 *
 * @author Negro
 */
public class Tambo {
    private static FachadaPersistencia persistencia;
    private static Tambo instancia;
    
    private Tambo(){
        persistencia = FachadaPersistencia.getInstancia();
    }
    
    public static Tambo getInstancia(){
        if(instancia == null){
            instancia = new Tambo();
        }
        return instancia;
    }
    
    public void altaUsuario(Usuario elUsuario){
        persistencia.altaUsuario(elUsuario);
    }
    
    public void bajaUsuario(int idUsuario){
        persistencia.bajaUsuario(idUsuario);
    }
    
    public void modificarUsuario(Usuario elUsuario){
        persistencia.modificarUsuario(elUsuario);
    }
    public List<Usuario> listarUsuarios(){
        return persistencia.listarUsuarios();
    }
    
    public Usuario buscarUsuario(int idUsuario){
        return persistencia.buscarUsuario(idUsuario);
    }
    
    public void altaTanque(Tanque elTanque){
        persistencia.altaTanque(elTanque);
    }
    
    public void bajaTanque(int idTanque){
        persistencia.bajaTanque(idTanque);
    }
    
    public void modificarTanque(Tanque elTanque){
        persistencia.modificarTanque(elTanque);
    }
    
    public List<Tanque> listarTanques(){
        return persistencia.listarTanques();
    }
    
    public Tanque buscarTanque(int idTanque){
        return persistencia.buscarTanque(idTanque);
    }
    
    
}
