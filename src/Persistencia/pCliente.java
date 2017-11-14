/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Servicios.*;
import java.util.List;

/**
 *
 * @author Negro
 */
public class pCliente extends MySql implements IABM<Cliente>, IBuscarListar<Cliente>{

    @Override
    public boolean alta(Cliente objeto) {
        strSQL = "INSERT INTO cliente (nombre, razonSocial, rut, idCiudad) VALUES ('"+objeto.getNombre()+"', '"+objeto.getRazonSocial()+"', '"+objeto.getRut()+"', '"+objeto.getCiudad().getId()+"')";
        update();
        return true;
    }

    @Override
    public boolean baja(int id) {
        strSQL = "UPDATE cliente SET estado = 0 WHERE id = "+ id;
        update();
        return true;
    }

    @Override
    public boolean modificar(Cliente objeto) {
        strSQL = "UPDATE cliente SET nombre = '"+objeto.getNombre()+"', razonSocial = '"+objeto.getRazonSocial()+"', rut = '"+objeto.getRut()+"', idCiudad = '" + objeto.getCiudad().getId()+"'WHERE id = " + objeto.getId();
        update();
        return true;
    }

    @Override
    public List<Cliente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
