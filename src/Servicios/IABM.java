/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Equipo
 */
public interface IABM<T> extends IBuscarListar<T> {
    boolean alta(T objeto);
    boolean baja (int id);
    boolean modificar(T objeto);
}
