package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Price;
import org.iesvdm.ejercicios.ejercicio5.auxClasses.Supplier;

public class Product {
    //Atributos
    private String id;
    private String name;
    private Supplier supplier;
    private Price price;

    //Constructor
    public Product(String id, String name, Supplier supplier, Price price) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    //Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
