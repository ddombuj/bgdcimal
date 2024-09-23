package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PagosPrestamos {

    //Formula para calcular el pago mensual PMT de un prestamos amortizable

    //PMT = (P x r) / (1 - (1 + r)^-n)

    //PMT: Es el pago mensual (o periódicamente, según la frecuencia de pagos).
    //P: Es el principal o monto original del préstamo.
    //r: Es la tasa de interés mensual. Si la tasa de interés anual es del 5%, el valor mensual es 0.05/12
    //n: Es el número total de pagos (en meses). Para un préstamo a 30 años, sería 30×12=360  meses.

    public static void main(String[] args) {
        BigDecimal pmt = BigDecimal.ONE; //pago mensual
        BigDecimal prestamo = new BigDecimal("200000"); //monto inicial
        BigDecimal interesAnual = new BigDecimal("5"); //interes anual 5/100 = 0.05%
        BigDecimal interesMensual = convertirInteresAnualMensual(interesAnual); //interes mensual 0.05/12 = 0.00416667
        Integer meses = 360; //meses de pago, 30 anos seria 30 x 12 = 360

        System.out.println("Prestamo: " + prestamo + "€");
        System.out.println("Tasa de interes anual: " + interesAnual + "%");
        pmt = (calcularPagoMensual(prestamo, interesMensual, meses));
        System.out.println("Pago mensual: " + pmt.setScale(2, RoundingMode.HALF_EVEN) + "€");

        System.out.println("\nEsquema de amortizacion" +
                "\n-----------------------");
        System.out.println("Mes\t Pago\t\t Principal \t Interes \t Balance");
        int contadorMes = 1;
        while(contadorMes <= 10){
        //while(pmt.compareTo(BigDecimal.ZERO) > 0){

            BigDecimal intereses = calcularPagoInteres(prestamo, interesMensual);
            BigDecimal pagoPrincipal = calcularPagoPrincipal(pmt, intereses);
            prestamo = reducirSaldo(prestamo, pagoPrincipal);

            System.out.println(contadorMes + " \t "
                    + pmt.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + pagoPrincipal.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + intereses.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + prestamo.setScale(2, RoundingMode.HALF_EVEN));

            contadorMes++;
        }



    }

    private static BigDecimal convertirInteresAnualMensual(BigDecimal r){
        BigDecimal meses = new BigDecimal("12");
        r = r.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_EVEN);
        return r.divide(meses, 10, RoundingMode.HALF_EVEN);
    }

    private static BigDecimal calcularPagoMensual(BigDecimal prestamo, BigDecimal interes, Integer meses){
        BigDecimal monto = BigDecimal.ONE;
        //Calculamos el dividendo
        monto = (prestamo.multiply(interes));

        //Calculamos el divisor
        BigDecimal divisor = BigDecimal.ONE.add(interes);
        divisor = divisor.pow(-meses, MathContext.DECIMAL128); // Eleva al exponente positivo
        divisor = BigDecimal.ONE.subtract(divisor); //0.7762

        //Realizamos la operacion final (dividendo/divisor)
        monto = monto.divide(divisor, 10 , RoundingMode.HALF_EVEN);
        return monto;
    }


    private static BigDecimal calcularPagoInteres(BigDecimal prestamo, BigDecimal interes){
        return prestamo.multiply(interes);
    }

    private static BigDecimal calcularPagoPrincipal(BigDecimal pmt, BigDecimal interes){
        return pmt.subtract(interes);
    }

    private static BigDecimal reducirSaldo(BigDecimal prestamo, BigDecimal pagoPrincipal){
        return prestamo.subtract(pagoPrincipal);
    }



}
