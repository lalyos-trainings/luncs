package com.acme.training;

import javax.xml.ws.Endpoint;

import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        MenuWS menuWS = new MenuWS();
        Endpoint.publish("http://localhost:8081/menu", menuWS);
    }

}
