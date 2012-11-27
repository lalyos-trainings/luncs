package com.acme.training;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWebService;

public class WebServiceBootStrap {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "csing-csang.xml", "kfc.xml");
        MenuWebService mWS = ctx.getBean(MenuWebService.class);
        Endpoint.publish("http://localhost:8082/menu", mWS);
        
    }
}
