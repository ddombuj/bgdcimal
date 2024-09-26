package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Address;
import org.iesvdm.ejercicios.ejercicio5.auxClasses.Phone;

public class Customer {
    //Atributos
    private String id;
    private Address address;
    private Phone phone;
    private String email;
    private Account account; //En clase Account no hay referencia a Customer por su relacion de composición


    //Constructor
    public Customer(String id, Address address, Phone phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
