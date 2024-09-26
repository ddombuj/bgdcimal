package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class Account {
    //Atributos
    private String id;
    private Address billing_address;
    private boolean is_closed;
    private Date open;
    private Date closed;
    //Un account tiene un shopping cart
    private ShoppingCart shoppingCart;
    //Un account tiene una lista de orders
    private final LinkedHashSet<Order> orders;
    // Un Account puede tener 0 o más Payments
    private final List<Payment> payments;


    //Constructor
    public Account(String id, Address billing_address, boolean is_closed, Date open, Date closed) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.orders = new LinkedHashSet<>();
        this.payments = new ArrayList<>();
    }


    //Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(Address billing_address) {
        this.billing_address = billing_address;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }





    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
        payment.setAccount(this);
    }


    //Metodo para obtener la lista de orders
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    //Metodo que añade un order
    public void addOrder(Order order) {
        orders.add(order);
    }

}
