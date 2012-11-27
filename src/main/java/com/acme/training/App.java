package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.service.InMemoryNAVService;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.InMemoryStatisticsService;
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
        ShoppingCart cart3 = ctx.getBean(InMemoryShoppingCart.class);
        OrderService os = ctx.getBean(InMemoryOrderService.class);
        os.doOrder(cart.withBillingAddress(new Address("1122", "Csaba utca"))
                .withDeliveryAddress(new Address("1122", "Csaba utca"))
                .withCustomer("Sztike")
                .withFood("KFC", "csirkeszarny", 1)
                .withFood("Csing-csang", "szezamos csirke", 2)
                .withFood("KFC", "csirkeszarny", 2)
                .withFood(4, 1)
                .checkOut());
        os.doOrder(cart2.withBillingAddress(new Address("1234", "Ize utca"))
                .withDeliveryAddress(new Address("1234", "Ize utca"))
                .withCustomer("Gizi")
                .withFood("Csing-csang", "leves", 1)
                .withFood("Csing-csang", "leves", 1)
                .withFood("KFC", "csirkeszarny", 1)
                .withFood("Csing-csang", "edes-savanyu", 3)
                .withFood("Csing-csang", "szezamos csirke", 5)
                .checkOut());
        os.doOrder(cart3.withBillingAddress(new Address("1234", "Ize utca"))
                .withDeliveryAddress(new Address("1234", "Ize utca"))
                .withCustomer("Jani")
                .withFood("Csing-csang", "csirkecomb", 1)
                .withFood("KFC", "csirkecomb", 1)
                .checkOut());
        for(Order order : os.getAllOrders()){
            System.out.println(order);
            System.out.println();
        }

        InMemoryStatisticsService statisticService = ctx.getBean(InMemoryStatisticsService.class);
        statisticService.printStatistics();

        InMemoryNAVService navService = ctx.getBean(InMemoryNAVService.class);
        navService.printIncome();

    }
}
