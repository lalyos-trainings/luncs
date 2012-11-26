package com.acme.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePlay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale german = Locale.GERMAN;
		Locale hun = new Locale("hu");
		ResourceBundle rb = ResourceBundle.getBundle("luncs", hun);
		String msg = rb.getString("welcome");
		System.out.println(msg);
	}

}
