package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Address;
import org.iesvdm.ejercicios.ejercicio5.auxClasses.Real;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    //Atributos
    private String number;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private Real total;
    private Account account;
    private final List<LineItem> lineItems = new ArrayList<>(); // Lista ordenada de LineItems
    private final List<Payment> payments = new ArrayList<>(); // Lista ordenada de payments


    //Constructor
    public Order(String number, Date ordered, Date shipped, Address ship_to, OrderStatus status, Real total, Account account) {
        this.number = number;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.status = status;
        this.total = total;
        this.account = account;
    }

    //Getters y setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Real getTotal() {
        return total;
    }

    public void setTotal(Real total) {
        this.total = total;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    //Metodos
    public void addLineItem(LineItem item) {
        // Verificar si el item ya existe en la lista
        if (!lineItems.contains(item)) {
            lineItems.add(item);
        } else {
            updateLineItemQuantity(item, item.getQuantity());
        }
    }

    public void updateLineItemQuantity(LineItem itemToUpdate, int newQuantity) {
        for (LineItem item : lineItems) {
            if (item.equals(itemToUpdate)) {
                item.setQuantity(item.getQuantity() + newQuantity);
                return; // Salimos del bucle una vez que encontramos el artículo
            }
        }
        // Si no se encuentra el artículo, lanzamos una excepcion
        throw new IllegalArgumentException("Artículo no encontrado en el carrito");
    }

    public void addPayment(Payment payment) {
        // Verificar si el item ya existe en la lista
        if (!payments.contains(payment)) {
            payments.add(payment);
        }
    }
}
