package org.iesvdm.ejercicios.ejercicio4;

import java.math.BigDecimal;
import java.math.MathContext;

public class Posicion {

    //Atributtes
    private BigDecimal latitud;
    private BigDecimal longitud;
    private final BigDecimal RADIOTIERRAKM = new BigDecimal(6378);

    //Constructor
    public Posicion(BigDecimal latitud, BigDecimal longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    //Getters & Setters
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


    //Methods

    //Method to calculate the distance between tho places
    public static BigDecimal DistanciaKm(Posicion posOrigen, Posicion posDestino){
        //Calculate the difference between latittude and longittude
        BigDecimal diferenciaLats = enRadianes(posOrigen.latitud.subtract(posDestino.latitud));
        BigDecimal diferenciaLongs = enRadianes(posOrigen.longitud.subtract(posDestino.longitud));

        //Calculate the half of the square of the distance in a straight line
            //COnvert all BigDecimal to Double, calculate, then convert them to BigDecimal
        BigDecimal difLat = diferenciaLats.divide(BigDecimal.TWO, MathContext.DECIMAL128);
        Double difLatSin = difLat.doubleValue();
        //BigDecimal a = (Math.sin(difLatSin)).pow(2);


    }

    //Method to calculate a number in radians
    private static BigDecimal enRadianes(BigDecimal valor){
        return valor.multiply(new BigDecimal(Math.PI/180));
    }
    
}
