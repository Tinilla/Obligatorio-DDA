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
public class CalculoPrecioA implements ICalculoPrecio{
    private static int porCostoCuidados = 5;
    private static int porCostoAlimentacion = 15;
    private static int porCostoAdicional = 2;
    private static int promedioUltimasVacas;
    private static CalculoPrecioA instancia;
    
    private CalculoPrecioA(){
        
    }
    
    public static CalculoPrecioA getInstancia(){
        instancia = new CalculoPrecioA();
        return instancia;
    }
    
    public
    @Override
    public int calcularPrecioLeche(int costoNeto) {
        int suma = costoNeto;
        suma += costoNeto * porCostoCuidados / 100;
        suma += costoNeto * porCostoAlimentacion / 100;
        
    }
    
}
