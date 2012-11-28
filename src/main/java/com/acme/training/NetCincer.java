package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.NavService;
import com.acme.training.service.ShoppingCart;

public class NetCincer {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.withCustomer("lalyos")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(101)
        .withFood(102, 2)
        .withFood(202, 3)
        .withFood(101, 1)
        .checkout();
        System.out.println(" **************** Print bill ****************** ");
        cart.getCustomerOrder().printBill();
        System.out.println(" ********************************************** ");

        ShoppingCart cart1 = ctx.getBean(ShoppingCart.class);
        cart1.withCustomer("jeno")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(102, 5)
        .withFood(202, 1)
        .checkout(); 
        System.out.println(" **************** Print bill ****************** ");
        cart1.getCustomerOrder().printBill();
        System.out.println(" ********************************************** ");
        
        /* Now printing with printBill
        OrderService orderService = ctx.getBean("InMemoryOrderService",OrderService.class);
        for (CustomerOrder order : orderService.getAllOrder()) {
            System.out.println("- next order:" + order);
        }
        */
        
        InMemoryStatisticService statisticService = ctx.getBean(InMemoryStatisticService.class);
        statisticService.printStatistic();
        
        NavService serv=ctx.getBean(NavService.class);
        serv.printTotal();
    }

}
