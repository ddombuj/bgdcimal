package org.iesvdm.ejercicios.ejercicio5.auxClasses;

import java.util.regex.Pattern;

public class Phone {
    //Atributos
    private String phoneNumber;
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d{9}"); // Ejemplo de patrón para números de 9 dígitos

    //Constructor
    public Phone(String phoneNumber) {
        if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }
        this.phoneNumber = phoneNumber;
    }

    //Getters y setters
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;

    }
}