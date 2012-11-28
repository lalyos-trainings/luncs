package com.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.ws.MenuWS;
import com.acme.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "ching.xml");
        
        MenuWS menuWS = ctx.getBean(MenuWS.class);
        InetAddress localHost = InetAddress.getLocalHost();
        Endpoint.publish("http://"+localHost.getHostAddress()+":8080/menu", menuWS );
        
        ShoppingCartWS scWS = ctx.getBean(ShoppingCartWS.class);
        Endpoint.publish("http://localhost:8080/shoppingcart", scWS);
    }

}
