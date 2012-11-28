package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.OrderItem;
import com.acme.training.service.InMemoryNavService;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml",
                "orders.xml");

        ShoppingCart cart = appContext.getBean(ShoppingCart.class);
        cart.withCustomer("jeno")
            .withDeliveryAddress(new Address("Futo utca 47", "Budapest", "1082", "H"))
            .withFood(2, 2)
            .withFood(4, 4)
            .checkout();

        OrderService os = appContext.getBean(InMemoryOrderService.class);

        for (CustomerOrder o : os.getOrders()) {
            for (OrderItem oi : o.getItems()) {
                System.out.println(String.format("food: %-25s %5s", oi.getFood()
                                                                      .getName(), oi.getQuantity()));
            }
        }

        InMemoryStatisticService ss = appContext.getBean(InMemoryStatisticService.class);
        ss.printStatistics();

        InMemoryNavService ns = appContext.getBean(InMemoryNavService.class);
        ns.printVat();
    }
}
