package com.acme.training;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Order;
import com.acme.training.service.InMemoryAFAService;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;
import com.acme.training.ws.MenuWS;

public class App 
{
    private static void netCincer()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
        
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
        
        InMemoryStatisticService statistic = context.getBean(InMemoryStatisticService.class);
        statistic.printStatistic();

        InMemoryAFAService nav = context.getBean(InMemoryAFAService.class);
        nav.doAFA();
}
    
    private static void lister()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
        
        MenuLister lister = context.getBean(MenuLister.class);
        lister.doList();
    }
    
    private static void menuWS()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
        
        MenuWS menuWS = context.getBean(MenuWS.class);
        
        Endpoint.publish("http://localhost:8081/menu", menuWS);
    }
    
    public static void main(String[] args) 
    {
//      lister();
//        netCincer();
        menuWS();
    }

}
