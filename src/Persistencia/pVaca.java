/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Categoria;
import Dominio.Raza;
import Dominio.Vaca;
import Servicios.IABM;
import Servicios.IBuscarListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Negro
 */
public class pVaca extends MySql implements IABM<Vaca>, IBuscarListar<Vaca>{    

    @Override
    public boolean alta(Vaca objeto) {
        strSQL = "INSERT INTO vaca (caravana, peso, fechaNacimiento, idRaza, idCategoria) VALUES ('"+objeto.getCaravana()+"', '"+objeto.getPeso()+"', '"+objeto.getFechaNacimiento()+"', '"+objeto.getRaza().getId()+"' , '"+objeto.getCategoria().getId()+"')";
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
        //strSQL = "UPDATE vaca SET caravana = " + objeto.getCaravana()+ ", peso = "+ objeto.getPeso()+", fechaNacimiento = " + objeto.getFechaNacimiento();
        strSQL = "UPDATE vaca SET caravana = " + objeto.getCaravana()+ ", peso = "+ objeto.getPeso()+ " WHERE id = "+ objeto.getId();
        update();
        return true;
    }

    @Override
    public List<Vaca> listar() {
        ArrayList<Vaca> listaVacas = listaVacas = new ArrayList();
        Vaca vaca;
        Raza raza;
        Categoria categoria;
        strSQL = "SELECT v.id, v.caravana, v.peso, v.fechaNacimiento, r.nombre, c.nombre FROM vaca v, categoria c, raza r WHERE v.idCategoria = c.id AND v.idRaza = r.id";
        seleccionar();
        try {
            while(rs.next()){
                
                vaca = new Vaca();
                categoria = new Categoria();
                raza = new Raza();
                vaca.setId(rs.getInt("v.id"));
                vaca.setCaravana(rs.getString("v.caravana"));
                vaca.setPeso(rs.getInt("v.peso"));
                vaca.setFechaNacimiento(rs.getDate("v.fechaNacimiento"));
                categoria.setNombre(rs.getString("c.nombre"));
                vaca.setCategoria(categoria); 
                raza.setNombre(rs.getString("r.nombre"));
                vaca.setRaza(raza);
                
                listaVacas.add(vaca);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaVacas;
    }

    @Override
    public Vaca buscar(int caravana) {
        Vaca vaca = null;
        Raza raza;
        Categoria categoria;
        strSQL = "SELECT v.caravana, v.peso, v.fechaNacimiento, r.nombre, c.nombre FROM vaca v, categoria c, raza r WHERE v.idCategoria = c.id AND v.idRaza = r.id AND v.caravana = " + caravana;
        seleccionar();
        try {
            if(rs.next()){
                vaca = new Vaca();
                categoria = new Categoria();
                raza = new Raza();
                vaca.setCaravana(rs.getString("v.caravana"));
                vaca.setPeso(rs.getInt("v.peso"));
                vaca.setFechaNacimiento(rs.getDate("v.fechaNacimiento"));
                categoria.setNombre(rs.getString("c.nombre"));
                vaca.setCategoria(categoria); 
                raza.setNombre(rs.getString("r.nombre"));
                vaca.setRaza(raza);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vaca;
    }

    
}
