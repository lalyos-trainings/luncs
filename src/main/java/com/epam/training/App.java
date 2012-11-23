package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "meki.xml");
        
        MenuLister lister = context.getBean(MenuLister.class);
        
        lister.doList();


    }

}
