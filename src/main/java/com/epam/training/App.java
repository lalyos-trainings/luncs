package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.service.MenuLister;

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
    }

}
