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
public class Tanque {
    private Integer id;
    private Integer numero;
    private Integer volumen;
    private Integer stock;
    
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    private Categoria categoria;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tanque(Integer id) {
        this.id = id;
    }
    
    public Tanque(Integer numero, Integer volumen, Integer stock, Categoria categoria) {
        this.numero = numero;
        this.volumen = volumen;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Tanque(Integer id, Integer numero, Integer volumen, Integer stock, Categoria categoria) {
        this.id = id;
        this.numero = numero;
        this.volumen = volumen;
        this.stock = stock;
        this.categoria = categoria;
    }
    
}
