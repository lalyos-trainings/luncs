

    package com.acme.training;

    import java.util.List;

    import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.service.InMemoryRestaurantRepository;
import com.acme.training.service.MenuLister;
import com.acme.training.service.OrderService;
import com.acme.training.service.RestaurantRepository;
import com.acme.training.service.ShoppingCart;
import com.acme.training.service.SysoutMenuLister;

    public class previousApps {

        /**
    * @param args
    */
        public static void main(String[] args) {
        /*   RestaurantRepository repo = new InMemoryRestaurantRepository();
            SysoutMenuLister lister = new SysoutMenuLister();
            lister.setRepo(repo);
            lister.doList(); */
        //   XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
            
            ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
            
//            ApplicationContext ctx = new ClassPathXmlApplicationContext("csing.xml");
//            System.out.println("beans: " +ctx.getBeanDefinitionCount());
          // Object bean = factory.getBean("repo");
          // RestaurantRepository repo = (RestaurantRepository) bean;
         //  RestaurantRepository repo = factory.getBean("repo", RestaurantRepository.class);
           // w/o "repo" it works too
//           MenuLister lister = factory.getBean(MenuLister.class);
          
             MenuLister lister = ctx.getBean(MenuLister.class);
            
            lister.doList();
           
        //   System.out.println("# of restaureants: " + repo.getAllRestaurants().size());
          // System.out.println("beans: " + factory.getBeanDefinitionNames());
//           RestaurantRepository rrr = ctx.getBean(RestaurantRepository.class);
           
           ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans.xml");
           
           ShoppingCart s_cart = ctx2.getBean(ShoppingCart.class);
           
           // pacal_id=3 ; csirke_id=7;
           /*
           s_cart.addFood(3, 1);
           s_cart.addFood(7, 2);
           
           s_cart.setCustomerName("Gipsz Jakab");
           s_cart.setDeliveryAddress(new Address("Futo 35", "Budapest", "1082", "Hungary"));
           s_cart.setBillingAddress(s_cart.getDeliveryAddress());

           Order current_o = s_cart.checkout();
//           System.out.println(current_o);
           
           OrderService order_s = ctx2.getBean(OrderService.class);
           
           order_s.doOrder(current_o);
           
           List<Order> list = order_s.getAllOrders();
           
           for ( Order o : list) {
               System.out.println(o);
           }
           */
           
        }

    }


