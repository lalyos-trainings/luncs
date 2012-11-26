package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        MenuLister lister = ctx.getBean(MenuLister.class);

        String message = ctx.getMessage("welcome", null, new Locale("hu"));
        System.out.println(String.format("=== %s ===", message));
        lister.doList();

    }
}
