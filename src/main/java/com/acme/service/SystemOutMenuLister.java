package com.acme.service;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

@Component
public class SystemOutMenuLister extends PrintWriterMenuLister {
    
   public SystemOutMenuLister(){
       super(new PrintWriter(System.out, true));
   }
}
