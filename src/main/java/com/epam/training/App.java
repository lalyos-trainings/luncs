package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.service.OrderLister;
import com.epam.training.service.ShoppingCart;

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
        cart.checkout("Epam Systems");
        
        OrderLister lister = ctx.getBean(OrderLister.class);
        lister.doList();
    }


}
