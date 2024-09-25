package org.iesvdm.ejercicios.ejercicio5;

import org.iesvdm.ejercicios.ejercicio5.auxClasses.Price;

public class LineItem {
    //Atributos
    private Integer quantity;
    private Price price;
    private ShoppingCart shoppingCart;
    private Product product;
    private Order order;

    //Constructor
    public LineItem(Integer quantity, ShoppingCart shoppingCart, Product product, Order order) {
        this.quantity = quantity;
        this.price = new Price(product.getPrice().getValor() * quantity);
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.order = order;
    }

    //Getters y setters
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
