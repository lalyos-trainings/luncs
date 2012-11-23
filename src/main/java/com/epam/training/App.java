package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.service.MenuLister;
import com.epam.training.service.ShoppingCart;

public class App 
{
    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
       
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        
        // TODO 
        
//      cart.setCustomer()
//      cart.setDeliveryAddress(street, city, zip, country)
//      cart.setBillingAddress(street, city, zip, country)
//      
//      cart.addFood(foodId, quantity)
        
        MenuLister lister = context.getBean(MenuLister.class);
        
        lister.doList();
    }

}
