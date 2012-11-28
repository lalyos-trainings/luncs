package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.InMemoryShoppingCartWS;
import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        MenuWS menuWS = ctx.getBean(MenuWS.class);
        InMemoryShoppingCartWS inMemoryShoppingCartWS = ctx.getBean(InMemoryShoppingCartWS.class);
                
        InetAddress localHost = InetAddress.getLocalHost();
        String menuUrl = "http://localhost:8080/menu";
        String shoppingUrl = "http://localhost:8080/shopping";
        System.out.println("Listenng on: " + menuUrl);
        System.out.println("Listenng on: " + shoppingUrl);
        Endpoint.publish(menuUrl, menuWS);
        Endpoint.publish(shoppingUrl, inMemoryShoppingCartWS);
        
    }

}
