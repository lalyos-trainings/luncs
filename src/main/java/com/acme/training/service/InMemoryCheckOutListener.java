package com.acme.training.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCheckOutListener implements ApplicationListener<CheckOutEvent> {

	public void onApplicationEvent(CheckOutEvent event) {
		System.out.println("checkout!!!" + event.getTimeStamp());
	}

	
}
