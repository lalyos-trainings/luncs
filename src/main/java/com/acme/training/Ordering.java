package com.acme.training;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;
import com.acme.training.service.InMemoryShoppingcart;
import com.acme.training.service.OrderService;

public class Ordering {

    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");
       InMemoryShoppingcart cart = ctx.getBean(InMemoryShoppingcart.class);
       
       cart.addFood(1, 1);
       cart.addFood(3, 2);
       cart.setCustomer("beluska");
       cart.setDeliveryAddress("Budapest", "KAKI utca 4", "666", "Ungarn");
       cart.setBillingaddress("Budapest", "KAKI utca 4", "666", "Ungarn");
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


