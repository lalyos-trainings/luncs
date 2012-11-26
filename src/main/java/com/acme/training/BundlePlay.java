package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Locale hun = new Locale("hu");
        Locale sekler = new Locale("hu", "ro");
        ResourceBundle bunde = ResourceBundle.getBundle("luncs", sekler);
        System.out.println(bunde.getString("welcome"));

    }

}
