/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Dominio.Categoria;
import Dominio.Tanque;
import Servicios.IABM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pTanque extends MySql implements IABM<Tanque>{

    @Override
    public boolean alta(Tanque objeto) {
        strSQL = "INSERT INTO `tanque` (`idCategoriaLeche`, `numero`, `volumen`, `stock`, `estado`) VALUES ('"+objeto.getCategoria().getId()+"', '"+objeto.getNumero()+"', '"+objeto.getVolumen()+"', '"+objeto.getStock()+"', 1)";
        update();
        return true;
    }

    @Override
    public boolean baja(int id) {
        strSQL = "UPDATE `tanque` SET `estado` = 0 WHERE `id` = " + id;
        update();
        return true;
    }

    @Override
    public boolean modificar(Tanque objeto) {
        strSQL = "UPDATE `tanque` SET `idCategoriaLeche` = "+objeto.getCategoria().getId()+", `numero` = "+objeto.getNumero()+", `volumen` = "+objeto.getVolumen()+", `stock` = "+objeto.getStock()+" WHERE `id` = "+objeto.getId();
        update();
        return true;
    }

    @Override
    public List<Tanque> listar() {
        ArrayList<Tanque> listaTanques = new ArrayList();
        return listaTanques;
    }

    @Override
    public Tanque buscar(int id) {
        Tanque elTanque = null;
        strSQL = "SELECT * FROM `tanque` WHERE `id` = "+ id;
        seleccionar();
        try{
            while(this.rs.next()){
                elTanque = new Tanque(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), new Categoria(rs.getInt(5)));
            }
            rs.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
        return elTanque;
    }
}
