/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Servicios.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<Cliente> listar(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        strSQL = "SELCT nombre, razonSocial, rut FROM cliente ";
        seleccionar();
        Cliente cliente;
        try {
            while(rs.next()){
                cliente = new Cliente(); 
                cliente.setNombre(rs.getString("nombre"));
                cliente.setNombre(rs.getString("razonSocial"));
                cliente.setNombre(rs.getString("rut"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = new Cliente();
        strSQL = "SELECT nombre, razonSocial, ruta FROM cliente WHERE cliente.id = " + id;
        seleccionar();
        try {
            if(rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setNombre(rs.getString("razonSocial"));
                cliente.setNombre(rs.getString("rut"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

   
    
}
