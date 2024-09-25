package org.iesvdm.ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
    //Atributos
    private Date created;
    private Account account;
    private WebUser webUser;
    private final List<LineItem> lineItems = new ArrayList<>(); // Lista ordenada de LineItems


    //Constructor
    public ShoppingCart(Date created, Account account, WebUser webUser) {
        this.created = created;
        this.account = account;
        this.webUser = webUser;
    }

    //Getters y setters
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
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

    public boolean containsProduct(Product product) {
        for (LineItem lineItem : lineItems) {
            if (product.equals(lineItem.getProduct())) {
                return true;
            }
        }
        return false;
    }


}
