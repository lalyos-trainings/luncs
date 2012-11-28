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
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing-csang.xml");

//        MenuWS menuWS = ctx.getBean(MenuWS.class);
        ShoppingCartWS sCWS = ctx.getBean(ShoppingCartWS.class);
        try {
            String localhost = InetAddress.getLocalHost().getHostAddress();
            String url = "http://" + localhost + ":8080/shoppingcart";
            System.out.println(url);
//            Endpoint.publish(url, menuWS);
            Endpoint.publish(url, sCWS);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
