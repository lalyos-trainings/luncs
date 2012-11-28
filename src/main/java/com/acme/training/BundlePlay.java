package com.acme.training;

import java.util.ResourceBundle;

public class BundlePlay {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("luncs");
        
        String msg = bundle.getString("welcome");
        System.out.println("msg: " + msg);

    }

}
