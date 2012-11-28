package com.acme.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.TestRepo;

public class NewMain {
    
    @Autowired
  //  private TestRepo testRepo;
    
    public static void main(String[] args) {
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        
        

    }

}
