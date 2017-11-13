/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Negro
 */
public class Factura {
    private Integer id;
    private Date fecha;
    private Integer total;
    private Cliente cliente;
    private List<ItemCompra> listaItemns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCompra> getListaItemns() {
        return listaItemns;
    }

    public void setListaItemns(List<ItemCompra> listaItemns) {
        this.listaItemns = listaItemns;
    }
    
}
