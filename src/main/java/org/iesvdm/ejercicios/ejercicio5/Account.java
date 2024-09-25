package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    //Atributos
    private String id;
    private Address billing_address;
    private boolean is_closed;
    private Date open;
    private Date closed;
    private Customer customer;
    private ShoppingCart shoppingCart;
    private Order order;
    private final List<Payment> payments = new ArrayList<>(); // Lista ordenada de payments
    private final List<Order> orders = new ArrayList<>(); // Lista ordenada de orders


    //Constructor
    public Account(String id, Address billing_address, boolean is_closed, Date open, Date closed) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
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


    //Atributos que son opcionales y/o no estan incluidos en el constructor

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //Metodos
    public void addOrder(Order order) {
        // Verificar si el order ya existe en la lista
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public void addPayment(Payment payment) {
        // Verificar si el payment ya existe en la lista
        if (!payments.contains(payment)) {
            payments.add(payment);
        }
    }
}
