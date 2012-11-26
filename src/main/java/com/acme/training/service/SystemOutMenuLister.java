package com.acme.training.service;

import java.io.PrintWriter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SystemOutMenuLister extends PrintWriterMenuLister {

    public SystemOutMenuLister() {
        super(new PrintWriter(System.out));
    }

}
