package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.NavService;
import com.acme.training.service.OrderService;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.ShoppingCart;

public class NetCincer {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        ShoppingCart cart = ctx.getBean(InMemoryShoppingCart.class);
        cart.withCustomer("lalyos")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(101)
        .withFood(102, 2)
        .withFood(202, 3)
        .withFood(101, 1)
        .checkout();

        ShoppingCart cart1 = ctx.getBean(InMemoryShoppingCart.class);
        cart1.withCustomer("jeno")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(102, 5)
        .withFood(202, 1)
        .checkout();

        OrderService orderService = ctx.getBean(OrderService.class);
        System.out.println("This OS is "+orderService+" hashcode: "+orderService.hashCode());
        for (CustomerOrder order : orderService.getAllOrder()) {
            System.out.println("- next order:" + order);
            order.printBill();
        }
        
        InMemoryStatisticService statisticService = ctx.getBean(InMemoryStatisticService.class);
        statisticService.printStatistic();
        
        NavService navService = ctx.getBean(NavService.class);
        System.out.println("Total VAT: " + navService.getTotalVAT());
    }

}
