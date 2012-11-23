package com.epam.training;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.epam.training.service.MenuLister;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        MenuLister lister = factory.getBean(SysoutMenuLister.class);

        lister.doList();
    }

}
