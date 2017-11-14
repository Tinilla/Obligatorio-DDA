/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.List;

/**
 *
 * @author Equipo
 */
public interface IBuscarListar <T>{
    List<T> listar();
    T buscar(int id);
}
