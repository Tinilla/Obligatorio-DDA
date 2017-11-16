/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Tanque;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import Persistencia.pTanque;
import Persistencia.pTipoUsuario;
import Persistencia.pUsuario;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class FachadaPersistencia {
    private static IABM<Tanque> tanqueABM;
    private static IABM<Usuario> usuarioABM;
    
    private static IBuscarListar<TipoUsuario> tipoUsuarioBL;
    
    private static IUsuario usuario;
    
    private static FachadaPersistencia instancia;
    
    private FachadaPersistencia() {
        tanqueABM = new pTanque();
        usuarioABM = new pUsuario();
        tipoUsuarioBL = new pTipoUsuario();
        usuario = new pUsuario();
    }
    
    public static FachadaPersistencia getInstancia(){
        if(instancia == null){
            instancia = new FachadaPersistencia();
        }
        return instancia;
    }
    
    public void altaUsuario(Usuario elUsuario){
        usuarioABM.alta(elUsuario);
    }
    
    public void bajaUsuario(int idUsuario){
        usuarioABM.baja(idUsuario);
    }
    
    public void modificarUsuario(Usuario elUsuario){
        usuarioABM.modificar(elUsuario);
    }
    
    public List<Usuario> listarUsuarios(){
        return usuarioABM.listar();
    }
    
    public Usuario buscarUsuario(int idUsuario){
        Usuario elUsuario = usuarioABM.buscar(idUsuario);
        elUsuario.setTipo(tipoUsuarioBL.buscar(elUsuario.getTipo().getId()));
        return elUsuario;
    }
    
    public boolean verificarUsuario(Usuario elUsuario){
        if(usuario.verificar(elUsuario)){
            elUsuario.setTipo(tipoUsuarioBL.buscar(elUsuario.getTipo().getId()));
        }
        return elUsuario != null;
    }
    
    public void altaTanque(Tanque elTanque){
        tanqueABM.alta(elTanque);
    }
    
    public void bajaTanque(int idTanque){
        tanqueABM.baja(idTanque);
    }
    
    public void modificarTanque(Tanque elTanque){
        tanqueABM.modificar(elTanque);
    }
    
    public List<Tanque> listarTanques(){
        return tanqueABM.listar();
    }
    
    public Tanque buscarTanque(int idTanque){
        return tanqueABM.buscar(idTanque);
    }
    
}
