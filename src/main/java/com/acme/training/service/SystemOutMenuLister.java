package com.acme.training.service;

import java.io.PrintWriter;

public class SystemOutMenuLister extends PrintWriterMenuLister {

    public SystemOutMenuLister() {
        super(new PrintWriter(System.out));
    }

}
