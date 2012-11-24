package com.epam.training;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.epam.training.domain.Address;
import com.epam.training.domain.Order;
import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.MenuLister;
import com.epam.training.service.OrderService;
import com.epam.training.service.RestaurantRepository;
import com.epam.training.service.ShoppingCart;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
* @param args
*/
    public static void main(String[] args) {
  
        // restaurant menus
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
//        MenuLister lister = ctx.getBean(MenuLister.class);
//        lister.doList();
       
        // order
       
       ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans.xml");
       
       ShoppingCart s_cart = ctx2.getBean(ShoppingCart.class);
       
       // pacal_id=3 ; csirke_id=7;
       
       s_cart.addFood(3, 1);
       s_cart.addFood(7, 2);
       
       s_cart.setCustomerName("Gipsz Jakab");
       s_cart.setDeliveryAddress(new Address("Futo 35", "Budapest", "1082", "Hungary"));
       s_cart.setBillingAddress(s_cart.getDeliveryAddress());

       Order current_o = s_cart.checkout();
       
       OrderService order_s = ctx2.getBean(OrderService.class);
       
       order_s.doOrder(current_o);
       
       List<Order> list = order_s.getAllOrders();
       
       for ( Order o : list) {
           System.out.println(o);
       }
       
       
    }

}
