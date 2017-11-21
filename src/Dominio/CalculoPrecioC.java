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
public class CalculoPrecioC implements ICalculoPrecio{
    private static int porCostoCuidadosAlimentacion = 12;
    private static int resta = 5;
    private static CalculoPrecioC instancia;
    @Override
    public int calcularPrecioLeche(int costoNeto) {
        int suma = costoNeto;
        suma += costoNeto * porCostoCuidadosAlimentacion / 100;
        int peso = Tambo.getInstancia().pesoPromedioC();
        if(peso < 650){
            suma = suma - (suma * 5 / 100);
        }
        return suma;
    }
    
}
