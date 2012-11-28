package com.acme.training;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");
        
        MenuWS menuWS = context.getBean(MenuWS.class);
        
        Endpoint.publish("http://localhost:8081/menu", menuWS);
    }

}
