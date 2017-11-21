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
public class CalculoPrecioB implements ICalculoPrecio{
    private static int porCostoCuidados = 3;
    private static int porCostoAlimentacion = 10;
    private static int porCostoAdicional = 1;
    private static int resta = 5;
    private static CalculoPrecioB instancia;
    @Override
    public int calcularPrecioLeche(int costoNeto) {
        int suma = costoNeto;
        int peso = Tambo.getInstancia().pesoPromedioB();
        suma += costoNeto * porCostoCuidados / 100;
        suma += costoNeto * porCostoAlimentacion /100;
        suma += peso * porCostoAdicional / 100;
        if(peso < 600){
            suma = suma - (suma * resta / 100);
        }
        return suma;
    }
    
}
