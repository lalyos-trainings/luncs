package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.ShoppingCart;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "tao.xml", "csing.xml");

        MenuLister lister = ctx.getBean(MenuLister.class);
        lister.doList();

        OrderService orderservice = ctx.getBean(OrderService.class);
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);

        cart.setOrderservice(orderservice);
        cart.addFood(1, 1);
        cart.addFood(2, 2);
        cart.setCustomer("Jozsi");
        cart.setDeliveryAddress(new Address("Lonyay 24", "Budapest", "1093", "Hungary"));
        cart.checkout();

        lister.printOrders(orderservice.getAllOrders());

    }
}
