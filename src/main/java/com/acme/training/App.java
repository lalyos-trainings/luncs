package com.acme.training;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Order;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class App 
{
    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
     
        String message = context.getMessage("welcome", null, new Locale("hu", "HU"));
        
        System.out.println(String.format("=== %s ===", message));
        
        MenuLister lister = context.getBean(MenuLister.class);
        lister.doList();
        
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        
        cart.setCustomer("János");
        cart.setDeliveryAddress("Harcsa utca 17.", "Talak", "6352", "HU");
        cart.setBillingAddress("Harcsa utca 17.", "Talak", "6352", "HU");

        cart.addFood(5, 2);
        cart.addFood(1, 4);

        cart.checkout();

        OrderService orderService = context.getBean(OrderService.class);
        
        List<Order> orders = orderService.getAllOrders();
        
        int i = 0;
        while (i < orders.size())
        {
            Order order = orders.get(i);
            System.out.println(String.format("%d. order:%n%s", (i+1), order));
            i++;
        }
        
        cart = context.getBean(ShoppingCart.class);
        cart = context.getBean(ShoppingCart.class);
        cart = context.getBean(ShoppingCart.class);
        
    }

}
