package com.epam.training;


import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Food;
import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;
import com.epam.training.service.InMemoryShoppingcart;
import com.epam.training.service.OrderService;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");
       InMemoryShoppingcart cart = ctx.getBean(InMemoryShoppingcart.class);
       
       cart.addFood(1, 1);
       cart.addFood(3, 2);
       cart.setCustomer("beluska");
       cart.setDeliveryAddress("Budapest", "FAszom utca 4", "666", "Ungarn");
       cart.setBillingaddress("Budapest", "FAszom utca 4", "666", "Ungarn");
       cart.checkOut();
       
       OrderService os = ctx.getBean(OrderService.class);
       LinkedList<Order> orders = os.getAllOrders();
      
       for(int i=0; i<orders.size(); i++){
           System.out.println(orders.get(i).getCustomer());
          System.out.println(orders.get(i).getDeliveryAddress());
          List<OrderItem> orderItems = orders.get(i).getOrderItems();
          
          for(int j=0; j<orderItems.size(); j++){
              Food food = orderItems.get(j).getFood();
              int quantity = orderItems.get(j).getQuantity();
              System.out.println(food.getName()+ "    " + food.getPrice() + "  q:" + quantity);
          }      
       }
    }
}

