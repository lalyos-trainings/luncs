package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml",
                "orders.xml");

        ShoppingCartWS ws = appContext.getBean(ShoppingCartWS.class);

        InetAddress localhost = InetAddress.getLocalHost();
        String addrCart = "http://" + localhost.getHostAddress() + ":8080/cart";
        System.out.println(addrCart);
        Endpoint.publish(addrCart, ws);

        MenuWS menuWs = appContext.getBean(MenuWS.class);

        String addrMenu = "http://" + localhost.getHostAddress() + ":8080/menu";
        Endpoint.publish(addrMenu, menuWs);
    }

}
