/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vaca;
import Servicios.IABM;
import Servicios.IBuscarListar;
import java.util.List;

/**
 *
 * @author Negro
 */
public class pVaca extends MySql implements IABM<Vaca>, IBuscarListar<Vaca>{    

    @Override
    public boolean alta(Vaca objeto) {
        strSQL = "INSERT INTO caravana, peso, fechaNacimiento, idRaza, idCategoriaLeche VALUES ('"+objeto.getCaravana()+"', '"+objeto.getPeso()+"', '"+objeto.getFechaNacimiento()+"', '"+objeto.getRaza().getId()+"' , '"+objeto.getCategoria().getId()+"'";
        update();
        return true;
    }

    @Override
    public boolean baja(int id) {
        strSQL = "DELETE FROM vaca WHERE id = "+ id;
        update();
        return true;
    }

    @Override
    public boolean modificar(Vaca objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vaca> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vaca buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
