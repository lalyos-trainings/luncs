package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml",
                "orders.xml");

        ShoppingCart cart = appContext.getBean("cart", ShoppingCart.class);
        cart.addFood(2, 2);
        cart.addFood(4, 4);
        cart.checkout();

        OrderService os = appContext.getBean(InMemoryOrderService.class);

        for (Order o : os.getOrders()) {
            for (OrderItem oi : o.getOrderItems()) {
                System.out.println(String.format("food: %-25s %5s", oi.getFood().getName(), oi.getQuantity()));
            }
        }
    }
}
