package org.iesvdm.ejercicios.ejercicio5.auxClasses;

public class Price {
    //Atributos
    private double valor;

    //Constructor, verificando que sea positivo
    public Price(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.valor = valor;
    }

    //Getters y setters
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    //Metodo para formatear salida
    @Override
    public String toString() {
        return String.format("%.2f", valor); // Formateamos el precio con dos decimales
    }
}
