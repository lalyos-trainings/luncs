package com.acme.training;

import java.net.InetAddress;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWebService;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    public static void main(String[] args) throws Exception {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");

        InetAddress localHost = InetAddress.getLocalHost();
        String host = localHost.getHostAddress();

        String menuUrl = "http://" + host + ":8081/menu";
        MenuWebService mWS = ctx.getBean(MenuWebService.class);
        Endpoint.publish(menuUrl, mWS);

        String shoppingCartUrl = "http://" + host + ":8081/shoppingcart";
        ShoppingCartWS sCWS = ctx.getBean(ShoppingCartWS.class);
        Endpoint.publish(shoppingCartUrl, sCWS);
        
        System.out.println(shoppingCartUrl);
        System.out.println(menuUrl);
    }
}
