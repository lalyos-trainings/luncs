package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.service.OrderLister;
import com.acme.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Food.setApplicationContext(new ClassPathXmlApplicationContext("foods.xml"));
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.addFood("csirke", 2);
        cart.addFood("husleves", 1);
        Address addr = new Address("Futó utca 47.", "Budapest", "1082", "Hungary");
        cart.setBillingAddress(addr);
        cart.setDeliveringAddress(addr);
        cart.checkout("E. Systems");
        
        cart = ctx.getBean(ShoppingCart.class);
        cart.addFood("csirke", 20);
        cart.addFood("husleves", 10);
        addr = new Address("Király utca 1.", "Budapest", "1082", "Hungary");
        cart.setBillingAddress(addr);
        cart.setDeliveringAddress(addr);
        cart.checkout("VP");
        
        System.out.println(ctx.getMessage("welcome", null, new Locale("hu")));
        
        OrderLister lister = ctx.getBean(OrderLister.class);
        lister.doList();
    }


}
