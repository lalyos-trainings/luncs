package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;
import com.acme.training.service.SystemOutMenuLister;

public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing-csang.xml");
        
        System.out.println(ctx.getMessage("welcome", null, new Locale("hu")));
        System.out.println();

        MenuLister menuLister = ctx.getBean("menuLister", SystemOutMenuLister.class);
        menuLister.doList();
        
        ShoppingCart cart = ctx.getBean("shoppingCart1", InMemoryShoppingCart.class);
//        cart.addFood("KFC", "csirkeszarny", 1);
//        cart.addFood("csing-csang", "szezamos csirke", 2);
        OrderService os = ctx.getBean("orderService", InMemoryOrderService.class);
        os.doOrder(cart.withBillingAddress(new Address("1122", "Csaba utca"))
                .withDeliveryAddress(new Address("1122", "Csaba utca"))
                .withCustomer("Sztike")
                .withFood("csirkeszarny", 1)
                .withFood("szezamos csirke", 2)
                .withFood("csirkeszarny", 2)
                .checkOut());
        for(Order order : os.getAllOrders()){
            order.setApplicationContext(ctx);
            System.out.println(order);
        }
    }
}
