package org.iesvdm.ejercicios.ejercicio5.auxClasses;

public class Address {
    //Atributo
    private String addressLine;

    //Constructor
    public Address(String addressLine) {
        this.addressLine = addressLine;
    }

    //Getters y setters
    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @Override
    public String toString() {
        return addressLine;

    }
}