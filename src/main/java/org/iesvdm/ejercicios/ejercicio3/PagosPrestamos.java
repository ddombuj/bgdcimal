package org.iesvdm.ejercicios.ejercicio3;

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
        BigDecimal pmt = BigDecimal.ONE; //Pago mensual, se inicializa temporalmente
        BigDecimal prestamo = new BigDecimal("200000"); //Monto del préstamo original (principal)
        BigDecimal interesAnual = new BigDecimal("5"); //Interés anual del 5%
        BigDecimal interesMensual = convertirInteresAnualMensual(interesAnual); //Interés mensual calculado
        Integer meses = 360; //Número total de meses (30 años = 360 meses)

        //Mostramos los valores iniciales
        System.out.println("Prestamo: " + prestamo + "€");
        System.out.println("Tasa de interes anual: " + interesAnual + "%");

        //Calculamos el pago mensual usando la fórmula y mostramos el resultado redondeado a 2 decimales
        pmt = (calcularPagoMensual(prestamo, interesMensual, meses));
        System.out.println("Pago mensual: " + pmt.setScale(2, RoundingMode.HALF_EVEN) + "€");

        //Imprimimos la cabecera del esquema de amortización

        System.out.println("\nEsquema de amortizacion" +
                "\n-----------------------");
        System.out.println("Mes\t Pago\t\t Principal \t Interes \t Balance");
        int contadorMes = 1; //Variable para llevar el conteo de los meses

        //Bucle que simula los pagos de los meses, hasta que se termine de pagar
        while(prestamo.compareTo(BigDecimal.ZERO) > 0) {
            //Calculamos el interés del mes actual
            BigDecimal intereses = calcularPagoInteres(prestamo, interesMensual);
            //Calculamos el pago principal (parte del pago mensual que se destina a reducir el préstamo)
            BigDecimal pagoPrincipal = calcularPagoPrincipal(pmt, intereses);

            // Si el saldo del préstamo es menor que el pago principal, ajustamos para evitar que el saldo sea negativo
            if (pagoPrincipal.compareTo(prestamo) > 0) {
                pagoPrincipal = prestamo;  //Pago solo lo que queda del préstamo
            }

            //Reducimos el saldo restante del préstamo
            prestamo = reducirSaldo(prestamo, pagoPrincipal);

            //Mostramos los valores del mes actual: pago, principal, interés, y saldo restante
            System.out.println(contadorMes + " \t "
                    + pmt.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + pagoPrincipal.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + intereses.setScale(2, RoundingMode.HALF_EVEN) + " \t "
                    + prestamo.setScale(2, RoundingMode.HALF_EVEN));

            contadorMes++; //Incrementamos el mes
        }



    }

    /**
     * Funcion que calcula el pago correspondiente a los intereses en un mes dado
     */
    private static BigDecimal convertirInteresAnualMensual(BigDecimal interes){
        BigDecimal meses = new BigDecimal("12"); //12 meses en un año
        interes = interes.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_EVEN); //Convertimos el porcentaje en decimal (5% -> 0.05)
        return interes.divide(meses, 10, RoundingMode.HALF_EVEN); //Dividimos el interés anual entre 12 para obtener el mensual
    }

    /**
     * Funcion que calcula el pago mensual usando la fórmula del préstamo amortizable
     * @param prestamo
     * @param interes
     * @param meses
     * @return
     */
    private static BigDecimal calcularPagoMensual(BigDecimal prestamo, BigDecimal interes, Integer meses){
        BigDecimal monto = prestamo.multiply(interes); //Multiplicamos el monto del préstamo por la tasa de interés mensual

        //Calculamos el divisor: (1 + r)^-n
        BigDecimal divisor = BigDecimal.ONE.add(interes); //Sumamos 1 al interés mensual
        divisor = divisor.pow(-meses, MathContext.DECIMAL128); //Elevamos al exponente negativo para obtener (1 + r)^-n
        divisor = BigDecimal.ONE.subtract(divisor); //Restamos 1 al resultado: 1 - (1 + r)^-n

        //Dividimos el monto entre el divisor para obtener el pago mensual
        monto = monto.divide(divisor, 10 , RoundingMode.HALF_EVEN);
        return monto;
    }


    /**
     * Funcion que calcula el pago correspondiente a los intereses en un mes dado
     */
    private static BigDecimal calcularPagoInteres(BigDecimal prestamo, BigDecimal interes){
        return prestamo.multiply(interes); //Multiplica el saldo del préstamo por el interés mensual
    }

    /**
     * Funcion que calcula el pago al principal, que es el pago total menos el pago de intereses
     * @param pmt
     * @param interes
     * @return
     */
    private static BigDecimal calcularPagoPrincipal(BigDecimal pmt, BigDecimal interes){
        return pmt.subtract(interes); //Restamos los intereses del pago mensual para obtener el principal pagado
    }

    /**
     * Funcion que reduce el saldo del préstamo restando el monto pagado al principal
     * @param prestamo
     * @param pagoPrincipal
     * @return
     */
    private static BigDecimal reducirSaldo(BigDecimal prestamo, BigDecimal pagoPrincipal){
        return prestamo.subtract(pagoPrincipal); //Restamos el pago principal del saldo del préstamo
    }



}
