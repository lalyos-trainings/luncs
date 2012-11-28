package com.acme.training;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        //MenuWS menuWS = ctx.getBean(MenuWS.class);
        
        ShoppingCartWS cartWS = ctx.getBean(ShoppingCartWS.class); 
        
        Endpoint.publish("http://localhost:8080/cart", cartWS);

    }

}
