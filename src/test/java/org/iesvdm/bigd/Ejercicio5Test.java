package org.iesvdm.bigd;

import org.iesvdm.ejercicios.ejercicio5.*;
import org.iesvdm.ejercicios.ejercicio5.auxClasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio5Test {

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Account account1;
    private Account account2;
    private Account account3;
    private WebUser webUser1;
    private WebUser webUser2;
    private WebUser webUser3;
    private ShoppingCart shoppingCart1;
    private ShoppingCart shoppingCart2;
    private ShoppingCart shoppingCart3;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    public void setUp() {
        // Creamos varios customers
        customer1 = new Customer("idCustomer1", new Address("Calle1"), new Phone("123456789"), "email1@gmail.com");
        customer2 = new Customer("idCustomer2", new Address("Calle2"), new Phone("234567891"), "email2@gmail.com");
        customer3 = new Customer("idCustomer3", new Address("Calle3"), new Phone("345678912"), "email3@gmail.com");

        // Creamos varios accounts
        account1 = new Account("idAccount1", new Address("Avenida1"), false, new Date(), new Date());
        account2 = new Account("idAccount2", new Address("Avenida2"), false, new Date(), new Date());
        account3 = new Account("idAccount3", new Address("Avenida3"), false, new Date(), new Date());

        // Creamos varios WebUsers
        webUser1 = new WebUser("idUser1", "password1", UserState.ACTIVE, customer1);
        webUser2 = new WebUser("idUser2", "password2", UserState.ACTIVE, customer2);
        webUser3 = new WebUser("idUser3", "password3", UserState.ACTIVE, customer3);

        // Creamos varios shopping carts
        shoppingCart1 = new ShoppingCart(new Date(), account1, webUser1);
        shoppingCart2 = new ShoppingCart(new Date(), account2, webUser2);
        shoppingCart3 = new ShoppingCart(new Date(), account3, webUser3);

        product1 = new Product("idProduct1", "product1", new Supplier("idSupplier1", "supplier1"), new Price(BigDecimal.valueOf(100)));
        product2 = new Product("idProduct2", "product2", new Supplier("idSupplier2", "supplier2"), new Price(BigDecimal.valueOf(200)));
        product3 = new Product("idProduct3", "product3", new Supplier("idSupplier3", "supplier3"), new Price(BigDecimal.valueOf(300)));
    }

    @Test
    public void testCrearWebUserCustomerAccount() {
        // Validaciones para Customers
        assertNotNull(customer1);
        assertEquals("idCustomer1", customer1.getId());
        assertEquals("Calle1", customer1.getAddress().getAddressLine());

        assertNotNull(customer2);
        assertEquals("idCustomer2", customer2.getId());
        assertEquals("Calle2", customer2.getAddress().getAddressLine());

        assertNotNull(customer3);
        assertEquals("idCustomer3", customer3.getId());
        assertEquals("Calle3", customer3.getAddress().getAddressLine());

        // Validaciones para Accounts
        assertNotNull(account1);
        assertEquals("idAccount1", account1.getId());
        assertEquals("Avenida1", account1.getBilling_address().getAddressLine());

        assertNotNull(account2);
        assertEquals("idAccount2", account2.getId());
        assertEquals("Avenida2", account2.getBilling_address().getAddressLine());

        assertNotNull(account3);
        assertEquals("idAccount3", account3.getId());
        assertEquals("Avenida3", account3.getBilling_address().getAddressLine());

        // Validaciones para WebUsers
        assertNotNull(webUser1);
        assertEquals("idUser1", webUser1.getLogin_id());
        assertEquals(UserState.ACTIVE, webUser1.getState());

        assertNotNull(webUser2);
        assertEquals("idUser2", webUser2.getLogin_id());
        assertEquals(UserState.ACTIVE, webUser2.getState());

        assertNotNull(webUser3);
        assertEquals("idUser3", webUser3.getLogin_id());
        assertEquals(UserState.ACTIVE, webUser3.getState());

        // Validaciones para ShoppingCarts
        assertNotNull(shoppingCart1);
        assertEquals(account1, shoppingCart1.getAccount());
        assertEquals(webUser1, shoppingCart1.getWebUser());

        assertNotNull(shoppingCart2);
        assertEquals(account2, shoppingCart2.getAccount());
        assertEquals(webUser2, shoppingCart2.getWebUser());

        assertNotNull(shoppingCart3);
        assertEquals(account3, shoppingCart3.getAccount());
        assertEquals(webUser3, shoppingCart3.getWebUser());
    }

    @Test
    public void testCrearProductos() {

        BigDecimal price1 = BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP);
        BigDecimal price2 = BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP);
        BigDecimal price3 = BigDecimal.valueOf(300).setScale(2, RoundingMode.HALF_UP);

        product1 = new Product("idProduct1", "product1", new Supplier("idSupplier1", "supplier1"), new Price(price1));
        product2 = new Product("idProduct2", "product2", new Supplier("idSupplier2", "supplier2"), new Price(price2));
        product3 = new Product("idProduct3", "product3", new Supplier("idSupplier3", "supplier3"), new Price(price3));

        // Afirmaciones para verificar que los productos se han creado correctamente
        assertNotNull(product1);
        assertEquals("idProduct1", product1.getId());
        assertEquals("product1", product1.getName());
        assertEquals("idSupplier1", product1.getSupplier().getId());
        assertEquals(price1, product1.getPrice().getValor());

        assertNotNull(product2);
        assertEquals("idProduct2", product2.getId());
        assertEquals("product2", product2.getName());
        assertEquals("idSupplier2", product2.getSupplier().getId());
        assertEquals(price2, product2.getPrice().getValor());

        assertNotNull(product3);
        assertEquals("idProduct3", product3.getId());
        assertEquals("product3", product3.getName());
        assertEquals("idSupplier3", product3.getSupplier().getId());
        assertEquals(price3, product3.getPrice().getValor());
    }

    @Test
    public void testAgregarProductosAShoppingCartYCrearOrderYPaymentAsociadosAShoppingCart() {
        // Creamos los orders
        Order order1 = new Order("idOrder1", new Date(), new Date(), new Address("Edf1"), OrderStatus.SHIPPED, new Real(BigDecimal.valueOf(100)), account1);
        Order order2 = new Order("idOrder2", new Date(), new Date(), new Address("Edf2"), OrderStatus.NEW, new Real(BigDecimal.valueOf(200)), account2);
        Order order3 = new Order("idOrder3", new Date(), new Date(), new Address("Edf3"), OrderStatus.CLOSED, new Real(BigDecimal.valueOf(300)), account3);

        // Añadimos los orders a las cuentas
        account1.addOrder(order1);
        account2.addOrder(order2);
        account3.addOrder(order3);

        // Creamos los payments asociados a los orders
        Payment payment1 = new Payment("payment1", new Date(), new Real(BigDecimal.valueOf(100)), "detalles pago 1", account1, order1);
        Payment payment2 = new Payment("payment2", new Date(), new Real(BigDecimal.valueOf(200)), "detalles pago 2", account2, order2);
        Payment payment3 = new Payment("payment3", new Date(), new Real(BigDecimal.valueOf(300)), "detalles pago 3", account3, order3);

        // Añadimos los payments a las cuentas
        account1.addPayment(payment1);
        account2.addPayment(payment2);
        account3.addPayment(payment3);

        // Creamos los lineitems
        LineItem lineItem1 = new LineItem(3, shoppingCart1, product1, order1);
        LineItem lineItem2 = new LineItem(2, shoppingCart2, product2, order2);
        LineItem lineItem3 = new LineItem(1, shoppingCart3, product3, order3);

        // Añadimos los productos a los carritos de compras
        shoppingCart1.addLineItem(lineItem1);
        shoppingCart2.addLineItem(lineItem2);
        shoppingCart3.addLineItem(lineItem3);

        // Comprobamos que los productos están asociados a los shoppingcarts
        assertEquals(1, shoppingCart1.getLineItems().size());
        assertEquals(lineItem1, shoppingCart1.getLineItems().getFirst());

        assertEquals(1, shoppingCart2.getLineItems().size());
        assertEquals(lineItem2, shoppingCart2.getLineItems().getFirst());

        assertEquals(1, shoppingCart3.getLineItems().size());
        assertEquals(lineItem3, shoppingCart3.getLineItems().getFirst());

        //Comprobamos que los orders estan asociados a los shoppingcarts
        assertEquals(1, shoppingCart1.getAccount().getOrders().size());
        assertEquals(order1, shoppingCart1.getAccount().getOrders().getFirst());

        assertEquals(1, shoppingCart2.getAccount().getOrders().size());
        assertEquals(order2, shoppingCart2.getAccount().getOrders().getFirst());

        assertEquals(1, shoppingCart3.getAccount().getOrders().size());
        assertEquals(order3, shoppingCart3.getAccount().getOrders().getFirst());

        //Comprobamos que los payments estan asociados a los shoppingcarts
        assertEquals(1, shoppingCart1.getAccount().getPayments().size());
        assertEquals(payment1, shoppingCart1.getAccount().getPayments().getFirst());

        assertEquals(1, shoppingCart2.getAccount().getPayments().size());
        assertEquals(payment2, shoppingCart2.getAccount().getPayments().getFirst());

        assertEquals(1, shoppingCart3.getAccount().getPayments().size());
        assertEquals(payment3, shoppingCart3.getAccount().getPayments().getFirst());
    }

}
