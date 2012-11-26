package com.acme;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Locale german = Locale.GERMAN;
        Locale hun = new Locale("hu");
        Locale ck = new Locale("hu", "ro");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("luncs");
        String msg = resourceBundle.getString("welcome");
        System.out.println("msg: "+ msg);
    }

}
