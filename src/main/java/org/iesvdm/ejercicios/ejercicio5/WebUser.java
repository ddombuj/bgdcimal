package org.iesvdm.ejercicios.ejercicio5;

public class WebUser {
    //Atributos
    private String login_id;
    private String password;
    private UserState state;
    private Customer customer;

    //Constructor - con el objeto Customer como parametro, ya que es una relacion unidireccional
    public WebUser(String loginId, String password, UserState state, Customer customer) {
        this.login_id = loginId;
        this.password = password;
        this.state = state;
        this.customer = customer;
    }

    //Getters y setters
    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
