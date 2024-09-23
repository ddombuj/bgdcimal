package org.iesvdm.ejercicios.ejercicio4;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Posicion igualada = new Posicion(BigDecimal.valueOf(41.57879),  BigDecimal.valueOf(1.617221));
        Posicion granada = new Posicion(BigDecimal.valueOf(37.176487), BigDecimal.valueOf(-3.597929));
    
        BigDecimal distancia = Posicion.DistanciaKm(igualada, granada);  
        System.out.println(distancia);  
    }
    
}

