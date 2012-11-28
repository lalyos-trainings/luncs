package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Locale germany = Locale.GERMANY;
        Locale hun = new Locale("hu");
        Locale ck = new Locale("hu", "ro");
        ResourceBundle bundle = ResourceBundle.getBundle("luncs");
        
        String msg = bundle.getString("welcome");
        System.out.println("msg: " + msg);

    }

}
