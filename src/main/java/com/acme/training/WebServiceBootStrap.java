package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.InMemoryOrderWS;
import com.acme.training.ws.InMemoryShoppingCartWS;
import com.acme.training.ws.MenuWS;
import com.acme.training.ws.OrderWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        MenuWS menuWS = ctx.getBean(MenuWS.class);
        ShoppingCartWS cartWS = ctx.getBean(InMemoryShoppingCartWS.class);
        OrderWS orderWS = ctx.getBean(InMemoryOrderWS.class);
                
        InetAddress localHost = InetAddress.getLocalHost();
        String menuUrl = "http://localhost:8080/menu";
        String shopUrl = "http://localhost:8080/shop";
        String orderUrl = "http://localhost:8080/order";
        System.out.println("Listenng on: " + menuUrl);
        System.out.println("Listenng on: " + shopUrl);
        System.out.println("Listenng on: " + orderUrl);
        Endpoint.publish(menuUrl, menuWS);
        Endpoint.publish(shopUrl, cartWS);
        Endpoint.publish(orderUrl, orderWS);
    }

}
