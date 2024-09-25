package org.iesvdm.ejercicios.ejercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuesto {

    //Una persona invierte un ‘monto principal’ en una cuenta de ahorro que produce un % de interés dado.

    //Suponiendo que todo el interés se deposita en la cuenta, calcula y muestra el monto de dinero en la cuenta al final de ‘n’ años.

    //Use la siguiente fórmula para determinar los montos anuales:
    //c = p(1 +r)^n

    //en donde

    //p es el monto que se invirtió originalmente (es decir, el monto principal)
    //r es la tasa de interés anual (por ejemplo, use 0.05 para el 5%)
    //n es el número de años
    //c es la cantidad depositada al final del año enésimo.

    //Nota: operaciones a 10 decimales con redondeo bancario HALF_EVEN.

    public static void main(String[] args) {
        BigDecimal principal = new BigDecimal("100"); //100 euros iniciales
        BigDecimal interes = new BigDecimal("0.05"); //5% de interes
        Integer years = 5; //5 años

        BigDecimal montoFinal = calcularMonto(principal, interes, years);

        System.out.println("Tras " + years + " años con un interés del " +
                (interes.multiply(BigDecimal.valueOf(100))) + "% tendrá " + montoFinal + "€"); //llamada al metodo y muestra por terminal

    }

    /**
     * Metodo que calcula el monto final transcurrido los años indicados y aplicado el interes indicado
     */
    public static BigDecimal calcularMonto (BigDecimal principal, BigDecimal interes, Integer years) {
        //Aplicamos la formula que se indica al inicio del script
        BigDecimal depositoFinal = principal.multiply((interes.add(BigDecimal.ONE)).pow(years));
        //Aplicamos la precisión para que tenga 10 decimales, y haga el redondeo bancario (HALF_EVEN)
        depositoFinal = depositoFinal.setScale(10, RoundingMode.HALF_EVEN);
        return depositoFinal;
    }





}
