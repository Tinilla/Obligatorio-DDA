/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Equipo
 */
public class TipoUsuario {
    private int id;
    private int nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario(int id) {
        this.id = id;
    }

    public TipoUsuario(int id, int nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
}
