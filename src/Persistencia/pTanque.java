/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Dominio.Tanque;
import Servicios.IABM;
import Servicios.IBuscarListar;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class pTanque extends MySql implements IABM<Tanque>, IBuscarListar<Tanque>{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tanque buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//id, idCategoriaLeche, numero, volumen, stock
   
}
