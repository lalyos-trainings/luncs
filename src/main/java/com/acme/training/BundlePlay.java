package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay 
{
    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        Locale germany = Locale.GERMANY;
        Locale hungary = new Locale("hu", "HU");
        Locale ck = new Locale("hu", "RO");
        
        ResourceBundle bundle = ResourceBundle.getBundle("luncs");
        String message = bundle.getString("welcome");
        System.out.println("message: " + message);
    }

}
