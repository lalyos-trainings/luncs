package com.acme.training;

//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;

import com.acme.training.domain.Order;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;
import com.acme.training.service.SystemOutMenuLister;
//import com.acme.training.service.LoggerMenuLister;

public class App 
{
    public static void main( String[] args )
    {
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
//
////        MenuLister menuLister = factory.getBean("menuLister", LoggerMenuLister.class);
//        MenuLister menuLister = factory.getBean("menuLister", SystemOutMenuLister.class);
//        menuLister.doList();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing-csang.xml");
        MenuLister menuLister = ctx.getBean("menuLister", SystemOutMenuLister.class);
        menuLister.doList();
        
        ShoppingCart cart = ctx.getBean("shoppingCart1", InMemoryShoppingCart.class);
//        cart.addFood("KFC", "csirkeszarny", 1);
//        cart.addFood("csing-csang", "szezamos csirke", 2);
        cart.addFood("csirkeszarny", 1);
        cart.addFood("szezamos csirke", 2);
        OrderService os = ctx.getBean("orderService", InMemoryOrderService.class);
        os.doOrder(cart.checkOut());
        for(Order order : os.getAllOrders()){
            System.out.println(order);
        }
    }
}
