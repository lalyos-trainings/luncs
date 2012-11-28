package com.acme.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.domain.RegistrationException;
import com.acme.training.service.InMemoryRegistrationService;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.NavService;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class NetCincer {

    private static Logger logger = LoggerFactory.getLogger(ShoppingCart.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        InMemoryRegistrationService inMemoryRegistrationService = ctx.getBean(InMemoryRegistrationService.class);
        inMemoryRegistrationService.registerUser("lalyos", new Address("Futo utca 47", "Budapest", "1082", "H"));
        inMemoryRegistrationService.registerUser("jeno", new Address("Kinizsi utca 19", "Nagyteteny", "2154", "D"));
        
        ShoppingCart cart1 = ctx.getBean(ShoppingCart.class);
        try {
            cart1.withCustomer("lalyos")
                .withFood(101)
                .withFood(102, 2)
                .withFood(202, 3)
                .withFood(101, 1)
                .checkout();
        } catch (RegistrationException e) {
            /* user not registered */
            logger.error("Issue: " + e.toString());
        }

        ShoppingCart cart2 = ctx.getBean(ShoppingCart.class);
        try {
            cart2.withCustomer("jeno")
                .withFood(102, 5)
                .withFood(202, 1)
                .checkout();
        } catch (RegistrationException e) {
            /* user not registered */
            logger.error("Issue: " + e.toString());
        }


        OrderService orderService = ctx.getBean(OrderService.class);
        for (Order order : orderService.getAllOrder()) {
            System.out.println("- next order:" + order);
        }
        
        InMemoryStatisticService statisticService = ctx.getBean(InMemoryStatisticService.class);
        statisticService.printStatistic();
        
        NavService navService = ctx.getBean(NavService.class);
        System.out.println("Total VAT: " + navService.getTotalVAT());
    }

}
