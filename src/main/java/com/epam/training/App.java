package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.service.MenuLister;
import com.epam.training.service.RestaurantRepository;


public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {      
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml","ching.xml","kfc.xml");
        
      //  ApplicationContext ctx = new ClassPathXmlApplicationContext("ching.xml");
        MenuLister lister = ctx.getBean(MenuLister.class);
        
        lister.doList();
        
   
    }

}
