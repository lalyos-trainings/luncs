package com.acme.training;

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
        
        MenuLister menuLister = ctx.getBean(SystemOutMenuLister.class);
        menuLister.doList();
        
        ShoppingCart cart = ctx.getBean(InMemoryShoppingCart.class);
        ShoppingCart cart2 = ctx.getBean(InMemoryShoppingCart.class);
//        cart.addFood("KFC", "csirkeszarny", 1);
//        cart.addFood("csing-csang", "szezamos csirke", 2);
        OrderService os = ctx.getBean(InMemoryOrderService.class);
        OrderService os2 = ctx.getBean(InMemoryOrderService.class);
        os.doOrder(cart.withBillingAddress(new Address("1122", "Csaba utca"))
                .withDeliveryAddress(new Address("1122", "Csaba utca"))
                .withCustomer("Sztike")
                .withFood("csirkeszarny", 1)
                .withFood("szezamos csirke", 2)
                .withFood("csirkeszarny", 2)
                .checkOut());
        os.doOrder(cart2.withBillingAddress(new Address("1234", "Ize utca"))
                .withDeliveryAddress(new Address("1234", "Ize utca"))
                .withCustomer("Gizi")
                .withFood("leves", 1)
                .withFood("leves", 1)
                .withFood("edes-savanyu", 3)
                .checkOut());
        for(Order order : os.getAllOrders()){
            System.out.println(order);
            System.out.println();
        }

//        System.out.println("OS2:");
//        for(Order order : os2.getAllOrders()){
//            System.out.println(order);
//            System.out.println();
//        }
    }
}
