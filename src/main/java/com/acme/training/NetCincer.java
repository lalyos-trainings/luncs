package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.service.NavService;
import com.acme.training.service.ShoppingCart;

public class NetCincer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.withCustomer("lalyos")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(101) //250
        .withFood(102, 2) //500
        .withFood(202, 3) //1350
        .withFood(101, 1) // 250
        .checkout();

        ShoppingCart cart1 = ctx.getBean(ShoppingCart.class);
        cart1.withCustomer("jeno")
        .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
        .withFood(102, 5) //1250
        .withFood(202, 1) //450
        .checkout();

//        OrderService orderService = ctx.getBean(OrderService.class);
//        for (Order order : orderService.getAllOrder()) {
//            System.out.println("- next order:" + order);
//        }
        
        NavService  ns = ctx.getBean(NavService.class);
        ns.printIncomes();
    }

}
