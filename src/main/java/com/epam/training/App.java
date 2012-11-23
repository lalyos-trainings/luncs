package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Address;
import com.epam.training.domain.Order;
import com.epam.training.service.InMemoryOrderService;
import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.InMemoryShoppingCart;
import com.epam.training.service.MenuLister;
import com.epam.training.service.OrderService;
import com.epam.training.service.RestaurantRepository;
import com.epam.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "ching.xml", "kfc.xml");

        // ApplicationContext ctx = new
        // ClassPathXmlApplicationContext("ching.xml");
        MenuLister lister = ctx.getBean(MenuLister.class);

        lister.doList();

        ShoppingCart shoppingCart = new InMemoryShoppingCart(new Order(), new InMemoryRestaurantRepository());
        shoppingCart.addFood(1, 1);
        shoppingCart.addFood(2, 1);
        shoppingCart.setCustomer("Tunde");
        shoppingCart.setBillingAddress(new Address("Corvin", "Budapest", "1085", "Magyarorszag"));
        shoppingCart.setDeliveryAddress(new Address("Corvin", "Budapest", "1085", "Magyarorszag"));

        shoppingCart.checkout();

    }

}
