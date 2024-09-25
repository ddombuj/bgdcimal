package org.iesvdm.bigd;

import org.iesvdm.ejercicios.ejercicio5.*;
import org.iesvdm.ejercicios.ejercicio5.auxClasses.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio5Test {

    public Customer customer1 = new Customer("Customer1", new Address("Calle1"), new Phone("662170597"), "customer@example.com");
    public Account account1 = new Account("acc1", new Address("Calle2"), false, new Date(), new Date());
    public WebUser webUser = new WebUser("webUser1", "password", UserState.NEW);

    @Test
    public void testCreacionEntidades() {
        // Crear un WebUser
        WebUser webUser = new WebUser("user1", "password123", UserState.NEW);
        assertNotNull(webUser);

        // Crear un Customer asociado al WebUser
        Customer customer = new Customer("customer1", new Address("Calle2"),
                new Phone("123456789"), "email@example.com");
        customer.setWebUser(webUser);

        assertNotNull(customer);
        assertEquals(webUser, customer.getWebUser());

        // Crear una Account asociada al Customer
        Account account = new Account("account1", new Address("Calle3"), false, new Date(), null);
        customer.setAccount(account);
        assertNotNull(account);
        account.setCustomer(customer);
        assertEquals(customer, account.getCustomer());
    }

    @Test
    public void testCreateProduct() {
        // Define test data
        String testId = "PROD123";
        String testName = "Tornillos";
        Supplier testSupplier = new Supplier("1", "Proveedor A");
        Price testPrice = new Price(10.99);

        // Create a Product object
        Product product = new Product(testId, testName, testSupplier, testPrice);

        // Verify object creation and attribute values
        assertNotNull(product, "Product object should not be null");
        assertEquals(testId, product.getId(), "Product ID should match");
        assertEquals(testName, product.getName(), "Product name should match");
        assertEquals(testSupplier, product.getSupplier(), "Product supplier should match");
        assertEquals(testPrice, product.getPrice(), "Product price should match");
    }

    @Test
    public void testAddProductToShoppingCart() {
        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart(new Date(), account1, webUser);

        // Create a Product object
        Product product = new Product("PROD123", "Tornillos", new Supplier("1", "Proveedor A"), new Price(10.99));

        // Create the associated order
        Order order = new Order("1", new Date(), new Date(), new Address("Calle4"), OrderStatus.NEW, new Real("20"), account1);

        // Create a line item for the product
        LineItem lineItem = new LineItem(3, shoppingCart, product, order);

        shoppingCart.addLineItem(lineItem);

        // With the public method "containsProduct" in ShoppingCart class, we assess if the product has been added
        boolean contains = shoppingCart.containsProduct(product);

        assertTrue(contains);
    }

    @Test
    public void testCreateOrderAndPaymentToShoppingCart() {
        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart(new Date(), account1, webUser);

        // Create an Order
        Order order = new Order("1", new Date(), new Date(), new Address("Calle4"), OrderStatus.NEW, new Real("20"), account1);

        // Create a payment
        Payment payment = new Payment("1", new Date(), new Real("20"), "Entregar por la mañana", account1, order);

        account1.addOrder(order);
        account1.addPayment(payment);

        // We now assess if the sopping cart has associated the order and the payment
        boolean orderAssociated = shoppingCart.getAccount().getOrders().contains(order);
        boolean paymentAssociated = shoppingCart.getAccount().getPayments().contains(payment);

        assertTrue(orderAssociated);
        assertTrue(paymentAssociated);

    }


}
