package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap
{
    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "csingCsung.xml", "kfc.xml");

        InetAddress localHost = InetAddress.getLocalHost();
        String host = localHost.getHostAddress();

        String menuUrl = "http://" + host + ":8081/menu";
        MenuWS menuWS = context.getBean(MenuWS.class);
        Endpoint.publish(menuUrl, menuWS);

        String shoppingCartUrl = "http://" + host + ":8081/shoppingcart";
        ShoppingCartWS shoppingCartWS = context.getBean(ShoppingCartWS.class);
        Endpoint.publish(shoppingCartUrl, shoppingCartWS);
        
        System.out.println(shoppingCartUrl);
        System.out.println(menuUrl);
    }

}
