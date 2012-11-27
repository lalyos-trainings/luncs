package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"/*, "kfc.xml", "csing-csang.xml"*/);

        MenuWS menuWS = ctx.getBean(MenuWS.class);
        try {
            String localhost = InetAddress.getLocalHost().getHostAddress();
            String url = "http://" + localhost + ":8080/menu";
            System.out.println(url);
            Endpoint.publish(url, menuWS);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
