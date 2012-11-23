package com.epam.training;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.epam.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/beans.xml"));
        MenuLister lister = factory.getBean(MenuLister.class);
        
        lister.doList();
        
    }

}
