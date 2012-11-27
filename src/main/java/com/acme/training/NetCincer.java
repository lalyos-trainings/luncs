package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class NetCincer {

    /**
* @param args
*/
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.withCustomer("lalyos")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(101)
        .withFood(102, 2)
        .withFood(202, 3)
        .withFood(101, 1)
        .checkout();
        
        OrderService orderService = ctx.getBean(OrderService.class);
        for (Order order : orderService.getAllOrder()) {
            System.out.println("- next order:" + order);
        }
    }

}