package org.iesvdm.ejercicios.ejercicio5.auxClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {
    // Atributos
    private BigDecimal valor;

    // Constructor, verificando que sea positivo
    public Price(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);  // Redondeo a dos decimales
    }

    // Constructor que acepta double
    public Price(double valor) {
        this(BigDecimal.valueOf(valor));  // Convierte el double a BigDecimal y usa el otro constructor
    }

    // Getters y setters
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);  // Redondeo a dos decimales
    }

    public void setValor(double valor) {
        setValor(BigDecimal.valueOf(valor));
    }

    // Método para formatear salida
    @Override
    public String toString() {
        return valor.setScale(2, RoundingMode.HALF_UP).toString();  // Formateamos el precio con dos decimales
    }
}
