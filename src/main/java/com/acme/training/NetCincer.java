package com.acme.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.InMemoryAFAService;
import com.acme.training.service.InMemoryNAVService;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class NetCincer
{
    /**
     * @param args
     */
    public static void main(String[] args)
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
        
        List<CustomerOrder> orders = orderService.getAllOrders();
        
        int i = 0;
        while (i < orders.size())
        {
            CustomerOrder order = orders.get(i);
            order.printBill();
            i++;
        }
        
        InMemoryStatisticService statistic = context.getBean(InMemoryStatisticService.class);
        statistic.printStatistic();

        InMemoryAFAService afa = context.getBean(InMemoryAFAService.class);
        afa.printAFA();

        InMemoryNAVService nav = context.getBean(InMemoryNAVService.class);
        nav.printNAV();
    }

}
