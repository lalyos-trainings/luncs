package com.epam.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.service.MenuLister;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml");

        MenuLister lister = appContext.getBean(SysoutMenuLister.class);

        lister.doList();
    }

}
