package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {

    public static void main(String[] args) {
        Locale ck = new Locale("hu_RO");
        ResourceBundle myResBundle = ResourceBundle.getBundle("luncs", ck);
        System.out.println(myResBundle.getString("welcome"));
    }

}
