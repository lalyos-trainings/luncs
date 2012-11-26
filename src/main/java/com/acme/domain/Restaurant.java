package com.acme.domain;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Restaurant implements ApplicationContextAware {

    private String name;
    private Address address;
    private Menu menu;
    private ApplicationContext ctx;
    
    public Restaurant(String name, String street, String zip) {
        this.name = name;
        this.address = new Address(street, "Budapest", zip, "Hungary");        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public String toString(){
        String nextRestMsg = ctx.getMessage("rest.next", null, new Locale("hu"));
        return String.format("%s %-20s %n %s",nextRestMsg, name, address);
    }
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    
}
