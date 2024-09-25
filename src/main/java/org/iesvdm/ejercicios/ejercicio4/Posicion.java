package org.iesvdm.ejercicios.ejercicio4;

import java.math.BigDecimal;
import java.math.MathContext;

public class Posicion {

    // Atributos
    private BigDecimal latitud; // Coordenada de latitud
    private BigDecimal longitud; // Coordenada de longitud
    public final static BigDecimal RADIO_TIERRA_KM = new BigDecimal(6378); // Radio de la Tierra en kilómetros

    // Constructor
    public Posicion(BigDecimal latitud, BigDecimal longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters & Setters
    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    // Métodos

    /**
     * Método para calcular la distancia en km entre dos posiciones
     * @param posOrigen Posición de origen
     * @param posDestino Posición de destino
     * @return Distancia en kilómetros
     */
    public static BigDecimal calcularDistanciaKm(Posicion posOrigen, Posicion posDestino) {
        // Calculamos la diferencia entre latitudes y longitudes en radianes
        BigDecimal diferenciaLatitudes = enRadianes(posDestino.latitud.subtract(posOrigen.latitud));
        BigDecimal diferenciaLongitudes = enRadianes(posDestino.longitud.subtract(posOrigen.longitud));

        // Calculamos la mitad del cuadrado de la distancia en línea recta
        // Convertimos todos los BigDecimal a double para hacer cálculos trigonométricos
        double mediaDiferenciaLat = (diferenciaLatitudes.divide(BigDecimal.TWO, MathContext.DECIMAL128)).doubleValue();
        double latitudOrigenRad = (enRadianes(posOrigen.latitud)).doubleValue();
        double latitudDestinoRad = (enRadianes(posDestino.latitud)).doubleValue();
        double mediaDiferenciaLon = (diferenciaLongitudes.divide(BigDecimal.TWO, MathContext.DECIMAL128)).doubleValue();

        // Aplicamos la fórmula del cálculo de la distancia Haversine
        double distanciaHaversine = alCuadrado(Math.sin(mediaDiferenciaLat))
                + (Math.cos(latitudOrigenRad))
                * (Math.cos(latitudDestinoRad))
                * alCuadrado(Math.sin(mediaDiferenciaLon));

        // Calculamos el ángulo central
        double anguloCentral = 2 * Math.atan2(Math.sqrt(distanciaHaversine), Math.sqrt(1 - distanciaHaversine));

        // Convertimos el resultado a BigDecimal
        BigDecimal newAnguloCentral = BigDecimal.valueOf(anguloCentral);

        // Devolvemos la distancia multiplicada por el radio de la Tierra
        return RADIO_TIERRA_KM.multiply(newAnguloCentral, MathContext.DECIMAL128);
    }

    // Método para convertir un valor en grados a radianes
    private static BigDecimal enRadianes(BigDecimal valor) {
        return valor.multiply(new BigDecimal(Math.PI / 180), MathContext.DECIMAL128);
    }

    // Método para elevar un número al cuadrado
    public static double alCuadrado(double valor) {
        return Math.pow(valor, 2);
    }
}
