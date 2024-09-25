package org.iesvdm.bigd;

import org.iesvdm.ejercicios.ejercicio4.Posicion;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ejercicio4Test {
    @Test
    public void testDistanciaKm() {
        //Creamos dos posiciones
        Posicion igualada = new Posicion(BigDecimal.valueOf(41.57879), BigDecimal.valueOf(1.617221));
        Posicion granada = new Posicion(BigDecimal.valueOf(37.176487), BigDecimal.valueOf(-3.597929));

        //Calculamos la distancia esperada
        BigDecimal distanciaEsperada = new BigDecimal("664.20"); // Ajusta según el resultado correcto

        //Calculamos la distancia usando el método de la clase Posicion
        BigDecimal distanciaCalculada = Posicion.calcularDistanciaKm(igualada, granada);

        //Comparamos los resultados
        assertEquals(distanciaEsperada.setScale(2, RoundingMode.HALF_EVEN),
                distanciaCalculada.setScale(2, RoundingMode.HALF_EVEN));    }
}
