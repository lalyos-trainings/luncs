package com.acme.training;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;
import com.acme.training.service.InMemoryAFAService;
import com.acme.training.service.InMemoryShoppingcart;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.OrderService;

public class Ordering {

    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");
       InMemoryShoppingcart cart = ctx.getBean(InMemoryShoppingcart.class);
       InMemoryStatisticService statService = ctx.getBean(InMemoryStatisticService.class);
       InMemoryAFAService NAVService = ctx.getBean(InMemoryAFAService.class);
       
       cart.addFood(1, 1);
       cart.addFood(3, 2);
       cart.setCustomer("beluska");
       cart.setDeliveryAddress("Budapest", "KAKI utca 4", "666", "Ungarn");
       cart.setBillingaddress("Budapest", "KAKI utca 4", "666", "Ungarn");
       cart.checkOut();
       
       OrderService os = ctx.getBean(OrderService.class);
       LinkedList<CustomerOrder> orders = os.getAllOrders();
      
       for(int i=0; i<orders.size(); i++){
          System.out.println(orders.get(i).getCustomer());
          System.out.println(orders.get(i).getDeliveryAddress());
          Map<String, RestaurantOrder> restaurantOrders = orders.get(i).restaurantOrders();
          for (RestaurantOrder value : restaurantOrders.values()) {
              Collection<OrderItem> orderItems = value.getOrderItems();
              for (OrderItem orderItem : orderItems) {
                  System.out.println("{" + orderItem.getFood().getRestaurant().getName() + "}  " +
                          orderItem.getFood() + "  q: " + orderItem.getQuantity());                 
              }
          }    
       }
             
       statService.printStat();
       NAVService.doNAVStatistics();

    }
}


