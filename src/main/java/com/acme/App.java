package com.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.domain.Address;
import com.acme.domain.Order;
import com.acme.domain.OrderItem;
import com.acme.service.InMemoryNAVService;
import com.acme.service.InMemoryStatisticService;
import com.acme.service.MenuLister;
import com.acme.service.OrderService;
import com.acme.service.ShoppingCart;
import com.acme.ws.MenuWS;

public class App {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "ching.xml", "kfc.xml", "order1.xml");

        MenuLister lister = ctx.getBean(MenuLister.class);
        
        lister.doList();
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.addFood(1, 1);
        cart.addFood(2, 1);
        cart.setCustomer("Tunde");
        cart.setBillingAddress(new Address("Corvin Street", "Budapest", "1085", "Hungary"));
        cart.setDeliveryAddress(new Address("Corvin Street", "Budapest", "1085", "Hungary"));
        cart.checkout();
        
        ShoppingCart cart1 = ctx.getBean(ShoppingCart.class);
        cart1.addFood(1, 1);
        cart1.addFood(2, 1);
        cart1.setCustomer("Tunde");
        cart1.setBillingAddress(new Address("Corvin Street", "Budapest", "1085", "Hungary"));
        cart1.setDeliveryAddress(new Address("Corvin Street", "Budapest", "1085", "Hungary"));
        cart1.checkout();
        
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
        
        InMemoryStatisticService statisticService = ctx.getBean(InMemoryStatisticService.class);
        statisticService.printStatistic();
        
        InMemoryNAVService navService = ctx.getBean(InMemoryNAVService.class);
        navService.printTotalVAT();
        
        //TODO Collection<> getRestaurantBills(), getOrderItemByRest()
        //restaurantOrders Map<String, Collection<OrderItem>> in Order class
        //create Small Order classes for each restaurant and big Order(Customer Order) class for the overall Order including all small Orders(Restaurant Order)
        //orderEventet megvaltoztatni -> nem Order lesz benne, hanem CustomerOrder
        //textfile-ba leirni, ha olyan dontest kell hozni, ami nincs benne a specifikacioban
        
        MenuWS menuWS = ctx.getBean(MenuWS.class);
        InetAddress localHost = InetAddress.getLocalHost();
       //Endpoint.publish("http://"+localHost.getHostAddress()+":8080/menu", menuWS );
        Endpoint.publish("http://localhost:8080/menu", menuWS );
    }
    

}
