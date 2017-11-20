/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Ciudad;
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
        strSQL = "INSERT INTO cliente (nombre, razonSocial, rut, idCiudad, estado) VALUES ('"+objeto.getNombre()+"', '"+objeto.getRazonSocial()+"', '"+objeto.getRut()+"', '"+objeto.getCiudad().getId()+"', 1)";
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
        strSQL = "UPDATE cliente SET nombre = '"+objeto.getNombre()+"', razonSocial = '"+objeto.getRazonSocial()+"', rut = '"+objeto.getRut()+"' WHERE id = " + objeto.getId();
        update();
        return true;
    }

    @Override
    public List<Cliente> listar(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        strSQL = "SELECT id, nombre, razonSocial, rut FROM cliente WHERE estado = 1";
        seleccionar();
        Cliente cliente;
        try {
            while(rs.next()){
                cliente = new Cliente(); 
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setRazonSocial(rs.getString("razonSocial"));
                cliente.setRut(rs.getString("rut"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    @Override
    public Cliente buscar(int rut) {
        Cliente cliente = null;
        Ciudad ciudad;
        strSQL = "SELECT nombre, razonSocial, rut, idCiudad FROM cliente WHERE cliente.rut = " + rut;
        seleccionar();
        try {
            if(rs.next()){
                cliente = new Cliente();
                ciudad = new Ciudad();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setRazonSocial(rs.getString("razonSocial"));
                cliente.setRut(rs.getString("rut"));
                ciudad.setId(rs.getInt("idCiudad"));
                cliente.setCiudad(ciudad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

   
    
}
