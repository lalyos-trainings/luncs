package com.acme.training.lister;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;



@Component
public class SysoutMenuLister extends PrintWriterMenuLister {

    public SysoutMenuLister() {
        super(new PrintWriter(System.out));
    }
}
