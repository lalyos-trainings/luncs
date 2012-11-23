package com.epam.training;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.epam.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        MenuLister lister = context.getBean(MenuLister.class);
        
        lister.doList();


    }

}
