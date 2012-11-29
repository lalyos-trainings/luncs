package com.acme.training.webservices;

import java.net.InetAddress;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebServiceBootStrap {
    
    public static void main(String[] args) throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "meki.xml");
        
        InetAddress ownIP=InetAddress.getLocalHost();
        
        MenuWeb menu = context.getBean(MenuWeb.class);
        String url = "http://"+ownIP.getHostAddress()+":8080/menu";
        System.out.println(url);
        Endpoint.publish(url, menu);
        
    }

}
