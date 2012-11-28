package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        ShoppingCartWS shoppingCartWS = ctx.getBean(ShoppingCartWS.class);

        InetAddress localHost = InetAddress.getLocalHost();
        String url = "http://" + localHost.getHostAddress() + ":8080/shoppingCartWS";
        System.out.println("Listenng on: " + url);
        Endpoint.publish(url, shoppingCartWS);

    }

}
