/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Negro
 */
public class Categoria {
    private Integer id;
    private String nombre;
    private Integer costo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String nombre, Integer costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }
    
}
