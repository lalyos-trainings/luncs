package com.acme.training;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.MenuLister;

public class App {

    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");
       
       MenuLister lister = ctx.getBean(MenuLister.class);
       lister.doList();

    }
}

