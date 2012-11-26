package com.acme;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.domain.Order;
import com.acme.domain.OrderItem;
import com.acme.service.MenuLister;
import com.acme.service.OrderService;
import com.acme.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "ching.xml", "kfc.xml", "order1.xml");

        // ApplicationContext ctx = new
        // ClassPathXmlApplicationContext("ching.xml");
        MenuLister lister = ctx.getBean(MenuLister.class);

        lister.doList();
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.addFood(1, 1);
        cart.addFood(2, 1);
        cart.checkout();
        
        OrderService orderService = ctx.getBean(OrderService.class);
        Collection<Order> allOrders = orderService.getAllOrders();
        
        for (Order o: allOrders){
          System.out.println("-------------------------------------");
          System.out.println("Your order has the foll. details:");
          System.out.println("Customer:"+o.getCustomer());
          System.out.println("Delivery address:"+o.getDeliveryAddress());
          System.out.println("Billing address:"+o.getBillingAddress());
          System.out.println("Order Items:");
          for (OrderItem oi: o.getOrderItems()){
              System.out.println(oi);
          }
          System.out.println("-------------------------------------");
        }
    }

}
