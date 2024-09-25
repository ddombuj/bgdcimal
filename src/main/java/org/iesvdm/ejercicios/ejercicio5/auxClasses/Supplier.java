package org.iesvdm.ejercicios.ejercicio5.auxClasses;

public class Supplier {
    //Atributos
    private String id;
    private String name;

    // Constructor
    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters y setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}