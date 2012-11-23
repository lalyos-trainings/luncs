package com.epam.training;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.epam.training.service.MenuLister;


public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
      
        @SuppressWarnings("deprecation")
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        
        MenuLister lister = factory.getBean(MenuLister.class);
        
        lister.doList();
        
    }

}
