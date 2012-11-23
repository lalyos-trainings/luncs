package com.epam.training;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.epam.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        MenuLister lister = factory.getBean(MenuLister.class);
        
        lister.doList();


    }

}
