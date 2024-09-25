package org.iesvdm.ejercicios.ejercicio1;

import java.math.BigInteger;

//Obtener el factorial de un numero con BigInteger -> !7 = 1 * 2 * 3... * 6 * 7 = 5040
public class Factorial {

    public static void main(String[] args) {
        //Hacemos la llamada al metodo y lo mostramos por pantalla
        BigInteger initialNumber = new BigInteger("7");
        System.out.println(factorial(initialNumber));
    }


    /**
     * Creamos el metodo estatico que se encargará de calcular el factorial del número que le pasemos como parámetro
     */
    public static BigInteger factorial(BigInteger number) {
        BigInteger result = BigInteger.ONE; //Inicializamos el resultado
        while(number.compareTo(BigInteger.ZERO) > 0){ //Mientras sea posible factorizar | el numero dado sea mayor a 0
            result = result.multiply(number); //Se multiplica el resultado que teniamos almacenado por el siguiente numero
            number = number.subtract(BigInteger.ONE); //Restamos 1 al numero dado para pasar al siguiente numero más pequeño
        }

        return result; //Retornamos el resultado
    }
}








