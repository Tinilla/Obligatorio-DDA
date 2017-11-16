/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Usuario;

/**
 *
 * @author Equipo
 */
public interface IUsuario {
    boolean verificar(Usuario elUsuario);
}
