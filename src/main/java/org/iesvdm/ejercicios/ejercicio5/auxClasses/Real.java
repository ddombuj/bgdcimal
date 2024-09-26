package org.iesvdm.ejercicios.ejercicio5.auxClasses;

import java.math.BigDecimal;

public class Real {
    //Atributos
    private BigDecimal value;

    //Constructores
    public Real(BigDecimal value) {
        this.value = value;
    }

    public Real(String value) {
        this.value = new BigDecimal(value);
    }

    //Getters y setters
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    //Metodo para mostrar el valor en string
    @Override
    public String toString() {
        return value.toString();
    }
}