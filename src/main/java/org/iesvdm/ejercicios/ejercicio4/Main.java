package org.iesvdm.ejercicios.ejercicio4;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //Creamos la posición de Igualada con latitud y longitud en BigDecimal
        Posicion igualada = new Posicion(BigDecimal.valueOf(41.57879),  BigDecimal.valueOf(1.617221));
        //Creamos la posición de Granada con latitud y longitud en BigDecimal
        Posicion granada = new Posicion(BigDecimal.valueOf(37.176487), BigDecimal.valueOf(-3.597929));

        //Calculamos la distancia en kilómetros entre Igualada y Granada
        BigDecimal distancia = Posicion.calcularDistanciaKm(igualada, granada);

        //Imprimimos la distancia en kilómetros
        System.out.println("Distancia entre Igualada y Granada: " + distancia + " Km");
    }
    
}

