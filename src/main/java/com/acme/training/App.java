package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
       /* MenuLister lister = ctx.getBean(MenuLister.class);
        
        lister.doList();*/
               
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        OrderService orderService = ctx.getBean(InMemoryOrderService.class);
        cart.addFood(1,1);
        cart.addFood(2,2);
        cart.setDeliveryAddress(new Address("kuka", "kaka", "8000", "kiki"));
        cart.setBillingAddress(new Address("kuka", "kaka", "8000", "kiki"));
        cart.checkout(orderService);
           
        
        
        for(Order order : orderService.getAllOrders()){
            System.out.println(order.toString());
            for(OrderItem orderItem :order.getItemList()){
                System.out.println(orderItem);
            }
        }
          
    }

}
