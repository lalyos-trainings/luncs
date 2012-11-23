package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Address;
import com.epam.training.domain.ShoppingCart;
import com.epam.training.service.MenuLister;
import com.epam.training.service.OrderService;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * RestaurantRepository repo = new InMemoryRestaurantRepository();
         * SysoutMenuLister lister = new SysoutMenuLister();
         * lister.setRepo(repo);
         * 
         * lister.doList();
         */

        /*
         * BeanFactory factory = new XmlBeanFactory(new
         * ClassPathResource("beans.xml"));
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "tao.xml", "csing.xml");
        /*
         * Object bean = factory.getBean("repo"); RestaurantRepository repo =
         * (RestaurantRepository) bean;
         */

        /*
         * RestaurantRepository repo = factory.getBean("repo",
         * RestaurantRepository.class);
         */
        MenuLister lister = ctx.getBean(MenuLister.class);
        lister.doList();

        OrderService orderservice = ctx.getBean(OrderService.class);
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);

        cart.setOrderservice(orderservice);
        cart.addFood(1, 1);
        cart.addFood(2, 2);
        cart.setCustomer("Jozsi");
        cart.setDeliveryAddress(new Address("Lonyay 24", "Budapest", "1093", "Hungary"));
        cart.checkout();

        lister.printOrders(orderservice.getAllOrders());

    }
}
