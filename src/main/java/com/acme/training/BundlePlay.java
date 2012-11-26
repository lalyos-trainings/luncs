package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {
    public static void main(String[] args) {
        Locale hu = new Locale("hu");
        Locale ck = new Locale("hu", "ro");
//        ResourceBundle bundle = ResourceBundle.getBundle("luncs", hu);
        ResourceBundle bundle = ResourceBundle.getBundle("luncs");  //veszi a rendszerspecifikusat
//        ResourceBundle bundle = ResourceBundle.getBundle("luncs", Locale.GERMAN);
        String message = bundle.getString("welcome");
        System.out.println(message);   
    }

}
