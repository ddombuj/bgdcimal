package org.iesvdm.ejercicios.ejercicio1;

import java.math.BigInteger;

//Obtener el factorial de un numero con BigInteger -> !7 = 1 * 2 * 3... * 6 * 7 = 5040
public class Factorial {

    public static void main(String[] args) {
        //Hacemos la llamada al metodo y lo mostramos por pantalla
        BigInteger n = new BigInteger("7");
        System.out.println(factorial(n));
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        while(n.compareTo(BigInteger.ZERO) > 0){
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
}








