package com.acme.training.ws;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        MenuWS menuService=ctx.getBean(MenuWS.class);
        String menuServiceUrl="http://"+InetAddress.getLocalHost().getHostAddress()+":8080/menu";
        Endpoint.publish(menuServiceUrl, menuService);


    }

}
