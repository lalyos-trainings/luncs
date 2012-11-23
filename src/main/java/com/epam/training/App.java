package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;
import com.epam.training.service.InMemoryOrderService;
import com.epam.training.service.OrderService;
import com.epam.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml",
                "orders.xml");

        ShoppingCart cart = appContext.getBean(ShoppingCart.class);
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
