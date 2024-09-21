package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;
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
        BigDecimal p = new BigDecimal("100"); //100 euros iniciales
        BigDecimal r = new BigDecimal("0.05"); //5% de interes
        Integer n = 5; //5 anos
        BigDecimal c = BigDecimal.ONE; //resultado

        System.out.println(calcularMonto(p, r, n)); //llamada al metodo

    }

    //Metodo que calcula el monto final transcurrido los anos y aplicado el interes
    public static BigDecimal calcularMonto (BigDecimal p, BigDecimal r, Integer n) {

        BigDecimal c = p.multiply((r.add(BigDecimal.ONE)).pow(n));
        c = c.setScale(10, RoundingMode.HALF_EVEN);
        return c;
    }





}
