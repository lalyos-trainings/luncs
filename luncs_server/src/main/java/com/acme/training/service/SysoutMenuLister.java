package com.acme.training.service;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;


@Component("menuLister")
public class SysoutMenuLister extends PrintWriterMenuLister {

    public SysoutMenuLister() {
        super(new PrintWriter(System.out, true));
    }
}
