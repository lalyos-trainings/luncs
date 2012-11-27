package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        MenuWS ws = new MenuWS();

        InetAddress localhost = InetAddress.getLocalHost();
        String address = "http://" + localhost.getHostAddress() + ":8080/menu";
        System.out.println(address);
        Endpoint.publish(address, ws);
    }

}
